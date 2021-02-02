import java.util.ArrayList;

public class MinTester_5BoxbergerSpencer {
    public static void main(String[] args) {
    ArrayList<Integer> stuff = new ArrayList<Integer>();
    stuff.add(-2);
    stuff.add(12);
    stuff.add(22);
    stuff.add(17);
    stuff.add(19);
    stuff.add(-10);
    stuff.add(-2);
    System.out.println("Test 1: 2nd smallest is: " + find2ndMin(stuff) );
    
    stuff.clear();
    stuff.add(-2);
    stuff.add(12);
    stuff.add(22);
    stuff.add(17);
    stuff.add(19);
    stuff.add(-1);
    stuff.add(-2);
    System.out.println("Test 2: 2nd smallest is: " + find2ndMin(stuff) );
    
    stuff.clear();
    stuff.add(-2);
    stuff.add(12);
    stuff.add(22);
    stuff.add(17);
    stuff.add(19);
    stuff.add(-1);
    stuff.add(999999);
    System.out.println("Test 3: 2nd smallest is: " + find2ndMin(stuff) );

    stuff.clear();
    stuff.add(5);
    stuff.add(4);
    stuff.add(3);
    stuff.add(2);
    stuff.add(1);
    stuff.add(1);
    System.out.println("Test 4: 2nd smallest is: " + find2ndMin(stuff) );
    }

    public static int find2ndMin(ArrayList<Integer> ints) {
        //Find smallest
        int smallest = ints.get(0);
        for(int i = 0; i < ints.size(); i++) {
            if (ints.get(i) < smallest) {
                smallest = ints.get(i);
            }
        }
        
        //Make sure the second number we start with isn't already the smallest (if it is the smallest then we will never find a value that is less than it, and loop will not work)
        int secondSmallest = ints.get(0);
        for (int num:ints) {
            secondSmallest = num;
            if (secondSmallest != smallest) break;
        }

        //Loop again, but this time ignore values that are equal to the smallest, making the value we find the second smallest 
        for(int i = 0; i < ints.size(); i++) {
            if (ints.get(i) < secondSmallest && ints.get(i) != smallest) {
                secondSmallest = ints.get(i);
            }
        }
        return secondSmallest;
    }
}