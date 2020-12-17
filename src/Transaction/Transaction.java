package Transaction;

import java.util.Date;
import java.util.UUID;

public class Transaction {

    public UUID transactionId;
    public long TransactionTime;
    public UUID SourceAccountId;
    public Double TransactionAmount;
    public UUID DestinationAccountId;

    public Transaction()
    {
        transactionId = UUID.randomUUID();
        Date date = new Date();
        TransactionTime = date.getTime();
    }
}