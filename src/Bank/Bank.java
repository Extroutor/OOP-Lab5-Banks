package Bank;

import Account.IAccount;
import Client.Client;

import java.util.ArrayList;
import java.util.UUID;

public class Bank {
    private final UUID _bankID;
    private final double _percentage;
    private final double _commission;
    private final double _limitOnTransferForSuspiciousAccount;
    private final double _limitOnWithdrawingForSuspiciousAccount;

    ArrayList<Client> _listOfClients = new ArrayList<>();

    Bank(final BankBuilder bankBuilder) {

        _bankID = bankBuilder.getBankID();
        _percentage = bankBuilder.getPercentage();
        _commission = bankBuilder.getCommission();
        _limitOnTransferForSuspiciousAccount = bankBuilder.getLimitOnTransferForSuspiciousAccount();
        _limitOnWithdrawingForSuspiciousAccount = bankBuilder.getLimitOnWithdrawingForSuspiciousAccount();

    }

    public void addClient(Client client) throws Exception {

        if (_listOfClients.contains(client))
            throw new Exception("Client is already exists");
        _listOfClients.add(client);

    }


    public void linkAccountToClient(Client client, IAccount account) throws Exception {

        if (client.isActive())
            client.addAccount(account);
        else
            throw new Exception("Account is not active");

    }

    public void withdraw(Client client, IAccount account, Double amountToWithdraw) throws Exception {

        if (!client.isActive() && amountToWithdraw > _limitOnWithdrawingForSuspiciousAccount)
        {
            throw new Exception("The client is not active, maximum withdrawal allowed is " + _limitOnWithdrawingForSuspiciousAccount);
        }

        client.withdrawFromAccount(account, amountToWithdraw);

    }

    public void deposit(Client client, IAccount account, double money) throws Exception {

        client.AddingToAccount(account, money);

    }

    public void Transfer(IAccount accountFrom, IAccount accountTo, Double amountToTransfer) throws Exception {
        var client = getClientWithAccountId(accountFrom._accountID);
        if (!client.isActive() && amountToTransfer > _limitOnTransferForSuspiciousAccount)
        {
            throw new Exception("The client is not active, maximum transfer allowed is " + _limitOnTransferForSuspiciousAccount);
        }
        client.transfer(accountFrom, accountTo, amountToTransfer);
    }

    public Client getClientWithAccountId(UUID accountId) throws Exception {
        Client client = null;
        for (var cl : _listOfClients) {
            if (cl.getAccount(accountId) != null)
                client = cl;
        }
        if (client == null)
            throw new Exception("Client with this account does not exist");
        return client;
    }

    public void printClients()
    {
        for (var client : _listOfClients)
        {
            System.out.println("Name: " + client.getName() + "\n"
                    + "Surname: " + client.getSurname());
            if (client.isActive())
                System.out.println("Client is active");
            else
                System.out.println("Client is not active");
            if (client.getAddress() != null)
                System.out.println("Address: " + client.getAddress());
            if (client.getPassportNumber() != null)
                System.out.println("Passport number: " + client.getPassportNumber());
        }
    }

    public double getPercentage() {
        return _percentage;
    }
}