package org.cts.service;

import org.cts.Emp;

public interface EmpService {
	int insert(Emp e);
	int delete(int eno);
	int update(int eno,String newName);
	Emp get(int eno);

}
