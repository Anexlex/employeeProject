package mx.com.proyecti;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class Greeter {
	public final String worldGreeting = "Hello World";
	
	public Greeter() {}
	
	@WebMethod
	public String greetWorld(String name) {
		return worldGreeting + " " + name;
	}
}