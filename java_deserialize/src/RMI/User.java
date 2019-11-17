package RMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class User extends UnicastRemoteObject implements IUser {
	protected User() throws RemoteException {
		//UnicastRemoteObject.exportObject(this,0);
	}
	private String name;

	public String getName() throws RemoteException{
		return name;
	}
	public void setName(String name) throws RemoteException{
		this.name=name;
	}
}