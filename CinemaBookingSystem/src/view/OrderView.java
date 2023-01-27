package view;

import model.*;
import repository.ShowTimeRepository;
import service.*;
import utils.DateUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class OrderView {
    private ShowTimeView showTimeView;
    private OrderService orderService;
    private ShowTimeService showTimeService;
    private SeatService seatService;
    private SeatView seatView;
    private ShowTimeRepository showTimeRepository;
    private TicketService ticketService;
    private FilmView filmView;
    private CustomerService customerService;
    private CustomerView customerView;
    Scanner scanner = new Scanner(System.in);
    private static int countEnter = 3;

    public OrderView() {
        showTimeRepository = new ShowTimeRepository();
        showTimeView = new ShowTimeView();
        orderService = new OrderService();
        showTimeService = new ShowTimeService();
        customerService = new CustomerService();
        customerView = new CustomerView();
        seatService = new SeatService();
        seatView = new SeatView();
        ticketService = new TicketService();
        filmView = new FilmView();
    }

    public void launcher() {
        boolean checkAction = false;
        do {
            renderMenuOrder();
            System.out.println("Please choose one");
            int actionMenuShowTime = Integer.parseInt(scanner.nextLine());
            switch (actionMenuShowTime) {
                case 1:
                    displayOrders(orderService.getAllOrders());
                    break;
                case 2:
                    addNewOrder();
                    break;
                case 3:
                    displayOrderDetail(chooseIdOrder());
                    break;
                case 4:
                    System.out.println("Enter name of customer you want to find");
                    String name = scanner.nextLine();
                    displayOrders(findOrderByName(name));
                    break;
                case 5:
                    getRevenuePerFilm();
                    break;
                case 6:
                    AdminView adminView = new AdminView();
                    adminView.launcher();
                    break;
            }
            checkAction = checkActionContinue();
        } while (checkAction);
    }

    public void renderMenuOrder() {
        System.out.println("                               ╔═══════════════════════════════════════════════════════════════════════════════════╗");
        System.out.println("                               ║                                      ORDER MENU                                   ║");
        System.out.println("                               ║                              [1] Display all orders                               ║");
        System.out.println("                               ║                              [2] Add new order                                    ║");
        System.out.println("                               ║                              [3] Show order detail                                ║");
        System.out.println("                               ║                              [4] Find order by customer's name                    ║");
        System.out.println("                               ║                              [5] Revenue per film                                 ║");
        System.out.println("                               ║                              [6] Return Admin Dashboard                           ║");
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

    public long checkExistCustomer() {
        System.out.println("Enter customer's name");
        String customerName = scanner.nextLine();
        List<User> result = customerService.searchByName(customerName);
        if (result.size() != 0) {
            customerView.displayAllCustomer(result);
            System.out.println("Enter ID's customer");
            long idCustomer = Long.parseLong(scanner.nextLine());
            for (User customer : result) {
                if (customer.getId() == idCustomer) {
                    return customer.getId();
                }
            }
        }
        return 222;
    }

    public void addNewOrder() {
        Order order = new Order();
        long idOrder = System.currentTimeMillis() % 1000;
        Date createDate = new Date();
        long idCustomer = checkExistCustomer();
        String customerName = customerService.findById(idCustomer).getName();
        order.setId(idOrder);
        order.setIdCustomer(idCustomer);
        order.setCustomerName(customerName);
        order.setCreateDate(createDate);
        orderService.addNewOrder(order);
        List<Ticket> ticketList = new ArrayList<>();
        boolean continueToAdd;
        do {
            Ticket ticket = addNewTicket();
            if (ticket != null) {
                ticket.setIdOrder(idOrder);
                ticketService.addNewTicket(ticket);
                ticketList.add(ticket);
            }
            continueToAdd = checkContinueAdd();
        } while (continueToAdd);
        //long id, String customerName, double total, Date createDate, List<Ticket> orderitemList
        if (ticketList.size() != 0) {
            order.setOrderitemList(ticketList);
            order.setTotal(order.total());
            orderService.updateOrder(order);
            customerService.addNewOrder(order);
            displayOrderDetail(idOrder);
        } else {
            System.out.println("Your order is empty!!!");
            orderService.deleteById(idOrder);
        }
    }

    public boolean checkContinueAdd() {
        boolean checkContinue = false;
        do {
            System.out.println("Do you want to continue?");
            String choice = scanner.nextLine().trim().toUpperCase();
            switch (choice) {
                case "Y":
                    return true;
                case "N":
                    return false;
                default:
                    checkContinue = true;
            }
        } while (checkContinue);
        return false;
    }

    public Ticket addNewTicket() {
        Ticket ticket = new Ticket();
        long id = System.currentTimeMillis() % 1000;
        //long id, Date soldDate, long showTimeId, long idSeat, long customerId
        showTimeView.displayAllShowTimes();
        long idShowTime;
        //còn ghế: true ; không: false
        boolean emptySeat;
        int count = 0;
        do {
            System.out.println("Choose ID's showtime you want to buy ticket");
            idShowTime = Long.parseLong(scanner.nextLine());
            boolean overdue = checkShowTimeOverdue(idShowTime);
            if (overdue == true) {
                System.out.println("This show is overdue.");
                return null;
            }
            emptySeat = showTimeService.checkEmptySeat(idShowTime);
            if (!emptySeat) {
                System.out.println("This showtime don't have empty seat. Please choose another showtime");
            }
            // giới hạn số lần nhập
            count++;
            if (count == countEnter) {
                boolean checkContinue = checkContinueAddTicket();
                if (!checkContinue) {
                    return null;
                }
            }
        } while (!emptySeat);
        // kiểm tra seat
        String seat;
        count = 0;
        long idSeat;
        do {
            if (showTimeService.findById(idShowTime).getOccupiedSeats() == null) {
                seatView.displayRoom(showTimeService.findById(idShowTime).getIdRoom());
            } else {
                seatView.displayRoomByShowTime(showTimeService.findById(idShowTime));
            }
            System.out.println("Please choose your seat");
            seat = scanner.nextLine().toUpperCase();
            if (!checkOccupiedSeat(idShowTime, seat)) {
                System.out.println("Occupied Seat!!! Please choose again");
            }
            count++;
            if (count == countEnter) {
                boolean checkContinue = checkContinueAddTicket();
                if (!checkContinue) {
                    return null;
                }
            }
        } while (!checkOccupiedSeat(idShowTime, seat));
        ERoom room = showTimeService.findById(idShowTime).getIdRoom();
        idSeat = seatService.getIdSeatByRoom(seat, showTimeService.findById(idShowTime));
        //long id, long showTimeId, long idSeat
        ticket.setId(id);
        ticket.setShowTimeId(idShowTime);
        ticket.setIdSeat(idSeat);
        ticket.setTotalPrice(ticket.getTotal());
        if (ticket != null) {
            List<Seat> occupiedSeat = showTimeService.findById(ticket.getShowTimeId()).getOccupiedSeats();
            if (occupiedSeat == null) {
                List<Seat> seatList = new ArrayList<>();
                seatList.add(seatService.findSeatById(idSeat));
                occupiedSeat = seatList;
            } else {
                occupiedSeat.add(seatService.findSeatById(idSeat));
            }
            int countEmptySeat = (showTimeService.findById(ticket.getShowTimeId()).getEmptySeat()) - 1;
            showTimeService.saveData(ticket.getShowTimeId(), countEmptySeat, occupiedSeat);
//            orderService.addNewOccupiedSeat(showTimeService.findById(ticket.getShowTimeId()), ticket.getIdSeat());
        }
        return ticket;
    }

    //kiểm tra showtime quá hạn
    // quá hạn: true; vẫn đặt được (sau thời điểm bây giờ):false
    public boolean checkShowTimeOverdue(long idShow) {
        Date now = new Date();
        if (showTimeService.findById(idShow).getStartTime().before(now)) {
            return true;
        }
        return false;
    }

    public boolean checkContinueAddTicket() {
        System.out.println("Enter [Y] to continue or if you want to cancel, enter any keys to exit");
        String choose = scanner.nextLine();
        switch (choose) {
            case "Y":
                return true;
            default:
                return false;
        }
    }

    //check ghế trống
    //ghế đã đặt: return false; chưa: true
    public boolean checkOccupiedSeat(long idShowTime, String selectedSeat) {
        long idSeat = seatService.getIdSeatByRoom(selectedSeat, showTimeService.findById(idShowTime));
        List<Seat> occupiedSeat = showTimeService.findById(idShowTime).getOccupiedSeats();
        if (occupiedSeat == null) {
            return true;
        }
        for (Seat seat : occupiedSeat) {
            if (seat.getId() == idSeat) {
                return false;
            }
        }
        return true;
    }

    public List<Order> findOrderByName(String name) {
        List<Order> allOrders = orderService.getAllOrders();
        List<Order> results = new ArrayList<>();
        for (Order order : allOrders) {
            if (order.getCustomerName().contains(name)) {
                results.add(order);
            }
        }
        return results;
    }

    public void displayOrders(List<Order> allOrders) {
        if (allOrders.size() == 0) {
            System.out.println("Empty order");
            return;
        }
        System.out.println("                        ╔═══════╦══════════════════════════════╦════════════════════╦════════════════════╦════════════════╗");
        System.out.printf("                        ║%7s║%-30s║%-20s║%-20s║%-16s║", "ID", "Customer Name", "Amount ticket", "Total", "Create Date");
        System.out.println();
        System.out.println("                        ╠═══════╬══════════════════════════════╬════════════════════╬════════════════════╬════════════════╣");
        for (int i = 0; i < allOrders.size(); i++) {
            if (i == (allOrders.size() - 1)) {
                System.out.println(allOrders.get(i).toView());
                System.out.println("                        ╚═══════╩══════════════════════════════╩════════════════════╩════════════════════╩════════════════╝");
            } else {
                System.out.println(allOrders.get(i).toView());
                System.out.println("                        ╠═══════╬══════════════════════════════╬════════════════════╬════════════════════╬════════════════╣");
            }
        }
    }

    public long chooseIdOrder() {
        System.out.println("Enter ID's order you want to show");
        long idOrder = Long.parseLong(scanner.nextLine());
        Order order = orderService.getOrderByIdOrder(idOrder);
        return order.getId();
    }

    public void getRevenuePerFilm() {
        filmView.getRevenueOfFilm();
    }

    public void displayOrderDetail(long idOrder) {
        Order order = orderService.getOrderByIdOrder(idOrder);
        if (order == null) {
            System.out.println("Not found this order");
            return;
        }
        List<Ticket> tickets = order.getOrderitemList();
        System.out.println("                                  ╔═══════════════════════════════════════════════════════════════════════════════════════════╗");
        System.out.printf("                                  ║%-10s %-20s %-59s║", " ", "ID Order", order.getId()).println();
        System.out.printf("                                  ║%-10s %-20s %-59s║", " ", "Customer's name", order.getCustomerName()).println();
        System.out.printf("                                  ║%-10s %-20s %-59s║", " ", "Create Date", DateUtils.convertDateToString(order.getCreateDate())).println();
        System.out.println("                                  ║-------------------------------------------------------------------------------------------║");
        System.out.printf("                                  ║%7s|%-30s|%-20s|%-7s|%-7s|%-15s║", "ID", "Film", "Start", "Room", "Seat", "Price").println();
        System.out.println("                                  ║-------------------------------------------------------------------------------------------║");

        for (Ticket ticket : tickets) {
            System.out.println(ticket.simpleView());
        }
        System.out.println("                                  ║-------------------------------------------------------------------------------------------║");
        System.out.printf("                                  ║%20s %53s %-16s║", "Total", " ", order.getTotal()).println();
        System.out.printf("                                  ║%91s║", " ").println();
        System.out.printf("                                  ║%20s %39s %-30s║", " ", "THANKS FOR SHOPPING!!!", " ").println();
        System.out.println("                                  ╚═══════════════════════════════════════════════════════════════════════════════════════════╝");
    }
}
