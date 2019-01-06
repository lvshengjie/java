package com.thzhima.advance.io.thread.sleep.wn;

import java.util.ArrayList;
import java.util.List;

import com.thzhima.advance.io.thread.work.Ticketmp;



public class Product {
	
	static int count=0;
	public static void main(String[] args) {
		List<Ticketmp> list=new ArrayList<>();
		
		Thread t=new Thread() {
			public void run() {
				try {
					for(int i=0;i<3;i++){
						synchronized (list) {
							while(list.size()<10) {
								count+=1;
								System.out.println("生产：" + count);
								Ticketmp t = new Ticketmp(count);
								list.add(t);
								Thread.sleep(1000);
							}
							list.notifyAll();
							list.wait();
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
};

Thread t2 = new Thread() {
	public void run() {
		try {
			for(int i=0;i<3;i++){
				synchronized (list) {
					while(list.size()>0) {
						int idx = list.size()-1;
						Ticketmp t = list.get(idx);
						list.remove(idx);
						System.out.println("取出了:" + t.id);
						Thread.sleep(1000);
					}
					list.notify();
					list.wait();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
};

t.start();
t2.start();
}
}
