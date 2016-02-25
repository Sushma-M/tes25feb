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
 * Service object for domain model class ScheduleFixed.
 * @see com.test_25feb.dynamohr126tabs.ScheduleFixed
 */

public interface ScheduleFixedService {
   /**
	 * Creates a new schedulefixed.
	 * 
	 * @param created
	 *            The information of the created schedulefixed.
	 * @return The created schedulefixed.
	 */
	public ScheduleFixed create(ScheduleFixed created);

	/**
	 * Deletes a schedulefixed.
	 * 
	 * @param schedulefixedId
	 *            The id of the deleted schedulefixed.
	 * @return The deleted schedulefixed.
	 * @throws EntityNotFoundException
	 *             if no schedulefixed is found with the given id.
	 */
	public ScheduleFixed delete(Integer schedulefixedId) throws EntityNotFoundException;

	/**
	 * Finds all schedulefixeds.
	 * 
	 * @return A list of schedulefixeds.
	 */
	public Page<ScheduleFixed> findAll(QueryFilter[] queryFilters, Pageable pageable);
	
	public Page<ScheduleFixed> findAll(Pageable pageable);
	
	/**
	 * Finds schedulefixed by id.
	 * 
	 * @param id
	 *            The id of the wanted schedulefixed.
	 * @return The found schedulefixed. If no schedulefixed is found, this method returns
	 *         null.
	 */
	public ScheduleFixed findById(Integer id) throws
	 EntityNotFoundException;
	/**
	 * Updates the information of a schedulefixed.
	 * 
	 * @param updated
	 *            The information of the updated schedulefixed.
	 * @return The updated schedulefixed.
	 * @throws EntityNotFoundException
	 *             if no schedulefixed is found with given id.
	 */
	public ScheduleFixed update(ScheduleFixed updated) throws EntityNotFoundException;

	/**
	 * Retrieve the total count of the schedulefixeds in the repository.
	 * 
	 * @param None
	 *            .
	 * @return The count of the schedulefixed.
	 */

	public long countAll();


    public Page<ScheduleFixed> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable);


}

