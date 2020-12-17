package Command;

import Account.Account;
import Transaction.WithdrawTransaction;

public class Withdraw implements ICommand{

    private double _amountForWithdrawing;
    private Account _account;
    private WithdrawTransaction _withdraw;

    public Withdraw(Account account, double ammountForWithdrawing) {
        _account = account;
        _amountForWithdrawing = ammountForWithdrawing;
    }

    @Override
    public void Execute() throws Exception {
        _account.Withdraw(_amountForWithdrawing);
        _withdraw = new WithdrawTransaction(_account._accountID, _amountForWithdrawing);
        _account.TransactionsList.add(_withdraw);
    }

    @Override
    public void Undo() throws Exception {
        _account.Deposit(_amountForWithdrawing);
        _account.TransactionsList.remove(_withdraw);
    }

}
