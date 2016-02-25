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
 * Service object for domain model class ApplicantAppointment.
 * @see com.test_25feb.dynamohr126tabs.ApplicantAppointment
 */

public interface ApplicantAppointmentService {
   /**
	 * Creates a new applicantappointment.
	 * 
	 * @param created
	 *            The information of the created applicantappointment.
	 * @return The created applicantappointment.
	 */
	public ApplicantAppointment create(ApplicantAppointment created);

	/**
	 * Deletes a applicantappointment.
	 * 
	 * @param applicantappointmentId
	 *            The id of the deleted applicantappointment.
	 * @return The deleted applicantappointment.
	 * @throws EntityNotFoundException
	 *             if no applicantappointment is found with the given id.
	 */
	public ApplicantAppointment delete(Integer applicantappointmentId) throws EntityNotFoundException;

	/**
	 * Finds all applicantappointments.
	 * 
	 * @return A list of applicantappointments.
	 */
	public Page<ApplicantAppointment> findAll(QueryFilter[] queryFilters, Pageable pageable);
	
	public Page<ApplicantAppointment> findAll(Pageable pageable);
	
	/**
	 * Finds applicantappointment by id.
	 * 
	 * @param id
	 *            The id of the wanted applicantappointment.
	 * @return The found applicantappointment. If no applicantappointment is found, this method returns
	 *         null.
	 */
	public ApplicantAppointment findById(Integer id) throws
	 EntityNotFoundException;
	/**
	 * Updates the information of a applicantappointment.
	 * 
	 * @param updated
	 *            The information of the updated applicantappointment.
	 * @return The updated applicantappointment.
	 * @throws EntityNotFoundException
	 *             if no applicantappointment is found with given id.
	 */
	public ApplicantAppointment update(ApplicantAppointment updated) throws EntityNotFoundException;

	/**
	 * Retrieve the total count of the applicantappointments in the repository.
	 * 
	 * @param None
	 *            .
	 * @return The count of the applicantappointment.
	 */

	public long countAll();


    public Page<ApplicantAppointment> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable);


}
