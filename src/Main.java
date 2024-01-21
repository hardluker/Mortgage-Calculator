import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String [] args) {
        //Declaring constants to avoid magic numbers
        final float PERCENT = 100.00F;
        final int MONTHS_IN_YEAR = 12;

        //Creating the scanner
        Scanner scanner = new Scanner(System.in);

        //Getting Principal Value with error handling
        double principal;
        while(true){
            System.out.print("Principal: ");
            principal = scanner.nextInt();

            //Confirming principal is between 1,000 and 100,000,000.
            if (principal >= 1_000.00 && principal <= 100_000_000.00){
                break;
            }
                System.out.println("Principal must be between 1,000 - 100,000,000");
        }


        //Getting Interest rate with error handling.
        double monthlyInterestRate;
        while (true) {
            System.out.print("Interest Rate: ");
            double interestRate = scanner.nextDouble();

            //Confirming interest rate is between 0 and 30 otherwise.
            if (interestRate > 0.00 && interestRate <= 30.00) {
                monthlyInterestRate = (interestRate / PERCENT / MONTHS_IN_YEAR);
                break;
            }
                System.out.println("Interest rate must be between 0.00 - 30.00");
        }

        //Getting the period in years.
        double years;
        while (true) {
            System.out.print("Number of Years: ");
            years = scanner.nextDouble();

            //Confirming years is between 1 and 40.
            if (years >= 1.00 && years <= 40.00) {
                break;
            }
            System.out.println("Years must be between 1 - 40");
        }

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