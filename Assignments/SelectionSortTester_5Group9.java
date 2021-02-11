public class SelectionSortTester_5Group9 {
    public static void main(String[] args) {
      int[] arr1 = { 1, 2, 3, 4, 5, 9 };
      int[] arr2 = { 11, 2, 3, 4, 5, 9 }; 
      int[] arr3 = { 11, 9, 8, 4, 3, 1 }; 

      arr1 = selectionSort( arr1 );
      print( arr1 );
      arr2 = selectionSort( arr2 );
      print( arr2 );
      arr3 = selectionSort( arr3 );
      print( arr3 ); 
    }

    /**
        Sorts the array passed in from largest to smallest.
        @return the sorted array (note that it is the same as the array passed in)
    */
    public static int[] selectionSort(int[] arr) {
      for (int i = arr.length - 1; i > 0; i--) {
        int smallestIndex = 0;
        //find smallestIndex on current selection of array
        for (int j = 1; j <= i; j++) {
          if (arr[j] < arr[smallestIndex]) {
            smallestIndex = j;
          }
        }
  
        //Swap smallest index with last index
        int temp = arr[i];
        arr[i] = arr[smallestIndex];
        arr[smallestIndex] = temp;
      }
      return arr;
    }

    public static void print(int[] arr) {
        System.out.print("[");
        for (int i : arr) {
            System.out.print(i + ", ");
        }
        System.out.println("]");
    }
}