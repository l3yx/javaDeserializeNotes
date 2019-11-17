package serialize;

import java.io.Serializable;

public class User implements Serializable{
	private String name;
	public void setName(String name) {
		this.name=name;
	}
	public String getName() {
		return name;
	}
}