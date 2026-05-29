package com.techshrines.composefirstdemo.learning.soliddemo.wrong.srp;

/**
 * Single Responsibilty principle Violation:
 * “a class should have only one reason to change”
 * which means every class should have a single responsibility
 * or single job or single purpose
 */
public class BankService {
    public void deposit(int amount, String accountNo){
        System.out.println("Amount deposited");
    }
    public void withdraw(int amount, String accountNo){
        System.out.println("Amount withdrawn");
    }
    public void printPassbook(String accountNo){
        System.out.println("Passbook Printed");
    }
    public double getInterestRate(String loanType){
        if(loanType.equals("Home")){
            return 6.5;
        }else if(loanType.equals("Car")){
            return 7.5;
        }else {
            return 8.9;
        }
    }
}
