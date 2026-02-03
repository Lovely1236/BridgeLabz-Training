package annotations;
import java.lang.annotation.*;
import java.lang.reflect.Method;
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

class Service {

    @BugReport(description="Null pointer issue")
    @BugReport(description="Performance slow")
    public void process(){
        System.out.println("Processing Service");
    }
}

public class BugReportDemo {

    public static void main(String[] args)throws Exception {
        Method method=Service.class.getMethod("process");
        BugReport[] bugs=method.getAnnotationsByType(BugReport.class);
        for(BugReport bug:bugs){
            System.out.println("Bug:"+bug.description());
        }
    }
}