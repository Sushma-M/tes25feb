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
 * Service object for domain model class TypeGenerationForm.
 * @see com.test_25feb.dynamohr126tabs.TypeGenerationForm
 */

public interface TypeGenerationFormService {
   /**
	 * Creates a new typegenerationform.
	 * 
	 * @param created
	 *            The information of the created typegenerationform.
	 * @return The created typegenerationform.
	 */
	public TypeGenerationForm create(TypeGenerationForm created);

	/**
	 * Deletes a typegenerationform.
	 * 
	 * @param typegenerationformId
	 *            The id of the deleted typegenerationform.
	 * @return The deleted typegenerationform.
	 * @throws EntityNotFoundException
	 *             if no typegenerationform is found with the given id.
	 */
	public TypeGenerationForm delete(Integer typegenerationformId) throws EntityNotFoundException;

	/**
	 * Finds all typegenerationforms.
	 * 
	 * @return A list of typegenerationforms.
	 */
	public Page<TypeGenerationForm> findAll(QueryFilter[] queryFilters, Pageable pageable);
	
	public Page<TypeGenerationForm> findAll(Pageable pageable);
	
	/**
	 * Finds typegenerationform by id.
	 * 
	 * @param id
	 *            The id of the wanted typegenerationform.
	 * @return The found typegenerationform. If no typegenerationform is found, this method returns
	 *         null.
	 */
	public TypeGenerationForm findById(Integer id) throws
	 EntityNotFoundException;
	/**
	 * Updates the information of a typegenerationform.
	 * 
	 * @param updated
	 *            The information of the updated typegenerationform.
	 * @return The updated typegenerationform.
	 * @throws EntityNotFoundException
	 *             if no typegenerationform is found with given id.
	 */
	public TypeGenerationForm update(TypeGenerationForm updated) throws EntityNotFoundException;

	/**
	 * Retrieve the total count of the typegenerationforms in the repository.
	 * 
	 * @param None
	 *            .
	 * @return The count of the typegenerationform.
	 */

	public long countAll();


    public Page<TypeGenerationForm> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable);


}
