/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.demoapps.bean;

import java.util.List;

/**
 *
 * @author dchakr
 */
public class CustomerList {

  private List<Customer> customers;

  public List<Customer> getCustomers() {
    return customers;
  }

  public void setCustomers(List<Customer> customers) {
    this.customers = customers;
  }

  @Override
  public String toString() {
    return "CustomerList{" + "customers=" + customers + '}';
  }
}
