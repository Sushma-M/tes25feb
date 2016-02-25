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
 * ServiceImpl object for domain model class JustifiedTravelExpenseFile.
 * @see com.test_25feb.dynamohr126tabs.JustifiedTravelExpenseFile
 */
@Service("Dynamohr126tabs.JustifiedTravelExpenseFileService")
public class JustifiedTravelExpenseFileServiceImpl implements JustifiedTravelExpenseFileService {


    private static final Logger LOGGER = LoggerFactory.getLogger(JustifiedTravelExpenseFileServiceImpl.class);

    @Autowired
    @Qualifier("Dynamohr126tabs.JustifiedTravelExpenseFileDao")
    private WMGenericDao<JustifiedTravelExpenseFile, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<JustifiedTravelExpenseFile, Integer> wmGenericDao){
        this.wmGenericDao = wmGenericDao;
    }
     @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
     public Page<JustifiedTravelExpenseFile> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable){
          LOGGER.debug("Fetching all associated");
          return this.wmGenericDao.getAssociatedObjects(value, entityName, key, pageable);
     }

    @Transactional(value = "Dynamohr126tabsTransactionManager")
    @Override
    public JustifiedTravelExpenseFile create(JustifiedTravelExpenseFile justifiedtravelexpensefile) {
        LOGGER.debug("Creating a new justifiedtravelexpensefile with information: {}" , justifiedtravelexpensefile);
        return this.wmGenericDao.create(justifiedtravelexpensefile);
    }

    @Transactional(rollbackFor = EntityNotFoundException.class, value = "Dynamohr126tabsTransactionManager")
    @Override
    public JustifiedTravelExpenseFile delete(Integer justifiedtravelexpensefileId) throws EntityNotFoundException {
        LOGGER.debug("Deleting justifiedtravelexpensefile with id: {}" , justifiedtravelexpensefileId);
        JustifiedTravelExpenseFile deleted = this.wmGenericDao.findById(justifiedtravelexpensefileId);
        if (deleted == null) {
            LOGGER.debug("No justifiedtravelexpensefile found with id: {}" , justifiedtravelexpensefileId);
            throw new EntityNotFoundException(String.valueOf(justifiedtravelexpensefileId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
    @Override
    public Page<JustifiedTravelExpenseFile> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all justifiedtravelexpensefiles");
        return this.wmGenericDao.search(queryFilters, pageable);
    }
    
    @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
    @Override
    public Page<JustifiedTravelExpenseFile> findAll(Pageable pageable) {
        LOGGER.debug("Finding all justifiedtravelexpensefiles");
        return this.wmGenericDao.search(null, pageable);
    }

    @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
    @Override
    public JustifiedTravelExpenseFile findById(Integer id) throws EntityNotFoundException {
        LOGGER.debug("Finding justifiedtravelexpensefile by id: {}" , id);
        JustifiedTravelExpenseFile justifiedtravelexpensefile=this.wmGenericDao.findById(id);
        if(justifiedtravelexpensefile==null){
            LOGGER.debug("No justifiedtravelexpensefile found with id: {}" , id);
            throw new EntityNotFoundException(String.valueOf(id));
        }
        return justifiedtravelexpensefile;
    }
    @Transactional(rollbackFor = EntityNotFoundException.class, value = "Dynamohr126tabsTransactionManager")
    @Override
    public JustifiedTravelExpenseFile update(JustifiedTravelExpenseFile updated) throws EntityNotFoundException {
        LOGGER.debug("Updating justifiedtravelexpensefile with information: {}" , updated);
        this.wmGenericDao.update(updated);

        Integer id = (Integer)updated.getIdJustifiedTravelExpenseFile();

        return this.wmGenericDao.findById(id);
    }

    @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
    @Override
    public long countAll() {
        return this.wmGenericDao.count();
    }
}

