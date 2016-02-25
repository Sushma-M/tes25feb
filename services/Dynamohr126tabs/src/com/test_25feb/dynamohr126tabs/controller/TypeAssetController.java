/*Copyright (c) 2016-2017 gmail.com All Rights Reserved.
 This software is the confidential and proprietary information of gmail.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with gmail.com*/

package com.test_25feb.dynamohr126tabs.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import com.test_25feb.dynamohr126tabs.service.AssetService;
import com.test_25feb.dynamohr126tabs.service.TypeAssetService;


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
 * Controller object for domain model class TypeAsset.
 * @see com.test_25feb.dynamohr126tabs.TypeAsset
 */

@RestController(value = "Dynamohr126tabs.TypeAssetController")
@Api(value = "/Dynamohr126tabs/TypeAsset", description = "Exposes APIs to work with TypeAsset resource.")
@RequestMapping("/Dynamohr126tabs/TypeAsset")
public class TypeAssetController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TypeAssetController.class);

	@Autowired
	@Qualifier("Dynamohr126tabs.TypeAssetService")
	private TypeAssetService typeAssetService;


    @Autowired
    @Qualifier("Dynamohr126tabs.AssetService")
    private AssetService assetService;


	@RequestMapping(value = "/search", method = RequestMethod.POST)
	@ApiOperation(value = "Returns the list of TypeAsset instances matching the search criteria.")
	public Page<TypeAsset> findTypeAssets( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
		LOGGER.debug("Rendering TypeAssets list");
		return typeAssetService.findAll(queryFilters, pageable);
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ApiOperation(value = "Returns the list of TypeAsset instances.")
	public Page<TypeAsset> getTypeAssets(Pageable pageable) {
		LOGGER.debug("Rendering TypeAssets list");
		return typeAssetService.findAll(pageable);
	}

	@RequestMapping(value = "/count", method = RequestMethod.GET)
	@ApiOperation(value = "Returns the total count of TypeAsset instances.")
	public Long countAllTypeAssets() {
		LOGGER.debug("counting TypeAssets");
		Long count = typeAssetService.countAll();
		return count;
	}


    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @ApiOperation(value = "Returns the TypeAsset instance associated with the given id.")
    public TypeAsset getTypeAsset(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting TypeAsset with id: {}" , id);
        TypeAsset instance = typeAssetService.findById(id);
        LOGGER.debug("TypeAsset details with id: {}" , instance);
        return instance;
    }
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @ApiOperation(value = "Deletes the TypeAsset instance associated with the given id.")
    public boolean deleteTypeAsset(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting TypeAsset with id: {}" , id);
        TypeAsset deleted = typeAssetService.delete(id);
        return deleted != null;
    }

    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @ApiOperation(value = "Updates the TypeAsset instance associated with the given id.")
    public TypeAsset editTypeAsset(@PathVariable("id") Integer id, @RequestBody TypeAsset instance) throws EntityNotFoundException {
        LOGGER.debug("Editing TypeAsset with id: {}" , instance.getIdTypeAsset());
        instance.setIdTypeAsset(id);
        instance = typeAssetService.update(instance);
        LOGGER.debug("TypeAsset details with id: {}" , instance);
        return instance;
    }


    @RequestMapping(value="/{id:.+}/assets", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the assets instance associated with the given id.")
     public Page<Asset> findAssociatedassets(Pageable pageable, @PathVariable("id") Integer id){
        LOGGER.debug("Fetching all associated assets");
        return assetService.findAssociatedValues(id,"typeAsset","idTypeAsset", pageable);
   }



	@RequestMapping(value = "/", method = RequestMethod.POST)
	@ApiOperation(value = "Creates a new TypeAsset instance.")
	public TypeAsset createTypeAsset(@RequestBody TypeAsset instance) {
		LOGGER.debug("Create TypeAsset with information: {}" , instance);
		instance = typeAssetService.create(instance);
		LOGGER.debug("Created TypeAsset with information: {}" , instance);
	    return instance;
	}

	/**
	 * This setter method should only be used by unit tests
	 * 
	 * @param service
	 */
	protected void setTypeAssetService(TypeAssetService service) {
		this.typeAssetService = service;
	}
}
