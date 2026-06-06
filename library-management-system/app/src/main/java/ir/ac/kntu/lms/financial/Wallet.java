package ir.ac.kntu.lms.financial;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Wallet {
    private static final int MAX_TRANSACTION_DISPLAYED = 10;
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private final List<TransactionInfo> transactions = new ArrayList<> ();
    private double balance;

    public void deposit(double value) {
        if (value < 0) {
            System.out.println("Operation failed: Value must be positive.");
            return;
        }

        balance += value;
        transactions.add(new TransactionInfo(value, Type.DEPOSIT, LocalDateTime.now()));
    }

    public boolean withdrawal(double value) {
        if (value < 0) {
            System.out.println("Operation failed: Value must be positive.");
            return false;
        }

        if (Double.compare(balance, value) == -1) {
            System.out.println("You don't have enough money in your wallet.");
            return false;
        }

        this.balance -= value;
        transactions.add(new TransactionInfo(value, Type.WITHDRAWAL, LocalDateTime.now()));
        return true;
    }

    public void displayTransactions(int numberOfTransaction) {
        System.out.println("Your Last " + numberOfTransaction + " Transcation: ");
        int counter = 0;
        for (int index = transactions.size() - 1; index >= 0; index --) {
            if (counter >= numberOfTransaction) {
                break;
            }
            counter ++;
            System.out.println(counter + transactions.get(index).toString());
        }
    }

    public void displayTransactions() {   // overloading method for using default value
        this.displayTransactions(MAX_TRANSACTION_DISPLAYED); 
    }

    public double getBalance() {
        return balance;
    }

    public List<TransactionInfo> filterTransactionByDate(String start, String stop) {
        List<TransactionInfo> filteredTransactions = new ArrayList<>();
        LocalDateTime startDate = LocalDateTime.parse(start, formatter).withNano(0);
        LocalDateTime stopDate = LocalDateTime.parse(stop, formatter).withNano(0);
        if (startDate.isAfter(stopDate)) {return filteredTransactions;}

        for (TransactionInfo t: transactions){
            boolean isBetween = t.getDateTime().isAfter(startDate) && t.getDateTime().isBefore(stopDate);
            boolean isEqual = t.getDateTime().isEqual(stopDate) || t.getDateTime().isEqual(startDate);
            if (isBetween || isEqual) {
                filteredTransactions.add(t);
            }
        }

        return filteredTransactions;
    }
        
    public List<TransactionInfo> filterTransactionFrom(String start) {
        return this.filterTransactionByDate(start, LocalDateTime.now().format(formatter));
    }

    public List<TransactionInfo> filterTransactionTo(String stop) {
        if (transactions.isEmpty()) {
            System.out.println("You don't have any transaction");
            return new ArrayList<>();
        }
        
        return this.filterTransactionByDate(transactions.get(0).getDateTime().format(formatter), stop);
    }
}


