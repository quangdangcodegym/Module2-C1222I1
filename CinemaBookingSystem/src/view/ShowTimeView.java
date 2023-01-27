package view;

import model.*;
import service.FilmService;
import service.ShowTimeService;
import utils.DateUtils;
import utils.ValidateShowTime;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ShowTimeView {
    private ShowTimeService showTimeService;
    private FilmView filmView;
    private ValidateShowTime validateShowTime;
    private FilmService filmService;
    Scanner scanner = new Scanner(System.in);

    public ShowTimeView() {
        showTimeService = new ShowTimeService();
        filmView = new FilmView();
        validateShowTime = new ValidateShowTime();
        filmService = new FilmService();
    }

    public void renderMenuShowTime() {
        System.out.println("                               ╔═══════════════════════════════════════════════════════════════════════════════════╗");
        System.out.println("                               ║                              SHOW TIME MANAGER MENU                               ║");
        System.out.println("                               ║                              [1] Display all show time                            ║");
        System.out.println("                               ║                              [2] Add new show time                                ║");
        System.out.println("                               ║                              [3] Edit show time                                   ║");
        System.out.println("                               ║                              [4] Delete show time                                 ║");
        System.out.println("                               ║                              [5] Search show time by name of film                 ║");
        System.out.println("                               ║                              [6] Return Admin Dashboard                           ║");
        System.out.println("                               ╚═══════════════════════════════════════════════════════════════════════════════════╝");
    }

    public void launcher() {
        boolean checkAction = false;
        do {
            renderMenuShowTime();
            System.out.println("Please choose one");
            int actionMenuShowTime = Integer.parseInt(scanner.nextLine());
            switch (actionMenuShowTime) {
                case 1:
                    displayAllShowTimes();
                    break;
                case 2:
                    addNewShowTime();
                    break;
                case 3:
                    displayAllShowTimes();
                    System.out.println("Enter ID's film you want to edit");
                    long idShowTime = Long.parseLong(scanner.nextLine());
                    ShowTime edit = showTimeService.findById(idShowTime);
                    if (checkShowTimeBeforeNow(edit) == true) {
                        System.out.println("Can't edit overdue showtimes");
                        break;
                    }
                    editShowTime(showTimeService.findById(idShowTime));
                    break;
                case 4:
                    deleteShowTime();
                    break;
                case 5:
                    System.out.println("Enter name of film you want to search");
                    String name = scanner.nextLine();
                    List<ShowTime> result = searchByName(name);
                    displayListShowTimes(result);
                    break;
                case 6:
                    AdminView adminView = new AdminView();
                    adminView.launcher();
                    break;
            }
            checkAction = checkActionContinue();
        } while (checkAction);
    }

    public List<ShowTime> searchByName(String name) {
        return showTimeService.searchByName(name);
    }

    public void addNewShowTime() {
        long id = System.currentTimeMillis() % 1000;
        filmView.showAllFilms();
        //long id, long idFilm, Date startTime, ERoom idRoom, EType type
        ShowTime showtime = new ShowTime();
        System.out.println("Please choose film by ID");
        long idFilm = Long.parseLong(scanner.nextLine());
        showtime.setId(id);
        showtime.setIdFilm(idFilm);
        //start time, room
        String start;
        boolean checkStartTime = false;
        Date startTime;
        ERoom room;
        do {
            System.out.println("Enter start time (Please enter the correct format: 'year-month-day hour:minute')");
            System.out.println("Ex: 2023-01-01 00:00");
            start = scanner.nextLine();
            renderRoom();
            long idRoom = Long.parseLong(scanner.nextLine());
            room = ERoom.toERoom(idRoom);
            startTime = DateUtils.parseDate(start);
            showtime.setStartTime(startTime);
            showtime.setIdRoom(room);
            showtime.setEndTime(DateUtils.plusTime(startTime, filmService.findDurationTimeById(idFilm)));
            checkStartTime = validateShowTime.checkNewValidateShowTime(start, showtime);
            if (checkStartTime) {
                System.out.println("Incorrect format or showtime already exists. Please re-enter");
            }
        } while (checkStartTime);
        //format
        renderFormatFilm();
        long idFormat = Long.parseLong(scanner.nextLine());
        EFormat format = EFormat.toFormat(idFormat);
        showtime.setFormat(format);
        showTimeService.add(showtime);
        checkBeforeSave(showtime);
    }

    public boolean checkBeforeSave(ShowTime showTime) {
        System.out.println("Please check information before save");
        displayShowTime(showTime);
        System.out.println("Do you want to save? Y/N");
        String choice = scanner.nextLine().toUpperCase();
        boolean save;
        switch (choice) {
            case "Y":
                save = true;
                break;
            case "N":
                save = false;
                System.out.println("If you want to edit, please enter 1");
                System.out.println("If you want to cancel, please enter 2");
                int choose = Integer.parseInt(scanner.nextLine());
                if (choose == 1) {
                    editShowTime(showTime);
                    break;
                } else {
                    showTimeService.deleteById(showTime.getId());
                    break;
                }
            default:
                System.out.println("Invalid value. Saved your information");
                save = false;
        }
        return save;
    }

    public boolean checkShowTimeBeforeNow(ShowTime showTime) {
        Date now = new Date();
        if (showTime.getStartTime().before(now)) {
            return true;
        }
        return false;
    }

    public void editShowTime(ShowTime showTime) {
        boolean continueEdit;
        do {
            System.out.println("                                                ┌-----------------EDIT-----------------┐");
            System.out.println("                                                |         [1] Edit ID's film           |");
            System.out.println("                                                |         [2] Edit start time          |");
            System.out.println("                                                |         [3] Edit ID's room           |");
            System.out.println("                                                |         [4] Edit format film         |");
            System.out.println("                                                └--------------------------------------┘");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    filmView.showAllFilms();
                    System.out.println("Please choose ID's film you want to change");
                    long idFilm = Long.parseLong(scanner.nextLine());
                    showTime.setIdFilm(idFilm);
                    displayShowTime(showTime);
                    break;
                case 2:
                    displayAllShowTimes();
                    String start;
                    System.out.println("Please enter the new start time in the correct format: 'yyyy-MM-dd HH:mm'");
                    do {
                        System.out.println("Enter start time (Please enter the correct format: 'year-month-day hour:minute')");
                        System.out.println("Ex: 2023-01-01 00:00");
                        start = scanner.nextLine();
                        if (validateShowTime.checkEditShowTime(start, showTime)) {
                            System.out.println("Incorrect format or showtime already exists. Please re-enter");
                        }
                    } while (validateShowTime.checkEditShowTime(start, showTime));
                    Date startTime = DateUtils.parseDate(start);
                    showTime.setStartTime(startTime);
                    showTime.setEndTime(DateUtils.plusTime(startTime, filmService.findDurationTimeById(showTime.getIdFilm())));
                    long durationTime = filmService.findDurationTimeById(showTime.getIdFilm());
                    showTime.setEndTime(DateUtils.plusTime(startTime, durationTime));
                    break;
                case 3:
                    displayAllShowTimes();
                    String startTimeEdit = DateUtils.convertDateToString(showTime.getStartTime());
                    long oldIdRoom = showTime.getIdRoom().getId();
                    ERoom oldRoom = ERoom.toERoom(oldIdRoom);
                    do {
                        showTime.setIdRoom(oldRoom);
                        long idRoom;
                        System.out.println("Please choose ID's room you want to change");
                        renderRoom();
                        System.out.print("ID = ");
                        try {
                            idRoom = Long.parseLong(scanner.nextLine());
                        } catch (Exception e) {
                            System.out.println("Invalid value");
                            break;
                        }
                        ERoom room = ERoom.toERoom(idRoom);
                        showTime.setIdRoom(room);
                        if (validateShowTime.checkEditShowTime(startTimeEdit, showTime)) {
                            System.out.println("Showtime already exists. Please re-enter");
                        }
                    } while (validateShowTime.checkEditShowTime(startTimeEdit, showTime));
                    break;
                case 4:
                    filmView.showAllFilms();
                    System.out.println("Please choose ID's format film you want to change");
                    renderFormatFilm();
                    System.out.print("ID = ");
                    long idFormat = Long.parseLong(scanner.nextLine());
                    EFormat format = EFormat.toFormat(idFormat);
                    showTime.setFormat(format);
                    break;
                default:
                    break;
            }
            continueEdit = checkActionContinueEdit();
        } while (continueEdit);
        showTimeService.updateShowTimeById(showTime.getId(), showTime);
        displayShowTime(showTime);
    }

    public boolean checkActionContinueEdit() {
        System.out.println("Do you want to continue to edit? 【Y】(Yes) or 【N】(No)");
        String choice = scanner.nextLine().toUpperCase();
        switch (choice) {
            case "Y":
                return true;
            case "N":
                return false;
            default:
                System.out.println("Please type your choice again");
                return true;
        }
    }

    public boolean checkActionAddNew(String startTime) {
        boolean actionAddNew = false;
        if (DateUtils.validateDateFormat(startTime) && validateShowTime.checkDateOfShowTime(startTime)) {
            actionAddNew = true;
        }
        return actionAddNew;
    }

    public void deleteShowTime() {
        displayAllShowTimes();
        System.out.println("Enter ID's showtime you want to delete ");
        long idShowtime = Long.parseLong(scanner.nextLine());
        showTimeService.deleteById(idShowtime);
        displayAllShowTimes();
    }

    public void displayAllShowTimes() {
        List<ShowTime> list = showTimeService.getAllShowTimes();
        System.out.println("                        ╔═══════╦══════════════════════════════╦═════════════════════╦═════════════════════╦════════╦════════╗");
        System.out.printf("                        ║%7s║%-30s║ %-20s║ %-20s║ %-7s║ %-7s║", "ID", "Film Name", "Start Time", "End Time", "Room", "Format");
        System.out.println();
        System.out.println("                        ╠═══════╬══════════════════════════════╬═════════════════════╬═════════════════════╬════════╬════════╣");
        for (int i = 0; i < list.size(); i++) {
            if (i == (list.size() - 1)) {
                System.out.println(list.get(i).toView());
                System.out.println("                        ╚═══════╩══════════════════════════════╩═════════════════════╩═════════════════════╩════════╩════════╝");
            } else {
                System.out.println(list.get(i).toView());
                System.out.println("                        ╠═══════╬══════════════════════════════╬═════════════════════╬═════════════════════╬════════╬════════╣");
            }
        }
    }

    public void displayListShowTimes(List<ShowTime> showTimes) {
        System.out.println("                        ╔═══════╦══════════════════════════════╦═════════════════════╦═════════════════════╦════════╦════════╗");
        System.out.printf("                        ║%7s║%-30s║ %-20s║ %-20s║ %-7s║ %-7s║", "ID", "Film Name", "Start Time", "End Time", "Room", "Format");
        System.out.println();
        System.out.println("                        ╠═══════╬══════════════════════════════╬═════════════════════╬═════════════════════╬════════╬════════╣");
        for (int i = 0; i < showTimes.size(); i++) {
            if (i == (showTimes.size() - 1)) {
                System.out.println(showTimes.get(i).toView());
                System.out.println("                        ╚═══════╩══════════════════════════════╩═════════════════════╩═════════════════════╩════════╩════════╝");
            } else {
                System.out.println(showTimes.get(i).toView());
                System.out.println("                        ╠═══════╬══════════════════════════════╬═════════════════════╬═════════════════════╬════════╬════════╣");
            }
        }
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

    public void displayShowTime(ShowTime showTime) {
        System.out.println("                        ╔═══════╦══════════════════════════════╦═════════════════════╦═════════════════════╦════════╦════════╗");
        System.out.printf("                        ║%7s║%-30s║ %-20s║ %-20s║ %-7s║ %-7s║", "ID", "Film Name", "Start Time", "End Time", "Room", "Format");
        System.out.println();
        System.out.println("                        ╠═══════╬══════════════════════════════╬═════════════════════╬═════════════════════╬════════╬════════╣");
        System.out.println(showTime.toView());
        System.out.println("                        ╚═══════╩══════════════════════════════╩═════════════════════╩═════════════════════╩════════╩════════╝");
    }

    public void renderFormatFilm() {
        System.out.println("                                                ┌───────────────┬───────────────┐");
        System.out.printf("                                                |%-15s|%-15s|", "ID", "Format");
        System.out.println();
        System.out.println("                                                ├───────────────┼───────────────┤");
        EFormat[] formats = EFormat.values();
        for (int i = 0; i < formats.length; i++) {
            if (i == (formats.length - 1)) {
                System.out.printf("                                                |%-15s|%-15s|", formats[i].getId(), formats[i].getName());
                System.out.println();
                System.out.println("                                                └───────────────┴───────────────┘");
            } else {
                System.out.printf("                                                |%-15s|%-15s|", formats[i].getId(), formats[i].getName());
                System.out.println();
                System.out.println("                                                ├---------------┼---------------┤");
            }
        }
    }

    public void renderRoom() {
        System.out.println("                                                ┌───────────────┬───────────────┐");
        System.out.printf("                                                |%-15s|%-15s|", "ID", "ROOM NAME");
        System.out.println();
        System.out.println("                                                ├───────────────┼───────────────┤");
        ERoom[] rooms = ERoom.values();
        for (int i = 0; i < rooms.length; i++) {
            if (i == (rooms.length - 1)) {
                System.out.printf("                                                |%-15s|%-15s|", rooms[i].getId(), rooms[i].getName());
                System.out.println();
                System.out.println("                                                └───────────────┴───────────────┘");
            } else {
                System.out.printf("                                                |%-15s|%-15s|", rooms[i].getId(), rooms[i].getName());
                System.out.println();
                System.out.println("                                                ├---------------┼---------------┤");
            }
        }
    }
}
