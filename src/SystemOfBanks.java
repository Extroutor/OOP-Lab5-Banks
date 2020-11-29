import java.util.ArrayList;
import java.util.HashMap;

public class SystemOfBanks {

//    HashMap<Integer, Bank> banksList = new HashMap<>();
    ArrayList<Bank> banksList = new ArrayList<>();

    public Bank AddBank() {
        banksList.add(new Bank());
        return banksList.get(banksList.size() - 1);
    }







}
