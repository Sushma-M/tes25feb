/*Copyright (c) 2016-2017 gmail.com All Rights Reserved.
 This software is the confidential and proprietary information of gmail.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with gmail.com*/

package com.test_25feb.dynamohr126tabs.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import com.test_25feb.dynamohr126tabs.service.CompensatoryDayCreditService;


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
 * Controller object for domain model class CompensatoryDayCredit.
 * @see com.test_25feb.dynamohr126tabs.CompensatoryDayCredit
 */

@RestController(value = "Dynamohr126tabs.CompensatoryDayCreditController")
@Api(value = "/Dynamohr126tabs/CompensatoryDayCredit", description = "Exposes APIs to work with CompensatoryDayCredit resource.")
@RequestMapping("/Dynamohr126tabs/CompensatoryDayCredit")
public class CompensatoryDayCreditController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CompensatoryDayCreditController.class);

	@Autowired
	@Qualifier("Dynamohr126tabs.CompensatoryDayCreditService")
	private CompensatoryDayCreditService compensatoryDayCreditService;


	@RequestMapping(value = "/search", method = RequestMethod.POST)
	@ApiOperation(value = "Returns the list of CompensatoryDayCredit instances matching the search criteria.")
	public Page<CompensatoryDayCredit> findCompensatoryDayCredits( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
		LOGGER.debug("Rendering CompensatoryDayCredits list");
		return compensatoryDayCreditService.findAll(queryFilters, pageable);
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ApiOperation(value = "Returns the list of CompensatoryDayCredit instances.")
	public Page<CompensatoryDayCredit> getCompensatoryDayCredits(Pageable pageable) {
		LOGGER.debug("Rendering CompensatoryDayCredits list");
		return compensatoryDayCreditService.findAll(pageable);
	}

	@RequestMapping(value = "/count", method = RequestMethod.GET)
	@ApiOperation(value = "Returns the total count of CompensatoryDayCredit instances.")
	public Long countAllCompensatoryDayCredits() {
		LOGGER.debug("counting CompensatoryDayCredits");
		Long count = compensatoryDayCreditService.countAll();
		return count;
	}


    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @ApiOperation(value = "Returns the CompensatoryDayCredit instance associated with the given id.")
    public CompensatoryDayCredit getCompensatoryDayCredit(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting CompensatoryDayCredit with id: {}" , id);
        CompensatoryDayCredit instance = compensatoryDayCreditService.findById(id);
        LOGGER.debug("CompensatoryDayCredit details with id: {}" , instance);
        return instance;
    }
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @ApiOperation(value = "Deletes the CompensatoryDayCredit instance associated with the given id.")
    public boolean deleteCompensatoryDayCredit(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting CompensatoryDayCredit with id: {}" , id);
        CompensatoryDayCredit deleted = compensatoryDayCreditService.delete(id);
        return deleted != null;
    }

    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @ApiOperation(value = "Updates the CompensatoryDayCredit instance associated with the given id.")
    public CompensatoryDayCredit editCompensatoryDayCredit(@PathVariable("id") Integer id, @RequestBody CompensatoryDayCredit instance) throws EntityNotFoundException {
        LOGGER.debug("Editing CompensatoryDayCredit with id: {}" , instance.getIdCompensatoryDayCredit());
        instance.setIdCompensatoryDayCredit(id);
        instance = compensatoryDayCreditService.update(instance);
        LOGGER.debug("CompensatoryDayCredit details with id: {}" , instance);
        return instance;
    }




	@RequestMapping(value = "/", method = RequestMethod.POST)
	@ApiOperation(value = "Creates a new CompensatoryDayCredit instance.")
	public CompensatoryDayCredit createCompensatoryDayCredit(@RequestBody CompensatoryDayCredit instance) {
		LOGGER.debug("Create CompensatoryDayCredit with information: {}" , instance);
		instance = compensatoryDayCreditService.create(instance);
		LOGGER.debug("Created CompensatoryDayCredit with information: {}" , instance);
	    return instance;
	}

	/**
	 * This setter method should only be used by unit tests
	 * 
	 * @param service
	 */
	protected void setCompensatoryDayCreditService(CompensatoryDayCreditService service) {
		this.compensatoryDayCreditService = service;
	}
}

