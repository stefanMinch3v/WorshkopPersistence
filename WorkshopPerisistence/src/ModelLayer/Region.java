package ModelLayer;

/**
 * Created by Red John on 29-Mar-17.
 */
public class Region {
    private int zip;
    private String city;

    public Region(int zip, String city) {
        this.zip = zip;
        this.city = city;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
