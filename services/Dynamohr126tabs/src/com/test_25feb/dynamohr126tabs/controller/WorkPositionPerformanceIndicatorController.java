/*Copyright (c) 2016-2017 gmail.com All Rights Reserved.
 This software is the confidential and proprietary information of gmail.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with gmail.com*/

package com.test_25feb.dynamohr126tabs.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import com.test_25feb.dynamohr126tabs.service.AssessmentFieldService;
import com.test_25feb.dynamohr126tabs.service.WorkPositionPerformanceIndicatorService;


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
 * Controller object for domain model class WorkPositionPerformanceIndicator.
 * @see com.test_25feb.dynamohr126tabs.WorkPositionPerformanceIndicator
 */

@RestController(value = "Dynamohr126tabs.WorkPositionPerformanceIndicatorController")
@Api(value = "/Dynamohr126tabs/WorkPositionPerformanceIndicator", description = "Exposes APIs to work with WorkPositionPerformanceIndicator resource.")
@RequestMapping("/Dynamohr126tabs/WorkPositionPerformanceIndicator")
public class WorkPositionPerformanceIndicatorController {

    private static final Logger LOGGER = LoggerFactory.getLogger(WorkPositionPerformanceIndicatorController.class);

	@Autowired
	@Qualifier("Dynamohr126tabs.WorkPositionPerformanceIndicatorService")
	private WorkPositionPerformanceIndicatorService workPositionPerformanceIndicatorService;


    @Autowired
    @Qualifier("Dynamohr126tabs.AssessmentFieldService")
    private AssessmentFieldService assessmentFieldService;


	@RequestMapping(value = "/search", method = RequestMethod.POST)
	@ApiOperation(value = "Returns the list of WorkPositionPerformanceIndicator instances matching the search criteria.")
	public Page<WorkPositionPerformanceIndicator> findWorkPositionPerformanceIndicators( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
		LOGGER.debug("Rendering WorkPositionPerformanceIndicators list");
		return workPositionPerformanceIndicatorService.findAll(queryFilters, pageable);
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ApiOperation(value = "Returns the list of WorkPositionPerformanceIndicator instances.")
	public Page<WorkPositionPerformanceIndicator> getWorkPositionPerformanceIndicators(Pageable pageable) {
		LOGGER.debug("Rendering WorkPositionPerformanceIndicators list");
		return workPositionPerformanceIndicatorService.findAll(pageable);
	}

	@RequestMapping(value = "/count", method = RequestMethod.GET)
	@ApiOperation(value = "Returns the total count of WorkPositionPerformanceIndicator instances.")
	public Long countAllWorkPositionPerformanceIndicators() {
		LOGGER.debug("counting WorkPositionPerformanceIndicators");
		Long count = workPositionPerformanceIndicatorService.countAll();
		return count;
	}


    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @ApiOperation(value = "Returns the WorkPositionPerformanceIndicator instance associated with the given id.")
    public WorkPositionPerformanceIndicator getWorkPositionPerformanceIndicator(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting WorkPositionPerformanceIndicator with id: {}" , id);
        WorkPositionPerformanceIndicator instance = workPositionPerformanceIndicatorService.findById(id);
        LOGGER.debug("WorkPositionPerformanceIndicator details with id: {}" , instance);
        return instance;
    }
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @ApiOperation(value = "Deletes the WorkPositionPerformanceIndicator instance associated with the given id.")
    public boolean deleteWorkPositionPerformanceIndicator(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting WorkPositionPerformanceIndicator with id: {}" , id);
        WorkPositionPerformanceIndicator deleted = workPositionPerformanceIndicatorService.delete(id);
        return deleted != null;
    }

    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @ApiOperation(value = "Updates the WorkPositionPerformanceIndicator instance associated with the given id.")
    public WorkPositionPerformanceIndicator editWorkPositionPerformanceIndicator(@PathVariable("id") Integer id, @RequestBody WorkPositionPerformanceIndicator instance) throws EntityNotFoundException {
        LOGGER.debug("Editing WorkPositionPerformanceIndicator with id: {}" , instance.getIdWorkPositionPerformanceIndicator());
        instance.setIdWorkPositionPerformanceIndicator(id);
        instance = workPositionPerformanceIndicatorService.update(instance);
        LOGGER.debug("WorkPositionPerformanceIndicator details with id: {}" , instance);
        return instance;
    }


    @RequestMapping(value="/{id:.+}/assessmentFields", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the assessmentFields instance associated with the given id.")
     public Page<AssessmentField> findAssociatedassessmentFields(Pageable pageable, @PathVariable("id") Integer id){
        LOGGER.debug("Fetching all associated assessmentFields");
        return assessmentFieldService.findAssociatedValues(id,"workPositionPerformanceIndicator","idWorkPositionPerformanceIndicator", pageable);
   }



	@RequestMapping(value = "/", method = RequestMethod.POST)
	@ApiOperation(value = "Creates a new WorkPositionPerformanceIndicator instance.")
	public WorkPositionPerformanceIndicator createWorkPositionPerformanceIndicator(@RequestBody WorkPositionPerformanceIndicator instance) {
		LOGGER.debug("Create WorkPositionPerformanceIndicator with information: {}" , instance);
		instance = workPositionPerformanceIndicatorService.create(instance);
		LOGGER.debug("Created WorkPositionPerformanceIndicator with information: {}" , instance);
	    return instance;
	}

	/**
	 * This setter method should only be used by unit tests
	 * 
	 * @param service
	 */
	protected void setWorkPositionPerformanceIndicatorService(WorkPositionPerformanceIndicatorService service) {
		this.workPositionPerformanceIndicatorService = service;
	}
}

