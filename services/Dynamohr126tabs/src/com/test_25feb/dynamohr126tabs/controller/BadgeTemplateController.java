/*Copyright (c) 2016-2017 gmail.com All Rights Reserved.
 This software is the confidential and proprietary information of gmail.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with gmail.com*/

package com.test_25feb.dynamohr126tabs.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import com.test_25feb.dynamohr126tabs.service.BadgeTemplateService;


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
 * Controller object for domain model class BadgeTemplate.
 * @see com.test_25feb.dynamohr126tabs.BadgeTemplate
 */

@RestController(value = "Dynamohr126tabs.BadgeTemplateController")
@Api(value = "/Dynamohr126tabs/BadgeTemplate", description = "Exposes APIs to work with BadgeTemplate resource.")
@RequestMapping("/Dynamohr126tabs/BadgeTemplate")
public class BadgeTemplateController {

    private static final Logger LOGGER = LoggerFactory.getLogger(BadgeTemplateController.class);

	@Autowired
	@Qualifier("Dynamohr126tabs.BadgeTemplateService")
	private BadgeTemplateService badgeTemplateService;


	@RequestMapping(value = "/search", method = RequestMethod.POST)
	@ApiOperation(value = "Returns the list of BadgeTemplate instances matching the search criteria.")
	public Page<BadgeTemplate> findBadgeTemplates( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
		LOGGER.debug("Rendering BadgeTemplates list");
		return badgeTemplateService.findAll(queryFilters, pageable);
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ApiOperation(value = "Returns the list of BadgeTemplate instances.")
	public Page<BadgeTemplate> getBadgeTemplates(Pageable pageable) {
		LOGGER.debug("Rendering BadgeTemplates list");
		return badgeTemplateService.findAll(pageable);
	}

	@RequestMapping(value = "/count", method = RequestMethod.GET)
	@ApiOperation(value = "Returns the total count of BadgeTemplate instances.")
	public Long countAllBadgeTemplates() {
		LOGGER.debug("counting BadgeTemplates");
		Long count = badgeTemplateService.countAll();
		return count;
	}


    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @ApiOperation(value = "Returns the BadgeTemplate instance associated with the given id.")
    public BadgeTemplate getBadgeTemplate(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting BadgeTemplate with id: {}" , id);
        BadgeTemplate instance = badgeTemplateService.findById(id);
        LOGGER.debug("BadgeTemplate details with id: {}" , instance);
        return instance;
    }
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @ApiOperation(value = "Deletes the BadgeTemplate instance associated with the given id.")
    public boolean deleteBadgeTemplate(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting BadgeTemplate with id: {}" , id);
        BadgeTemplate deleted = badgeTemplateService.delete(id);
        return deleted != null;
    }

    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @ApiOperation(value = "Updates the BadgeTemplate instance associated with the given id.")
    public BadgeTemplate editBadgeTemplate(@PathVariable("id") Integer id, @RequestBody BadgeTemplate instance) throws EntityNotFoundException {
        LOGGER.debug("Editing BadgeTemplate with id: {}" , instance.getIdBadgeTemplate());
        instance.setIdBadgeTemplate(id);
        instance = badgeTemplateService.update(instance);
        LOGGER.debug("BadgeTemplate details with id: {}" , instance);
        return instance;
    }

    @RequestMapping(value = "/{id:.+}", method = RequestMethod.POST, consumes = {"multipart/form-data"})
    @ApiOperation(value = "Updates the BadgeTemplate instance associated with the given id.This API should be used when BadgeTemplate instance fields that require multipart data.")
    public BadgeTemplate editBadgeTemplate(@PathVariable("id") Integer id, MultipartHttpServletRequest multipartHttpServletRequest) throws EntityNotFoundException {
        BadgeTemplate newbadgetemplate = WMMultipartUtils.toObject(multipartHttpServletRequest,BadgeTemplate.class,"Dynamohr126tabs");
        newbadgetemplate.setIdBadgeTemplate(id);
        BadgeTemplate oldbadgetemplate = badgeTemplateService.findById(id);
        WMMultipartUtils.updateLobsContent(oldbadgetemplate,newbadgetemplate);
        LOGGER.debug("Updating badgetemplate with information: {}" , newbadgetemplate);
        return badgeTemplateService.update(newbadgetemplate);
    }
    @RequestMapping(value = "/{id}/content/{fieldName}", method = RequestMethod.GET, produces="application/octet-stream")
    @ApiOperation(value = "Retrieves content for the given BLOB field in BadgeTemplate instance" )
    public DownloadResponse getBadgeTemplateBLOBContent(@PathVariable("id") Integer id,@PathVariable("fieldName") String fieldName,HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @RequestParam( value="download", defaultValue = "false") boolean download) {
        LOGGER.debug("Retrieves content for the given BLOB field {} in BadgeTemplate instance" , fieldName);
        if(!WMRuntimeUtils.isLob(BadgeTemplate.class,fieldName)) {
            throw new TypeMismatchException("Given field " + fieldName + " is not a valid BLOB type");
        }
        BadgeTemplate instance = badgeTemplateService.findById(id);
        return WMMultipartUtils.buildDownloadResponseForBlob(instance, fieldName, httpServletRequest, download);
    }



	@RequestMapping(value = "/", method = RequestMethod.POST)
	@ApiOperation(value = "Creates a new BadgeTemplate instance.")
	public BadgeTemplate createBadgeTemplate(@RequestBody BadgeTemplate instance) {
		LOGGER.debug("Create BadgeTemplate with information: {}" , instance);
		instance = badgeTemplateService.create(instance);
		LOGGER.debug("Created BadgeTemplate with information: {}" , instance);
	    return instance;
	}

	@RequestMapping(value = "/", method = RequestMethod.POST, consumes = {"multipart/form-data"})
	@ApiOperation(value = "Creates a new BadgeTemplate instance.This API should be used when the BadgeTemplate instance has fields that requires multipart data.")
    public BadgeTemplate createBadgeTemplate(MultipartHttpServletRequest multipartHttpServletRequest) {
    	BadgeTemplate badgetemplate = WMMultipartUtils.toObject(multipartHttpServletRequest,BadgeTemplate.class,"Dynamohr126tabs");
        LOGGER.debug("Creating a new badgetemplate with information: {}" , badgetemplate);
        return badgeTemplateService.create(badgetemplate);
    }

	/**
	 * This setter method should only be used by unit tests
	 * 
	 * @param service
	 */
	protected void setBadgeTemplateService(BadgeTemplateService service) {
		this.badgeTemplateService = service;
	}
}
