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
 * Log generated by hbm2java
 */
@Entity
@Table(name="`log`"
)

public class Log  implements java.io.Serializable {

    private Integer logId;
    private String description_;
    private Integer modLocation;
    private Date modDate;
    private LogOperation logOperation;
    private User user;

    public Log() {
    }


    @Id @GeneratedValue(strategy=IDENTITY)
    

    @Column(name="`log_id`", nullable=false, precision=10)
    public Integer getLogId() {
        return this.logId;
    }
    
    public void setLogId(Integer logId) {
        this.logId = logId;
    }

    

    @Column(name="`description?`", nullable=false, length=150)
    public String getDescription_() {
        return this.description_;
    }
    
    public void setDescription_(String description_) {
        this.description_ = description_;
    }

    

    @Column(name="`mod_location`", nullable=false, precision=10)
    public Integer getModLocation() {
        return this.modLocation;
    }
    
    public void setModLocation(Integer modLocation) {
        this.modLocation = modLocation;
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
    @JoinColumn(name="`fk_log_operation`", nullable=false)
    public LogOperation getLogOperation() {
        return this.logOperation;
    }
    
    public void setLogOperation(LogOperation logOperation) {
        this.logOperation = logOperation;
    }

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="`fk_user_responsible`", nullable=false)
    public User getUser() {
        return this.user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }





    public boolean equals(Object o) {
         if (this == o) return true;
		 if ( (o == null )) return false;
		 if ( !(o instanceof Log) )
		    return false;

		 Log that = (Log) o;

		 return ( (this.getLogId()==that.getLogId()) || ( this.getLogId()!=null && that.getLogId()!=null && this.getLogId().equals(that.getLogId()) ) );
    }

    public int hashCode() {
         int result = 17;

         result = 37 * result + ( getLogId() == null ? 0 : this.getLogId().hashCode() );

         return result;
    }


}

