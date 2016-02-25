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
 * ServiceImpl object for domain model class IncidenceEmployee.
 * @see com.test_25feb.dynamohr126tabs.IncidenceEmployee
 */
@Service("Dynamohr126tabs.IncidenceEmployeeService")
public class IncidenceEmployeeServiceImpl implements IncidenceEmployeeService {


    private static final Logger LOGGER = LoggerFactory.getLogger(IncidenceEmployeeServiceImpl.class);

    @Autowired
    @Qualifier("Dynamohr126tabs.IncidenceEmployeeDao")
    private WMGenericDao<IncidenceEmployee, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<IncidenceEmployee, Integer> wmGenericDao){
        this.wmGenericDao = wmGenericDao;
    }
     @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
     public Page<IncidenceEmployee> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable){
          LOGGER.debug("Fetching all associated");
          return this.wmGenericDao.getAssociatedObjects(value, entityName, key, pageable);
     }

    @Transactional(value = "Dynamohr126tabsTransactionManager")
    @Override
    public IncidenceEmployee create(IncidenceEmployee incidenceemployee) {
        LOGGER.debug("Creating a new incidenceemployee with information: {}" , incidenceemployee);
        return this.wmGenericDao.create(incidenceemployee);
    }

    @Transactional(rollbackFor = EntityNotFoundException.class, value = "Dynamohr126tabsTransactionManager")
    @Override
    public IncidenceEmployee delete(Integer incidenceemployeeId) throws EntityNotFoundException {
        LOGGER.debug("Deleting incidenceemployee with id: {}" , incidenceemployeeId);
        IncidenceEmployee deleted = this.wmGenericDao.findById(incidenceemployeeId);
        if (deleted == null) {
            LOGGER.debug("No incidenceemployee found with id: {}" , incidenceemployeeId);
            throw new EntityNotFoundException(String.valueOf(incidenceemployeeId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
    @Override
    public Page<IncidenceEmployee> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all incidenceemployees");
        return this.wmGenericDao.search(queryFilters, pageable);
    }
    
    @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
    @Override
    public Page<IncidenceEmployee> findAll(Pageable pageable) {
        LOGGER.debug("Finding all incidenceemployees");
        return this.wmGenericDao.search(null, pageable);
    }

    @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
    @Override
    public IncidenceEmployee findById(Integer id) throws EntityNotFoundException {
        LOGGER.debug("Finding incidenceemployee by id: {}" , id);
        IncidenceEmployee incidenceemployee=this.wmGenericDao.findById(id);
        if(incidenceemployee==null){
            LOGGER.debug("No incidenceemployee found with id: {}" , id);
            throw new EntityNotFoundException(String.valueOf(id));
        }
        return incidenceemployee;
    }
    @Transactional(rollbackFor = EntityNotFoundException.class, value = "Dynamohr126tabsTransactionManager")
    @Override
    public IncidenceEmployee update(IncidenceEmployee updated) throws EntityNotFoundException {
        LOGGER.debug("Updating incidenceemployee with information: {}" , updated);
        this.wmGenericDao.update(updated);

        Integer id = (Integer)updated.getIdIncidenceEmployee();

        return this.wmGenericDao.findById(id);
    }

    @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
    @Override
    public long countAll() {
        return this.wmGenericDao.count();
    }
}


