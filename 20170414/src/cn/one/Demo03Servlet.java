package cn.one;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Demo03Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 1:设置输出的格式
		response.setContentType("image/jpeg");
		// 2:创建内存中的图片
		int width = 60;
		int height = 30;
		BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		// 3:获取笔
		Graphics g = img.getGraphics();

		// 4:设置画布的background
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, width, height);
		// 5：设置字体
		g.setFont(new Font("宋体", Font.BOLD, 20));

		// 创建一个随机对象
		Random r = new Random();
		for (int i = 0; i < 4; i++) {
			int a = r.nextInt(10);
			g.setColor(new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256)));
			g.drawString("" + a, i * 15,10+(r.nextInt(20)));
		}
		for(int i=0;i<5;i++){
			g.setColor(new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256)));
			g.drawLine(r.nextInt(width),r.nextInt(height),r.nextInt(width),r.nextInt(height));
		}
		//让图片生效
		g.dispose();
		//输出图片
		ImageIO.write(img, "JPEG", response.getOutputStream());
	}
}