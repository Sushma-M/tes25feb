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
 * ServiceImpl object for domain model class LogOperation.
 * @see com.test_25feb.dynamohr126tabs.LogOperation
 */
@Service("Dynamohr126tabs.LogOperationService")
public class LogOperationServiceImpl implements LogOperationService {


    private static final Logger LOGGER = LoggerFactory.getLogger(LogOperationServiceImpl.class);

    @Autowired
    @Qualifier("Dynamohr126tabs.LogOperationDao")
    private WMGenericDao<LogOperation, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<LogOperation, Integer> wmGenericDao){
        this.wmGenericDao = wmGenericDao;
    }
     @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
     public Page<LogOperation> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable){
          LOGGER.debug("Fetching all associated");
          return this.wmGenericDao.getAssociatedObjects(value, entityName, key, pageable);
     }

    @Transactional(value = "Dynamohr126tabsTransactionManager")
    @Override
    public LogOperation create(LogOperation logoperation) {
        LOGGER.debug("Creating a new logoperation with information: {}" , logoperation);
        return this.wmGenericDao.create(logoperation);
    }

    @Transactional(rollbackFor = EntityNotFoundException.class, value = "Dynamohr126tabsTransactionManager")
    @Override
    public LogOperation delete(Integer logoperationId) throws EntityNotFoundException {
        LOGGER.debug("Deleting logoperation with id: {}" , logoperationId);
        LogOperation deleted = this.wmGenericDao.findById(logoperationId);
        if (deleted == null) {
            LOGGER.debug("No logoperation found with id: {}" , logoperationId);
            throw new EntityNotFoundException(String.valueOf(logoperationId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
    @Override
    public Page<LogOperation> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all logoperations");
        return this.wmGenericDao.search(queryFilters, pageable);
    }
    
    @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
    @Override
    public Page<LogOperation> findAll(Pageable pageable) {
        LOGGER.debug("Finding all logoperations");
        return this.wmGenericDao.search(null, pageable);
    }

    @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
    @Override
    public LogOperation findById(Integer id) throws EntityNotFoundException {
        LOGGER.debug("Finding logoperation by id: {}" , id);
        LogOperation logoperation=this.wmGenericDao.findById(id);
        if(logoperation==null){
            LOGGER.debug("No logoperation found with id: {}" , id);
            throw new EntityNotFoundException(String.valueOf(id));
        }
        return logoperation;
    }
    @Transactional(rollbackFor = EntityNotFoundException.class, value = "Dynamohr126tabsTransactionManager")
    @Override
    public LogOperation update(LogOperation updated) throws EntityNotFoundException {
        LOGGER.debug("Updating logoperation with information: {}" , updated);
        this.wmGenericDao.update(updated);

        Integer id = (Integer)updated.getIdLogOperation();

        return this.wmGenericDao.findById(id);
    }

    @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
    @Override
    public long countAll() {
        return this.wmGenericDao.count();
    }
}


