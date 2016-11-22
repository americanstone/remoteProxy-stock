package com.codehub.remoting.proxy;

import com.codehub.remoting.proxy.RemoteProxyServerManager;
import com.codehub.remoting.proxy.models.IPerson;
import com.codehub.remoting.proxy.models.Person;
import com.codehub.remoting.proxy.proxy.RemoteProxy;

public class Main {
	public static void main(String[] args) {
		RemoteProxyServerManager manager = RemoteProxyServerManager.getInstance();
		manager.forceStart();


		RemoteProxy proxy1 = RemoteProxy.createClientProxy(
				new String[]{"com.codehub.remoting.proxy.models.IPerson"}, // interface(s)
				"com.codehub.remoting.proxy.models.Person",  // implementation
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
