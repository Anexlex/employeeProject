package mx.com.proyecti;

import java.util.Date;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import mx.com.proyecti.dto.EmployeeFullnameDTO;
import mx.com.proyecti.entity.Employee;
import mx.com.proyecti.manager.EmployeeManager;

@WebService
public class EmployeeSoap {
	
	EmployeeManager manager = new EmployeeManager();
	
	public EmployeeSoap() {
		
	}
	
	@WebMethod
	public Integer create(
			@WebParam(name="firstName") String firstName, 
			@WebParam(name="lastName") String lastName, 
			@WebParam(name="birthDate") Date birthdate, 
			@WebParam(name="salary") double salary) {
		manager.setup();
		Integer id = manager.create(firstName, lastName, birthdate, salary);
		manager.exit();
		return id;
	}
	
	@WebMethod
	public Employee read(@WebParam(name="id")int id) {
		manager.setup();
		Employee employee = manager.read(id);
		manager.exit();
		return employee;
	}

	
	@WebMethod
	public Employee update(@WebParam(name="id")int id, 
	@WebParam(name="firstname")String firstName, 
	@WebParam(name="lastname")String lastName, 
	@WebParam(name="birthdate")Date birthdate, 
	@WebParam(name="salary")double salary, 
	@WebParam(name="username")String userName, 
	@WebParam(name="password")String password) {
		manager.setup();
		manager.update(id, firstName, lastName, birthdate, salary);
		manager.exit();
		Employee emp = read(id);
		return emp;	
	}
	
	@WebMethod
	public void delete(@WebParam(name="id")int id) {
		manager.setup();
		manager.delete(id);
		manager.exit();
	}
	
	@WebMethod
	public EmployeeFullnameDTO readFullname(@WebParam(name="id") int id) {
		manager.setup();
		Employee employee = manager.read(id);
		EmployeeFullnameDTO employeeFullName = new EmployeeFullnameDTO();
		employeeFullName.setId(employee.getId());
		employeeFullName.setFullName(employee.getFirstName() + " " + employee.getLastName());
		
		manager.exit();
		return employeeFullName;
	}
	
	@WebMethod
	public List<Employee> readAll(){
		manager.setup();
		List<Employee> employees=manager.readAll();
		manager.exit();
		return employees;
	}
}
