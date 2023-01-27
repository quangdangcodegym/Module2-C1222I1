package repository;

import model.Order;
import model.Ticket;

import java.util.ArrayList;
import java.util.List;

public class TicketRepository extends FileContext<Ticket> {
    public TicketRepository() {
        filePath = "./data/ticket.csv";
        tClass = Ticket.class;
    }
}
