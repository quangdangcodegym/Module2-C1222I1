package model;

import repository.IModel;

public class Seat implements IModel<Seat> {
    //id, vi_tri_day, vi_tri_cot, phong_chieu_id, vị trí
    private long id;
    private int rowSeat;
    private int colSeat;
    private String position;
    private ERoom eRoom;

    public Seat() {

    }

    public Seat(long id, int rowSeat, int colSeat, String position, ERoom eRoom) {
        this.id = id;
        this.rowSeat = rowSeat;
        this.colSeat = colSeat;
        this.position = position;
        this.eRoom = eRoom;
    }

    public long getId() {
        return id;
    }

    @Override
    public void update(Seat obj) {
//        this.id = obj.getId();
//        this.colSeat = obj.getColSeat();
//        this.rowSeat = obj.getRowSeat();
//        this.position = obj.getPosition();
//        this.eRoom = obj.geteRoom();
    }

    @Override
    public Seat parseData(String line) {
        // line: 1,1,1,1,A1
        //id, vi_tri_day, vi_tri_cot, phong_chieu_id, vị trí
        String[] items = line.split(",");
        long idSeat = Long.parseLong(items[0]);
        int rowSeat = Integer.parseInt(items[1]);
        int colSeat = Integer.parseInt(items[2]);
        ERoom room = ERoom.toERoom(Integer.parseInt(items[3]));
        String position = items[4];

        Seat seat = new Seat();
        seat.setId(idSeat);
        seat.setRowSeat(rowSeat);
        seat.setColSeat(colSeat);
        seat.seteRoom(room);
        seat.setPosition(position);

        return seat;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getRowSeat() {
        return rowSeat;
    }

    public void setRowSeat(int rowSeat) {
        this.rowSeat = rowSeat;
    }

    public int getColSeat() {
        return colSeat;
    }

    public void setColSeat(int colSeat) {
        this.colSeat = colSeat;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public ERoom geteRoom() {
        return eRoom;
    }

    public void seteRoom(ERoom eRoom) {
        this.eRoom = eRoom;
    }
}
