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
 * ServiceImpl object for domain model class Month.
 * @see com.test_25feb.dynamohr126tabs.Month
 */
@Service("Dynamohr126tabs.MonthService")
public class MonthServiceImpl implements MonthService {


    private static final Logger LOGGER = LoggerFactory.getLogger(MonthServiceImpl.class);

    @Autowired
    @Qualifier("Dynamohr126tabs.MonthDao")
    private WMGenericDao<Month, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Month, Integer> wmGenericDao){
        this.wmGenericDao = wmGenericDao;
    }
     @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
     public Page<Month> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable){
          LOGGER.debug("Fetching all associated");
          return this.wmGenericDao.getAssociatedObjects(value, entityName, key, pageable);
     }

    @Transactional(value = "Dynamohr126tabsTransactionManager")
    @Override
    public Month create(Month month) {
        LOGGER.debug("Creating a new month with information: {}" , month);
        return this.wmGenericDao.create(month);
    }

    @Transactional(rollbackFor = EntityNotFoundException.class, value = "Dynamohr126tabsTransactionManager")
    @Override
    public Month delete(Integer monthId) throws EntityNotFoundException {
        LOGGER.debug("Deleting month with id: {}" , monthId);
        Month deleted = this.wmGenericDao.findById(monthId);
        if (deleted == null) {
            LOGGER.debug("No month found with id: {}" , monthId);
            throw new EntityNotFoundException(String.valueOf(monthId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
    @Override
    public Page<Month> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all months");
        return this.wmGenericDao.search(queryFilters, pageable);
    }
    
    @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
    @Override
    public Page<Month> findAll(Pageable pageable) {
        LOGGER.debug("Finding all months");
        return this.wmGenericDao.search(null, pageable);
    }

    @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
    @Override
    public Month findById(Integer id) throws EntityNotFoundException {
        LOGGER.debug("Finding month by id: {}" , id);
        Month month=this.wmGenericDao.findById(id);
        if(month==null){
            LOGGER.debug("No month found with id: {}" , id);
            throw new EntityNotFoundException(String.valueOf(id));
        }
        return month;
    }
    @Transactional(rollbackFor = EntityNotFoundException.class, value = "Dynamohr126tabsTransactionManager")
    @Override
    public Month update(Month updated) throws EntityNotFoundException {
        LOGGER.debug("Updating month with information: {}" , updated);
        this.wmGenericDao.update(updated);

        Integer id = (Integer)updated.getIdMonth();

        return this.wmGenericDao.findById(id);
    }

    @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
    @Override
    public long countAll() {
        return this.wmGenericDao.count();
    }
}

