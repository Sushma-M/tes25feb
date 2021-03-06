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
 * Service object for domain model class WorkPosition.
 * @see com.test_25feb.dynamohr126tabs.WorkPosition
 */

public interface WorkPositionService {
   /**
	 * Creates a new workposition.
	 * 
	 * @param created
	 *            The information of the created workposition.
	 * @return The created workposition.
	 */
	public WorkPosition create(WorkPosition created);

	/**
	 * Deletes a workposition.
	 * 
	 * @param workpositionId
	 *            The id of the deleted workposition.
	 * @return The deleted workposition.
	 * @throws EntityNotFoundException
	 *             if no workposition is found with the given id.
	 */
	public WorkPosition delete(Integer workpositionId) throws EntityNotFoundException;

	/**
	 * Finds all workpositions.
	 * 
	 * @return A list of workpositions.
	 */
	public Page<WorkPosition> findAll(QueryFilter[] queryFilters, Pageable pageable);
	
	public Page<WorkPosition> findAll(Pageable pageable);
	
	/**
	 * Finds workposition by id.
	 * 
	 * @param id
	 *            The id of the wanted workposition.
	 * @return The found workposition. If no workposition is found, this method returns
	 *         null.
	 */
	public WorkPosition findById(Integer id) throws
	 EntityNotFoundException;
	/**
	 * Updates the information of a workposition.
	 * 
	 * @param updated
	 *            The information of the updated workposition.
	 * @return The updated workposition.
	 * @throws EntityNotFoundException
	 *             if no workposition is found with given id.
	 */
	public WorkPosition update(WorkPosition updated) throws EntityNotFoundException;

	/**
	 * Retrieve the total count of the workpositions in the repository.
	 * 
	 * @param None
	 *            .
	 * @return The count of the workposition.
	 */

	public long countAll();


    public Page<WorkPosition> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable);


}

