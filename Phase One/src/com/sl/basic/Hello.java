package com.sl.basic;

import java.util.ArrayList;

public class Hello {

	public static void main(String[] args) {
		System.out.println("..................");
		ArrayList<Object> al = new ArrayList<Object>();
		
		al.add(123);
		al.add("asas");
		
		System.out.println("0 : " + al.get(0));
		System.out.println("1 : " + al.get(1));
		
		System.out.println(al);
	}

}
