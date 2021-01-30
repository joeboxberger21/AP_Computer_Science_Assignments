//Joe Boxberger
//Loops-A2
/**
Main class
*/
public class ASCII_5Boxberger {
    public static void main(String[] args) {
        printChart();
    }

    public static void printChart() {
        for(int i = 32; i < 127; i++) {
            if (i < 100) {
                System.out.print(" " + i + " [ " + (char)i + " ]  | ");
            } else {
                System.out.print(i + " [ " + (char)i + " ]  | ");
            }
            //Move to next line and print divider after 5 table cells are printed
            if((i-31) % 5 == 0) {
                System.out.println("\n________________________________________________________________");
            }
        }
    }
}