package mx.com.proyecti;

import javax.xml.ws.Endpoint;

public class Publish {

	public static void main(String[] args) {
		Endpoint.publish("http://localhost:8082/employee/webService", new EmployeeSoap());
		System.out.println("Server started at 8082");

	}

}
