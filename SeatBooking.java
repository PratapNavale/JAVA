package Projects;

import java.lang.*;
import java.util.*;

class Booking {
    Scanner sc = new  Scanner(System.in);
    int seats = 5;


    void greeting(){
        System.out.println("-----Bus Seating Booking-----");
        System.out.print("Enter your name: ");
        String name = sc.nextLine();
        user(name);

    }

    void user(String name1) {
        System.out.println("Hello " + name1 + " welcome to seating booking. "+ seats + " seats are available.");
        seatBook();
    }


    void seatBook() {
        Booking b = new Booking();
            if(seats > 0){
                System.out.println("Seats available are: " + seats);
                System.out.print("How many seats do you want to book: ");
                int seatBook = sc.nextInt();
                if(seatBook > seats) {
                    System.out.println("Sorry seats not available.");
                } else if (seatBook == 0) {
                    System.err.println("Please enter the valid number.");
                    seatBook();;
                } else {
                    System.out.println(seatBook+" ticket booked");
                    System.out.println("Happy journey");

                }
                seats -= seatBook;
                greeting();

            } else{
                System.out.println("The counter is closed.");

            }



    }





}


public class SeatBooking {
    public static void main(String[] args) {
        Scanner sc = new  Scanner(System.in);
        Booking op = new Booking();

    }
}
