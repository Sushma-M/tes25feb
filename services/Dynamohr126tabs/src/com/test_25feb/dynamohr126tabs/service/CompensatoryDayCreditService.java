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
 * Service object for domain model class CompensatoryDayCredit.
 * @see com.test_25feb.dynamohr126tabs.CompensatoryDayCredit
 */

public interface CompensatoryDayCreditService {
   /**
	 * Creates a new compensatorydaycredit.
	 * 
	 * @param created
	 *            The information of the created compensatorydaycredit.
	 * @return The created compensatorydaycredit.
	 */
	public CompensatoryDayCredit create(CompensatoryDayCredit created);

	/**
	 * Deletes a compensatorydaycredit.
	 * 
	 * @param compensatorydaycreditId
	 *            The id of the deleted compensatorydaycredit.
	 * @return The deleted compensatorydaycredit.
	 * @throws EntityNotFoundException
	 *             if no compensatorydaycredit is found with the given id.
	 */
	public CompensatoryDayCredit delete(Integer compensatorydaycreditId) throws EntityNotFoundException;

	/**
	 * Finds all compensatorydaycredits.
	 * 
	 * @return A list of compensatorydaycredits.
	 */
	public Page<CompensatoryDayCredit> findAll(QueryFilter[] queryFilters, Pageable pageable);
	
	public Page<CompensatoryDayCredit> findAll(Pageable pageable);
	
	/**
	 * Finds compensatorydaycredit by id.
	 * 
	 * @param id
	 *            The id of the wanted compensatorydaycredit.
	 * @return The found compensatorydaycredit. If no compensatorydaycredit is found, this method returns
	 *         null.
	 */
	public CompensatoryDayCredit findById(Integer id) throws
	 EntityNotFoundException;
	/**
	 * Updates the information of a compensatorydaycredit.
	 * 
	 * @param updated
	 *            The information of the updated compensatorydaycredit.
	 * @return The updated compensatorydaycredit.
	 * @throws EntityNotFoundException
	 *             if no compensatorydaycredit is found with given id.
	 */
	public CompensatoryDayCredit update(CompensatoryDayCredit updated) throws EntityNotFoundException;

	/**
	 * Retrieve the total count of the compensatorydaycredits in the repository.
	 * 
	 * @param None
	 *            .
	 * @return The count of the compensatorydaycredit.
	 */

	public long countAll();


    public Page<CompensatoryDayCredit> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable);


}

