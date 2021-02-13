public class SelSort2Tester_5Boxberger {
        public static void main(String[] args) {
        String[] arr1 = {"maria", "stacy", "imelda", "beth", "sarah"};
        String[] arr2 = {"steve", "john", "bobby", "frank", "bartholomew"};
        String[] arr3 = {"a", "aaa", "aa", "aaaa", "aaaaaaaa", "aaa", "aaaaaa"};

        arr1 = selectionSort( arr1 );
        print( arr1 );
        arr2 = selectionSort( arr2 );
        print( arr2 );
        arr3 = selectionSort( arr3 );
        print( arr3 ); 
    }

    /**
        Sorts the array passed in from smallest to largest.
        @return the sorted array (note that it is the same as the array passed in)
    */
    public static String[] selectionSort(String[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
          int largestIndex = 0;
          //find largestIndex on current selection of array
          for (int j = 1; j <= i; j++) {
            if (arr[j].compareTo(arr[largestIndex]) > 0) {
              largestIndex = j;
            }
          }
    
          //Swap largest element with last index
          String temp = arr[i];
          arr[i] = arr[largestIndex];
          arr[largestIndex] = temp;
        }
        return arr;
      }
      
      /**
       * Prints the array on one line
       * @param arr - array that gets printed out to the console
       */
      public static void print(String[] arr) {
          System.out.print("[");
          for (String s : arr) {
              System.out.print(s + ", ");
          }
          System.out.println("]");
      }
}
