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

    Client(final ClientBuilder clientBuilder) {
        _name = clientBuilder.getName();
        _surname = clientBuilder.getSurname();
        _address = clientBuilder.getAddress();
        _passport = clientBuilder.getPassport();
    }

    public void addAccount(IAccount account) {
        accounts.add(account);
    }

    public void addingToAccount(IAccount account, double money) throws Exception {
        _command = new Adding(account, money);
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

    public void undo(IAccount account) throws Exception {
        _command.undo();
    }

    public boolean isActive() {
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

    public void SetPassportNumber(Integer passportNumber) {
        _passport = passportNumber;
    }

    public void setAddress(String address) {
        _address = address;
    }

    public String getName() {
        return _name;
    }

    public String getSurname() {
        return _surname;
    }

    public String getAddress() {
        return _address;
    }

    public Integer getPassportNumber() {
        return _passport;
    }
}