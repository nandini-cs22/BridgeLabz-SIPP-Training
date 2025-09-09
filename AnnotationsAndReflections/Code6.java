import java.lang.reflect.*;
import java.util.*;

@interface Inject {}

class Service {
    public void serve() {
        System.out.println("Service is serving");
    }
}

class Client {
    @Inject
    public Service service;
    public void doWork() {
        service.serve();
    }
}

class DIContainer {
    public static <T> T getInstance(Class<T> clazz) throws Exception {
        T obj = clazz.getDeclaredConstructor().newInstance();
        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(Inject.class)) {
                field.setAccessible(true);
                field.set(obj, field.getType().getDeclaredConstructor().newInstance());
            }
        }
        return obj;
    }
}

public class DependencyInjectionDemo {
    public static void main(String[] args) throws Exception {
        Client client = DIContainer.getInstance(Client.class);
        client.doWork();
    }
}
