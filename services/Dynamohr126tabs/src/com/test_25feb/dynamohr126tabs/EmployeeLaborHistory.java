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
import org.hibernate.annotations.Type;
import org.joda.time.LocalDateTime;


import java.util.Arrays;

import javax.persistence.Transient;
import javax.persistence.CascadeType;
import javax.persistence.UniqueConstraint;



/**
 * EmployeeLaborHistory generated by hbm2java
 */
@Entity
@Table(name="`employee_labor_history`"
)

public class EmployeeLaborHistory  implements java.io.Serializable {

    private Integer idEmployeeLaborHistory;
    private String charge;
    private String institution;


@Type(type="DateTime")
    private LocalDateTime startDate;


@Type(type="DateTime")
    private LocalDateTime finalDate;
    private String occasionOfRetirement;
    private Integer modLocation;
    private Integer modUser;
    private Date modDate;
    private Employee employee;

    public EmployeeLaborHistory() {
    }


    @Id @GeneratedValue(strategy=IDENTITY)
    

    @Column(name="`id_employee_labor_history`", nullable=false, precision=10)
    public Integer getIdEmployeeLaborHistory() {
        return this.idEmployeeLaborHistory;
    }
    
    public void setIdEmployeeLaborHistory(Integer idEmployeeLaborHistory) {
        this.idEmployeeLaborHistory = idEmployeeLaborHistory;
    }

    

    @Column(name="`charge`", nullable=false, length=100)
    public String getCharge() {
        return this.charge;
    }
    
    public void setCharge(String charge) {
        this.charge = charge;
    }

    

    @Column(name="`institution`", nullable=false, length=150)
    public String getInstitution() {
        return this.institution;
    }
    
    public void setInstitution(String institution) {
        this.institution = institution;
    }

    

    @Column(name="`start_date`", length=10)
    public LocalDateTime getStartDate() {
        return this.startDate;
    }
    
    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    

    @Column(name="`final_date`", length=10)
    public LocalDateTime getFinalDate() {
        return this.finalDate;
    }
    
    public void setFinalDate(LocalDateTime finalDate) {
        this.finalDate = finalDate;
    }

    

    @Column(name="`occasion_of_retirement`", nullable=false, length=100)
    public String getOccasionOfRetirement() {
        return this.occasionOfRetirement;
    }
    
    public void setOccasionOfRetirement(String occasionOfRetirement) {
        this.occasionOfRetirement = occasionOfRetirement;
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
    @JoinColumn(name="`fk_employee`", nullable=false)
    public Employee getEmployee() {
        return this.employee;
    }
    
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }





    public boolean equals(Object o) {
         if (this == o) return true;
		 if ( (o == null )) return false;
		 if ( !(o instanceof EmployeeLaborHistory) )
		    return false;

		 EmployeeLaborHistory that = (EmployeeLaborHistory) o;

		 return ( (this.getIdEmployeeLaborHistory()==that.getIdEmployeeLaborHistory()) || ( this.getIdEmployeeLaborHistory()!=null && that.getIdEmployeeLaborHistory()!=null && this.getIdEmployeeLaborHistory().equals(that.getIdEmployeeLaborHistory()) ) );
    }

    public int hashCode() {
         int result = 17;

         result = 37 * result + ( getIdEmployeeLaborHistory() == null ? 0 : this.getIdEmployeeLaborHistory().hashCode() );

         return result;
    }


}

