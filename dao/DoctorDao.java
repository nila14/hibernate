package org.medex.dao;

import java.util.List;

import org.medex.beans.Display;
import org.medex.beans.Doctor;

public interface DoctorDao {
	String insertRegistration(Doctor d);
	List<Display> viewAppointment(Display d,String id);
}
