package src.lab_17.task_1;

import javax.naming.ldap.Control;
import java.util.Scanner;

public class MVCPatternDemo {
    public static void main(String[] args) {
        Student student =  retrieveStudentFromDatabase();
        StudentController control = new StudentController();
        control.setStudentName(student.getName());
        control.setStudentRollNo(student.getRollNo());
        control.updateView();
    }
    public static Student retrieveStudentFromDatabase() {
        Student student = new Student("Tuan", "abc");
        return student;
    }

}
