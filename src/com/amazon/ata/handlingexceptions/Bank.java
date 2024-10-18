package com.amazon.ata.handlingexceptions;

import java.math.BigDecimal;

import com.amazon.ata.handlingexceptions.exceptions.InsufficientFundsException;
import com.amazon.ata.handlingexceptions.exceptions.TransactionException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * This class represents a bank, which includes the functionality to transfer from
 * one BankAccount to another.
 */
public class Bank {
    private Logger log = LogManager.getLogger(Bank.class);

    /**
     * Transfer money from one account to another. 
     * 
     * @param fromAccount BankAccount to withdraw amount from
     * @param toAccount BankAccount to deposit amount into
     * @param amount of money to transfer.
     * @return true if transfer was successful, false if transfer fails due to insufficient funds
     */
    public boolean transfer(BankAccount fromAccount, BankAccount toAccount, BigDecimal amount) throws TransactionException {

        boolean isSuccessful;

        try {
            fromAccount.withdraw(amount);
            toAccount.deposit(amount);
        } catch(InsufficientFundsException e) {
            isSuccessful = false;
            return isSuccessful;
        }

        isSuccessful = true;

        return isSuccessful;
    }
}
