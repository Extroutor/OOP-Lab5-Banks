package Transaction;

import java.util.UUID;

public class WithdrawTransaction extends Transaction{

    public WithdrawTransaction(UUID sourceAccountId, Double amountToWithdraw)
    {
        SourceAccountId = sourceAccountId;
        TransactionAmount = amountToWithdraw;
    }
}
