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
import org.hibernate.annotations.Type;
import org.joda.time.LocalDateTime;


import java.util.Arrays;

import javax.persistence.Transient;
import javax.persistence.CascadeType;
import javax.persistence.UniqueConstraint;



/**
 * TravelExpense generated by hbm2java
 */
@Entity
@Table(name="`travel_expense`"
)

public class TravelExpense  implements java.io.Serializable {

    private Integer idTravelExpense;
    private String reason;
    private Double value_;


@Type(type="DateTime")
    private LocalDateTime creationDate;
    private String observation;
    private Integer modLocation;
    private Integer modUser;
    private Date modDate;
    private Set<JustifiedTravelExpenseFile> justifiedTravelExpenseFiles = new HashSet<JustifiedTravelExpenseFile>(0);
    private Set<ListTravelExpenseDetail> listTravelExpenseDetails = new HashSet<ListTravelExpenseDetail>(0);
    private Currency currency;
    private TravelEmployee travelEmployee;
    private TypeTravellingExpense typeTravellingExpense;

    public TravelExpense() {
    }


    @Id @GeneratedValue(strategy=IDENTITY)
    

    @Column(name="`id_travel_expense`", nullable=false, precision=10)
    public Integer getIdTravelExpense() {
        return this.idTravelExpense;
    }
    
    public void setIdTravelExpense(Integer idTravelExpense) {
        this.idTravelExpense = idTravelExpense;
    }

    

    @Column(name="`reason`", nullable=false, length=50)
    public String getReason() {
        return this.reason;
    }
    
    public void setReason(String reason) {
        this.reason = reason;
    }

    

    @Column(name="`value?`", nullable=false, scale=4)
    public Double getValue_() {
        return this.value_;
    }
    
    public void setValue_(Double value_) {
        this.value_ = value_;
    }

    

    @Column(name="`creation_date`", nullable=false)
    public LocalDateTime getCreationDate() {
        return this.creationDate;
    }
    
    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    

    @Column(name="`observation`")
    public String getObservation() {
        return this.observation;
    }
    
    public void setObservation(String observation) {
        this.observation = observation;
    }

    

    @Column(name="`mod_location`", nullable=false, precision=10)
    public Integer getModLocation() {
        return this.modLocation;
    }
    
    public void setModLocation(Integer modLocation) {
        this.modLocation = modLocation;
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

    @OneToMany(fetch=FetchType.LAZY, cascade = {CascadeType.ALL}, mappedBy="travelExpense")
    public Set<JustifiedTravelExpenseFile> getJustifiedTravelExpenseFiles() {
        return this.justifiedTravelExpenseFiles;
    }
    
    public void setJustifiedTravelExpenseFiles(Set<JustifiedTravelExpenseFile> justifiedTravelExpenseFiles) {
        this.justifiedTravelExpenseFiles = justifiedTravelExpenseFiles;
    }

    @OneToMany(fetch=FetchType.LAZY, cascade = {CascadeType.ALL}, mappedBy="travelExpense")
    public Set<ListTravelExpenseDetail> getListTravelExpenseDetails() {
        return this.listTravelExpenseDetails;
    }
    
    public void setListTravelExpenseDetails(Set<ListTravelExpenseDetail> listTravelExpenseDetails) {
        this.listTravelExpenseDetails = listTravelExpenseDetails;
    }

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="`fk_currency`", nullable=false)
    public Currency getCurrency() {
        return this.currency;
    }
    
    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="`fk_travel`", nullable=false)
    public TravelEmployee getTravelEmployee() {
        return this.travelEmployee;
    }
    
    public void setTravelEmployee(TravelEmployee travelEmployee) {
        this.travelEmployee = travelEmployee;
    }

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="`fk_type_travelling_expense`", nullable=false)
    public TypeTravellingExpense getTypeTravellingExpense() {
        return this.typeTravellingExpense;
    }
    
    public void setTypeTravellingExpense(TypeTravellingExpense typeTravellingExpense) {
        this.typeTravellingExpense = typeTravellingExpense;
    }





    public boolean equals(Object o) {
         if (this == o) return true;
		 if ( (o == null )) return false;
		 if ( !(o instanceof TravelExpense) )
		    return false;

		 TravelExpense that = (TravelExpense) o;

		 return ( (this.getIdTravelExpense()==that.getIdTravelExpense()) || ( this.getIdTravelExpense()!=null && that.getIdTravelExpense()!=null && this.getIdTravelExpense().equals(that.getIdTravelExpense()) ) );
    }

    public int hashCode() {
         int result = 17;

         result = 37 * result + ( getIdTravelExpense() == null ? 0 : this.getIdTravelExpense().hashCode() );

         return result;
    }


}

