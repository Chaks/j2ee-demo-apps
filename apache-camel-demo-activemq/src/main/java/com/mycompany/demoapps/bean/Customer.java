/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.demoapps.bean;

/**
 *
 * @author dchakr
 */
public class Customer {

  private long customerId;
  private String discountCode;
  private String zip;
  private String name;
  private String addressLine1;
  private String addressLine2;
  private String city;
  private String state;
  private String phone;
  private String fax;
  private String email;

  public String getAddressLine1() {
    return addressLine1;
  }

  public void setAddressLine1(String addressLine1) {
    this.addressLine1 = addressLine1;
  }

  public String getAddressLine2() {
    return addressLine2;
  }

  public void setAddressLine2(String addressLine2) {
    this.addressLine2 = addressLine2;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public long getCustomerId() {
    return customerId;
  }

  public void setCustomerId(long customerId) {
    this.customerId = customerId;
  }

  public String getDiscountCode() {
    return discountCode;
  }

  public void setDiscountCode(String discountCode) {
    this.discountCode = discountCode;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getFax() {
    return fax;
  }

  public void setFax(String fax) {
    this.fax = fax;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
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

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("Customer [");
    builder.append("addressLine1=").append(addressLine1);
    builder.append(", addressLine2=").append(addressLine2);
    builder.append(", city=").append(city);
    builder.append(", customerId=").append(customerId);
    builder.append(", discountCode=").append(discountCode);
    builder.append(", email=").append(email);
    builder.append(", fax=").append(fax);
    builder.append(", name=").append(name);
    builder.append(", phone=").append(phone);
    builder.append(", state=").append(state);
    builder.append(", zip=").append(zip);
    builder.append("]");
    return builder.toString();
  }
}
