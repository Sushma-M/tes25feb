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
 * ServiceImpl object for domain model class Payroll.
 * @see com.test_25feb.dynamohr126tabs.Payroll
 */
@Service("Dynamohr126tabs.PayrollService")
public class PayrollServiceImpl implements PayrollService {


    private static final Logger LOGGER = LoggerFactory.getLogger(PayrollServiceImpl.class);

    @Autowired
    @Qualifier("Dynamohr126tabs.PayrollDao")
    private WMGenericDao<Payroll, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Payroll, Integer> wmGenericDao){
        this.wmGenericDao = wmGenericDao;
    }
     @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
     public Page<Payroll> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable){
          LOGGER.debug("Fetching all associated");
          return this.wmGenericDao.getAssociatedObjects(value, entityName, key, pageable);
     }

    @Transactional(value = "Dynamohr126tabsTransactionManager")
    @Override
    public Payroll create(Payroll payroll) {
        LOGGER.debug("Creating a new payroll with information: {}" , payroll);
        return this.wmGenericDao.create(payroll);
    }

    @Transactional(rollbackFor = EntityNotFoundException.class, value = "Dynamohr126tabsTransactionManager")
    @Override
    public Payroll delete(Integer payrollId) throws EntityNotFoundException {
        LOGGER.debug("Deleting payroll with id: {}" , payrollId);
        Payroll deleted = this.wmGenericDao.findById(payrollId);
        if (deleted == null) {
            LOGGER.debug("No payroll found with id: {}" , payrollId);
            throw new EntityNotFoundException(String.valueOf(payrollId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
    @Override
    public Page<Payroll> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all payrolls");
        return this.wmGenericDao.search(queryFilters, pageable);
    }
    
    @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
    @Override
    public Page<Payroll> findAll(Pageable pageable) {
        LOGGER.debug("Finding all payrolls");
        return this.wmGenericDao.search(null, pageable);
    }

    @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
    @Override
    public Payroll findById(Integer id) throws EntityNotFoundException {
        LOGGER.debug("Finding payroll by id: {}" , id);
        Payroll payroll=this.wmGenericDao.findById(id);
        if(payroll==null){
            LOGGER.debug("No payroll found with id: {}" , id);
            throw new EntityNotFoundException(String.valueOf(id));
        }
        return payroll;
    }
    @Transactional(rollbackFor = EntityNotFoundException.class, value = "Dynamohr126tabsTransactionManager")
    @Override
    public Payroll update(Payroll updated) throws EntityNotFoundException {
        LOGGER.debug("Updating payroll with information: {}" , updated);
        this.wmGenericDao.update(updated);

        Integer id = (Integer)updated.getIdPayroll();

        return this.wmGenericDao.findById(id);
    }

    @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
    @Override
    public long countAll() {
        return this.wmGenericDao.count();
    }
}


