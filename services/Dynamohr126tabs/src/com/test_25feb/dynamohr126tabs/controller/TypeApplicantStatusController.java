/*Copyright (c) 2016-2017 gmail.com All Rights Reserved.
 This software is the confidential and proprietary information of gmail.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with gmail.com*/

package com.test_25feb.dynamohr126tabs.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import com.test_25feb.dynamohr126tabs.service.ApplicantToPositionService;
import com.test_25feb.dynamohr126tabs.service.TypeApplicantStatusService;


import java.io.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.hibernate.TypeMismatchException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.util.WMMultipartUtils;
import com.wavemaker.runtime.util.WMRuntimeUtils;
import com.wavemaker.runtime.file.model.DownloadResponse;
import com.wordnik.swagger.annotations.*;

import com.test_25feb.dynamohr126tabs.*;
import com.test_25feb.dynamohr126tabs.service.*;


/**
 * Controller object for domain model class TypeApplicantStatus.
 * @see com.test_25feb.dynamohr126tabs.TypeApplicantStatus
 */

@RestController(value = "Dynamohr126tabs.TypeApplicantStatusController")
@Api(value = "/Dynamohr126tabs/TypeApplicantStatus", description = "Exposes APIs to work with TypeApplicantStatus resource.")
@RequestMapping("/Dynamohr126tabs/TypeApplicantStatus")
public class TypeApplicantStatusController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TypeApplicantStatusController.class);

	@Autowired
	@Qualifier("Dynamohr126tabs.TypeApplicantStatusService")
	private TypeApplicantStatusService typeApplicantStatusService;


    @Autowired
    @Qualifier("Dynamohr126tabs.ApplicantToPositionService")
    private ApplicantToPositionService applicantToPositionService;


	@RequestMapping(value = "/search", method = RequestMethod.POST)
	@ApiOperation(value = "Returns the list of TypeApplicantStatus instances matching the search criteria.")
	public Page<TypeApplicantStatus> findTypeApplicantStatuss( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
		LOGGER.debug("Rendering TypeApplicantStatuss list");
		return typeApplicantStatusService.findAll(queryFilters, pageable);
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ApiOperation(value = "Returns the list of TypeApplicantStatus instances.")
	public Page<TypeApplicantStatus> getTypeApplicantStatuss(Pageable pageable) {
		LOGGER.debug("Rendering TypeApplicantStatuss list");
		return typeApplicantStatusService.findAll(pageable);
	}

	@RequestMapping(value = "/count", method = RequestMethod.GET)
	@ApiOperation(value = "Returns the total count of TypeApplicantStatus instances.")
	public Long countAllTypeApplicantStatuss() {
		LOGGER.debug("counting TypeApplicantStatuss");
		Long count = typeApplicantStatusService.countAll();
		return count;
	}


    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @ApiOperation(value = "Returns the TypeApplicantStatus instance associated with the given id.")
    public TypeApplicantStatus getTypeApplicantStatus(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting TypeApplicantStatus with id: {}" , id);
        TypeApplicantStatus instance = typeApplicantStatusService.findById(id);
        LOGGER.debug("TypeApplicantStatus details with id: {}" , instance);
        return instance;
    }
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @ApiOperation(value = "Deletes the TypeApplicantStatus instance associated with the given id.")
    public boolean deleteTypeApplicantStatus(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting TypeApplicantStatus with id: {}" , id);
        TypeApplicantStatus deleted = typeApplicantStatusService.delete(id);
        return deleted != null;
    }

    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @ApiOperation(value = "Updates the TypeApplicantStatus instance associated with the given id.")
    public TypeApplicantStatus editTypeApplicantStatus(@PathVariable("id") Integer id, @RequestBody TypeApplicantStatus instance) throws EntityNotFoundException {
        LOGGER.debug("Editing TypeApplicantStatus with id: {}" , instance.getIdTypeMaritalStatus());
        instance.setIdTypeMaritalStatus(id);
        instance = typeApplicantStatusService.update(instance);
        LOGGER.debug("TypeApplicantStatus details with id: {}" , instance);
        return instance;
    }


    @RequestMapping(value="/{id:.+}/applicantToPositions", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the applicantToPositions instance associated with the given id.")
     public Page<ApplicantToPosition> findAssociatedapplicantToPositions(Pageable pageable, @PathVariable("id") Integer id){
        LOGGER.debug("Fetching all associated applicantToPositions");
        return applicantToPositionService.findAssociatedValues(id,"typeApplicantStatus","idTypeMaritalStatus", pageable);
   }



	@RequestMapping(value = "/", method = RequestMethod.POST)
	@ApiOperation(value = "Creates a new TypeApplicantStatus instance.")
	public TypeApplicantStatus createTypeApplicantStatus(@RequestBody TypeApplicantStatus instance) {
		LOGGER.debug("Create TypeApplicantStatus with information: {}" , instance);
		instance = typeApplicantStatusService.create(instance);
		LOGGER.debug("Created TypeApplicantStatus with information: {}" , instance);
	    return instance;
	}

	/**
	 * This setter method should only be used by unit tests
	 * 
	 * @param service
	 */
	protected void setTypeApplicantStatusService(TypeApplicantStatusService service) {
		this.typeApplicantStatusService = service;
	}
}

