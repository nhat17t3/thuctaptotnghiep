package com.thuctap.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.thuctap.entities.Student;
import com.thuctap.service.StudentService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/rest")
public class StudentController {
	
	@Autowired
	private StudentService studentService;

	// get all students
	@RequestMapping(value = "/students", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public List<Student> getStudents() {

		List<Student> list = studentService.getAllStudents();
		return list;
	}

	// get student by id
	@RequestMapping(value = "/students/{id}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public Student getStudent(@PathVariable("id") int id) {

		return studentService.getStudent(id);

	}

	// add student
	@RequestMapping(value = "/students", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public Student addStudent(@RequestBody Student stuForm) {

		System.out.println("server side creating student with empNo" + stuForm.getName());
		return studentService.addStudent(stuForm);

	}

	// update student
	@RequestMapping(value = "/students", method = RequestMethod.PUT, produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public Student updateStudent(@RequestBody Student stuForm) {

		System.out.println("server side updating student with id" + stuForm.getId());
		return studentService.updateStudent(stuForm);

	}

	// delete student by id
	@RequestMapping(value = "/students/{id}", method = RequestMethod.DELETE, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public String deleteStudent(@PathVariable("id") int id) {
		System.out.println("server side deleting student with id" + id);
		studentService.deleteStudent(id);
		return "delete student sucessful";

	}
}
