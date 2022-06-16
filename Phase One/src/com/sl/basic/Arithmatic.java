package com.sl.basic;

import java.util.Scanner;

public class Arithmatic {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Number 1");
		float v1 = sc.nextFloat();
		System.out.println("Enter Number 2");
		float v2 = sc.nextFloat();
		
		float res = 0.0f;
		
		System.out.println("Enter Operator + - / x as 1 2 3 4 :");
		
		int op = sc.nextInt();
		
		if(op == 1) {
			res = v1 + v2;
		} else if (op == 2) {
			res = v1 - v2;
		}else if (op == 3) {
			res = v1 / v2;
		}else if (op == 4) {
			res = v1 * v2;
		}
		
		System.out.println("Res : " + res);
	}

}
