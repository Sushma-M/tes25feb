/*Copyright (c) 2016-2017 gmail.com All Rights Reserved.
 This software is the confidential and proprietary information of gmail.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with gmail.com*/

package com.test_25feb.dynamohr126tabs;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import javax.persistence.PrimaryKeyJoinColumn;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


import java.util.Arrays;

import javax.persistence.Transient;
import javax.persistence.CascadeType;
import javax.persistence.UniqueConstraint;



/**
 * ListTravelExpenseDetail generated by hbm2java
 */
@Entity
@Table(name="`list_travel_expense_detail`"
)

public class ListTravelExpenseDetail  implements java.io.Serializable {

    private Integer idListTravelExpenseDetail;
    private Double value_;
    private String observation;
    private Integer modLocation;
    private Integer modUser;
    private Date modDate;
    private Currency currency;
    private PayrollDetail payrollDetail;
    private TravelExpense travelExpense;

    public ListTravelExpenseDetail() {
    }


    @Id @GeneratedValue(strategy=IDENTITY)
    

    @Column(name="`id_list_travel_expense_detail`", nullable=false, precision=10)
    public Integer getIdListTravelExpenseDetail() {
        return this.idListTravelExpenseDetail;
    }
    
    public void setIdListTravelExpenseDetail(Integer idListTravelExpenseDetail) {
        this.idListTravelExpenseDetail = idListTravelExpenseDetail;
    }

    

    @Column(name="`value?`", nullable=false, scale=4)
    public Double getValue_() {
        return this.value_;
    }
    
    public void setValue_(Double value_) {
        this.value_ = value_;
    }

    

    @Column(name="`observation`", length=100)
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

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="`fk_currency`", nullable=false)
    public Currency getCurrency() {
        return this.currency;
    }
    
    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="`fk_payroll_detail`", nullable=false)
    public PayrollDetail getPayrollDetail() {
        return this.payrollDetail;
    }
    
    public void setPayrollDetail(PayrollDetail payrollDetail) {
        this.payrollDetail = payrollDetail;
    }

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="`fk_travel_expense`", nullable=false)
    public TravelExpense getTravelExpense() {
        return this.travelExpense;
    }
    
    public void setTravelExpense(TravelExpense travelExpense) {
        this.travelExpense = travelExpense;
    }





    public boolean equals(Object o) {
         if (this == o) return true;
		 if ( (o == null )) return false;
		 if ( !(o instanceof ListTravelExpenseDetail) )
		    return false;

		 ListTravelExpenseDetail that = (ListTravelExpenseDetail) o;

		 return ( (this.getIdListTravelExpenseDetail()==that.getIdListTravelExpenseDetail()) || ( this.getIdListTravelExpenseDetail()!=null && that.getIdListTravelExpenseDetail()!=null && this.getIdListTravelExpenseDetail().equals(that.getIdListTravelExpenseDetail()) ) );
    }

    public int hashCode() {
         int result = 17;

         result = 37 * result + ( getIdListTravelExpenseDetail() == null ? 0 : this.getIdListTravelExpenseDetail().hashCode() );

         return result;
    }


}

