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
 * EmployeeSalary generated by hbm2java
 */
@Entity
@Table(name="`employee_salary`"
)

public class EmployeeSalary  implements java.io.Serializable {

    private Integer idEmployeeSalary;
    private String bankAccountNumber;
    private Boolean active;
    private Double monthlySalary;
    private Double biweeklySalary;
    private Double basicWageHour;
    private String observation;
    private Integer modLocation;
    private Integer modUser;
    private Date modDate;
    private Bank bank;
    private Currency currency;
    private Employee employee;
    private ScheduleDynamic scheduleDynamic;
    private ScheduleFixed scheduleFixed;
    private TypeEmployeePaymentMethod typeEmployeePaymentMethod;
    private TypeGenerationForm typeGenerationForm;

    public EmployeeSalary() {
    }


    @Id @GeneratedValue(strategy=IDENTITY)
    

    @Column(name="`id_employee_salary`", nullable=false, precision=10)
    public Integer getIdEmployeeSalary() {
        return this.idEmployeeSalary;
    }
    
    public void setIdEmployeeSalary(Integer idEmployeeSalary) {
        this.idEmployeeSalary = idEmployeeSalary;
    }

    

    @Column(name="`bank_account_number`", nullable=false, length=25)
    public String getBankAccountNumber() {
        return this.bankAccountNumber;
    }
    
    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    

    @Column(name="`active`", nullable=false)
    public Boolean getActive() {
        return this.active;
    }
    
    public void setActive(Boolean active) {
        this.active = active;
    }

    

    @Column(name="`monthly_salary`", nullable=false, scale=4)
    public Double getMonthlySalary() {
        return this.monthlySalary;
    }
    
    public void setMonthlySalary(Double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    

    @Column(name="`biweekly_salary`", nullable=false, scale=4)
    public Double getBiweeklySalary() {
        return this.biweeklySalary;
    }
    
    public void setBiweeklySalary(Double biweeklySalary) {
        this.biweeklySalary = biweeklySalary;
    }

    

    @Column(name="`basic_wage_hour`", nullable=false, scale=4)
    public Double getBasicWageHour() {
        return this.basicWageHour;
    }
    
    public void setBasicWageHour(Double basicWageHour) {
        this.basicWageHour = basicWageHour;
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

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="`fk_bank`")
    public Bank getBank() {
        return this.bank;
    }
    
    public void setBank(Bank bank) {
        this.bank = bank;
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
    @JoinColumn(name="`fk_employee`", nullable=false)
    public Employee getEmployee() {
        return this.employee;
    }
    
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="`fk_over_time_segment_payroll`")
    public ScheduleDynamic getScheduleDynamic() {
        return this.scheduleDynamic;
    }
    
    public void setScheduleDynamic(ScheduleDynamic scheduleDynamic) {
        this.scheduleDynamic = scheduleDynamic;
    }

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="`fk_schedule_fixed`")
    public ScheduleFixed getScheduleFixed() {
        return this.scheduleFixed;
    }
    
    public void setScheduleFixed(ScheduleFixed scheduleFixed) {
        this.scheduleFixed = scheduleFixed;
    }

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="`fk_type_employee_payment_method`", nullable=false)
    public TypeEmployeePaymentMethod getTypeEmployeePaymentMethod() {
        return this.typeEmployeePaymentMethod;
    }
    
    public void setTypeEmployeePaymentMethod(TypeEmployeePaymentMethod typeEmployeePaymentMethod) {
        this.typeEmployeePaymentMethod = typeEmployeePaymentMethod;
    }

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="`fk_type_generation_form`", nullable=false)
    public TypeGenerationForm getTypeGenerationForm() {
        return this.typeGenerationForm;
    }
    
    public void setTypeGenerationForm(TypeGenerationForm typeGenerationForm) {
        this.typeGenerationForm = typeGenerationForm;
    }





    public boolean equals(Object o) {
         if (this == o) return true;
		 if ( (o == null )) return false;
		 if ( !(o instanceof EmployeeSalary) )
		    return false;

		 EmployeeSalary that = (EmployeeSalary) o;

		 return ( (this.getIdEmployeeSalary()==that.getIdEmployeeSalary()) || ( this.getIdEmployeeSalary()!=null && that.getIdEmployeeSalary()!=null && this.getIdEmployeeSalary().equals(that.getIdEmployeeSalary()) ) );
    }

    public int hashCode() {
         int result = 17;

         result = 37 * result + ( getIdEmployeeSalary() == null ? 0 : this.getIdEmployeeSalary().hashCode() );

         return result;
    }


}
