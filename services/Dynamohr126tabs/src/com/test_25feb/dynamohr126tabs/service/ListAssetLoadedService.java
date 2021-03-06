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
 * Service object for domain model class ListAssetLoaded.
 * @see com.test_25feb.dynamohr126tabs.ListAssetLoaded
 */

public interface ListAssetLoadedService {
   /**
	 * Creates a new listassetloaded.
	 * 
	 * @param created
	 *            The information of the created listassetloaded.
	 * @return The created listassetloaded.
	 */
	public ListAssetLoaded create(ListAssetLoaded created);

	/**
	 * Deletes a listassetloaded.
	 * 
	 * @param listassetloadedId
	 *            The id of the deleted listassetloaded.
	 * @return The deleted listassetloaded.
	 * @throws EntityNotFoundException
	 *             if no listassetloaded is found with the given id.
	 */
	public ListAssetLoaded delete(Integer listassetloadedId) throws EntityNotFoundException;

	/**
	 * Finds all listassetloadeds.
	 * 
	 * @return A list of listassetloadeds.
	 */
	public Page<ListAssetLoaded> findAll(QueryFilter[] queryFilters, Pageable pageable);
	
	public Page<ListAssetLoaded> findAll(Pageable pageable);
	
	/**
	 * Finds listassetloaded by id.
	 * 
	 * @param id
	 *            The id of the wanted listassetloaded.
	 * @return The found listassetloaded. If no listassetloaded is found, this method returns
	 *         null.
	 */
	public ListAssetLoaded findById(Integer id) throws
	 EntityNotFoundException;
	/**
	 * Updates the information of a listassetloaded.
	 * 
	 * @param updated
	 *            The information of the updated listassetloaded.
	 * @return The updated listassetloaded.
	 * @throws EntityNotFoundException
	 *             if no listassetloaded is found with given id.
	 */
	public ListAssetLoaded update(ListAssetLoaded updated) throws EntityNotFoundException;

	/**
	 * Retrieve the total count of the listassetloadeds in the repository.
	 * 
	 * @param None
	 *            .
	 * @return The count of the listassetloaded.
	 */

	public long countAll();


    public Page<ListAssetLoaded> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable);


}

