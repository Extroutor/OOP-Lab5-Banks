public class Client {

    private String _name;
    private String _surname;
    private String _address;
    private Integer _passportNumber;
    private Account _account;

    public Client() {}
    public Client(String name, String surname) {
        _name = name;
        _surname = surname;
    }

    public void AddAddress(String address) {
        _address = address;
    }

    public void AddPassportNumber(Integer passportNumber) {
        _passportNumber = passportNumber;
    }

    public void OpenBankAccount(Account account) {
        _account = account;
    }

    public void GetInformationAboutClient () {
        System.out.println("name: " + _name);
        System.out.println("surname: " + _surname);
        if (_address != null)
            System.out.println("address: " + _address);
        if (_passportNumber != null)
            System.out.println("passport number: " + _passportNumber);
        if (_account != null)
            System.out.println("bank account: " + _account);
    }

}
