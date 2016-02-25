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
 * ListAssetLoaded generated by hbm2java
 */
@Entity
@Table(name="`list_asset_loaded`"
)

public class ListAssetLoaded  implements java.io.Serializable {

    private Integer idListAssetLoaded;
    private Boolean currentlyLoaded;
    private Integer modLocation;
    private Integer modUser;
    private Date modDate;
    private Asset asset;
    private AssetAssignDocument assetAssignDocument;

    public ListAssetLoaded() {
    }


    @Id @GeneratedValue(strategy=IDENTITY)
    

    @Column(name="`id_list_asset_loaded`", nullable=false, precision=10)
    public Integer getIdListAssetLoaded() {
        return this.idListAssetLoaded;
    }
    
    public void setIdListAssetLoaded(Integer idListAssetLoaded) {
        this.idListAssetLoaded = idListAssetLoaded;
    }

    

    @Column(name="`currently_loaded`", nullable=false)
    public Boolean getCurrentlyLoaded() {
        return this.currentlyLoaded;
    }
    
    public void setCurrentlyLoaded(Boolean currentlyLoaded) {
        this.currentlyLoaded = currentlyLoaded;
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
    @JoinColumn(name="`fk_asset`", nullable=false)
    public Asset getAsset() {
        return this.asset;
    }
    
    public void setAsset(Asset asset) {
        this.asset = asset;
    }

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="`fk_asset_assign_document`", nullable=false)
    public AssetAssignDocument getAssetAssignDocument() {
        return this.assetAssignDocument;
    }
    
    public void setAssetAssignDocument(AssetAssignDocument assetAssignDocument) {
        this.assetAssignDocument = assetAssignDocument;
    }





    public boolean equals(Object o) {
         if (this == o) return true;
		 if ( (o == null )) return false;
		 if ( !(o instanceof ListAssetLoaded) )
		    return false;

		 ListAssetLoaded that = (ListAssetLoaded) o;

		 return ( (this.getIdListAssetLoaded()==that.getIdListAssetLoaded()) || ( this.getIdListAssetLoaded()!=null && that.getIdListAssetLoaded()!=null && this.getIdListAssetLoaded().equals(that.getIdListAssetLoaded()) ) );
    }

    public int hashCode() {
         int result = 17;

         result = 37 * result + ( getIdListAssetLoaded() == null ? 0 : this.getIdListAssetLoaded().hashCode() );

         return result;
    }


}

