/*Copyright (c) 2016-2017 gmail.com All Rights Reserved.
 This software is the confidential and proprietary information of gmail.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with gmail.com*/

package com.test_25feb.dynamohr126tabs.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import com.test_25feb.dynamohr126tabs.service.AssetFileService;


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
 * Controller object for domain model class AssetFile.
 * @see com.test_25feb.dynamohr126tabs.AssetFile
 */

@RestController(value = "Dynamohr126tabs.AssetFileController")
@Api(value = "/Dynamohr126tabs/AssetFile", description = "Exposes APIs to work with AssetFile resource.")
@RequestMapping("/Dynamohr126tabs/AssetFile")
public class AssetFileController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AssetFileController.class);

	@Autowired
	@Qualifier("Dynamohr126tabs.AssetFileService")
	private AssetFileService assetFileService;


	@RequestMapping(value = "/search", method = RequestMethod.POST)
	@ApiOperation(value = "Returns the list of AssetFile instances matching the search criteria.")
	public Page<AssetFile> findAssetFiles( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
		LOGGER.debug("Rendering AssetFiles list");
		return assetFileService.findAll(queryFilters, pageable);
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ApiOperation(value = "Returns the list of AssetFile instances.")
	public Page<AssetFile> getAssetFiles(Pageable pageable) {
		LOGGER.debug("Rendering AssetFiles list");
		return assetFileService.findAll(pageable);
	}

	@RequestMapping(value = "/count", method = RequestMethod.GET)
	@ApiOperation(value = "Returns the total count of AssetFile instances.")
	public Long countAllAssetFiles() {
		LOGGER.debug("counting AssetFiles");
		Long count = assetFileService.countAll();
		return count;
	}


    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @ApiOperation(value = "Returns the AssetFile instance associated with the given id.")
    public AssetFile getAssetFile(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting AssetFile with id: {}" , id);
        AssetFile instance = assetFileService.findById(id);
        LOGGER.debug("AssetFile details with id: {}" , instance);
        return instance;
    }
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @ApiOperation(value = "Deletes the AssetFile instance associated with the given id.")
    public boolean deleteAssetFile(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting AssetFile with id: {}" , id);
        AssetFile deleted = assetFileService.delete(id);
        return deleted != null;
    }

    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @ApiOperation(value = "Updates the AssetFile instance associated with the given id.")
    public AssetFile editAssetFile(@PathVariable("id") Integer id, @RequestBody AssetFile instance) throws EntityNotFoundException {
        LOGGER.debug("Editing AssetFile with id: {}" , instance.getIdAssetFile());
        instance.setIdAssetFile(id);
        instance = assetFileService.update(instance);
        LOGGER.debug("AssetFile details with id: {}" , instance);
        return instance;
    }




	@RequestMapping(value = "/", method = RequestMethod.POST)
	@ApiOperation(value = "Creates a new AssetFile instance.")
	public AssetFile createAssetFile(@RequestBody AssetFile instance) {
		LOGGER.debug("Create AssetFile with information: {}" , instance);
		instance = assetFileService.create(instance);
		LOGGER.debug("Created AssetFile with information: {}" , instance);
	    return instance;
	}

	/**
	 * This setter method should only be used by unit tests
	 * 
	 * @param service
	 */
	protected void setAssetFileService(AssetFileService service) {
		this.assetFileService = service;
	}
}
