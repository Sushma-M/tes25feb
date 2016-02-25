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
 * Service object for domain model class TypeMaritalStatus.
 * @see com.test_25feb.dynamohr126tabs.TypeMaritalStatus
 */

public interface TypeMaritalStatusService {
   /**
	 * Creates a new typemaritalstatus.
	 * 
	 * @param created
	 *            The information of the created typemaritalstatus.
	 * @return The created typemaritalstatus.
	 */
	public TypeMaritalStatus create(TypeMaritalStatus created);

	/**
	 * Deletes a typemaritalstatus.
	 * 
	 * @param typemaritalstatusId
	 *            The id of the deleted typemaritalstatus.
	 * @return The deleted typemaritalstatus.
	 * @throws EntityNotFoundException
	 *             if no typemaritalstatus is found with the given id.
	 */
	public TypeMaritalStatus delete(Integer typemaritalstatusId) throws EntityNotFoundException;

	/**
	 * Finds all typemaritalstatuss.
	 * 
	 * @return A list of typemaritalstatuss.
	 */
	public Page<TypeMaritalStatus> findAll(QueryFilter[] queryFilters, Pageable pageable);
	
	public Page<TypeMaritalStatus> findAll(Pageable pageable);
	
	/**
	 * Finds typemaritalstatus by id.
	 * 
	 * @param id
	 *            The id of the wanted typemaritalstatus.
	 * @return The found typemaritalstatus. If no typemaritalstatus is found, this method returns
	 *         null.
	 */
	public TypeMaritalStatus findById(Integer id) throws
	 EntityNotFoundException;
	/**
	 * Updates the information of a typemaritalstatus.
	 * 
	 * @param updated
	 *            The information of the updated typemaritalstatus.
	 * @return The updated typemaritalstatus.
	 * @throws EntityNotFoundException
	 *             if no typemaritalstatus is found with given id.
	 */
	public TypeMaritalStatus update(TypeMaritalStatus updated) throws EntityNotFoundException;

	/**
	 * Retrieve the total count of the typemaritalstatuss in the repository.
	 * 
	 * @param None
	 *            .
	 * @return The count of the typemaritalstatus.
	 */

	public long countAll();


    public Page<TypeMaritalStatus> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable);


}

