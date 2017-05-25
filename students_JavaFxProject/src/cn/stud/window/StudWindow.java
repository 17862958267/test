package cn.stud.window;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import cn.stud.db.DataBase;
import cn.stud.domain.Stud;
import cn.stud.domain.User;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import sun.applet.Main;

public class StudWindow {
	TableView<Stud> tv = new TableView<>();

	public StudWindow(Stage stage) {
		stage.setTitle("学生信息列表");
		VBox vBox = new VBox(10);
		// 声明表头
		TableColumn<Stud, String> tc1 = new TableColumn<>("姓名");
		tc1.setCellValueFactory(new PropertyValueFactory<Stud, String>("name"));
		tv.getColumns().add(tc1);

		TableColumn<Stud, String> tc2 = new TableColumn<>("性别");
		tc2.setCellValueFactory(new PropertyValueFactory<Stud, String>("sex"));
		tv.getColumns().add(tc2);

		TableColumn<Stud, String> tc3 = new TableColumn<>("年龄");
		tc3.setCellValueFactory(new PropertyValueFactory<Stud, String>("age"));
		tv.getColumns().add(tc3);

		vBox.getChildren().add(tv);

		// --10:查询所有学生
		queryStuds();
		// 声明按扭

		HBox hbox = new HBox(10);
		hbox.setPadding(new Insets(10));
		hbox.setAlignment(Pos.CENTER);

		/// 添加分页页面
		Pagination pp = new Pagination();
		vBox.getChildren().add(pp);

		Button btnAdd = new Button("增加");
		Button btnDel = new Button("删除");
		Button btnUpdate = new Button("修改");
		Button btnQuery = new Button("查询");
		Button btnExport = new Button("导出Excel");

		hbox.getChildren().addAll(btnAdd, btnDel, btnUpdate, btnQuery, btnExport);
		vBox.getChildren().add(hbox);
		Scene sc = new Scene(vBox, 500, 300);
		stage.setScene(sc);
		stage.show();

		// 添加事件
		btnAdd.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				new AddStudDialog(new Back() {
					@Override
					public void sendBack(Stud stud) {
						// --11：先保存学生
						DataBase.getInstace().saveStud(stud);
						// 再保存界面
						tv.getItems().add(stud);
					}

				});
			}
		});
		// 删除事件
		btnDel.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.err.println("可以工作..");
				int index = tv.getSelectionModel().getSelectedIndex();
				if (index == -1) {
					Alert alert = new Alert(AlertType.WARNING, "请选择要删除的行!", ButtonType.YES);
					alert.show();
				} else {
					Alert alert = new Alert(AlertType.CONFIRMATION, "确定要删除这一行记录吗？", ButtonType.YES, ButtonType.NO);
					Optional<ButtonType> opt = alert.showAndWait();
					if (opt.get() == ButtonType.YES) {
						// --12:先删除后台
						// 获取当前选择的Stud对象
						Stud stud = tv.getItems().get(index);
						DataBase.getInstace().removeStud(stud);
						// 再删除界面
						tv.getItems().remove(index);
					}
				}
			}
		});

		// 添加修改事件
		btnUpdate.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				int index = tv.getSelectionModel().getSelectedIndex();
				if (index == -1) {
					Alert alert = new Alert(AlertType.WARNING, "请选择要修改的行!", ButtonType.YES);
					alert.show();
				} else {
					// 获取当前选择的行的Stud对象
					Stud stud = tv.getItems().get(index);
					new UpdateStudDialog(new Back() {
						@Override
						public void sendBack(Stud stud) {
							DataBase.getInstace().update(index, stud);
							tv.getItems().set(index, stud);
						}

					}, stud);
				}
			}

		});
//查询事件
		btnQuery.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				new QueryStudDialog(new QueryBack() {

					@Override
					public void sendBack(List<Stud> list) {
						// 设置显示的数据
						tv.getItems().clear();
						// 添加新的数据
						for (Stud stud : list) {
							tv.getItems().add(stud);
						}
					}
				});
			}
		});

		// 导入
		btnExport.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				// 显示一个对话框
				FileChooser fc = new FileChooser();
				File file = fc.showSaveDialog(stage);
				if (file != null) {
					// System.err.println("你要保存到:"+file.getAbsolutePath());
					// 开始导出
					export(file, tv.getItems());
				}
			}
		});
	}

	// --9:去查询目前有多少学生
	public void queryStuds() {
		List<Stud> list = DataBase.getInstace().queryStuds();
		// 添加到TableView中去
		for (Stud stud : list) {
			tv.getItems().add(stud);
		}
	}

	// 声明一个接口
	public interface Back {
		public void sendBack(Stud stud);
	}

	public interface QueryBack {
		public void sendBack(List<Stud> list);
	}

	// 导出
	private void export(File file, ObservableList<Stud> items) {
		HSSFWorkbook book = new HSSFWorkbook();
		HSSFSheet sheet = book.createSheet("学生表");
		HSSFRow row = sheet.createRow(0);//表格的第0列
		HSSFCell cel = row.createCell(0);
		cel.setCellValue("姓名");
		HSSFRow row1 = sheet.createRow(1);//表格的第1列
		HSSFCell cel1 = row.createCell(1);
		cel1.setCellValue("年龄");
		HSSFRow row2 = sheet.createRow(2);//表格的第2列
		HSSFCell cel2 = row.createCell(2);
		cel2.setCellValue("性别");
		int index = 1;
		for (Stud ss : items) {
			row = sheet.createRow(index++);
			cel = row.createCell(0);
			cel.setCellValue(ss.getName());
			cel1 = row.createCell(1);
			cel1.setCellValue(ss.getAge());
			cel2 = row.createCell(2);
			cel2.setCellValue(ss.getSex());
			
			}
	
		
		
		try {
			book.write(file);
			book.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

	}
}
