package Transaction;

import Account.IAccount;

public class TransferTransaction extends Transaction{

    public TransferTransaction(IAccount sourceAccount, IAccount destinationAccount, Double amountToTransfer)
    {
        SourceAccountId = sourceAccount._accountID;
        TransactionAmount = amountToTransfer;
        DestinationAccountId = destinationAccount._accountID;
    }
}
