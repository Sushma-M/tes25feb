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
 * Service object for domain model class ApplicantFile.
 * @see com.test_25feb.dynamohr126tabs.ApplicantFile
 */

public interface ApplicantFileService {
   /**
	 * Creates a new applicantfile.
	 * 
	 * @param created
	 *            The information of the created applicantfile.
	 * @return The created applicantfile.
	 */
	public ApplicantFile create(ApplicantFile created);

	/**
	 * Deletes a applicantfile.
	 * 
	 * @param applicantfileId
	 *            The id of the deleted applicantfile.
	 * @return The deleted applicantfile.
	 * @throws EntityNotFoundException
	 *             if no applicantfile is found with the given id.
	 */
	public ApplicantFile delete(Integer applicantfileId) throws EntityNotFoundException;

	/**
	 * Finds all applicantfiles.
	 * 
	 * @return A list of applicantfiles.
	 */
	public Page<ApplicantFile> findAll(QueryFilter[] queryFilters, Pageable pageable);
	
	public Page<ApplicantFile> findAll(Pageable pageable);
	
	/**
	 * Finds applicantfile by id.
	 * 
	 * @param id
	 *            The id of the wanted applicantfile.
	 * @return The found applicantfile. If no applicantfile is found, this method returns
	 *         null.
	 */
	public ApplicantFile findById(Integer id) throws
	 EntityNotFoundException;
	/**
	 * Updates the information of a applicantfile.
	 * 
	 * @param updated
	 *            The information of the updated applicantfile.
	 * @return The updated applicantfile.
	 * @throws EntityNotFoundException
	 *             if no applicantfile is found with given id.
	 */
	public ApplicantFile update(ApplicantFile updated) throws EntityNotFoundException;

	/**
	 * Retrieve the total count of the applicantfiles in the repository.
	 * 
	 * @param None
	 *            .
	 * @return The count of the applicantfile.
	 */

	public long countAll();


    public Page<ApplicantFile> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable);


}
