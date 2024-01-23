package com.mortgageCalculator;

public class MortgageCalculator {
    private final static byte MONTHS_IN_YEAR = 12;
    private final static byte PERCENT = 100;

    private double principal;
    private float annualInterestRate;
    private byte years;

    //Constructor
    public MortgageCalculator(double principal, float annualInterestRate, byte years) {
        this.principal = principal;
        this.annualInterestRate = annualInterestRate;
        this.years = years;
    }

    //Method for calculating the remaining balance after a certain number of payments was made.
    public double calculateBalance(short numberOfPaymentsMade) {
        float monthlyInterestRate = getMonthlyInterestRate();
        float numberOfPayments = getNumberOfPayments();

        return principal
                * (Math.pow(1 + monthlyInterestRate, numberOfPayments) - Math.pow(1 + monthlyInterestRate, numberOfPaymentsMade))
                / (Math.pow(1 + monthlyInterestRate, numberOfPayments) - 1);
    }


    //Method for calculating the mortgage payment
    public double calculateMortgagePayment() {
        //Defining the monthly interest rate
        float monthlyInterestRate = getMonthlyInterestRate();
        float numberOfPayments = getNumberOfPayments();

        //Calculating the monthly payment
        return (principal * ((monthlyInterestRate * Math.pow(1.00 + monthlyInterestRate, numberOfPayments))
                / (Math.pow(1.00 + monthlyInterestRate, numberOfPayments) - 1)));

    }

    public double[] getRemainingBalances() {
        double[] balances = new double[getNumberOfPayments()];
        for (short month = 1; month <= balances.length; month++)
            balances[month - 1] = calculateBalance(month);

        return balances;
    }


    //Private Getter for numberOfPayments
    private int getNumberOfPayments() {
        return years * MONTHS_IN_YEAR;
    }

    //Private Getter for monthlyInterestRate
    private float getMonthlyInterestRate() {
        return annualInterestRate / PERCENT / MONTHS_IN_YEAR;
    }
}
