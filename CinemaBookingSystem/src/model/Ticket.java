package model;

import repository.IModel;
import service.FilmService;
import service.SeatService;
import service.ShowTimeService;
import utils.DateUtils;

import java.util.Date;

public class Ticket implements IModel<Ticket> {
    private long id;
    private long idOrder;
    private Date soldDate;
    private double totalPrice;
    private long showTimeId;
    private static double ticketPrice = 50000;
    private long idSeat;
    private long customerId;
    private static ShowTimeService showTimeService = new ShowTimeService();
    private static SeatService seatService = new SeatService();

    public Ticket() {
    }

    public Ticket(long id, long showTimeId, long idSeat, long customerId) {
        this.id = id;
        this.showTimeId = showTimeId;
        this.idSeat = idSeat;
        this.customerId = customerId;
        this.totalPrice = getTotal();
    }

    public Ticket(long id, long showTimeId, long idSeat) {
        this.id = id;
        this.showTimeId = showTimeId;
        this.idSeat = idSeat;
        this.totalPrice = getTotal();
    }

    public Ticket(long id, long idOrder, Date soldDate, long showTimeId, long idSeat, long customerId) {
        this.id = id;
        this.idOrder = idOrder;
        this.soldDate = soldDate;
        this.totalPrice = getTotal();
        this.showTimeId = showTimeId;
        this.idSeat = idSeat;
        this.customerId = customerId;
    }

    public long getId() {
        return id;
    }

    @Override
    public void update(Ticket obj) {
        //long id, long idOrder, long showTimeId, long idSeat,double total
        this.id = obj.getId();
        this.idOrder = obj.getIdOrder();
        this.showTimeId = obj.getShowTimeId();
        this.idSeat = obj.getIdSeat();
        this.totalPrice = obj.getTotalPrice();
    }

    @Override
    public Ticket parseData(String line) {
        Ticket ticket = new Ticket();

        //long id, long idOrder, long showTimeId, long idSeat, total
        String[] itemInfo = line.split(",");
        long id = Long.parseLong(itemInfo[0]);
        long idOrder = Long.parseLong(itemInfo[1]);
        long showTimeId = Long.parseLong(itemInfo[2]);
        long idSeat = Long.parseLong(itemInfo[3]);
        double total = Double.parseDouble(itemInfo[4]);

        ticket.setId(id);
        ticket.setIdOrder(idOrder);
        ticket.setShowTimeId(showTimeId);
        ticket.setIdSeat(idSeat);
        ticket.setTotalPrice(total);
        return ticket;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(long idOrder) {
        this.idOrder = idOrder;
    }

    public Date getSoldDate() {
        return soldDate;
    }

    public void setSoldDate(Date soldDate) {
        this.soldDate = soldDate;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public long getShowTimeId() {
        return showTimeId;
    }

    public void setShowTimeId(long showTimeId) {
        this.showTimeId = showTimeId;
    }

    public long getIdSeat() {
        return idSeat;
    }

    public void setIdSeat(long idSeat) {
        this.idSeat = idSeat;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public double getTotal() {
        double total;
        //total = giá vé +  2d/3d...;
        double surchargeFormat = showTimeService.findById(this.showTimeId).getFormat().getSurcharge();
        total = ticketPrice + surchargeFormat;
        return total;
    }

    public String toView() {
        String filmName = showTimeService.getFilmNameById(this.showTimeId);
        Date startTime = showTimeService.findById(this.showTimeId).getStartTime();
        String start = DateUtils.convertDateToString(startTime);
        String roomName = seatService.getRoomById(this.idSeat);
        String position = seatService.getPostionSeatById(this.idSeat);
        String format = showTimeService.findById(this.showTimeId).getFormat().getName();
        return String.format("║%7s║%-30s║%-20s║%-7s║%-7s║%-7s║%-20s║", this.id, filmName, start, roomName, position, format, this.totalPrice);
    }

    public String simpleView() {
        Film film = showTimeService.getFilmByShowTimeId(this.showTimeId);
        String filmName = film.getName();
        Date startTime = showTimeService.findById(this.showTimeId).getStartTime();
        String start = DateUtils.convertDateToString(startTime);
        String roomName = seatService.getRoomById(this.idSeat);
        String position = seatService.getPostionSeatById(this.idSeat);
        return String.format("                                  ║%7s|%-30s|%-20s|%-7s|%-7s|%-15s║", this.id, filmName, start, roomName, position, this.totalPrice);
    }

    @Override
    public String toString() {
        //long id, long idOrder, long showTimeId, long idSeat,double tota
        return String.format("%s,%s,%s,%s,%s", this.id, this.idOrder, this.showTimeId, this.idSeat, this.totalPrice);
    }

    public void printTicket() {
        System.out.println("vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv");
        System.out.println(">>>CINEMA  |                                <<<<");
        System.out.println(">>>TICKET  |                                <<<<");
        System.out.println(">>>┌───────────────────────────────────────┐<<<<");
        System.out.printf(">>> %s      |    <<<<", this.id);

    }
}
