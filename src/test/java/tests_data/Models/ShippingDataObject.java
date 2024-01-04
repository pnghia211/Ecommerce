package tests_data.Models;

public class ShippingDataObject {
    String phone;
    String shippingAddress1;
    String shippingAddress2;
    String city;
    String zipcode;
    String country;

    public ShippingDataObject(String phone, String shippingAddress1, String shippingAddress2, String city, String zipcode, String country) {
        this.phone = phone;
        this.shippingAddress1 = shippingAddress1;
        this.shippingAddress2 = shippingAddress2;
        this.city = city;
        this.zipcode = zipcode;
        this.country = country;
    }

    public String getPhone() {
        return phone;
    }

    public String getShippingAddress1() {
        return shippingAddress1;
    }

    public String getShippingAddress2() {
        return shippingAddress2;
    }

    public String getCity() {
        return city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public String getCountry() {
        return country;
    }
}
