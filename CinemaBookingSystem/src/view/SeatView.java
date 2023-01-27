package view;

import feature.PrintColor;
import model.EFormat;
import model.ERoom;
import model.Seat;
import model.ShowTime;
import repository.SeatRepository;
import service.SeatService;
import utils.DateUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class SeatView {
    private SeatService seatService;

    public SeatView() {
        seatService = new SeatService();
    }

    public void displayRoomByShowTime(ShowTime showTime) {
        List<Seat> seats = seatService.getSeatsByIdRoom(showTime.getIdRoom());
        ERoom room = showTime.getIdRoom();
        List<Long> occupiedSeatId = new ArrayList<>();
        for (Seat seat : showTime.getOccupiedSeats()) {
            occupiedSeatId.add(seat.getId());
        }
        int row = room.getRow();
        int col = room.getCol();
        int count = 1;
        //ghế trống: 1, còn chỗ: 0
        int[][] demoRoom = new int[row][col];
        for (int i = 0; i < demoRoom.length; i++) {
            for (int j = 0; j < demoRoom[i].length; j++) {
                demoRoom[i][j] = 0;
                for (int k = 0; k < occupiedSeatId.size(); k++) {
                    if (occupiedSeatId.get(k) == seats.get(count - 1).getId()) {
                        demoRoom[i][j] = 1;
                    }
                }
                count++;
            }
        }
        count = 0;
        for (int i = 0; i < demoRoom.length; i++) {
            for (int k = 0; k < demoRoom[i].length; k++) {
                if (demoRoom[i][k] == 1) {
                    System.out.print(PrintColor.RED + "┌─────┐" + PrintColor.RESET);
                } else {
                    System.out.print("┌─────┐");
                }
            }
            System.out.println();
            for (int j = 0; j < demoRoom[i].length; j++) {
                if (demoRoom[i][j] == 0) {
                    System.out.printf("│ %s  │", seats.get(count).getPosition());
                } else {
                    System.out.print(PrintColor.RED);
                    System.out.printf("│ %s  │", seats.get(count).getPosition());
                    System.out.print(PrintColor.RESET);
                }
                count++;
            }
            System.out.println();
            for (int k = 0; k < demoRoom[i].length; k++) {
                if (demoRoom[i][k] == 1) {
                    System.out.print(PrintColor.RED + "└─────┘" + PrintColor.RESET);
                } else {
                    System.out.print("└─────┘");
                }
            }
            System.out.println();
        }
        System.out.println(PrintColor.RED + "┌─────┐");
        System.out.print("│     │");
        System.out.println("  occupied seat         ");
        System.out.println("└─────┘");
        System.out.println(PrintColor.RESET + "┌─────┐");
        System.out.print("│     │");
        System.out.println("  empty seat         ");
        System.out.println("└─────┘");
    }

    public void displayRoom(ERoom room) {
        List<Seat> list = seatService.getSeatsByIdRoom(room);
        int row = room.getRow();
        int col = room.getCol();
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int k = 0; k < col; k++) {
                System.out.print("┌─────┐");
            }
            System.out.println();
            for (int j = 0; j < col; j++) {
                System.out.printf("│ %s  │", list.get(count).getPosition());
                count++;
            }
            System.out.println();
            for (int k = 0; k < col; k++) {
                System.out.print("└─────┘");
            }
            System.out.println();
        }
        System.out.println(PrintColor.RED + "┌─────┐");
        System.out.print("│     │");
        System.out.println("  occupied seat         ");
        System.out.println("└─────┘");
        System.out.println(PrintColor.RESET + "┌─────┐");
        System.out.print("│     │");
        System.out.println("  empty seat         ");
        System.out.println("└─────┘");
    }

    public static void main(String[] args) {
        SeatService service = new SeatService();
        SeatView seatView = new SeatView();
        String date = "2023-01-09 12:00";
        Date start = DateUtils.parseDate(date);
        ShowTime showTime1 = new ShowTime(1, 1, start, ERoom.ROOM_1, EFormat._3D);
        List<Seat> occupiedSeat = new ArrayList<>();
//        occupiedSeat.add(service.getIdSeat(showTime1.getIdRoom(),"A3"));
        occupiedSeat.add(service.findSeatById(3L));
        occupiedSeat.add(service.findSeatById(5L));
        occupiedSeat.add(service.findSeatById(11L));
        occupiedSeat.add(service.findSeatById(10L));
        occupiedSeat.add(service.findSeatById(16L));
        showTime1.setOccupiedSeats(occupiedSeat);
        seatView.displayRoomByShowTime(showTime1);
        System.out.println("---------------------------");
        seatView.displayRoom(ERoom.ROOM_1);
    }
}
