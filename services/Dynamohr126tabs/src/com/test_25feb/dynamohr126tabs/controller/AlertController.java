/*Copyright (c) 2016-2017 gmail.com All Rights Reserved.
 This software is the confidential and proprietary information of gmail.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with gmail.com*/

package com.test_25feb.dynamohr126tabs.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import com.test_25feb.dynamohr126tabs.service.AlertService;


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
 * Controller object for domain model class Alert.
 * @see com.test_25feb.dynamohr126tabs.Alert
 */

@RestController(value = "Dynamohr126tabs.AlertController")
@Api(value = "/Dynamohr126tabs/Alert", description = "Exposes APIs to work with Alert resource.")
@RequestMapping("/Dynamohr126tabs/Alert")
public class AlertController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AlertController.class);

	@Autowired
	@Qualifier("Dynamohr126tabs.AlertService")
	private AlertService alertService;


	@RequestMapping(value = "/search", method = RequestMethod.POST)
	@ApiOperation(value = "Returns the list of Alert instances matching the search criteria.")
	public Page<Alert> findAlerts( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
		LOGGER.debug("Rendering Alerts list");
		return alertService.findAll(queryFilters, pageable);
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ApiOperation(value = "Returns the list of Alert instances.")
	public Page<Alert> getAlerts(Pageable pageable) {
		LOGGER.debug("Rendering Alerts list");
		return alertService.findAll(pageable);
	}

	@RequestMapping(value = "/count", method = RequestMethod.GET)
	@ApiOperation(value = "Returns the total count of Alert instances.")
	public Long countAllAlerts() {
		LOGGER.debug("counting Alerts");
		Long count = alertService.countAll();
		return count;
	}


    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @ApiOperation(value = "Returns the Alert instance associated with the given id.")
    public Alert getAlert(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting Alert with id: {}" , id);
        Alert instance = alertService.findById(id);
        LOGGER.debug("Alert details with id: {}" , instance);
        return instance;
    }
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @ApiOperation(value = "Deletes the Alert instance associated with the given id.")
    public boolean deleteAlert(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting Alert with id: {}" , id);
        Alert deleted = alertService.delete(id);
        return deleted != null;
    }

    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @ApiOperation(value = "Updates the Alert instance associated with the given id.")
    public Alert editAlert(@PathVariable("id") Integer id, @RequestBody Alert instance) throws EntityNotFoundException {
        LOGGER.debug("Editing Alert with id: {}" , instance.getIdAlert());
        instance.setIdAlert(id);
        instance = alertService.update(instance);
        LOGGER.debug("Alert details with id: {}" , instance);
        return instance;
    }




	@RequestMapping(value = "/", method = RequestMethod.POST)
	@ApiOperation(value = "Creates a new Alert instance.")
	public Alert createAlert(@RequestBody Alert instance) {
		LOGGER.debug("Create Alert with information: {}" , instance);
		instance = alertService.create(instance);
		LOGGER.debug("Created Alert with information: {}" , instance);
	    return instance;
	}

	/**
	 * This setter method should only be used by unit tests
	 * 
	 * @param service
	 */
	protected void setAlertService(AlertService service) {
		this.alertService = service;
	}
}

