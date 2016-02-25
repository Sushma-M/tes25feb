/*Copyright (c) 2016-2017 gmail.com All Rights Reserved.
 This software is the confidential and proprietary information of gmail.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with gmail.com*/

package com.test_25feb.dynamohr126tabs.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import com.test_25feb.dynamohr126tabs.service.EmployeeAssessmentService;
import com.test_25feb.dynamohr126tabs.service.ListEmployeePositionService;
import com.test_25feb.dynamohr126tabs.service.WorkPositionPerformanceIndicatorService;
import com.test_25feb.dynamohr126tabs.service.WorkPositionRequiementService;
import com.test_25feb.dynamohr126tabs.service.WorkPositionResponsibilityService;
import com.test_25feb.dynamohr126tabs.service.WorkPositionScopeService;
import com.test_25feb.dynamohr126tabs.service.WorkPositionService;
import com.test_25feb.dynamohr126tabs.service.WorkPositionVacantService;


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
 * Controller object for domain model class WorkPosition.
 * @see com.test_25feb.dynamohr126tabs.WorkPosition
 */

@RestController(value = "Dynamohr126tabs.WorkPositionController")
@Api(value = "/Dynamohr126tabs/WorkPosition", description = "Exposes APIs to work with WorkPosition resource.")
@RequestMapping("/Dynamohr126tabs/WorkPosition")
public class WorkPositionController {

    private static final Logger LOGGER = LoggerFactory.getLogger(WorkPositionController.class);

	@Autowired
	@Qualifier("Dynamohr126tabs.WorkPositionService")
	private WorkPositionService workPositionService;


    @Autowired
    @Qualifier("Dynamohr126tabs.WorkPositionResponsibilityService")
    private WorkPositionResponsibilityService workPositionResponsibilityService;


    @Autowired
    @Qualifier("Dynamohr126tabs.EmployeeAssessmentService")
    private EmployeeAssessmentService employeeAssessmentService;


    @Autowired
    @Qualifier("Dynamohr126tabs.WorkPositionVacantService")
    private WorkPositionVacantService workPositionVacantService;


    @Autowired
    @Qualifier("Dynamohr126tabs.WorkPositionPerformanceIndicatorService")
    private WorkPositionPerformanceIndicatorService workPositionPerformanceIndicatorService;


    @Autowired
    @Qualifier("Dynamohr126tabs.ListEmployeePositionService")
    private ListEmployeePositionService listEmployeePositionService;


    @Autowired
    @Qualifier("Dynamohr126tabs.WorkPositionRequiementService")
    private WorkPositionRequiementService workPositionRequiementService;


    @Autowired
    @Qualifier("Dynamohr126tabs.WorkPositionScopeService")
    private WorkPositionScopeService workPositionScopeService;


	@RequestMapping(value = "/search", method = RequestMethod.POST)
	@ApiOperation(value = "Returns the list of WorkPosition instances matching the search criteria.")
	public Page<WorkPosition> findWorkPositions( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
		LOGGER.debug("Rendering WorkPositions list");
		return workPositionService.findAll(queryFilters, pageable);
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ApiOperation(value = "Returns the list of WorkPosition instances.")
	public Page<WorkPosition> getWorkPositions(Pageable pageable) {
		LOGGER.debug("Rendering WorkPositions list");
		return workPositionService.findAll(pageable);
	}

	@RequestMapping(value = "/count", method = RequestMethod.GET)
	@ApiOperation(value = "Returns the total count of WorkPosition instances.")
	public Long countAllWorkPositions() {
		LOGGER.debug("counting WorkPositions");
		Long count = workPositionService.countAll();
		return count;
	}


    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @ApiOperation(value = "Returns the WorkPosition instance associated with the given id.")
    public WorkPosition getWorkPosition(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting WorkPosition with id: {}" , id);
        WorkPosition instance = workPositionService.findById(id);
        LOGGER.debug("WorkPosition details with id: {}" , instance);
        return instance;
    }
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @ApiOperation(value = "Deletes the WorkPosition instance associated with the given id.")
    public boolean deleteWorkPosition(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting WorkPosition with id: {}" , id);
        WorkPosition deleted = workPositionService.delete(id);
        return deleted != null;
    }

    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @ApiOperation(value = "Updates the WorkPosition instance associated with the given id.")
    public WorkPosition editWorkPosition(@PathVariable("id") Integer id, @RequestBody WorkPosition instance) throws EntityNotFoundException {
        LOGGER.debug("Editing WorkPosition with id: {}" , instance.getIdWorkPosition());
        instance.setIdWorkPosition(id);
        instance = workPositionService.update(instance);
        LOGGER.debug("WorkPosition details with id: {}" , instance);
        return instance;
    }


    @RequestMapping(value="/{id:.+}/workPositionResponsibilities", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the workPositionResponsibilities instance associated with the given id.")
     public Page<WorkPositionResponsibility> findAssociatedworkPositionResponsibilities(Pageable pageable, @PathVariable("id") Integer id){
        LOGGER.debug("Fetching all associated workPositionResponsibilities");
        return workPositionResponsibilityService.findAssociatedValues(id,"workPosition","idWorkPosition", pageable);
   }

    @RequestMapping(value="/{id:.+}/workPositionRequiements", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the workPositionRequiements instance associated with the given id.")
     public Page<WorkPositionRequiement> findAssociatedworkPositionRequiements(Pageable pageable, @PathVariable("id") Integer id){
        LOGGER.debug("Fetching all associated workPositionRequiements");
        return workPositionRequiementService.findAssociatedValues(id,"workPosition","idWorkPosition", pageable);
   }

    @RequestMapping(value="/{id:.+}/workPositionScopes", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the workPositionScopes instance associated with the given id.")
     public Page<WorkPositionScope> findAssociatedworkPositionScopes(Pageable pageable, @PathVariable("id") Integer id){
        LOGGER.debug("Fetching all associated workPositionScopes");
        return workPositionScopeService.findAssociatedValues(id,"workPosition","idWorkPosition", pageable);
   }

    @RequestMapping(value="/{id:.+}/workPositionPerformanceIndicators", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the workPositionPerformanceIndicators instance associated with the given id.")
     public Page<WorkPositionPerformanceIndicator> findAssociatedworkPositionPerformanceIndicators(Pageable pageable, @PathVariable("id") Integer id){
        LOGGER.debug("Fetching all associated workPositionPerformanceIndicators");
        return workPositionPerformanceIndicatorService.findAssociatedValues(id,"workPosition","idWorkPosition", pageable);
   }

    @RequestMapping(value="/{id:.+}/workPositionsForFkSuperiorPosition", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the workPositionsForFkSuperiorPosition instance associated with the given id.")
     public Page<WorkPosition> findAssociatedworkPositionsForFkSuperiorPosition(Pageable pageable, @PathVariable("id") Integer id){
        LOGGER.debug("Fetching all associated workPositionsForFkSuperiorPosition");
        return workPositionService.findAssociatedValues(id,"workPositionByFkSuperiorPosition","idWorkPosition", pageable);
   }

    @RequestMapping(value="/{id:.+}/listEmployeePositions", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the listEmployeePositions instance associated with the given id.")
     public Page<ListEmployeePosition> findAssociatedlistEmployeePositions(Pageable pageable, @PathVariable("id") Integer id){
        LOGGER.debug("Fetching all associated listEmployeePositions");
        return listEmployeePositionService.findAssociatedValues(id,"workPosition","idWorkPosition", pageable);
   }

    @RequestMapping(value="/{id:.+}/employeeAssessments", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the employeeAssessments instance associated with the given id.")
     public Page<EmployeeAssessment> findAssociatedemployeeAssessments(Pageable pageable, @PathVariable("id") Integer id){
        LOGGER.debug("Fetching all associated employeeAssessments");
        return employeeAssessmentService.findAssociatedValues(id,"workPosition","idWorkPosition", pageable);
   }

    @RequestMapping(value="/{id:.+}/workPositionVacants", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the workPositionVacants instance associated with the given id.")
     public Page<WorkPositionVacant> findAssociatedworkPositionVacants(Pageable pageable, @PathVariable("id") Integer id){
        LOGGER.debug("Fetching all associated workPositionVacants");
        return workPositionVacantService.findAssociatedValues(id,"workPosition","idWorkPosition", pageable);
   }



	@RequestMapping(value = "/", method = RequestMethod.POST)
	@ApiOperation(value = "Creates a new WorkPosition instance.")
	public WorkPosition createWorkPosition(@RequestBody WorkPosition instance) {
		LOGGER.debug("Create WorkPosition with information: {}" , instance);
		instance = workPositionService.create(instance);
		LOGGER.debug("Created WorkPosition with information: {}" , instance);
	    return instance;
	}

	/**
	 * This setter method should only be used by unit tests
	 * 
	 * @param service
	 */
	protected void setWorkPositionService(WorkPositionService service) {
		this.workPositionService = service;
	}
}
