package com.thuctap.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.thuctap.entities.Student;


@Repository
@Transactional(rollbackFor = Exception.class)
public class StudentDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public Student getStudent(int id) {
		Session session = sessionFactory.getCurrentSession();
		Student stu = (Student) session.get(Student.class, id);
		return stu;

	}

	public Student addStudent(Student stuForm) {
		Session session = sessionFactory.getCurrentSession();
		session.save(stuForm);
		return stuForm;
	}

	public Student updateStudent(Student stuForm) {
		Session session = sessionFactory.getCurrentSession();
		Student stu = (Student) session.get(Student.class, stuForm.getId());
		stu.setName(stuForm.getName());
		stu.setAge(stuForm.getAge());
		stu.setAddress(stuForm.getAddress());
		session.update(stu);
		return stu;

	}

	public void deleteStudent(int id) {
		Session session = sessionFactory.getCurrentSession();
		Student stu = (Student) session.get(Student.class, id);
		session.delete(stu);
	}

	public List<Student> getAllStudents() {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Student> listStudent = session.createQuery(" FROM " + Student.class.getName() +" as b ORDER BY b.id ").list();
		return listStudent;
	}
}
