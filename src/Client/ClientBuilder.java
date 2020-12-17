package Client;

public class ClientBuilder {

    private String name;
    private String surname;
    private String address;
    private int passport;

    public ClientBuilder name(final String name) {
        this.name = name;
        return this;
    }

    public ClientBuilder surname(final String surname) {
        this.surname = surname;
        return this;
    }

    public ClientBuilder address(final String address) {
        this.address = address;
        return this;
    }

    public ClientBuilder passport(final int passport) {
        this.passport = passport;
        return this;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getAddress() {
        return address;
    }

    public int getPassport() {
        return passport;
    }

    public Client build() {
        return new Client(this);
    }
}
