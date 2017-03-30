package ModelLayer;

/**
 * Created by Admin on 3/29/2017.
 */
public class Customer {
    private int id;
    private String name;
    private String address;
    private int zip;
    private boolean isCompany;
    private String phoneNumber;

    public Customer(String name, String address, int zip, boolean isCompany, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.zip = zip;
        this.isCompany = isCompany;
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public boolean isCompany() {
        return isCompany;
    }

    public void setCompany(boolean company) {
        isCompany = company;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", zip=" + zip +
                ", isCompany=" + isCompany +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
