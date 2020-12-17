package Transaction;

import Account.Account;

public class TransferTransaction extends Transaction{

    public TransferTransaction(Account sourceAccount, Account destinationAccount, Double amountToTransfer)
    {
//        TransactionType = TransactionType.Transfer;
        SourceAccountId = sourceAccount._accountID;
        TransactionAmount = amountToTransfer;
        DestinationAccountId = destinationAccount._accountID;
    }
}
