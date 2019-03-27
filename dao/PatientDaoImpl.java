package org.medex.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.medex.beans.Display;
import org.medex.beans.Patient;
import org.medex.util.DBConstants;
import org.medex.util.DBUtil;

public class PatientDaoImpl implements PatientDao {

	Connection con = null;
	Statement st = null;
	PreparedStatement pst = null;
	ResultSet rs = null;

	public String insertRegistration(Patient p) {
        int c = 0,r1=0,r2=0;
        String role="patient";
        String pid=null;
        try {
                        con =(Connection) DBUtil.getConnection(DBConstants.DRIVER, DBConstants.URL,
                                                        DBConstants.UNAME, DBConstants.PWD);
                        pst = con.prepareStatement("select * from patient");
                        rs=pst.executeQuery();
                        while(rs.next())
                                        c=c+1;
                        pid="P"+c;
                        pst = con
                                                        .prepareStatement("insert into patient values(?,?,?,?,?,?,?,?,?,?)");
                        pst.setString(1, pid);
                        pst.setString(2, p.getFname());
                        pst.setString(3, p.getLname());
                        pst.setInt(4, p.getAge());
                        pst.setString(5, p.getGender());
                        pst.setString(6, p.getPhn_number());
                        pst.setString(7, p.getEmail());
                        pst.setString(8, p.getAddress());
                        pst.setInt(9, p.getZipcode());
                        pst.setString(10, p.getCity());
                        r1 = pst.executeUpdate();
                        pst = con.prepareStatement("insert into user values(?,?,?)");
                        pst.setString(1, pid);
                        pst.setString(2, p.getPwd());
                        pst.setString(3, role);
                        r2 = pst.executeUpdate();
                        con.close();
                        
                        

        } catch (Exception e2) {
                        e2.printStackTrace();
        }
        if(r1>0 && r2>0)
        {
                        return pid;
        }
        else{
                        return null;
        }
        

}

	
	public List<Display> viewAppointmentDetails(Display d)
	{
		List<Display> display=new ArrayList<>();
       
        ResultSet rs1=null;
       
        try {
               con=DBUtil.getConnection(DBConstants.DRIVER,DBConstants.URL,DBConstants.UNAME, DBConstants.PWD);
              
             String selectQuery="select * from appointment where date_of_app=? and pat_id=?";
            pst=con.prepareStatement(selectQuery);
   			pst.setString(1, d.getAppDate());
   			pst.setString(2, d.getPatId());
   			rs=pst.executeQuery();
   		
                                        while(rs.next())
                                        {
                                        	
                                        	 Display d1=new Display();
                                        	 String selectDoctor="select * from doctor where did=?";	                            
                                        	 pst=con.prepareStatement(selectDoctor);
                                        	 pst.setString(1, rs.getString("doc_id"));
                                        	 rs1=pst.executeQuery();
                                        	 if(rs1.next())
                                        	 {
                                        		 d1.setDocName(rs1.getString("fname"));
                                        		 d1.setDocCategory(rs1.getString("specialization"));
                                        	 }
                                        	 
                                        	   d1.setAppBookDate(rs.getString("date_time_booked"));
                                        	   d1.setAppDate(rs.getString("date_of_app"));
                                        	   d1.setTimeSlot(rs.getString("time_of_app"));
                                        	  
                                               display.add(d1);
                                              
                                        }
                                        con.close();
                        } 
                        catch (Exception e) 
                        {
                                        e.printStackTrace();
                        }
                        
                        return display;
        }


	@Override
	public List<Display> viewAppointment(Display d) {
		List<Display> display=new ArrayList<>();
		try
		{
			con=DBUtil.getConnection(DBConstants.DRIVER,DBConstants.URL,DBConstants.UNAME, DBConstants.PWD);
            
            String selectQuery="select t1.id,t1.date_of_app,t1.time_of_app,t1.date_time_booked,t2.fname,t2.lname,t2.specialization from appointment t1 join doctor t2 on t1.doc_id=t2.did  where t1.pat_id=?";
            pst=con.prepareStatement(selectQuery);
  			pst.setString(1, d.getPatId());
  			rs=pst.executeQuery();
  			while(rs.next())
            {
  				Display d1=new Display();
  				 d1.setDocName(rs.getString("fname")+" "+rs.getString("lname"));
        		 d1.setDocCategory(rs.getString("specialization"));
        		 d1.setAppDate(rs.getString("date_of_app"));
          	   d1.setTimeSlot(rs.getString("time_of_app"));
          	   d1.setAppBookDate(rs.getString("date_time_booked"));
          	   
          	 d1.setAppId(rs.getString("id"));
          	 display.add(d1);
  				
            }
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return display;
	}
	

	/*
	 * @Override public boolean insertAppointment(Appointment a) { boolean
	 * b=false; try { con=DBUtil.getConnection(DBConstants.DRIVER,
	 * DBConstants.URL, DBConstants.UNAME, DBConstants.PWD);
	 * pst=con.prepareStatement("insert into patient values(?,?,?,?)");
	 * pst.setString(1, a.getSpecialist_category()); pst.setString(2,
	 * a.getDate()); pst.setString(3, a.getTime()); pst.setString(4,
	 * a.getDoctor_name());
	 * 
	 * int r=pst.executeUpdate(); if(r>0) b=true; else b=false; con.close();
	 * 
	 * } catch (Exception e2) { e2.printStackTrace(); }
	 * 
	 * return b; }
	 * 
	 * @Override public Appointment selectAppointment(Appointment a) {
	 * 
	 * Appointment app= null; try { con =
	 * DBUtil.getConnection(DBConstants.DRIVER,
	 * DBConstants.URL,DBConstants.UNAME , DBConstants.PWD); pst =
	 * con.prepareStatement("select * from patient where date = ?");
	 * pst.setString(1, app.getDate()); rs = pst.executeQuery(); rs.next(); app
	 * = new Appointment(rs.getString(1),rs.getString(2),rs.getString(3),
	 * rs.getString(4)); con.close();
	 * 
	 * } catch (Exception e) { e.printStackTrace(); }
	 * 
	 * return app; }
	 * 
	 * 
	 * 
	 * @Override public boolean deleteAppointment(int appid) {
	 * 
	 * return false; }
	 */

}