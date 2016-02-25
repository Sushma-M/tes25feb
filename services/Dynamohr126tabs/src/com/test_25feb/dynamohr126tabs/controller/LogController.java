/*Copyright (c) 2016-2017 gmail.com All Rights Reserved.
 This software is the confidential and proprietary information of gmail.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with gmail.com*/

package com.test_25feb.dynamohr126tabs.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


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
 * Controller object for domain model class Log.
 * @see com.test_25feb.dynamohr126tabs.Log
 */

@RestController(value = "Dynamohr126tabs.LogController")
@Api(value = "/Dynamohr126tabs/Log", description = "Exposes APIs to work with Log resource.")
@RequestMapping("/Dynamohr126tabs/Log")
public class LogController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LogController.class);

	@Autowired
	@Qualifier("Dynamohr126tabs.LogService")
	private LogService logService;


	@RequestMapping(value = "/search", method = RequestMethod.POST)
	@ApiOperation(value = "Returns the list of Log instances matching the search criteria.")
	public Page<Log> findLogs( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
		LOGGER.debug("Rendering Logs list");
		return logService.findAll(queryFilters, pageable);
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ApiOperation(value = "Returns the list of Log instances.")
	public Page<Log> getLogs(Pageable pageable) {
		LOGGER.debug("Rendering Logs list");
		return logService.findAll(pageable);
	}

	@RequestMapping(value = "/count", method = RequestMethod.GET)
	@ApiOperation(value = "Returns the total count of Log instances.")
	public Long countAllLogs() {
		LOGGER.debug("counting Logs");
		Long count = logService.countAll();
		return count;
	}


    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @ApiOperation(value = "Returns the Log instance associated with the given id.")
    public Log getLog(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting Log with id: {}" , id);
        Log instance = logService.findById(id);
        LOGGER.debug("Log details with id: {}" , instance);
        return instance;
    }
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @ApiOperation(value = "Deletes the Log instance associated with the given id.")
    public boolean deleteLog(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting Log with id: {}" , id);
        Log deleted = logService.delete(id);
        return deleted != null;
    }

    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @ApiOperation(value = "Updates the Log instance associated with the given id.")
    public Log editLog(@PathVariable("id") Integer id, @RequestBody Log instance) throws EntityNotFoundException {
        LOGGER.debug("Editing Log with id: {}" , instance.getLogId());
        instance.setLogId(id);
        instance = logService.update(instance);
        LOGGER.debug("Log details with id: {}" , instance);
        return instance;
    }




	@RequestMapping(value = "/", method = RequestMethod.POST)
	@ApiOperation(value = "Creates a new Log instance.")
	public Log createLog(@RequestBody Log instance) {
		LOGGER.debug("Create Log with information: {}" , instance);
		instance = logService.create(instance);
		LOGGER.debug("Created Log with information: {}" , instance);
	    return instance;
	}

	/**
	 * This setter method should only be used by unit tests
	 * 
	 * @param service
	 */
	protected void setLogService(LogService service) {
		this.logService = service;
	}
}

