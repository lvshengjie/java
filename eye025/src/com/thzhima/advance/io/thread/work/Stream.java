package com.thzhima.advance.io.thread.work;

import java.util.Arrays;

public class Stream {
		static Ticketmp[] tks=null;
		static int count=50;
		
		static {
			tks=new Ticketmp[50];
			for(int i=1;i<=50;i++) {
				tks[i-1] =new Ticketmp(i);
			}
		}
		
		public static synchronized Ticketmp[] buy(int s) {
			Ticketmp[] ts=null;
			
			try {
				int c =s<count? s:count;
				ts =new Ticketmp[c];
				Thread.sleep(110);
				System.arraycopy(tks, count-c, ts, 0, c);
				Thread.sleep(100);
				count-=c;
				Thread.sleep(100);
				Arrays.fill(tks, count,count+c,null);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			return ts;
			
		}
		public static void main(String[] args) throws InterruptedException {
			Runnable r=new Runnable() {

				@Override
				public void run() {
					Ticketmp[] b = Stream.buy(16);
					System.out.println(b.length);
				}
				
			};
			Thread t = new Thread(r);
			Thread t2 = new Thread(r);
			Thread t3 = new Thread(r);
			Thread t4 = new Thread(r);
			t.start();
			t2.start();
			t3.start();
			t4.start();
			t.join();
			t2.join();
			t3.join();
			t4.join();
		
		
		
		System.out.println("剩余："+Stream.count);
		
}
		}

