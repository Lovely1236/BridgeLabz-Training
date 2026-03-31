package annotations;
import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface LogExecutionTime {
}

class PerformanceTest {

    @LogExecutionTime
    public void heavyTask(){
        for(int i=0;i<1000000;i++){
        }
    }
}

public class LogExecutionTimeDemo {

    public static void main(String[] args)throws Exception {
        PerformanceTest obj=new PerformanceTest();
        Method method=PerformanceTest.class.getMethod("heavyTask");
        if(method.isAnnotationPresent(LogExecutionTime.class)){
            long start=System.nanoTime();
            method.invoke(obj);
            long end=System.nanoTime();
            System.out.println("Execution Time:"+(end-start)+"ns");
        }
    }
}