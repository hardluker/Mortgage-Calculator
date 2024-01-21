import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String [] args) {

        //Declaring constants to avoid magic numbers
        final float PERCENT = 100.00F;
        final int MONTHS_IN_YEAR = 12;

        //Creating the scanner
        Scanner scanner = new Scanner(System.in);

        //Getting Principal Value
        System.out.print("Principal: ");
        double principal = scanner.nextInt();

        //Getting Interest rate
        System.out.print("Interest Rate: ");
        double monthlyInterestRate = (scanner.nextDouble() / PERCENT / MONTHS_IN_YEAR);

        //Getting the period in years
        System.out.print("Number of Years: ");
        double years = scanner.nextInt();

        //Running method for monthly payment calculation
        double monthlyPayment = calculateMortgagePayment(principal, monthlyInterestRate, years);

        //Formatting and printing monthly payment
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(monthlyPayment);
        System.out.println("Monthly payment is " + mortgageFormatted);



    }

    //Method for calculating monthly payment.
    static double calculateMortgagePayment(double principal, double interestRate, double years) {
        return (principal * ((interestRate * Math.pow(1.00 + interestRate, years * 12))
                /(Math.pow(1.00 + interestRate, years * 12) - 1)));
    }
}