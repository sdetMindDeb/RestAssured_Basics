package APITest.Serialization_Deserialization.Serialization;

import java.util.List;

public class profileDetails {

    private int id;
    private String name;
    private String email;
    private String age;
    private String isActive;
    private List<String> hobbies;
    private Addressdetails addressDetails;

    public profileDetails(int id, String name, String email, String age, String isActive, List<String> hobbies, Addressdetails addressDetails) {
        setId(id);
        setName(name);
        setEmail(email);
        setAge(age);
        setIsActive(isActive);
        setHobbies(hobbies);
        setAddressDetails(addressDetails);
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getAge() {
        return age;
    }
    public void setAge(String age) {
        this.age = age;
    }
    public String getIsActive() {
        return isActive;
    }
    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }
    public List<String> getHobbies() {
        return hobbies;
    }
    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }
    public Addressdetails getAddressDetails() {
        return addressDetails;
    }
    public void setAddressDetails(Addressdetails addressDetails) {
        this.addressDetails = addressDetails;
    }
}
