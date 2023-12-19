package src.Model.Data;

import java.util.ArrayList;

import com.google.gson.reflect.TypeToken;

import src.Model.JSON.ModelJSON;
import src.Node.Data.Account;

public class ModelAccount {
    public ArrayList<Account> AccountList;
    ModelJSON<Account> dataJSON;

    public ModelAccount() {
        this.dataJSON = new ModelJSON<>("Database/Game/Player.json");
        fetchJsonData();
    }

    public void fetchJsonData() {
        this.AccountList = dataJSON.readFromFile(new TypeToken<ArrayList<Account>>() {}.getType());
    }

    public void addAccount(Account account) {
        this.AccountList.add(account);
    }

    public void updateAccount(int index, Account account) {
        this.AccountList.set(index, account);
    }

    public int searchAccount(String username) {
        for (Account account : AccountList) {
            if (account.getUsername().equals(username)) {
                return AccountList.indexOf(account);
            }
        }
        return -1;
    }

    public Account getAccount(int index) {
        return AccountList.get(index);
    }

    public ArrayList<Account> getAllAccount() {
        return AccountList;
    }

    public boolean saveData() {
        try {
            dataJSON.writeToFile(AccountList);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
