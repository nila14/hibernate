package org.medex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ListIterator;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.medex.beans.User;
import org.medex.util.DBConstants;
import org.medex.util.DBUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sun.glass.ui.Size;


@Repository("LoginDao")
public class LoginDaoImpl implements LoginDao {
	
	@Autowired
	 private SessionFactory sessionFactory;

	@Override
	public User selectUser(User u) {
		String name = "";
		
	    String role = "";
	    User res = new User();
		/*String name = "";
		String role = "";
		Connection con = null;
		PreparedStatement pst1 = null, pst2 = null;
		ResultSet rs1 = null, rs2 = null;
		User res = new User();

		try {
			con = DBUtil.getConnection(DBConstants.DRIVER, DBConstants.URL,
					DBConstants.UNAME, DBConstants.PWD);
			pst1 = (PreparedStatement) con
					.prepareStatement("select role from user where id=? and pwd=?");
			pst1.setString(1, u.getId());
			pst1.setString(2, u.getPwd());
			rs1 = pst1.executeQuery();
			if (rs1.next()) {
				role = rs1.getString(1);
				if (role.contentEquals("patient")) {
					pst2 = (PreparedStatement) con
							.prepareStatement("select fname,lname from patient where pid=?");
					pst2.setString(1, u.getId());
					rs2 = pst2.executeQuery();
					if (rs2.next()) {
						name = rs2.getString(1) + " " + rs2.getString(2);

						res.setName(name);
						res.setRole(role);
					}
					rs2.close();
					pst2.close();
				} else if (role.contentEquals("doctor")) {
					pst2 = (PreparedStatement) con
							.prepareStatement("select fname,lname from doctor where did=?");
					pst2.setString(1, u.getId());
					rs2 = pst2.executeQuery();
					if (rs2.next()) {
						name = rs2.getString(1) + " " + rs2.getString(2);

						res.setName(name);
						res.setRole(role);
					}
					rs2.close();
					pst2.close();
				}

			}
			else
			{
				res=null;
			}
			rs1.close();
			pst1.close();

			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;*/
		SQLQuery<User> userSelect=sessionFactory.getCurrentSession().createSQLQuery("select role from user where id=? and pwd=?");
		
		userSelect.addEntity(User.class);
		//List<User> userList=userSelect.list();
		userSelect.setString(1, u.getId());
		userSelect.setString(2, u.getPwd());
		List<User> userList=userSelect.list();
		//ListIterator<User> it = userList.listIterator();
		if(userList.size()>0)
		{
			
		    role = userList.get(0).getRole();
			if (role.contentEquals("patient")) {
				
				SQLQuery<User> userSelect1=sessionFactory.getCurrentSession().createSQLQuery("select fname,lname from patient where pid=?");
				userSelect1.setString(1, u.getId());
				List<User> userList1=userSelect1.list();
				if(userList1.size()>0)
				{
					name = userList1.get(0) + " " + userList1.get(1);

					res.setName(name);
					res.setRole(role);
				}
				
				
			}
			else if(role.contentEquals("doctor"))
			{
				SQLQuery<User> userSelect1=sessionFactory.getCurrentSession().createSQLQuery("select fname,lname from doctor where did=?");
				userSelect1.setString(1, u.getId());
				List<User> userList1=userSelect1.list();
				if(userList1.size()>0)
				{
					name = userList1.get(0) + " " + userList1.get(1);

					res.setName(name);
					res.setRole(role);
				}
			}
			
		}
		else
		{
			res=null;
		}
		return res;

	}

}