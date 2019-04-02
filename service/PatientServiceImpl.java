package org.medex.service;

import java.util.List;

import org.medex.beans.Display;
import org.medex.beans.Patient;
import org.medex.dao.PatientDao;
import org.medex.dao.PatientDaoImpl;

public class PatientServiceImpl implements PatientService {

	PatientDao p_dao=new PatientDaoImpl() ;
	
		
		
	@Override
	public String registerPatient(Patient p) {
		
		String b=p_dao.insertRegistration(p);
		
		return b;
	}
	
	@Override
	public List<Display> view(Display d) {
		List<Display> b=p_dao.viewAppointmentDetails(d);
		
		return b;
	}

	@Override
	public List<Display> viewAppointment(Display d) {
		List<Display> b=p_dao.viewAppointment(d);
		return b;
	}
}