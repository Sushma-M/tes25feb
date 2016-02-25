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
 * ServiceImpl object for domain model class ListOvertimePayroll.
 * @see com.test_25feb.dynamohr126tabs.ListOvertimePayroll
 */
@Service("Dynamohr126tabs.ListOvertimePayrollService")
public class ListOvertimePayrollServiceImpl implements ListOvertimePayrollService {


    private static final Logger LOGGER = LoggerFactory.getLogger(ListOvertimePayrollServiceImpl.class);

    @Autowired
    @Qualifier("Dynamohr126tabs.ListOvertimePayrollDao")
    private WMGenericDao<ListOvertimePayroll, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<ListOvertimePayroll, Integer> wmGenericDao){
        this.wmGenericDao = wmGenericDao;
    }
     @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
     public Page<ListOvertimePayroll> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable){
          LOGGER.debug("Fetching all associated");
          return this.wmGenericDao.getAssociatedObjects(value, entityName, key, pageable);
     }

    @Transactional(value = "Dynamohr126tabsTransactionManager")
    @Override
    public ListOvertimePayroll create(ListOvertimePayroll listovertimepayroll) {
        LOGGER.debug("Creating a new listovertimepayroll with information: {}" , listovertimepayroll);
        return this.wmGenericDao.create(listovertimepayroll);
    }

    @Transactional(rollbackFor = EntityNotFoundException.class, value = "Dynamohr126tabsTransactionManager")
    @Override
    public ListOvertimePayroll delete(Integer listovertimepayrollId) throws EntityNotFoundException {
        LOGGER.debug("Deleting listovertimepayroll with id: {}" , listovertimepayrollId);
        ListOvertimePayroll deleted = this.wmGenericDao.findById(listovertimepayrollId);
        if (deleted == null) {
            LOGGER.debug("No listovertimepayroll found with id: {}" , listovertimepayrollId);
            throw new EntityNotFoundException(String.valueOf(listovertimepayrollId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
    @Override
    public Page<ListOvertimePayroll> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all listovertimepayrolls");
        return this.wmGenericDao.search(queryFilters, pageable);
    }
    
    @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
    @Override
    public Page<ListOvertimePayroll> findAll(Pageable pageable) {
        LOGGER.debug("Finding all listovertimepayrolls");
        return this.wmGenericDao.search(null, pageable);
    }

    @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
    @Override
    public ListOvertimePayroll findById(Integer id) throws EntityNotFoundException {
        LOGGER.debug("Finding listovertimepayroll by id: {}" , id);
        ListOvertimePayroll listovertimepayroll=this.wmGenericDao.findById(id);
        if(listovertimepayroll==null){
            LOGGER.debug("No listovertimepayroll found with id: {}" , id);
            throw new EntityNotFoundException(String.valueOf(id));
        }
        return listovertimepayroll;
    }
    @Transactional(rollbackFor = EntityNotFoundException.class, value = "Dynamohr126tabsTransactionManager")
    @Override
    public ListOvertimePayroll update(ListOvertimePayroll updated) throws EntityNotFoundException {
        LOGGER.debug("Updating listovertimepayroll with information: {}" , updated);
        this.wmGenericDao.update(updated);

        Integer id = (Integer)updated.getIdListOvertimePayroll();

        return this.wmGenericDao.findById(id);
    }

    @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
    @Override
    public long countAll() {
        return this.wmGenericDao.count();
    }
}

