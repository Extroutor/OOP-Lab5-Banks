package Transaction;

import java.util.UUID;

public class AddingTransaction extends Transaction {

    public String typeOfTransaction = "Deposit";


    public AddingTransaction(UUID sourceAccountId, Double amountToDeposit)
    {
        SourceAccountId = sourceAccountId;
        TransactionAmount = amountToDeposit;
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
