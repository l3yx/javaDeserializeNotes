package reflection;

import java.lang.reflect.*;

public class CallMethod {
	public static void main(String[] args) throws Exception {
		Class UserClass=Class.forName("reflection.User");
		
		Constructor constructor=UserClass.getConstructor(String.class);
		User user=(User) constructor.newInstance("leixiao");
		
		Method method = UserClass.getDeclaredMethod("setName", String.class);
		method.invoke(user, "l3yx");
		
		System.out.println(user.getName());
	}
}