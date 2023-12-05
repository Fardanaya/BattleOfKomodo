package src.View;

import java.util.ArrayList;
import src.Node.Data.Age;

public class AgeView {

    // TODO : complete show age details
    public void showElementDetails(Age age) {
        System.out.println("Age ID   : " + age.getId());
        System.out.println("Age Stage Name : " + age.getStageName());
    }

    public void showAllElementDetails(ArrayList<Age> ageList) {
        for (Age age : ageList) {
            System.out.println("========================");
            showElementDetails(age);
        }
        System.out.println("========================");
    }
}
