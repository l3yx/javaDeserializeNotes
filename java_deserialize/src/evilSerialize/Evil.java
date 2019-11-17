package evilSerialize;

import java.io.*;

public class Evil implements Serializable{
	public String cmd;
	private void readObject(java.io.ObjectInputStream stream) throws Exception {
		stream.defaultReadObject();
		Runtime.getRuntime().exec(cmd);
	}
}
