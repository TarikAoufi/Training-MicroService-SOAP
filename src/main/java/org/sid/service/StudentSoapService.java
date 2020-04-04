package org.sid.service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.sid.entity.Student;
import org.sid.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 
 * Web service SOAP basé sur JAX-WS (Java API for XML based Web Services).
 * Permet de gérer des étudiants.
 *
 */
@Component
@WebService(serviceName = "StudentWS")
public class StudentSoapService {

	@Autowired
	private StudentRepository studentRepository;

	@WebMethod(operationName = "studentList")
	public List<Student> getStudents() {
		return studentRepository.findAll();
	}

	@WebMethod
	public Student getStudent(@WebParam(name = "id") Long id) {
		return studentRepository.findById(id).get();
	}

	@WebMethod
	public Student saveStudent(@WebParam(name = "student") Student student) {
		return studentRepository.save(student);
	}

	@WebMethod
	public Student updateStudent(@WebParam(name = "id") Long id, @WebParam(name = "student") Student student) {
		student.setId(id);
		return studentRepository.save(student);
	}

	@WebMethod
	public void deleteStudent(@WebParam(name = "id") Long id) {
		studentRepository.deleteById(id);
	}

}
