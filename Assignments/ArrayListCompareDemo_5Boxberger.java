import java.util.ArrayList;
class ArrayListCompareDemo_5Boxberger {
    public static void main(String[] args) {
        ArrayList<String> aList = new ArrayList<String>();
        aList.add("Hello");
        aList.add("Test");
        aList.add("Supercalifragilisticexpialidocious");
        aList.add("AP Computer Science");
        aList.add("Keyboard");

        for (int i = 0; i < aList.size(); i++) {
            System.out.println(aList.get(i));
        }

        aList.remove(1);
        aList.set(3, "Mouse");
        aList.add(1, "Bye");

        for (String item:aList) {
            System.out.println(item);
        }

        System.out.println("Largest: " + findMax(aList));
    }
    public static String findMax(ArrayList<String> list) {
        String largest = list.get(0);
        for(String item:list) {
            if (largest.compareTo(item) < 0) {
                largest = item;
            }
        }
        return largest;
    }
}