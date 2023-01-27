package view;

import model.ERole;
import model.User;
import service.UserService;

import java.util.Scanner;

public class LoginView {
    private AdminView adminView;
    private UserService userService;
    Scanner scanner = new Scanner(System.in);

    public LoginView() {
        adminView = new AdminView();
        userService = new UserService();
    }

    public void launcher() {
        login();
        adminView.launcher();
    }

    public void menuLogin() {
        System.out.println("                               ╔═══════════════════════════════════════════════════════════════════════════════════╗");
        System.out.println("                               ║                                                                                   ║");
        System.out.println("                               ║                          WELCOME TO CINEMA MANAGEMENT SYSTEM                      ║");
        System.out.println("                               ║-----------------------------------ADMIN LOGIN PANEL-------------------------------║");
        System.out.println("                               ║                                 Login now to manage!!!                            ║");
        System.out.println("                               ║                                                                                   ║");
        System.out.println("                               ╚═══════════════════════════════════════════════════════════════════════════════════╝");
        System.out.println();
        System.out.println();
    }

    public boolean checkActionContinue() {
        boolean checkActionContinue = false;
        do {
            System.out.println("Continue? Y/N");
            String choice = scanner.nextLine().trim().toUpperCase();
            switch (choice) {
                case "Y":
                    return true;
                case "N":
                    return false;
                default:
                    checkActionContinue = true;
            }
        } while (checkActionContinue);
        return false;
    }

    public void login() {
        menuLogin();
        boolean checkInfoLogin;
        do {
            System.out.println("Username: ");
            String username = scanner.nextLine();
            System.out.println("Password: ");
            String password = scanner.nextLine();
            checkInfoLogin = userService.checkLoginAdmin(username, password);
            if (!checkInfoLogin) {
                System.out.println("Incorrect username or incorrect password. Please re-enter");
            }
        } while (!checkInfoLogin);
    }
}
