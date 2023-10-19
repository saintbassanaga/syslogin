package tech.saintbassanaga.authapi.models;

import jakarta.persistence.*;

import java.time.Instant;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

@Entity(name = "User")
@Table(name = "users")
public class User {

    // ---------------------------- Entity attributes declarations ----------------------------------->

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "iD", nullable = false)
    private UUID iD;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "surname", nullable = true)
    private String surname;

    @Column(name = "username", nullable = false, unique = true)
    private String username;
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "bornYear", nullable = true)
    private Date burnYear;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "locations_id")
    private Locations locations;
    @Column(name = "join_date", nullable = false)
    private Instant joinDate;


    //--------------------------- End of Declaration ----------------------------------------->

    // ----------------------------- Getter, Setter and Constructor -------------------------->


    public UUID getiD() {
        return iD;
    }

    public void setiD(UUID iD) {
        this.iD = iD;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Instant getJoinDate() {
        return joinDate;
    }

    public User(UUID iD, String name, String surname, String username, String email, String password, Date burnYear, Locations locations, Instant joinDate, long phoneNumber) {
        this.iD = iD;
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.email = email;
        this.password = password;
        this.burnYear = burnYear;
        this.locations = locations;
        this.joinDate = joinDate;
        this.phoneNumber = phoneNumber;
    }

    public void setJoinDate(Instant joinDate) {
        this.joinDate = joinDate;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBurnYear() {
        return burnYear;
    }

    public void setBurnYear(Date burnYear) {
        this.burnYear = burnYear;
    }


    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Column(name = "phone_number", nullable = false, unique = true, length = 12)
    private long phoneNumber;


    public Locations getLocations() {
        return locations;
    }

    public void setLocations(Locations locations) {
        this.locations = locations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return phoneNumber == user.phoneNumber && Objects.equals(iD, user.iD) && Objects.equals(name, user.name) && Objects.equals(surname, user.surname) && Objects.equals(username, user.username) && Objects.equals(email, user.email) && Objects.equals(password, user.password) && Objects.equals(burnYear, user.burnYear) && Objects.equals(locations, user.locations);
    }

    @Override
    public String toString() {
        return "User{" +
                "iD=" + iD +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", burnYear=" + burnYear +
                ", locations=" + locations +
                ", joinDate=" + joinDate +
                ", phoneNumber=" + phoneNumber +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(iD, name, surname, username, email, password, burnYear, phoneNumber, locations);
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }


}