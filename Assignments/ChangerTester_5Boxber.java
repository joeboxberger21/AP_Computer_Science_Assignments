import java.util.Scanner;
public class ChangerTester_5Boxber {
    public static void main(String[] args){
        Register register = new Register();
        register.giveChange(499, 2050);
        register.giveChange(1999, 5227);
        register.giveChange(29999, 54321);

        Scanner input = new Scanner(System.in);
        System.out.print("Enter cost in pennies: ");
        int userCost = Integer.valueOf(input.nextLine()); 
        System.out.print("Enter money given in pennies: ");

        int userGiven = Integer.valueOf(input.nextLine()); 
        register.giveChange(userCost, userGiven);
    }

    public static class Register {
        private int change;

        public void giveChange(int cost, int moneyRecieved) {
            change = moneyRecieved - cost;
            int dollars = divideChange(100);
            int quarters = divideChange(25);
            int dimes = divideChange(10);
            int nickels = divideChange(5);
            int pennies = divideChange(1);
            System.out.println("The cashier needs to give the customer: " + dollars + " dollars, " + quarters + 
                " quarters, " + dimes + " dimes, " + nickels + " nickels and " + pennies + " pennies.");
        }
        public int divideChange(int currencyValue) {
            //divides change into number of currency type based on inputed value of the currency (ex. penny = 1, dollar = 100)
            int tempChange = change;
            change %= currencyValue;
            return tempChange / currencyValue;
        }
    }
}