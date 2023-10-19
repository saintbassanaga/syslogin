package tech.saintbassanaga.authapi.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.Instant;
import java.util.*;

@Entity(name = "User")
@Table(name = "users")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User implements UserDetails {

    // ---------------------------- Entity attributes declarations ----------------------------------->

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "iD", nullable = false)
    private UUID iD;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "surname")
    private String surname;

    @Column(name = "username", nullable = false, unique = true)
    private String username;
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "born_Year")
    private Date burnYear;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "locations_id")
    private Locations locations;
    @Column(name = "join_date", nullable = false)
    private Instant joinDate;

    private Boolean locked;
    private Boolean enabled;
    @Enumerated(EnumType.STRING)
    private UserRole userRole;


    //--------------------------- End of Declaration ----------------------------------------->

    // ----------------------------- Getter, Setter and Constructor -------------------------->


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



    public void setSurname(String surname) {
        this.surname = surname;
    }


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority =
                new SimpleGrantedAuthority(userRole.name());
        return Collections.singletonList(authority) ;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }


    public void setPassword(String password) {
        this.password = password;
    }


    public void setBurnYear(Date burnYear) {
        this.burnYear = burnYear;
    }



    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Column(name = "phone_number", nullable = false, unique = true, length = 12)
    private long phoneNumber;


    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }




    public void setLocations(Locations locations) {
        this.locations = locations;
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
                ", locked=" + locked +
                ", enabled=" + enabled +
                ", userRole=" + userRole +
                ", phoneNumber=" + phoneNumber +
                '}';
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return phoneNumber == user.phoneNumber && Objects.equals(iD, user.iD) && Objects.equals(name, user.name) && Objects.equals(surname, user.surname) && Objects.equals(username, user.username) && Objects.equals(email, user.email) && Objects.equals(password, user.password) && Objects.equals(burnYear, user.burnYear) && Objects.equals(locations, user.locations) && Objects.equals(joinDate, user.joinDate) && Objects.equals(locked, user.locked) && Objects.equals(enabled, user.enabled) && userRole == user.userRole;
    }

    @Override
    public int hashCode() {
        return Objects.hash(iD, name, surname, username, email, password, burnYear, locations, joinDate, locked, enabled, userRole, phoneNumber);
    }
}