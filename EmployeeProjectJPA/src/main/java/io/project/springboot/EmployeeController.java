package io.project.springboot;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping(value="/employee")
	public void addTopic(@RequestBody Employee employee)
	{
		employeeService.addEmployee(employee);
	}
	
	@GetMapping(value="/employee")
	public List<Employee>getAllEmployees()
	{
		return employeeService.getAllEmployees();
	}
	@GetMapping(value="employee/{id}")
	public Optional<Employee> getEmployee(@PathVariable int id)
	{
		return employeeService.getEmployee(id);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/employee/{id}")
	public void updateEmployee(@RequestBody Employee employee,@PathVariable int id)
	{
		employeeService.updateEmployee(employee, id);
	}
	
	@DeleteMapping(value="/employee/{id}")
	public void deleteEmployee(@PathVariable int id)
	{
		employeeService.deleteEmployee(id);
	}
}
