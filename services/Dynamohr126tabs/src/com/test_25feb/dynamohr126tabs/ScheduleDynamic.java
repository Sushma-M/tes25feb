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
 * ScheduleDynamic generated by hbm2java
 */
@Entity
@Table(name="`schedule_dynamic`"
)

public class ScheduleDynamic  implements java.io.Serializable {

    private Integer idScheduleDynamic;


@Type(type="DateTime")
    private LocalDateTime checkIn;


@Type(type="DateTime")
    private LocalDateTime lunchHourStart;


@Type(type="DateTime")
    private LocalDateTime lunchHourEnd;


@Type(type="DateTime")
    private LocalDateTime outputTime;
    private String observation;
    private Boolean hourLunchPaid;
    private Integer modUser;
    private Date modDate;
    private Set<EmployeeSalary> employeeSalaries = new HashSet<EmployeeSalary>(0);
    private Employee employee;

    public ScheduleDynamic() {
    }


    @Id @GeneratedValue(strategy=IDENTITY)
    

    @Column(name="`id_schedule_dynamic`", nullable=false, precision=10)
    public Integer getIdScheduleDynamic() {
        return this.idScheduleDynamic;
    }
    
    public void setIdScheduleDynamic(Integer idScheduleDynamic) {
        this.idScheduleDynamic = idScheduleDynamic;
    }

    

    @Column(name="`check_in`", nullable=false)
    public LocalDateTime getCheckIn() {
        return this.checkIn;
    }
    
    public void setCheckIn(LocalDateTime checkIn) {
        this.checkIn = checkIn;
    }

    

    @Column(name="`lunch_hour_start`", nullable=false)
    public LocalDateTime getLunchHourStart() {
        return this.lunchHourStart;
    }
    
    public void setLunchHourStart(LocalDateTime lunchHourStart) {
        this.lunchHourStart = lunchHourStart;
    }

    

    @Column(name="`lunch_hour_end`", nullable=false)
    public LocalDateTime getLunchHourEnd() {
        return this.lunchHourEnd;
    }
    
    public void setLunchHourEnd(LocalDateTime lunchHourEnd) {
        this.lunchHourEnd = lunchHourEnd;
    }

    

    @Column(name="`output_time`", nullable=false)
    public LocalDateTime getOutputTime() {
        return this.outputTime;
    }
    
    public void setOutputTime(LocalDateTime outputTime) {
        this.outputTime = outputTime;
    }

    

    @Column(name="`observation`")
    public String getObservation() {
        return this.observation;
    }
    
    public void setObservation(String observation) {
        this.observation = observation;
    }

    

    @Column(name="`hour_lunch_paid`", nullable=false)
    public Boolean getHourLunchPaid() {
        return this.hourLunchPaid;
    }
    
    public void setHourLunchPaid(Boolean hourLunchPaid) {
        this.hourLunchPaid = hourLunchPaid;
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

    @OneToMany(fetch=FetchType.LAZY, cascade = {CascadeType.ALL}, mappedBy="scheduleDynamic")
    public Set<EmployeeSalary> getEmployeeSalaries() {
        return this.employeeSalaries;
    }
    
    public void setEmployeeSalaries(Set<EmployeeSalary> employeeSalaries) {
        this.employeeSalaries = employeeSalaries;
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
		 if ( !(o instanceof ScheduleDynamic) )
		    return false;

		 ScheduleDynamic that = (ScheduleDynamic) o;

		 return ( (this.getIdScheduleDynamic()==that.getIdScheduleDynamic()) || ( this.getIdScheduleDynamic()!=null && that.getIdScheduleDynamic()!=null && this.getIdScheduleDynamic().equals(that.getIdScheduleDynamic()) ) );
    }

    public int hashCode() {
         int result = 17;

         result = 37 * result + ( getIdScheduleDynamic() == null ? 0 : this.getIdScheduleDynamic().hashCode() );

         return result;
    }


}

