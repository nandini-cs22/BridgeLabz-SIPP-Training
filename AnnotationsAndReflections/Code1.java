import java.lang.reflect.*;

class Person {
    private int age;
}

class Calculator {
    private int multiply(int a, int b) {
        return a * b;
    }
}

class Student {
    public Student() {}
    public void display() {
        System.out.println("Student object created");
    }
}

public class ReflectionPractice {
    public static void main(String[] args) throws Exception {
        Class<?> cls = Class.forName("java.util.ArrayList");
        for(Method m : cls.getDeclaredMethods())
            System.out.println(m.getName());
        for(Field f : cls.getDeclaredFields())
            System.out.println(f.getName());
        for(Constructor<?> c : cls.getDeclaredConstructors())
            System.out.println(c.getName());

        Person p = new Person();
        Field field = Person.class.getDeclaredField("age");
        field.setAccessible(true);
        field.setInt(p, 25);
        System.out.println(field.getInt(p));

        Calculator calc = new Calculator();
        Method method = Calculator.class.getDeclaredMethod("multiply", int.class, int.class);
        method.setAccessible(true);
        System.out.println(method.invoke(calc, 5, 4));

        Class<?> studentCls = Class.forName("Student");
        Object studentObj = studentCls.getDeclaredConstructor().newInstance();
        Method display = studentCls.getDeclaredMethod("display");
        display.invoke(studentObj);
    }
}
