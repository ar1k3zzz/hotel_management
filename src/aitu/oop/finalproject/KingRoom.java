package aitu.oop.finalproject;

public class KingRoom extends Room{
    public KingRoom(int roomId, int roomNumber, int numberOfBeds) {
        super(roomId, roomNumber, 3);
    }

    @Override
    public int getRoomId() {
        return super.getRoomId();
    }

    @Override
    public void setRoomId(int roomId) {
        super.setRoomId(roomId);
    }

    @Override
    public int getRoomNumber() {
        return super.getRoomNumber();
    }

    @Override
    public void setRoomNumber(int roomNumber) {
        super.setRoomNumber(roomNumber);
    }

    @Override
    public int getNumberOfBeds() {
        return super.getNumberOfBeds();
    }

    @Override
    public void setNumberOfBeds(int numberOfBeds) {
        super.setNumberOfBeds(numberOfBeds);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
