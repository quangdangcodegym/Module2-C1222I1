package view;

import model.Film;
import service.FilmService;
import service.OrderService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FilmView {
    private FilmService filmService;
    private OrderService orderService;
    Scanner scanner = new Scanner(System.in);

    public FilmView() {
        filmService = new FilmService();
        orderService = new OrderService();
    }

    public void showAllFilms() {
        List<Film> listFilm = filmService.getAllFilms();
        System.out.println("                        ╔═══════╦══════════════════════════════╦════════════════╦═══════════════╦═══════════════╗");
        System.out.printf("                        ║%7s║%-30s║ %-15s║%-15s║%-15s║", "ID", "Name", "Duration Time", "Type", "Status");
        System.out.println();
        System.out.println("                        ╠═══════╬══════════════════════════════╬════════════════╬═══════════════╬═══════════════╣");
        for (int i = 0; i < listFilm.size(); i++) {
            if (i == (listFilm.size() - 1)) {
                System.out.println(listFilm.get(i).toView());
                System.out.println("                        ╚═══════╩══════════════════════════════╩════════════════╩═══════════════╩═══════════════╝");
            } else {
                System.out.println(listFilm.get(i).toView());
                System.out.println("                        ╠═══════╬══════════════════════════════╬════════════════╬═══════════════╬═══════════════╣");
            }
        }
    }

    public void getRevenueOfFilm() {
        List<Double> revenue = new ArrayList<>();
        for (int i = 0; i < filmService.getAllFilms().size(); i++) {
            revenue.add(orderService.getRevenueOfFilm(filmService.getFilmById(i + 1).getId()));
        }
        System.out.println("                                                ╔══════════════════════════════╦════════════════╗");
        System.out.printf("                                                ║%-30s║ %15s║", "Film Name", "Revenue");
        System.out.println();
        System.out.println("                                                ╠══════════════════════════════╬════════════════╣");
        for(int i = 0; i < revenue.size();i++){
            if(i == (revenue.size()) - 1){
                System.out.printf("                                                ║%-30s║ %15s║",filmService.getFilmById(i+1).getName(),revenue.get(i)).println();
                System.out.println("                                                ╚══════════════════════════════╩════════════════╝");
            } else{
            System.out.printf("                                                ║%-30s║ %15s║",filmService.getFilmById(i+1).getName(),revenue.get(i)).println();
            System.out.println("                                                ╠══════════════════════════════╬════════════════╣");
            }
        }
    }

    public static void main(String[] args) {
        FilmView filmView = new FilmView();
        filmView.getRevenueOfFilm();
    }
}
