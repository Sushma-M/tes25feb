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
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
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
 * TravelEmployee generated by hbm2java
 */
@Entity
@Table(name="`travel_employee`"
)

public class TravelEmployee  implements java.io.Serializable {

    private Integer idTravelEmployee;
    private String tripPurpose;
    private Integer modUser;
    private Integer modLocation;
    private Date modDate;
    private Employee employee;
    private Viaje viaje;
    private Set<TravelExpense> travelExpenses = new HashSet<TravelExpense>(0);

    public TravelEmployee() {
    }


    @Id @GeneratedValue(strategy=IDENTITY)
    

    @Column(name="`id_travel_employee`", nullable=false, precision=10)
    public Integer getIdTravelEmployee() {
        return this.idTravelEmployee;
    }
    
    public void setIdTravelEmployee(Integer idTravelEmployee) {
        this.idTravelEmployee = idTravelEmployee;
    }

    

    @Column(name="`trip_purpose`")
    public String getTripPurpose() {
        return this.tripPurpose;
    }
    
    public void setTripPurpose(String tripPurpose) {
        this.tripPurpose = tripPurpose;
    }

    

    @Column(name="`mod_user`", precision=10)
    public Integer getModUser() {
        return this.modUser;
    }
    
    public void setModUser(Integer modUser) {
        this.modUser = modUser;
    }

    

    @Column(name="`mod_location`", precision=10)
    public Integer getModLocation() {
        return this.modLocation;
    }
    
    public void setModLocation(Integer modLocation) {
        this.modLocation = modLocation;
    }

    @Temporal(TemporalType.TIMESTAMP)

    @Column(name="`mod_date`", length=19)
    public Date getModDate() {
        return this.modDate;
    }
    
    public void setModDate(Date modDate) {
        this.modDate = modDate;
    }

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="`fk_employee`", nullable=false)
    public Employee getEmployee() {
        return this.employee;
    }
    
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="`fk_travel`", nullable=false)
    public Viaje getViaje() {
        return this.viaje;
    }
    
    public void setViaje(Viaje viaje) {
        this.viaje = viaje;
    }

    @OneToMany(fetch=FetchType.LAZY, cascade = {CascadeType.ALL}, mappedBy="travelEmployee")
    public Set<TravelExpense> getTravelExpenses() {
        return this.travelExpenses;
    }
    
    public void setTravelExpenses(Set<TravelExpense> travelExpenses) {
        this.travelExpenses = travelExpenses;
    }





    public boolean equals(Object o) {
         if (this == o) return true;
		 if ( (o == null )) return false;
		 if ( !(o instanceof TravelEmployee) )
		    return false;

		 TravelEmployee that = (TravelEmployee) o;

		 return ( (this.getIdTravelEmployee()==that.getIdTravelEmployee()) || ( this.getIdTravelEmployee()!=null && that.getIdTravelEmployee()!=null && this.getIdTravelEmployee().equals(that.getIdTravelEmployee()) ) );
    }

    public int hashCode() {
         int result = 17;

         result = 37 * result + ( getIdTravelEmployee() == null ? 0 : this.getIdTravelEmployee().hashCode() );

         return result;
    }


}

