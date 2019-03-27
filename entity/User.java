package org.medex.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")

public class User implements Serializable {
	
	private static final long serialVersionUID = -723583058586873479L;
	 
	 @Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
	 
	 @Column(name = "id")
	private String id;
	 @Column(name = "pwd")
	private String pwd;
	 @Column(name = "role")
	private String role;
	 @Column(name = "name")
	private String name;

	 
	 
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getPwd() {
			return pwd;
		}
		public void setPwd(String pwd) {
			this.pwd = pwd;
		}
		public String getRole() {
			return role;
		}
		public void setRole(String role) {
			this.role = role;
		}
		
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
		

}
