package mx.com.proyecti.manager;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import mx.com.proyecti.entity.Employee;

public class EmployeeManager {

	private SessionFactory sessionFactory;
	
	public void setup() {
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
				.configure()
				.build();
		try {
		sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		} catch(Exception e) {
			StandardServiceRegistryBuilder.destroy(registry);
		}
	}
	
	public void exit() {
		sessionFactory.close();
	}
	
	//CRUD OPERATIONS
	public Integer create(String firstName, String lastName, Date birthdate, double salary) {
		Employee employee = new Employee();
		employee.setFirstName(firstName);
		employee.setLastName(lastName);
		employee.setBirthdate(birthdate);
		employee.setSalary(salary);
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Integer result = (Integer)session.save(employee);
		
		session.getTransaction().commit();
		session.close();
		return result;
	}
	
	public Employee read(int id) {
		Session session = sessionFactory.openSession();
		Employee result = session.get(Employee.class, id);
		session.clear();
		return result;
	}
	
	public void update(int id, String firstName, String lastName, Date birthdate, double salary) {
		Employee employee = new Employee();
		employee.setId(id);
		employee.setFirstName(firstName);
		employee.setLastName(lastName);
		employee.setBirthdate(birthdate);
		employee.setSalary(salary);
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(employee);
		session.getTransaction().commit();
		session.close();
	}
	
	public void delete(int id) {
		Employee employee = new Employee();
		employee.setId(id);
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		session.delete(employee);
		session.getTransaction().commit();
		session.close();
	}
	
	public List<Employee> readAll() {
		Session session =sessionFactory.openSession();
		List<Employee> list=session.createQuery("from Employee").list();
		session.close();
		return list;
		
	}
}