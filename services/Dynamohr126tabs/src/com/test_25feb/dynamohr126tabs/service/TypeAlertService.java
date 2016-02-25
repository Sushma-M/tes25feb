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
 * Service object for domain model class TypeAlert.
 * @see com.test_25feb.dynamohr126tabs.TypeAlert
 */

public interface TypeAlertService {
   /**
	 * Creates a new typealert.
	 * 
	 * @param created
	 *            The information of the created typealert.
	 * @return The created typealert.
	 */
	public TypeAlert create(TypeAlert created);

	/**
	 * Deletes a typealert.
	 * 
	 * @param typealertId
	 *            The id of the deleted typealert.
	 * @return The deleted typealert.
	 * @throws EntityNotFoundException
	 *             if no typealert is found with the given id.
	 */
	public TypeAlert delete(Integer typealertId) throws EntityNotFoundException;

	/**
	 * Finds all typealerts.
	 * 
	 * @return A list of typealerts.
	 */
	public Page<TypeAlert> findAll(QueryFilter[] queryFilters, Pageable pageable);
	
	public Page<TypeAlert> findAll(Pageable pageable);
	
	/**
	 * Finds typealert by id.
	 * 
	 * @param id
	 *            The id of the wanted typealert.
	 * @return The found typealert. If no typealert is found, this method returns
	 *         null.
	 */
	public TypeAlert findById(Integer id) throws
	 EntityNotFoundException;
	/**
	 * Updates the information of a typealert.
	 * 
	 * @param updated
	 *            The information of the updated typealert.
	 * @return The updated typealert.
	 * @throws EntityNotFoundException
	 *             if no typealert is found with given id.
	 */
	public TypeAlert update(TypeAlert updated) throws EntityNotFoundException;

	/**
	 * Retrieve the total count of the typealerts in the repository.
	 * 
	 * @param None
	 *            .
	 * @return The count of the typealert.
	 */

	public long countAll();


    public Page<TypeAlert> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable);


}

