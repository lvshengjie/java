package com.thzhima.advance.io.standara;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	public static void main(String[] args) throws IOException {
		ServerSocket ss=null;
		
		ss=new ServerSocket(8088);
		
		for(int i=0;i<10;i++) {
			Socket s=ss.accept();
			Thread t=new Pt(s);
			t.start();
		}
		ss.close();
		
	}
}

 class Pt extends Thread{
	 private  Socket s;
	 Pt(Socket s){
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
