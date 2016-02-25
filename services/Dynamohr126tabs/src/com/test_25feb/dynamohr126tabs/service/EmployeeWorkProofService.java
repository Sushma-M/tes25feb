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
 * Service object for domain model class EmployeeWorkProof.
 * @see com.test_25feb.dynamohr126tabs.EmployeeWorkProof
 */

public interface EmployeeWorkProofService {
   /**
	 * Creates a new employeeworkproof.
	 * 
	 * @param created
	 *            The information of the created employeeworkproof.
	 * @return The created employeeworkproof.
	 */
	public EmployeeWorkProof create(EmployeeWorkProof created);

	/**
	 * Deletes a employeeworkproof.
	 * 
	 * @param employeeworkproofId
	 *            The id of the deleted employeeworkproof.
	 * @return The deleted employeeworkproof.
	 * @throws EntityNotFoundException
	 *             if no employeeworkproof is found with the given id.
	 */
	public EmployeeWorkProof delete(Integer employeeworkproofId) throws EntityNotFoundException;

	/**
	 * Finds all employeeworkproofs.
	 * 
	 * @return A list of employeeworkproofs.
	 */
	public Page<EmployeeWorkProof> findAll(QueryFilter[] queryFilters, Pageable pageable);
	
	public Page<EmployeeWorkProof> findAll(Pageable pageable);
	
	/**
	 * Finds employeeworkproof by id.
	 * 
	 * @param id
	 *            The id of the wanted employeeworkproof.
	 * @return The found employeeworkproof. If no employeeworkproof is found, this method returns
	 *         null.
	 */
	public EmployeeWorkProof findById(Integer id) throws
	 EntityNotFoundException;
	/**
	 * Updates the information of a employeeworkproof.
	 * 
	 * @param updated
	 *            The information of the updated employeeworkproof.
	 * @return The updated employeeworkproof.
	 * @throws EntityNotFoundException
	 *             if no employeeworkproof is found with given id.
	 */
	public EmployeeWorkProof update(EmployeeWorkProof updated) throws EntityNotFoundException;

	/**
	 * Retrieve the total count of the employeeworkproofs in the repository.
	 * 
	 * @param None
	 *            .
	 * @return The count of the employeeworkproof.
	 */

	public long countAll();


    public Page<EmployeeWorkProof> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable);


}
