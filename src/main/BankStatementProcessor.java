package src.main;

import java.time.Month;
import java.util.List;

public class BankStatementProcessor {

    private List<BankTransaction> bankTransactions;

    public BankStatementProcessor(List<BankTransaction> bankTransactions) {
        this.bankTransactions = bankTransactions;
    }

    public double calculateTotalAmount(List<BankTransaction> bankTransactions) {
        double total = 0d;
        for(BankTransaction bankTransaction: this.bankTransactions) {
            total += bankTransaction.getAmount();
        }
        return total;
    }

    public double calculateTotalInMonth(Month month) {
        double total = 0;

        for (BankTransaction bankTransaction : this.bankTransactions) {
            if (bankTransaction.getDate().getMonth() == month) {
                total += bankTransaction.getAmount();
            }
        }

        return total;
    }

    public double calculateTotalForCategory(String category) {
        double total = 0;
        for(BankTransaction bankTransaction: this.bankTransactions) {
            if(bankTransaction.getDescription().equals(category)) {
                total += bankTransaction.getAmount();
            }
        }
        return total;
    }

}
