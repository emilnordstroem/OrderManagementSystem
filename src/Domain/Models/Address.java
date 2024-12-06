package Domain.Models;

public class Address {
    private String streetName;
    private String buildingNo;
    private String postalCode;
    private String city;
    private String country;

    public Address(String streetName, String buildingNo, String postalCode, String city, String country){
        this.streetName = streetName;
        this.buildingNo = buildingNo;
        this.postalCode = postalCode;
        this.city = city;
        this.country = country;
    }
}
