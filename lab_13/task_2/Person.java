package src.lab_13.task_2;

public class Person {
    private String firstName;
    private String middleName;
    private String lastName;
    public Person(String firstName, String middleName, String lastName){
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }
    public Person(String firstName){
        this(firstName,"Van", "Tuan");
    }

    public String getName() {
        return firstName + " " + middleName + " " + lastName;
    }

    public static void main(String[] args) {
        Person person = new Person("Mai");
        System.out.println(person.getName());
    }
}
