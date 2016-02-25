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


import java.util.Arrays;

import javax.persistence.Transient;
import javax.persistence.CascadeType;
import javax.persistence.UniqueConstraint;



/**
 * TypeEmployeePaymentMethod generated by hbm2java
 */
@Entity
@Table(name="`type_employee_payment_method`"
)

public class TypeEmployeePaymentMethod  implements java.io.Serializable {

    private Integer idTypeEmployeeStatus;
    private String nombre;
    private String name;
    private String observation;
    private Integer modUser;
    private Date modDate;
    private Set<EmployeeSalary> employeeSalaries = new HashSet<EmployeeSalary>(0);
    private Set<PayrollDetail> payrollDetails = new HashSet<PayrollDetail>(0);

    public TypeEmployeePaymentMethod() {
    }


    @Id @GeneratedValue(strategy=IDENTITY)
    

    @Column(name="`id_type_employee_status`", nullable=false, precision=10)
    public Integer getIdTypeEmployeeStatus() {
        return this.idTypeEmployeeStatus;
    }
    
    public void setIdTypeEmployeeStatus(Integer idTypeEmployeeStatus) {
        this.idTypeEmployeeStatus = idTypeEmployeeStatus;
    }

    

    @Column(name="`nombre`", nullable=false, length=50)
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    

    @Column(name="`name`", nullable=false, length=50)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    

    @Column(name="`observation`", length=150)
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

    @OneToMany(fetch=FetchType.LAZY, cascade = {CascadeType.ALL}, mappedBy="typeEmployeePaymentMethod")
    public Set<EmployeeSalary> getEmployeeSalaries() {
        return this.employeeSalaries;
    }
    
    public void setEmployeeSalaries(Set<EmployeeSalary> employeeSalaries) {
        this.employeeSalaries = employeeSalaries;
    }

    @OneToMany(fetch=FetchType.LAZY, cascade = {CascadeType.ALL}, mappedBy="typeEmployeePaymentMethod")
    public Set<PayrollDetail> getPayrollDetails() {
        return this.payrollDetails;
    }
    
    public void setPayrollDetails(Set<PayrollDetail> payrollDetails) {
        this.payrollDetails = payrollDetails;
    }





    public boolean equals(Object o) {
         if (this == o) return true;
		 if ( (o == null )) return false;
		 if ( !(o instanceof TypeEmployeePaymentMethod) )
		    return false;

		 TypeEmployeePaymentMethod that = (TypeEmployeePaymentMethod) o;

		 return ( (this.getIdTypeEmployeeStatus()==that.getIdTypeEmployeeStatus()) || ( this.getIdTypeEmployeeStatus()!=null && that.getIdTypeEmployeeStatus()!=null && this.getIdTypeEmployeeStatus().equals(that.getIdTypeEmployeeStatus()) ) );
    }

    public int hashCode() {
         int result = 17;

         result = 37 * result + ( getIdTypeEmployeeStatus() == null ? 0 : this.getIdTypeEmployeeStatus().hashCode() );

         return result;
    }


}
