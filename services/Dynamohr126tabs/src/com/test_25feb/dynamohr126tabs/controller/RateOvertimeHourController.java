/*Copyright (c) 2016-2017 gmail.com All Rights Reserved.
 This software is the confidential and proprietary information of gmail.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with gmail.com*/

package com.test_25feb.dynamohr126tabs.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import com.test_25feb.dynamohr126tabs.service.RateOvertimeHourService;


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
 * Controller object for domain model class RateOvertimeHour.
 * @see com.test_25feb.dynamohr126tabs.RateOvertimeHour
 */

@RestController(value = "Dynamohr126tabs.RateOvertimeHourController")
@Api(value = "/Dynamohr126tabs/RateOvertimeHour", description = "Exposes APIs to work with RateOvertimeHour resource.")
@RequestMapping("/Dynamohr126tabs/RateOvertimeHour")
public class RateOvertimeHourController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RateOvertimeHourController.class);

	@Autowired
	@Qualifier("Dynamohr126tabs.RateOvertimeHourService")
	private RateOvertimeHourService rateOvertimeHourService;


	@RequestMapping(value = "/search", method = RequestMethod.POST)
	@ApiOperation(value = "Returns the list of RateOvertimeHour instances matching the search criteria.")
	public Page<RateOvertimeHour> findRateOvertimeHours( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
		LOGGER.debug("Rendering RateOvertimeHours list");
		return rateOvertimeHourService.findAll(queryFilters, pageable);
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ApiOperation(value = "Returns the list of RateOvertimeHour instances.")
	public Page<RateOvertimeHour> getRateOvertimeHours(Pageable pageable) {
		LOGGER.debug("Rendering RateOvertimeHours list");
		return rateOvertimeHourService.findAll(pageable);
	}

	@RequestMapping(value = "/count", method = RequestMethod.GET)
	@ApiOperation(value = "Returns the total count of RateOvertimeHour instances.")
	public Long countAllRateOvertimeHours() {
		LOGGER.debug("counting RateOvertimeHours");
		Long count = rateOvertimeHourService.countAll();
		return count;
	}


    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @ApiOperation(value = "Returns the RateOvertimeHour instance associated with the given id.")
    public RateOvertimeHour getRateOvertimeHour(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting RateOvertimeHour with id: {}" , id);
        RateOvertimeHour instance = rateOvertimeHourService.findById(id);
        LOGGER.debug("RateOvertimeHour details with id: {}" , instance);
        return instance;
    }
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @ApiOperation(value = "Deletes the RateOvertimeHour instance associated with the given id.")
    public boolean deleteRateOvertimeHour(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting RateOvertimeHour with id: {}" , id);
        RateOvertimeHour deleted = rateOvertimeHourService.delete(id);
        return deleted != null;
    }

    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @ApiOperation(value = "Updates the RateOvertimeHour instance associated with the given id.")
    public RateOvertimeHour editRateOvertimeHour(@PathVariable("id") Integer id, @RequestBody RateOvertimeHour instance) throws EntityNotFoundException {
        LOGGER.debug("Editing RateOvertimeHour with id: {}" , instance.getIdTypeGenerationForm());
        instance.setIdTypeGenerationForm(id);
        instance = rateOvertimeHourService.update(instance);
        LOGGER.debug("RateOvertimeHour details with id: {}" , instance);
        return instance;
    }




	@RequestMapping(value = "/", method = RequestMethod.POST)
	@ApiOperation(value = "Creates a new RateOvertimeHour instance.")
	public RateOvertimeHour createRateOvertimeHour(@RequestBody RateOvertimeHour instance) {
		LOGGER.debug("Create RateOvertimeHour with information: {}" , instance);
		instance = rateOvertimeHourService.create(instance);
		LOGGER.debug("Created RateOvertimeHour with information: {}" , instance);
	    return instance;
	}

	/**
	 * This setter method should only be used by unit tests
	 * 
	 * @param service
	 */
	protected void setRateOvertimeHourService(RateOvertimeHourService service) {
		this.rateOvertimeHourService = service;
	}
}

