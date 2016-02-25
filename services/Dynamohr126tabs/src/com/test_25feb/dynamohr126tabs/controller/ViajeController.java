/*Copyright (c) 2016-2017 gmail.com All Rights Reserved.
 This software is the confidential and proprietary information of gmail.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with gmail.com*/

package com.test_25feb.dynamohr126tabs.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import com.test_25feb.dynamohr126tabs.service.TravelEmployeeService;
import com.test_25feb.dynamohr126tabs.service.ViajeService;


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
 * Controller object for domain model class Viaje.
 * @see com.test_25feb.dynamohr126tabs.Viaje
 */

@RestController(value = "Dynamohr126tabs.ViajeController")
@Api(value = "/Dynamohr126tabs/Viaje", description = "Exposes APIs to work with Viaje resource.")
@RequestMapping("/Dynamohr126tabs/Viaje")
public class ViajeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ViajeController.class);

	@Autowired
	@Qualifier("Dynamohr126tabs.ViajeService")
	private ViajeService viajeService;


    @Autowired
    @Qualifier("Dynamohr126tabs.TravelEmployeeService")
    private TravelEmployeeService travelEmployeeService;


	@RequestMapping(value = "/search", method = RequestMethod.POST)
	@ApiOperation(value = "Returns the list of Viaje instances matching the search criteria.")
	public Page<Viaje> findViajes( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
		LOGGER.debug("Rendering Viajes list");
		return viajeService.findAll(queryFilters, pageable);
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ApiOperation(value = "Returns the list of Viaje instances.")
	public Page<Viaje> getViajes(Pageable pageable) {
		LOGGER.debug("Rendering Viajes list");
		return viajeService.findAll(pageable);
	}

	@RequestMapping(value = "/count", method = RequestMethod.GET)
	@ApiOperation(value = "Returns the total count of Viaje instances.")
	public Long countAllViajes() {
		LOGGER.debug("counting Viajes");
		Long count = viajeService.countAll();
		return count;
	}


    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @ApiOperation(value = "Returns the Viaje instance associated with the given id.")
    public Viaje getViaje(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting Viaje with id: {}" , id);
        Viaje instance = viajeService.findById(id);
        LOGGER.debug("Viaje details with id: {}" , instance);
        return instance;
    }
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @ApiOperation(value = "Deletes the Viaje instance associated with the given id.")
    public boolean deleteViaje(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting Viaje with id: {}" , id);
        Viaje deleted = viajeService.delete(id);
        return deleted != null;
    }

    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @ApiOperation(value = "Updates the Viaje instance associated with the given id.")
    public Viaje editViaje(@PathVariable("id") Integer id, @RequestBody Viaje instance) throws EntityNotFoundException {
        LOGGER.debug("Editing Viaje with id: {}" , instance.getIdTravel());
        instance.setIdTravel(id);
        instance = viajeService.update(instance);
        LOGGER.debug("Viaje details with id: {}" , instance);
        return instance;
    }


    @RequestMapping(value="/{id:.+}/travelEmployees", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the travelEmployees instance associated with the given id.")
     public Page<TravelEmployee> findAssociatedtravelEmployees(Pageable pageable, @PathVariable("id") Integer id){
        LOGGER.debug("Fetching all associated travelEmployees");
        return travelEmployeeService.findAssociatedValues(id,"viaje","idTravel", pageable);
   }



	@RequestMapping(value = "/", method = RequestMethod.POST)
	@ApiOperation(value = "Creates a new Viaje instance.")
	public Viaje createViaje(@RequestBody Viaje instance) {
		LOGGER.debug("Create Viaje with information: {}" , instance);
		instance = viajeService.create(instance);
		LOGGER.debug("Created Viaje with information: {}" , instance);
	    return instance;
	}

	/**
	 * This setter method should only be used by unit tests
	 * 
	 * @param service
	 */
	protected void setViajeService(ViajeService service) {
		this.viajeService = service;
	}
}

