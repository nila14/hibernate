package org.medex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import org.medex.beans.Feedback;
import org.medex.util.DBConstants;
import org.medex.util.DBUtil;

public class FeedbackDaoImpl implements FeedbackDao {

	Connection con = null;
	PreparedStatement pst = null;
	ResultSet rs =null;

	@Override
	public void feedbackFormRegister(Feedback f) {
		int r1 = 0;
	
		try {
			con = (Connection) DBUtil.getConnection(DBConstants.DRIVER,
					DBConstants.URL, DBConstants.UNAME, DBConstants.PWD);
			
			pst = con.prepareStatement("insert into feedbackform values(?,?,?,?)");
			pst.setString(1, f.getName());
			pst.setString(2, f.getEmail());
			pst.setString(3, f.getSubjectLine());
			pst.setString(4, f.getMsg());
			r1 = pst.executeUpdate();

			con.close();
		}
		catch (Exception e2) {
			e2.printStackTrace();
		}
		
}

	
	}
