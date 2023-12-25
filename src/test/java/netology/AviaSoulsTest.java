package netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AviaSoulsTest {

    @Test
    public void FindAllTickets() {
        AviaSouls repo = new AviaSouls();
        Ticket ticket1 = new Ticket("Москва", "Екатеренбург", 7500, 12, 15);
        Ticket ticket2 = new Ticket("Екатеренбург", "Волгоград", 8000, 15, 19);
        Ticket ticket3 = new Ticket("Волгоград", "Москва", 7000, 19, 22);

        Ticket ticket4 = new Ticket("Москва", "Екатеренбург", 8500, 10, 12);
        Ticket ticket5 = new Ticket("Екатеренбург", "Волгоград", 9500, 18, 21);
        Ticket ticket6 = new Ticket("Волгоград", "Москва", 9000, 21, 23);

        repo.add(ticket1);
        repo.add(ticket2);
        repo.add(ticket3);
        repo.add(ticket4);
        repo.add(ticket5);
        repo.add(ticket6);

        Ticket[] actual = repo.findAll();
        Ticket[] expected = {ticket1, ticket2, ticket3, ticket4, ticket5, ticket6};

        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void SearchTicket() {
        AviaSouls repo = new AviaSouls();
        Ticket ticket1 = new Ticket("Москва", "Екатеренбург", 7500, 12, 15);
        Ticket ticket2 = new Ticket("Екатеренбург", "Волгоград", 8000, 15, 19);
        Ticket ticket3 = new Ticket("Волгоград", "Москва", 7000, 19, 22);

        Ticket ticket4 = new Ticket("Москва", "Екатеренбург", 8500, 10, 12);
        Ticket ticket5 = new Ticket("Екатеренбург", "Волгоград", 9500, 18, 21);
        Ticket ticket6 = new Ticket("Волгоград", "Москва", 9000, 21, 23);

        repo.add(ticket1);
        repo.add(ticket2);
        repo.add(ticket3);
        repo.add(ticket4);
        repo.add(ticket5);
        repo.add(ticket6);

        Ticket[] actual = repo.search("Екатеренбург", "Волгоград");
        Ticket[] expected = {ticket2, ticket5};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchForNonExistentTickets() {
        AviaSouls repo = new AviaSouls();
        Ticket ticket1 = new Ticket("Москва", "Екатеренбург", 7500, 12, 15);
        Ticket ticket2 = new Ticket("Екатеренбург", "Волгоград", 8000, 15, 19);
        Ticket ticket3 = new Ticket("Волгоград", "Москва", 7000, 19, 22);

        Ticket ticket4 = new Ticket("Москва", "Екатеренбург", 8500, 10, 12);
        Ticket ticket5 = new Ticket("Екатеренбург", "Волгоград", 9500, 18, 21);
        Ticket ticket6 = new Ticket("Волгоград", "Москва", 9000, 21, 23);

        repo.add(ticket1);
        repo.add(ticket2);
        repo.add(ticket3);
        repo.add(ticket4);
        repo.add(ticket5);
        repo.add(ticket6);

        Ticket[] actual = repo.search("Екатеренбург", "Москва");
        Ticket[] expected = {};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchForOneTicket() {
        AviaSouls repo = new AviaSouls();
        Ticket ticket1 = new Ticket("Москва", "Екатеренбург", 7500, 12, 15);
        Ticket ticket2 = new Ticket("Екатеренбург", "Волгоград", 8000, 15, 19);
        Ticket ticket3 = new Ticket("Волгоград", "Москва", 7000, 19, 22);

        Ticket ticket4 = new Ticket("Москва", "Екатеренбург", 8500, 10, 12);
        Ticket ticket5 = new Ticket("Екатеренбург", "Волгоград", 9500, 18, 21);
        Ticket ticket6 = new Ticket("Волгоград", "Москва", 9000, 21, 23);

        Ticket ticket7 = new Ticket("Москва", "Сочи", 12000, 15, 19);
        repo.add(ticket1);
        repo.add(ticket2);
        repo.add(ticket3);
        repo.add(ticket4);
        repo.add(ticket5);
        repo.add(ticket6);
        repo.add(ticket7);

        Ticket[] actual = repo.search("Москва", "Сочи");
        Ticket[] expected = {ticket7};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchTicketComparator() {
        AviaSouls repo = new AviaSouls();
        Ticket ticket1 = new Ticket("Москва", "Екатеренбург", 7500, 12, 15);
        Ticket ticket2 = new Ticket("Екатеренбург", "Волгоград", 8000, 15, 19);
        Ticket ticket3 = new Ticket("Волгоград", "Москва", 7000, 19, 22);

        Ticket ticket4 = new Ticket("Москва", "Екатеренбург", 8500, 10, 12);
        Ticket ticket5 = new Ticket("Екатеренбург", "Волгоград", 9500, 18, 21);
        Ticket ticket6 = new Ticket("Волгоград", "Москва", 9000, 21, 23);

        repo.add(ticket1);
        repo.add(ticket2);
        repo.add(ticket3);
        repo.add(ticket4);
        repo.add(ticket5);
        repo.add(ticket6);

        TicketTimeComparator comparator = new TicketTimeComparator();
        Ticket[] actual = repo.searchAndSortBy("Екатеренбург", "Волгоград", comparator);
        Ticket[] expected = {ticket5, ticket2};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchForNonExistentTicketComparator() {
        AviaSouls repo = new AviaSouls();
        Ticket ticket1 = new Ticket("Москва", "Екатеренбург", 7500, 12, 15);
        Ticket ticket2 = new Ticket("Екатеренбург", "Волгоград", 8000, 15, 19);
        Ticket ticket3 = new Ticket("Волгоград", "Москва", 7000, 19, 22);

        Ticket ticket4 = new Ticket("Москва", "Екатеренбург", 8500, 10, 12);
        Ticket ticket5 = new Ticket("Екатеренбург", "Волгоград", 9500, 18, 21);
        Ticket ticket6 = new Ticket("Волгоград", "Москва", 9000, 21, 23);

        repo.add(ticket1);
        repo.add(ticket2);
        repo.add(ticket3);
        repo.add(ticket4);
        repo.add(ticket5);
        repo.add(ticket6);

        TicketTimeComparator comparator = new TicketTimeComparator();
        Ticket[] actual = repo.searchAndSortBy("Екатеренбург", "Москва", comparator);
        Ticket[] expected = {};
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void searchForOneTicketComparator() {
        AviaSouls repo = new AviaSouls();
        Ticket ticket1 = new Ticket("Москва", "Екатеренбург", 7500, 12, 15);
        Ticket ticket2 = new Ticket("Екатеренбург", "Волгоград", 8000, 15, 19);
        Ticket ticket3 = new Ticket("Волгоград", "Москва", 7000, 19, 22);

        Ticket ticket4 = new Ticket("Москва", "Екатеренбург", 8500, 10, 12);
        Ticket ticket5 = new Ticket("Екатеренбург", "Волгоград", 9500, 18, 21);
        Ticket ticket6 = new Ticket("Волгоград", "Москва", 9000, 21, 23);

        Ticket ticket7 = new Ticket("Москва", "Сочи", 12000, 15, 19);
        repo.add(ticket1);
        repo.add(ticket2);
        repo.add(ticket3);
        repo.add(ticket4);
        repo.add(ticket5);
        repo.add(ticket6);
        repo.add(ticket7);

        TicketTimeComparator comparator = new TicketTimeComparator();
        Ticket[] actual = repo.searchAndSortBy("Москва", "Сочи", comparator);
        Ticket[] expected = {ticket7};
        Assertions.assertArrayEquals(expected, actual);
    }
}