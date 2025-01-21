
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.bookingSystem.factory.BookingFactory;
import com.bookingSystem.model.Availability;
import com.bookingSystem.model.Hotel;
import com.bookingSystem.model.HotelBooking;
import com.bookingSystem.model.Room;
import com.bookingSystem.model.User;
import com.bookingSystem.service.impl.HotelBookingServiceImpl;
import com.bookingSystem.service.impl.HotelServiceImpl;
import com.bookingSystem.service.impl.RoomServiceImpl;
import com.bookingSystem.service.inter.IBookingService;
import com.bookingSystem.util.BookingUtil;
import com.bookingSystem.util.ExceptionUtil;

/**
 * The Main class provides a simple command-line interface for the hotel booking system.
 */
public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Hotel> hotels = new ArrayList<>();
    private static final List<HotelBooking> bookings = new ArrayList<>();
    private static final HotelServiceImpl hotelService = new HotelServiceImpl();
    private static final IBookingService<HotelBooking> hotelBookingServiceimpl = new HotelBookingServiceImpl();
    private static final ExceptionUtil exceptionUtil = ExceptionUtil.getInstance();
    private static final RoomServiceImpl roomServiceImpl = new RoomServiceImpl();
    private static final BookingUtil bookingUtil = new BookingUtil();
    /**
     * Main method to run the hotel booking system.
     * @param args
     */
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
                    exceptionUtil.invalidChoice();
                }
            }
        }
    }
    
    /**
     * Displays the availability of rooms in all hotels.
     * Used for 1st choice in the main menu.
     */
    private static void viewAvailability(){
        List<Hotel> matchingHotels = hotelService.findAllAvailbleHotels(hotels);

        if (matchingHotels.isEmpty()) {
            exceptionUtil.noHotelFound();
            return;
        }

        ExceptionUtil.printBefore();
        for (Hotel hotel : matchingHotels) {
            System.out.println("Hotel : " + hotel.getName()+" Location : "+hotel.getLocation());
            for (Room room : hotel.getRooms()) {
                System.out.println("    - Room Type : " + room.getRoomType() + ", Price : Rs " + room.getPricePerNight());
                if(room.getAvailability().size() == 0){
                    System.out.println("        - All Rooms are booked");
                }
                else{
                    for(Availability a : room.getAvailability()){
                        if(!a.getIsBooked()){
                            System.out.println("        - Available from : "+a.getStartDate()+" to "+a.getEndDate());
                        }
                    }
                }
                
            }
            System.out.println();
        }

        ExceptionUtil.printAfter();
    }

    /**
     * Initializes the hotels with rooms and availability.
     */
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

    /**
     * Searches for hotels in a city based on the check-in and check-out dates.
     * Used for 2nd choice in the main menu.
     */
    private static void searchHotelByCity() {
        List<String> availableCity = new ArrayList<>();
        for(Hotel h : hotels){
            if(!availableCity.contains(h.getLocation())){
                availableCity.add(h.getLocation());
            }
        }
        
        System.out.print("Select city for booking -> ");
        for (int i = 0; i < availableCity.size(); i++) {
            System.out.print("\n"+(i + 1) + ". " + availableCity.get(i));
        }
        System.out.print("\nEnter choice : ");
        int cityChoice = 0;
        String city = null;
        try{
            cityChoice = Integer.parseInt(scanner.nextLine());
            city = availableCity.get(cityChoice - 1);
        }
        catch(Exception e){
            exceptionUtil.invalidChoice();
            return;
        }
        System.out.print("Enter Check-in Date (YYYY-MM-DD) : ");
        LocalDate checkInDate = null;

        try{
            checkInDate =  LocalDate.parse(scanner.nextLine());
        }
        catch(Exception e){
            exceptionUtil.invalideDateFormat();
            return;
        }

        System.out.print("Enter Check-out Date (YYYY-MM-DD) : ");
        LocalDate checkOutDate = null;

        try{
            checkOutDate = LocalDate.parse(scanner.nextLine());
        }
        catch(Exception e){
            exceptionUtil.invalideDateFormat();
            return;
        }

        if (checkInDate.isAfter(checkOutDate) || checkInDate.isEqual(checkOutDate)) {
            exceptionUtil.checkInDateExecpetion();
            return;
        }

        List<Hotel> matchingHotels = hotelService.findHotelsByCityAndAvailability(hotels, city, checkInDate, checkOutDate);

        if (matchingHotels.isEmpty()) {
            exceptionUtil.noHotelFound();
            return;
        }

        ExceptionUtil.printBefore();
        System.out.println("Hotels available in " + city + " -> ");

        for (Hotel hotel : matchingHotels) {
            System.out.println("Hotel : " + hotel.getName());
            for (Room room : hotel.getRooms()) {
                if (roomServiceImpl.isAvailable(room, checkInDate, checkOutDate)) {
                    System.out.println("    - Room Type : " + room.getRoomType() + ", Price : Rs " + room.getPricePerNight()+" per night");
                }
            }
        }
        ExceptionUtil.printAfter();
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
            exceptionUtil.invalidChoice();
        }
    }

    /**
     * Displays the bookings made by the user.
     * Used for 3rd choice in the main menu.
     */
    private static void viewBookings() {
        System.out.print("Enter your name to view bookings : ");
        String name = scanner.nextLine();
        boolean found = false;

        for (HotelBooking booking : bookings) {
            if (booking.getUser().getName().equalsIgnoreCase(name)) {
                found = true;
                ExceptionUtil.printBefore();
                bookingUtil.printBookingDetails(booking);
                ExceptionUtil.printAfter();
            }
        }

        if (!found) {
            exceptionUtil.noBookingFound(name);
        }
    }

    /**
     * Books a hotel based on the user's choice.
     * Used for 1st choice in the searchHotelByCity subMenu method.
     * @param matchingHotels
     * @param checkInDate
     * @param checkOutDate
     */
    private static void bookHotel(List<Hotel> matchingHotels, LocalDate checkInDate, LocalDate checkOutDate) {
        System.out.println("Enter Booking Deatils ");
        System.out.print("Enter your name : ");
        String name = scanner.nextLine();
        System.out.print("Enter mobile number : ");
        String contactInfo = scanner.nextLine();

        if(contactInfo.length() != 10){
            exceptionUtil.invalidMobileNumber();
            return;
        }
        else if(!contactInfo.matches("[0-9]+")){
            exceptionUtil.mobileNumberDigits();
            return;
        }

        System.out.println("Select Hotel -> ");
        for (int i = 0; i < matchingHotels.size(); i++) {
            System.out.println((i + 1) + ". " + matchingHotels.get(i).getName());
        }

        System.out.print("Enter choice : ");
        int hotelChoice = 0;
        Hotel selectedHotel = null;

        try{
            hotelChoice = Integer.parseInt(scanner.nextLine());
            selectedHotel = matchingHotels.get(hotelChoice - 1);
        }catch(Exception e){
            exceptionUtil.invalidChoice();
            return;
        }
        
        if(selectedHotel != null){
            System.out.println("Select Room Type -> ");
            List<Room> availableRooms = new ArrayList<>();
            for (Room room : selectedHotel.getRooms()) {
                if (roomServiceImpl.isAvailable(room, checkInDate, checkOutDate)) {
                    availableRooms.add(room);
                }
            }
            for (int i = 0; i < availableRooms.size(); i++) {
                System.out.println((i + 1) + ". " + availableRooms.get(i).getRoomType());
            }

            System.out.print("Enter choice : ");
            int roomChoice = -1;
            Room selectedRoom = null;
            
            try{
                roomChoice =  Integer.parseInt(scanner.nextLine());
                selectedRoom = availableRooms.get(roomChoice - 1);
            } 
            catch(Exception e){ 
                exceptionUtil.invalidChoice();
                return;
            }

            int index = roomServiceImpl.getIndexforAvailable(selectedRoom, checkInDate, checkOutDate);
            if(index == -1){
                exceptionUtil.invalidChoice();
                return;
            }

            roomServiceImpl.findDifference(selectedRoom, index, checkInDate, checkOutDate);
        
            User user = new User(name, contactInfo);
            HotelBooking book = BookingFactory.createHotelBooking(user, selectedHotel, selectedRoom, checkInDate, checkOutDate, index);
            HotelBooking booking = (HotelBooking) hotelBookingServiceimpl.createBooking(user, book);
            bookings.add(booking);

            ExceptionUtil.printBefore();
            System.out.println("Hurry!!! Booking confirmed!");
            bookingUtil.printBookingDetails(booking);
            ExceptionUtil.printAfter();
        }
        
    }  
}