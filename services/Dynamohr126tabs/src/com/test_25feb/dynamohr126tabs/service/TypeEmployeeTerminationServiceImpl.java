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
 * ServiceImpl object for domain model class TypeEmployeeTermination.
 * @see com.test_25feb.dynamohr126tabs.TypeEmployeeTermination
 */
@Service("Dynamohr126tabs.TypeEmployeeTerminationService")
public class TypeEmployeeTerminationServiceImpl implements TypeEmployeeTerminationService {


    private static final Logger LOGGER = LoggerFactory.getLogger(TypeEmployeeTerminationServiceImpl.class);

    @Autowired
    @Qualifier("Dynamohr126tabs.TypeEmployeeTerminationDao")
    private WMGenericDao<TypeEmployeeTermination, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<TypeEmployeeTermination, Integer> wmGenericDao){
        this.wmGenericDao = wmGenericDao;
    }
     @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
     public Page<TypeEmployeeTermination> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable){
          LOGGER.debug("Fetching all associated");
          return this.wmGenericDao.getAssociatedObjects(value, entityName, key, pageable);
     }

    @Transactional(value = "Dynamohr126tabsTransactionManager")
    @Override
    public TypeEmployeeTermination create(TypeEmployeeTermination typeemployeetermination) {
        LOGGER.debug("Creating a new typeemployeetermination with information: {}" , typeemployeetermination);
        return this.wmGenericDao.create(typeemployeetermination);
    }

    @Transactional(rollbackFor = EntityNotFoundException.class, value = "Dynamohr126tabsTransactionManager")
    @Override
    public TypeEmployeeTermination delete(Integer typeemployeeterminationId) throws EntityNotFoundException {
        LOGGER.debug("Deleting typeemployeetermination with id: {}" , typeemployeeterminationId);
        TypeEmployeeTermination deleted = this.wmGenericDao.findById(typeemployeeterminationId);
        if (deleted == null) {
            LOGGER.debug("No typeemployeetermination found with id: {}" , typeemployeeterminationId);
            throw new EntityNotFoundException(String.valueOf(typeemployeeterminationId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
    @Override
    public Page<TypeEmployeeTermination> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all typeemployeeterminations");
        return this.wmGenericDao.search(queryFilters, pageable);
    }
    
    @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
    @Override
    public Page<TypeEmployeeTermination> findAll(Pageable pageable) {
        LOGGER.debug("Finding all typeemployeeterminations");
        return this.wmGenericDao.search(null, pageable);
    }

    @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
    @Override
    public TypeEmployeeTermination findById(Integer id) throws EntityNotFoundException {
        LOGGER.debug("Finding typeemployeetermination by id: {}" , id);
        TypeEmployeeTermination typeemployeetermination=this.wmGenericDao.findById(id);
        if(typeemployeetermination==null){
            LOGGER.debug("No typeemployeetermination found with id: {}" , id);
            throw new EntityNotFoundException(String.valueOf(id));
        }
        return typeemployeetermination;
    }
    @Transactional(rollbackFor = EntityNotFoundException.class, value = "Dynamohr126tabsTransactionManager")
    @Override
    public TypeEmployeeTermination update(TypeEmployeeTermination updated) throws EntityNotFoundException {
        LOGGER.debug("Updating typeemployeetermination with information: {}" , updated);
        this.wmGenericDao.update(updated);

        Integer id = (Integer)updated.getIdEmployeeTermination();

        return this.wmGenericDao.findById(id);
    }

    @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
    @Override
    public long countAll() {
        return this.wmGenericDao.count();
    }
}

