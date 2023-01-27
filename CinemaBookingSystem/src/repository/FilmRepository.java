package repository;

import model.Film;

public class FilmRepository extends FileContext<Film> {
    public FilmRepository(){
        filePath = "./data/film.csv";
        tClass = Film.class;
    }
}
