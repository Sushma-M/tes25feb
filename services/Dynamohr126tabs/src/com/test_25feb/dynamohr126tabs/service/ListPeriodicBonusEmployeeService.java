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
 * Service object for domain model class ListPeriodicBonusEmployee.
 * @see com.test_25feb.dynamohr126tabs.ListPeriodicBonusEmployee
 */

public interface ListPeriodicBonusEmployeeService {
   /**
	 * Creates a new listperiodicbonusemployee.
	 * 
	 * @param created
	 *            The information of the created listperiodicbonusemployee.
	 * @return The created listperiodicbonusemployee.
	 */
	public ListPeriodicBonusEmployee create(ListPeriodicBonusEmployee created);

	/**
	 * Deletes a listperiodicbonusemployee.
	 * 
	 * @param listperiodicbonusemployeeId
	 *            The id of the deleted listperiodicbonusemployee.
	 * @return The deleted listperiodicbonusemployee.
	 * @throws EntityNotFoundException
	 *             if no listperiodicbonusemployee is found with the given id.
	 */
	public ListPeriodicBonusEmployee delete(Integer listperiodicbonusemployeeId) throws EntityNotFoundException;

	/**
	 * Finds all listperiodicbonusemployees.
	 * 
	 * @return A list of listperiodicbonusemployees.
	 */
	public Page<ListPeriodicBonusEmployee> findAll(QueryFilter[] queryFilters, Pageable pageable);
	
	public Page<ListPeriodicBonusEmployee> findAll(Pageable pageable);
	
	/**
	 * Finds listperiodicbonusemployee by id.
	 * 
	 * @param id
	 *            The id of the wanted listperiodicbonusemployee.
	 * @return The found listperiodicbonusemployee. If no listperiodicbonusemployee is found, this method returns
	 *         null.
	 */
	public ListPeriodicBonusEmployee findById(Integer id) throws
	 EntityNotFoundException;
	/**
	 * Updates the information of a listperiodicbonusemployee.
	 * 
	 * @param updated
	 *            The information of the updated listperiodicbonusemployee.
	 * @return The updated listperiodicbonusemployee.
	 * @throws EntityNotFoundException
	 *             if no listperiodicbonusemployee is found with given id.
	 */
	public ListPeriodicBonusEmployee update(ListPeriodicBonusEmployee updated) throws EntityNotFoundException;

	/**
	 * Retrieve the total count of the listperiodicbonusemployees in the repository.
	 * 
	 * @param None
	 *            .
	 * @return The count of the listperiodicbonusemployee.
	 */

	public long countAll();


    public Page<ListPeriodicBonusEmployee> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable);


}
