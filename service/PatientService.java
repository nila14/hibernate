package org.medex.service;

import java.util.List;

import org.medex.beans.Display;
import org.medex.beans.Patient;

public interface PatientService {
	String registerPatient(Patient p);
	List<Display> view(Display d);
	List<Display> viewAppointment(Display d);
	
}