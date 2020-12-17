package Command;

import Account.IAccount;
import Transaction.TransferTransaction;

public class Transfer implements ICommand{

    private double _amountForTransfer;
    private IAccount _accountFROM;
    private IAccount _accountTO;
    private TransferTransaction _transfer;


    public Transfer(IAccount accountFROM, IAccount accountTO, double amountForTransfer) {
        _accountFROM = accountFROM;
        _accountTO = accountTO;
        _amountForTransfer = amountForTransfer;
    }

    @Override
    public void execute() throws Exception {
        _accountFROM.withdraw(_amountForTransfer);
        _accountTO.deposit(_amountForTransfer);
        _transfer = new TransferTransaction(_accountFROM, _accountTO, _amountForTransfer);
        _accountFROM.TransactionsList.add(_transfer);
        _accountTO.TransactionsList.add(_transfer);
    }

    @Override
    public void undo() throws Exception {
        _accountFROM.deposit(_amountForTransfer);
        _accountTO.withdraw(_amountForTransfer);
        _accountFROM.TransactionsList.remove(_transfer);
        _accountTO.TransactionsList.remove(_transfer);
    }
}
