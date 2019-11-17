package invokerTransformerDemo;

import org.apache.commons.collections.functors.InvokerTransformer;

public class InvokerTransformerDemo {
	public static void main(String[] args) throws Exception {
		//Class runtimeClass=Class.forName("java.lang.Runtime");
		//Object runtime=runtimeClass.getMethod("getRuntime").invoke(null);
		//runtimeClass.getMethod("exec", String.class).invoke(runtime,"calc.exe");
		
		Class runtimeClass=Class.forName("java.lang.Runtime");// Runtime的类对象
		
		//借助InvokerTransformer调用runtimeClass的getMethod方法,参数是getRuntime,最后返回的其实是一个Method对象即getRuntime方法
		Object m_getMethod=new InvokerTransformer("getMethod",new Class[] {
				String.class,Class[].class},new Object[] {
				"getRuntime",null
				}
		).transform(runtimeClass);
		
		//借助InvokerTransformer调用m_getMethod的invoke方法,没有参数,最后返回的其实是runtime这个对象
		Object runtime=new InvokerTransformer("invoke",new Class[] {
				Object.class,Object[].class},new Object[] {
				null,null
				}
		).transform(m_getMethod);
		
		//借助InvokerTransformer调用runtime的exec方法,参数为calc.exe,返回的自然是一个Process对象
		Object exec=new InvokerTransformer("exec",new Class[] {
				String.class},new Object[] {
				"calc.exe"
				}
		).transform(runtime);
	}
}