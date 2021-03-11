package aitu.oop.finalproject;

import aitu.oop.finalproject.data.ConnectionManager;
import aitu.oop.finalproject.data.PreparedStatementManager;
import aitu.oop.finalproject.repositories.RoomRepository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Menu {
    static Scanner scanner = new Scanner(System.in);

    public static void printMenu(){
        System.out.println("Choose one of the options:\n" +
                "1. Rooms\n" +
                "2. Customers\n" +
                "3. Reservations\n" +
                "4. Billing\n" +
                "5. Quite program");
    }

    public static void getMenuOption(int option){
        switch (option) {
            case 1 -> {
                roomMenuOption();
            }
            case 2 -> {
                customerMenuOption();
            }
            case 3 -> {
                reservationMenuOption();
            }
            case 4 -> {
                billingMenuOption();
            }
            case 5 -> {
                System.out.println("Good bye!");
            }
            default -> throw new IllegalStateException("Unexpected value: " + option);
        }
    }

    public static void roomMenuOption(){
        System.out.println("1. Show list of rooms\n" +
                "2. Show room info\n" +
                "3. Create new room\n" +
                "4. Update room information\n" +
                "5. Delete room from list\n" +
                "6. Back");
        getRoomMenuOption(scanner.nextInt());
    }

    public static void customerMenuOption(){
        System.out.println("1. Show list of customers\n" +
                "2. Show customer info\n" +
                "3. Create new customer\n" +
                "4. Update room information\n" +
                "5. Delete room from list\n" +
                "6. Back");
        getCustomerMenuOption(scanner.nextInt());
    }

    public static void reservationMenuOption(){
        System.out.println("1. Show list of reservations\n" +
                "2. Show reservation info\n" +
                "3. Create new reservation\n" +
                "4. Update reservation info\n" +
                "5. Delete reservation from list\n" +
                "6. Back");
        getReservationMenuOption(scanner.nextInt());
    }

    public static void billingMenuOption(){
        System.out.println("1. Show list of billing\n" +
                "2. Show billing info\n" +
                "3. Create new billing\n" +
                "4. Back");
        getBillingMenuOption(scanner.nextInt());
    }

    public static void getRoomMenuOption(int option){
        switch (option) {
            case 1 -> {
                Connection con = null;
                ResultSet res = null;
                Statement stmt = null;

                con = ConnectionManager.getConnection();
                try{
                    stmt = con.createStatement();
                    String sql = PreparedStatementManager.getRooms();
                    res = stmt.executeQuery(sql);
                    ConsoleTable table = new ConsoleTable();
                    table.setShowVerticalLines(true);
                    table.setHeaders("roomID", "room number", "room type", "number of beds", "customer");
                    while (res.next()){
                        String room_id = String.valueOf(res.getInt("room_id"));
                        String room_number = String.valueOf(res.getInt("room_number"));
                        String room_type = res.getString("room_type");
                        String number_of_beds = String.valueOf(res.getInt("number_of_beds"));
                        String customer_id = String.valueOf(res.getInt("customer_id"));
                        table.addRow(room_id, room_number, room_type, number_of_beds, customer_id);
                    }
                    table.print();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } finally {
                    try{
                        res.close();
                        stmt.close();
                        con.close();
                    } catch (SQLException throwables){
                        throwables.printStackTrace();
                    }
                }
            }
            case 2 -> {
                System.out.println("Please, enter roomID");

                Connection con = null;
                ResultSet res = null;
                Statement stmt = null;

                con = ConnectionManager.getConnection();
                try{
                    stmt = con.createStatement();
                    String sql = PreparedStatementManager.getRooms(scanner.nextInt());
                    res = stmt.executeQuery(sql);
                    ConsoleTable table = new ConsoleTable();
                    table.setShowVerticalLines(true);
                    table.setHeaders("roomID", "room number", "room type", "number of beds", "customer");
                    while (res.next()){
                        String room_id = String.valueOf(res.getInt("room_id"));
                        String room_number = String.valueOf(res.getInt("room_number"));
                        String room_type = res.getString("room_type");
                        String number_of_beds = String.valueOf(res.getInt("number_of_beds"));
                        String customer_id = String.valueOf(res.getInt("customer_id"));
                        table.addRow(room_id, room_number, room_type, number_of_beds, customer_id);
                    }
                    table.print();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } finally {
                    try{
                        res.close();
                        stmt.close();
                        con.close();
                    } catch (SQLException throwables){
                        throwables.printStackTrace();
                    }
                }
            }
            case 3 -> {
                Integer room_number = null;
                String room_type = null;
                Integer number_of_beds = null;
                Integer customer_id = null;

                System.out.println("Please fill in the following fields:\n");
                System.out.println("1. Room Number");
                room_number = scanner.nextInt();
                System.out.println("2. Room Type");
                room_type = scanner.next();
                System.out.println("3. Number Of Beds");
                number_of_beds = scanner.nextInt();
                System.out.println("4. Customer ID (Print `0` if does not exist)");
                customer_id = scanner.nextInt();

                RoomRepository room = new RoomRepository();
                if(customer_id == 0){
                    if(room.createRoom(room_number,room_type,number_of_beds)){
                        System.out.println("Room successfully registered");
                    } else {
                        System.out.println("Something went wrong");
                    }
                } else {
                    if(room.createRoom(room_number,room_type,number_of_beds,customer_id)){
                        System.out.println("Room successfully registered");
                    } else {
                        System.out.println("Something went wrong");
                    }
                }
            }
            case 4 -> {
                Integer room_id = null;
                Integer room_number = null;
                String room_type = null;
                Integer number_of_beds = null;
                Integer customer_id = null;

                System.out.println("Please fill in the following fields:\n");
                System.out.println("1. Room ID");
                room_id = scanner.nextInt();
                System.out.println("2. Room Number");
                room_number = scanner.nextInt();
                System.out.println("3. Room Type");
                room_type = scanner.next();
                System.out.println("4. Number Of Beds");
                number_of_beds = scanner.nextInt();
                System.out.println("5. Customer ID (Print `0` if does not exist)");
                customer_id = scanner.nextInt();

                RoomRepository room = new RoomRepository();
                if(customer_id == 0){
                    if(room.updateRoom(room_id,room_number,room_type,number_of_beds)){
                        System.out.println("Room info successfully updated");
                    } else {
                        System.out.println("Something went wrong");
                    }
                } else {
                    if(room.updateRoom(room_id,room_number,room_type,number_of_beds,customer_id)){
                        System.out.println("Room info successfully updated");
                    } else {
                        System.out.println("Something went wrong");
                    }
                }
            }
            case 5 -> {
                Integer room_id = null;

                System.out.println("1. Room ID");
                room_id = scanner.nextInt();

                RoomRepository room = new RoomRepository();
                if(room.deleteRoom(room_id)){
                    System.out.println("Room was successfully deleted");
                } else {
                    System.out.println("Something went wrong");
                }
            }
            case 6 -> {
                printMenu();
                getMenuOption(scanner.nextInt());
            }
            default -> throw new IllegalStateException("Unexpected value: " + option);
        }
        if(option != 6){
            roomMenuOption();
        }
    }

    public static void getCustomerMenuOption(int option){
        switch (option) {
            case 1 -> {
                Connection con = null;
                ResultSet res = null;
                Statement stmt = null;

                con = ConnectionManager.getConnection();
                try{
                    stmt = con.createStatement();
                    String sql = PreparedStatementManager.getCustomers();
                    res = stmt.executeQuery(sql);
                    ConsoleTable table = new ConsoleTable();
                    table.setShowVerticalLines(true);
                    table.setHeaders("customerID", "firstname", "lastname", "phonenumber", "country", "city");
                    while (res.next()){
                        String customer_id = String.valueOf(res.getInt("customer_id"));
                        String firstname = res.getString("firstname");
                        String lastname = res.getString("lastname");
                        String phonenumber = res.getString("phonenumber");
                        String country = res.getString("country");
                        String city = res.getString("city");
                        table.addRow(customer_id, firstname, lastname, phonenumber, country, city);
                    }
                    table.print();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } finally {
                    try{
                        res.close();
                        stmt.close();
                        con.close();
                    } catch (SQLException throwables){
                        throwables.printStackTrace();
                    }
                }
            }
            case 2 -> {
                System.out.println("Please, enter customerID");

                Connection con = null;
                ResultSet res = null;
                Statement stmt = null;

                con = ConnectionManager.getConnection();
                try{
                    stmt = con.createStatement();
                    String sql = PreparedStatementManager.getCustomers(scanner.nextInt());
                    res = stmt.executeQuery(sql);
                    ConsoleTable table = new ConsoleTable();
                    table.setShowVerticalLines(true);
                    table.setHeaders("customerID", "firstname", "lastname", "phonenumber", "country", "city");
                    while (res.next()){
                        String customer_id = String.valueOf(res.getInt("customer_id"));
                        String firstname = res.getString("firstname");
                        String lastname = res.getString("lastname");
                        String phonenumber = res.getString("phonenumber");
                        String country = res.getString("country");
                        String city = res.getString("city");
                        table.addRow(customer_id, firstname, lastname, phonenumber, country, city);
                    }
                    table.print();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } finally {
                    try{
                        res.close();
                        stmt.close();
                        con.close();
                    } catch (SQLException throwables){
                        throwables.printStackTrace();
                    }
                }
            }
            case 3 -> {
                String firstname = null;
                String lastname = null;
                String phonenumber = null;
                String country = null;
                String city = null;

                System.out.println("Please fill in the following fields:\n");
                System.out.println("1. Firstname");
                firstname = scanner.next();
                System.out.println("2. Lastname");
                lastname = scanner.next();
                System.out.println("3. Phone number");
                phonenumber = scanner.next();
                System.out.println("4. Country");
                country = scanner.next();
                System.out.println("5. City");
                city = scanner.next();

                Connection con = null;
                Boolean res = null;
                Statement stmt = null;

                con = ConnectionManager.getConnection();
                try{
                    stmt = con.createStatement();
                    String sql = PreparedStatementManager.createCustomer(firstname, lastname, phonenumber, country, city);
                    res = stmt.execute(sql);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } finally {
                    try{
                        con.close();
                    } catch (SQLException throwables){
                        throwables.printStackTrace();
                    }
                }
            }
            case 4 -> {
                Integer customer_id = null;
                String firstname = null;
                String lastname = null;
                String phonenumber = null;
                String country = null;
                String city = null;

                System.out.println("Please fill in the following fields:\n");
                System.out.println("1. Customer ID");
                customer_id = scanner.nextInt();
                System.out.println("2. Firstname");
                firstname = scanner.next();
                System.out.println("3. Lastname");
                lastname = scanner.next();
                System.out.println("4. Phone number");
                phonenumber = scanner.next();
                System.out.println("5. Country");
                country = scanner.next();
                System.out.println("6. City");
                city = scanner.next();

                Connection con = null;
                Boolean res = null;
                Statement stmt = null;

                con = ConnectionManager.getConnection();
                try{
                    stmt = con.createStatement();
                    String sql = PreparedStatementManager.updateCustomer(customer_id, firstname, lastname, phonenumber, country, city);
                    res = stmt.execute(sql);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } finally {
                    try{
                        con.close();
                    } catch (SQLException throwables){
                        throwables.printStackTrace();
                    }
                }
            }
            case 5 -> {
                Integer customer_id = null;

                System.out.println("1. Customer ID");
                customer_id = scanner.nextInt();

                Connection con = null;
                Boolean res = null;
                Statement stmt = null;

                con = ConnectionManager.getConnection();
                try{
                    stmt = con.createStatement();
                    String sql = PreparedStatementManager.deleteCustomer(customer_id);
                    res = stmt.execute(sql);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } finally {
                    try{
                        con.close();
                    } catch (SQLException throwables){
                        throwables.printStackTrace();
                    }
                }
            }
            case 6 -> {
                printMenu();
                getMenuOption(scanner.nextInt());
            }
            default -> throw new IllegalStateException("Unexpected value: " + option);
        }
        if(option != 6) {
            customerMenuOption();
        }
    }

    public static void getReservationMenuOption(int option){
        switch (option) {
            case 1 -> {
                Connection con = null;
                ResultSet res = null;
                Statement stmt = null;

                con = ConnectionManager.getConnection();
                try{
                    stmt = con.createStatement();
                    String sql = PreparedStatementManager.getReservations();
                    res = stmt.executeQuery(sql);
                    ConsoleTable table = new ConsoleTable();
                    table.setShowVerticalLines(true);
                    table.setHeaders("reservationNumber", "customerId", "check in date", "check out date", "status", "number of guests", "reservation date", "roomId");
                    while (res.next()){
                        String reservation_number = String.valueOf(res.getInt("reservation_number"));
                        String customer_id = String.valueOf(res.getInt("customer_id"));
                        String check_in_date = res.getString("check_in_date");
                        String check_out_date = res.getString("check_out_date");
                        if(res.getString("check_out_date") == null){
                            check_out_date = "NULL";
                        }
                        String status = String.valueOf(res.getInt("status"));
                        String number_of_guests = String.valueOf(res.getInt("number_of_guests"));
                        String reservation_date = res.getString("reservation_date");
                        String room_id = String.valueOf(res.getInt("room_id"));
                        table.addRow(reservation_number, customer_id, check_in_date, check_out_date, status, number_of_guests, reservation_date, room_id);
                    }
                    table.print();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } finally {
                    try{
                        res.close();
                        stmt.close();
                        con.close();
                    } catch (SQLException throwables){
                        throwables.printStackTrace();
                    }
                }
            }
            case 2 -> {
                System.out.println("Please, enter reservation number");

                Connection con = null;
                ResultSet res = null;
                Statement stmt = null;

                con = ConnectionManager.getConnection();
                try{
                    stmt = con.createStatement();
                    String sql = PreparedStatementManager.getReservations(scanner.nextInt());
                    res = stmt.executeQuery(sql);
                    ConsoleTable table = new ConsoleTable();
                    table.setShowVerticalLines(true);
                    table.setHeaders("reservationNumber", "customerId", "check in date", "check out date", "status", "number of guests", "reservation date", "roomId");
                    while (res.next()){
                        String reservation_number = String.valueOf(res.getInt("reservation_number"));
                        String customer_id = String.valueOf(res.getInt("customer_id"));
                        String check_in_date = res.getString("check_in_date");
                        String check_out_date = res.getString("check_out_date");
                        if(res.getString("check_out_date") == null){
                            check_out_date = "NULL";
                        }
                        String status = String.valueOf(res.getInt("status"));
                        String number_of_guests = String.valueOf(res.getInt("number_of_guests"));
                        String reservation_date = res.getString("reservation_date");
                        String room_id = String.valueOf(res.getInt("room_id"));
                        table.addRow(reservation_number, customer_id, check_in_date, check_out_date, status, number_of_guests, reservation_date, room_id);
                    }
                    table.print();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } finally {
                    try{
                        res.close();
                        stmt.close();
                        con.close();
                    } catch (SQLException throwables){
                        throwables.printStackTrace();
                    }
                }
            }
            case 3 -> {
                Integer customer_id = null;
                String check_in_date = null;
                String check_out_date = null;
                Integer status = null;
                String number_of_guests = null;
                String reservation_date = null;
                Integer room_id = null;

                System.out.println("Please fill in the following fields:\n");
                System.out.println("1. Customer ID");
                customer_id = scanner.nextInt();
                System.out.println("2. Check In Date");
                check_in_date = scanner.next();
                System.out.println("3. Check Out Date (Print NULL if period not expired)");
                check_out_date = scanner.next();
                System.out.println("4. Status");
                status = scanner.nextInt();
                System.out.println("5. Number Of Guests");
                number_of_guests = scanner.next();
                System.out.println("5. Reservation Date");
                reservation_date = scanner.next();
                System.out.println("5. Room ID");
                room_id = scanner.nextInt();

                Connection con = null;
                Boolean res = null;
                Statement stmt = null;

                con = ConnectionManager.getConnection();
                try{
                    stmt = con.createStatement();
                    String sql = null;
                    if(check_out_date.equals("NULL")){
                        sql = PreparedStatementManager.createReservation(customer_id, check_in_date, status, number_of_guests, reservation_date, room_id);
                    } else {
                        sql = PreparedStatementManager.createReservation(customer_id, check_in_date, check_out_date, status, number_of_guests, reservation_date, room_id);
                    }
                    res = stmt.execute(sql);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } finally {
                    try{
                        con.close();
                    } catch (SQLException throwables){
                        throwables.printStackTrace();
                    }
                }
            }
            case 4 -> {
                Integer reservation_number = null;
                Integer customer_id = null;
                String check_in_date = null;
                String check_out_date = null;
                Integer status = null;
                String number_of_guests = null;
                String reservation_date = null;
                Integer room_id = null;

                System.out.println("Please fill in the following fields:\n");
                System.out.println("1. Reservation Number");
                reservation_number = scanner.nextInt();
                System.out.println("1. Customer ID");
                customer_id = scanner.nextInt();
                System.out.println("2. Check In Date");
                check_in_date = scanner.next();
                System.out.println("3. Check Out Date (Print NULL if period not expired)");
                check_out_date = scanner.next();
                System.out.println("4. Status");
                status = scanner.nextInt();
                System.out.println("5. Number Of Guests");
                number_of_guests = scanner.next();
                System.out.println("5. Reservation Date");
                reservation_date = scanner.next();
                System.out.println("5. Room ID");
                room_id = scanner.nextInt();

                Connection con = null;
                Boolean res = null;
                Statement stmt = null;

                con = ConnectionManager.getConnection();
                try{
                    stmt = con.createStatement();
                    String sql = null;
                    if(check_out_date.equals("NULL")){
                        sql = PreparedStatementManager.updateReservation(reservation_number, customer_id, check_in_date, status, number_of_guests, reservation_date, room_id);
                    } else {
                        sql = PreparedStatementManager.updateReservation(reservation_number, customer_id, check_in_date, check_out_date, status, number_of_guests, reservation_date, room_id);
                    }
                    res = stmt.execute(sql);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } finally {
                    try{
                        con.close();
                    } catch (SQLException throwables){
                        throwables.printStackTrace();
                    }
                }
            }
            case 5 -> {
                Integer reservation_number = null;

                System.out.println("1. Reservation Number");
                reservation_number = scanner.nextInt();

                Connection con = null;
                Boolean res = null;
                Statement stmt = null;

                con = ConnectionManager.getConnection();
                try{
                    stmt = con.createStatement();
                    String sql = PreparedStatementManager.deleteReservation(reservation_number);
                    res = stmt.execute(sql);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } finally {
                    try{
                        con.close();
                    } catch (SQLException throwables){
                        throwables.printStackTrace();
                    }
                }
            }
            case 6 -> {
                printMenu();
                getMenuOption(scanner.nextInt());
            }
            default -> throw new IllegalStateException("Unexpected value: " + option);
        }
        if(option != 6) {
            reservationMenuOption();
        }
    }

    public static void getBillingMenuOption(int option){
        switch (option){
            case 1 -> {
                Connection con = null;
                ResultSet res = null;
                Statement stmt = null;

                con = ConnectionManager.getConnection();
                try{
                    stmt = con.createStatement();
                    String sql = PreparedStatementManager.getBillings();
                    res = stmt.executeQuery(sql);
                    ConsoleTable table = new ConsoleTable();
                    table.setShowVerticalLines(true);
                    table.setHeaders("billing", "room charge", "misc charges", "credit card no", "payment date", "customerId");
                    while (res.next()){
                        String billing = String.valueOf(res.getInt("billing"));
                        String room_charge = String.valueOf(res.getInt("room_charge"));
                        String misc_charges = String.valueOf(res.getInt("misc_charges"));
                        String credit_card_no = res.getString("credit_card_no");
                        String payment_date = res.getString("payment_date");
                        String customer_id = String.valueOf(res.getInt("customer_id"));
                        table.addRow(billing, room_charge, misc_charges, credit_card_no, payment_date, customer_id);
                    }
                    table.print();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } finally {
                    try{
                        res.close();
                        stmt.close();
                        con.close();
                    } catch (SQLException throwables){
                        throwables.printStackTrace();
                    }
                }
            }
            case  2 -> {
                System.out.println("Please, enter billing number");

                Connection con = null;
                ResultSet res = null;
                Statement stmt = null;

                con = ConnectionManager.getConnection();
                try{
                    stmt = con.createStatement();
                    String sql = PreparedStatementManager.getBillings(scanner.nextInt());
                    res = stmt.executeQuery(sql);
                    ConsoleTable table = new ConsoleTable();
                    table.setShowVerticalLines(true);
                    table.setHeaders("billing", "room charge", "misc charges", "credit card no", "payment date", "customerId");
                    while (res.next()){
                        String billing = String.valueOf(res.getInt("billing"));
                        String room_charge = String.valueOf(res.getInt("room_charge"));
                        String misc_charges = String.valueOf(res.getInt("misc_charges"));
                        String credit_card_no = res.getString("credit_card_no");
                        String payment_date = res.getString("payment_date");
                        String customer_id = String.valueOf(res.getInt("customer_id"));
                        table.addRow(billing, room_charge, misc_charges, credit_card_no, payment_date, customer_id);
                    }
                    table.print();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } finally {
                    try{
                        res.close();
                        stmt.close();
                        con.close();
                    } catch (SQLException throwables){
                        throwables.printStackTrace();
                    }
                }
            }
            case 3 -> {
                Integer room_charge = null;
                Integer misc_charges = null;
                String credit_card_no = null;
                String payment_date = null;
                Integer customer_id = null;

                System.out.println("Please fill in the following fields:\n");
                System.out.println("1. Room Charge");
                room_charge = scanner.nextInt();
                System.out.println("1. Misc Charges");
                misc_charges = scanner.nextInt();
                System.out.println("2. Credit Card NO");
                credit_card_no = scanner.next();
                System.out.println("3. Payment Date");
                payment_date = scanner.next();
                System.out.println("4. Customer ID");
                customer_id = scanner.nextInt();

                Connection con = null;
                Boolean res = null;
                Statement stmt = null;

                con = ConnectionManager.getConnection();
                try{
                    stmt = con.createStatement();
                    String sql = PreparedStatementManager.createBilling(customer_id, room_charge, misc_charges, credit_card_no, payment_date);
                    res = stmt.execute(sql);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } finally {
                    try{
                        con.close();
                    } catch (SQLException throwables){
                        throwables.printStackTrace();
                    }
                }
            }
            case 4 -> {
                printMenu();
                getMenuOption(scanner.nextInt());
            }
            default -> throw new IllegalStateException("Unexpected value: " + option);
        }
        if(option != 4){
            billingMenuOption();
        }
    }


}
