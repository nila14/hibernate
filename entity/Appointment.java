package org.medex.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="doctor")

public class Appointment implements Serializable {
	
	private static final long serialVersionUID = -723583058586873479L;
	 
	 @Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
	 @Column(name = "id")
		int id;
	 @Column(name = "date")
		String date;
	 @Column(name = "time")
		String time;
	 @Column(name = "time_booked")
		String time_booked;
	 @Column(name = "category")
		String category;
	 @Column(name = "doc_id")
		String doc_id;
	 @Column(name = "pat_id")
		String pat_id;
	 @Column(name = "diag_info")
		String diag_info;
	     
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getDate() {
			return date;
		}
		public void setDate(String date) {
			this.date = date;
		}
		public String getTime() {
			return time;
		}
		public void setTime(String time) {
			this.time = time;
		}
		public String getTime_booked() {
			return time_booked;
		}
		public void setTime_booked(String time_booked) {
			this.time_booked = time_booked;
		}
		public String getCategory() {
			return category;
		}
		public void setCategory(String category) {
			this.category = category;
		}
		public String getDoc_id() {
			return doc_id;
		}
		public void setDoc_id(String doc_id) {
			this.doc_id = doc_id;
		}
		public String getPat_id() {
			return pat_id;
		}
		public void setPat_id(String pat_id) {
			this.pat_id = pat_id;
		}
		public String getDiag_info() {
			return diag_info;
		}
		public void setDiag_info(String diag_info) {
			this.diag_info = diag_info;
		}
		

}
