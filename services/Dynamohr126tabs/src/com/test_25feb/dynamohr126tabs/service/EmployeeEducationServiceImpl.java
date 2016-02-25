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
 * ServiceImpl object for domain model class EmployeeEducation.
 * @see com.test_25feb.dynamohr126tabs.EmployeeEducation
 */
@Service("Dynamohr126tabs.EmployeeEducationService")
public class EmployeeEducationServiceImpl implements EmployeeEducationService {


    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeEducationServiceImpl.class);

    @Autowired
    @Qualifier("Dynamohr126tabs.EmployeeEducationDao")
    private WMGenericDao<EmployeeEducation, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<EmployeeEducation, Integer> wmGenericDao){
        this.wmGenericDao = wmGenericDao;
    }
     @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
     public Page<EmployeeEducation> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable){
          LOGGER.debug("Fetching all associated");
          return this.wmGenericDao.getAssociatedObjects(value, entityName, key, pageable);
     }

    @Transactional(value = "Dynamohr126tabsTransactionManager")
    @Override
    public EmployeeEducation create(EmployeeEducation employeeeducation) {
        LOGGER.debug("Creating a new employeeeducation with information: {}" , employeeeducation);
        return this.wmGenericDao.create(employeeeducation);
    }

    @Transactional(rollbackFor = EntityNotFoundException.class, value = "Dynamohr126tabsTransactionManager")
    @Override
    public EmployeeEducation delete(Integer employeeeducationId) throws EntityNotFoundException {
        LOGGER.debug("Deleting employeeeducation with id: {}" , employeeeducationId);
        EmployeeEducation deleted = this.wmGenericDao.findById(employeeeducationId);
        if (deleted == null) {
            LOGGER.debug("No employeeeducation found with id: {}" , employeeeducationId);
            throw new EntityNotFoundException(String.valueOf(employeeeducationId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
    @Override
    public Page<EmployeeEducation> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all employeeeducations");
        return this.wmGenericDao.search(queryFilters, pageable);
    }
    
    @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
    @Override
    public Page<EmployeeEducation> findAll(Pageable pageable) {
        LOGGER.debug("Finding all employeeeducations");
        return this.wmGenericDao.search(null, pageable);
    }

    @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
    @Override
    public EmployeeEducation findById(Integer id) throws EntityNotFoundException {
        LOGGER.debug("Finding employeeeducation by id: {}" , id);
        EmployeeEducation employeeeducation=this.wmGenericDao.findById(id);
        if(employeeeducation==null){
            LOGGER.debug("No employeeeducation found with id: {}" , id);
            throw new EntityNotFoundException(String.valueOf(id));
        }
        return employeeeducation;
    }
    @Transactional(rollbackFor = EntityNotFoundException.class, value = "Dynamohr126tabsTransactionManager")
    @Override
    public EmployeeEducation update(EmployeeEducation updated) throws EntityNotFoundException {
        LOGGER.debug("Updating employeeeducation with information: {}" , updated);
        this.wmGenericDao.update(updated);

        Integer id = (Integer)updated.getIdEmployeeEducation();

        return this.wmGenericDao.findById(id);
    }

    @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
    @Override
    public long countAll() {
        return this.wmGenericDao.count();
    }
}

