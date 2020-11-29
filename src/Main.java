public class Main {
    public static void main(String[] args) {

        SystemOfBanks systemOfBanks = new SystemOfBanks();

        Bank Sberbank = systemOfBanks.AddBank();

        Client client1 = Sberbank.AddClient("Leila", "Ahmedova");

        client1.AddAddress("Leningradskaya 70");
        client1.AddPassportNumber(668676);

        client1.GetInformationAboutClient();

        client1.OpenBankAccount(new CreditAccount());

        client1.GetInformationAboutClient();

    }
}
