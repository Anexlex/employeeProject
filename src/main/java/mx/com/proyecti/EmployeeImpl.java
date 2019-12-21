package mx.com.proyecti;

import java.util.Date;

import mx.com.proyecti.manager.EmployeeManager;

public class EmployeeImpl {

	public static void main(String[] args) {
		EmployeeManager manager  = new EmployeeManager();
		manager.setup();
		
		manager.create("Jorge", "Ramírez", new Date(), 200);
		
		manager.exit();
	}

}
