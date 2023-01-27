package repository;

import model.ShowTime;

public class ShowTimeRepository extends FileContext<ShowTime>{
    public ShowTimeRepository(){
        filePath = "./data/showtime.csv";
        tClass = ShowTime.class;
    }
}
