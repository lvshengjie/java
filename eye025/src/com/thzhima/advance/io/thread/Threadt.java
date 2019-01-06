package com.thzhima.advance.io.thread;

public class Threadt {
	
	public static void main(String[] args) {
		
		ThreadGroup gp=new ThreadGroup("gp");
		
		Thread t=new Thread(gp,new MyRun(),"你好");
		t.start();
	}
}

class MyRun implements Runnable{

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getThreadGroup().getName()
				+"---------"+Thread.currentThread().getName());
		
	}
	
}
