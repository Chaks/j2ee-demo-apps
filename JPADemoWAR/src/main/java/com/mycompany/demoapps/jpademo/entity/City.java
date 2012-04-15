/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.demoapps.jpademo.entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dchakr
 */
@Entity
@Table(name = "City", catalog = "world", schema = "")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "City.findAll", query = "SELECT c FROM City c"),
  @NamedQuery(name = "City.findById", query = "SELECT c FROM City c WHERE c.id = :id"),
  @NamedQuery(name = "City.findByName", query = "SELECT c FROM City c WHERE c.name = :name"),
  @NamedQuery(name = "City.findByCountryCode", query = "SELECT c FROM City c WHERE c.countryCode = :countryCode"),
  @NamedQuery(name = "City.findByDistrict", query = "SELECT c FROM City c WHERE c.district = :district"),
  @NamedQuery(name = "City.findByPopulation", query = "SELECT c FROM City c WHERE c.population = :population")})
public class City implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "ID", nullable = false)
  private Integer id;
  @Basic(optional = false)
  @Column(name = "Name", nullable = false, length = 35)
  private String name;
  @Basic(optional = false)
  @Column(name = "CountryCode", nullable = false, length = 3)
  private String countryCode;
  @Basic(optional = false)
  @Column(name = "District", nullable = false, length = 20)
  private String district;
  @Basic(optional = false)
  @Column(name = "Population", nullable = false)
  private int population;

  public City() {
  }

  public City(Integer id) {
    this.id = id;
  }

  public City(Integer id, String name, String countryCode, String district, int population) {
    this.id = id;
    this.name = name;
    this.countryCode = countryCode;
    this.district = district;
    this.population = population;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCountryCode() {
    return countryCode;
  }

  public void setCountryCode(String countryCode) {
    this.countryCode = countryCode;
  }

  public String getDistrict() {
    return district;
  }

  public void setDistrict(String district) {
    this.district = district;
  }

  public int getPopulation() {
    return population;
  }

  public void setPopulation(int population) {
    this.population = population;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (id != null ? id.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof City)) {
      return false;
    }
    City other = (City) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "com.mycompany.demoapps.jpademo.servlet.City[ id=" + id + " ]";
  }
}
