import Account.*;
import Bank.*;
import Client.*;

public class Main {

    public static void main(String[] args) throws Exception {

        final Client client1 = new ClientBuilder()
                .name("Leila")
                .surname("Ahmedova")
                .address("Leningradskaya 70")
                .passport(668676)
                .build();

        final Bank bank1 = new BankBuilder()
                .bankID()
                .percentage(0.05)
                .commission(0.002)
                .limitOnTransferForSuspiciousAccount(5000)
                .limitOnWithdrawingForSuspiciousAccount(5000)
                .build();

        bank1.addClient(client1);

        Account account1 = new DebitAccount(bank1.getPercentage());
        bank1.linkAccountToClient(client1, account1);

        bank1.deposit(client1, account1, 10000);
    }
}