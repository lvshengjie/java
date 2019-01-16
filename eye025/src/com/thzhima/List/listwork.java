package com.thzhima.List;

import java.util.ArrayList;
import java.util.List;

public class listwork {
		public static void main(String[] args) {
			
			List<Integer> list=new ArrayList<>();
			for(int i=1; i<=10; i++) {
				list.add(i);
			}
			List backup=(List) ((ArrayList)list).clone();
			int count=0;
			do {
				count++;
				
				int h=list.size()/2;
				List<Integer> a=new ArrayList();
				List<Integer> b=new ArrayList();
				
				
				//分开
				for(int i=0; i<list.size()/2; i++) {
					a.add(list.get(i));
				}
				for(int i=list.size()/2; i<list.size(); i++) {
					b.add(list.get(i));
				}
				System.out.println(a);
				System.out.println(b);
				
				list.clear();
				//合
				for(int i=0;i<h;i++) {
					list.add(a.get(i));
					list.add(b.get(i));
				}
				System.out.println(list);
				
			}while(!list.equals(backup));
			System.out.println(count);
			
			
			
		}
}
