import java.lang.reflect.*;

@interface Author {
    String name();
}

@Author(name = "John Doe")
class MathOperations {
    public int add(int a, int b) {
        return a + b;
    }
    public int subtract(int a, int b) {
        return a - b;
    }
    public int multiply(int a, int b) {
        return a * b;
    }
}

class Configuration {
    private static String API_KEY = "DEFAULT_KEY";
}

public class ReflectionCombined {
    public static void main(String[] args) throws Exception {
        Class<?> mathCls = MathOperations.class;
        Object mathObj = mathCls.getDeclaredConstructor().newInstance();
        Method method = mathCls.getDeclaredMethod("multiply", int.class, int.class);
        System.out.println(method.invoke(mathObj, 6, 7));

        Class<?> authorCls = MathOperations.class;
        if(authorCls.isAnnotationPresent(Author.class)) {
            Author author = authorCls.getAnnotation(Author.class);
            System.out.println("Author: " + author.name());
        }

        Class<?> configCls = Configuration.class;
        Field field = configCls.getDeclaredField("API_KEY");
        field.setAccessible(true);
        field.set(null, "NEW_SECRET_KEY");
        System.out.println("API_KEY: " + field.get(null));
    }
}
