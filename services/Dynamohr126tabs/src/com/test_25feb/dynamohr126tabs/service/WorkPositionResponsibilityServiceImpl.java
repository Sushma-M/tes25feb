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
 * ServiceImpl object for domain model class WorkPositionResponsibility.
 * @see com.test_25feb.dynamohr126tabs.WorkPositionResponsibility
 */
@Service("Dynamohr126tabs.WorkPositionResponsibilityService")
public class WorkPositionResponsibilityServiceImpl implements WorkPositionResponsibilityService {


    private static final Logger LOGGER = LoggerFactory.getLogger(WorkPositionResponsibilityServiceImpl.class);

    @Autowired
    @Qualifier("Dynamohr126tabs.WorkPositionResponsibilityDao")
    private WMGenericDao<WorkPositionResponsibility, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<WorkPositionResponsibility, Integer> wmGenericDao){
        this.wmGenericDao = wmGenericDao;
    }
     @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
     public Page<WorkPositionResponsibility> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable){
          LOGGER.debug("Fetching all associated");
          return this.wmGenericDao.getAssociatedObjects(value, entityName, key, pageable);
     }

    @Transactional(value = "Dynamohr126tabsTransactionManager")
    @Override
    public WorkPositionResponsibility create(WorkPositionResponsibility workpositionresponsibility) {
        LOGGER.debug("Creating a new workpositionresponsibility with information: {}" , workpositionresponsibility);
        return this.wmGenericDao.create(workpositionresponsibility);
    }

    @Transactional(rollbackFor = EntityNotFoundException.class, value = "Dynamohr126tabsTransactionManager")
    @Override
    public WorkPositionResponsibility delete(Integer workpositionresponsibilityId) throws EntityNotFoundException {
        LOGGER.debug("Deleting workpositionresponsibility with id: {}" , workpositionresponsibilityId);
        WorkPositionResponsibility deleted = this.wmGenericDao.findById(workpositionresponsibilityId);
        if (deleted == null) {
            LOGGER.debug("No workpositionresponsibility found with id: {}" , workpositionresponsibilityId);
            throw new EntityNotFoundException(String.valueOf(workpositionresponsibilityId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
    @Override
    public Page<WorkPositionResponsibility> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all workpositionresponsibilitys");
        return this.wmGenericDao.search(queryFilters, pageable);
    }
    
    @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
    @Override
    public Page<WorkPositionResponsibility> findAll(Pageable pageable) {
        LOGGER.debug("Finding all workpositionresponsibilitys");
        return this.wmGenericDao.search(null, pageable);
    }

    @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
    @Override
    public WorkPositionResponsibility findById(Integer id) throws EntityNotFoundException {
        LOGGER.debug("Finding workpositionresponsibility by id: {}" , id);
        WorkPositionResponsibility workpositionresponsibility=this.wmGenericDao.findById(id);
        if(workpositionresponsibility==null){
            LOGGER.debug("No workpositionresponsibility found with id: {}" , id);
            throw new EntityNotFoundException(String.valueOf(id));
        }
        return workpositionresponsibility;
    }
    @Transactional(rollbackFor = EntityNotFoundException.class, value = "Dynamohr126tabsTransactionManager")
    @Override
    public WorkPositionResponsibility update(WorkPositionResponsibility updated) throws EntityNotFoundException {
        LOGGER.debug("Updating workpositionresponsibility with information: {}" , updated);
        this.wmGenericDao.update(updated);

        Integer id = (Integer)updated.getIdWorkPositionResponsibility();

        return this.wmGenericDao.findById(id);
    }

    @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
    @Override
    public long countAll() {
        return this.wmGenericDao.count();
    }
}

