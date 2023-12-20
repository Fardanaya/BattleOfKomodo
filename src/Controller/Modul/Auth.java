package src.Controller.Modul;

import src.Controller.Data;
import src.Node.Data.Account;
import src.View.*;

public class Auth {
    Input prompt = new Input();

    // TODO: ROMBAK INPUT & OUTPUT

    public void register() {
        String username, password, verifpass;
        Data.game.print("LOGIN");
        do {
            username = prompt.getUserInput("Username : ");
            if (Data.playerList.searchAccount(username) != -1) {
                Game.cls();
                Data.game.print("Username sudah terdaftar. Silakan coba lagi.");
                continue;
            }
        } while (Data.playerList.searchAccount(username) != -1);

        do {
            password = prompt.getPasswordInput("Password : ");
            if (password.length() < 8 || !containLetterAndDigit(password)) {
                Game.cls();
                Data.game.print("password harus lebih dari 8 karakter dan terdiri dari huruf dan angka");
                Data.game.print("Username : " + username);
                continue;
            }
        } while (password.length() < 8 || !containLetterAndDigit(password));

        do {
            verifpass = prompt.getPasswordInput("Repeat Password : ");
            if (!password.equals(verifpass)) {
                Game.cls();
                Data.game.print("Password tidak cocok. Silakan coba lagi.");
                Data.game.print("Username : " + username);
                Data.game.print("Password : " + ("*").repeat(password.length()));
                continue;
            }
            Data.playerList.addAccount(new Account(username, password));
            Data.game.print("Registrasi Berhasil");
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

    public Account login() {
        Data.game.print("LOGIN");
        String username = prompt.getUserInput("Username : ");
        Account account = null;
        boolean loginSuccessful = false;

        while (!loginSuccessful) {
            String password = prompt.getPasswordInput("Password : ");
            int userid = Data.playerList.searchAccount(username);

            if (userid == -1) {
                Data.game.print("User tidak ditemukan");
                username = prompt.getUserInput("Username : ");
                continue;
            }

            account = Data.playerList.getAccount(userid);

            if (!password.equals(account.getPassword())) {
                Data.game.print("Password salah");
                continue;
            }

            loginSuccessful = true;
        }

        Data.game.print("Login Berhasil");
        return account;
    }
}