/*Copyright (c) 2016-2017 gmail.com All Rights Reserved.
 This software is the confidential and proprietary information of gmail.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with gmail.com*/

package com.test_25feb.dynamohr126tabs.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import com.test_25feb.dynamohr126tabs.service.ListRolePermissionService;
import com.test_25feb.dynamohr126tabs.service.RoleService;
import com.test_25feb.dynamohr126tabs.service.UserService;


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
 * Controller object for domain model class Role.
 * @see com.test_25feb.dynamohr126tabs.Role
 */

@RestController(value = "Dynamohr126tabs.RoleController")
@Api(value = "/Dynamohr126tabs/Role", description = "Exposes APIs to work with Role resource.")
@RequestMapping("/Dynamohr126tabs/Role")
public class RoleController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RoleController.class);

	@Autowired
	@Qualifier("Dynamohr126tabs.RoleService")
	private RoleService roleService;


    @Autowired
    @Qualifier("Dynamohr126tabs.UserService")
    private UserService userService;


    @Autowired
    @Qualifier("Dynamohr126tabs.ListRolePermissionService")
    private ListRolePermissionService listRolePermissionService;


	@RequestMapping(value = "/search", method = RequestMethod.POST)
	@ApiOperation(value = "Returns the list of Role instances matching the search criteria.")
	public Page<Role> findRoles( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
		LOGGER.debug("Rendering Roles list");
		return roleService.findAll(queryFilters, pageable);
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ApiOperation(value = "Returns the list of Role instances.")
	public Page<Role> getRoles(Pageable pageable) {
		LOGGER.debug("Rendering Roles list");
		return roleService.findAll(pageable);
	}

	@RequestMapping(value = "/count", method = RequestMethod.GET)
	@ApiOperation(value = "Returns the total count of Role instances.")
	public Long countAllRoles() {
		LOGGER.debug("counting Roles");
		Long count = roleService.countAll();
		return count;
	}


    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @ApiOperation(value = "Returns the Role instance associated with the given id.")
    public Role getRole(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting Role with id: {}" , id);
        Role instance = roleService.findById(id);
        LOGGER.debug("Role details with id: {}" , instance);
        return instance;
    }
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @ApiOperation(value = "Deletes the Role instance associated with the given id.")
    public boolean deleteRole(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting Role with id: {}" , id);
        Role deleted = roleService.delete(id);
        return deleted != null;
    }

    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @ApiOperation(value = "Updates the Role instance associated with the given id.")
    public Role editRole(@PathVariable("id") Integer id, @RequestBody Role instance) throws EntityNotFoundException {
        LOGGER.debug("Editing Role with id: {}" , instance.getIdRole());
        instance.setIdRole(id);
        instance = roleService.update(instance);
        LOGGER.debug("Role details with id: {}" , instance);
        return instance;
    }


    @RequestMapping(value="/{id:.+}/users", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the users instance associated with the given id.")
     public Page<User> findAssociatedusers(Pageable pageable, @PathVariable("id") Integer id){
        LOGGER.debug("Fetching all associated users");
        return userService.findAssociatedValues(id,"role","idRole", pageable);
   }

    @RequestMapping(value="/{id:.+}/listRolePermissions", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the listRolePermissions instance associated with the given id.")
     public Page<ListRolePermission> findAssociatedlistRolePermissions(Pageable pageable, @PathVariable("id") Integer id){
        LOGGER.debug("Fetching all associated listRolePermissions");
        return listRolePermissionService.findAssociatedValues(id,"role","idRole", pageable);
   }



	@RequestMapping(value = "/", method = RequestMethod.POST)
	@ApiOperation(value = "Creates a new Role instance.")
	public Role createRole(@RequestBody Role instance) {
		LOGGER.debug("Create Role with information: {}" , instance);
		instance = roleService.create(instance);
		LOGGER.debug("Created Role with information: {}" , instance);
	    return instance;
	}

	/**
	 * This setter method should only be used by unit tests
	 * 
	 * @param service
	 */
	protected void setRoleService(RoleService service) {
		this.roleService = service;
	}
}

