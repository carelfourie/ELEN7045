package za.ac.wits.eie.ELEN7045.aps.concurrency;

import java.lang.reflect.Proxy;

public class ProxyFactory {

	public static Object newInstance(final Object obj) {
		return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), new ScrapingSessionInvocationHandler(obj));
	}
}
