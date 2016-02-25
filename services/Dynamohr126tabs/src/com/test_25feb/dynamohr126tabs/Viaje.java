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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.Type;
import org.joda.time.LocalDateTime;


import java.util.Arrays;

import javax.persistence.Transient;
import javax.persistence.CascadeType;
import javax.persistence.UniqueConstraint;



/**
 * Viaje generated by hbm2java
 */
@Entity
@Table(name="`viaje`"
)

public class Viaje  implements java.io.Serializable {

    private Integer idTravel;


@Type(type="DateTime")
    private LocalDateTime travelDate;


@Type(type="DateTime")
    private LocalDateTime returnDate;
    private String destination;
    private String travelMotive;
    private Double budget;
    private Integer modUser;
    private Integer modLocation;
    private Date modDate;
    private Set<TravelEmployee> travelEmployees = new HashSet<TravelEmployee>(0);

    public Viaje() {
    }


    @Id @GeneratedValue(strategy=IDENTITY)
    

    @Column(name="`id_travel`", nullable=false, precision=10)
    public Integer getIdTravel() {
        return this.idTravel;
    }
    
    public void setIdTravel(Integer idTravel) {
        this.idTravel = idTravel;
    }

    

    @Column(name="`travel_date`", nullable=false, length=10)
    public LocalDateTime getTravelDate() {
        return this.travelDate;
    }
    
    public void setTravelDate(LocalDateTime travelDate) {
        this.travelDate = travelDate;
    }

    

    @Column(name="`return_date`", nullable=false, length=10)
    public LocalDateTime getReturnDate() {
        return this.returnDate;
    }
    
    public void setReturnDate(LocalDateTime returnDate) {
        this.returnDate = returnDate;
    }

    

    @Column(name="`destination`", nullable=false, length=150)
    public String getDestination() {
        return this.destination;
    }
    
    public void setDestination(String destination) {
        this.destination = destination;
    }

    

    @Column(name="`travel_motive`", nullable=false)
    public String getTravelMotive() {
        return this.travelMotive;
    }
    
    public void setTravelMotive(String travelMotive) {
        this.travelMotive = travelMotive;
    }

    

    @Column(name="`budget`", nullable=false, scale=4)
    public Double getBudget() {
        return this.budget;
    }
    
    public void setBudget(Double budget) {
        this.budget = budget;
    }

    

    @Column(name="`mod_user`", nullable=false, precision=10)
    public Integer getModUser() {
        return this.modUser;
    }
    
    public void setModUser(Integer modUser) {
        this.modUser = modUser;
    }

    

    @Column(name="`mod_location`", nullable=false, precision=10)
    public Integer getModLocation() {
        return this.modLocation;
    }
    
    public void setModLocation(Integer modLocation) {
        this.modLocation = modLocation;
    }

    @Temporal(TemporalType.TIMESTAMP)

    @Column(name="`mod_date`", nullable=false, length=19)
    public Date getModDate() {
        return this.modDate;
    }
    
    public void setModDate(Date modDate) {
        this.modDate = modDate;
    }

    @OneToMany(fetch=FetchType.LAZY, cascade = {CascadeType.ALL}, mappedBy="viaje")
    public Set<TravelEmployee> getTravelEmployees() {
        return this.travelEmployees;
    }
    
    public void setTravelEmployees(Set<TravelEmployee> travelEmployees) {
        this.travelEmployees = travelEmployees;
    }





    public boolean equals(Object o) {
         if (this == o) return true;
		 if ( (o == null )) return false;
		 if ( !(o instanceof Viaje) )
		    return false;

		 Viaje that = (Viaje) o;

		 return ( (this.getIdTravel()==that.getIdTravel()) || ( this.getIdTravel()!=null && that.getIdTravel()!=null && this.getIdTravel().equals(that.getIdTravel()) ) );
    }

    public int hashCode() {
         int result = 17;

         result = 37 * result + ( getIdTravel() == null ? 0 : this.getIdTravel().hashCode() );

         return result;
    }


}
