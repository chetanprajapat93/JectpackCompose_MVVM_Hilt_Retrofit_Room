package com.techshrines.composefirstdemo.learning.soliddemo.correct.dip;

public class CreditCard implements BankCard{
    @Override
    public void doTransaction(int amount) {
        System.out.println("Credit transaction Done "+ amount);
    }
}
