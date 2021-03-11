public class InheritanceTester_5Boxberger {
    public static void main(String[] args) {
        Person john = new Person("John Stevens", 34);
        System.out.println(john);
        john.increaseAge();
        System.out.println(john);

        Student steve = new Student("Steven Johnson", 17, 3.6, 3);
        System.out.println("----------------\n" + steve);
        steve.increaseYear();
        System.out.println(steve);
    }
}

class Person {
    private String name;
    private int age;

    public Person(String personName, int personAge) {
        name = personName;
        age = personAge;
    }

    public String toString() {
        return "Name: " + name + ", Age: " + age;
    }

    public void increaseAge() {
        age++;
    }
}

class Student extends Person {
    private double gpa;
    private int year;

    public Student(String name, int age, double studentGpa, int studentYear) {
        super(name, age);
        gpa = studentGpa;
        year = studentYear;
    }

    public String toString() {
        return super.toString() + ", GPA: " + gpa + ", Year: " + year;
    }

    public void increaseYear() {
        super.increaseAge();
        year++;
    }
}