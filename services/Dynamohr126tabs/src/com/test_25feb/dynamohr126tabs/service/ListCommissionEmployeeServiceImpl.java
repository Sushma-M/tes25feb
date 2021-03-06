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
 * ServiceImpl object for domain model class ListCommissionEmployee.
 * @see com.test_25feb.dynamohr126tabs.ListCommissionEmployee
 */
@Service("Dynamohr126tabs.ListCommissionEmployeeService")
public class ListCommissionEmployeeServiceImpl implements ListCommissionEmployeeService {


    private static final Logger LOGGER = LoggerFactory.getLogger(ListCommissionEmployeeServiceImpl.class);

    @Autowired
    @Qualifier("Dynamohr126tabs.ListCommissionEmployeeDao")
    private WMGenericDao<ListCommissionEmployee, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<ListCommissionEmployee, Integer> wmGenericDao){
        this.wmGenericDao = wmGenericDao;
    }
     @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
     public Page<ListCommissionEmployee> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable){
          LOGGER.debug("Fetching all associated");
          return this.wmGenericDao.getAssociatedObjects(value, entityName, key, pageable);
     }

    @Transactional(value = "Dynamohr126tabsTransactionManager")
    @Override
    public ListCommissionEmployee create(ListCommissionEmployee listcommissionemployee) {
        LOGGER.debug("Creating a new listcommissionemployee with information: {}" , listcommissionemployee);
        return this.wmGenericDao.create(listcommissionemployee);
    }

    @Transactional(rollbackFor = EntityNotFoundException.class, value = "Dynamohr126tabsTransactionManager")
    @Override
    public ListCommissionEmployee delete(Integer listcommissionemployeeId) throws EntityNotFoundException {
        LOGGER.debug("Deleting listcommissionemployee with id: {}" , listcommissionemployeeId);
        ListCommissionEmployee deleted = this.wmGenericDao.findById(listcommissionemployeeId);
        if (deleted == null) {
            LOGGER.debug("No listcommissionemployee found with id: {}" , listcommissionemployeeId);
            throw new EntityNotFoundException(String.valueOf(listcommissionemployeeId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
    @Override
    public Page<ListCommissionEmployee> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all listcommissionemployees");
        return this.wmGenericDao.search(queryFilters, pageable);
    }
    
    @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
    @Override
    public Page<ListCommissionEmployee> findAll(Pageable pageable) {
        LOGGER.debug("Finding all listcommissionemployees");
        return this.wmGenericDao.search(null, pageable);
    }

    @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
    @Override
    public ListCommissionEmployee findById(Integer id) throws EntityNotFoundException {
        LOGGER.debug("Finding listcommissionemployee by id: {}" , id);
        ListCommissionEmployee listcommissionemployee=this.wmGenericDao.findById(id);
        if(listcommissionemployee==null){
            LOGGER.debug("No listcommissionemployee found with id: {}" , id);
            throw new EntityNotFoundException(String.valueOf(id));
        }
        return listcommissionemployee;
    }
    @Transactional(rollbackFor = EntityNotFoundException.class, value = "Dynamohr126tabsTransactionManager")
    @Override
    public ListCommissionEmployee update(ListCommissionEmployee updated) throws EntityNotFoundException {
        LOGGER.debug("Updating listcommissionemployee with information: {}" , updated);
        this.wmGenericDao.update(updated);

        Integer id = (Integer)updated.getIdListCommissionEmployee();

        return this.wmGenericDao.findById(id);
    }

    @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
    @Override
    public long countAll() {
        return this.wmGenericDao.count();
    }
}


