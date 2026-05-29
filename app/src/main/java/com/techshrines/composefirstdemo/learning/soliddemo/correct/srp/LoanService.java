package com.techshrines.composefirstdemo.learning.soliddemo.correct.srp;

public class LoanService {
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
