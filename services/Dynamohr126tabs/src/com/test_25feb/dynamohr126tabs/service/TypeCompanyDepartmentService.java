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
 * Service object for domain model class TypeCompanyDepartment.
 * @see com.test_25feb.dynamohr126tabs.TypeCompanyDepartment
 */

public interface TypeCompanyDepartmentService {
   /**
	 * Creates a new typecompanydepartment.
	 * 
	 * @param created
	 *            The information of the created typecompanydepartment.
	 * @return The created typecompanydepartment.
	 */
	public TypeCompanyDepartment create(TypeCompanyDepartment created);

	/**
	 * Deletes a typecompanydepartment.
	 * 
	 * @param typecompanydepartmentId
	 *            The id of the deleted typecompanydepartment.
	 * @return The deleted typecompanydepartment.
	 * @throws EntityNotFoundException
	 *             if no typecompanydepartment is found with the given id.
	 */
	public TypeCompanyDepartment delete(Integer typecompanydepartmentId) throws EntityNotFoundException;

	/**
	 * Finds all typecompanydepartments.
	 * 
	 * @return A list of typecompanydepartments.
	 */
	public Page<TypeCompanyDepartment> findAll(QueryFilter[] queryFilters, Pageable pageable);
	
	public Page<TypeCompanyDepartment> findAll(Pageable pageable);
	
	/**
	 * Finds typecompanydepartment by id.
	 * 
	 * @param id
	 *            The id of the wanted typecompanydepartment.
	 * @return The found typecompanydepartment. If no typecompanydepartment is found, this method returns
	 *         null.
	 */
	public TypeCompanyDepartment findById(Integer id) throws
	 EntityNotFoundException;
	/**
	 * Updates the information of a typecompanydepartment.
	 * 
	 * @param updated
	 *            The information of the updated typecompanydepartment.
	 * @return The updated typecompanydepartment.
	 * @throws EntityNotFoundException
	 *             if no typecompanydepartment is found with given id.
	 */
	public TypeCompanyDepartment update(TypeCompanyDepartment updated) throws EntityNotFoundException;

	/**
	 * Retrieve the total count of the typecompanydepartments in the repository.
	 * 
	 * @param None
	 *            .
	 * @return The count of the typecompanydepartment.
	 */

	public long countAll();


    public Page<TypeCompanyDepartment> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable);


}

