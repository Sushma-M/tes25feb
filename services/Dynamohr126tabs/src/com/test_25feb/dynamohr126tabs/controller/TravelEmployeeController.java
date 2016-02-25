/*Copyright (c) 2016-2017 gmail.com All Rights Reserved.
 This software is the confidential and proprietary information of gmail.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with gmail.com*/

package com.test_25feb.dynamohr126tabs.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import com.test_25feb.dynamohr126tabs.service.TravelEmployeeService;
import com.test_25feb.dynamohr126tabs.service.TravelExpenseService;


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
 * Controller object for domain model class TravelEmployee.
 * @see com.test_25feb.dynamohr126tabs.TravelEmployee
 */

@RestController(value = "Dynamohr126tabs.TravelEmployeeController")
@Api(value = "/Dynamohr126tabs/TravelEmployee", description = "Exposes APIs to work with TravelEmployee resource.")
@RequestMapping("/Dynamohr126tabs/TravelEmployee")
public class TravelEmployeeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TravelEmployeeController.class);

	@Autowired
	@Qualifier("Dynamohr126tabs.TravelEmployeeService")
	private TravelEmployeeService travelEmployeeService;


    @Autowired
    @Qualifier("Dynamohr126tabs.TravelExpenseService")
    private TravelExpenseService travelExpenseService;


	@RequestMapping(value = "/search", method = RequestMethod.POST)
	@ApiOperation(value = "Returns the list of TravelEmployee instances matching the search criteria.")
	public Page<TravelEmployee> findTravelEmployees( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
		LOGGER.debug("Rendering TravelEmployees list");
		return travelEmployeeService.findAll(queryFilters, pageable);
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ApiOperation(value = "Returns the list of TravelEmployee instances.")
	public Page<TravelEmployee> getTravelEmployees(Pageable pageable) {
		LOGGER.debug("Rendering TravelEmployees list");
		return travelEmployeeService.findAll(pageable);
	}

	@RequestMapping(value = "/count", method = RequestMethod.GET)
	@ApiOperation(value = "Returns the total count of TravelEmployee instances.")
	public Long countAllTravelEmployees() {
		LOGGER.debug("counting TravelEmployees");
		Long count = travelEmployeeService.countAll();
		return count;
	}


    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @ApiOperation(value = "Returns the TravelEmployee instance associated with the given id.")
    public TravelEmployee getTravelEmployee(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting TravelEmployee with id: {}" , id);
        TravelEmployee instance = travelEmployeeService.findById(id);
        LOGGER.debug("TravelEmployee details with id: {}" , instance);
        return instance;
    }
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @ApiOperation(value = "Deletes the TravelEmployee instance associated with the given id.")
    public boolean deleteTravelEmployee(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting TravelEmployee with id: {}" , id);
        TravelEmployee deleted = travelEmployeeService.delete(id);
        return deleted != null;
    }

    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @ApiOperation(value = "Updates the TravelEmployee instance associated with the given id.")
    public TravelEmployee editTravelEmployee(@PathVariable("id") Integer id, @RequestBody TravelEmployee instance) throws EntityNotFoundException {
        LOGGER.debug("Editing TravelEmployee with id: {}" , instance.getIdTravelEmployee());
        instance.setIdTravelEmployee(id);
        instance = travelEmployeeService.update(instance);
        LOGGER.debug("TravelEmployee details with id: {}" , instance);
        return instance;
    }


    @RequestMapping(value="/{id:.+}/travelExpenses", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the travelExpenses instance associated with the given id.")
     public Page<TravelExpense> findAssociatedtravelExpenses(Pageable pageable, @PathVariable("id") Integer id){
        LOGGER.debug("Fetching all associated travelExpenses");
        return travelExpenseService.findAssociatedValues(id,"travelEmployee","idTravelEmployee", pageable);
   }



	@RequestMapping(value = "/", method = RequestMethod.POST)
	@ApiOperation(value = "Creates a new TravelEmployee instance.")
	public TravelEmployee createTravelEmployee(@RequestBody TravelEmployee instance) {
		LOGGER.debug("Create TravelEmployee with information: {}" , instance);
		instance = travelEmployeeService.create(instance);
		LOGGER.debug("Created TravelEmployee with information: {}" , instance);
	    return instance;
	}

	/**
	 * This setter method should only be used by unit tests
	 * 
	 * @param service
	 */
	protected void setTravelEmployeeService(TravelEmployeeService service) {
		this.travelEmployeeService = service;
	}
}

