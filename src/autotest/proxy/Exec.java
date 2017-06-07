package autotest.proxy;

public class Exec {
	public static void main(String[] args){
		System.out.println(new ProxyGenerator(TestBean.class).createShallow());
	}
}
