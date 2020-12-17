package Client;

import Account.IAccount;
import Command.Adding;
import Command.ICommand;
import Command.Transfer;
import Command.Withdraw;

import java.util.ArrayList;
import java.util.UUID;

public class Client {

    private ArrayList<IAccount> accounts = new ArrayList<>();
    private ICommand _command;
    private String _name;
    private String _surname;
    private String _address = null;
    private Integer _passport = null;
//    private boolean _active = isActive();

    Client(final ClientBuilder clientBuilder) {
        _name = clientBuilder.getName();
        _surname = clientBuilder.getSurname();
        _address = clientBuilder.getAddress();
        _passport = clientBuilder.getPassport();
    }

    public void addAccount(IAccount account) {
        accounts.add(account);
    }

    public void AddingToAccount(IAccount account, double money) throws Exception {
        _command = new Adding(account, money);
        _command.execute();
    }

    public void SetName(String name)
    {
        _name = name;
    }

    public void SetFamilyName(String surname)
    {
        _surname = surname;
    }

    public void SetPassportNumber(Integer passportNumber)
    {
        _passport = passportNumber;
    }

    public void setAddress(String address)
    {
        _address = address;
    }

    public String getName()
    {
        return _name;
    }

    public String getSurname()
    {
        return _surname;
    }

    public String getAddress()
    {
        return _address;
    }

    public Integer getPassportNumber()
    {
        return _passport;
    }

    public void depositToAccount(IAccount account, Double amountToDeposit) throws Exception {
        _command = new Adding(account, amountToDeposit);
        _command.execute();
    }

    public void withdrawFromAccount(IAccount account, Double amountToWithdraw) throws Exception {
        _command = new Withdraw(account, amountToWithdraw);
        _command.execute();
    }

    public void transfer(IAccount sourceAccount, IAccount destinationAccount, Double amountToTransfer) throws Exception {
        _command = new Transfer(sourceAccount, destinationAccount, amountToTransfer);
        _command.execute();
    }

    public boolean isActive()
    {
        return _address != null || _passport != null;
    }

    public IAccount getAccount(UUID accountId) throws Exception {
        IAccount account = null;
        for (var acc : accounts) {
            if (acc._accountID == accountId)
                account = acc;
        }
        if (account == null)
            throw new Exception("Account does not exist");
        return account;
    }

    public void PrintTransactions()
    {
        for (var tr : accounts) {
            System.out.println(tr.TransactionsList);
        }

//        for (var tr : accounts.SelectMany(account => account.TransactionsList))
//        {
//            System.out.println("{tr.TransactionType} {tr.TransactionAmount}");
//        }
    }

}