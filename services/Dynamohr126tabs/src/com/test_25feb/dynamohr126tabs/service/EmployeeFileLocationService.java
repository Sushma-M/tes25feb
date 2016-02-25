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
 * Service object for domain model class EmployeeFileLocation.
 * @see com.test_25feb.dynamohr126tabs.EmployeeFileLocation
 */

public interface EmployeeFileLocationService {
   /**
	 * Creates a new employeefilelocation.
	 * 
	 * @param created
	 *            The information of the created employeefilelocation.
	 * @return The created employeefilelocation.
	 */
	public EmployeeFileLocation create(EmployeeFileLocation created);

	/**
	 * Deletes a employeefilelocation.
	 * 
	 * @param employeefilelocationId
	 *            The id of the deleted employeefilelocation.
	 * @return The deleted employeefilelocation.
	 * @throws EntityNotFoundException
	 *             if no employeefilelocation is found with the given id.
	 */
	public EmployeeFileLocation delete(Integer employeefilelocationId) throws EntityNotFoundException;

	/**
	 * Finds all employeefilelocations.
	 * 
	 * @return A list of employeefilelocations.
	 */
	public Page<EmployeeFileLocation> findAll(QueryFilter[] queryFilters, Pageable pageable);
	
	public Page<EmployeeFileLocation> findAll(Pageable pageable);
	
	/**
	 * Finds employeefilelocation by id.
	 * 
	 * @param id
	 *            The id of the wanted employeefilelocation.
	 * @return The found employeefilelocation. If no employeefilelocation is found, this method returns
	 *         null.
	 */
	public EmployeeFileLocation findById(Integer id) throws
	 EntityNotFoundException;
	/**
	 * Updates the information of a employeefilelocation.
	 * 
	 * @param updated
	 *            The information of the updated employeefilelocation.
	 * @return The updated employeefilelocation.
	 * @throws EntityNotFoundException
	 *             if no employeefilelocation is found with given id.
	 */
	public EmployeeFileLocation update(EmployeeFileLocation updated) throws EntityNotFoundException;

	/**
	 * Retrieve the total count of the employeefilelocations in the repository.
	 * 
	 * @param None
	 *            .
	 * @return The count of the employeefilelocation.
	 */

	public long countAll();


    public Page<EmployeeFileLocation> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable);


}

