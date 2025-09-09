import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface TaskInfo {
    int priority();
    String assignedTo();
}

class TaskManager {
    @TaskInfo(priority = 1, assignedTo = "Alice")
    public void performTask() {
        System.out.println("Task is being performed");
    }
}

public class CustomAnnotationExample {
    public static void main(String[] args) throws Exception {
        Method method = TaskManager.class.getMethod("performTask");
        if(method.isAnnotationPresent(TaskInfo.class)) {
            TaskInfo info = method.getAnnotation(TaskInfo.class);
            System.out.println("Priority: " + info.priority());
            System.out.println("Assigned To: " + info.assignedTo());
        }
    }
}
