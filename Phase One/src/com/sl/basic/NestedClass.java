package com.sl.basic;

public class NestedClass extends B{
	
	public NestedClass() {
		super();
		System.out.println("NestedClass called...");
	}

	public static void main(String[] args) {
		new NestedClass();

	}

}

class A{
	A(){
		System.out.println("A called...");
	}
}

class B extends A {
	B(){
		System.out.println("B called...");
	}
}