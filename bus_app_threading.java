package Projects;
import java.lang.*;

class BookingSeat {

    int availableTicket = 10;

    public synchronized void book(String name, int seat) {
        for (int i = 1; i <= 3; i++) {
            System.out.println("Hello " + name);
        }
        if (availableTicket >= seat) {
            System.out.println(name + " " + seat + " seats are booked");
            availableTicket -= seat;
        } else {
            System.out.println(name + " sorry");
        }


    }
}

class bus_booking extends Thread {
    int passenger;
    BookingSeat a;
    String name;

    bus_booking(BookingSeat a, int seat, String name) {
        this.passenger = seat;
        this.name = name;
        this.a = a;

    }

    public void run() {
        a.book(name, passenger);

    }
}

public class bus_app_threading {
    public static void main(String[] args) {

        BookingSeat sc = new BookingSeat();

        bus_booking ob = new bus_booking(sc, 6, "Yuvraj");
        bus_booking obj = new bus_booking(sc, 7, "Pratap");

        obj.start();
        ob.start();

    }
}
