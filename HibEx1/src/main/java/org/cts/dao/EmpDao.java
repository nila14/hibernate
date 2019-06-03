package org.cts.dao;

import java.util.List;

import org.cts.Emp;

public interface EmpDao {
	int insert(Emp e);
	Emp get(int eno);
	List<Emp> getAll();
	void updateName(int eno,String newName);
	void delete(int eno);

}
