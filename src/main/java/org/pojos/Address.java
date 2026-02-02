package org.pojos;

public class Address {

    private String company;
    private String address;
    private String address_line2;
    private String city;
    private String state;
    private String zip;
    private String country;
    private String home_phone;
    private String mobile_phone;
    private String additional_info;
    private String assign_address;

    public Address(String company, String address, String address_line2, String city,  String zip, String home_phone, String mobile_phone, String additional_info, String assign_address,String state) {
        this.company = company;
        this.address = address;
        this.address_line2 = address_line2;
        this.city = city;
        this.state = state;
        this.zip = zip;
       // this.country = country;
        this.home_phone = home_phone;
        this.mobile_phone = mobile_phone;
        this.additional_info = additional_info;
        this.assign_address = assign_address;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress_line2() {
        return address_line2;
    }

    public void setAddress_line2(String address_line2) {
        this.address_line2 = address_line2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getHome_phone() {
        return home_phone;
    }

    public void setHome_phone(String home_phone) {
        this.home_phone = home_phone;
    }

    public String getMobile_phone() {
        return mobile_phone;
    }

    public void setMobile_phone(String mobile_phone) {
        this.mobile_phone = mobile_phone;
    }

    public String getAdditional_info() {
        return additional_info;
    }

    public void setAdditional_info(String additional_info) {
        this.additional_info = additional_info;
    }

    public String getAssign_address() {
        return assign_address;
    }

    public void setAssign_address(String assign_address) {
        this.assign_address = assign_address;
    }

    @Override
    public String toString() {
        return "Address{" +
                "company='" + company + '\'' +
                ", address='" + address + '\'' +
                ", address_line2='" + address_line2 + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip='" + zip + '\'' +
                ", country='" + country + '\'' +
                ", home_phone='" + home_phone + '\'' +
                ", mobile_phone='" + mobile_phone + '\'' +
                ", additional_info='" + additional_info + '\'' +
                ", assign_address='" + assign_address + '\'' +
                '}';
    }
}
