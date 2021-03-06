/*Copyright (c) 2016-2017 gmail.com All Rights Reserved.
 This software is the confidential and proprietary information of gmail.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with gmail.com*/

package com.test_25feb.dynamohr126tabs.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import com.test_25feb.dynamohr126tabs.service.EmployeeService;
import com.test_25feb.dynamohr126tabs.service.TypeRecruitmentService;


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
 * Controller object for domain model class TypeRecruitment.
 * @see com.test_25feb.dynamohr126tabs.TypeRecruitment
 */

@RestController(value = "Dynamohr126tabs.TypeRecruitmentController")
@Api(value = "/Dynamohr126tabs/TypeRecruitment", description = "Exposes APIs to work with TypeRecruitment resource.")
@RequestMapping("/Dynamohr126tabs/TypeRecruitment")
public class TypeRecruitmentController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TypeRecruitmentController.class);

	@Autowired
	@Qualifier("Dynamohr126tabs.TypeRecruitmentService")
	private TypeRecruitmentService typeRecruitmentService;


    @Autowired
    @Qualifier("Dynamohr126tabs.EmployeeService")
    private EmployeeService employeeService;


	@RequestMapping(value = "/search", method = RequestMethod.POST)
	@ApiOperation(value = "Returns the list of TypeRecruitment instances matching the search criteria.")
	public Page<TypeRecruitment> findTypeRecruitments( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
		LOGGER.debug("Rendering TypeRecruitments list");
		return typeRecruitmentService.findAll(queryFilters, pageable);
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ApiOperation(value = "Returns the list of TypeRecruitment instances.")
	public Page<TypeRecruitment> getTypeRecruitments(Pageable pageable) {
		LOGGER.debug("Rendering TypeRecruitments list");
		return typeRecruitmentService.findAll(pageable);
	}

	@RequestMapping(value = "/count", method = RequestMethod.GET)
	@ApiOperation(value = "Returns the total count of TypeRecruitment instances.")
	public Long countAllTypeRecruitments() {
		LOGGER.debug("counting TypeRecruitments");
		Long count = typeRecruitmentService.countAll();
		return count;
	}


    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @ApiOperation(value = "Returns the TypeRecruitment instance associated with the given id.")
    public TypeRecruitment getTypeRecruitment(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting TypeRecruitment with id: {}" , id);
        TypeRecruitment instance = typeRecruitmentService.findById(id);
        LOGGER.debug("TypeRecruitment details with id: {}" , instance);
        return instance;
    }
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @ApiOperation(value = "Deletes the TypeRecruitment instance associated with the given id.")
    public boolean deleteTypeRecruitment(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting TypeRecruitment with id: {}" , id);
        TypeRecruitment deleted = typeRecruitmentService.delete(id);
        return deleted != null;
    }

    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @ApiOperation(value = "Updates the TypeRecruitment instance associated with the given id.")
    public TypeRecruitment editTypeRecruitment(@PathVariable("id") Integer id, @RequestBody TypeRecruitment instance) throws EntityNotFoundException {
        LOGGER.debug("Editing TypeRecruitment with id: {}" , instance.getIdTypeRecruitment());
        instance.setIdTypeRecruitment(id);
        instance = typeRecruitmentService.update(instance);
        LOGGER.debug("TypeRecruitment details with id: {}" , instance);
        return instance;
    }


    @RequestMapping(value="/{id:.+}/employees", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the employees instance associated with the given id.")
     public Page<Employee> findAssociatedemployees(Pageable pageable, @PathVariable("id") Integer id){
        LOGGER.debug("Fetching all associated employees");
        return employeeService.findAssociatedValues(id,"typeRecruitment","idTypeRecruitment", pageable);
   }



	@RequestMapping(value = "/", method = RequestMethod.POST)
	@ApiOperation(value = "Creates a new TypeRecruitment instance.")
	public TypeRecruitment createTypeRecruitment(@RequestBody TypeRecruitment instance) {
		LOGGER.debug("Create TypeRecruitment with information: {}" , instance);
		instance = typeRecruitmentService.create(instance);
		LOGGER.debug("Created TypeRecruitment with information: {}" , instance);
	    return instance;
	}

	/**
	 * This setter method should only be used by unit tests
	 * 
	 * @param service
	 */
	protected void setTypeRecruitmentService(TypeRecruitmentService service) {
		this.typeRecruitmentService = service;
	}
}

