package src.Model.Data;

import java.util.ArrayList;
import src.Model.JSON.ModelDragonJSON;
import src.Node.Data.Dragon;

public class ModelDragon {
    public ArrayList<Dragon> DragonList;

    ModelDragonJSON dataJSON = new ModelDragonJSON();

    public ModelDragon() {
        fetchJsonData();
    }

    public void fetchJsonData() {
        this.DragonList = dataJSON.readDataJSON();
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

    public boolean saveData() {
        try {
            dataJSON.writeDataJSON(DragonList);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // TODO : list dragon return array (for selector)
}
