package org.medex.service;

import java.util.List;

import org.medex.beans.Display;
import org.medex.beans.Doctor;
import org.medex.dao.DoctorDao;
import org.medex.dao.DoctorDaoImpl;

public class DoctorServiceImpl implements DoctorService {

	DoctorDao d_dao =new DoctorDaoImpl();
	@Override
	public String registerDoctor(Doctor d) {
		String b=d_dao.insertRegistration(d);
		
		return b;
	}
	
	@Override
	public List<Display> view(Display d,String id) {
		List<Display> b=d_dao.viewAppointment(d,id);
		
		return b;
	}

}