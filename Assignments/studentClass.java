class studentClass {
    public static void main(String args[]) {
        Student student1 = new Student("Bill", "Bellarmine", 4);
        System.out.println(student1 + "\n");

        Student student2 = new Student("Charles", "Mitty", 2);
        System.out.println(student2 + "\n");
        
        Student student3 = new Student("Jessica", "Presentation", 3);
        System.out.println(student3);
        student3.changeSchool("Notre Dame");
        System.out.println(student3);
    }
}

class Student {
    private static String name;
    private static String school;
    private static int year;

    public Student(String studentName, String studentSchool, int studentYear) {
        name = studentName;
        school = studentSchool;
        year = studentYear;
    }

    public static void changeSchool(String newSchool) {
        school = newSchool;
        System.out.println(name + " transfered to " + school);
    }

    public String toString() {
        return name + " is currently attending their " + year + "th year at " + school;
    }
}