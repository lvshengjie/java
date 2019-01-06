package com.thzhima.advance.io.standara;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;



public class Chat {
	
	public static void start() throws IOException {
		InputStreamReader inReader=new InputStreamReader(System.in);
		BufferedReader reader=new BufferedReader(inReader);
		
		try {
			for(;;) {
				String str=reader.readLine();
				if(":exit".equals(str)) {
					break;
				}else {
					sendMsg(str);
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(null!=reader) {
				reader.close();
			}
			if(null!=inReader) {
				inReader.close();
			}
		}
	}
	public static void sendMsg(String msg) throws IOException{
		Socket s=new Socket();
		SocketAddress address=new InetSocketAddress("192.168.43.78", 8088);
		OutputStream out=null;
		OutputStreamWriter outWriter=null;
		
		try {
			s.connect(address);
			out=s.getOutputStream();
			outWriter=new OutputStreamWriter(out, "utf-8");
			
			outWriter.write(msg+"\n");
			outWriter.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			outWriter.close();
			out.close();
			s.close();
		}
	}
	


	public static void main(String[] args) throws IOException {

		 
//		InputStream in=System.in;
//		InputStreamReader inReader=null;
//		inReader =new InputStreamReader(in);
//		BufferedReader reader=new BufferedReader(inReader);
//		
//		char[] cbuf=new char[10];
//		String str="";
//		
//		while(true) {
//			str =reader.readLine();
//			System.out.println(str);
//			
//			if(":exit".equals(str)) {
//				break;
//			}
//		}
//		if(null!=inReader) {
//			inReader.close();
//		}
		
		
		Chat.start();
		
		
	} 
}
class P extends Thread{
	 private  Socket s;
	 P(Socket s){
		 this.s=s;
	 }
	 
	 public void run() {
		 InputStream in=null;
		 InputStreamReader inReader=null;
		 BufferedReader reader=null;
		 
		 
		 try {
			in=this.s.getInputStream();
			inReader=new InputStreamReader(in);
			reader=new BufferedReader(inReader);
			String msg=reader.readLine();
			System.out.println(msg);
			if(null!=reader) {
				reader.close();
			}
			if(null!=inReader) {
				inReader.close();
			}
			if(null!=in) {
				in.close();
			}
			if(null!=s) {
				s.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
		}
	 }
}
