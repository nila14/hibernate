package org.medex.dao;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.medex.beans.Display;
import org.medex.beans.Doctor;
import org.medex.beans.Patient;
import org.medex.entity.PatientEntity;
import org.medex.entity.User;
import org.medex.entity.Appointment;
import org.medex.util.DBConstants;
import org.medex.util.DBUtil;

@Repository("patientDao")
public class PatientDaoImpl implements PatientDao {

                @Autowired
                private SessionFactory sessionFactory;
                
        public String insertRegistration(Patient p) {
        int c = 0,r1=0,r2=0;
        String role="patient";
        String pid=null;
    
        SQLQuery<Patient> patientSelect=sessionFactory.getCurrentSession().createSQLQuery("select * from patient");
        patientSelect.addEntity(Patient.class);
        List<Patient> patientList=patientSelect.list();
   for(Patient i:patientList)
   {
                        c=c+1;
                        pid="P"+c;
                        SQLQuery<Patient> patientInsert=sessionFactory.getCurrentSession().createSQLQuery("insert into patient values(?,?,?,?,?,?,?,?,?,?)");
                        patientInsert.addEntity(Patient.class);
      
                        patientInsert.setString(1, pid);
                        patientInsert.setString(2, p.getFname());
                        patientInsert.setString(3, p.getLname());
                        patientInsert.setString(4, p.getAge());
                        patientInsert.setString(5, p.getGender());
                        patientInsert.setString(6, p.getPhn_number());
                        patientInsert.setString(7, p.getEmail());
                        patientInsert.setString(8, p.getAddress());
                        patientInsert.setInteger(9, p.getZipcode());
                        patientInsert.setString(10, p.getCity());
                        r1 = patientInsert.executeUpdate();
                        SQLQuery<User> userInsert=sessionFactory.getCurrentSession().createSQLQuery("insert into user values(?,?,?)");
                        userInsert.addEntity(User.class);
                      //  pst = con.prepareStatement("insert into user values(?,?,?)");
                        userInsert.setString(1, pid);
                        userInsert.setString(2, p.getPwd());
                        userInsert.setString(3, role);
                        r2 = userInsert.executeUpdate();
                        
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
                                
        SQLQuery<Appointment> appointmentSelect=sessionFactory.getCurrentSession().createSQLQuery("select * from appointment where date_of_app=? and pat_id=?");
        appointmentSelect.addEntity(Display.class);
        List<Appointment> doctorList= appointmentSelect.list();
        appointmentSelect.setString(1, d.getAppDate());
        appointmentSelect.setString(2, d.getPatId());
        List<Display> display=new ArrayList<>();
        Appointment a=new Appointment();
        for(Appointment i:doctorList)
        {
                                                                                                                                                
                                                                                                                                                Display d1=new Display();
                                             SQLQuery<Doctor> selectDoctor=sessionFactory.getCurrentSession().createSQLQuery("select * from doctor where did=?");
                                             selectDoctor.addEntity(Doctor.class);
                                             selectDoctor.setString(1,a.getDoc_id());
                                             List<Doctor> doctorList1= selectDoctor.list();
                                            if( doctorList1.size()>0)
                                             {
                                                             d1.setDocName(doctorList1.get(1).getFname());
                                                             d1.setDocCategory(doctorList1.get(6).getSpecialization());
                                             }
                                             
                                               d1.setAppBookDate(a.getTime_booked());
                                               d1.setTimeSlot(a.getTime());
                                               d1.setAppDate(a.getDate());
                                              
                                               display.add(d1);
                                              
                }
                                      
                      
                        return display;
        }


                @Override
                public List<Display> viewAppointment(Display d) {
                                List<Display> display=new ArrayList<>();
                                SQLQuery<Display> appointmentView=sessionFactory.getCurrentSession().createSQLQuery("select t1.id,t1.date_of_app,t1.time_of_app,t1.date_time_booked,t2.fname,t2.lname,t2.specialization from appointment t1 join doctor t2 on t1.doc_id=t2.did  where t1.pat_id=?");
                                appointmentView.addEntity(Display.class);
                                List<Display> viewList= appointmentView.list();
            
        appointmentView.setString(1, d.getPatId());
                                                
                                                for(Display i:viewList)
            {
                                                                Display d1=new Display();
                                                                 d1.setDocName(viewList.get(1).getDocName());
                                d1.setDocCategory(viewList.get(6).getDocCategory());
                                d1.setAppDate((viewList.get(3).getAppDate()));
                  d1.setTimeSlot(viewList.get(4).getTimeSlot());
                  d1.setAppBookDate(viewList.get(5).getAppBookDate());
                  
                d1.setAppId(viewList.get(0).getAppId());
                display.add(d1);
                                                                
            }
                                
                                return display;
}
}
