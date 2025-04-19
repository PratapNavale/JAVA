import java.util.Scanner;

class TicketBooking extends Thread {
    static int availableTickets = 10;
    int ticketNeeded;
    String customerName;

    TicketBooking(String name, int tickets) {
        this.customerName = name;
        this.ticketNeeded = tickets;
    }

    public void run() {
        synchronized (TicketBooking.class) {
            if (availableTickets >= ticketNeeded) {
                System.out.println(customerName + " is booking " + ticketNeeded + " " +
                        "ticket(s)...");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("Thread interrupted");
                }
                availableTickets -= ticketNeeded;

                System.out.println(customerName + " successfully booked " + ticketNeeded + " ticket(s).");

                System.out.println("Tickets left " + availableTickets);
            } else {
                System.out.println("Sorry " + customerName + " not enough tickets available.");
            }
        }
    }
}

public class TicketBookingApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter total available tickets: ");
        TicketBooking.availableTickets = sc.nextInt();

        System.out.println("Enter nummber of customers: ");
        int numCustomers = sc.nextInt();

        TicketBooking[] customers = new TicketBooking[numCustomers];

        sc.nextLine();

        for(int i=0; i<numCustomers; i++) {
            System.out.println("Enter customer name: ");
            String name = sc.nextLine();
            System.out.println("Enter the number of tickets required: ");
            int tickets = sc.nextInt();
            sc.nextLine();

            customers[i] = new TicketBooking(name, tickets);
        }

        System.out.println("\n---Booking started---\n");
        for(TicketBooking customer : customers) {
            customer.start();
        }

        sc.close();

    }
}