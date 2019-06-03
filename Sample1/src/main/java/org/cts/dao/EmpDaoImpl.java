package org.cts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.cts.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.stereotype.Repository;
@Repository("service")
public class EmpDaoImpl implements EmpDao {
	@Autowired
	JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	@Override
	public int insert(Emp e) {
		String sql="insert into emp values(?,?,?)";
		int i=template.update(sql, e.getEno(),e.getName(),e.getAddress());
		return i;
	}
	@Override
	public int delete(int eno) {
		/*
		 * int i = template.update(new PreparedStatementCreator() { PreparedStatement
		 * pst=null;
		 * 
		 * @Override public PreparedStatement createPreparedStatement(Connection con)
		 * throws SQLException {
		 * pst=con.prepareStatement("delete from emp where eno=?"); pst.setInt(1, eno);
		 * return pst; } });
		 */
		int i=template.update(new PreparedStatementCreator() {
			PreparedStatement pst=null;
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				pst=con.prepareStatement("delete from emp where eno=?");
				pst.setInt(1, eno);
				return pst;
			}
		});
		return i;
	}

	@Override
	public int update(int eno, String newName) {
		int i=template.update(new PreparedStatementCreator() {
			PreparedStatement pst=null;
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				pst=con.prepareStatement("update emp set name=? where eno=?");
				pst.setString(1, newName);
				pst.setInt(2, eno);
				return pst;
			}
		});
		return i;
	}

	@Override
	public Emp get(int eno) {
		Emp e=template.queryForObject("select * from emp where eno=?", new Object[] {eno}, Emp.class);
		return e;
	}

}
