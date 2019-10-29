package com.myclass.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.myclass.connection.JDBCConnection;
import com.myclass.connection.JDBCConnectionImpl;
import com.myclass.entity.Student;

public class AccountRepositoryImpl implements AccountRepository {
	
	private JDBCConnection jdbcConnection;
	private final String FIND_ALL="SELECT *FROM students;";

	private final String ADD_NEW="INSERT INTO students (email,fullName,address,phone) VALUES (?,?,?,?);";
	
	private final String FIND_BY_ID="SELECT *FROM students WHERE id= ?;";
	
	private final String UPDATE_STUDENT="UPDATE students SET email=?, fullName=?, address=?, phone=? WHERE id = ?;";
	
	private final String DELETE_BY_ID="DELETE FROM students WHERE id= ?";
	public AccountRepositoryImpl() {
		
		jdbcConnection= new JDBCConnectionImpl();
	}

	public void RemoveAll(List<Student> students) {
		students.removeAll(students);
	}
	public List<Student> getListStudent() {
		List<Student> students =  new ArrayList<Student>();
		try (Connection conn= jdbcConnection.getConnection()) {
			PreparedStatement stmt=conn.prepareStatement(FIND_ALL);
			ResultSet rs = stmt.executeQuery();
			while  (rs.next()) {
				Student student = new Student();
				student.setId(rs.getInt("id"));
				student.setEmail(rs.getString("email"));
				student.setFullName(rs.getString("fullName"));
				student.setPhone(rs.getString("phone"));
				student.setAddress(rs.getString("address"));
				
				students.add(student);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return students;
	}

	public void add(Student student) {
		int result=-1;
		try (Connection conn = jdbcConnection.getConnection()) {
			PreparedStatement stmt= conn.prepareStatement(ADD_NEW);
			stmt.setString(1, student.getEmail());
			stmt.setString(2, student.getFullName());
			stmt.setString(3, student.getAddress());
			stmt.setString(4, student.getPhone());
			result= stmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	@Override
	public void edit(int id) {
		Student student = FindById(id);
		int result=-1;
		student.Input();
		try (Connection conn = jdbcConnection.getConnection()) {
			PreparedStatement stmt= conn.prepareStatement(UPDATE_STUDENT);
			stmt.setString(1, student.getEmail());
			stmt.setString(2, student.getFullName());
			stmt.setString(3, student.getAddress());
			stmt.setString(4, student.getPhone());
			stmt.setInt(5, student.getId());
			result= stmt.executeUpdate();
		
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	@Override
	public void delete(int id) {
		int result=-1;
		try (Connection conn = jdbcConnection.getConnection()) {
			PreparedStatement stmt= conn.prepareStatement(DELETE_BY_ID);
			stmt.setInt(1, id);
			result= stmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}



	@Override
	public Student FindById(int id) {
		Student student= new Student();
		try (Connection conn = jdbcConnection.getConnection()) {
			PreparedStatement stmt= conn.prepareStatement(FIND_BY_ID);
			stmt.setInt(1, id);
			ResultSet rs= stmt.executeQuery();
			if (rs.next()) {
				student.setId(rs.getInt("id"));
				student.setEmail(rs.getString("email"));
				student.setFullName(rs.getString("fullName"));
				student.setPhone(rs.getString("phone"));
				student.setAddress(rs.getString("address"));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return student;
	}

	

	

}
