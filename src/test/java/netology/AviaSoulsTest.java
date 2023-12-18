package netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AviaSoulsTest {

    @Test
    public void FindAllTickets() {
        AviaSouls repo = new AviaSouls();
        Ticket ticket1 = new Ticket("Москва", "Екатеренбург", 7500, 14, 18);
        Ticket ticket2 = new Ticket("Екатеренбург", "Волгоград", 8500, 18, 21);
        Ticket ticket3 = new Ticket("Волгоград", "Москва", 7000, 21, 23);
        repo.add(ticket1);
        repo.add(ticket2);
        repo.add(ticket3);
        Ticket[] actual = repo.findAll();
        Ticket[] expected = {ticket1, ticket2, ticket3};

        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void SearchTickets() {
        AviaSouls repo = new AviaSouls();
        Ticket ticket1 = new Ticket("Москва", "Екатеренбург", 7500, 19, 21);
        Ticket ticket2 = new Ticket("Екатеренбург", "Волгоград", 8500, 14, 18);
        repo.add(ticket1);
        repo.add(ticket2);
        Ticket[] actual = repo.search("Екатеренбург", "Волгоград");
        Ticket[] expected = {ticket2};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void SearchTicketsComparator() {
        AviaSouls repo = new AviaSouls();
        Ticket ticket1 = new Ticket("Москва", "Екатеренбург", 7500, 14, 18);
        Ticket ticket2 = new Ticket("Екатеренбург", "Волгоград", 8500, 18, 21);
        repo.add(ticket1);
        repo.add(ticket2);
        TicketTimeComparator comparator = new TicketTimeComparator();
        Ticket[] actual = repo.searchAndSortBy("Екатеренбург", "Волгоград", comparator);
        Ticket[] expected = {ticket2};
        Assertions.assertArrayEquals(expected, actual);
    }
}