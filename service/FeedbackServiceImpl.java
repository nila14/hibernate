package org.medex.service;


import org.medex.beans.Feedback;
import org.medex.dao.FeedbackDao;
import org.medex.dao.FeedbackDaoImpl;

public class FeedbackServiceImpl implements  FeedbackService{
    
	FeedbackDao dao=new FeedbackDaoImpl() ;
	@Override
	public void feedbackForm(Feedback f) {
		
		dao.feedbackFormRegister(f);
		
		
	}

}
