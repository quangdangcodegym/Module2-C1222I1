import model.Seat;
import service.SeatService;
import view.CustomerView;
import view.LoginView;
import view.OrderView;
import view.ShowTimeView;

import java.util.List;

public class Main {
    public static void main(String[] args) {
//        ShowTimeView showTimeView = new ShowTimeView();
//        showTimeView.launcher();

//        OrderView orderView = new OrderView();
//        orderView.launcher();

//        CustomerView customerView = new CustomerView();
//        customerView.launcher();
        LoginView loginView = new LoginView();
        loginView.launcher();
    }
}