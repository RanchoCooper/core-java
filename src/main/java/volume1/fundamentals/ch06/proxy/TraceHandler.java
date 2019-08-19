package volume1.fundamentals.ch06.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author rancho
 * @date 2019-08-19
 */
public class TraceHandler implements InvocationHandler {

    private Object target;

    TraceHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(String.format("Target `%s` called method `%s` with args `%s`", target, method.getName(), Arrays.toString(args)));

        // invoke actual method
        return method.invoke(target, args);
    }

}
