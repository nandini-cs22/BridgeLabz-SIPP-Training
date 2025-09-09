import java.lang.reflect.*;

interface Greeting {
    void sayHello();
}

class GreetingImpl implements Greeting {
    public void sayHello() {
        System.out.println("Hello!");
    }
}

public class LoggingProxy {
    public static void main(String[] args) {
        Greeting real = new GreetingImpl();
        Greeting proxy = (Greeting) Proxy.newProxyInstance(
            Greeting.class.getClassLoader(),
            new Class[]{Greeting.class},
            (proxyObj, method, methodArgs) -> {
                System.out.println("Calling method: " + method.getName());
                return method.invoke(real, methodArgs);
            }
        );
        proxy.sayHello();
    }
}
