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
 * Service object for domain model class Alert.
 * @see com.test_25feb.dynamohr126tabs.Alert
 */

public interface AlertService {
   /**
	 * Creates a new alert.
	 * 
	 * @param created
	 *            The information of the created alert.
	 * @return The created alert.
	 */
	public Alert create(Alert created);

	/**
	 * Deletes a alert.
	 * 
	 * @param alertId
	 *            The id of the deleted alert.
	 * @return The deleted alert.
	 * @throws EntityNotFoundException
	 *             if no alert is found with the given id.
	 */
	public Alert delete(Integer alertId) throws EntityNotFoundException;

	/**
	 * Finds all alerts.
	 * 
	 * @return A list of alerts.
	 */
	public Page<Alert> findAll(QueryFilter[] queryFilters, Pageable pageable);
	
	public Page<Alert> findAll(Pageable pageable);
	
	/**
	 * Finds alert by id.
	 * 
	 * @param id
	 *            The id of the wanted alert.
	 * @return The found alert. If no alert is found, this method returns
	 *         null.
	 */
	public Alert findById(Integer id) throws
	 EntityNotFoundException;
	/**
	 * Updates the information of a alert.
	 * 
	 * @param updated
	 *            The information of the updated alert.
	 * @return The updated alert.
	 * @throws EntityNotFoundException
	 *             if no alert is found with given id.
	 */
	public Alert update(Alert updated) throws EntityNotFoundException;

	/**
	 * Retrieve the total count of the alerts in the repository.
	 * 
	 * @param None
	 *            .
	 * @return The count of the alert.
	 */

	public long countAll();


    public Page<Alert> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable);


}

