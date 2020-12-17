package Command;

import Account.IAccount;
import Transaction.WithdrawTransaction;

public class Withdraw implements ICommand{

    private double _amountForWithdrawing;
    private IAccount _account;
    private WithdrawTransaction _withdraw;

    public Withdraw(IAccount account, double ammountForWithdrawing) {
        _account = account;
        _amountForWithdrawing = ammountForWithdrawing;
    }

    @Override
    public void execute() throws Exception {
        _account.withdraw(_amountForWithdrawing);
        _withdraw = new WithdrawTransaction(_account._accountID, _amountForWithdrawing);
        _account.TransactionsList.add(_withdraw);
    }

    @Override
    public void undo() throws Exception {
        _account.deposit(_amountForWithdrawing);
        _account.TransactionsList.remove(_withdraw);
    }

}
