package org.cts.dao;

import org.cts.Emp;

public interface EmpDao {
	
	int insert(Emp e);
	int delete(int eno);
	int update(int eno,String newName);
	Emp get(int eno);

}
