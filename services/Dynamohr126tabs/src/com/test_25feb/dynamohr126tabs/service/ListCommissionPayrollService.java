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
 * Service object for domain model class ListCommissionPayroll.
 * @see com.test_25feb.dynamohr126tabs.ListCommissionPayroll
 */

public interface ListCommissionPayrollService {
   /**
	 * Creates a new listcommissionpayroll.
	 * 
	 * @param created
	 *            The information of the created listcommissionpayroll.
	 * @return The created listcommissionpayroll.
	 */
	public ListCommissionPayroll create(ListCommissionPayroll created);

	/**
	 * Deletes a listcommissionpayroll.
	 * 
	 * @param listcommissionpayrollId
	 *            The id of the deleted listcommissionpayroll.
	 * @return The deleted listcommissionpayroll.
	 * @throws EntityNotFoundException
	 *             if no listcommissionpayroll is found with the given id.
	 */
	public ListCommissionPayroll delete(Integer listcommissionpayrollId) throws EntityNotFoundException;

	/**
	 * Finds all listcommissionpayrolls.
	 * 
	 * @return A list of listcommissionpayrolls.
	 */
	public Page<ListCommissionPayroll> findAll(QueryFilter[] queryFilters, Pageable pageable);
	
	public Page<ListCommissionPayroll> findAll(Pageable pageable);
	
	/**
	 * Finds listcommissionpayroll by id.
	 * 
	 * @param id
	 *            The id of the wanted listcommissionpayroll.
	 * @return The found listcommissionpayroll. If no listcommissionpayroll is found, this method returns
	 *         null.
	 */
	public ListCommissionPayroll findById(Integer id) throws
	 EntityNotFoundException;
	/**
	 * Updates the information of a listcommissionpayroll.
	 * 
	 * @param updated
	 *            The information of the updated listcommissionpayroll.
	 * @return The updated listcommissionpayroll.
	 * @throws EntityNotFoundException
	 *             if no listcommissionpayroll is found with given id.
	 */
	public ListCommissionPayroll update(ListCommissionPayroll updated) throws EntityNotFoundException;

	/**
	 * Retrieve the total count of the listcommissionpayrolls in the repository.
	 * 
	 * @param None
	 *            .
	 * @return The count of the listcommissionpayroll.
	 */

	public long countAll();


    public Page<ListCommissionPayroll> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable);


}
