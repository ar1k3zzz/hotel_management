package aitu.oop.finalproject;

public class Room {
    private int roomId;
    private int roomNumber;
    private String roomType;
    private int numberOfBeds;
    private int customerId;

    public Room(int roomNumber,String roomType, int numberOfBeds, int customerId) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.numberOfBeds = numberOfBeds;
        this.customerId = customerId;
    }

    public int getRoomId() {
        return roomId;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public void setNumberOfBeds(int numberOfBeds) {
        this.numberOfBeds = numberOfBeds;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomId=" + roomId +
                ", roomNumber=" + roomNumber +
                ", roomType='" + roomType + '\'' +
                ", numberOfBeds=" + numberOfBeds +
                ", customerId=" + customerId +
                '}';
    }
}
