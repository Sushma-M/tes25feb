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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
 * AssetAssignDocument generated by hbm2java
 */
@Entity
@Table(name="`asset_assign_document`"
)

public class AssetAssignDocument  implements java.io.Serializable {

    private Integer idAssetAssignDocument;


@Type(type="DateTime")
    private LocalDateTime noteOfficeDate;
    private Boolean printedNote;
    private Integer userDevelops;
    private String observation;
    private Integer modLocation;
    private Integer modUser;
    private Date modDate;
    private Employee employee;
    private Set<ListAssetLoaded> listAssetLoadeds = new HashSet<ListAssetLoaded>(0);

    public AssetAssignDocument() {
    }


    @Id 
    

    @Column(name="`id_asset_assign_document`", nullable=false, precision=10)
    public Integer getIdAssetAssignDocument() {
        return this.idAssetAssignDocument;
    }
    
    public void setIdAssetAssignDocument(Integer idAssetAssignDocument) {
        this.idAssetAssignDocument = idAssetAssignDocument;
    }

    

    @Column(name="`note_office_date`", nullable=false)
    public LocalDateTime getNoteOfficeDate() {
        return this.noteOfficeDate;
    }
    
    public void setNoteOfficeDate(LocalDateTime noteOfficeDate) {
        this.noteOfficeDate = noteOfficeDate;
    }

    

    @Column(name="`printed_note`", nullable=false)
    public Boolean getPrintedNote() {
        return this.printedNote;
    }
    
    public void setPrintedNote(Boolean printedNote) {
        this.printedNote = printedNote;
    }

    

    @Column(name="`user_develops`", nullable=false, precision=10)
    public Integer getUserDevelops() {
        return this.userDevelops;
    }
    
    public void setUserDevelops(Integer userDevelops) {
        this.userDevelops = userDevelops;
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

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="`fk_employee`", nullable=false)
    public Employee getEmployee() {
        return this.employee;
    }
    
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @OneToMany(fetch=FetchType.LAZY, cascade = {CascadeType.ALL}, mappedBy="assetAssignDocument")
    public Set<ListAssetLoaded> getListAssetLoadeds() {
        return this.listAssetLoadeds;
    }
    
    public void setListAssetLoadeds(Set<ListAssetLoaded> listAssetLoadeds) {
        this.listAssetLoadeds = listAssetLoadeds;
    }





    public boolean equals(Object o) {
         if (this == o) return true;
		 if ( (o == null )) return false;
		 if ( !(o instanceof AssetAssignDocument) )
		    return false;

		 AssetAssignDocument that = (AssetAssignDocument) o;

		 return ( (this.getIdAssetAssignDocument()==that.getIdAssetAssignDocument()) || ( this.getIdAssetAssignDocument()!=null && that.getIdAssetAssignDocument()!=null && this.getIdAssetAssignDocument().equals(that.getIdAssetAssignDocument()) ) );
    }

    public int hashCode() {
         int result = 17;

         result = 37 * result + ( getIdAssetAssignDocument() == null ? 0 : this.getIdAssetAssignDocument().hashCode() );

         return result;
    }


}

