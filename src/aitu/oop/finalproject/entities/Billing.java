package aitu.oop.finalproject.entities;

public class Billing{
    private int billing;
    private int roomCharge;
    private int miscCharges;
    private String creditCardNO;
    private String paymentDate;
    private int customerId;

    public Billing(int roomCharge, int miscCharges, String creditCardNO, String paymentDate, int customerId) {
        this.roomCharge = roomCharge;
        this.miscCharges = miscCharges;
        this.creditCardNO = creditCardNO;
        this.paymentDate = paymentDate;
        this.customerId = customerId;
    }

    public int getBilling() {
        return billing;
    }

    public void setBilling(int billing) {
        this.billing = billing;
    }

    public int getRoomCharge() {
        return roomCharge;
    }

    public void setRoomCharge(int roomCharge) {
        this.roomCharge = roomCharge;
    }

    public int getMiscCharges() {
        return miscCharges;
    }

    public void setMiscCharges(int miscCharges) {
        this.miscCharges = miscCharges;
    }

    public String getCreditCardNO() {
        return creditCardNO;
    }

    public void setCreditCardNO(String creditCardNO) {
        this.creditCardNO = creditCardNO;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "Billing{" +
                "billing=" + billing +
                ", roomCharge=" + roomCharge +
                ", miscCharges=" + miscCharges +
                ", creditCardNO='" + creditCardNO + '\'' +
                ", paymentDate='" + paymentDate + '\'' +
                ", customerId=" + customerId +
                '}';
    }
}
