import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.bookingSystem.model.Availability;
import com.bookingSystem.model.Booking;
import com.bookingSystem.model.Hotel;
import com.bookingSystem.model.Room;
import com.bookingSystem.model.User;
import com.bookingSystem.service.BookingService;
import com.bookingSystem.service.HotelService;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Hotel> hotels = new ArrayList<>();
    private static final List<Booking> bookings = new ArrayList<>();
    private static HotelService hotelService = new HotelService();

    public static void main(String[] args) {
        initializeHotels();
        boolean exit = false;

        while (!exit) {
            System.out.println("\nOptions:");
            System.out.println("1. View Availability");
            System.out.println("2. Search hotel by city");
            System.out.println("3. My Bookings");
            System.out.println("4. Exit");
            System.out.println();
            System.out.print("Enter your choice: ");

            int choice = 0;
            try{
                choice = Integer.parseInt(scanner.nextLine());
            }catch(Exception e){ }

            switch (choice) {
                case 1 -> viewAvailability();
                case 2 -> searchHotelByCity();
                case 3 -> viewBookings();
                case 4 -> {
                    exit = true;
                    System.out.println("Exiting the system. Thank you!");
                }
                default -> {
                    System.out.println("------------------------------------");
                    System.out.println();
                    System.out.println("Invalid choice. Please try again.");
                    System.out.println();
                    System.out.println("------------------------------------");
                }
            }
        }
    }
    
    // Get the Availability of the rooms which are available in the hotels
    private static void viewAvailability(){
        List<Hotel> matchingHotels = hotelService.findAllAvailbleHotels(hotels);

        if (matchingHotels.isEmpty()) {
            System.out.println("------------------------------------");
            System.out.println();
            System.out.println("No hotels found");
            System.out.println();
            System.out.println("------------------------------------");
            return;
        }

        System.out.println("------------------------------------");
        System.out.println();
        for (Hotel hotel : matchingHotels) {
            System.out.println("Hotel : " + hotel.getName()+" Location : "+hotel.getLocation());
            for (Room room : hotel.getRooms()) {
                System.out.println("    - Room Type : " + room.getRoomType() + ", Price : Rs " + room.getPricePerNight());
                if(room.getAvailability().size() == 0){
                    System.out.println("        - All Rooms are booked");
                }
                else{
                    for(Availability a : room.getAvailability()){
                        if(a.getIsBooked()){
                            System.out.println("        - Available from : "+a.getStartDate()+" to "+a.getEndDate());
                        }
                    }
                }
                
            }
            System.out.println();
        }

        System.out.println();
        System.out.println("------------------------------------");
    }

    private static void initializeHotels() {
        Hotel hotel1 = new Hotel("Hyatt", "Mumbai");
        Room room1 = new Room("Single", 10000);
        Room room2 = new Room("Double", 15000);
        Room room3 = new Room("Suite", 25000);
        room1.addAvailability(LocalDate.of(2025, 1, 15), LocalDate.of(2025, 1, 20));
        room2.addAvailability(LocalDate.of(2025, 1, 16), LocalDate.of(2025, 1, 22));
        room3.addAvailability(LocalDate.of(2025, 1, 17), LocalDate.of(2025, 1, 22));
        hotel1.addRoom(room1);
        hotel1.addRoom(room2);
        hotel1.addRoom(room3);

        Hotel hotel2 = new Hotel("Raddison", "Pune");
        Room room4 = new Room("Single", 9000);
        Room room5 = new Room("Suite", 20000);
        room4.addAvailability(LocalDate.of(2025, 1, 17), LocalDate.of(2025, 1, 21));
        room5.addAvailability(LocalDate.of(2025, 1, 18), LocalDate.of(2025, 1, 25));
        hotel2.addRoom(room4);
        hotel2.addRoom(room5);

        Hotel hotel3 = new Hotel("Taj", "Mumbai");
        Room room6 = new Room("Single", 12000);
        Room room7 = new Room("Double", 18000);
        Room room8 = new Room("Suite", 30000);
        room6.addAvailability(LocalDate.of(2025, 1, 15), LocalDate.of(2025, 1, 20));
        room7.addAvailability(LocalDate.of(2025, 1, 16), LocalDate.of(2025, 1, 22));    
        room8.addAvailability(LocalDate.of(2025, 1, 17), LocalDate.of(2025, 1, 22));
        hotel3.addRoom(room6);
        hotel3.addRoom(room7);
        hotel3.addRoom(room8);

        Hotel hotel4 = new Hotel("Marriot", "Pune");
        Room room9 = new Room("Single", 10000);
        Room room10 = new Room("Double", 15000);
        Room room11 = new Room("Suite", 25000);
        room9.addAvailability(LocalDate.of(2025, 1, 15), LocalDate.of(2025, 1, 20));
        room10.addAvailability(LocalDate.of(2025, 1, 16), LocalDate.of(2025, 1, 22));
        room11.addAvailability(LocalDate.of(2025, 1, 17), LocalDate.of(2025, 1, 22));
        hotel4.addRoom(room9);
        hotel4.addRoom(room10);
        hotel4.addRoom(room11);

        hotels.add(hotel1);
        hotels.add(hotel2);
        hotels.add(hotel3);
        hotels.add(hotel4);
    }

    private static void searchHotelByCity() {
        System.out.print("Enter city name : ");
        String city = scanner.nextLine();

        System.out.print("Enter Check-in Date (YYYY-MM-DD) : ");
        LocalDate checkInDate = null;

        try{
            checkInDate =  LocalDate.parse(scanner.nextLine());
        }
        catch(Exception e){
            System.out.println("------------------------------------");
            System.out.println();
            System.out.println("Invalid Date Format");
            System.out.println();
            System.out.println("------------------------------------");
            return;
        }

        System.out.print("Enter Check-out Date (YYYY-MM-DD) : ");
        LocalDate checkOutDate = null;

        try{
            checkOutDate = LocalDate.parse(scanner.nextLine());
        }
        catch(Exception e){
            System.out.println("------------------------------------");
            System.out.println();
            System.out.println("OOPS! Invalid Date Format");
            System.out.println();
            System.out.println("------------------------------------");
            return;
        }

        List<Hotel> matchingHotels = hotelService.findHotelsByCityAndAvailability(hotels, city, checkInDate, checkOutDate);

        if (matchingHotels.isEmpty()) {
            System.out.println("------------------------------------");
            System.out.println();
            System.out.println("No hotels found in the specified city or date range.");
            System.out.println();
            System.out.println("------------------------------------");
            return;
        }

        System.out.println("------------------------------------");
        System.out.println();
        System.out.println("Hotels available in " + city + " : ");
        for (Hotel hotel : matchingHotels) {
            System.out.println("Hotel : " + hotel.getName());
            for (Room room : hotel.getRooms()) {
                if (room.isAvailable(checkInDate, checkOutDate)) {
                    System.out.println("    - Room Type : " + room.getRoomType() + ", Price : Rs " + room.getPricePerNight());
                }
            }
        }
        System.out.println();
        System.out.println("------------------------------------");

        System.out.println("\n1. Book hotel");
        System.out.println("2. Back");
        System.out.print("Enter your choice: ");
        int choice = 0;

        try{
            choice = Integer.parseInt(scanner.nextLine());  
        }catch(Exception e){
            System.out.println("Please enter a valid number");
        }
        

        if (choice == 1) {
            bookHotel(matchingHotels, checkInDate, checkOutDate);
        }
        else if(choice != 2){
            System.out.println("------------------------------------");
            System.out.println();
            System.out.println("Invalid choice. Please try again.");
            System.out.println();
            System.out.println("------------------------------------");
        }
    }

    private static void bookHotel(List<Hotel> matchingHotels, LocalDate checkInDate, LocalDate checkOutDate) {
        System.out.print("Enter your name : ");
        String name = scanner.nextLine();
        System.out.print("Enter mobile number : ");
        String contactInfo = scanner.nextLine();

        System.out.println("Select Hotel:");
        for (int i = 0; i < matchingHotels.size(); i++) {
            System.out.println((i + 1) + ". " + matchingHotels.get(i).getName());
        }
        System.out.print("Enter choice: ");
        int hotelChoice = Integer.parseInt(scanner.nextLine());
        Hotel selectedHotel = matchingHotels.get(hotelChoice - 1);

        System.out.println("Select Room Type:");
        List<Room> availableRooms = new ArrayList<>();
        for (Room room : selectedHotel.getRooms()) {
            if (room.isAvailable(checkInDate, checkOutDate)) {
                availableRooms.add(room);
            }
        }
        for (int i = 0; i < availableRooms.size(); i++) {
            System.out.println((i + 1) + ". " + availableRooms.get(i).getRoomType());
        }
        System.out.print("Enter choice: ");
        int roomChoice = Integer.parseInt(scanner.nextLine());
        Room selectedRoom = availableRooms.get(roomChoice - 1);

        int index = selectedRoom.getIndexforAvailable(checkInDate, checkOutDate);
        selectedRoom.findDifference(index, checkInDate, checkOutDate);
        BookingService bookingService = new BookingService();
        User user = new User(name, contactInfo);
        Booking booking = bookingService.createBooking(user, selectedRoom, selectedHotel, checkInDate, checkOutDate);

        bookings.add(booking);

        System.out.println("------------------------------------");
        System.out.println();
        System.out.println("Hurry!!! Booking confirmed!");
        System.out.println("Booking ID : " + booking.getBookingId());
        System.out.println("Location : " + booking.getHotel().getLocation());
        System.out.println("Hotel : " + booking.getHotel().getName());
        System.out.println("Room Type : " + booking.getRoom().getRoomType());
        System.out.println("Check-in : " + booking.getCheckIn());
        System.out.println("Check-out : " + booking.getCheckOut());
        System.out.println();
        System.out.println("------------------------------------");
    }

    private static void viewBookings() {
        System.out.print("Enter your name to view bookings: ");
        String name = scanner.nextLine();
        boolean found = false;

        for (Booking booking : bookings) {
            if (booking.getUser().getName().equalsIgnoreCase(name)) {
                found = true;
                System.out.println("------------------------------------");
                System.out.println();
                System.out.println("Booking ID: " + booking.getBookingId());
                System.out.println("Location : "+booking.getHotel().getLocation());
                System.out.println("Hotel : " + booking.getHotel().getName());
                System.out.println("Room Type : " + booking.getRoom().getRoomType());
                System.out.println("Check-in : " + booking.getCheckIn());
                System.out.println("Check-out : " + booking.getCheckOut());
                System.out.println();
                System.out.println("------------------------------------");
            }
        }

        if (!found) {
            System.out.println("------------------------------------");
            System.out.println();
            System.out.println("No bookings found for " + name);
            System.out.println();
            System.out.println("------------------------------------");
        }
    }
}