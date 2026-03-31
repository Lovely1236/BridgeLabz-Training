package annotations;
import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Todo {
    String task();
    String assignedTo();
    String priority()default"MEDIUM";
}

class Project {
    @Todo(task="Add Login",assignedTo="Parth",priority="HIGH")
    public void loginFeature(){
    }

    @Todo(task="Add Payment",assignedTo="Rahul")
    public void paymentFeature(){
    }
}

public class ToDoDemo {
    public static void main(String[] args){
        Method[] methods=Project.class.getDeclaredMethods();
        for(Method method:methods){
            if(method.isAnnotationPresent(Todo.class)){
                Todo todo=method.getAnnotation(Todo.class);
                System.out.println("Task:"+todo.task());
                System.out.println("Assigned To:"+todo.assignedTo());
                System.out.println("Priority:"+todo.priority());
                System.out.println("---------------");
            }
        }
    }
}