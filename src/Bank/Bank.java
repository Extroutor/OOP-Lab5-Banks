package Bank;

import Account.Account;
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


    public void linkAccountToClient(Client client, Account account) throws Exception {

        if (client.isActive())
            client.addAccount(account);
        else
            throw new Exception("Account is not active");
    }

    public void Withdraw(Client client, Account account, Double amountToWithdraw) throws Exception {
        if (!client.isActive() && amountToWithdraw > _limitOnWithdrawingForSuspiciousAccount)
        {
            throw new Exception("The client is not active, maximum withdrawal allowed is " + _limitOnWithdrawingForSuspiciousAccount);
        }

        client.WithdrawFromAccount(account, amountToWithdraw);
    }

    public void deposit(Client client, Account account, double money) throws Exception {
        client.AddingToAccount(account, money);
    }

//    public void Transfer(UUID sourceAccountId, Account destinationAccount, Double amountToTransfer)
//    {
//        var client = GetClientWithAccountId(sourceAccountId);
//        var sourceAccount = GetAccountWithAccountId(sourceAccountId);
//        if (!client.isActive() && amountToTransfer > _limitOnTransferForSuspiciousAccount)
//        {
//            throw new Exception("The client is not active, maximum transfer allowed is " _limitOnTransferForSuspiciousAccount);
//        }
//
//        client.Transfer(sourceAccount,destinationAccount,amountToTransfer);
//    }

//    public Client GetClientWithAccountId(UUID accountId)
//    {
//        return ClientsList.FirstOrDefault(client => client.GetAccount(accountId).AccountId == accountId);
//    }
//
//    public Account GetAccountWithAccountId(UUID accountId)
//    {
//        return GetClientWithAccountId(accountId).GetAccount(accountId);
//    }

    public void PrintClients()
    {
        for (var client : _listOfClients)
        {
            System.out.println(client.getName() + client.getSurname() + client.getPassportNumber() + client.getAddress() + client.isActive());
        }
    }

    public Double GetCommissionRate()
    {
        return _commission;
    }
    public double getPercentage() {
        return _percentage;
    }

}
