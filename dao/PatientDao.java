package org.medex.dao;

import java.util.List;

import org.medex.beans.Display;
import org.medex.beans.Patient;

public interface PatientDao {
	
	public String insertRegistration(Patient p); //register patient
    List<Display> viewAppointmentDetails(Display d);//view appointment by date
	List<Display> viewAppointment(Display d);//appointment dropdown
}
