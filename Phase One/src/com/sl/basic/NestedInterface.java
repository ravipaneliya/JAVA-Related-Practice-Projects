package com.sl.basic;

public class NestedInterface implements B1{

	@Override
	public void print() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void read() {
		// TODO Auto-generated method stub
		
	}

}

interface A1{
	void print();
}

interface B1 extends A1{
	void read();
}