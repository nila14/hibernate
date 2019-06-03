package org.cts.test;

import org.cts.Emp;
import org.cts.dao.EmpDaoImpl;

public class Test {

	public static void main(String[] args) {
		EmpDaoImpl dao=new EmpDaoImpl();
		int eno=dao.insert(new Emp(2, "suresh", "chennai"));
		System.out.println("the employee with "+eno+" inserted");
		
	}

}
