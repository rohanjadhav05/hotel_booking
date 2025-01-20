# HOTEL_BOOKING

## Project Description
This project is a hotel booking system that allows users to book rooms in various hotels. 
It includes features such as 
 1. Checking room availability.
 2. Searching Available Room based on city and check in date's.
 3. Book rooms.
 4. View My bookings

## Prerequisites
- Java 8 or higher
- Maven 3.6 or higher
- Git

## Getting Started

### Cloning the Repository
To clone the repository, open your terminal and run the following command :
```sh
git clone https://github.com/rohanjadhav05/hotel_booking.git
```

### Navigating to the Project Directory
Change to the project directory :
```sh
cd hotel_booking/hotel_booking/src/main/java
```

### Compiling the Project
Use the following command to compile your java code : 
```sh
javac Main.java
```

### Running the Application
To run the application, use the following command :
```sh
java Main
```

## Project Structure
The project structure is as follows : 
```
hotel_booking/
├── pom.xml
├── README.md
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── bookingSystem
│   │   │           ├── model
|   |   |                   ├── Availability.java
|   |   |                   ├── BaseEntity.java
|   |   |                   ├── Booking.java
|   |   |                   ├── Hotel.java
|   |   |                   ├── Room.java
|   |   |                   ├── User.java 
│   │   │           ├── service
│   │   │                   ├── impl
│   │   │                         ├── BookingServiceImpl.java
│   │   │                         ├── HotelServiceImpl.java
│   │   │                         ├── RoomServiceImpl.java
│   │   │                   ├── inter
|   |   |                         ├── IBookingService.java
|   |   |                         ├── IHotelService.java
│   │   │                         ├── IRoomService.java
│   │   │           └── util
|   |   |                   ├── BookingUtil.java
│   │   │                   ├── ExceptionUtil.java
|   |   |       └── Main.java
│   │   └── resources
│   └── test
│       ├── java
│       └── resources
```

## Entity Relation Diagram
Below is the Entity relation diagram for the hotel booking system :

![alt text](image-6.png)

### Explanation of the Diagram

1. `BaseEntity` :  This is an abstract root class for the Booking and User classes. It is used to generate a unique ID and record the creation time of the entity. The BaseEntity class ensures that every entity that extends it will have a unique identifier and a timestamp indicating when it was created.
2. `Availability` : Represents the availability status of a room for a specific date range. It  includes fields such as start date, end date, and a boolean indicating whether the room is available.
3. `Booking` : Represents a booking made by a user. It includes details such as booking ID, user information, room information, hotel information, check-in date, and check-out date.  
4. `Hotel` :  Represents a hotel. It includes details such as  name, location, and a list of rooms available in the hotel, here `Booking` class is having one to many relation with `Hotel` entity and `Hotel` is many to one relation with entity `Room`.
5. `Room` : Represents a room in a hotel. It includes details such as room type, pricePerNight, availability status. Here Entity `Room` is having one to many relation with `Availability` entity 
6. `User` : Represents a user of the system. It includes user details such as user ID, name, contact information, and booking history.

## Functionalities Demo

When you run the `Main.java` file, you will see the following options:

![alt text](image.png)

### 1. Checking Room Availability
When the user enters `1` to check room availability, the system will display the available rooms. Below is a screenshot of the availability check process :

![alt text](image-1.png)

### 2. Search hotel by city
When the user enters `2` to search for a hotel by city, the system will provide a choice of cities that are present in the database :

![alt text](image-2.png)

based on selected city suppose user enter's `1` and city `Mumbai` is selected then user need to enter the Check-in Date and Check-out Date in the correct format i.e `YYYY-MM-DD`,
when user enter the check-in date and check-out date in correct format the system will check in database do we have Hotel's have availability for those days if present will print the Hotel name with the room type available, check image for reference

![alt text](image-3.png)

#### 1. Book Hotel

then we get the available hotels if user want to book a hotel then he need to enter `1` proceed with booking hotel, where he need to add the Booking details like name, contact number, based on the available hotel in city he will be shown options in which hotel he need's to select 1 option, and the room type after entering the details we will get a confirmation message that hotel has been booking with the booking details.

![alt text](image-4.png)

#### 2. Back

if user enter option `2` then he will be navigated to previous menu

### 3. My Bookings

If user want to check his booking then when he enter's option `3` and selected My Bookings she must enter the name with which he had made the booking by entering the name the list of booking made my user will be displayed.

![alt text](image-5.png)

### 4. Exit

When user select option `4` the program will stop its execution.

## OOPS Concepts Implementation

1. **Abstraction**: 
   - Created the abstract class `BaseEntity` and service layer interfaces which are implemented to achieve abstraction. This allows us to define common properties and methods that can be shared across multiple classes while hiding the implementation details.

2. **Encapsulation**: 
   - Encapsulated the properties of classes by making them private and providing public getter and setter methods. This ensures that the internal state of an object is protected and can only be accessed or modified through controlled methods.

3. **Inheritance**: 
   - Added the `BaseEntity` class which is extended by other classes such as `Booking` and `User`. This allows these classes to inherit common properties and methods from `BaseEntity`, promoting code reuse and reducing redundancy.

4. **Polymorphism**: 
   - Implemented polymorphism through method overriding and interface implementation. For example, different service implementations (`BookingServiceImpl`, `HotelServiceImpl`, `RoomServiceImpl`) provide specific behaviors for the methods defined in their respective interfaces (`IBookingService`, `IHotelService`, `IRoomService`).

5. **Modularity**: 
    - The project is organized into different packages such as `model`, `service`, and `util`, each containing related classes. This modular structure makes the codebase more manageable and promotes separation of concerns.

6. **Composition**: 
   - Used composition to build complex objects from simpler ones. For example, a `Hotel` object contains a list of `Room` objects, and a `Booking` object contains references to `User`, `Room`, and `Hotel` objects. This allows for a more modular and flexible design.
 

These OOP principles help in creating a well-structured, maintainable, and scalable hotel booking system.


## Contact
If you have any questions or need further assistance, feel free to contact the project maintainer at rohan.jadhav511@gmail.com.

Thank you for using our hotel booking system!


