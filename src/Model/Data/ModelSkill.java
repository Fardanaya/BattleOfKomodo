package src.Model.Data;

import java.util.ArrayList;

import com.google.gson.reflect.TypeToken;

import src.Model.JSON.*;
import src.Node.Data.Skill;

public class ModelSkill {
    public ArrayList<Skill> SkillList;
    ModelJSON<Skill> dataJSON;

    public ModelSkill() {
        this.dataJSON = new ModelJSON<>("Database/Game/Skill.json");
        fetchJsonData();
    }

    public void fetchJsonData() {
        this.SkillList = dataJSON.readFromFile(new TypeToken<ArrayList<Skill>>() {}.getType());
    }

    public void addSkill(Skill skill) {
        this.SkillList.add(skill);
    }

    public void updateSkill(int index, Skill skill) {
        this.SkillList.set(index, skill);
    }

    public int searchSkill(String name) {
        for (Skill skill : SkillList) {
            if (skill.getName().equals(name)) {
                return SkillList.indexOf(skill);
            }
        }
        return -1;
    }

    public Skill getSkill(int index) {
        return SkillList.get(index);
    }

    public ArrayList<Skill> getAllSkill() {
        return SkillList;
    }

    public boolean saveData() {
        try {
            dataJSON.writeToFile(SkillList);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}