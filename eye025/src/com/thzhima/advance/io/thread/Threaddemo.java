package com.thzhima.advance.io.thread;

import java.awt.Toolkit;

public class Threaddemo {
	public static void main(String[] args) throws InterruptedException {

		Thread curr = Thread.currentThread(); 
		System.out.println(curr.getName());
		
		Thread t = new MyTask();
		t.start();

		
		System.out.println("================over----------------");

		for(int i=0;i<50;i++) {
			Toolkit.getDefaultToolkit().beep();
			Thread.sleep(10);
		}
		
	
		
	}
}

class MyTask extends Thread{

	@Override
	public void run() {
		for(int i=0; i<1000; i++) {
			System.out.println("---------"+Thread.currentThread().getName());
		}
	}

	}

