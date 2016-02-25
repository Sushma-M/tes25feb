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
 * AssetPhotoFile generated by hbm2java
 */
@Entity
@Table(name="`asset_photo_file`"
)

public class AssetPhotoFile  implements java.io.Serializable {

    private Integer idAssetPhotoFile;
    private Boolean mainPhoto;
    private String fileName;
    private String mimeType;
    private String description_;
    private String filePath;
    private Integer modLocation;
    private Integer modUser;
    private Date modDate;
    private Asset asset;

    public AssetPhotoFile() {
    }


    @Id @GeneratedValue(strategy=IDENTITY)
    

    @Column(name="`id_asset_photo_file`", nullable=false, precision=10)
    public Integer getIdAssetPhotoFile() {
        return this.idAssetPhotoFile;
    }
    
    public void setIdAssetPhotoFile(Integer idAssetPhotoFile) {
        this.idAssetPhotoFile = idAssetPhotoFile;
    }

    

    @Column(name="`main_photo`", nullable=false)
    public Boolean getMainPhoto() {
        return this.mainPhoto;
    }
    
    public void setMainPhoto(Boolean mainPhoto) {
        this.mainPhoto = mainPhoto;
    }

    

    @Column(name="`file_name`", nullable=false, length=150)
    public String getFileName() {
        return this.fileName;
    }
    
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    

    @Column(name="`mime_type`", nullable=false, length=150)
    public String getMimeType() {
        return this.mimeType;
    }
    
    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    

    @Column(name="`description?`", nullable=false, length=150)
    public String getDescription_() {
        return this.description_;
    }
    
    public void setDescription_(String description_) {
        this.description_ = description_;
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
    @JoinColumn(name="`fk_asset`", nullable=false)
    public Asset getAsset() {
        return this.asset;
    }
    
    public void setAsset(Asset asset) {
        this.asset = asset;
    }





    public boolean equals(Object o) {
         if (this == o) return true;
		 if ( (o == null )) return false;
		 if ( !(o instanceof AssetPhotoFile) )
		    return false;

		 AssetPhotoFile that = (AssetPhotoFile) o;

		 return ( (this.getIdAssetPhotoFile()==that.getIdAssetPhotoFile()) || ( this.getIdAssetPhotoFile()!=null && that.getIdAssetPhotoFile()!=null && this.getIdAssetPhotoFile().equals(that.getIdAssetPhotoFile()) ) );
    }

    public int hashCode() {
         int result = 17;

         result = 37 * result + ( getIdAssetPhotoFile() == null ? 0 : this.getIdAssetPhotoFile().hashCode() );

         return result;
    }


}
