package annotations;

import java.util.ArrayList;

public class SuppressUncheckedWarning {

    void demo() {
        @SuppressWarnings("unchecked")
        ArrayList list = new ArrayList();   // raw type → unchecked warning

        list.add("Java");
        list.add(100);
    }

    public static void main(String[] args) {
        SuppressUncheckedWarning obj = new SuppressUncheckedWarning();
        obj.demo();
    }
}
