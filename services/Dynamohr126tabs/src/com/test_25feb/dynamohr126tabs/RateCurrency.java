/*Copyright (c) 2016-2017 gmail.com All Rights Reserved.
 This software is the confidential and proprietary information of gmail.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with gmail.com*/

package com.test_25feb.dynamohr126tabs;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import javax.persistence.PrimaryKeyJoinColumn;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
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
 * RateCurrency generated by hbm2java
 */
@Entity
@Table(name="`rate_currency`"
)

public class RateCurrency  implements java.io.Serializable {

    private Integer idRateCurrency;


@Type(type="DateTime")
    private LocalDateTime rateDate;
    private String currency;
    private Double value_;
    private Integer modUser;
    private Date modDate;

    public RateCurrency() {
    }


    @Id @GeneratedValue(strategy=IDENTITY)
    

    @Column(name="`id_rate_currency`", nullable=false, precision=10)
    public Integer getIdRateCurrency() {
        return this.idRateCurrency;
    }
    
    public void setIdRateCurrency(Integer idRateCurrency) {
        this.idRateCurrency = idRateCurrency;
    }

    

    @Column(name="`rate_date`", nullable=false, length=10)
    public LocalDateTime getRateDate() {
        return this.rateDate;
    }
    
    public void setRateDate(LocalDateTime rateDate) {
        this.rateDate = rateDate;
    }

    

    @Column(name="`currency`", nullable=false, length=6)
    public String getCurrency() {
        return this.currency;
    }
    
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    

    @Column(name="`value?`", nullable=false, scale=4)
    public Double getValue_() {
        return this.value_;
    }
    
    public void setValue_(Double value_) {
        this.value_ = value_;
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





    public boolean equals(Object o) {
         if (this == o) return true;
		 if ( (o == null )) return false;
		 if ( !(o instanceof RateCurrency) )
		    return false;

		 RateCurrency that = (RateCurrency) o;

		 return ( (this.getIdRateCurrency()==that.getIdRateCurrency()) || ( this.getIdRateCurrency()!=null && that.getIdRateCurrency()!=null && this.getIdRateCurrency().equals(that.getIdRateCurrency()) ) );
    }

    public int hashCode() {
         int result = 17;

         result = 37 * result + ( getIdRateCurrency() == null ? 0 : this.getIdRateCurrency().hashCode() );

         return result;
    }


}

