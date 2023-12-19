package src.Model.Data;

import java.util.ArrayList;

import com.google.gson.reflect.TypeToken;

import src.Model.JSON.ModelJSON;
import src.Node.Data.Dragon;

public class ModelDragon {
    public ArrayList<Dragon> DragonList;

    ModelJSON<Dragon> dataJSON;

    public ModelDragon() {
        this.dataJSON = new ModelJSON<>("Database/Game/Dragon.json");
        fetchJsonData();
    }

    public void fetchJsonData() {
        this.DragonList = dataJSON.readFromFile(new TypeToken<ArrayList<Dragon>>() {
        }.getType());
    }

    public void addDragon(Dragon dragon) {
        this.DragonList.add(dragon);
    }

    public int searchDragon(String name) {
        for (Dragon dragon : DragonList) {
            if (dragon.getName().equals(name)) {
                return this.DragonList.indexOf(dragon);
            }
        }
        return -1;
    }

    public Dragon getDragon(int index) {
        return this.DragonList.get(index);
    }

    public ArrayList<Dragon> getAllDragons() {
        return this.DragonList;
    }

    public void removeDragon(int index) {
        this.DragonList.remove(index);
    }

    public boolean saveData() {
        try {
            dataJSON.writeToFile(DragonList);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // TODO : list dragon return array (for selector)
}
