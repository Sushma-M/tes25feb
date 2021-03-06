/*Copyright (c) 2016-2017 gmail.com All Rights Reserved.
 This software is the confidential and proprietary information of gmail.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with gmail.com*/

package com.test_25feb.dynamohr126tabs.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import com.test_25feb.dynamohr126tabs.service.LogOperationService;
import com.test_25feb.dynamohr126tabs.service.LogService;


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
 * Controller object for domain model class LogOperation.
 * @see com.test_25feb.dynamohr126tabs.LogOperation
 */

@RestController(value = "Dynamohr126tabs.LogOperationController")
@Api(value = "/Dynamohr126tabs/LogOperation", description = "Exposes APIs to work with LogOperation resource.")
@RequestMapping("/Dynamohr126tabs/LogOperation")
public class LogOperationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LogOperationController.class);

	@Autowired
	@Qualifier("Dynamohr126tabs.LogOperationService")
	private LogOperationService logOperationService;


    @Autowired
    @Qualifier("Dynamohr126tabs.LogService")
    private LogService logService;


	@RequestMapping(value = "/search", method = RequestMethod.POST)
	@ApiOperation(value = "Returns the list of LogOperation instances matching the search criteria.")
	public Page<LogOperation> findLogOperations( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
		LOGGER.debug("Rendering LogOperations list");
		return logOperationService.findAll(queryFilters, pageable);
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ApiOperation(value = "Returns the list of LogOperation instances.")
	public Page<LogOperation> getLogOperations(Pageable pageable) {
		LOGGER.debug("Rendering LogOperations list");
		return logOperationService.findAll(pageable);
	}

	@RequestMapping(value = "/count", method = RequestMethod.GET)
	@ApiOperation(value = "Returns the total count of LogOperation instances.")
	public Long countAllLogOperations() {
		LOGGER.debug("counting LogOperations");
		Long count = logOperationService.countAll();
		return count;
	}


    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @ApiOperation(value = "Returns the LogOperation instance associated with the given id.")
    public LogOperation getLogOperation(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting LogOperation with id: {}" , id);
        LogOperation instance = logOperationService.findById(id);
        LOGGER.debug("LogOperation details with id: {}" , instance);
        return instance;
    }
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @ApiOperation(value = "Deletes the LogOperation instance associated with the given id.")
    public boolean deleteLogOperation(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting LogOperation with id: {}" , id);
        LogOperation deleted = logOperationService.delete(id);
        return deleted != null;
    }

    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @ApiOperation(value = "Updates the LogOperation instance associated with the given id.")
    public LogOperation editLogOperation(@PathVariable("id") Integer id, @RequestBody LogOperation instance) throws EntityNotFoundException {
        LOGGER.debug("Editing LogOperation with id: {}" , instance.getIdLogOperation());
        instance.setIdLogOperation(id);
        instance = logOperationService.update(instance);
        LOGGER.debug("LogOperation details with id: {}" , instance);
        return instance;
    }


    @RequestMapping(value="/{id:.+}/logs", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the logs instance associated with the given id.")
     public Page<Log> findAssociatedlogs(Pageable pageable, @PathVariable("id") Integer id){
        LOGGER.debug("Fetching all associated logs");
        return logService.findAssociatedValues(id,"logOperation","idLogOperation", pageable);
   }



	@RequestMapping(value = "/", method = RequestMethod.POST)
	@ApiOperation(value = "Creates a new LogOperation instance.")
	public LogOperation createLogOperation(@RequestBody LogOperation instance) {
		LOGGER.debug("Create LogOperation with information: {}" , instance);
		instance = logOperationService.create(instance);
		LOGGER.debug("Created LogOperation with information: {}" , instance);
	    return instance;
	}

	/**
	 * This setter method should only be used by unit tests
	 * 
	 * @param service
	 */
	protected void setLogOperationService(LogOperationService service) {
		this.logOperationService = service;
	}
}

