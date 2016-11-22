import com.codehub.remoting.proxy.RemoteProxy;
import com.codehub.remoting.proxy.RemoteProxyServerManager;
import models.IPerson;
import models.Person;

public class Main {
	public static void main(String[] args) {
		RemoteProxyServerManager manager = RemoteProxyServerManager.getInstance();
		manager.forceStart();


		RemoteProxy proxy1 = RemoteProxy.createClientProxy(
				new String[]{"models.IPerson"}, // interface(s)
				"models.Person",  // implementation
				"localhost",       // server IP or hostname
				1099               // server port
		);

		IPerson intstance1 = (IPerson)proxy1.getInstance();
		intstance1.setName("Gordon");
		System.out.println("this is client proxy generated object Aperson and name is : " + intstance1.getName());


		RemoteProxy proxy = RemoteProxy.createServerProxy(Person.class, "localhost", 1099);
		Object person = proxy.getInstance();
	}
}
