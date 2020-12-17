package Command;

import Account.Account;
import Transaction.TransferTransaction;

public class Transfer implements ICommand{

    private double _amountForTransfer;
    private Account _accountFROM;
    private Account _accountTO;
    private TransferTransaction _transfer;


    public Transfer(Account accountFROM, Account accountTO, double amountForTransfer) {
        _accountFROM = accountFROM;
        _accountTO = accountTO;
        _amountForTransfer = amountForTransfer;
    }

    @Override
    public void Execute() throws Exception {
        _accountFROM.Withdraw(_amountForTransfer);
        _accountTO.Deposit(_amountForTransfer);
        _transfer = new TransferTransaction(_accountFROM, _accountTO, _amountForTransfer);
        _accountFROM.TransactionsList.add(_transfer);
        _accountTO.TransactionsList.add(_transfer);
    }

    @Override
    public void Undo() throws Exception {
        _accountFROM.Deposit(_amountForTransfer);
        _accountTO.Withdraw(_amountForTransfer);
        _accountFROM.TransactionsList.remove(_transfer);
        _accountTO.TransactionsList.remove(_transfer);
    }
}
