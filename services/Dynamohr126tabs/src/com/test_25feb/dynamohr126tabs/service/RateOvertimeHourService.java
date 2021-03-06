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
 * Service object for domain model class RateOvertimeHour.
 * @see com.test_25feb.dynamohr126tabs.RateOvertimeHour
 */

public interface RateOvertimeHourService {
   /**
	 * Creates a new rateovertimehour.
	 * 
	 * @param created
	 *            The information of the created rateovertimehour.
	 * @return The created rateovertimehour.
	 */
	public RateOvertimeHour create(RateOvertimeHour created);

	/**
	 * Deletes a rateovertimehour.
	 * 
	 * @param rateovertimehourId
	 *            The id of the deleted rateovertimehour.
	 * @return The deleted rateovertimehour.
	 * @throws EntityNotFoundException
	 *             if no rateovertimehour is found with the given id.
	 */
	public RateOvertimeHour delete(Integer rateovertimehourId) throws EntityNotFoundException;

	/**
	 * Finds all rateovertimehours.
	 * 
	 * @return A list of rateovertimehours.
	 */
	public Page<RateOvertimeHour> findAll(QueryFilter[] queryFilters, Pageable pageable);
	
	public Page<RateOvertimeHour> findAll(Pageable pageable);
	
	/**
	 * Finds rateovertimehour by id.
	 * 
	 * @param id
	 *            The id of the wanted rateovertimehour.
	 * @return The found rateovertimehour. If no rateovertimehour is found, this method returns
	 *         null.
	 */
	public RateOvertimeHour findById(Integer id) throws
	 EntityNotFoundException;
	/**
	 * Updates the information of a rateovertimehour.
	 * 
	 * @param updated
	 *            The information of the updated rateovertimehour.
	 * @return The updated rateovertimehour.
	 * @throws EntityNotFoundException
	 *             if no rateovertimehour is found with given id.
	 */
	public RateOvertimeHour update(RateOvertimeHour updated) throws EntityNotFoundException;

	/**
	 * Retrieve the total count of the rateovertimehours in the repository.
	 * 
	 * @param None
	 *            .
	 * @return The count of the rateovertimehour.
	 */

	public long countAll();


    public Page<RateOvertimeHour> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable);


}

