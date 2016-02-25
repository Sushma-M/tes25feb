/*Copyright (c) 2016-2017 gmail.com All Rights Reserved.
 This software is the confidential and proprietary information of gmail.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with gmail.com*/

package com.test_25feb.dynamohr126tabs.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import com.test_25feb.dynamohr126tabs.service.ListRolePermissionService;
import com.test_25feb.dynamohr126tabs.service.RolePermissionService;


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
 * Controller object for domain model class RolePermission.
 * @see com.test_25feb.dynamohr126tabs.RolePermission
 */

@RestController(value = "Dynamohr126tabs.RolePermissionController")
@Api(value = "/Dynamohr126tabs/RolePermission", description = "Exposes APIs to work with RolePermission resource.")
@RequestMapping("/Dynamohr126tabs/RolePermission")
public class RolePermissionController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RolePermissionController.class);

	@Autowired
	@Qualifier("Dynamohr126tabs.RolePermissionService")
	private RolePermissionService rolePermissionService;


    @Autowired
    @Qualifier("Dynamohr126tabs.ListRolePermissionService")
    private ListRolePermissionService listRolePermissionService;


	@RequestMapping(value = "/search", method = RequestMethod.POST)
	@ApiOperation(value = "Returns the list of RolePermission instances matching the search criteria.")
	public Page<RolePermission> findRolePermissions( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
		LOGGER.debug("Rendering RolePermissions list");
		return rolePermissionService.findAll(queryFilters, pageable);
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ApiOperation(value = "Returns the list of RolePermission instances.")
	public Page<RolePermission> getRolePermissions(Pageable pageable) {
		LOGGER.debug("Rendering RolePermissions list");
		return rolePermissionService.findAll(pageable);
	}

	@RequestMapping(value = "/count", method = RequestMethod.GET)
	@ApiOperation(value = "Returns the total count of RolePermission instances.")
	public Long countAllRolePermissions() {
		LOGGER.debug("counting RolePermissions");
		Long count = rolePermissionService.countAll();
		return count;
	}


    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @ApiOperation(value = "Returns the RolePermission instance associated with the given id.")
    public RolePermission getRolePermission(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting RolePermission with id: {}" , id);
        RolePermission instance = rolePermissionService.findById(id);
        LOGGER.debug("RolePermission details with id: {}" , instance);
        return instance;
    }
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @ApiOperation(value = "Deletes the RolePermission instance associated with the given id.")
    public boolean deleteRolePermission(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting RolePermission with id: {}" , id);
        RolePermission deleted = rolePermissionService.delete(id);
        return deleted != null;
    }

    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @ApiOperation(value = "Updates the RolePermission instance associated with the given id.")
    public RolePermission editRolePermission(@PathVariable("id") Integer id, @RequestBody RolePermission instance) throws EntityNotFoundException {
        LOGGER.debug("Editing RolePermission with id: {}" , instance.getIdRolePermission());
        instance.setIdRolePermission(id);
        instance = rolePermissionService.update(instance);
        LOGGER.debug("RolePermission details with id: {}" , instance);
        return instance;
    }


    @RequestMapping(value="/{id:.+}/listRolePermissions", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the listRolePermissions instance associated with the given id.")
     public Page<ListRolePermission> findAssociatedlistRolePermissions(Pageable pageable, @PathVariable("id") Integer id){
        LOGGER.debug("Fetching all associated listRolePermissions");
        return listRolePermissionService.findAssociatedValues(id,"rolePermission","idRolePermission", pageable);
   }



	@RequestMapping(value = "/", method = RequestMethod.POST)
	@ApiOperation(value = "Creates a new RolePermission instance.")
	public RolePermission createRolePermission(@RequestBody RolePermission instance) {
		LOGGER.debug("Create RolePermission with information: {}" , instance);
		instance = rolePermissionService.create(instance);
		LOGGER.debug("Created RolePermission with information: {}" , instance);
	    return instance;
	}

	/**
	 * This setter method should only be used by unit tests
	 * 
	 * @param service
	 */
	protected void setRolePermissionService(RolePermissionService service) {
		this.rolePermissionService = service;
	}
}

