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
 * ServiceImpl object for domain model class EmployeeWorkProof.
 * @see com.test_25feb.dynamohr126tabs.EmployeeWorkProof
 */
@Service("Dynamohr126tabs.EmployeeWorkProofService")
public class EmployeeWorkProofServiceImpl implements EmployeeWorkProofService {


    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeWorkProofServiceImpl.class);

    @Autowired
    @Qualifier("Dynamohr126tabs.EmployeeWorkProofDao")
    private WMGenericDao<EmployeeWorkProof, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<EmployeeWorkProof, Integer> wmGenericDao){
        this.wmGenericDao = wmGenericDao;
    }
     @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
     public Page<EmployeeWorkProof> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable){
          LOGGER.debug("Fetching all associated");
          return this.wmGenericDao.getAssociatedObjects(value, entityName, key, pageable);
     }

    @Transactional(value = "Dynamohr126tabsTransactionManager")
    @Override
    public EmployeeWorkProof create(EmployeeWorkProof employeeworkproof) {
        LOGGER.debug("Creating a new employeeworkproof with information: {}" , employeeworkproof);
        return this.wmGenericDao.create(employeeworkproof);
    }

    @Transactional(rollbackFor = EntityNotFoundException.class, value = "Dynamohr126tabsTransactionManager")
    @Override
    public EmployeeWorkProof delete(Integer employeeworkproofId) throws EntityNotFoundException {
        LOGGER.debug("Deleting employeeworkproof with id: {}" , employeeworkproofId);
        EmployeeWorkProof deleted = this.wmGenericDao.findById(employeeworkproofId);
        if (deleted == null) {
            LOGGER.debug("No employeeworkproof found with id: {}" , employeeworkproofId);
            throw new EntityNotFoundException(String.valueOf(employeeworkproofId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
    @Override
    public Page<EmployeeWorkProof> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all employeeworkproofs");
        return this.wmGenericDao.search(queryFilters, pageable);
    }
    
    @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
    @Override
    public Page<EmployeeWorkProof> findAll(Pageable pageable) {
        LOGGER.debug("Finding all employeeworkproofs");
        return this.wmGenericDao.search(null, pageable);
    }

    @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
    @Override
    public EmployeeWorkProof findById(Integer id) throws EntityNotFoundException {
        LOGGER.debug("Finding employeeworkproof by id: {}" , id);
        EmployeeWorkProof employeeworkproof=this.wmGenericDao.findById(id);
        if(employeeworkproof==null){
            LOGGER.debug("No employeeworkproof found with id: {}" , id);
            throw new EntityNotFoundException(String.valueOf(id));
        }
        return employeeworkproof;
    }
    @Transactional(rollbackFor = EntityNotFoundException.class, value = "Dynamohr126tabsTransactionManager")
    @Override
    public EmployeeWorkProof update(EmployeeWorkProof updated) throws EntityNotFoundException {
        LOGGER.debug("Updating employeeworkproof with information: {}" , updated);
        this.wmGenericDao.update(updated);

        Integer id = (Integer)updated.getIdEmployeeWorkProof();

        return this.wmGenericDao.findById(id);
    }

    @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
    @Override
    public long countAll() {
        return this.wmGenericDao.count();
    }
}

