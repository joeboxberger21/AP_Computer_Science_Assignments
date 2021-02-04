import java.util.ArrayList;

public class StudentListTester_5Boxberger {
    public static void main(String[] args) {
      Student steve = new Student("Steve", 2, 64, 3.9, 26);
      Student john = new Student("John", 4, 70, 3.7, 53);
      Student cindy = new Student("Cindy", 3, 61, 4.0, 40);
      Student jess = new Student("Jessica", 4, 63, 3.4, 55);
      Student bob = new Student("Bob", 1, 73, 2.9, 13);

      john.reportGrade(2, 6.7);
      jess.reportGrade(4, 15.6);
      
      Team group = new Team("Robotics");

      group.add(steve);
      group.add(john);
      group.add(cindy);
      group.add(jess);
      group.add(bob);

      System.out.println(group);

      System.out.println("The tallest person on the " + group.getName() + " team is " + group.findTallest().getName());
    }
}

class Student {
    // instance variables
    private String name;
    private int year;
    private int height;  // in inches
    private double gpa;
    private int totalUnits;

    private double totalGradePoints;
    
    /**
      initializes instance variables 
    */
  public Student( String studentName, int year, int height, double gpa, int totalUnits) {
      name = studentName;
      this.year = year;
      this.height = height;
      this.gpa = gpa;
      this.totalUnits = totalUnits;
  }
    //mutator methods
    public void reportGrade(int units, double gradePointsEarned) {
        totalGradePoints = gpa * totalUnits;
        totalUnits += units;
        gpa = (totalGradePoints + gradePointsEarned) / totalUnits;
        gpa = Math.floor(gpa * 100d)/100d;
    }

    //accessor methods
    public int getYear() {
        return year;
    }
    public int getHeight() {
        return height;
    }
    public double getGpa() {
        return gpa;
    }
    public String getName() {
        return name;
    }
    //display instance variables
    public String toString() {
      return "[Student: " + name + "], [Year: " + year + "], [Height: " + height + " inches], [GPA: " + gpa + "]";
    }
}

  /**
     Represents a collection/team of students
  */
class Team {
    private ArrayList<Student> roster = new ArrayList<Student>();
    private String allNames = "";
    private String name;

    private int tallestIndex = 0;
    private int maxHeight;

    public Team(String name) {
      this.name = name;
    }

    //mutator methods
    public void add(Student newStudent) {
        roster.add(newStudent);
    }

    public Student findTallest() {
      maxHeight = roster.get(0).getHeight();
      for(int i = 0; i < roster.size(); i++) {
        if (roster.get(i).getHeight() > maxHeight) {
          maxHeight = roster.get(i).getHeight();
          tallestIndex = i;
        }
      }
      return roster.get(tallestIndex);
    }

    //accessor methods
    public String getName() {
      return name;
    }

    public String toString() {
        for(int i = 0; i < roster.size(); i++) {
            allNames += roster.get(i) + "\n";
        }
        return name + " Roster: \n" + allNames;
    }
}