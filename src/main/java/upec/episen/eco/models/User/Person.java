package upec.episen.eco.models.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Person extends User {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "first_name")
    private String lastName;

    @Column
    private char gender;

    @Column
    private int age;

    // Constructors

    public Person(String username, String phoneNumber, String email, String password, String firstName, String lastName,
            char gender, int age) {
        super(username, phoneNumber, email, password);
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
    }

    public Person() {

    }

    // Getters - Setters

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // toString

    @Override
    public String toString() {
        return "Person [firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender + ", age=" + age
                + "]";
    }

}
