package com.thuctap.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thuctap.DAO.StudentDAO;
import com.thuctap.entities.Student;

@Service
@Transactional
public class StudentService {
	@Autowired
	private StudentDAO studentDAO;
	
	public Student getStudent(int id) {
		return studentDAO.getStudent(id);
	}
	
	public Student addStudent (Student empForm) {
		return studentDAO.addStudent(empForm);
	}
	public Student updateStudent (Student empForm) {
		return studentDAO.updateStudent(empForm);
	}
	
	public void deleteStudent (int id) {
		 studentDAO.deleteStudent(id);
	}
	
	public List<Student> getAllStudents () {
		return studentDAO.getAllStudents();
	}
}
