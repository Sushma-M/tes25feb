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
 * Service object for domain model class TypeAsset.
 * @see com.test_25feb.dynamohr126tabs.TypeAsset
 */

public interface TypeAssetService {
   /**
	 * Creates a new typeasset.
	 * 
	 * @param created
	 *            The information of the created typeasset.
	 * @return The created typeasset.
	 */
	public TypeAsset create(TypeAsset created);

	/**
	 * Deletes a typeasset.
	 * 
	 * @param typeassetId
	 *            The id of the deleted typeasset.
	 * @return The deleted typeasset.
	 * @throws EntityNotFoundException
	 *             if no typeasset is found with the given id.
	 */
	public TypeAsset delete(Integer typeassetId) throws EntityNotFoundException;

	/**
	 * Finds all typeassets.
	 * 
	 * @return A list of typeassets.
	 */
	public Page<TypeAsset> findAll(QueryFilter[] queryFilters, Pageable pageable);
	
	public Page<TypeAsset> findAll(Pageable pageable);
	
	/**
	 * Finds typeasset by id.
	 * 
	 * @param id
	 *            The id of the wanted typeasset.
	 * @return The found typeasset. If no typeasset is found, this method returns
	 *         null.
	 */
	public TypeAsset findById(Integer id) throws
	 EntityNotFoundException;
	/**
	 * Updates the information of a typeasset.
	 * 
	 * @param updated
	 *            The information of the updated typeasset.
	 * @return The updated typeasset.
	 * @throws EntityNotFoundException
	 *             if no typeasset is found with given id.
	 */
	public TypeAsset update(TypeAsset updated) throws EntityNotFoundException;

	/**
	 * Retrieve the total count of the typeassets in the repository.
	 * 
	 * @param None
	 *            .
	 * @return The count of the typeasset.
	 */

	public long countAll();


    public Page<TypeAsset> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable);


}
