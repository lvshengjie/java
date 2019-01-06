package com.thzhima.File;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class file {
	
	public static void write(String data,String fileName,String charset ) throws IOException {
		FileOutputStream fout=null;
		OutputStreamWriter outwriter=null;
		BufferedWriter writer=null;
		
		try {
			fout=new FileOutputStream(fileName);
			outwriter=new OutputStreamWriter(fout, charset);
			writer=new BufferedWriter(outwriter);
			
			writer.write(data);
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(null !=writer) {
				writer.close();
				
			}
		
			if(null!=outwriter) {
				outwriter.close();
			}
			
			if(null !=fout) {
				fout.close();
			}
			
		}
	}
	
	public static String readTxt(String fileName,String charest) throws IOException {
		String data="";
		FileInputStream fin= null;
		InputStreamReader inRead=null;
		BufferedReader reader=null;
		
		try {
			fin=new FileInputStream(fileName);
			inRead=new InputStreamReader(fin,charest);
			reader=new BufferedReader(inRead);
			String s=null;
			while(null!=(s=reader.readLine())) {
				data+=s;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(null!=reader) {
				reader.close();
			}
			if(null!=inRead) {
				inRead.close();
			}
			
			if(null!=fin) {
				fin.close();
			}
		}
		
		return data;
		}
	
	

//	public static void write(String data, String fileName) throws IOException {
//		FileWriter writer = null;
//		File f = new File(fileName);
//		File p = f.getParentFile();
//		if(! p.exists()) {
//			p.mkdirs();
//		}
//
//		try {
//			writer = new FileWriter(f);
//			writer.write(data);
//		} catch (IOException e) {
//			e.printStackTrace();
//		} finally {
//			if(null != writer) {
//				writer.close();
//			}
//		}
//	}
//	
//	public static String readTxt(String name) throws IOException {
//		String data = "";
//		FileReader reader = null;
//		
//		try {
//			reader = new FileReader(name);
//			char[] buffer = new char[13];
//			int count = -1;
//			while(-1 !=(count=reader.read(buffer))) {
//				String s = new String(buffer, 0, count);
//				data += s;
//			}
//			
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} finally {
//			if(null != reader) {
//				reader.close();
//			}
//		}
//		
//		
//		return data;
//}
	

	
	//==========================================================================	
	public static void wirte(byte[]data, String fileName) throws IOException{
		FileOutputStream out=null;
		
		try {
			File f=new File(fileName);
			if(!f.exists()) {
				
				File dir=f.getParentFile();
				if(! dir.exists()) {
					System.out.println("-------------创建父目录------------");
					dir.mkdirs();
	
				}
				f.createNewFile();
				System.out.println("=============创建子目录==========");	
			}
			
			out=new FileOutputStream(fileName,true);
			out.write(data);
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(null != out) {
				out.close();
				}
		}
			
	}
	
	public static byte[] read(String fileName) throws IOException{
		byte[] b=null;
		File f=new File(fileName);
		FileInputStream in=null;
		
		try {
			in=new FileInputStream(f);
			b= new byte[in.available()];
			in.read(b);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(null != in) {
				in.close();
               }
		}
		
		return b;
	}
	
	public static void copy(String y,String m) throws IOException{
		byte[] c=new byte[1048576];
		FileInputStream in=null;
		FileOutputStream out=null;
		
		try {
			in=new FileInputStream(y);
			File x=new File(m);
			File p=x.getParentFile();
			if(!p.exists()) {
				p.mkdirs();
			}
			out=new FileOutputStream(x);
			
			int count=-1;
			while(-1!=(count=in.read(c))) {
				out.write(c, 0, count);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			if(null != in) {
				in.close();
               }
			if(null != out) {
				in.close();
               }
			
		}
	}
	
	
	

	public static void main(String[] args) throws IOException, InterruptedException {
//		String fileName = "/home/lvshengjie/tmp/a.txt";
//		byte[] data = "h".getBytes();
//		
//		wirte(data, fileName);
//		
//		
//		byte[] d = read(fileName);
//		String str = new String(d);
//		System.out.println(str);
//		 copy("/home/lvshengjie/音乐/1.opus","/home/lvshengjie/音乐/2.opus");
		
		write("大家好，这里是java学习课堂。欢迎大家来学习Java Web 应用程序开发课程。", "/home/lvshengjie/tmp/aa.txt","utf-8");
		String s = readTxt("/home/lvshengjie/tmp/aa.txt","utf-8");
		System.out.println(s);
		
		
}
	
}
