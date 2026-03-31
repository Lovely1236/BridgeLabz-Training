package annotations;
import java.lang.annotation.*;
import java.lang.reflect.Field;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface JsonField {
    String name();
}

class UserProfile {

    @JsonField(name="user_name")
    private String name;

    @JsonField(name="user_age")
    private int age;
    public UserProfile(String name,int age){
        this.name=name;
        this.age=age;
    }
}

public class JsonFieldDemo {
    public static String toJson(Object obj)throws Exception {
        StringBuilder json=new StringBuilder("{");
        Field[] fields=obj.getClass().getDeclaredFields();
        for(int i=0;i<fields.length;i++){
            fields[i].setAccessible(true);
            JsonField jf=fields[i].getAnnotation(JsonField.class);
            json.append("\"").append(jf.name()).append("\":\"").append(fields[i].get(obj)).append("\"");

            if(i<fields.length-1){
                json.append(",");
            }
        }
        json.append("}");
        return json.toString();
    }
    public static void main(String[] args)throws Exception {
        UserProfile user=new UserProfile("Parth",22);
        System.out.println(toJson(user));
    }
}