package view;

import java.util.Scanner;

public class AdminView {
    Scanner scanner = new Scanner(System.in);
    private ShowTimeView showTimeView;
    private OrderView orderView;
    private CustomerView customerView;
    private FilmView filmView;
    public AdminView(){
        showTimeView = new ShowTimeView();
        orderView = new OrderView();
        customerView = new CustomerView();
        filmView = new FilmView();
    }
    public void launcher(){
        boolean checkAction = false;
        do {
            menuView();
            System.out.println("Please choose one");
            int actionMenuShowTime = Integer.parseInt(scanner.nextLine());
            switch (actionMenuShowTime) {
                case 1:
                    showTimeView.launcher();
                    break;
                case 2:
                    orderView.launcher();
                    break;
                case 3:
                    customerView.launcher();
                    break;
                case 4:
                    filmView.getRevenueOfFilm();
                    break;
                case 5:
                    LoginView loginView = new LoginView();
                    loginView.launcher();
            }
            checkAction = checkActionContinue();
        } while (checkAction);
    }
    public void menuView() {
        System.out.println("                               ╔═══════════════════════════════════════════════════════════════════════════════════╗");
        System.out.println("                               ║                                    ADMIN DASHBOARD                                ║");
        System.out.println("                               ║                                 [1] Manage showtime                               ║");
        System.out.println("                               ║                                 [2] Manage order                                  ║");
        System.out.println("                               ║                                 [3] Manage customer                               ║");
        System.out.println("                               ║                                 [4] Revenue per film                              ║");
        System.out.println("                               ║                                 [5] Log out                                       ║");
        System.out.println("                               ╚═══════════════════════════════════════════════════════════════════════════════════╝");
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
}
