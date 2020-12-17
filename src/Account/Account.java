package Account;

import Transaction.Transaction;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public interface Account {

    //AccountType AccountType = null;
    UUID _accountID = null;

    HashMap<Long, Double> DailyProfitList = null;
    ArrayList<Transaction> TransactionsList = null;
    void Withdraw(Double amountToWithdraw) throws Exception;
    void Deposit(Double amountToDeposit) throws Exception;
    void CalculateDailyProfit(Long day) throws Exception;
    Double CalculateMonthlyProfit() throws Exception;
}
