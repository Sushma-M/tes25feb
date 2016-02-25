/*Copyright (c) 2016-2017 gmail.com All Rights Reserved.
 This software is the confidential and proprietary information of gmail.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with gmail.com*/

package com.test_25feb.dynamohr126tabs.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import com.test_25feb.dynamohr126tabs.service.EmployeeFileService;


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
 * Controller object for domain model class EmployeeFile.
 * @see com.test_25feb.dynamohr126tabs.EmployeeFile
 */

@RestController(value = "Dynamohr126tabs.EmployeeFileController")
@Api(value = "/Dynamohr126tabs/EmployeeFile", description = "Exposes APIs to work with EmployeeFile resource.")
@RequestMapping("/Dynamohr126tabs/EmployeeFile")
public class EmployeeFileController {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeFileController.class);

	@Autowired
	@Qualifier("Dynamohr126tabs.EmployeeFileService")
	private EmployeeFileService employeeFileService;


	@RequestMapping(value = "/search", method = RequestMethod.POST)
	@ApiOperation(value = "Returns the list of EmployeeFile instances matching the search criteria.")
	public Page<EmployeeFile> findEmployeeFiles( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
		LOGGER.debug("Rendering EmployeeFiles list");
		return employeeFileService.findAll(queryFilters, pageable);
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ApiOperation(value = "Returns the list of EmployeeFile instances.")
	public Page<EmployeeFile> getEmployeeFiles(Pageable pageable) {
		LOGGER.debug("Rendering EmployeeFiles list");
		return employeeFileService.findAll(pageable);
	}

	@RequestMapping(value = "/count", method = RequestMethod.GET)
	@ApiOperation(value = "Returns the total count of EmployeeFile instances.")
	public Long countAllEmployeeFiles() {
		LOGGER.debug("counting EmployeeFiles");
		Long count = employeeFileService.countAll();
		return count;
	}


    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @ApiOperation(value = "Returns the EmployeeFile instance associated with the given id.")
    public EmployeeFile getEmployeeFile(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting EmployeeFile with id: {}" , id);
        EmployeeFile instance = employeeFileService.findById(id);
        LOGGER.debug("EmployeeFile details with id: {}" , instance);
        return instance;
    }
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @ApiOperation(value = "Deletes the EmployeeFile instance associated with the given id.")
    public boolean deleteEmployeeFile(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting EmployeeFile with id: {}" , id);
        EmployeeFile deleted = employeeFileService.delete(id);
        return deleted != null;
    }

    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @ApiOperation(value = "Updates the EmployeeFile instance associated with the given id.")
    public EmployeeFile editEmployeeFile(@PathVariable("id") Integer id, @RequestBody EmployeeFile instance) throws EntityNotFoundException {
        LOGGER.debug("Editing EmployeeFile with id: {}" , instance.getIdEmployeeFile());
        instance.setIdEmployeeFile(id);
        instance = employeeFileService.update(instance);
        LOGGER.debug("EmployeeFile details with id: {}" , instance);
        return instance;
    }




	@RequestMapping(value = "/", method = RequestMethod.POST)
	@ApiOperation(value = "Creates a new EmployeeFile instance.")
	public EmployeeFile createEmployeeFile(@RequestBody EmployeeFile instance) {
		LOGGER.debug("Create EmployeeFile with information: {}" , instance);
		instance = employeeFileService.create(instance);
		LOGGER.debug("Created EmployeeFile with information: {}" , instance);
	    return instance;
	}

	/**
	 * This setter method should only be used by unit tests
	 * 
	 * @param service
	 */
	protected void setEmployeeFileService(EmployeeFileService service) {
		this.employeeFileService = service;
	}
}

