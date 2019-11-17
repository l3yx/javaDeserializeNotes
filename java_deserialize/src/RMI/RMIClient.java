package RMI;

import java.net.MalformedURLException;
import java.rmi.*;
import java.rmi.registry.*;

public class RMIClient {
	public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {
		Registry registry = LocateRegistry.getRegistry("localhost",1099);
		IUser user = (IUser)registry.lookup("user");// 从Registry中检索远程对象的存根/代理
		
		user.setName("leixiao");// 调用远程对象的方法
		System.out.println(user.getName());
	}
}