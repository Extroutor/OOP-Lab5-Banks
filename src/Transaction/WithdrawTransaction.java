package Transaction;

import java.util.UUID;

public class WithdrawTransaction extends Transaction {

    public String typeOfTransaction = "Withdraw";

    public WithdrawTransaction(UUID sourceAccountId, Double amountToWithdraw) {
        SourceAccountId = sourceAccountId;
        TransactionAmount = amountToWithdraw;
    }

    @Override
    public String getType() {
        return typeOfTransaction;
    }

    @Override
    public void getList() {
        System.out.println(getType() + "\n");
        System.out.println("Id transaction ID: " + getTransactionId());
        System.out.println("Date: " + getTime());
        System.out.println("Transaction amount: " + getTransactionAmount() + "\n");
    }
}