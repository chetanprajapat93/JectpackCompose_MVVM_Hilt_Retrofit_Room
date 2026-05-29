package com.techshrines.composefirstdemo.learning.soliddemo.correct.dip;

public class DebitCard implements BankCard{
    @Override
    public void doTransaction(int amount) {
        System.out.println("DebitCard transaction Done "+ amount);
    }
}
