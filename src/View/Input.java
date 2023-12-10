package src.View;

import java.io.Console;
import java.util.Scanner;

public class Input {

    private Scanner input = new Scanner(System.in);
    private Console console = System.console();

    public String getUserInput(String text) {
        System.out.print(text);
        return input.nextLine();
    }

    public String getPasswordInput(String text) {
        if (console == null) {
            System.err.println("Error: Console not available");
            System.exit(1);
        }
        return new String(console.readPassword(text));
    }

    public int getMenuUserInput(String title, String[] menuOptions) {
        System.out.println(title);
        for (int i = 0; i < menuOptions.length; i++) {
            System.out.println(i+1 + ". " + menuOptions[i]);
        }
        System.out.println();
        System.out.print("[ + ] Select :");
        return input.nextInt();
    }
}