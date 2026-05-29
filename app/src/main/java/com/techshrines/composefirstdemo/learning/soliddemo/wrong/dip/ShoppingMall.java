package com.techshrines.composefirstdemo.learning.soliddemo.wrong.dip;

public class ShoppingMall {
    CreditCard creditCard;
    DebitCard debitCard;
    public ShoppingMall(CreditCard creditCard){
        this.creditCard = creditCard;
    }

    public ShoppingMall(DebitCard debitCard){
        this.debitCard = debitCard;
    }
    public void doTransaction(int amount){
        creditCard.doTransaction(amount);
    }
}
