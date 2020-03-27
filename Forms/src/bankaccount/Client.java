package bankaccount;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private String name;
    private List<BankAccount> personalAccounts;

    public Client(String name) {
        this.name = name;
        this.personalAccounts = new ArrayList<>();
    }

    public void addAccount(BankAccount account){
        this.personalAccounts.add(account);
    }

    public String getName() {
        return this.name;
    }


}
