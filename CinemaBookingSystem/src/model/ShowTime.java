package model;

import repository.IModel;
import service.FilmService;
import service.OrderService;
import utils.DateUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ShowTime implements IModel<ShowTime> {
    private long id;
    private long idFilm;
    private Date startTime;
    private Date endTime;
    private ERoom idRoom;
    private EFormat format;
    private int quantitySeat;
    private int emptySeat;
    private FilmService filmService = new FilmService();
    private OrderService orderService = new OrderService();
    private List<Seat> occupiedSeats;

    public ShowTime() {
    }

    public ShowTime(long id, long idFilm, Date startTime, ERoom idRoom, EFormat format) {
//        filmService = new FilmService();
        this.id = id;
        this.idFilm = idFilm;
        this.startTime = startTime;
        this.endTime = generateEndTime(startTime, getDurationTime(idFilm));
        this.idRoom = idRoom;
        this.format = format;
        this.quantitySeat = idRoom.getAmountSeat();
        this.occupiedSeats = new ArrayList<>();
        this.emptySeat = this.quantitySeat - occupiedSeats.size();
    }
    public ShowTime(long id, long idFilm, Date startTime, ERoom idRoom) {
//        filmService = new FilmService();
        this.id = id;
        this.idFilm = idFilm;
        this.startTime = startTime;
        this.endTime = generateEndTime(startTime, getDurationTime(idFilm));
        this.idRoom = idRoom;
        this.quantitySeat = idRoom.getAmountSeat();
        this.occupiedSeats = new ArrayList<>();
        this.emptySeat = this.quantitySeat - occupiedSeats.size();
    }

    public ShowTime(long id, long idFilm, Date startTime, ERoom idRoom, EFormat format, int quantitySeat, int emptySeat) {
        this.id = id;
        this.idFilm = idFilm;
        this.startTime = startTime;
        this.idRoom = idRoom;
        this.format = format;
        this.quantitySeat = quantitySeat;
        this.emptySeat = emptySeat;
    }

    private long getDurationTime(long idFilm) {
        long durationTime = filmService.findDurationTimeById(idFilm);
        return durationTime;
    }

    private Date generateEndTime(Date startTime, long durationTime) {
        Date endTime = DateUtils.plusTime(startTime, durationTime);
        return endTime;
    }

    public long getId() {
        return id;
    }

    @Override
    public void update(ShowTime obj) {
        //long id, long idFilm, Date startTime, ERoom idRoom, EFormat format, int quantitySeat,int empty
        this.id = obj.getId();
        this.idFilm = obj.getIdFilm();
        this.startTime = obj.getStartTime();
//        this.endTime = obj.getEndTime();
        this.idRoom = obj.getIdRoom();
        this.format = obj.getFormat();
        this.quantitySeat = obj.getQuantitySeat();
        this.emptySeat = obj.getEmptySeat();
        this.occupiedSeats = obj.getOccupiedSeats();
    }

    @Override
    public ShowTime parseData(String line) {
        //long id, long idFilm, Date startTime, ERoom idRoom, EFormat format, int quantitySeat,int empty
        String[] itemInfo = line.split(",");
        ShowTime showTime = new ShowTime();

        long id = Long.parseLong(itemInfo[0]);
        long idFilm = Long.parseLong(itemInfo[1]);
        Date startTime = DateUtils.parseDate(itemInfo[2]);
        Date endTime = DateUtils.plusTime(startTime,filmService.findDurationTimeById(idFilm));
        ERoom room = ERoom.toERoom(Long.parseLong(itemInfo[3]));
        EFormat format = EFormat.getFormatByName(itemInfo[4]);
        int quantitySeat = Integer.parseInt(itemInfo[5]);
        int emptySeat = Integer.parseInt(itemInfo[6]);

        showTime.setId(id);
        showTime.setIdFilm(idFilm);
        showTime.setEndTime(endTime);
        showTime.setStartTime(startTime);
        showTime.setFormat(format);
        showTime.setIdRoom(room);
        showTime.setQuantitySeat(quantitySeat);
        showTime.setEmptySeat(emptySeat);
        showTime.setOccupiedSeats(orderService.getOccupiedSeatByShowTimeId(id));

        return showTime;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdFilm() {
        return idFilm;
    }

    public void setIdFilm(long idFilm) {
        this.idFilm = idFilm;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public ERoom getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(ERoom idRoom) {
        this.idRoom = idRoom;
    }

    public EFormat getFormat() {
        return format;
    }

    public void setFormat(EFormat format) {
        this.format = format;
    }

    public int getQuantitySeat() {
        return quantitySeat;
    }

    public void setQuantitySeat(int quantitySeat) {
        this.quantitySeat = quantitySeat;
    }

    public List<Seat> getOccupiedSeats() {
        return occupiedSeats;
    }
    public void addOccupiedSeat(Seat seat){
        this.occupiedSeats.add(seat);
    }

    public void setOccupiedSeats(List<Seat> occupiedSeats) {
        this.occupiedSeats = occupiedSeats;
    }

    public int getEmptySeat() {
        return emptySeat;
    }

    public void setEmptySeat(int emptySeat) {
        this.emptySeat = emptySeat;
    }

    public String toView() {
        //long id, long idFilm, Date startTime, ERoom idRoom, EFormat format
        String start = DateUtils.convertDateToString(this.startTime);
        String end = DateUtils.convertDateToString(this.endTime);
        String filmName = filmService.findFilmById(this.idFilm);
        String roomName = this.idRoom.getName();
        String formatFilm = this.format.getName();
        return String.format("                        ║%7s║%-30s║ %-20s║ %-20s║ %-7s║ %-7s║", this.id, filmName, start, end, roomName, formatFilm);
    }

    @Override
    public String toString() {
        //long id, long idFilm, Date startTime, ERoom idRoom, EFormat format, int quantitySeat,int empty
        String start = DateUtils.convertDateToString(this.startTime);
        long roomId = this.idRoom.getId();
        String formatFilm = this.format.getName();
        return String.format("%s,%s,%s,%s,%s,%s,%s", this.id, this.idFilm, start, roomId, formatFilm,this.quantitySeat,this.emptySeat);
    }

    public static void main(String[] args) {
        ShowTime showTime = new ShowTime(1, 1, DateUtils.parseDate("2022-01-01 04:00"), ERoom.ROOM_1, EFormat._3D);
        System.out.println(showTime.toView());
    }

}
