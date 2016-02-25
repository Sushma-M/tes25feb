/*Copyright (c) 2016-2017 gmail.com All Rights Reserved.
 This software is the confidential and proprietary information of gmail.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with gmail.com*/

package com.test_25feb.dynamohr126tabs;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Embeddable;


import java.util.Arrays;

import javax.persistence.Transient;
import javax.persistence.CascadeType;
import javax.persistence.UniqueConstraint;



/**
 * DetallePlanillaEgresosId generated by hbm2java
 */
@Embeddable
public class DetallePlanillaEgresosId  implements java.io.Serializable {

    private Integer idPayrollDetail;
    private String type_;
    private String code;
    private String description_;
    private String currency;
    private Double value_;

    public DetallePlanillaEgresosId() {
    }


    public Integer getIdPayrollDetail() {
        return this.idPayrollDetail;
    }
    
    public void setIdPayrollDetail(Integer idPayrollDetail) {
        this.idPayrollDetail = idPayrollDetail;
    }
    public String getType_() {
        return this.type_;
    }
    
    public void setType_(String type_) {
        this.type_ = type_;
    }
    public String getCode() {
        return this.code;
    }
    
    public void setCode(String code) {
        this.code = code;
    }
    public String getDescription_() {
        return this.description_;
    }
    
    public void setDescription_(String description_) {
        this.description_ = description_;
    }
    public String getCurrency() {
        return this.currency;
    }
    
    public void setCurrency(String currency) {
        this.currency = currency;
    }
    public Double getValue_() {
        return this.value_;
    }
    
    public void setValue_(Double value_) {
        this.value_ = value_;
    }





    public boolean equals(Object o) {
         if (this == o) return true;
		 if ( (o == null )) return false;
		 if ( !(o instanceof DetallePlanillaEgresosId) )
		    return false;

		 DetallePlanillaEgresosId that = (DetallePlanillaEgresosId) o;

         return ( (this.getIdPayrollDetail()==that.getIdPayrollDetail()) || ( this.getIdPayrollDetail()!=null && that.getIdPayrollDetail()!=null && this.getIdPayrollDetail().equals(that.getIdPayrollDetail()) ) )
 && ( (this.getType_()==that.getType_()) || ( this.getType_()!=null && that.getType_()!=null && this.getType_().equals(that.getType_()) ) )
 && ( (this.getCode()==that.getCode()) || ( this.getCode()!=null && that.getCode()!=null && this.getCode().equals(that.getCode()) ) )
 && ( (this.getDescription_()==that.getDescription_()) || ( this.getDescription_()!=null && that.getDescription_()!=null && this.getDescription_().equals(that.getDescription_()) ) )
 && ( (this.getCurrency()==that.getCurrency()) || ( this.getCurrency()!=null && that.getCurrency()!=null && this.getCurrency().equals(that.getCurrency()) ) )
 && ( (this.getValue_()==that.getValue_()) || ( this.getValue_()!=null && that.getValue_()!=null && this.getValue_().equals(that.getValue_()) ) );
    }

    public int hashCode() {
         int result = 17;

         result = 37 * result + ( getIdPayrollDetail() == null ? 0 : this.getIdPayrollDetail().hashCode() );
         result = 37 * result + ( getType_() == null ? 0 : this.getType_().hashCode() );
         result = 37 * result + ( getCode() == null ? 0 : this.getCode().hashCode() );
         result = 37 * result + ( getDescription_() == null ? 0 : this.getDescription_().hashCode() );
         result = 37 * result + ( getCurrency() == null ? 0 : this.getCurrency().hashCode() );
         result = 37 * result + ( getValue_() == null ? 0 : this.getValue_().hashCode() );

         return result;
    }


}

