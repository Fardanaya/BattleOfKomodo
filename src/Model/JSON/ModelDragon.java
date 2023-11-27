package src.Model.JSON;

import java.io.File;
import java.io.IOException;

import src.View.Message;

public class ModelDragon {

    String fname = "database/Game/Dragon.json";
    Message gameMessage = new Message();

    public boolean checkFile() {
        boolean status = false;
        if (new java.io.File(fname).exists()) {
            status = true;
        }
        return status;
    }

    public void setupFile() {
        try {
            if (checkFile() == false) {
                File file = new File(fname);
                if (file.createNewFile()) {
                    gameMessage.alert("File telah dibuat - " + file.getName());
                }
            }
        } catch (IOException e) {
            System.out.println("Error.");
            e.printStackTrace();
        }
    }

}
