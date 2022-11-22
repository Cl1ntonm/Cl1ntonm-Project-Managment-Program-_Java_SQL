import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Class for Creation of Person Objects
 */
public class Person {
    //Attributes
//    private int projectNum;
    private String firstName;
    private String lastName;
    private String telephone;
    private String email;
    private String address;

    // Constructor
    public Person(String firstName, String lastName, String telephone, String email, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.telephone = telephone;
        this.email = email;
        this.address = address;
    }

    // Getters
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getTelephone() {
        return telephone;
    }
    public String getEmail() {
        return email;
    }
    public String getAddress() {
        return address;
    }

    //Methods
    /**
     * Displays Information on screen
     *
     * @return Displays to screen the stored Person objects values
     */
    public String toString() {
        return "\nName: " + firstName + " " + lastName
                + "\nPhone Number: " + telephone
                + "\nEmail Address: " + email
                + "\nAddress : " + address;
    }
}

