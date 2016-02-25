/*Copyright (c) 2016-2017 gmail.com All Rights Reserved.
 This software is the confidential and proprietary information of gmail.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with gmail.com*/

package com.test_25feb.dynamohr126tabs.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import com.test_25feb.dynamohr126tabs.service.BadgeEmployeeService;


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
 * Controller object for domain model class BadgeEmployee.
 * @see com.test_25feb.dynamohr126tabs.BadgeEmployee
 */

@RestController(value = "Dynamohr126tabs.BadgeEmployeeController")
@Api(value = "/Dynamohr126tabs/BadgeEmployee", description = "Exposes APIs to work with BadgeEmployee resource.")
@RequestMapping("/Dynamohr126tabs/BadgeEmployee")
public class BadgeEmployeeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(BadgeEmployeeController.class);

	@Autowired
	@Qualifier("Dynamohr126tabs.BadgeEmployeeService")
	private BadgeEmployeeService badgeEmployeeService;


	@RequestMapping(value = "/search", method = RequestMethod.POST)
	@ApiOperation(value = "Returns the list of BadgeEmployee instances matching the search criteria.")
	public Page<BadgeEmployee> findBadgeEmployees( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
		LOGGER.debug("Rendering BadgeEmployees list");
		return badgeEmployeeService.findAll(queryFilters, pageable);
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ApiOperation(value = "Returns the list of BadgeEmployee instances.")
	public Page<BadgeEmployee> getBadgeEmployees(Pageable pageable) {
		LOGGER.debug("Rendering BadgeEmployees list");
		return badgeEmployeeService.findAll(pageable);
	}

	@RequestMapping(value = "/count", method = RequestMethod.GET)
	@ApiOperation(value = "Returns the total count of BadgeEmployee instances.")
	public Long countAllBadgeEmployees() {
		LOGGER.debug("counting BadgeEmployees");
		Long count = badgeEmployeeService.countAll();
		return count;
	}


    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @ApiOperation(value = "Returns the BadgeEmployee instance associated with the given id.")
    public BadgeEmployee getBadgeEmployee(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting BadgeEmployee with id: {}" , id);
        BadgeEmployee instance = badgeEmployeeService.findById(id);
        LOGGER.debug("BadgeEmployee details with id: {}" , instance);
        return instance;
    }
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @ApiOperation(value = "Deletes the BadgeEmployee instance associated with the given id.")
    public boolean deleteBadgeEmployee(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting BadgeEmployee with id: {}" , id);
        BadgeEmployee deleted = badgeEmployeeService.delete(id);
        return deleted != null;
    }

    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @ApiOperation(value = "Updates the BadgeEmployee instance associated with the given id.")
    public BadgeEmployee editBadgeEmployee(@PathVariable("id") Integer id, @RequestBody BadgeEmployee instance) throws EntityNotFoundException {
        LOGGER.debug("Editing BadgeEmployee with id: {}" , instance.getIdBadgeEmployee());
        instance.setIdBadgeEmployee(id);
        instance = badgeEmployeeService.update(instance);
        LOGGER.debug("BadgeEmployee details with id: {}" , instance);
        return instance;
    }




	@RequestMapping(value = "/", method = RequestMethod.POST)
	@ApiOperation(value = "Creates a new BadgeEmployee instance.")
	public BadgeEmployee createBadgeEmployee(@RequestBody BadgeEmployee instance) {
		LOGGER.debug("Create BadgeEmployee with information: {}" , instance);
		instance = badgeEmployeeService.create(instance);
		LOGGER.debug("Created BadgeEmployee with information: {}" , instance);
	    return instance;
	}

	/**
	 * This setter method should only be used by unit tests
	 * 
	 * @param service
	 */
	protected void setBadgeEmployeeService(BadgeEmployeeService service) {
		this.badgeEmployeeService = service;
	}
}

