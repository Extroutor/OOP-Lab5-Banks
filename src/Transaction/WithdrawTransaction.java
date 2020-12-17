package Transaction;

import java.util.UUID;

public class WithdrawTransaction extends Transaction{

    public WithdrawTransaction(UUID sourceAccountId, Double amountToWithdraw)
    {
//        TransactionType = TransactionType.Withdraw;
        SourceAccountId = sourceAccountId;
        TransactionAmount = amountToWithdraw;
    }
}
