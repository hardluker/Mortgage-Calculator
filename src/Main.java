import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String [] args) {

        //Getting Principal, Annual Interest Rate, and Years
        double principal = readNumber("Principal: ", 1_000.00, 1_000_000.00);
        double annualInterestRate = readNumber("Annual Interest Rate: ", 0, 30);
        double years = readNumber("Years: ", 1, 40);

        //Calculating the mortgage payment
        double mortgagePayment = calculateMortgagePayment(principal, annualInterestRate, years);

        //Formatting and printing mortgage payment
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgagePayment);
        System.out.println("Monthly payment is " + mortgageFormatted);
    }



    //Method for getting values from the user input
    public static double readNumber(String prompt, double min, double max) {
        Scanner scanner = new Scanner(System.in);
        double value;
        while (true) {
            System.out.print(prompt);
            value = scanner.nextDouble();

            //Confirming value is within range
            if (value >= min && value <= max) {
                break;
            }
            System.out.println("Enter a value between " + min + "and " + max);
        }
        return value;
    }



    //Method for calculating Mortgage payment.
    public static double calculateMortgagePayment(double principal, double AnnualInterestRate, double years) {
        //Defining the monthly interest rate
        final float PERCENT = 100.00F;
        final int MONTHS_IN_YEAR = 12;
        double monthlyInterestRate = AnnualInterestRate / PERCENT / MONTHS_IN_YEAR;

        //Calculating the monthly payment
        return (principal * ((monthlyInterestRate * Math.pow(1.00 + monthlyInterestRate, years * 12))
                /(Math.pow(1.00 + monthlyInterestRate, years * 12) - 1)));

    }
}