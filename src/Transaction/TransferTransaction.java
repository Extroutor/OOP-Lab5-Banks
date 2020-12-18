package Transaction;

import Account.IAccount;

public class TransferTransaction extends Transaction {

    public String typeOfTransaction = "Transfer";

    public TransferTransaction(IAccount sourceAccount, IAccount destinationAccount, Double amountToTransfer) {
        SourceAccountId = sourceAccount._accountID;
        TransactionAmount = amountToTransfer;
        DestinationAccountId = destinationAccount._accountID;
    }

    public String getType() {
        return typeOfTransaction;
    }

    @Override
    public void getList() {
        System.out.println(getType() + "\n");
        System.out.println("Id transaction ID: " + getTransactionId());
        System.out.println("Date: " + getTime());
        System.out.println("Transfer amount: " + getTransactionAmount() + "\n");
    }
}

