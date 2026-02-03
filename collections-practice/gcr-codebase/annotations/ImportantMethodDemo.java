package annotations;
import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface ImportantMethod {
    String level()default"HIGH";
}

class SystemTasks {
    @ImportantMethod
    public void backup(){
        System.out.println("Backup Done");
    }
    @ImportantMethod(level="LOW")
    public void cleanTemp(){
        System.out.println("Temp Cleaned");
    }
}

public class ImportantMethodDemo {
    public static void main(String[] args){
        Method[] methods=SystemTasks.class.getDeclaredMethods();
        for(Method method:methods){
            if(method.isAnnotationPresent(ImportantMethod.class)){
                ImportantMethod info=method.getAnnotation(ImportantMethod.class);
                System.out.println("Method:"+method.getName()+" Level:"+info.level());
            }
        }
    }
}