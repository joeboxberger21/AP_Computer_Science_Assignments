public class test {
    public static void main(String[] args) {
      int[] arr2 = { 11, 2, 3, 4, 5, 9 };
      for (int i : selectionSort(arr2)) {
        System.out.print(i + ", ");
      }
    }

    public static int[] selectionSort(int[] arr) {
      for (int i = arr.length - 1; i > 0; i--) {
        int smallestIndex = 0;
        //find smallestIndex on current selection of array
        for (int j = 1; j <= i; j++) {
          if (arr[j] < arr[smallestIndex]) {
            smallestIndex = j;
          }
        }
  
        //Swap smallest index with number last index
        System.out.println("Swapping small: " + arr[smallestIndex] + " and end: " + arr[i]);
        int temp = arr[i];
        arr[i] = arr[smallestIndex];
        arr[smallestIndex] = temp;
      }
      return arr;
    }
}