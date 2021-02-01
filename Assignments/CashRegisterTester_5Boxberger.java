import java.util.Scanner;
/**
    LoopsA4 Bell Market Coin changer
    @author Joe Boxberger
*/

/**
 Test out Cash Register allowing user to do several transactions each with several purchases.
 */
public class CashRegisterTester_5Boxberger {
    public static void main(String args[]) {
		//Opening banner	
		System.out.println("Bell Market Coin Changer \nCashRegisterTester_5Boxberger.java \n\tCreated By: Joe Boxberger");
        CashRegister bellMarketCoinChanger = new CashRegister(100, 100, 100, 150);
		System.out.println(bellMarketCoinChanger);
		bellMarketCoinChanger.run();
		System.out.println(bellMarketCoinChanger);
    }
}

/**
 represents a cash register keeps track of coins and totals items purchased, and calculates correct change
*/
class CashRegister {
	//instance variables
    private int pennies = 0;
    private int quarters = 0;
    private int nickels = 0;
    private int dimes = 0;
  
	private boolean stillCustomers = true;
	private int total = 0;
	private int change = 0;
	final double EPSILON = 0.0001;
	
    /**
     Constructors
    */

    public CashRegister(int pennies, int nickels, int dimes, int quarters) {
        this.pennies = pennies;
        this.nickels = nickels;
        this.dimes = dimes;
		this.quarters = quarters;
    }

    public CashRegister() {
        //calls other constructor with these args
        this(100, 100, 100, 250);
    }
    

    /**
    Methods
    */

	/**
		Mutators
	*/

    /**
	total purchased item in cents
	*/
    public void purchase(double amount) {
       total += (int)(amount * 100 + EPSILON);
	}

	/**
	Calculate change
	*/
	public void recievePayment(double payment) {
		
		int penniesRecieved = (int)(payment*100 + EPSILON);
		change = penniesRecieved - total;

		//divides change into number of currency type based on inputed value of the currency (ex. penny = 1, dollar = 100)
		int quartersChange = divideChange(25);
		int dimesChange = divideChange(10);
		int nickelsChange = divideChange(5);
		int penniesChange = divideChange(1);
		if (quarters >= quartersChange && dimes >= dimesChange && nickels >= nickelsChange &&  pennies >= penniesChange) {
			quarters -= quartersChange;
			dimes -= dimesChange;
			nickels -= nickelsChange;
			pennies -= penniesChange;
		} else {
			System.out.println("ERROR. The resiger does not have enough change, shutting down.");
			return;
		}
		System.out.println("You were given: " + quartersChange + " quarter(s), " + dimesChange + " dime(s), " + nickelsChange + " nickel(s), and " + penniesChange + " penny/pennies as change.");
	}

	public int divideChange(int currencyValue) {
		//divides change into number of currency type based on inputed value of the currency (ex. penny = 1, dollar = 100)
		int tempChange = change;
		change %= currencyValue;
		return tempChange / currencyValue;
	}

	/**
	user inputs items they want to buy, totals price from purchases, displays total and recevies payment, gives correct amount of change
	*/
	 public void run() {
		Scanner input = new Scanner(System.in);
		while(stillCustomers) {
			System.out.print("Input the price of the item you want to buy: ");
			purchase(input.nextDouble());
			System.out.print("Would you like to continue shopping? Y/N: ");
			input.nextLine(); //clear input buffer
			String userDescision = input.nextLine();
			while (!userDescision.toUpperCase().equals("Y") && !userDescision.toUpperCase().equals("N")) {
				System.out.print("Invalid Input. Would you like to continue shopping? Y/N: ");
				userDescision = input.nextLine();
			}
			if (userDescision.toUpperCase().equals("N")) stillCustomers = false;
		}
		total();

		//recieve money
		System.out.print("Input the amount of money you want to give: ");
		recievePayment(input.nextDouble());
	 }

	/**
		Accessors
	*/

	/**
	Print and return total
	*/
     public double total() {
		double realTotal = total/100.00;
		System.out.printf("Total amount due: %.2f %n", realTotal);
        return realTotal;
	 }
	 
     public String toString() {
        return "The Cash Register has: " + quarters + " quaters, " + dimes + " dimes, " + nickels + " nickels, and " + pennies + " pennies";
     }
}
