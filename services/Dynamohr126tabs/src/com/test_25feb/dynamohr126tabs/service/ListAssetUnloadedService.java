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
 * Service object for domain model class ListAssetUnloaded.
 * @see com.test_25feb.dynamohr126tabs.ListAssetUnloaded
 */

public interface ListAssetUnloadedService {
   /**
	 * Creates a new listassetunloaded.
	 * 
	 * @param created
	 *            The information of the created listassetunloaded.
	 * @return The created listassetunloaded.
	 */
	public ListAssetUnloaded create(ListAssetUnloaded created);

	/**
	 * Deletes a listassetunloaded.
	 * 
	 * @param listassetunloadedId
	 *            The id of the deleted listassetunloaded.
	 * @return The deleted listassetunloaded.
	 * @throws EntityNotFoundException
	 *             if no listassetunloaded is found with the given id.
	 */
	public ListAssetUnloaded delete(Integer listassetunloadedId) throws EntityNotFoundException;

	/**
	 * Finds all listassetunloadeds.
	 * 
	 * @return A list of listassetunloadeds.
	 */
	public Page<ListAssetUnloaded> findAll(QueryFilter[] queryFilters, Pageable pageable);
	
	public Page<ListAssetUnloaded> findAll(Pageable pageable);
	
	/**
	 * Finds listassetunloaded by id.
	 * 
	 * @param id
	 *            The id of the wanted listassetunloaded.
	 * @return The found listassetunloaded. If no listassetunloaded is found, this method returns
	 *         null.
	 */
	public ListAssetUnloaded findById(Integer id) throws
	 EntityNotFoundException;
	/**
	 * Updates the information of a listassetunloaded.
	 * 
	 * @param updated
	 *            The information of the updated listassetunloaded.
	 * @return The updated listassetunloaded.
	 * @throws EntityNotFoundException
	 *             if no listassetunloaded is found with given id.
	 */
	public ListAssetUnloaded update(ListAssetUnloaded updated) throws EntityNotFoundException;

	/**
	 * Retrieve the total count of the listassetunloadeds in the repository.
	 * 
	 * @param None
	 *            .
	 * @return The count of the listassetunloaded.
	 */

	public long countAll();


    public Page<ListAssetUnloaded> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable);


}

