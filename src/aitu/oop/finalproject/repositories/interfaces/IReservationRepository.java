package aitu.oop.finalproject.repositories.interfaces;

public interface IReservationRepository {
    public abstract void getReservations();
    public abstract void getReservations(int reservation_number);
    public abstract boolean createReservation(int customer_id, String check_in_date,int status, String number_of_guests, String reservation_date, int room_id);
    public abstract boolean createReservation(int customer_id, String check_in_date, String check_out_date, int status, String number_of_guests, String reservation_date, int room_id);
    public abstract boolean updateReservation(int reservation_number, int customer_id, String check_in_date,int status, String number_of_guests, String reservation_date, int room_id);
    public abstract boolean updateReservation(int reservation_number, int customer_id, String check_in_date, String check_out_date, int status, String number_of_guests, String reservation_date, int room_id);
    public abstract void deleteReservation(int reservation_number);
}
