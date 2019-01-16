package com.thzhima.SimpleDate;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class SimpleDateFormatDemo {
		public static void main(String[] args) throws ParseException {
			SimpleDateFormat fint=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String str="2019-1-8 12:20:22";
			
			Date d= (Date) fint.parse(str);//类型转换
			
			
			System.out.println(d);
			
			String strDate=fint.format(d);//格式化
			System.out.println(strDate);
		}
}
