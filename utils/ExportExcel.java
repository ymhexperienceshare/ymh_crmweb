package com.guigu.crm.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;



public class ExportExcel<T> {
		
	public static void main(String[] args) {
		
		//
		//ProductService service=new ProductServiceImpl();
		
		//测试
		String title="导出Excel测试";
		String[] headers={"产品编号","产品名称","安全库存","上次采购日期",
				            "上次销售日期","数量","建议购买价","建议销售价"};
		//List<Product> productList=service.queryProduct();
		//
		try {
			FileOutputStream fos=new FileOutputStream(new File("H:/a.xls"));
			
			//ExportExcel<Product> ex=new ExportExcel<Product>();
			//ex.exportExcel(title, headers, productList, fos, "yyyy-mm-dd");
			
			fos.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
	/**
	 * 导出excel方法
	 * @param title       excel标题
	 * @param headers     字段名(列名)数组
	 * @param dataset     数据集合
	 * @param out         输出流
	 * @param pattern     日期模式
	 */
	@SuppressWarnings("deprecation")   //此注解有什么用?
	public void exportExcel(String title, String[] headers,
		Collection<T> dataset, OutputStream out, String pattern)
	{
		//创建工作簿
		HSSFWorkbook myBook=new HSSFWorkbook();      
	    //由工作簿创建一个表格，并传入标题
		HSSFSheet  mySheet=myBook.createSheet(title);
		//设置表格默认的列宽为15个字节
		mySheet.setDefaultColumnWidth(15);
		
		//由工作簿生成一个(单元格)样式,并自定义样式(用于显示列名称)
		HSSFCellStyle cellStyle=myBook.createCellStyle();
		cellStyle.setFillForegroundColor(HSSFColor.SKY_BLUE.index);
		cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
        cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
        cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		
		//由工作簿生成一个字体
        HSSFFont myFont=myBook.createFont();
        myFont.setColor(HSSFColor.VIOLET.index);
        myFont.setFontHeightInPoints((short)12);
        myFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		//将字体应用到当前的样式
        cellStyle.setFont(myFont);
		/*********************************/
        // 由工作簿生成另一种单元格样式（用于显示表格的数据值）
        HSSFCellStyle cellStyle2 = myBook.createCellStyle();
        cellStyle2.setFillForegroundColor(HSSFColor.LIGHT_YELLOW.index);
        cellStyle2.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        cellStyle2.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        cellStyle2.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        cellStyle2.setBorderRight(HSSFCellStyle.BORDER_THIN);
        cellStyle2.setBorderTop(HSSFCellStyle.BORDER_THIN);
        cellStyle2.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        cellStyle2.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        // 生成另一个字体
        HSSFFont myFont2 = myBook.createFont();
        myFont2.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
        // 把字体应用到当前的样式
        cellStyle2.setFont(myFont2);
		
        
        
        
        //由表格生成标题行
        HSSFRow rowTitle=mySheet.createRow(0);
        for(int i=0;i<headers.length;i++)
        {
        	//由行生成单元格
        	HSSFCell cell=rowTitle.createCell(i);
        	//将刚刚的样式应用到单元格
        	cell.setCellStyle(cellStyle);
        	//封装列名数组的各个元素
        	HSSFRichTextString text=new HSSFRichTextString(headers[i]);
        	//设定此单元格的值
        	cell.setCellValue(text);
        }
      //遍历集合中的每一个对象，产生数据行  
        Iterator<T> iter=dataset.iterator();
        int index=0;
        while(iter.hasNext())
        {
        	index++;
        	T t=(T)iter.next();  //本行对象
        	HSSFRow row=mySheet.createRow(index); //由表格产生数据行
        	
        	// 利用反射，根据javabean属性的先后顺序，动态调用getXxx()方法得到属性值
        	Field[] fields=t.getClass().getDeclaredFields();//应该是获得了t对象的所有属性?
        	//以下对t对象的每一个属性进行识别、获取
        	for(int i=0;i<fields.length;i++)
        	{
        		//数据行创建单元格，每一个属性值存储在一个单元格中
        		HSSFCell cell=row.createCell(i);
        		cell.setCellStyle(cellStyle2);  //设置单元格样式为样式二
        		Field field=fields[i]; //当前列字段
        		String fieldName=field.getName();  //获取当前字段名
        		//动态调用getXxx()方法获取属性值
        		String methodName="get"+
        		                   fieldName.substring(0, 1).toUpperCase()+
        		                   fieldName.substring(1);
        		try {
        			//动态调用getXxx()方法,获取当期字段的属性值
					Class tClas=t.getClass(); //t对象的类型
					Method getMethod=tClas.getMethod(methodName, new Class[]{});
					//该方法返回的结果是getXxx()返回的结果
					Object value=getMethod.invoke(t, new Object[]{});
				
					//根据该属性值得类型进行类型转换
					String textValue=null;
					//判断类型
					if(value instanceof Date)  //如果当前属性值类型为Date需要根据给定的格式转换
					{
						Date date=(Date)value;
						SimpleDateFormat format=new SimpleDateFormat(pattern);
						textValue=format.format(date);
					}
					else                      //当前属性值类型为其他类型，直接转换为字符串即可
					{
					    if(value!=null)
					    {
						  textValue=value.toString();
					    }
					    else
					    {
					        textValue="未定义";
					    }
					}
					
					/**************************/
					//准备将此单元格内容设定为该属性值
					if(textValue!=null)
					{
						Pattern p=Pattern.compile("^//d+(//.//d+)?$");  //设计到正则表达式的内容
						Matcher matcher=p.matcher(textValue);
						if(matcher.matches())
						{
							cell.setCellValue(Double.parseDouble(textValue));
						}
						else
						{
							//封装属性值
							HSSFRichTextString textString=new HSSFRichTextString(textValue);
							//由工作簿生成字体
							HSSFFont myFont3=myBook.createFont();
							myFont3.setColor(HSSFColor.BLUE.index);
							textString.applyFont(myFont3);//该字体应用到被封装的属性值
							cell.setCellValue(textString);
						}
					}
					
				} catch (NoSuchMethodException e) {
					e.printStackTrace();
				} catch (SecurityException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
        		
        	}
        
        }
       try {
    	   
		    myBook.write(out);    //导出excel
		
	} catch (IOException e) {
		e.printStackTrace();
	}
        
       		
	}

}
