package aitu.oop.finalproject.entities;

public class Reservation{
    private int reservation_number;
    private int customer_id;
    private String check_in_date;
    private String check_out_date;
    private int status;
    private int numberOfGuests;
    private String reservation_date;
    private int room_id;

    public Reservation(int customer_id, String check_in_date, String check_out_date, int status, int numberOfGuests, String reservation_date, int room_id) {
        this.customer_id = customer_id;
        this.check_in_date = check_in_date;
        this.check_out_date = check_out_date;
        this.status = status;
        this.numberOfGuests = numberOfGuests;
        this.reservation_date = reservation_date;
        this.room_id = room_id;
    }

    public int getReservation_number() {
        return reservation_number;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getCheck_in_date() {
        return check_in_date;
    }

    public void setCheck_in_date(String check_in_date) {
        this.check_in_date = check_in_date;
    }

    public String getCheck_out_date() {
        return check_out_date;
    }

    public void setCheck_out_date(String check_out_date) {
        this.check_out_date = check_out_date;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getNumberOfGuests() {
        return numberOfGuests;
    }

    public void setNumberOfGuests(int numberOfGuests) {
        this.numberOfGuests = numberOfGuests;
    }

    public String getReservation_date() {
        return reservation_date;
    }

    public void setReservation_date(String reservation_date) {
        this.reservation_date = reservation_date;
    }

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "reservation_number=" + reservation_number +
                ", customer_id=" + customer_id +
                ", check_in_date='" + check_in_date + '\'' +
                ", check_out_date='" + check_out_date + '\'' +
                ", status=" + status +
                ", numberOfGuests=" + numberOfGuests +
                ", reservation_date='" + reservation_date + '\'' +
                ", room_id=" + room_id +
                '}';
    }
}
