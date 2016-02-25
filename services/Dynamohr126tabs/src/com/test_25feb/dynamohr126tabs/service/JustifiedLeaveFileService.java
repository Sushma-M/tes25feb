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
 * Service object for domain model class JustifiedLeaveFile.
 * @see com.test_25feb.dynamohr126tabs.JustifiedLeaveFile
 */

public interface JustifiedLeaveFileService {
   /**
	 * Creates a new justifiedleavefile.
	 * 
	 * @param created
	 *            The information of the created justifiedleavefile.
	 * @return The created justifiedleavefile.
	 */
	public JustifiedLeaveFile create(JustifiedLeaveFile created);

	/**
	 * Deletes a justifiedleavefile.
	 * 
	 * @param justifiedleavefileId
	 *            The id of the deleted justifiedleavefile.
	 * @return The deleted justifiedleavefile.
	 * @throws EntityNotFoundException
	 *             if no justifiedleavefile is found with the given id.
	 */
	public JustifiedLeaveFile delete(Integer justifiedleavefileId) throws EntityNotFoundException;

	/**
	 * Finds all justifiedleavefiles.
	 * 
	 * @return A list of justifiedleavefiles.
	 */
	public Page<JustifiedLeaveFile> findAll(QueryFilter[] queryFilters, Pageable pageable);
	
	public Page<JustifiedLeaveFile> findAll(Pageable pageable);
	
	/**
	 * Finds justifiedleavefile by id.
	 * 
	 * @param id
	 *            The id of the wanted justifiedleavefile.
	 * @return The found justifiedleavefile. If no justifiedleavefile is found, this method returns
	 *         null.
	 */
	public JustifiedLeaveFile findById(Integer id) throws
	 EntityNotFoundException;
	/**
	 * Updates the information of a justifiedleavefile.
	 * 
	 * @param updated
	 *            The information of the updated justifiedleavefile.
	 * @return The updated justifiedleavefile.
	 * @throws EntityNotFoundException
	 *             if no justifiedleavefile is found with given id.
	 */
	public JustifiedLeaveFile update(JustifiedLeaveFile updated) throws EntityNotFoundException;

	/**
	 * Retrieve the total count of the justifiedleavefiles in the repository.
	 * 
	 * @param None
	 *            .
	 * @return The count of the justifiedleavefile.
	 */

	public long countAll();


    public Page<JustifiedLeaveFile> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable);


}
