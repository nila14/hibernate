package org.medex.service;

import org.medex.beans.User;
import org.medex.dao.LoginDao;
import org.medex.dao.LoginDaoImpl;

public class LoginServiceImpl implements LoginService {

	LoginDao log_dao = new LoginDaoImpl();
	@Override
	public User validateUser(User u) {
		User res_user = log_dao.selectUser(u);
		
		return res_user;
	}

}