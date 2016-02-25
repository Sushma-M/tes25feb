/*Copyright (c) 2016-2017 gmail.com All Rights Reserved.
 This software is the confidential and proprietary information of gmail.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with gmail.com*/

package com.test_25feb.dynamohr126tabs.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import com.test_25feb.dynamohr126tabs.service.AssetDischargeDocumentService;
import com.test_25feb.dynamohr126tabs.service.ListAssetUnloadedService;


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
 * Controller object for domain model class AssetDischargeDocument.
 * @see com.test_25feb.dynamohr126tabs.AssetDischargeDocument
 */

@RestController(value = "Dynamohr126tabs.AssetDischargeDocumentController")
@Api(value = "/Dynamohr126tabs/AssetDischargeDocument", description = "Exposes APIs to work with AssetDischargeDocument resource.")
@RequestMapping("/Dynamohr126tabs/AssetDischargeDocument")
public class AssetDischargeDocumentController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AssetDischargeDocumentController.class);

	@Autowired
	@Qualifier("Dynamohr126tabs.AssetDischargeDocumentService")
	private AssetDischargeDocumentService assetDischargeDocumentService;


    @Autowired
    @Qualifier("Dynamohr126tabs.ListAssetUnloadedService")
    private ListAssetUnloadedService listAssetUnloadedService;


	@RequestMapping(value = "/search", method = RequestMethod.POST)
	@ApiOperation(value = "Returns the list of AssetDischargeDocument instances matching the search criteria.")
	public Page<AssetDischargeDocument> findAssetDischargeDocuments( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
		LOGGER.debug("Rendering AssetDischargeDocuments list");
		return assetDischargeDocumentService.findAll(queryFilters, pageable);
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ApiOperation(value = "Returns the list of AssetDischargeDocument instances.")
	public Page<AssetDischargeDocument> getAssetDischargeDocuments(Pageable pageable) {
		LOGGER.debug("Rendering AssetDischargeDocuments list");
		return assetDischargeDocumentService.findAll(pageable);
	}

	@RequestMapping(value = "/count", method = RequestMethod.GET)
	@ApiOperation(value = "Returns the total count of AssetDischargeDocument instances.")
	public Long countAllAssetDischargeDocuments() {
		LOGGER.debug("counting AssetDischargeDocuments");
		Long count = assetDischargeDocumentService.countAll();
		return count;
	}


    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @ApiOperation(value = "Returns the AssetDischargeDocument instance associated with the given id.")
    public AssetDischargeDocument getAssetDischargeDocument(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting AssetDischargeDocument with id: {}" , id);
        AssetDischargeDocument instance = assetDischargeDocumentService.findById(id);
        LOGGER.debug("AssetDischargeDocument details with id: {}" , instance);
        return instance;
    }
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @ApiOperation(value = "Deletes the AssetDischargeDocument instance associated with the given id.")
    public boolean deleteAssetDischargeDocument(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting AssetDischargeDocument with id: {}" , id);
        AssetDischargeDocument deleted = assetDischargeDocumentService.delete(id);
        return deleted != null;
    }

    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @ApiOperation(value = "Updates the AssetDischargeDocument instance associated with the given id.")
    public AssetDischargeDocument editAssetDischargeDocument(@PathVariable("id") Integer id, @RequestBody AssetDischargeDocument instance) throws EntityNotFoundException {
        LOGGER.debug("Editing AssetDischargeDocument with id: {}" , instance.getIdAssetDischargeDocument());
        instance.setIdAssetDischargeDocument(id);
        instance = assetDischargeDocumentService.update(instance);
        LOGGER.debug("AssetDischargeDocument details with id: {}" , instance);
        return instance;
    }


    @RequestMapping(value="/{id:.+}/listAssetUnloadeds", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the listAssetUnloadeds instance associated with the given id.")
     public Page<ListAssetUnloaded> findAssociatedlistAssetUnloadeds(Pageable pageable, @PathVariable("id") Integer id){
        LOGGER.debug("Fetching all associated listAssetUnloadeds");
        return listAssetUnloadedService.findAssociatedValues(id,"assetDischargeDocument","idAssetDischargeDocument", pageable);
   }



	@RequestMapping(value = "/", method = RequestMethod.POST)
	@ApiOperation(value = "Creates a new AssetDischargeDocument instance.")
	public AssetDischargeDocument createAssetDischargeDocument(@RequestBody AssetDischargeDocument instance) {
		LOGGER.debug("Create AssetDischargeDocument with information: {}" , instance);
		instance = assetDischargeDocumentService.create(instance);
		LOGGER.debug("Created AssetDischargeDocument with information: {}" , instance);
	    return instance;
	}

	/**
	 * This setter method should only be used by unit tests
	 * 
	 * @param service
	 */
	protected void setAssetDischargeDocumentService(AssetDischargeDocumentService service) {
		this.assetDischargeDocumentService = service;
	}
}
