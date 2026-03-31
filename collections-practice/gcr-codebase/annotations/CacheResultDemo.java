package annotations;
import java.lang.annotation.*;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface CacheResult {
}

class Calculator {

    @CacheResult
    public int square(int num){
        System.out.println("Computing...");
        return num*num;
    }
}

public class CacheResultDemo {
    private static Map<String,Object> cache=new HashMap<>();
    public static void main(String[] args)throws Exception {
        Calculator calc=new Calculator();
        Method method=Calculator.class.getMethod("square",int.class);
        System.out.println(invoke(calc,method,6));
        System.out.println(invoke(calc,method,5));
    }
    private static Object invoke(Object obj,Method method,Object arg)throws Exception {
        String key=method.getName()+arg;
        if(cache.containsKey(key)){
            return cache.get(key);
        }
        Object result=method.invoke(obj,arg);
        cache.put(key,result);
        return result;
    }
}