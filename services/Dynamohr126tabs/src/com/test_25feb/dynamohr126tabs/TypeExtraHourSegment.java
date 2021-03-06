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


import java.util.Arrays;

import javax.persistence.Transient;
import javax.persistence.CascadeType;
import javax.persistence.UniqueConstraint;



/**
 * TypeExtraHourSegment generated by hbm2java
 */
@Entity
@Table(name="`type_extra_hour_segment`"
)

public class TypeExtraHourSegment  implements java.io.Serializable {

    private Integer idTypeExtraHourSegment;
    private Date startTime;
    private Date endTime;
    private Double rate;
    private String observation;
    private Currency currency;
    private Set<OverTimeSegmentPayroll> overTimeSegmentPayrolls = new HashSet<OverTimeSegmentPayroll>(0);

    public TypeExtraHourSegment() {
    }


    @Id @GeneratedValue(strategy=IDENTITY)
    

    @Column(name="`id_type_extra_hour_segment`", nullable=false, precision=10)
    public Integer getIdTypeExtraHourSegment() {
        return this.idTypeExtraHourSegment;
    }
    
    public void setIdTypeExtraHourSegment(Integer idTypeExtraHourSegment) {
        this.idTypeExtraHourSegment = idTypeExtraHourSegment;
    }

    @Temporal(TemporalType.TIME)

    @Column(name="`start_time`", nullable=false, length=8)
    public Date getStartTime() {
        return this.startTime;
    }
    
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    @Temporal(TemporalType.TIME)

    @Column(name="`end_time`", nullable=false, length=8)
    public Date getEndTime() {
        return this.endTime;
    }
    
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    

    @Column(name="`rate`", nullable=false, scale=4)
    public Double getRate() {
        return this.rate;
    }
    
    public void setRate(Double rate) {
        this.rate = rate;
    }

    

    @Column(name="`observation`", nullable=false, length=50)
    public String getObservation() {
        return this.observation;
    }
    
    public void setObservation(String observation) {
        this.observation = observation;
    }

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="`fk_currency`", nullable=false)
    public Currency getCurrency() {
        return this.currency;
    }
    
    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    @OneToMany(fetch=FetchType.LAZY, cascade = {CascadeType.ALL}, mappedBy="typeExtraHourSegment")
    public Set<OverTimeSegmentPayroll> getOverTimeSegmentPayrolls() {
        return this.overTimeSegmentPayrolls;
    }
    
    public void setOverTimeSegmentPayrolls(Set<OverTimeSegmentPayroll> overTimeSegmentPayrolls) {
        this.overTimeSegmentPayrolls = overTimeSegmentPayrolls;
    }





    public boolean equals(Object o) {
         if (this == o) return true;
		 if ( (o == null )) return false;
		 if ( !(o instanceof TypeExtraHourSegment) )
		    return false;

		 TypeExtraHourSegment that = (TypeExtraHourSegment) o;

		 return ( (this.getIdTypeExtraHourSegment()==that.getIdTypeExtraHourSegment()) || ( this.getIdTypeExtraHourSegment()!=null && that.getIdTypeExtraHourSegment()!=null && this.getIdTypeExtraHourSegment().equals(that.getIdTypeExtraHourSegment()) ) );
    }

    public int hashCode() {
         int result = 17;

         result = 37 * result + ( getIdTypeExtraHourSegment() == null ? 0 : this.getIdTypeExtraHourSegment().hashCode() );

         return result;
    }


}

