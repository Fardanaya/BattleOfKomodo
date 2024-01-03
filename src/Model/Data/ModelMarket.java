package src.Model.Data;

import java.util.ArrayList;

import com.google.gson.reflect.TypeToken;

import src.Model.JSON.ModelJSON;
import src.Node.Data.Market;

public class ModelMarket {
    public ArrayList<Market> MarketList;

    ModelJSON<Market> dataJSON;

    public ModelMarket() {
        this.dataJSON = new ModelJSON<>("Database/Game/Market.json");
        fetchJsonData();
    }

    public void fetchJsonData() {
        this.MarketList = dataJSON.readFromFile(new TypeToken<ArrayList<Market>>() {
        }.getType());
    }

    public void addMarket(Market Market) {
        this.MarketList.add(Market);
    }

    public Market getMarket(int index) {
        return this.MarketList.get(index);
    }

    public ArrayList<Market> getAllMarkets() {
        return this.MarketList;
    }

    public void removeMarket(int index) {
        this.MarketList.remove(index);
    }

    public boolean saveData() {
        try {
            dataJSON.writeToFile(MarketList);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // TODO : list Market return array (for selector)
}
