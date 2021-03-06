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
 * ServiceImpl object for domain model class EmployeeSalary.
 * @see com.test_25feb.dynamohr126tabs.EmployeeSalary
 */
@Service("Dynamohr126tabs.EmployeeSalaryService")
public class EmployeeSalaryServiceImpl implements EmployeeSalaryService {


    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeSalaryServiceImpl.class);

    @Autowired
    @Qualifier("Dynamohr126tabs.EmployeeSalaryDao")
    private WMGenericDao<EmployeeSalary, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<EmployeeSalary, Integer> wmGenericDao){
        this.wmGenericDao = wmGenericDao;
    }
     @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
     public Page<EmployeeSalary> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable){
          LOGGER.debug("Fetching all associated");
          return this.wmGenericDao.getAssociatedObjects(value, entityName, key, pageable);
     }

    @Transactional(value = "Dynamohr126tabsTransactionManager")
    @Override
    public EmployeeSalary create(EmployeeSalary employeesalary) {
        LOGGER.debug("Creating a new employeesalary with information: {}" , employeesalary);
        return this.wmGenericDao.create(employeesalary);
    }

    @Transactional(rollbackFor = EntityNotFoundException.class, value = "Dynamohr126tabsTransactionManager")
    @Override
    public EmployeeSalary delete(Integer employeesalaryId) throws EntityNotFoundException {
        LOGGER.debug("Deleting employeesalary with id: {}" , employeesalaryId);
        EmployeeSalary deleted = this.wmGenericDao.findById(employeesalaryId);
        if (deleted == null) {
            LOGGER.debug("No employeesalary found with id: {}" , employeesalaryId);
            throw new EntityNotFoundException(String.valueOf(employeesalaryId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
    @Override
    public Page<EmployeeSalary> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all employeesalarys");
        return this.wmGenericDao.search(queryFilters, pageable);
    }
    
    @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
    @Override
    public Page<EmployeeSalary> findAll(Pageable pageable) {
        LOGGER.debug("Finding all employeesalarys");
        return this.wmGenericDao.search(null, pageable);
    }

    @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
    @Override
    public EmployeeSalary findById(Integer id) throws EntityNotFoundException {
        LOGGER.debug("Finding employeesalary by id: {}" , id);
        EmployeeSalary employeesalary=this.wmGenericDao.findById(id);
        if(employeesalary==null){
            LOGGER.debug("No employeesalary found with id: {}" , id);
            throw new EntityNotFoundException(String.valueOf(id));
        }
        return employeesalary;
    }
    @Transactional(rollbackFor = EntityNotFoundException.class, value = "Dynamohr126tabsTransactionManager")
    @Override
    public EmployeeSalary update(EmployeeSalary updated) throws EntityNotFoundException {
        LOGGER.debug("Updating employeesalary with information: {}" , updated);
        this.wmGenericDao.update(updated);

        Integer id = (Integer)updated.getIdEmployeeSalary();

        return this.wmGenericDao.findById(id);
    }

    @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
    @Override
    public long countAll() {
        return this.wmGenericDao.count();
    }
}


