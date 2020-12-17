package Transaction;

import java.util.UUID;

public class AddingTransaction extends Transaction {

    public AddingTransaction(UUID sourceAccountId, Double amountToDeposit)
    {
        SourceAccountId = sourceAccountId;
        TransactionAmount = amountToDeposit;
    }
}
