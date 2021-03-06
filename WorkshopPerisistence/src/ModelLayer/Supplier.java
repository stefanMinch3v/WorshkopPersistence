package ModelLayer;

/**
 * Created by Admin on 3/29/2017.
 */
public class Supplier {
    private int id = 0;
    private String name;
    private String address;
    private String country;
    private String phone;
    private String email;

    public Supplier(){

    }
    public Supplier(String name, String address, String country, String phone, String email) {
        id++;
        this.name = name;
        this.address = address;
        this.country = country;
        this.phone = phone;
        this.email = email;
    }

    /*
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }*/

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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", country='" + country + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
