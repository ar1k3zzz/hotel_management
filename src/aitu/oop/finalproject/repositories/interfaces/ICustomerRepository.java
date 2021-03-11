package aitu.oop.finalproject.repositories.interfaces;

public interface ICustomerRepository {
    public abstract void getCustomer();
    public abstract void getCustomer(int customer_id);
    public abstract boolean createCustomer(String firstname, String lastname, String phonenumber, String country, String city);
    public abstract boolean updateCustomer(int customer_id, String firstname, String lastname, String phonenumber, String country, String city);
    public abstract void deleteCustomer(int customer_id);
}
