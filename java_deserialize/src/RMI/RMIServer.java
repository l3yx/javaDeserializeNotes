package RMI;

import java.net.MalformedURLException;
import java.rmi.*;
import java.rmi.registry.*;

public class RMIServer {
	public static void main(String[] args) throws RemoteException, AlreadyBoundException, MalformedURLException {
		User user=new User();//创建一个远程对象
		
		Registry registry = LocateRegistry.createRegistry(1099);//本地主机上的远程对象注册表Registry的实例,默认端口1099
		registry.bind("user", user);//把远程对象注册到RMI注册服务器上,并命名为user
		
		System.out.println("server ready...");
	}
}