package annotations;
import java.lang.annotation.*;
import java.lang.reflect.Field;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface MaxLength {
    int value();
}

class User {
    @MaxLength(10)
    private String username;
    public User(String username)throws Exception {
        Field field=this.getClass().getDeclaredField("username");
        field.setAccessible(true);
        MaxLength max=field.getAnnotation(MaxLength.class);
        if(username.length()>max.value()){
            throw new IllegalArgumentException("Username too long");
        }
        this.username=username;
    }
    public void show(){
        System.out.println("Username:"+username);
    }
}
public class MaxLengthDemo {
    public static void main(String[] args)throws Exception {
        User user=new User("Parth");
        user.show();
    }
}