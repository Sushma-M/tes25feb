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
 * Assessment generated by hbm2java
 */
@Entity
@Table(name="`assessment`"
)

public class Assessment  implements java.io.Serializable {

    private Integer idAssessment;
    private Integer fkWorkPosition;
    private Integer userEvaluation;
    private String observation;
    private Integer modLocation;
    private Integer modUser;
    private Date modDate;
    private Set<AssessmentField> assessmentFields = new HashSet<AssessmentField>(0);

    public Assessment() {
    }


    @Id @GeneratedValue(strategy=IDENTITY)
    

    @Column(name="`id_assessment`", nullable=false, precision=10)
    public Integer getIdAssessment() {
        return this.idAssessment;
    }
    
    public void setIdAssessment(Integer idAssessment) {
        this.idAssessment = idAssessment;
    }

    

    @Column(name="`fk_work_position`", precision=10)
    public Integer getFkWorkPosition() {
        return this.fkWorkPosition;
    }
    
    public void setFkWorkPosition(Integer fkWorkPosition) {
        this.fkWorkPosition = fkWorkPosition;
    }

    

    @Column(name="`user_evaluation`", nullable=false, precision=10)
    public Integer getUserEvaluation() {
        return this.userEvaluation;
    }
    
    public void setUserEvaluation(Integer userEvaluation) {
        this.userEvaluation = userEvaluation;
    }

    

    @Column(name="`observation`", nullable=false, length=150)
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

    @OneToMany(fetch=FetchType.LAZY, cascade = {CascadeType.ALL}, mappedBy="assessment")
    public Set<AssessmentField> getAssessmentFields() {
        return this.assessmentFields;
    }
    
    public void setAssessmentFields(Set<AssessmentField> assessmentFields) {
        this.assessmentFields = assessmentFields;
    }





    public boolean equals(Object o) {
         if (this == o) return true;
		 if ( (o == null )) return false;
		 if ( !(o instanceof Assessment) )
		    return false;

		 Assessment that = (Assessment) o;

		 return ( (this.getIdAssessment()==that.getIdAssessment()) || ( this.getIdAssessment()!=null && that.getIdAssessment()!=null && this.getIdAssessment().equals(that.getIdAssessment()) ) );
    }

    public int hashCode() {
         int result = 17;

         result = 37 * result + ( getIdAssessment() == null ? 0 : this.getIdAssessment().hashCode() );

         return result;
    }


}

