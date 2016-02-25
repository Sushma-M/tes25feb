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
 * Service object for domain model class AssessmentField.
 * @see com.test_25feb.dynamohr126tabs.AssessmentField
 */

public interface AssessmentFieldService {
   /**
	 * Creates a new assessmentfield.
	 * 
	 * @param created
	 *            The information of the created assessmentfield.
	 * @return The created assessmentfield.
	 */
	public AssessmentField create(AssessmentField created);

	/**
	 * Deletes a assessmentfield.
	 * 
	 * @param assessmentfieldId
	 *            The id of the deleted assessmentfield.
	 * @return The deleted assessmentfield.
	 * @throws EntityNotFoundException
	 *             if no assessmentfield is found with the given id.
	 */
	public AssessmentField delete(Integer assessmentfieldId) throws EntityNotFoundException;

	/**
	 * Finds all assessmentfields.
	 * 
	 * @return A list of assessmentfields.
	 */
	public Page<AssessmentField> findAll(QueryFilter[] queryFilters, Pageable pageable);
	
	public Page<AssessmentField> findAll(Pageable pageable);
	
	/**
	 * Finds assessmentfield by id.
	 * 
	 * @param id
	 *            The id of the wanted assessmentfield.
	 * @return The found assessmentfield. If no assessmentfield is found, this method returns
	 *         null.
	 */
	public AssessmentField findById(Integer id) throws
	 EntityNotFoundException;
	/**
	 * Updates the information of a assessmentfield.
	 * 
	 * @param updated
	 *            The information of the updated assessmentfield.
	 * @return The updated assessmentfield.
	 * @throws EntityNotFoundException
	 *             if no assessmentfield is found with given id.
	 */
	public AssessmentField update(AssessmentField updated) throws EntityNotFoundException;

	/**
	 * Retrieve the total count of the assessmentfields in the repository.
	 * 
	 * @param None
	 *            .
	 * @return The count of the assessmentfield.
	 */

	public long countAll();


    public Page<AssessmentField> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable);


}
