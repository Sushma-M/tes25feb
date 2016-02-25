/*Copyright (c) 2016-2017 gmail.com All Rights Reserved.
 This software is the confidential and proprietary information of gmail.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with gmail.com*/

package com.test_25feb.dynamohr126tabs;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import javax.persistence.PrimaryKeyJoinColumn;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
 * CompanyDepartment generated by hbm2java
 */
@Entity
@Table(name="`company_department`"
)

public class CompanyDepartment  implements java.io.Serializable {

    private Integer idCompanyDepartment;
    private String name;
    private String observation;
    private Integer modLocation;
    private Integer modUser;
    private Date modDate;
    private Set<WorkPosition> workPositions = new HashSet<WorkPosition>(0);
    private CompanyDepartment companyDepartmentByFkSuperiorDepartment;
    private Set<CompanyDepartment> companyDepartmentsForFkSuperiorDepartment = new HashSet<CompanyDepartment>(0);
    private Location location;
    private TypeCompanyDepartment typeCompanyDepartment;

    public CompanyDepartment() {
    }


    @Id 
    

    @Column(name="`id_company_department`", nullable=false, precision=10)
    public Integer getIdCompanyDepartment() {
        return this.idCompanyDepartment;
    }
    
    public void setIdCompanyDepartment(Integer idCompanyDepartment) {
        this.idCompanyDepartment = idCompanyDepartment;
    }

    

    @Column(name="`name`", nullable=false, length=150)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
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

    @OneToMany(fetch=FetchType.LAZY, cascade = {CascadeType.ALL}, mappedBy="companyDepartment")
    public Set<WorkPosition> getWorkPositions() {
        return this.workPositions;
    }
    
    public void setWorkPositions(Set<WorkPosition> workPositions) {
        this.workPositions = workPositions;
    }

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="`fk_superior_department`", nullable=false)
    @JsonIgnoreProperties({"companyDepartmentByFkSuperiorDepartment", "companyDepartmentsForFkSuperiorDepartment"})
    public CompanyDepartment getCompanyDepartmentByFkSuperiorDepartment() {
        return this.companyDepartmentByFkSuperiorDepartment;
    }
    
    public void setCompanyDepartmentByFkSuperiorDepartment(CompanyDepartment companyDepartmentByFkSuperiorDepartment) {
        this.companyDepartmentByFkSuperiorDepartment = companyDepartmentByFkSuperiorDepartment;
    }

    @OneToMany(fetch=FetchType.LAZY, cascade = {CascadeType.ALL}, mappedBy="companyDepartmentByFkSuperiorDepartment")
    public Set<CompanyDepartment> getCompanyDepartmentsForFkSuperiorDepartment() {
        return this.companyDepartmentsForFkSuperiorDepartment;
    }
    
    public void setCompanyDepartmentsForFkSuperiorDepartment(Set<CompanyDepartment> companyDepartmentsForFkSuperiorDepartment) {
        this.companyDepartmentsForFkSuperiorDepartment = companyDepartmentsForFkSuperiorDepartment;
    }

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="`fk_location`", nullable=false)
    public Location getLocation() {
        return this.location;
    }
    
    public void setLocation(Location location) {
        this.location = location;
    }

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="`fk_type_company_department`", nullable=false)
    public TypeCompanyDepartment getTypeCompanyDepartment() {
        return this.typeCompanyDepartment;
    }
    
    public void setTypeCompanyDepartment(TypeCompanyDepartment typeCompanyDepartment) {
        this.typeCompanyDepartment = typeCompanyDepartment;
    }





    public boolean equals(Object o) {
         if (this == o) return true;
		 if ( (o == null )) return false;
		 if ( !(o instanceof CompanyDepartment) )
		    return false;

		 CompanyDepartment that = (CompanyDepartment) o;

		 return ( (this.getIdCompanyDepartment()==that.getIdCompanyDepartment()) || ( this.getIdCompanyDepartment()!=null && that.getIdCompanyDepartment()!=null && this.getIdCompanyDepartment().equals(that.getIdCompanyDepartment()) ) );
    }

    public int hashCode() {
         int result = 17;

         result = 37 * result + ( getIdCompanyDepartment() == null ? 0 : this.getIdCompanyDepartment().hashCode() );

         return result;
    }


}
