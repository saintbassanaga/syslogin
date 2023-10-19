package tech.saintbassanaga.authapi.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * DTO for {@link tech.saintbassanaga.authapi.models.User}
 */
public class UserInfosDto implements Serializable {
    private final String name;
    private final String surname;
    private final Date burnYear;
    private final long phoneNumber;
    private final String locationsZIP;
    private final String locationsStreetName;
    private final String locationsPostalCode;
    private final String locationsCountry;
    private final String locationsState;

    public UserInfosDto(String name, String surname, Date burnYear, long phoneNumber, String locationsZIP, String locationsStreetName, String locationsPostalCode, String locationsCountry, String locationsState) {
        this.name = name;
        this.surname = surname;
        this.burnYear = burnYear;
        this.phoneNumber = phoneNumber;
        this.locationsZIP = locationsZIP;
        this.locationsStreetName = locationsStreetName;
        this.locationsPostalCode = locationsPostalCode;
        this.locationsCountry = locationsCountry;
        this.locationsState = locationsState;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Date getBurnYear() {
        return burnYear;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public String getLocationsZIP() {
        return locationsZIP;
    }

    public String getLocationsStreetName() {
        return locationsStreetName;
    }

    public String getLocationsPostalCode() {
        return locationsPostalCode;
    }

    public String getLocationsCountry() {
        return locationsCountry;
    }

    public String getLocationsState() {
        return locationsState;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserInfosDto entity = (UserInfosDto) o;
        return Objects.equals(this.name, entity.name) &&
                Objects.equals(this.surname, entity.surname) &&
                Objects.equals(this.burnYear, entity.burnYear) &&
                Objects.equals(this.phoneNumber, entity.phoneNumber) &&
                Objects.equals(this.locationsZIP, entity.locationsZIP) &&
                Objects.equals(this.locationsStreetName, entity.locationsStreetName) &&
                Objects.equals(this.locationsPostalCode, entity.locationsPostalCode) &&
                Objects.equals(this.locationsCountry, entity.locationsCountry) &&
                Objects.equals(this.locationsState, entity.locationsState);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, burnYear, phoneNumber, locationsZIP, locationsStreetName, locationsPostalCode, locationsCountry, locationsState);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "name = " + name + ", " +
                "surname = " + surname + ", " +
                "burnYear = " + burnYear + ", " +
                "phoneNumber = " + phoneNumber + ", " +
                "locationsZIP = " + locationsZIP + ", " +
                "locationsStreetName = " + locationsStreetName + ", " +
                "locationsPostalCode = " + locationsPostalCode + ", " +
                "locationsCountry = " + locationsCountry + ", " +
                "locationsState = " + locationsState + ")";
    }
}