package volume1.fundamentals.ch06.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Random;

/**
 * @author rancho
 * @date 2019-08-19
 */
public class ProxyTest {

    public static void main(String[] args) {
        Object[] elements = new Object[1000];

        // fill elements with proxies for the integers 1-1000
        for (int i = 0; i < elements.length; i++) {
            Integer value = i + 1;
            InvocationHandler handler = new TraceHandler(value);
            Object proxy = Proxy.newProxyInstance(null, new Class[] {Comparable.class}, handler);
            elements[i] = proxy;
        }

        // construct a random integer
        Integer key = new Random().nextInt(elements.length) + 1;

        // search for the key
        int result = Arrays.binarySearch(elements, key);

        if (result >= 0) {
            System.out.println(elements[result]);
            // check class info
            Object wrapped = elements[result];
            System.out.println(wrapped.getClass());
            System.out.println(Proxy.isProxyClass(wrapped.getClass()));
            System.out.println(Proxy.getInvocationHandler(wrapped));
        }
    }

}
