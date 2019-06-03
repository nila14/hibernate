package org.cts.dao;

import java.util.List;


import org.cts.Emp;
import org.cts.util.HibUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class EmpDaoImpl implements EmpDao {
	Session session=HibUtil.getSession();
	@Override
	public int insert(Emp e) {
		Transaction transaction=session.beginTransaction();
		Integer eno=(Integer)session.save(e);
		transaction.commit();
		return eno;
	}

	@Override
	public Emp get(int eno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Emp> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateName(int eno, String newName) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int eno) {
		// TODO Auto-generated method stub

	}

}
