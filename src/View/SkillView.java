package src.View;

import java.util.ArrayList;
import src.Node.Data.Skill;

public class SkillView {
    public void showSkillDetails(Skill skill) {
        System.out.println("Skill ID : " + skill.getId());
        System.out.println("Skill Name : " + skill.getName());
        System.out.println("Skill Base Power : " + skill.getStartPoint());
    }

    public void showSkill(Skill skill) {
        System.out.println("Skill Name : " + skill.getName());
        System.out.println("Skill Damage : " + skill.getStartPoint());
    }

    public void showAllSkillDetails(ArrayList<Skill> skillList) {
        for (Skill skill : skillList) {
            System.out.println("========================");
            showSkillDetails(skill);
        }
            System.out.println("========================");
    }

    public void showAllSkill(ArrayList<Skill> skillList) {
        for (Skill skill : skillList) {
            System.out.println("========================");
            showSkill(skill);
        }
        System.out.println("========================");
    }
}
