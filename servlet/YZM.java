package com.guigu.crm.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class YZM extends HttpServlet {
	
	//����ֵ�
	public static final char [] chars = {'2','3','4','5','6','7','8','9','0',
		'a','b','c','d','e','f','g','h','j','k','m','n','o','p','q','r','s','t','u','v','w','x','y','z',
		'A','B','C','D','E','F','G','H','G','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
	
	//���������
	public static Random random = new Random();
	
	//��������
	public static String getRandomString(){
		StringBuffer buffer = new StringBuffer();
		for(int i=0;i<4;i++){
			buffer.append(chars[random.nextInt(chars.length)]);
		}
		return buffer.toString();
	}
	
	//����������ɫ
	public static Color getRandomColor(){
		return new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
	}
	
	//��÷�ɫ
	public static Color getReverColor(Color c){
		return new Color(255-c.getRed(), 255-c.getGreen(), 255-c.getBlue());
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		
		//�����������
		response.setContentType("image/jpg");
		
		//���������ַ���
		String randomString  = getRandomString();
		//��ñ���ɫ
		Color color = getRandomColor();
		//���������ɫ
		Color revColor = getReverColor(color);
		
		//����ͼƬ
		BufferedImage bi = new BufferedImage(100, 40, BufferedImage.TYPE_INT_RGB);
		//����ͼƬ��Ϣ
		Graphics g = bi.getGraphics();//����
		//���û��ʵ���ɫ
		g.setColor(color);
		g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 28));
		//���ñ���
		g.fillRect(0, 0, 100, 40);
		
		//�ı仭�ʵ���ɫ,��������
		g.setColor(revColor);
		g.drawString(randomString, 12, 29);
		
		//������
		for(int i =0; i<100;i++){
			g.drawRect(random.nextInt(100), random.nextInt(40), 1, 1);
		}
		
		//���ַ�������session
		request.getSession().setAttribute("yzm", randomString);
		
		//��ͼƬд��
		ImageIO.write(bi, "jpg", response.getOutputStream());
		

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		doGet(request, response);
	}

}
