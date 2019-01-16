package com.thzhima.List;

import java.util.ArrayList;
import java.util.List;
 

public class list {
	public static void main(String[] args) {
		List<String> list=new ArrayList<String>(); //LinedList<>();vector();
			list.add("a");
			list.add("b");
			System.out.println(list.size());
			list.remove(0);
			System.out.println(list.get(0));
		
	}
}
