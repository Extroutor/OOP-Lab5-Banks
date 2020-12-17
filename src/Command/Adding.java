package Command;

import Account.Account;
import Transaction.AddingTransaction;

public class Adding implements ICommand{

    private final Double _amountForAdding;
    private final Account _account;
    private AddingTransaction _adding;

    public Adding(Account account, double amountForAdding) {
        _account = account;
        _amountForAdding = amountForAdding;
    }

    @Override
    public void Execute() throws Exception {
        _account.Deposit(_amountForAdding);
        _adding = new AddingTransaction(_account._accountID, _amountForAdding);
        _account.TransactionsList.add(_adding);
    }

    @Override
    public void Undo() throws Exception {
        _account.Withdraw(_amountForAdding);
        _account.TransactionsList.remove(_adding);
    }
}