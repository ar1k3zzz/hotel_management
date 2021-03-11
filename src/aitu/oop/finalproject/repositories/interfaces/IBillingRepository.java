package aitu.oop.finalproject.repositories.interfaces;

public interface IBillingRepository {
    public abstract void getBillings();
    public abstract void getBillings(int billing);
    public abstract boolean createBilling(int customer_id, int room_charge, int misc_charges, String credit_card_no, String payment_date);
}
