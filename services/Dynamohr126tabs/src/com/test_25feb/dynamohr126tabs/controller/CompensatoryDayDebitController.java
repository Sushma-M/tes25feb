/*Copyright (c) 2016-2017 gmail.com All Rights Reserved.
 This software is the confidential and proprietary information of gmail.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with gmail.com*/

package com.test_25feb.dynamohr126tabs.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import com.test_25feb.dynamohr126tabs.service.CompensatoryDayDebitService;


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
 * Controller object for domain model class CompensatoryDayDebit.
 * @see com.test_25feb.dynamohr126tabs.CompensatoryDayDebit
 */

@RestController(value = "Dynamohr126tabs.CompensatoryDayDebitController")
@Api(value = "/Dynamohr126tabs/CompensatoryDayDebit", description = "Exposes APIs to work with CompensatoryDayDebit resource.")
@RequestMapping("/Dynamohr126tabs/CompensatoryDayDebit")
public class CompensatoryDayDebitController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CompensatoryDayDebitController.class);

	@Autowired
	@Qualifier("Dynamohr126tabs.CompensatoryDayDebitService")
	private CompensatoryDayDebitService compensatoryDayDebitService;


	@RequestMapping(value = "/search", method = RequestMethod.POST)
	@ApiOperation(value = "Returns the list of CompensatoryDayDebit instances matching the search criteria.")
	public Page<CompensatoryDayDebit> findCompensatoryDayDebits( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
		LOGGER.debug("Rendering CompensatoryDayDebits list");
		return compensatoryDayDebitService.findAll(queryFilters, pageable);
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ApiOperation(value = "Returns the list of CompensatoryDayDebit instances.")
	public Page<CompensatoryDayDebit> getCompensatoryDayDebits(Pageable pageable) {
		LOGGER.debug("Rendering CompensatoryDayDebits list");
		return compensatoryDayDebitService.findAll(pageable);
	}

	@RequestMapping(value = "/count", method = RequestMethod.GET)
	@ApiOperation(value = "Returns the total count of CompensatoryDayDebit instances.")
	public Long countAllCompensatoryDayDebits() {
		LOGGER.debug("counting CompensatoryDayDebits");
		Long count = compensatoryDayDebitService.countAll();
		return count;
	}


    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @ApiOperation(value = "Returns the CompensatoryDayDebit instance associated with the given id.")
    public CompensatoryDayDebit getCompensatoryDayDebit(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting CompensatoryDayDebit with id: {}" , id);
        CompensatoryDayDebit instance = compensatoryDayDebitService.findById(id);
        LOGGER.debug("CompensatoryDayDebit details with id: {}" , instance);
        return instance;
    }
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @ApiOperation(value = "Deletes the CompensatoryDayDebit instance associated with the given id.")
    public boolean deleteCompensatoryDayDebit(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting CompensatoryDayDebit with id: {}" , id);
        CompensatoryDayDebit deleted = compensatoryDayDebitService.delete(id);
        return deleted != null;
    }

    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @ApiOperation(value = "Updates the CompensatoryDayDebit instance associated with the given id.")
    public CompensatoryDayDebit editCompensatoryDayDebit(@PathVariable("id") Integer id, @RequestBody CompensatoryDayDebit instance) throws EntityNotFoundException {
        LOGGER.debug("Editing CompensatoryDayDebit with id: {}" , instance.getIdTiempoCompensatorioDiaAcreditado());
        instance.setIdTiempoCompensatorioDiaAcreditado(id);
        instance = compensatoryDayDebitService.update(instance);
        LOGGER.debug("CompensatoryDayDebit details with id: {}" , instance);
        return instance;
    }




	@RequestMapping(value = "/", method = RequestMethod.POST)
	@ApiOperation(value = "Creates a new CompensatoryDayDebit instance.")
	public CompensatoryDayDebit createCompensatoryDayDebit(@RequestBody CompensatoryDayDebit instance) {
		LOGGER.debug("Create CompensatoryDayDebit with information: {}" , instance);
		instance = compensatoryDayDebitService.create(instance);
		LOGGER.debug("Created CompensatoryDayDebit with information: {}" , instance);
	    return instance;
	}

	/**
	 * This setter method should only be used by unit tests
	 * 
	 * @param service
	 */
	protected void setCompensatoryDayDebitService(CompensatoryDayDebitService service) {
		this.compensatoryDayDebitService = service;
	}
}

