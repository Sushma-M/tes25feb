/*Copyright (c) 2016-2017 gmail.com All Rights Reserved.
 This software is the confidential and proprietary information of gmail.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with gmail.com*/

package com.test_25feb.dynamohr126tabs.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import com.test_25feb.dynamohr126tabs.service.OverTimeSegmentPayrollService;


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
 * Controller object for domain model class OverTimeSegmentPayroll.
 * @see com.test_25feb.dynamohr126tabs.OverTimeSegmentPayroll
 */

@RestController(value = "Dynamohr126tabs.OverTimeSegmentPayrollController")
@Api(value = "/Dynamohr126tabs/OverTimeSegmentPayroll", description = "Exposes APIs to work with OverTimeSegmentPayroll resource.")
@RequestMapping("/Dynamohr126tabs/OverTimeSegmentPayroll")
public class OverTimeSegmentPayrollController {

    private static final Logger LOGGER = LoggerFactory.getLogger(OverTimeSegmentPayrollController.class);

	@Autowired
	@Qualifier("Dynamohr126tabs.OverTimeSegmentPayrollService")
	private OverTimeSegmentPayrollService overTimeSegmentPayrollService;


	@RequestMapping(value = "/search", method = RequestMethod.POST)
	@ApiOperation(value = "Returns the list of OverTimeSegmentPayroll instances matching the search criteria.")
	public Page<OverTimeSegmentPayroll> findOverTimeSegmentPayrolls( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
		LOGGER.debug("Rendering OverTimeSegmentPayrolls list");
		return overTimeSegmentPayrollService.findAll(queryFilters, pageable);
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ApiOperation(value = "Returns the list of OverTimeSegmentPayroll instances.")
	public Page<OverTimeSegmentPayroll> getOverTimeSegmentPayrolls(Pageable pageable) {
		LOGGER.debug("Rendering OverTimeSegmentPayrolls list");
		return overTimeSegmentPayrollService.findAll(pageable);
	}

	@RequestMapping(value = "/count", method = RequestMethod.GET)
	@ApiOperation(value = "Returns the total count of OverTimeSegmentPayroll instances.")
	public Long countAllOverTimeSegmentPayrolls() {
		LOGGER.debug("counting OverTimeSegmentPayrolls");
		Long count = overTimeSegmentPayrollService.countAll();
		return count;
	}


    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @ApiOperation(value = "Returns the OverTimeSegmentPayroll instance associated with the given id.")
    public OverTimeSegmentPayroll getOverTimeSegmentPayroll(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting OverTimeSegmentPayroll with id: {}" , id);
        OverTimeSegmentPayroll instance = overTimeSegmentPayrollService.findById(id);
        LOGGER.debug("OverTimeSegmentPayroll details with id: {}" , instance);
        return instance;
    }
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @ApiOperation(value = "Deletes the OverTimeSegmentPayroll instance associated with the given id.")
    public boolean deleteOverTimeSegmentPayroll(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting OverTimeSegmentPayroll with id: {}" , id);
        OverTimeSegmentPayroll deleted = overTimeSegmentPayrollService.delete(id);
        return deleted != null;
    }

    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @ApiOperation(value = "Updates the OverTimeSegmentPayroll instance associated with the given id.")
    public OverTimeSegmentPayroll editOverTimeSegmentPayroll(@PathVariable("id") Integer id, @RequestBody OverTimeSegmentPayroll instance) throws EntityNotFoundException {
        LOGGER.debug("Editing OverTimeSegmentPayroll with id: {}" , instance.getIdOverTimeSegmentPayroll());
        instance.setIdOverTimeSegmentPayroll(id);
        instance = overTimeSegmentPayrollService.update(instance);
        LOGGER.debug("OverTimeSegmentPayroll details with id: {}" , instance);
        return instance;
    }




	@RequestMapping(value = "/", method = RequestMethod.POST)
	@ApiOperation(value = "Creates a new OverTimeSegmentPayroll instance.")
	public OverTimeSegmentPayroll createOverTimeSegmentPayroll(@RequestBody OverTimeSegmentPayroll instance) {
		LOGGER.debug("Create OverTimeSegmentPayroll with information: {}" , instance);
		instance = overTimeSegmentPayrollService.create(instance);
		LOGGER.debug("Created OverTimeSegmentPayroll with information: {}" , instance);
	    return instance;
	}

	/**
	 * This setter method should only be used by unit tests
	 * 
	 * @param service
	 */
	protected void setOverTimeSegmentPayrollService(OverTimeSegmentPayrollService service) {
		this.overTimeSegmentPayrollService = service;
	}
}

