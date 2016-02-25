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
 * ServiceImpl object for domain model class OverTimeEmployee.
 * @see com.test_25feb.dynamohr126tabs.OverTimeEmployee
 */
@Service("Dynamohr126tabs.OverTimeEmployeeService")
public class OverTimeEmployeeServiceImpl implements OverTimeEmployeeService {


    private static final Logger LOGGER = LoggerFactory.getLogger(OverTimeEmployeeServiceImpl.class);

    @Autowired
    @Qualifier("Dynamohr126tabs.OverTimeEmployeeDao")
    private WMGenericDao<OverTimeEmployee, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<OverTimeEmployee, Integer> wmGenericDao){
        this.wmGenericDao = wmGenericDao;
    }
     @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
     public Page<OverTimeEmployee> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable){
          LOGGER.debug("Fetching all associated");
          return this.wmGenericDao.getAssociatedObjects(value, entityName, key, pageable);
     }

    @Transactional(value = "Dynamohr126tabsTransactionManager")
    @Override
    public OverTimeEmployee create(OverTimeEmployee overtimeemployee) {
        LOGGER.debug("Creating a new overtimeemployee with information: {}" , overtimeemployee);
        return this.wmGenericDao.create(overtimeemployee);
    }

    @Transactional(rollbackFor = EntityNotFoundException.class, value = "Dynamohr126tabsTransactionManager")
    @Override
    public OverTimeEmployee delete(Integer overtimeemployeeId) throws EntityNotFoundException {
        LOGGER.debug("Deleting overtimeemployee with id: {}" , overtimeemployeeId);
        OverTimeEmployee deleted = this.wmGenericDao.findById(overtimeemployeeId);
        if (deleted == null) {
            LOGGER.debug("No overtimeemployee found with id: {}" , overtimeemployeeId);
            throw new EntityNotFoundException(String.valueOf(overtimeemployeeId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
    @Override
    public Page<OverTimeEmployee> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all overtimeemployees");
        return this.wmGenericDao.search(queryFilters, pageable);
    }
    
    @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
    @Override
    public Page<OverTimeEmployee> findAll(Pageable pageable) {
        LOGGER.debug("Finding all overtimeemployees");
        return this.wmGenericDao.search(null, pageable);
    }

    @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
    @Override
    public OverTimeEmployee findById(Integer id) throws EntityNotFoundException {
        LOGGER.debug("Finding overtimeemployee by id: {}" , id);
        OverTimeEmployee overtimeemployee=this.wmGenericDao.findById(id);
        if(overtimeemployee==null){
            LOGGER.debug("No overtimeemployee found with id: {}" , id);
            throw new EntityNotFoundException(String.valueOf(id));
        }
        return overtimeemployee;
    }
    @Transactional(rollbackFor = EntityNotFoundException.class, value = "Dynamohr126tabsTransactionManager")
    @Override
    public OverTimeEmployee update(OverTimeEmployee updated) throws EntityNotFoundException {
        LOGGER.debug("Updating overtimeemployee with information: {}" , updated);
        this.wmGenericDao.update(updated);

        Integer id = (Integer)updated.getIdOverTimeEmployee();

        return this.wmGenericDao.findById(id);
    }

    @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
    @Override
    public long countAll() {
        return this.wmGenericDao.count();
    }
}


