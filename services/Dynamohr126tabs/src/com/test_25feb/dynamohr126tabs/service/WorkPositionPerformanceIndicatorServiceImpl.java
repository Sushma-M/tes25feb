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
 * ServiceImpl object for domain model class WorkPositionPerformanceIndicator.
 * @see com.test_25feb.dynamohr126tabs.WorkPositionPerformanceIndicator
 */
@Service("Dynamohr126tabs.WorkPositionPerformanceIndicatorService")
public class WorkPositionPerformanceIndicatorServiceImpl implements WorkPositionPerformanceIndicatorService {


    private static final Logger LOGGER = LoggerFactory.getLogger(WorkPositionPerformanceIndicatorServiceImpl.class);

    @Autowired
    @Qualifier("Dynamohr126tabs.WorkPositionPerformanceIndicatorDao")
    private WMGenericDao<WorkPositionPerformanceIndicator, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<WorkPositionPerformanceIndicator, Integer> wmGenericDao){
        this.wmGenericDao = wmGenericDao;
    }
     @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
     public Page<WorkPositionPerformanceIndicator> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable){
          LOGGER.debug("Fetching all associated");
          return this.wmGenericDao.getAssociatedObjects(value, entityName, key, pageable);
     }

    @Transactional(value = "Dynamohr126tabsTransactionManager")
    @Override
    public WorkPositionPerformanceIndicator create(WorkPositionPerformanceIndicator workpositionperformanceindicator) {
        LOGGER.debug("Creating a new workpositionperformanceindicator with information: {}" , workpositionperformanceindicator);
        return this.wmGenericDao.create(workpositionperformanceindicator);
    }

    @Transactional(rollbackFor = EntityNotFoundException.class, value = "Dynamohr126tabsTransactionManager")
    @Override
    public WorkPositionPerformanceIndicator delete(Integer workpositionperformanceindicatorId) throws EntityNotFoundException {
        LOGGER.debug("Deleting workpositionperformanceindicator with id: {}" , workpositionperformanceindicatorId);
        WorkPositionPerformanceIndicator deleted = this.wmGenericDao.findById(workpositionperformanceindicatorId);
        if (deleted == null) {
            LOGGER.debug("No workpositionperformanceindicator found with id: {}" , workpositionperformanceindicatorId);
            throw new EntityNotFoundException(String.valueOf(workpositionperformanceindicatorId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
    @Override
    public Page<WorkPositionPerformanceIndicator> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all workpositionperformanceindicators");
        return this.wmGenericDao.search(queryFilters, pageable);
    }
    
    @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
    @Override
    public Page<WorkPositionPerformanceIndicator> findAll(Pageable pageable) {
        LOGGER.debug("Finding all workpositionperformanceindicators");
        return this.wmGenericDao.search(null, pageable);
    }

    @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
    @Override
    public WorkPositionPerformanceIndicator findById(Integer id) throws EntityNotFoundException {
        LOGGER.debug("Finding workpositionperformanceindicator by id: {}" , id);
        WorkPositionPerformanceIndicator workpositionperformanceindicator=this.wmGenericDao.findById(id);
        if(workpositionperformanceindicator==null){
            LOGGER.debug("No workpositionperformanceindicator found with id: {}" , id);
            throw new EntityNotFoundException(String.valueOf(id));
        }
        return workpositionperformanceindicator;
    }
    @Transactional(rollbackFor = EntityNotFoundException.class, value = "Dynamohr126tabsTransactionManager")
    @Override
    public WorkPositionPerformanceIndicator update(WorkPositionPerformanceIndicator updated) throws EntityNotFoundException {
        LOGGER.debug("Updating workpositionperformanceindicator with information: {}" , updated);
        this.wmGenericDao.update(updated);

        Integer id = (Integer)updated.getIdWorkPositionPerformanceIndicator();

        return this.wmGenericDao.findById(id);
    }

    @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
    @Override
    public long countAll() {
        return this.wmGenericDao.count();
    }
}

