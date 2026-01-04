import java.util.*;

class Room{
    Scanner sc = new Scanner(System.in);
    List<Integer> room = new ArrayList<>(Arrays.asList(101, 102, 103, 104, 105));

    void bookRoom() {
        System.out.println("We have " + room.size() + " rooms available.");
        System.out.print("Enter the number of room/rooms you would to Book: ");
        int count = sc.nextInt();

        if(count > room.size() ) {
            System.out.println("Sorry we don't have rooms available ");
            System.out.println("Please try again with the valid number of room.");
            bookRoom();
        } else {
            System.out.println("Your order is successful");
            for(int i =0; i<count; i++){
                int roomBooked = room.remove(0);
                System.out.println("Room Number is [" + roomBooked + "]");
            }
        }
    }

    void checkOut() {

        System.out.print("\nEnter the number of rooms you booked: ");
        int count = sc.nextInt();

        if (count > room.size()) {
            System.out.println("Invalid room number");
            checkOut();
        } else {
            for(int i =0; i < count; i++) {
                System.out.print("\nEnter the room number you where staying in: ");
                int roomCheckOut = sc.nextInt();

                if(room.contains(roomCheckOut)) {
                    System.out.println("Invalid room number.");
                    System.out.println("Room number [" + roomCheckOut + "] is already vacant.");
                    i--;
                } else if( roomCheckOut < 101 || roomCheckOut > 105) {
                    System.out.println("Restricted room number.");
                } else {
                    room.add(roomCheckOut);
                    Collections.sort(room); // Keep the list in sorted order
                    System.out.println("Room number [" + roomCheckOut + "] checked out successfully.");
                }
            }
        }
    }
}

class User extends Room{
    Scanner sc = new Scanner(System.in);

    void menu(){
        boolean c = true;
        while(c) {
            System.out.println("\n========================================");
            System.out.println("-----Welcome to The Hotel Continental-----");
            System.out.println("\nThank you for staying in our Hotel.\nWe will ensure you fun stay with our, proper facilities and delicious food!");
            System.out.println("\n1. Book Room\n2. Check out\n3. Exit Program");
            System.out.print("Enter Your Choice: ");
            int ch = sc.nextInt();

            switch(ch) {
                case 1:
                    System.out.println("\n-----Booking Section-----");
                    bookRoom();
                    break;

                case 2:
                    System.out.println("-----Checkout Section-----");
                    checkOut();
                    System.out.println("Thank you for choosing us.");
                    System.out.println("Visit Again!");
                    break;

                case 3:
                    c = false;
                    break;

                default:
                    System.out.print("Enter the valid choice");
                    menu();
                    break;
            }
        }
    }
}
public class Hotel {
    public static void main(String[] args) {
        User u = new User();
        u.menu();
    }
}