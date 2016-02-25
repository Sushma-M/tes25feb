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
 * Service object for domain model class Conf.
 * @see com.test_25feb.dynamohr126tabs.Conf
 */

public interface ConfService {
   /**
	 * Creates a new conf.
	 * 
	 * @param created
	 *            The information of the created conf.
	 * @return The created conf.
	 */
	public Conf create(Conf created);

	/**
	 * Deletes a conf.
	 * 
	 * @param confId
	 *            The id of the deleted conf.
	 * @return The deleted conf.
	 * @throws EntityNotFoundException
	 *             if no conf is found with the given id.
	 */
	public Conf delete(Integer confId) throws EntityNotFoundException;

	/**
	 * Finds all confs.
	 * 
	 * @return A list of confs.
	 */
	public Page<Conf> findAll(QueryFilter[] queryFilters, Pageable pageable);
	
	public Page<Conf> findAll(Pageable pageable);
	
	/**
	 * Finds conf by id.
	 * 
	 * @param id
	 *            The id of the wanted conf.
	 * @return The found conf. If no conf is found, this method returns
	 *         null.
	 */
	public Conf findById(Integer id) throws
	 EntityNotFoundException;
	/**
	 * Updates the information of a conf.
	 * 
	 * @param updated
	 *            The information of the updated conf.
	 * @return The updated conf.
	 * @throws EntityNotFoundException
	 *             if no conf is found with given id.
	 */
	public Conf update(Conf updated) throws EntityNotFoundException;

	/**
	 * Retrieve the total count of the confs in the repository.
	 * 
	 * @param None
	 *            .
	 * @return The count of the conf.
	 */

	public long countAll();


    public Page<Conf> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable);


}
