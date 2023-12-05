package src.View;

import java.io.IOException;

public class ClearScreen {
    public static void clearConsole() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }
            else {
                System.out.print("\033\143 hehe");
            }
        } catch (IOException | InterruptedException ex) {}
    }
}
