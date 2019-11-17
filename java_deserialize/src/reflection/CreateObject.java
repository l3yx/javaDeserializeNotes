package reflection;

import java.lang.reflect.*;

public class CreateObject {
	public static void main(String[] args) throws Exception {
		Class UserClass=Class.forName("reflection.User");
		
		Constructor constructor=UserClass.getConstructor(String.class);
		
		User user=(User) constructor.newInstance("leixiao");
		
		System.out.println(user.getName());
	}
}