package org.medex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.medex.beans.BookAppointment;
import org.medex.util.DBConstants;
import org.medex.util.DBUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository("employeeDao")
public class BookAppointmentDaoImpl implements BookAppointmentDao {

	@Autowired
	 private SessionFactory sessionFactory;
	public boolean showavailableDoctor(BookAppointment ba) {
		/*try{
		con =(Connection) DBUtil.getConnection(DBConstants.DRIVER, DBConstants.URL,
                DBConstants.UNAME, DBConstants.PWD);
						
						pst = con.prepareStatement("insert into appointment (pat_id,doc_id,date_of_app,time_of_app,date_time_booked) values(?,?,?,?,?)");
						
						pst.setString(1, ba.getId());
						pst.setString(2, ba.getDoctorid());
						pst.setString(3, ba.getDate_of_app());
						pst.setString(4, ba.getTimeslot());
						pst.setString(5, ba.getTime_of_app());
						r1=pst.executeUpdate();
						con.close();
                        
                      }
	catch (Exception e2) {
                    e2.printStackTrace();
    }
    if(r1>0 )
    {
                    return true;
    }
    else{
                    return false;
    }
    
*/
		SQLQuery<BookAppointment> bookInsert=sessionFactory.getCurrentSession().createSQLQuery("insert into appointment (pat_id,doc_id,date_of_app,time_of_app,date_time_booked) values(?,?,?,?,?)");
		bookInsert.addEntity(BookAppointment.class);
		int r1=bookInsert.executeUpdate();
		if(r1>0 )
	    {
	                    return true;
	    }
	    else{
	                    return false;
	    }
	}

}
