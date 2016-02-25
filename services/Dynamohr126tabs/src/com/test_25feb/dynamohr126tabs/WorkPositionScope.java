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
 * WorkPositionScope generated by hbm2java
 */
@Entity
@Table(name="`work_position_scope`"
)

public class WorkPositionScope  implements java.io.Serializable {

    private Integer idWorkPositionScope;
    private String name;
    private String observation;
    private Integer modUser;
    private Date modDate;
    private WorkPosition workPosition;

    public WorkPositionScope() {
    }


    @Id @GeneratedValue(strategy=IDENTITY)
    

    @Column(name="`id_work_position_scope`", nullable=false, precision=10)
    public Integer getIdWorkPositionScope() {
        return this.idWorkPositionScope;
    }
    
    public void setIdWorkPositionScope(Integer idWorkPositionScope) {
        this.idWorkPositionScope = idWorkPositionScope;
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

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="`fk_work_position`", nullable=false)
    public WorkPosition getWorkPosition() {
        return this.workPosition;
    }
    
    public void setWorkPosition(WorkPosition workPosition) {
        this.workPosition = workPosition;
    }





    public boolean equals(Object o) {
         if (this == o) return true;
		 if ( (o == null )) return false;
		 if ( !(o instanceof WorkPositionScope) )
		    return false;

		 WorkPositionScope that = (WorkPositionScope) o;

		 return ( (this.getIdWorkPositionScope()==that.getIdWorkPositionScope()) || ( this.getIdWorkPositionScope()!=null && that.getIdWorkPositionScope()!=null && this.getIdWorkPositionScope().equals(that.getIdWorkPositionScope()) ) );
    }

    public int hashCode() {
         int result = 17;

         result = 37 * result + ( getIdWorkPositionScope() == null ? 0 : this.getIdWorkPositionScope().hashCode() );

         return result;
    }


}

