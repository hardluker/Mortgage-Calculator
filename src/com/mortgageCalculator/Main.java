package com.mortgageCalculator;

public class Main {
    public static void main(String [] args) {

        //Getting Principal, Annual Interest Rate, and Years
        double principal = Console.readNumber("Principal: ", 1_000.00, 1_000_000.00);
        float annualInterestRate = (float) Console.readNumber("Annual Interest Rate: ", 0, 30);
        byte years = (byte) Console.readNumber("Years: ", 1, 40);

        //Instantiating a calculator with values for calculation
        var calculator = new MortgageCalculator(principal, annualInterestRate, years);

        //Instantiating MortgageReport and running reports.
        var report = new MortgageReport(calculator);
        report.printMortgage();
        report.printPaymentSchedule();
    }
}