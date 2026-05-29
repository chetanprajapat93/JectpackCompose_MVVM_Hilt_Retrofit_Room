package com.techshrines.composefirstdemo.learning.soliddemo.correct.dip;

public class Shopping {
    BankCard bankCard;
    public Shopping(BankCard bankCard){
        this.bankCard = bankCard;
    }
    public void doTransaction(int amount) {
        bankCard.doTransaction(amount);
    }

    public static void main(String args[]){
        BankCard creditCard = new CreditCard();
        BankCard debitCard = new DebitCard();
        Shopping shoppingCreditCard = new Shopping(creditCard);
        Shopping shoppingDebitCard = new Shopping(debitCard);
        shoppingCreditCard.doTransaction(1000);
        shoppingDebitCard.doTransaction(2000);
    }
}
