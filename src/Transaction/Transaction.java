package Transaction;

import java.util.Date;
import java.util.UUID;

public class Transaction {

//    public TransactionType TransactionType;
    public UUID TransactionId;
    public long TransactionTime;
    public UUID SourceAccountId;
    public UUID SourceBankId;
    public Double TransactionAmount;
    public UUID DestinationBankId;
    public UUID DestinationAccountId;
    public boolean IsCanceled;

    public Transaction()
    {
        TransactionId = UUID.randomUUID();
        Date date = new Date();
        TransactionTime = date.getTime();
    }
}