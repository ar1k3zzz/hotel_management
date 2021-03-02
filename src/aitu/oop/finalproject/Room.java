package aitu.oop.finalproject;

public class Room {
    private int roomId;
    private int roomNumber;
    private int numberOfBeds;

    public Room(int roomId, int roomNumber, int numberOfBeds) {
        this.roomId = roomId;
        this.roomNumber = roomNumber;
        this.numberOfBeds = numberOfBeds;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public void setNumberOfBeds(int numberOfBeds) {
        this.numberOfBeds = numberOfBeds;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomId=" + roomId +
                ", roomNumber=" + roomNumber +
                ", numberOfBeds=" + numberOfBeds +
                '}';
    }
}
