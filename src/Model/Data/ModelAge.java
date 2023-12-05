package src.Model.Data;

import java.util.ArrayList;
import src.Node.Data.Age;

public class ModelAge {
    public ArrayList<Age> AgeStage;

    public ModelAge() {
        this.AgeStage = new ArrayList<>();
    }

    public void addAge(Age Age) {
        this.AgeStage.add(Age);
    }

    public int searchAge(String id) {
        for (Age age : AgeStage) {
            if (age.getId().equals(id)) {
                return AgeStage.indexOf(age);
            }
        }
        return -1;
    }

    public Age getAge(int index) {
        return AgeStage.get(index);
    }

    public ArrayList<Age> getAllAges() {
        return AgeStage;
    }
}
