package com.practice.SpringDemo;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class App {
	public static void main(String[] args) {
		// First Way to read beans
		Resource resource = new ClassPathResource("beans.xml");
		BeanFactory beanfactory = new XmlBeanFactory(resource);

		TestBean tb = (TestBean) beanfactory.getBean("hello");
		tb.printHello();

		// Second Way to read beans
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

		Student st = (Student) context.getBean("std");
		System.out.println("\nID   : " + st.getId());
		System.out.println("NAME : " + st.getName());

		Marks m = st.getMarks();
		System.out.println("\nPHY  : " + m.getPhy());
		System.out.println("CHEM : " + m.getChem());
		System.out.println("MATH : " + m.getMaths());
	}
}
