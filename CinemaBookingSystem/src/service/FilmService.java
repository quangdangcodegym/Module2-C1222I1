package service;

import model.Film;
import repository.FilmRepository;

import java.util.List;

public class FilmService {
    private FilmRepository filmRepository;

    public FilmService() {
        filmRepository = new FilmRepository();
    }
    public List<Film> getAllFilms(){
        return filmRepository.getAll();
    }
    public Film getFilmById(long id){
        return filmRepository.findById(id);
    }
    public long findDurationTimeById(long id){
        return filmRepository.findById(id).getDurationTime();
    }
    public String findFilmById(long id){
        return filmRepository.findById(id).getName();
    }
}
