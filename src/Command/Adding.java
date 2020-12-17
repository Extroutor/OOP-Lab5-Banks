package Command;

import Account.IAccount;
import Transaction.AddingTransaction;

public class Adding implements ICommand{

    private final Double _amountForAdding;
    private final IAccount _account;
    private AddingTransaction _adding;

    public Adding(IAccount account, double amountForAdding) {
        _account = account;
        _amountForAdding = amountForAdding;
    }

    @Override
    public void execute() throws Exception {
        _account.deposit(_amountForAdding);
        _adding = new AddingTransaction(_account._accountID, _amountForAdding);
        _account.TransactionsList.add(_adding);
    }

    @Override
    public void undo() throws Exception {
        _account.withdraw(_amountForAdding);
        _account.TransactionsList.remove(_adding);
    }
}