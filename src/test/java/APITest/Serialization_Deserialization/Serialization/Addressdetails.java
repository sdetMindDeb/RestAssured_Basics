package APITest.Serialization_Deserialization.Serialization;

public class Addressdetails {

    private String city;
    private String state;
    private String street;
    private String zip;

    public Addressdetails(String city, String state, String street, String zip) {
        setCity(city);
        setState(state);
        setStreet(street);
        setZip(zip);
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public String getStreet() {
        return street;
    }
    public void setStreet(String street) {
        this.street = street;
    }
    public String getZip() {
        return zip;
    }
    public void setZip(String zip) {
        this.zip = zip;
    }
}
