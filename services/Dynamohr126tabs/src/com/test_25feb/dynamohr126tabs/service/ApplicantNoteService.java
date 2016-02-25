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
 * Service object for domain model class ApplicantNote.
 * @see com.test_25feb.dynamohr126tabs.ApplicantNote
 */

public interface ApplicantNoteService {
   /**
	 * Creates a new applicantnote.
	 * 
	 * @param created
	 *            The information of the created applicantnote.
	 * @return The created applicantnote.
	 */
	public ApplicantNote create(ApplicantNote created);

	/**
	 * Deletes a applicantnote.
	 * 
	 * @param applicantnoteId
	 *            The id of the deleted applicantnote.
	 * @return The deleted applicantnote.
	 * @throws EntityNotFoundException
	 *             if no applicantnote is found with the given id.
	 */
	public ApplicantNote delete(Integer applicantnoteId) throws EntityNotFoundException;

	/**
	 * Finds all applicantnotes.
	 * 
	 * @return A list of applicantnotes.
	 */
	public Page<ApplicantNote> findAll(QueryFilter[] queryFilters, Pageable pageable);
	
	public Page<ApplicantNote> findAll(Pageable pageable);
	
	/**
	 * Finds applicantnote by id.
	 * 
	 * @param id
	 *            The id of the wanted applicantnote.
	 * @return The found applicantnote. If no applicantnote is found, this method returns
	 *         null.
	 */
	public ApplicantNote findById(Integer id) throws
	 EntityNotFoundException;
	/**
	 * Updates the information of a applicantnote.
	 * 
	 * @param updated
	 *            The information of the updated applicantnote.
	 * @return The updated applicantnote.
	 * @throws EntityNotFoundException
	 *             if no applicantnote is found with given id.
	 */
	public ApplicantNote update(ApplicantNote updated) throws EntityNotFoundException;

	/**
	 * Retrieve the total count of the applicantnotes in the repository.
	 * 
	 * @param None
	 *            .
	 * @return The count of the applicantnote.
	 */

	public long countAll();


    public Page<ApplicantNote> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable);


}

