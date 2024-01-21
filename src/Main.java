import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    final static byte PERCENT = 100;
    final static byte MONTHS_IN_YEAR = 12;
    public static void main(String [] args) {

        //Getting Principal, Annual Interest Rate, and Years
        double principal = readNumber("Principal: ", 1_000.00, 1_000_000.00);
        float annualInterestRate = (float)readNumber("Annual Interest Rate: ", 0, 30);
        byte years = (byte)readNumber("Years: ", 1, 40);

        //Calculating and printing the mortgage payment
        printMortgage(principal, annualInterestRate, years);

        printPaymentSchedule(years, principal, annualInterestRate);
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



    //Method for calculating the balance through the iterations of the payment schedule
    public static double calculateBalance(double principal, float annualInterestRate, byte years, short numberOfPaymentsMade) {
        float monthlyInterestRate = annualInterestRate / PERCENT / MONTHS_IN_YEAR;
        float numberOfPayments = years * MONTHS_IN_YEAR;

        return principal
                *(Math.pow(1 + monthlyInterestRate, numberOfPayments) - Math.pow(1 + monthlyInterestRate, numberOfPaymentsMade))
                / (Math.pow(1 + monthlyInterestRate, numberOfPayments) - 1);
    }


    //Method for calculating Mortgage payment.
    public static double calculateMortgagePayment(double principal, float annualInterestRate, byte years) {
        //Defining the monthly interest rate
        float monthlyInterestRate = annualInterestRate / PERCENT / MONTHS_IN_YEAR;
        float numberOfPayments = years * MONTHS_IN_YEAR;

        //Calculating the monthly payment
        return (principal * ((monthlyInterestRate * Math.pow(1.00 + monthlyInterestRate, numberOfPayments))
                /(Math.pow(1.00 + monthlyInterestRate, numberOfPayments) - 1)));

    }

    //Method for formatting and printing the mortgage payment
    public static void printMortgage(double principal, float annualInterestRate, byte years) {
        double mortgagePayment = calculateMortgagePayment(principal, annualInterestRate, years);
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgagePayment);
        System.out.println();
        System.out.println("MORTGAGE");
        System.out.println("--------");
        System.out.println("Monthly payment: " + mortgageFormatted);
    }


    //Method for formatting and printing the payment schedule
    public static void printPaymentSchedule(byte years, double principal, float annualInterestRate) {
        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("----------------");
        for (short month = 1; month <= years * MONTHS_IN_YEAR; month++) {
            double balance = calculateBalance(principal, annualInterestRate, years, month);
            System.out.println(NumberFormat.getCurrencyInstance().format(balance));
        }
    }


}