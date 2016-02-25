/*Copyright (c) 2016-2017 gmail.com All Rights Reserved.
 This software is the confidential and proprietary information of gmail.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with gmail.com*/

package com.test_25feb.dynamohr126tabs.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import com.test_25feb.dynamohr126tabs.service.EmployeeMessageService;


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
 * Controller object for domain model class EmployeeMessage.
 * @see com.test_25feb.dynamohr126tabs.EmployeeMessage
 */

@RestController(value = "Dynamohr126tabs.EmployeeMessageController")
@Api(value = "/Dynamohr126tabs/EmployeeMessage", description = "Exposes APIs to work with EmployeeMessage resource.")
@RequestMapping("/Dynamohr126tabs/EmployeeMessage")
public class EmployeeMessageController {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeMessageController.class);

	@Autowired
	@Qualifier("Dynamohr126tabs.EmployeeMessageService")
	private EmployeeMessageService employeeMessageService;


	@RequestMapping(value = "/search", method = RequestMethod.POST)
	@ApiOperation(value = "Returns the list of EmployeeMessage instances matching the search criteria.")
	public Page<EmployeeMessage> findEmployeeMessages( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
		LOGGER.debug("Rendering EmployeeMessages list");
		return employeeMessageService.findAll(queryFilters, pageable);
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ApiOperation(value = "Returns the list of EmployeeMessage instances.")
	public Page<EmployeeMessage> getEmployeeMessages(Pageable pageable) {
		LOGGER.debug("Rendering EmployeeMessages list");
		return employeeMessageService.findAll(pageable);
	}

	@RequestMapping(value = "/count", method = RequestMethod.GET)
	@ApiOperation(value = "Returns the total count of EmployeeMessage instances.")
	public Long countAllEmployeeMessages() {
		LOGGER.debug("counting EmployeeMessages");
		Long count = employeeMessageService.countAll();
		return count;
	}


    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @ApiOperation(value = "Returns the EmployeeMessage instance associated with the given id.")
    public EmployeeMessage getEmployeeMessage(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting EmployeeMessage with id: {}" , id);
        EmployeeMessage instance = employeeMessageService.findById(id);
        LOGGER.debug("EmployeeMessage details with id: {}" , instance);
        return instance;
    }
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @ApiOperation(value = "Deletes the EmployeeMessage instance associated with the given id.")
    public boolean deleteEmployeeMessage(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting EmployeeMessage with id: {}" , id);
        EmployeeMessage deleted = employeeMessageService.delete(id);
        return deleted != null;
    }

    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @ApiOperation(value = "Updates the EmployeeMessage instance associated with the given id.")
    public EmployeeMessage editEmployeeMessage(@PathVariable("id") Integer id, @RequestBody EmployeeMessage instance) throws EntityNotFoundException {
        LOGGER.debug("Editing EmployeeMessage with id: {}" , instance.getIdEmployeeMessage());
        instance.setIdEmployeeMessage(id);
        instance = employeeMessageService.update(instance);
        LOGGER.debug("EmployeeMessage details with id: {}" , instance);
        return instance;
    }




	@RequestMapping(value = "/", method = RequestMethod.POST)
	@ApiOperation(value = "Creates a new EmployeeMessage instance.")
	public EmployeeMessage createEmployeeMessage(@RequestBody EmployeeMessage instance) {
		LOGGER.debug("Create EmployeeMessage with information: {}" , instance);
		instance = employeeMessageService.create(instance);
		LOGGER.debug("Created EmployeeMessage with information: {}" , instance);
	    return instance;
	}

	/**
	 * This setter method should only be used by unit tests
	 * 
	 * @param service
	 */
	protected void setEmployeeMessageService(EmployeeMessageService service) {
		this.employeeMessageService = service;
	}
}

