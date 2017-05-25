package cn.test;

import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;

import cn.stud.db.DataBase;
import cn.stud.domain.Stud;

public class Demo01 {
	@Test
	public void testt() {
		Stud stud = new Stud();
		stud.setName("赵");
		stud.setSex("男");
		stud.setAge2(20);
		List<Stud> ss = DataBase.getInstace().queryWithStud(stud);
		System.err.println(">>>>>>>>>>>:" + ss);

	}

	@Test
	public void test1() throws Exception {
		HSSFWorkbook wb = new HSSFWorkbook();
		FileOutputStream fileOut = new FileOutputStream("d:/a/a.xls");
		
		HSSFSheet sheet = wb.createSheet("第一个sheet");
		HSSFRow row = sheet.createRow(0);
		HSSFCell cel = row.createCell(0);
		cel.setCellValue("你好");
		
		
		wb.write(fileOut);
		fileOut.close();
		wb.close();
	}
}
