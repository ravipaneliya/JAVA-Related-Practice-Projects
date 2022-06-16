package com.sl.basic;

import java.util.Scanner;

public class EmailValidate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String emails[] = {"a@gmail.com","b@gmail.com","c@gmail.com","d@gmail.com"};
		Scanner sc = new Scanner(System.in);
		String email = sc.next();
		boolean found = false;
		for(String val : emails) {
			if(email.equalsIgnoreCase(val)) {
				found = true;
				break;
			}
		}
		
		if(found) {
			System.out.println("Found");
		} else {
			System.out.println("Not found");
		}
	}

}
