/*Copyright (c) 2016-2017 gmail.com All Rights Reserved.
 This software is the confidential and proprietary information of gmail.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with gmail.com*/

package com.test_25feb.dynamohr126tabs.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/





import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.wavemaker.runtime.data.dao.*;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.exception.EntityNotFoundException;

import com.test_25feb.dynamohr126tabs.*;


/**
 * ServiceImpl object for domain model class ListAssetLoaded.
 * @see com.test_25feb.dynamohr126tabs.ListAssetLoaded
 */
@Service("Dynamohr126tabs.ListAssetLoadedService")
public class ListAssetLoadedServiceImpl implements ListAssetLoadedService {


    private static final Logger LOGGER = LoggerFactory.getLogger(ListAssetLoadedServiceImpl.class);

    @Autowired
    @Qualifier("Dynamohr126tabs.ListAssetLoadedDao")
    private WMGenericDao<ListAssetLoaded, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<ListAssetLoaded, Integer> wmGenericDao){
        this.wmGenericDao = wmGenericDao;
    }
     @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
     public Page<ListAssetLoaded> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable){
          LOGGER.debug("Fetching all associated");
          return this.wmGenericDao.getAssociatedObjects(value, entityName, key, pageable);
     }

    @Transactional(value = "Dynamohr126tabsTransactionManager")
    @Override
    public ListAssetLoaded create(ListAssetLoaded listassetloaded) {
        LOGGER.debug("Creating a new listassetloaded with information: {}" , listassetloaded);
        return this.wmGenericDao.create(listassetloaded);
    }

    @Transactional(rollbackFor = EntityNotFoundException.class, value = "Dynamohr126tabsTransactionManager")
    @Override
    public ListAssetLoaded delete(Integer listassetloadedId) throws EntityNotFoundException {
        LOGGER.debug("Deleting listassetloaded with id: {}" , listassetloadedId);
        ListAssetLoaded deleted = this.wmGenericDao.findById(listassetloadedId);
        if (deleted == null) {
            LOGGER.debug("No listassetloaded found with id: {}" , listassetloadedId);
            throw new EntityNotFoundException(String.valueOf(listassetloadedId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
    @Override
    public Page<ListAssetLoaded> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all listassetloadeds");
        return this.wmGenericDao.search(queryFilters, pageable);
    }
    
    @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
    @Override
    public Page<ListAssetLoaded> findAll(Pageable pageable) {
        LOGGER.debug("Finding all listassetloadeds");
        return this.wmGenericDao.search(null, pageable);
    }

    @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
    @Override
    public ListAssetLoaded findById(Integer id) throws EntityNotFoundException {
        LOGGER.debug("Finding listassetloaded by id: {}" , id);
        ListAssetLoaded listassetloaded=this.wmGenericDao.findById(id);
        if(listassetloaded==null){
            LOGGER.debug("No listassetloaded found with id: {}" , id);
            throw new EntityNotFoundException(String.valueOf(id));
        }
        return listassetloaded;
    }
    @Transactional(rollbackFor = EntityNotFoundException.class, value = "Dynamohr126tabsTransactionManager")
    @Override
    public ListAssetLoaded update(ListAssetLoaded updated) throws EntityNotFoundException {
        LOGGER.debug("Updating listassetloaded with information: {}" , updated);
        this.wmGenericDao.update(updated);

        Integer id = (Integer)updated.getIdListAssetLoaded();

        return this.wmGenericDao.findById(id);
    }

    @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
    @Override
    public long countAll() {
        return this.wmGenericDao.count();
    }
}

