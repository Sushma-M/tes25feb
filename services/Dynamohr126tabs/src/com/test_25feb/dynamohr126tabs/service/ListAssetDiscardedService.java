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
 * Service object for domain model class ListAssetDiscarded.
 * @see com.test_25feb.dynamohr126tabs.ListAssetDiscarded
 */

public interface ListAssetDiscardedService {
   /**
	 * Creates a new listassetdiscarded.
	 * 
	 * @param created
	 *            The information of the created listassetdiscarded.
	 * @return The created listassetdiscarded.
	 */
	public ListAssetDiscarded create(ListAssetDiscarded created);

	/**
	 * Deletes a listassetdiscarded.
	 * 
	 * @param listassetdiscardedId
	 *            The id of the deleted listassetdiscarded.
	 * @return The deleted listassetdiscarded.
	 * @throws EntityNotFoundException
	 *             if no listassetdiscarded is found with the given id.
	 */
	public ListAssetDiscarded delete(Integer listassetdiscardedId) throws EntityNotFoundException;

	/**
	 * Finds all listassetdiscardeds.
	 * 
	 * @return A list of listassetdiscardeds.
	 */
	public Page<ListAssetDiscarded> findAll(QueryFilter[] queryFilters, Pageable pageable);
	
	public Page<ListAssetDiscarded> findAll(Pageable pageable);
	
	/**
	 * Finds listassetdiscarded by id.
	 * 
	 * @param id
	 *            The id of the wanted listassetdiscarded.
	 * @return The found listassetdiscarded. If no listassetdiscarded is found, this method returns
	 *         null.
	 */
	public ListAssetDiscarded findById(Integer id) throws
	 EntityNotFoundException;
	/**
	 * Updates the information of a listassetdiscarded.
	 * 
	 * @param updated
	 *            The information of the updated listassetdiscarded.
	 * @return The updated listassetdiscarded.
	 * @throws EntityNotFoundException
	 *             if no listassetdiscarded is found with given id.
	 */
	public ListAssetDiscarded update(ListAssetDiscarded updated) throws EntityNotFoundException;

	/**
	 * Retrieve the total count of the listassetdiscardeds in the repository.
	 * 
	 * @param None
	 *            .
	 * @return The count of the listassetdiscarded.
	 */

	public long countAll();


    public Page<ListAssetDiscarded> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable);


}
