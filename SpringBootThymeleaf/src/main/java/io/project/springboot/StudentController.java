package io.project.springboot;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class StudentController {
	@Autowired
	private StudentService studentService;
	@GetMapping("/hello")
	public String helloworld(Model model) 
	{
		model.addAttribute("message","Hello World");
		return "helloworld";
	}
	@GetMapping("/")
	public String displayStudents(Model model)
	{
		model.addAttribute("allstudentlist",studentService.getAllStudents());
		return "index";
		
	}
	
	@GetMapping("/addnew")
	public String addNewStudent(Model model)
	{
		Student student =new Student();
		model.addAttribute("student",student);
		return "addnewstudent.html";
	}
	
	@PostMapping("/save")
	public String saveStudent(@ModelAttribute("student") Student student)
	{
		studentService.addStudent(student);
		return "redirect:/";
	}
	
	@GetMapping("/updateStudent/{id}")
	public String updateStudent(@PathVariable(value ="id") long id,Model model)
	{
		
		model.addAttribute("student",studentService.getStudentById(id));
		return "updateStudent";
		
	}
	
	@GetMapping("/deleteStudent/{id}")
	public String deleteStudent(@PathVariable(value= "id") long id) {
	    studentService.deleteStudent(id);
	    return "redirect:/";
		
		
	       
	}

}