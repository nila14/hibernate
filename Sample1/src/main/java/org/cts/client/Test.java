package org.cts.client;

import org.cts.Emp;
import org.cts.config.MyConfig;
import org.cts.service.EmpServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {

		ApplicationContext context=new AnnotationConfigApplicationContext(MyConfig.class);
		EmpServiceImpl service=context.getBean(EmpServiceImpl.class,"service");
		int i=service.insert(new Emp(9, "ram", "chennai"));
		System.out.println(i+" records inserted");
	}

}
