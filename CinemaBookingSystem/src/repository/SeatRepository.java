package repository;


import model.Seat;

public class SeatRepository extends FileContext<Seat> {
    public SeatRepository(){
        filePath = "./data/seat.csv";
        tClass = Seat.class;
    }
}
