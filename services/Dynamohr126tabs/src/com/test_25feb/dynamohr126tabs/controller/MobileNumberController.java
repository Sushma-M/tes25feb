/*Copyright (c) 2016-2017 gmail.com All Rights Reserved.
 This software is the confidential and proprietary information of gmail.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with gmail.com*/

package com.test_25feb.dynamohr126tabs.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import com.test_25feb.dynamohr126tabs.service.ListCelphoneDetailPayrollService;
import com.test_25feb.dynamohr126tabs.service.ListEmployeePhoneService;
import com.test_25feb.dynamohr126tabs.service.MobileNumberService;


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
 * Controller object for domain model class MobileNumber.
 * @see com.test_25feb.dynamohr126tabs.MobileNumber
 */

@RestController(value = "Dynamohr126tabs.MobileNumberController")
@Api(value = "/Dynamohr126tabs/MobileNumber", description = "Exposes APIs to work with MobileNumber resource.")
@RequestMapping("/Dynamohr126tabs/MobileNumber")
public class MobileNumberController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MobileNumberController.class);

	@Autowired
	@Qualifier("Dynamohr126tabs.MobileNumberService")
	private MobileNumberService mobileNumberService;


    @Autowired
    @Qualifier("Dynamohr126tabs.ListEmployeePhoneService")
    private ListEmployeePhoneService listEmployeePhoneService;


    @Autowired
    @Qualifier("Dynamohr126tabs.ListCelphoneDetailPayrollService")
    private ListCelphoneDetailPayrollService listCelphoneDetailPayrollService;


	@RequestMapping(value = "/search", method = RequestMethod.POST)
	@ApiOperation(value = "Returns the list of MobileNumber instances matching the search criteria.")
	public Page<MobileNumber> findMobileNumbers( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
		LOGGER.debug("Rendering MobileNumbers list");
		return mobileNumberService.findAll(queryFilters, pageable);
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ApiOperation(value = "Returns the list of MobileNumber instances.")
	public Page<MobileNumber> getMobileNumbers(Pageable pageable) {
		LOGGER.debug("Rendering MobileNumbers list");
		return mobileNumberService.findAll(pageable);
	}

	@RequestMapping(value = "/count", method = RequestMethod.GET)
	@ApiOperation(value = "Returns the total count of MobileNumber instances.")
	public Long countAllMobileNumbers() {
		LOGGER.debug("counting MobileNumbers");
		Long count = mobileNumberService.countAll();
		return count;
	}


    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @ApiOperation(value = "Returns the MobileNumber instance associated with the given id.")
    public MobileNumber getMobileNumber(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting MobileNumber with id: {}" , id);
        MobileNumber instance = mobileNumberService.findById(id);
        LOGGER.debug("MobileNumber details with id: {}" , instance);
        return instance;
    }
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @ApiOperation(value = "Deletes the MobileNumber instance associated with the given id.")
    public boolean deleteMobileNumber(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting MobileNumber with id: {}" , id);
        MobileNumber deleted = mobileNumberService.delete(id);
        return deleted != null;
    }

    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @ApiOperation(value = "Updates the MobileNumber instance associated with the given id.")
    public MobileNumber editMobileNumber(@PathVariable("id") Integer id, @RequestBody MobileNumber instance) throws EntityNotFoundException {
        LOGGER.debug("Editing MobileNumber with id: {}" , instance.getIdCellphone());
        instance.setIdCellphone(id);
        instance = mobileNumberService.update(instance);
        LOGGER.debug("MobileNumber details with id: {}" , instance);
        return instance;
    }


    @RequestMapping(value="/{id:.+}/listCelphoneDetailPayrolls", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the listCelphoneDetailPayrolls instance associated with the given id.")
     public Page<ListCelphoneDetailPayroll> findAssociatedlistCelphoneDetailPayrolls(Pageable pageable, @PathVariable("id") Integer id){
        LOGGER.debug("Fetching all associated listCelphoneDetailPayrolls");
        return listCelphoneDetailPayrollService.findAssociatedValues(id,"mobileNumber","idCellphone", pageable);
   }

    @RequestMapping(value="/{id:.+}/listEmployeePhones", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the listEmployeePhones instance associated with the given id.")
     public Page<ListEmployeePhone> findAssociatedlistEmployeePhones(Pageable pageable, @PathVariable("id") Integer id){
        LOGGER.debug("Fetching all associated listEmployeePhones");
        return listEmployeePhoneService.findAssociatedValues(id,"mobileNumber","idCellphone", pageable);
   }



	@RequestMapping(value = "/", method = RequestMethod.POST)
	@ApiOperation(value = "Creates a new MobileNumber instance.")
	public MobileNumber createMobileNumber(@RequestBody MobileNumber instance) {
		LOGGER.debug("Create MobileNumber with information: {}" , instance);
		instance = mobileNumberService.create(instance);
		LOGGER.debug("Created MobileNumber with information: {}" , instance);
	    return instance;
	}

	/**
	 * This setter method should only be used by unit tests
	 * 
	 * @param service
	 */
	protected void setMobileNumberService(MobileNumberService service) {
		this.mobileNumberService = service;
	}
}

