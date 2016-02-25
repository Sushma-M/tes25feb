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
 * ServiceImpl object for domain model class TravelEmployee.
 * @see com.test_25feb.dynamohr126tabs.TravelEmployee
 */
@Service("Dynamohr126tabs.TravelEmployeeService")
public class TravelEmployeeServiceImpl implements TravelEmployeeService {


    private static final Logger LOGGER = LoggerFactory.getLogger(TravelEmployeeServiceImpl.class);

    @Autowired
    @Qualifier("Dynamohr126tabs.TravelEmployeeDao")
    private WMGenericDao<TravelEmployee, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<TravelEmployee, Integer> wmGenericDao){
        this.wmGenericDao = wmGenericDao;
    }
     @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
     public Page<TravelEmployee> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable){
          LOGGER.debug("Fetching all associated");
          return this.wmGenericDao.getAssociatedObjects(value, entityName, key, pageable);
     }

    @Transactional(value = "Dynamohr126tabsTransactionManager")
    @Override
    public TravelEmployee create(TravelEmployee travelemployee) {
        LOGGER.debug("Creating a new travelemployee with information: {}" , travelemployee);
        return this.wmGenericDao.create(travelemployee);
    }

    @Transactional(rollbackFor = EntityNotFoundException.class, value = "Dynamohr126tabsTransactionManager")
    @Override
    public TravelEmployee delete(Integer travelemployeeId) throws EntityNotFoundException {
        LOGGER.debug("Deleting travelemployee with id: {}" , travelemployeeId);
        TravelEmployee deleted = this.wmGenericDao.findById(travelemployeeId);
        if (deleted == null) {
            LOGGER.debug("No travelemployee found with id: {}" , travelemployeeId);
            throw new EntityNotFoundException(String.valueOf(travelemployeeId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
    @Override
    public Page<TravelEmployee> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all travelemployees");
        return this.wmGenericDao.search(queryFilters, pageable);
    }
    
    @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
    @Override
    public Page<TravelEmployee> findAll(Pageable pageable) {
        LOGGER.debug("Finding all travelemployees");
        return this.wmGenericDao.search(null, pageable);
    }

    @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
    @Override
    public TravelEmployee findById(Integer id) throws EntityNotFoundException {
        LOGGER.debug("Finding travelemployee by id: {}" , id);
        TravelEmployee travelemployee=this.wmGenericDao.findById(id);
        if(travelemployee==null){
            LOGGER.debug("No travelemployee found with id: {}" , id);
            throw new EntityNotFoundException(String.valueOf(id));
        }
        return travelemployee;
    }
    @Transactional(rollbackFor = EntityNotFoundException.class, value = "Dynamohr126tabsTransactionManager")
    @Override
    public TravelEmployee update(TravelEmployee updated) throws EntityNotFoundException {
        LOGGER.debug("Updating travelemployee with information: {}" , updated);
        this.wmGenericDao.update(updated);

        Integer id = (Integer)updated.getIdTravelEmployee();

        return this.wmGenericDao.findById(id);
    }

    @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
    @Override
    public long countAll() {
        return this.wmGenericDao.count();
    }
}


