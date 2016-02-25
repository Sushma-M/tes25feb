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
 * Service object for domain model class ListRolePermission.
 * @see com.test_25feb.dynamohr126tabs.ListRolePermission
 */

public interface ListRolePermissionService {
   /**
	 * Creates a new listrolepermission.
	 * 
	 * @param created
	 *            The information of the created listrolepermission.
	 * @return The created listrolepermission.
	 */
	public ListRolePermission create(ListRolePermission created);

	/**
	 * Deletes a listrolepermission.
	 * 
	 * @param listrolepermissionId
	 *            The id of the deleted listrolepermission.
	 * @return The deleted listrolepermission.
	 * @throws EntityNotFoundException
	 *             if no listrolepermission is found with the given id.
	 */
	public ListRolePermission delete(Integer listrolepermissionId) throws EntityNotFoundException;

	/**
	 * Finds all listrolepermissions.
	 * 
	 * @return A list of listrolepermissions.
	 */
	public Page<ListRolePermission> findAll(QueryFilter[] queryFilters, Pageable pageable);
	
	public Page<ListRolePermission> findAll(Pageable pageable);
	
	/**
	 * Finds listrolepermission by id.
	 * 
	 * @param id
	 *            The id of the wanted listrolepermission.
	 * @return The found listrolepermission. If no listrolepermission is found, this method returns
	 *         null.
	 */
	public ListRolePermission findById(Integer id) throws
	 EntityNotFoundException;
	/**
	 * Updates the information of a listrolepermission.
	 * 
	 * @param updated
	 *            The information of the updated listrolepermission.
	 * @return The updated listrolepermission.
	 * @throws EntityNotFoundException
	 *             if no listrolepermission is found with given id.
	 */
	public ListRolePermission update(ListRolePermission updated) throws EntityNotFoundException;

	/**
	 * Retrieve the total count of the listrolepermissions in the repository.
	 * 
	 * @param None
	 *            .
	 * @return The count of the listrolepermission.
	 */

	public long countAll();


    public Page<ListRolePermission> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable);


}

