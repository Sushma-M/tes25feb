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
 * IncidenceEmployee generated by hbm2java
 */
@Entity
@Table(name="`incidence_employee`"
)

public class IncidenceEmployee  implements java.io.Serializable {

    private Integer idIncidenceEmployee;


@Type(type="DateTime")
    private LocalDateTime incidenceDate;
    private String observation;
    private Integer modLocation;
    private Integer modUser;
    private Date modDate;
    private Employee employee;
    private TypeIncident typeIncident;

    public IncidenceEmployee() {
    }


    @Id @GeneratedValue(strategy=IDENTITY)
    

    @Column(name="`id_incidence_employee`", nullable=false, precision=10)
    public Integer getIdIncidenceEmployee() {
        return this.idIncidenceEmployee;
    }
    
    public void setIdIncidenceEmployee(Integer idIncidenceEmployee) {
        this.idIncidenceEmployee = idIncidenceEmployee;
    }

    

    @Column(name="`incidence_date`", nullable=false, length=10)
    public LocalDateTime getIncidenceDate() {
        return this.incidenceDate;
    }
    
    public void setIncidenceDate(LocalDateTime incidenceDate) {
        this.incidenceDate = incidenceDate;
    }

    

    @Column(name="`observation`", nullable=false)
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
    @JoinColumn(name="`fk_employee`", nullable=false)
    public Employee getEmployee() {
        return this.employee;
    }
    
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="`fk_type_incident`", nullable=false)
    public TypeIncident getTypeIncident() {
        return this.typeIncident;
    }
    
    public void setTypeIncident(TypeIncident typeIncident) {
        this.typeIncident = typeIncident;
    }





    public boolean equals(Object o) {
         if (this == o) return true;
		 if ( (o == null )) return false;
		 if ( !(o instanceof IncidenceEmployee) )
		    return false;

		 IncidenceEmployee that = (IncidenceEmployee) o;

		 return ( (this.getIdIncidenceEmployee()==that.getIdIncidenceEmployee()) || ( this.getIdIncidenceEmployee()!=null && that.getIdIncidenceEmployee()!=null && this.getIdIncidenceEmployee().equals(that.getIdIncidenceEmployee()) ) );
    }

    public int hashCode() {
         int result = 17;

         result = 37 * result + ( getIdIncidenceEmployee() == null ? 0 : this.getIdIncidenceEmployee().hashCode() );

         return result;
    }


}
