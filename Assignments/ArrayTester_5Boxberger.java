public class ArrayTester_5Boxberger {
    public static void main(String[] args) {
        int[] nums = {1, 5, 22, 15, 0, 9};
        String[] words = {"to", "be", "not", "aardvark", "scintillating"};
        testNums(nums);
        testStrings(words);
    }

    public static void testNums(int[] numArray) {
        int largestNum = 0;
        System.out.println("Second element: " + numArray[1]);
        System.out.println("Last element: " + numArray[numArray.length -1]);
        for(int i = 0; i < numArray.length; i++) {
            if (numArray[i] > largestNum) largestNum = numArray[i];
        }
        System.out.println("Largest element: " + largestNum);
    }

    public static void testStrings(String[] stringArray) {
        System.out.println("Last element: " + stringArray[stringArray.length -1]);
        System.out.print("Content of array: ");
        for(int i = 0; i < stringArray.length; i++) {
            System.out.print(stringArray[i] + " ");
        }
        System.out.println();
        for(int i = 0; i < stringArray.length; i++) {
            System.out.println("Length of " + stringArray[i] + ": " + stringArray[i].length());
        }
    }
}
