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
 * EmployeeEducation generated by hbm2java
 */
@Entity
@Table(name="`employee_education`"
)

public class EmployeeEducation  implements java.io.Serializable {

    private Integer idEmployeeEducation;
    private String title;
    private String institution;
    private Integer yearRetrieved;
    private Integer modLocation;
    private Integer modUser;
    private Date modDate;
    private Employee employee;
    private TypeEducation typeEducation;

    public EmployeeEducation() {
    }


    @Id @GeneratedValue(strategy=IDENTITY)
    

    @Column(name="`id_employee_education`", nullable=false, precision=10)
    public Integer getIdEmployeeEducation() {
        return this.idEmployeeEducation;
    }
    
    public void setIdEmployeeEducation(Integer idEmployeeEducation) {
        this.idEmployeeEducation = idEmployeeEducation;
    }

    

    @Column(name="`title`", nullable=false, length=100)
    public String getTitle() {
        return this.title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }

    

    @Column(name="`institution`", nullable=false, length=100)
    public String getInstitution() {
        return this.institution;
    }
    
    public void setInstitution(String institution) {
        this.institution = institution;
    }

    

    @Column(name="`year_retrieved`", nullable=false, precision=10)
    public Integer getYearRetrieved() {
        return this.yearRetrieved;
    }
    
    public void setYearRetrieved(Integer yearRetrieved) {
        this.yearRetrieved = yearRetrieved;
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

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="`fk_type_education`", nullable=false)
    public TypeEducation getTypeEducation() {
        return this.typeEducation;
    }
    
    public void setTypeEducation(TypeEducation typeEducation) {
        this.typeEducation = typeEducation;
    }





    public boolean equals(Object o) {
         if (this == o) return true;
		 if ( (o == null )) return false;
		 if ( !(o instanceof EmployeeEducation) )
		    return false;

		 EmployeeEducation that = (EmployeeEducation) o;

		 return ( (this.getIdEmployeeEducation()==that.getIdEmployeeEducation()) || ( this.getIdEmployeeEducation()!=null && that.getIdEmployeeEducation()!=null && this.getIdEmployeeEducation().equals(that.getIdEmployeeEducation()) ) );
    }

    public int hashCode() {
         int result = 17;

         result = 37 * result + ( getIdEmployeeEducation() == null ? 0 : this.getIdEmployeeEducation().hashCode() );

         return result;
    }


}

