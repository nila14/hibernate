package org.cts.service;

import org.cts.Emp;
import org.cts.dao.EmpDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class EmpServiceImpl implements EmpService {
	@Autowired
	EmpDao dao;
	
	public void setDao(EmpDao dao) {
		this.dao = dao;
	}

	@Override
	public int insert(Emp e) {
		int i=dao.insert(e);
		return i;
	}

	@Override
	public int delete(int eno) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(int eno, String newName) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Emp get(int eno) {
		// TODO Auto-generated method stub
		return null;
	}

}
