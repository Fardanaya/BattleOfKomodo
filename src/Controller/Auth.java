package src.Controller;

import src.Node.Data.Player;
import src.View.ClearScreen;
import src.View.Input;

public class Auth {
    Input prompt = new Input();

    public void register() {
        String username, password, verifpass;
        System.out.println("REGISTRASI");
        do {
            username = prompt.getUserInput("Username : ");
            if (Model.playerList.searchPlayer(username) != -1) {
                ClearScreen.clearConsole();
                System.out.println("Username sudah terdaftar. Silakan coba lagi.");
                continue;
            }
        } while (Model.playerList.searchPlayer(username) != -1);

        do {
            password = prompt.getPasswordInput("password: ");
            if (password.length() < 8 || !containLetterAndDigit(password)) {
                ClearScreen.clearConsole();
                System.out.println("password harus lebih dari 8 karakter dan terdiri dari huruf dan angka");
                System.out.println("REGISTRASI");
                System.out.println("Username : " + username);
                continue;
            }
        } while (password.length() < 8 || !containLetterAndDigit(password));

        do {
            verifpass = prompt.getPasswordInput("ulang password");
            if (!password.equals(verifpass)) {
                ClearScreen.clearConsole();
                System.out.println("Password tidak cocok. Silakan coba lagi.");
                System.out.println("REGISTRASI");
                System.out.println("Username : " + username);
                System.out.println("Password : " + ("*").repeat(password.length()));
                continue;
            }
            Model.playerList.addPlayer(new Player(username, password));
            System.out.println("Registrasi Berhasil");
        } while (!password.equals(verifpass));
    }

    private boolean containLetterAndDigit(String pass) {
        boolean hasLetter = false;
        boolean hasDigit = false;

        for (char x : pass.toCharArray()) {
            if (Character.isLetter(x)) {
                hasLetter = true;
            } else if (Character.isDigit(x)) {
                hasDigit = true;
            }
            if (hasLetter && hasDigit) {
                break;
            }
        }

        return hasLetter && hasDigit;
    }

    public void login() {
        boolean log = false;
        System.out.println("LOGIN");
        do {
            String username = prompt.getUserInput("username : ");
            String password = prompt.getPasswordInput("password : ");
            int userlog = Model.playerList.searchPlayer(username);
            if (userlog == -1) {
                System.out.println("data user tidak ditemukan");
                continue;
            }
            if (!password.equals(Model.playerList.getPlayer(userlog).getPassword())) {
                System.out.println("password salah");
                continue;
            }
            log = true;
        } while (!log);
        System.out.println("Login Berhasil");
    }

}