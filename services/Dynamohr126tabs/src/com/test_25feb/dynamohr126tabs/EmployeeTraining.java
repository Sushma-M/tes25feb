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
 * EmployeeTraining generated by hbm2java
 */
@Entity
@Table(name="`employee_training`"
)

public class EmployeeTraining  implements java.io.Serializable {

    private Integer idEmployeeTraining;
    private String trainingTopic;
    private String impartidoPor;
    private Boolean approximateDate;


@Type(type="DateTime")
    private LocalDateTime startTrainingDate;


@Type(type="DateTime")
    private LocalDateTime orderTrainingDate;
    private Integer duration;
    private String unitDuration;
    private Integer modLocation;
    private Integer modUser;
    private Date modDate;
    private Employee employee;

    public EmployeeTraining() {
    }


    @Id @GeneratedValue(strategy=IDENTITY)
    

    @Column(name="`id_employee_training`", nullable=false, precision=10)
    public Integer getIdEmployeeTraining() {
        return this.idEmployeeTraining;
    }
    
    public void setIdEmployeeTraining(Integer idEmployeeTraining) {
        this.idEmployeeTraining = idEmployeeTraining;
    }

    

    @Column(name="`training_topic`", nullable=false, length=150)
    public String getTrainingTopic() {
        return this.trainingTopic;
    }
    
    public void setTrainingTopic(String trainingTopic) {
        this.trainingTopic = trainingTopic;
    }

    

    @Column(name="`impartido_por`", nullable=false, length=64)
    public String getImpartidoPor() {
        return this.impartidoPor;
    }
    
    public void setImpartidoPor(String impartidoPor) {
        this.impartidoPor = impartidoPor;
    }

    

    @Column(name="`approximate_date`", nullable=false)
    public Boolean getApproximateDate() {
        return this.approximateDate;
    }
    
    public void setApproximateDate(Boolean approximateDate) {
        this.approximateDate = approximateDate;
    }

    

    @Column(name="`start_training_date`", nullable=false, length=10)
    public LocalDateTime getStartTrainingDate() {
        return this.startTrainingDate;
    }
    
    public void setStartTrainingDate(LocalDateTime startTrainingDate) {
        this.startTrainingDate = startTrainingDate;
    }

    

    @Column(name="`order_training_date`", length=10)
    public LocalDateTime getOrderTrainingDate() {
        return this.orderTrainingDate;
    }
    
    public void setOrderTrainingDate(LocalDateTime orderTrainingDate) {
        this.orderTrainingDate = orderTrainingDate;
    }

    

    @Column(name="`duration`", precision=10)
    public Integer getDuration() {
        return this.duration;
    }
    
    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    

    @Column(name="`unit_duration`", length=25)
    public String getUnitDuration() {
        return this.unitDuration;
    }
    
    public void setUnitDuration(String unitDuration) {
        this.unitDuration = unitDuration;
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
		 if ( !(o instanceof EmployeeTraining) )
		    return false;

		 EmployeeTraining that = (EmployeeTraining) o;

		 return ( (this.getIdEmployeeTraining()==that.getIdEmployeeTraining()) || ( this.getIdEmployeeTraining()!=null && that.getIdEmployeeTraining()!=null && this.getIdEmployeeTraining().equals(that.getIdEmployeeTraining()) ) );
    }

    public int hashCode() {
         int result = 17;

         result = 37 * result + ( getIdEmployeeTraining() == null ? 0 : this.getIdEmployeeTraining().hashCode() );

         return result;
    }


}

