package com.sl.basic;

import java.util.Scanner;

public class LIS {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("How much values you want to enter : ");
		int nos = sc.nextInt();
		int [] values = new int[nos];
		
		System.out.println("Enter Values Now..");
		int counter = 0;
		while(counter < nos) {
			values[counter] = sc.nextInt();
			counter++;
		}
		System.out.println("Generating Result..");
		int lis = 0;
		for(int i = 0; i< values.length;i++){
			int count = 1;
			int base = values[i];
			for(int j = (i+1); j< values.length; j++){
		    	if(values[j] > base){
		        	base = values[j];
		        	count++;
		    	}
			}
			if(count > lis){
		    	lis = count;
			}
			System.out.println(values[i] + " : " + count);
		}
		System.out.println("\nMAX LIS IS : " + lis);
	}

}
