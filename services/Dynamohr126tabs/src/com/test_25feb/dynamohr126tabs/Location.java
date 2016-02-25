/*Copyright (c) 2016-2017 gmail.com All Rights Reserved.
 This software is the confidential and proprietary information of gmail.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with gmail.com*/

package com.test_25feb.dynamohr126tabs;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import javax.persistence.PrimaryKeyJoinColumn;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


import java.util.Arrays;

import javax.persistence.Transient;
import javax.persistence.CascadeType;
import javax.persistence.UniqueConstraint;



/**
 * Location generated by hbm2java
 */
@Entity
@Table(name="`location`"
)

public class Location  implements java.io.Serializable {

    private Integer idLocation;
    private String name;
    private String code;
    private String phone;
    private String fax;
    private String city;
    private String department;
    private String registrationNumber;
    private String direction;
    private String observation;
    private Integer modUser;
    private Date modDate;
    private Set<CompanyDepartment> companyDepartments = new HashSet<CompanyDepartment>(0);
    private Country country;

    public Location() {
    }


    @Id 
    

    @Column(name="`id_location`", nullable=false, precision=10)
    public Integer getIdLocation() {
        return this.idLocation;
    }
    
    public void setIdLocation(Integer idLocation) {
        this.idLocation = idLocation;
    }

    

    @Column(name="`name`", nullable=false, length=50)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    

    @Column(name="`code`", nullable=false, length=4)
    public String getCode() {
        return this.code;
    }
    
    public void setCode(String code) {
        this.code = code;
    }

    

    @Column(name="`phone`", length=50)
    public String getPhone() {
        return this.phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }

    

    @Column(name="`fax`", length=50)
    public String getFax() {
        return this.fax;
    }
    
    public void setFax(String fax) {
        this.fax = fax;
    }

    

    @Column(name="`city`", nullable=false, length=50)
    public String getCity() {
        return this.city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }

    

    @Column(name="`department`", nullable=false, length=50)
    public String getDepartment() {
        return this.department;
    }
    
    public void setDepartment(String department) {
        this.department = department;
    }

    

    @Column(name="`registration_number`", nullable=false, length=50)
    public String getRegistrationNumber() {
        return this.registrationNumber;
    }
    
    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    

    @Column(name="`direction`", nullable=false, length=150)
    public String getDirection() {
        return this.direction;
    }
    
    public void setDirection(String direction) {
        this.direction = direction;
    }

    

    @Column(name="`observation`", length=100)
    public String getObservation() {
        return this.observation;
    }
    
    public void setObservation(String observation) {
        this.observation = observation;
    }

    

    @Column(name="`mod_user`", nullable=false, precision=10)
    public Integer getModUser() {
        return this.modUser;
    }
    
    public void setModUser(Integer modUser) {
        this.modUser = modUser;
    }

    @Temporal(TemporalType.TIMESTAMP)

    @Column(name="`mod_date`", nullable=false, length=19)
    public Date getModDate() {
        return this.modDate;
    }
    
    public void setModDate(Date modDate) {
        this.modDate = modDate;
    }

    @OneToMany(fetch=FetchType.LAZY, cascade = {CascadeType.ALL}, mappedBy="location")
    public Set<CompanyDepartment> getCompanyDepartments() {
        return this.companyDepartments;
    }
    
    public void setCompanyDepartments(Set<CompanyDepartment> companyDepartments) {
        this.companyDepartments = companyDepartments;
    }

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="`fk_country`", nullable=false)
    public Country getCountry() {
        return this.country;
    }
    
    public void setCountry(Country country) {
        this.country = country;
    }





    public boolean equals(Object o) {
         if (this == o) return true;
		 if ( (o == null )) return false;
		 if ( !(o instanceof Location) )
		    return false;

		 Location that = (Location) o;

		 return ( (this.getIdLocation()==that.getIdLocation()) || ( this.getIdLocation()!=null && that.getIdLocation()!=null && this.getIdLocation().equals(that.getIdLocation()) ) );
    }

    public int hashCode() {
         int result = 17;

         result = 37 * result + ( getIdLocation() == null ? 0 : this.getIdLocation().hashCode() );

         return result;
    }


}
