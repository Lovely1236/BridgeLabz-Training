package annotations;
import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface TaskInfo {
    String priority();
    String assignedTo();
}
class TaskManager {
    @TaskInfo(priority="HIGH",assignedTo="Parth")
    public void submitProject(){
        System.out.println("Project Submitted");
    }
}
public class TaskInfoDemo {
    public static void main(String[] args)throws Exception {
        Method method=TaskManager.class.getMethod("submitProject");
        TaskInfo info=method.getAnnotation(TaskInfo.class);
        System.out.println("Priority:"+info.priority());
        System.out.println("Assigned To:"+info.assignedTo());
    }
}