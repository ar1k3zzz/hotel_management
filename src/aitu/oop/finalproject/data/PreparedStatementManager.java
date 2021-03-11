package aitu.oop.finalproject.data;

public class PreparedStatementManager {
    public static String getRooms(){
        return "SELECT * FROM rooms";
    }

    public static String getRooms(int room_id){
        return "SELECT * FROM rooms WHERE room_id = " + room_id;
    }

    public static String createRoom(int room_number, String room_type, int number_of_beds){
        return "INSERT INTO rooms(`room_number`,`room_type`,`number_of_beds`) VALUES(" +
                "'" + room_number + "'," +
                "'" + room_type + "'," +
                "'" + number_of_beds + "')";
    }

    public static String createRoom(int room_number, String room_type, int number_of_beds, int customer_id){
        return "INSERT INTO rooms(`room_number`,`room_type`,`number_of_beds`,`customer_id`) VALUES(" +
                "'" + room_number + "'," +
                "'" + room_type + "'," +
                "'" + number_of_beds + "'," +
                "'" + customer_id + "')";
    }

    public static String updateRoom(int room_id, int room_number, String room_type, int number_of_beds){
        return "UPDATE rooms SET " +
                "`room_number` = '" + room_number + "'," +
                "`room_type` = '"+ room_type +"'," +
                "`number_of_beds` = '" + number_of_beds + "'" +
                " WHERE room_id = " + room_id;
    }

    public static String updateRoom(int room_id, int room_number, String room_type, int number_of_beds, int customer_id){
        return "UPDATE rooms SET " +
                "`room_number` = '" + room_number + "'," +
                "`room_type` = '"+ room_type +"'," +
                "`number_of_beds` = '" + number_of_beds + "'," +
                "`customer_id` = '" + customer_id + "'" +
                " WHERE `room_id` = " + room_id;
    }

    public static String deleteRoom(int room_id){
        return "DELETE FROM rooms WHERE room_id = " + room_id;
    }

    public static String getCustomers(){
        return "SELECT * FROM customer";
    }

    public static String getCustomers(int customer_id){
        return "SELECT * FROM customer WHERE customer_id = " + customer_id;
    }

    public static String createCustomer(String firstname, String lastname, String phonenumber, String country, String city){
        return "INSERT INTO customer(`firstname`,`lastname`,`phonenumber`,`country`,`city`) VALUES(" +
                "'" + firstname + "'," +
                "'" + lastname + "'," +
                "'" + phonenumber + "'," +
                "'" + country + "'," +
                "'" + city + "')";
    }

    public static String updateCustomer(int customer_id, String firstname, String lastname, String phonenumber, String country, String city){
        return "UPDATE customer SET " +
                "`firstname` = '" + firstname + "'," +
                "`lastname` = '"+ lastname +"'," +
                "`phonenumber` = '" + phonenumber + "'," +
                "`country` = '" + country + "'," +
                "`city` = '" + city + "'" +
                " WHERE customer_id = " + customer_id;
    }

    public static String deleteCustomer(int customer_id){
        return "DELETE FROM customer WHERE customer_id = " + customer_id;
    }

    public static String getReservations(){
        return "SELECT * FROM reservation";
    }

    public static String getReservations(int reservation_number){
        return "SELECT * FROM reservation WHERE reservation_number = " + reservation_number;
    }

    public static String createReservation(int customer_id, String check_in_date, String check_out_date, int status, String number_of_guests, String reservation_date, int room_id){
        return "INSERT INTO reservation(`customer_id`,`check_in_date`,`check_out_date`,`status`,`number_of_guests`,`reservation_date`,`room_id`) VALUES(" +
                "'" + customer_id + "'," +
                "'" + check_in_date + "'," +
                "'" + check_out_date + "'," +
                "'" + status + "'," +
                "'" + number_of_guests + "'," +
                "'" + reservation_date + "'," +
                "'" + room_id + "')";
    }
    public static String createReservation(int customer_id, String check_in_date, int status, String number_of_guests, String reservation_date, int room_id){
        return "INSERT INTO reservation(`customer_id`,`check_in_date`,`check_out_date`,`status`,`number_of_guests`,`reservation_date`,`room_id`) VALUES(" +
                "'" + customer_id + "'," +
                "'" + check_in_date + "'," +
                "NULL," +
                "'" + status + "'," +
                "'" + number_of_guests + "'," +
                "'" + reservation_date + "'," +
                "'" + room_id + "')";
    }

    public static String updateReservation(int reservation_number, int customer_id, String check_in_date, String check_out_date, int status, String number_of_guests, String reservation_date, int room_id){
        return "UPDATE reservation SET " +
                "`customer_id` = '" + customer_id + "'," +
                "`check_in_date` = '"+ check_in_date +"'," +
                "`check_out_date` = '" + check_out_date + "'," +
                "`status` = '" + status + "'," +
                "`number_of_guests` = '" + number_of_guests + "'," +
                "`reservation_date` = '" + reservation_date + "'," +
                "`room_id` = '" + room_id + "'" +
                " WHERE reservation_number = " + reservation_number;
    }

    public static String updateReservation(int reservation_number, int customer_id, String check_in_date, int status, String number_of_guests, String reservation_date, int room_id){
        return "UPDATE reservation SET " +
                "`customer_id` = '" + customer_id + "'," +
                "`check_in_date` = '"+ check_in_date +"'," +
                "`check_out_date` = NULL," +
                "`status` = '" + status + "'," +
                "`number_of_guests` = '" + number_of_guests + "'," +
                "`reservation_date` = '" + reservation_date + "'," +
                "`room_id` = '" + room_id + "'" +
                " WHERE reservation_number = " + reservation_number;
    }

    public static String deleteReservation(int reservation_number){
        return "DELETE FROM reservation WHERE reservation_number = " + reservation_number;
    }

    public static String getBillings(){
        return "SELECT * FROM billing";
    }

    public static String getBillings(int billing){
        return "SELECT * FROM billing WHERE billing = " + billing;
    }

    public static String createBilling(int customer_id, int room_charge, int misc_charges, String credit_card_no, String payment_date){
        return "INSERT INTO billing(`room_charge`,`misc_charges`,`credit_card_no`,`payment_date`,`customer_id`) VALUES(" +
                "'" + room_charge + "'," +
                "'" + misc_charges + "'," +
                "'" + credit_card_no + "'," +
                "'" + payment_date + "'," +
                "'" + customer_id + "')";
    }

}
