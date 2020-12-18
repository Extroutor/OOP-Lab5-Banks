package Account;

import Transaction.Transaction;
import java.util.ArrayList;
import java.util.UUID;

public interface IAccount {

    ArrayList<Transaction> TransactionsList = new ArrayList<>();
    UUID _accountID = null;
    void withdraw(Double amountToWithdraw) throws Exception;
    void deposit(Double amountToDeposit) throws Exception;
    void calculateDailyPercent(Long day) throws Exception;
    Double calculateMonthlyPercent() throws Exception;
    void listOfTransactions(IAccount account);
}
