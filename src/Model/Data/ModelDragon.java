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
        System.out.println(DragonList.size());
    }

    public void addDragon(Dragon dragon) {
        this.DragonList.add(dragon);
    }

    public int searchDragon(String name) {
        for (Dragon dragon : DragonList) {
            if (dragon.getName().equals(name)) {
                return DragonList.indexOf(dragon);
            }
        }
        return -1;
    }

    public Dragon getDragon(int index) {
        return DragonList.get(index);
    }

    public void showDragonList() {
        for (Dragon dragon : DragonList) {
            System.out.println("id : " + dragon.getId());
            System.out.println("name : " + dragon.getName());
            System.out.println("level : " + dragon.getLevel());
            System.out.println("element : " + dragon.getElement().getName());
            System.out.println("Stage : " + dragon.getAgeStage().getStageName());
            System.out.println("----------------------");
        }
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
