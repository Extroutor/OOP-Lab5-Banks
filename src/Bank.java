import java.util.ArrayList;

public class Bank {

    ArrayList<Client> clientList = new ArrayList<>();



    public Client AddClient(String name, String surname) {
        clientList.add(new Client(name, surname));
        return clientList.get(clientList.size() - 1);
    }





}
