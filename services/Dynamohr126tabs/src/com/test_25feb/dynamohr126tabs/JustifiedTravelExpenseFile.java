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
 * JustifiedTravelExpenseFile generated by hbm2java
 */
@Entity
@Table(name="`justified_travel_expense_file`"
)

public class JustifiedTravelExpenseFile  implements java.io.Serializable {

    private Integer idJustifiedTravelExpenseFile;
    private String fileName;
    private String description_;
    private String mimeType;
    private String filePath;
    private Integer modLocation;
    private Integer modUser;
    private Date modDate;
    private TravelExpense travelExpense;

    public JustifiedTravelExpenseFile() {
    }


    @Id @GeneratedValue(strategy=IDENTITY)
    

    @Column(name="`id_justified_travel_expense_file`", nullable=false, precision=10)
    public Integer getIdJustifiedTravelExpenseFile() {
        return this.idJustifiedTravelExpenseFile;
    }
    
    public void setIdJustifiedTravelExpenseFile(Integer idJustifiedTravelExpenseFile) {
        this.idJustifiedTravelExpenseFile = idJustifiedTravelExpenseFile;
    }

    

    @Column(name="`file_name`", nullable=false, length=150)
    public String getFileName() {
        return this.fileName;
    }
    
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    

    @Column(name="`description?`", nullable=false, length=150)
    public String getDescription_() {
        return this.description_;
    }
    
    public void setDescription_(String description_) {
        this.description_ = description_;
    }

    

    @Column(name="`mime_type`", nullable=false, length=150)
    public String getMimeType() {
        return this.mimeType;
    }
    
    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    

    @Column(name="`file_path`", nullable=false)
    public String getFilePath() {
        return this.filePath;
    }
    
    public void setFilePath(String filePath) {
        this.filePath = filePath;
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
    @JoinColumn(name="`fk_travel_expense`", nullable=false)
    public TravelExpense getTravelExpense() {
        return this.travelExpense;
    }
    
    public void setTravelExpense(TravelExpense travelExpense) {
        this.travelExpense = travelExpense;
    }





    public boolean equals(Object o) {
         if (this == o) return true;
		 if ( (o == null )) return false;
		 if ( !(o instanceof JustifiedTravelExpenseFile) )
		    return false;

		 JustifiedTravelExpenseFile that = (JustifiedTravelExpenseFile) o;

		 return ( (this.getIdJustifiedTravelExpenseFile()==that.getIdJustifiedTravelExpenseFile()) || ( this.getIdJustifiedTravelExpenseFile()!=null && that.getIdJustifiedTravelExpenseFile()!=null && this.getIdJustifiedTravelExpenseFile().equals(that.getIdJustifiedTravelExpenseFile()) ) );
    }

    public int hashCode() {
         int result = 17;

         result = 37 * result + ( getIdJustifiedTravelExpenseFile() == null ? 0 : this.getIdJustifiedTravelExpenseFile().hashCode() );

         return result;
    }


}
