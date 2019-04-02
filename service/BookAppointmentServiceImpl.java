package org.medex.service;



import org.medex.beans.BookAppointment;
import org.medex.dao.BookAppointmentDao;
import org.medex.dao.BookAppointmentDaoImpl;

public class BookAppointmentServiceImpl implements BookAppointmentService {
	
	BookAppointmentDao dao=new BookAppointmentDaoImpl();
	@Override
	public boolean showavailableDoctor(BookAppointment ba) {
		
		
		boolean res=dao.showavailableDoctor(ba);
		return res;
	}

}
