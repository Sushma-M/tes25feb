/*Copyright (c) 2016-2017 gmail.com All Rights Reserved.
 This software is the confidential and proprietary information of gmail.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with gmail.com*/

package com.test_25feb.dynamohr126tabs.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import com.test_25feb.dynamohr126tabs.service.RateCurrencyService;


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
 * Controller object for domain model class RateCurrency.
 * @see com.test_25feb.dynamohr126tabs.RateCurrency
 */

@RestController(value = "Dynamohr126tabs.RateCurrencyController")
@Api(value = "/Dynamohr126tabs/RateCurrency", description = "Exposes APIs to work with RateCurrency resource.")
@RequestMapping("/Dynamohr126tabs/RateCurrency")
public class RateCurrencyController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RateCurrencyController.class);

	@Autowired
	@Qualifier("Dynamohr126tabs.RateCurrencyService")
	private RateCurrencyService rateCurrencyService;


	@RequestMapping(value = "/search", method = RequestMethod.POST)
	@ApiOperation(value = "Returns the list of RateCurrency instances matching the search criteria.")
	public Page<RateCurrency> findRateCurrencys( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
		LOGGER.debug("Rendering RateCurrencys list");
		return rateCurrencyService.findAll(queryFilters, pageable);
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ApiOperation(value = "Returns the list of RateCurrency instances.")
	public Page<RateCurrency> getRateCurrencys(Pageable pageable) {
		LOGGER.debug("Rendering RateCurrencys list");
		return rateCurrencyService.findAll(pageable);
	}

	@RequestMapping(value = "/count", method = RequestMethod.GET)
	@ApiOperation(value = "Returns the total count of RateCurrency instances.")
	public Long countAllRateCurrencys() {
		LOGGER.debug("counting RateCurrencys");
		Long count = rateCurrencyService.countAll();
		return count;
	}


    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @ApiOperation(value = "Returns the RateCurrency instance associated with the given id.")
    public RateCurrency getRateCurrency(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting RateCurrency with id: {}" , id);
        RateCurrency instance = rateCurrencyService.findById(id);
        LOGGER.debug("RateCurrency details with id: {}" , instance);
        return instance;
    }
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @ApiOperation(value = "Deletes the RateCurrency instance associated with the given id.")
    public boolean deleteRateCurrency(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting RateCurrency with id: {}" , id);
        RateCurrency deleted = rateCurrencyService.delete(id);
        return deleted != null;
    }

    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @ApiOperation(value = "Updates the RateCurrency instance associated with the given id.")
    public RateCurrency editRateCurrency(@PathVariable("id") Integer id, @RequestBody RateCurrency instance) throws EntityNotFoundException {
        LOGGER.debug("Editing RateCurrency with id: {}" , instance.getIdRateCurrency());
        instance.setIdRateCurrency(id);
        instance = rateCurrencyService.update(instance);
        LOGGER.debug("RateCurrency details with id: {}" , instance);
        return instance;
    }




	@RequestMapping(value = "/", method = RequestMethod.POST)
	@ApiOperation(value = "Creates a new RateCurrency instance.")
	public RateCurrency createRateCurrency(@RequestBody RateCurrency instance) {
		LOGGER.debug("Create RateCurrency with information: {}" , instance);
		instance = rateCurrencyService.create(instance);
		LOGGER.debug("Created RateCurrency with information: {}" , instance);
	    return instance;
	}

	/**
	 * This setter method should only be used by unit tests
	 * 
	 * @param service
	 */
	protected void setRateCurrencyService(RateCurrencyService service) {
		this.rateCurrencyService = service;
	}
}

