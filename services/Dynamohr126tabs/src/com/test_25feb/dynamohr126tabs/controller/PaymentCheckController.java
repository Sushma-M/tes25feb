/*Copyright (c) 2016-2017 gmail.com All Rights Reserved.
 This software is the confidential and proprietary information of gmail.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with gmail.com*/

package com.test_25feb.dynamohr126tabs.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import com.test_25feb.dynamohr126tabs.service.PaymentCheckService;


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
 * Controller object for domain model class PaymentCheck.
 * @see com.test_25feb.dynamohr126tabs.PaymentCheck
 */

@RestController(value = "Dynamohr126tabs.PaymentCheckController")
@Api(value = "/Dynamohr126tabs/PaymentCheck", description = "Exposes APIs to work with PaymentCheck resource.")
@RequestMapping("/Dynamohr126tabs/PaymentCheck")
public class PaymentCheckController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PaymentCheckController.class);

	@Autowired
	@Qualifier("Dynamohr126tabs.PaymentCheckService")
	private PaymentCheckService paymentCheckService;


	@RequestMapping(value = "/search", method = RequestMethod.POST)
	@ApiOperation(value = "Returns the list of PaymentCheck instances matching the search criteria.")
	public Page<PaymentCheck> findPaymentChecks( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
		LOGGER.debug("Rendering PaymentChecks list");
		return paymentCheckService.findAll(queryFilters, pageable);
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ApiOperation(value = "Returns the list of PaymentCheck instances.")
	public Page<PaymentCheck> getPaymentChecks(Pageable pageable) {
		LOGGER.debug("Rendering PaymentChecks list");
		return paymentCheckService.findAll(pageable);
	}

	@RequestMapping(value = "/count", method = RequestMethod.GET)
	@ApiOperation(value = "Returns the total count of PaymentCheck instances.")
	public Long countAllPaymentChecks() {
		LOGGER.debug("counting PaymentChecks");
		Long count = paymentCheckService.countAll();
		return count;
	}


    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @ApiOperation(value = "Returns the PaymentCheck instance associated with the given id.")
    public PaymentCheck getPaymentCheck(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting PaymentCheck with id: {}" , id);
        PaymentCheck instance = paymentCheckService.findById(id);
        LOGGER.debug("PaymentCheck details with id: {}" , instance);
        return instance;
    }
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @ApiOperation(value = "Deletes the PaymentCheck instance associated with the given id.")
    public boolean deletePaymentCheck(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting PaymentCheck with id: {}" , id);
        PaymentCheck deleted = paymentCheckService.delete(id);
        return deleted != null;
    }

    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @ApiOperation(value = "Updates the PaymentCheck instance associated with the given id.")
    public PaymentCheck editPaymentCheck(@PathVariable("id") Integer id, @RequestBody PaymentCheck instance) throws EntityNotFoundException {
        LOGGER.debug("Editing PaymentCheck with id: {}" , instance.getIdPaymentCheck());
        instance.setIdPaymentCheck(id);
        instance = paymentCheckService.update(instance);
        LOGGER.debug("PaymentCheck details with id: {}" , instance);
        return instance;
    }




	@RequestMapping(value = "/", method = RequestMethod.POST)
	@ApiOperation(value = "Creates a new PaymentCheck instance.")
	public PaymentCheck createPaymentCheck(@RequestBody PaymentCheck instance) {
		LOGGER.debug("Create PaymentCheck with information: {}" , instance);
		instance = paymentCheckService.create(instance);
		LOGGER.debug("Created PaymentCheck with information: {}" , instance);
	    return instance;
	}

	/**
	 * This setter method should only be used by unit tests
	 * 
	 * @param service
	 */
	protected void setPaymentCheckService(PaymentCheckService service) {
		this.paymentCheckService = service;
	}
}

