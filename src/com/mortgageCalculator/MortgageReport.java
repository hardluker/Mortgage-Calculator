package com.mortgageCalculator;
import java.text.NumberFormat;

public class MortgageReport {

    private final NumberFormat currency;
    private MortgageCalculator calculator;

    // Constructor
    public MortgageReport(MortgageCalculator calculator) {
        this.calculator = calculator;
        currency = NumberFormat.getCurrencyInstance();
    }

    //Method to print the payment schedule
    public void printPaymentSchedule() {
        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("----------------");

        //Iterates through the payments array and prints them.
        for (double balance: calculator.getRemainingBalances())
            System.out.println(currency.format(balance));
    }

    //Method for formatting and printing the mortgage payment
    public void printMortgage() {
        double mortgagePayment = calculator.calculateMortgagePayment();
        String mortgageFormatted = currency.format(mortgagePayment);
        System.out.println();
        System.out.println("MORTGAGE");
        System.out.println("--------");
        System.out.println("Monthly payment: " + mortgageFormatted);
    }
}