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
 * Service object for domain model class PaymentLoanManual.
 * @see com.test_25feb.dynamohr126tabs.PaymentLoanManual
 */

public interface PaymentLoanManualService {
   /**
	 * Creates a new paymentloanmanual.
	 * 
	 * @param created
	 *            The information of the created paymentloanmanual.
	 * @return The created paymentloanmanual.
	 */
	public PaymentLoanManual create(PaymentLoanManual created);

	/**
	 * Deletes a paymentloanmanual.
	 * 
	 * @param paymentloanmanualId
	 *            The id of the deleted paymentloanmanual.
	 * @return The deleted paymentloanmanual.
	 * @throws EntityNotFoundException
	 *             if no paymentloanmanual is found with the given id.
	 */
	public PaymentLoanManual delete(Integer paymentloanmanualId) throws EntityNotFoundException;

	/**
	 * Finds all paymentloanmanuals.
	 * 
	 * @return A list of paymentloanmanuals.
	 */
	public Page<PaymentLoanManual> findAll(QueryFilter[] queryFilters, Pageable pageable);
	
	public Page<PaymentLoanManual> findAll(Pageable pageable);
	
	/**
	 * Finds paymentloanmanual by id.
	 * 
	 * @param id
	 *            The id of the wanted paymentloanmanual.
	 * @return The found paymentloanmanual. If no paymentloanmanual is found, this method returns
	 *         null.
	 */
	public PaymentLoanManual findById(Integer id) throws
	 EntityNotFoundException;
	/**
	 * Updates the information of a paymentloanmanual.
	 * 
	 * @param updated
	 *            The information of the updated paymentloanmanual.
	 * @return The updated paymentloanmanual.
	 * @throws EntityNotFoundException
	 *             if no paymentloanmanual is found with given id.
	 */
	public PaymentLoanManual update(PaymentLoanManual updated) throws EntityNotFoundException;

	/**
	 * Retrieve the total count of the paymentloanmanuals in the repository.
	 * 
	 * @param None
	 *            .
	 * @return The count of the paymentloanmanual.
	 */

	public long countAll();


    public Page<PaymentLoanManual> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable);


}
