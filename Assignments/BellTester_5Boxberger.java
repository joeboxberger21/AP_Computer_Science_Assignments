/**
 * AList-A3: ArrayList Bk Pgm
 * @author Joe Boxberger
*/

import java.util.ArrayList;

public class BellTester_5Boxberger {
    public static void main(String[] args) {
        ArrayList<Bell> students = new ArrayList<Bell>();

        Bell adam = new Bell(221);
        Bell matt = new Bell(141);
        Bell steve = new Bell(526);
        Bell greg = new Bell(897);
        Bell ralph = new Bell(174);
        Bell peter = new Bell(376);
        Bell larry = new Bell(643);
        Bell daniel = new Bell(872);
        Bell joe = new Bell(903);
        Bell tyler = new Bell(202);

        students.add(adam);
        students.add(matt);
        students.add(steve);
        students.add(greg);
        students.add(ralph);
        students.add(peter);
        students.add(larry);
        students.add(daniel);
        students.add(joe);
        students.add(tyler);

        System.out.println("All students: " + students);

        evenIndex(students);
        evenIds(students);
        firstAndLast(students);
    }

    public static void evenIndex(ArrayList<Bell> students) {
        //Print every element at an even index
        System.out.print("Students at even indexes: ");
        for (int i = 0; i < students.size(); i += 2) {
            System.out.print("[" + students.get(i) + "] ");
        }
        System.out.println("");
    }

    public static void evenIds(ArrayList<Bell> students) {
        //Print every student with an even id
        System.out.print("Students with even id's: ");
        for (Bell student : students) {
            if(student.id() % 2 == 0) {
                System.out.print("[" + student + "] ");
            }
        } 
        System.out.println("");
    }

    public static void firstAndLast(ArrayList<Bell> students) {
        //First and last elements
        System.out.println("First and Last Students: [" + students.get(0) + "] and [" + students.get(students.size() - 1) + "]");
    }
}

/**
 * Class that represents a Bellarmine student with a student id
 */
class Bell 
{
  private int studentId;

  public Bell( int id )
  {
     studentId = id;
  }

  public int id()
  {
     return studentId;
  }

  public int compareTo( Bell otherBell )
  {
     return studentId - otherBell.id();
  }
  public String toString() 
  {
     return "" + studentId;
  }
} 