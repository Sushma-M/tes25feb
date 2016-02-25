/*Copyright (c) 2016-2017 gmail.com All Rights Reserved.
 This software is the confidential and proprietary information of gmail.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with gmail.com*/

package com.test_25feb.dynamohr126tabs.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/




import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.exception.EntityNotFoundException;

import com.test_25feb.dynamohr126tabs.*;

/**
 * Service object for domain model class CompanyInfo.
 * @see com.test_25feb.dynamohr126tabs.CompanyInfo
 */

public interface CompanyInfoService {
   /**
	 * Creates a new companyinfo.
	 * 
	 * @param created
	 *            The information of the created companyinfo.
	 * @return The created companyinfo.
	 */
	public CompanyInfo create(CompanyInfo created);

	/**
	 * Deletes a companyinfo.
	 * 
	 * @param companyinfoId
	 *            The id of the deleted companyinfo.
	 * @return The deleted companyinfo.
	 * @throws EntityNotFoundException
	 *             if no companyinfo is found with the given id.
	 */
	public CompanyInfo delete(Integer companyinfoId) throws EntityNotFoundException;

	/**
	 * Finds all companyinfos.
	 * 
	 * @return A list of companyinfos.
	 */
	public Page<CompanyInfo> findAll(QueryFilter[] queryFilters, Pageable pageable);
	
	public Page<CompanyInfo> findAll(Pageable pageable);
	
	/**
	 * Finds companyinfo by id.
	 * 
	 * @param id
	 *            The id of the wanted companyinfo.
	 * @return The found companyinfo. If no companyinfo is found, this method returns
	 *         null.
	 */
	public CompanyInfo findById(Integer id) throws
	 EntityNotFoundException;
	/**
	 * Updates the information of a companyinfo.
	 * 
	 * @param updated
	 *            The information of the updated companyinfo.
	 * @return The updated companyinfo.
	 * @throws EntityNotFoundException
	 *             if no companyinfo is found with given id.
	 */
	public CompanyInfo update(CompanyInfo updated) throws EntityNotFoundException;

	/**
	 * Retrieve the total count of the companyinfos in the repository.
	 * 
	 * @param None
	 *            .
	 * @return The count of the companyinfo.
	 */

	public long countAll();


    public Page<CompanyInfo> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable);


}
