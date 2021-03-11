package aitu.oop.finalproject.repositories.interfaces;

import aitu.oop.finalproject.entities.Room;

import java.util.List;

public interface IRoomRepository {
    public abstract void getRooms();
    public abstract void getRooms(int room_id);
    public abstract boolean createRoom(int room_number, String room_type, int number_of_beds);
    public abstract boolean createRoom(int room_number, String room_type, int number_of_beds, int customer_id);
    public abstract boolean updateRoom(int room_id, int room_number, String room_type, int number_of_beds);
    public abstract boolean updateRoom(int room_id, int room_number, String room_type, int number_of_beds, int customer_id);
    public abstract boolean deleteRoom(int room_id);
}
