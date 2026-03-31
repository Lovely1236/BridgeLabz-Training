public class PenDivision {
    public static void main(String[] args) {
        int totalPens = 14;

        int students = 3;
        int pensPerStudent = totalPens / students;

        int remainPens = totalPens % students;
        System.out.print("The Pen per Student is:" + pensPerStudent + "and the remaining pen not distributed is:" +remainPens);

    }
}