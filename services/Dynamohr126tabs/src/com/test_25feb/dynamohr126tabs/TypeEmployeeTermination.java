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
 * TypeEmployeeTermination generated by hbm2java
 */
@Entity
@Table(name="`type_employee_termination`"
)

public class TypeEmployeeTermination  implements java.io.Serializable {

    private Integer idEmployeeTermination;
    private String nombre;
    private String name;
    private String observation;
    private Integer modUser;
    private Date modDate;
    private Set<EmployeeTermination> employeeTerminations = new HashSet<EmployeeTermination>(0);

    public TypeEmployeeTermination() {
    }


    @Id @GeneratedValue(strategy=IDENTITY)
    

    @Column(name="`id_employee_termination`", nullable=false, precision=10)
    public Integer getIdEmployeeTermination() {
        return this.idEmployeeTermination;
    }
    
    public void setIdEmployeeTermination(Integer idEmployeeTermination) {
        this.idEmployeeTermination = idEmployeeTermination;
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

    

    @Column(name="`observation`")
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

    @OneToMany(fetch=FetchType.LAZY, cascade = {CascadeType.ALL}, mappedBy="typeEmployeeTermination")
    public Set<EmployeeTermination> getEmployeeTerminations() {
        return this.employeeTerminations;
    }
    
    public void setEmployeeTerminations(Set<EmployeeTermination> employeeTerminations) {
        this.employeeTerminations = employeeTerminations;
    }





    public boolean equals(Object o) {
         if (this == o) return true;
		 if ( (o == null )) return false;
		 if ( !(o instanceof TypeEmployeeTermination) )
		    return false;

		 TypeEmployeeTermination that = (TypeEmployeeTermination) o;

		 return ( (this.getIdEmployeeTermination()==that.getIdEmployeeTermination()) || ( this.getIdEmployeeTermination()!=null && that.getIdEmployeeTermination()!=null && this.getIdEmployeeTermination().equals(that.getIdEmployeeTermination()) ) );
    }

    public int hashCode() {
         int result = 17;

         result = 37 * result + ( getIdEmployeeTermination() == null ? 0 : this.getIdEmployeeTermination().hashCode() );

         return result;
    }


}

