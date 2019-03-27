package org.medex.dao;

import org.medex.beans.User;

public interface LoginDao {
	User selectUser(User u);

}