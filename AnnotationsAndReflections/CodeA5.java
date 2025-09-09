import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(BugReports.class)
@interface BugReport {
    String description();
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface BugReports {
    BugReport[] value();
}

class TestClass {
    @BugReport(description = "Null pointer exception")
    @BugReport(description = "Array index out of bounds")
    public void testMethod() {
        System.out.println("Testing method");
    }
}

public class RepeatableAnnotationExample {
    public static void main(String[] args) throws Exception {
        Method method = TestClass.class.getMethod("testMethod");
        if(method.isAnnotationPresent(BugReports.class)) {
            BugReports reports = method.getAnnotation(BugReports.class);
            for(BugReport report : reports.value()) {
                System.out.println("Bug: " + report.description());
            }
        }
    }
}
