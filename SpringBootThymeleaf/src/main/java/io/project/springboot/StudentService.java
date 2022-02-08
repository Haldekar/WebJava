package io.project.springboot;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	public List<Student>getAllStudents()
	{
		return studentRepository.findAll();
	}
	
	public void addStudent(Student student)
	{
		studentRepository.save(student);
	}
	

	public Student getStudentById(long id)
	{
		java.util.Optional<Student>optional=studentRepository.findById(id);
		Student student=null;
		if(optional.isPresent())
		{
			student=optional.get();
		}
		else {
			throw new RuntimeException("Student not found for id:" +id);
			
		}
		return student;
		
		 
	}
	
	public void updateStudent(Student student,long id)
	{
		studentRepository.save(student);
	}
	
	public void deleteStudent(long id)
	{
		studentRepository.deleteById(id);
	}

	

	 
	
}
