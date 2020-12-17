package Client;

import Account.Account;
import Command.Adding;
import Command.ICommand;
import Command.Transfer;
import Command.Withdraw;

import java.util.ArrayList;
import java.util.UUID;

public class Client {

    private ArrayList<Account> accounts = new ArrayList<>();
    private ICommand _command;
    private String _name;
    private String _surname;
    private String _address;
    private Integer _passport;
    private boolean active;

    Client(final ClientBuilder clientBuilder) {
        _name = clientBuilder.getName();
        _surname = clientBuilder.getSurname();
        _address = clientBuilder.getAddress();
        _passport = clientBuilder.getPassport();
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public void AddingToAccount(Account account, double money) throws Exception {
        _command = new Adding(account, money);
        _command.Execute();
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

    public void AddAccount(Account account)
    {
        accounts.add(account);
    }

    public void ChangeStatus(boolean isActive)
    {
        active = isActive;
    }

    public void DepositToAccount(Account account, Double amountToDeposit) throws Exception {
        _command = new Adding(account, amountToDeposit);
        _command.Execute();
    }

    public void WithdrawFromAccount(Account account, Double amountToWithdraw) throws Exception {
        _command = new Withdraw(account, amountToWithdraw);
        _command.Execute();
    }

    public void Transfer(Account sourceAccount, Account destinationAccount, Double amountToTransfer) throws Exception {
        _command = new Transfer(sourceAccount, destinationAccount, amountToTransfer);
        _command.Execute();
    }

    public boolean isActive()
    {
        return active;
    }

//    public Account GetAccount(UUID accountId)
//    {
//        return accounts.FirstOrDefault(account => account.AccountId == accountId);
//    }
//
//    public void PrintTransactions()
//    {
//        for (var tr : accounts.SelectMany(account => account.TransactionsList))
//        {
//            System.out.println("{tr.TransactionType} {tr.TransactionAmount}");
//        }
//    }

}