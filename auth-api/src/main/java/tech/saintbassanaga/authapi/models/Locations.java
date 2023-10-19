package tech.saintbassanaga.authapi.models;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "locations")
public class Locations {
    // ----------------- Entity Attribute Declaration ----------------------------------------->
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;
    @Column(name = "zip",nullable = true)
    private String ZIP;
    @Column(name = "street_name", nullable = false)
    private String streetName;
    @Column(name = "postal_code", nullable = false)
    private String postalCode;

    @Column(name = "country", nullable = false)
    private String country;
    @Column(name = "state", nullable = false)
    private String state;

    // ---------------------------- Entity Attribute End ------------------------------->


    // ----------------Getter, Setter and Constructor ---------------------------------->


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getZIP() {
        return ZIP;
    }

    public void setZIP(String ZIP) {
        this.ZIP = ZIP;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Locations locations = (Locations) o;
        return Objects.equals(id, locations.id) && Objects.equals(ZIP, locations.ZIP) && Objects.equals(streetName, locations.streetName) && Objects.equals(postalCode, locations.postalCode) && Objects.equals(country, locations.country) && Objects.equals(state, locations.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ZIP, streetName, postalCode, country, state);
    }

    @Override
    public String toString() {
        return "Locations{" +
                "id=" + id +
                ", ZIP='" + ZIP + '\'' +
                ", streetName='" + streetName + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", country='" + country + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}