package org.medex.service;

import java.util.List;

import org.medex.beans.Display;
import org.medex.beans.Doctor;

public interface DoctorService {
	String registerDoctor(Doctor d);
	List<Display> view(Display d,String id);

}