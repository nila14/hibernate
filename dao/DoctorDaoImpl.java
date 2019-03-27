package org.medex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.medex.beans.Appointment;
import org.medex.beans.Display;
import org.medex.beans.Doctor;
import org.medex.beans.Patient;
import org.medex.beans.User;
import org.medex.entity.PatientEntity;
import org.medex.util.DBConstants;
import org.medex.util.DBUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("DoctorDao")
public class DoctorDaoImpl implements DoctorDao {


	@Autowired
	 private SessionFactory sessionFactory;

	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	public String insertRegistration(Doctor d) {

		String did = null;
		int c = 0, r1 = 0, r2 = 0;
		String role = "doctor";

		SQLQuery<Doctor> doctorSelect=sessionFactory.getCurrentSession().createSQLQuery("select * from doctor");
		doctorSelect.addEntity(Doctor.class);
		List<Doctor> doctorList=doctorSelect.list();
		while(doctorList.size()>0)
		{
			c = c + 1;
		}
		did = "D" + c;
		SQLQuery<Doctor> doctorInsert=sessionFactory.getCurrentSession().createSQLQuery("insert into doctor values(?,?,?,?,?,?,?,?,?,?,?,?)");
		doctorInsert.addEntity(Doctor.class);
		doctorInsert.setString(1, did);
		doctorInsert.setString(2, d.getFname());
		doctorInsert.setString(3, d.getLname());
		doctorInsert.setString(4, d.getGender());
		doctorInsert.setString(5, d.getAge());
		doctorInsert.setString(6, d.getQualification());
		doctorInsert.setString(7, d.getSpecialization());
		doctorInsert.setString(8, d.getContact_no());
		doctorInsert.setString(9, d.getEmail());
		doctorInsert.setString(10, d.getAddress());
		doctorInsert.setInteger(11, d.getZipcode());
		doctorInsert.setString(12, d.getCity());
		List<Doctor> doctorList1=doctorInsert.list();
		SQLQuery<User> userInsert=sessionFactory.getCurrentSession().createSQLQuery("insert into user values(?,?,?)");
		userInsert.addEntity(User.class);
		userInsert.setString(1, did);
		userInsert.setString(2, d.getPwd());
		doctorInsert.setString(3, role);
		List<User> userList=userInsert.list();
		if(userList.size()>0 && doctorList1.size()>0)
		{
			return did;
		}
		else
		{
			return null;
		}
		
	}
	public List<Display> viewAppointment(Display d,String id)
	{
		List<Display> display=new ArrayList<>();
   
		 Display d1=new Display();
		SQLQuery<Appointment> appSelect=sessionFactory.getCurrentSession().createSQLQuery("select * from appointment where date_of_app=? and doc_id=?");
		appSelect.addEntity(Appointment.class);
		List<Appointment> appList=appSelect.list();
		appSelect.setString(1,  d.getAppDate());
		appSelect.setString(2, id);
		Appointment a =new Appointment();
		for(Appointment i:appList)
		{
			SQLQuery<Patient> patSelect=sessionFactory.getCurrentSession().createSQLQuery("select * from patient where pid=?");
			patSelect.addEntity(Patient.class);
			List<Patient> patList=patSelect.list();
			patSelect.setString(1,a.getPat_id());
			if(patList.size()>0)
			{
				d1.setPatId(patList.get(1).getFname()+" "+patList.get(2).getLname());
				d1.setPatContactNo(patList.get(5).getPhn_number());
       		    d1.setPatEmail(patList.get(6).getEmail());
       		    d1.setPatAddress(patList.get(7).getAddress()+" "+patList.get(8).getCity()+" "+patList.get(9).getZipcode());
       		    d1.setPatAge(patList.get(4).getAge());
       		    d1.setPatGender(patList.get(3).getGender());
			}
			d1.setAppBookDate(appList.get(3).getDate());
     	   d1.setTimeSlot(appList.get(4).getTime());
     	  display.add(d1);
			
		}
		return display;
        }

}
