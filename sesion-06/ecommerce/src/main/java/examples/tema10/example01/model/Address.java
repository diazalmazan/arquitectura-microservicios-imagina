package examples.tema10.example01.model;

public class Address {
    private String street;
    private String country;

    public Address(String street, String country) {
        this.street = street;
        this.country = country;
    }

    public String getStreet() {
        return street;
    }

    public String getCountry() {
        return country;
    }
}
