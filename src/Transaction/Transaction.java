package Transaction;

import java.util.Date;
import java.util.UUID;

public abstract class Transaction {

    public UUID transactionId;
    public String TransactionTime;
    public UUID SourceAccountId;
    public Double TransactionAmount;
    public UUID DestinationAccountId;

    public Transaction()
    {
        transactionId = UUID.randomUUID();
        Date date = new Date();
        TransactionTime = date.toString();
    }

    public Double getTransactionAmount() {
        return TransactionAmount;
    }

    public UUID getTransactionId() {
        return transactionId;
    }

    public abstract String getType();

    public String getTime() {
        return TransactionTime;
    }

    public abstract void getList();
}