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
 * ServiceImpl object for domain model class TypeMovement.
 * @see com.test_25feb.dynamohr126tabs.TypeMovement
 */
@Service("Dynamohr126tabs.TypeMovementService")
public class TypeMovementServiceImpl implements TypeMovementService {


    private static final Logger LOGGER = LoggerFactory.getLogger(TypeMovementServiceImpl.class);

    @Autowired
    @Qualifier("Dynamohr126tabs.TypeMovementDao")
    private WMGenericDao<TypeMovement, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<TypeMovement, Integer> wmGenericDao){
        this.wmGenericDao = wmGenericDao;
    }
     @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
     public Page<TypeMovement> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable){
          LOGGER.debug("Fetching all associated");
          return this.wmGenericDao.getAssociatedObjects(value, entityName, key, pageable);
     }

    @Transactional(value = "Dynamohr126tabsTransactionManager")
    @Override
    public TypeMovement create(TypeMovement typemovement) {
        LOGGER.debug("Creating a new typemovement with information: {}" , typemovement);
        return this.wmGenericDao.create(typemovement);
    }

    @Transactional(rollbackFor = EntityNotFoundException.class, value = "Dynamohr126tabsTransactionManager")
    @Override
    public TypeMovement delete(Integer typemovementId) throws EntityNotFoundException {
        LOGGER.debug("Deleting typemovement with id: {}" , typemovementId);
        TypeMovement deleted = this.wmGenericDao.findById(typemovementId);
        if (deleted == null) {
            LOGGER.debug("No typemovement found with id: {}" , typemovementId);
            throw new EntityNotFoundException(String.valueOf(typemovementId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
    @Override
    public Page<TypeMovement> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all typemovements");
        return this.wmGenericDao.search(queryFilters, pageable);
    }
    
    @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
    @Override
    public Page<TypeMovement> findAll(Pageable pageable) {
        LOGGER.debug("Finding all typemovements");
        return this.wmGenericDao.search(null, pageable);
    }

    @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
    @Override
    public TypeMovement findById(Integer id) throws EntityNotFoundException {
        LOGGER.debug("Finding typemovement by id: {}" , id);
        TypeMovement typemovement=this.wmGenericDao.findById(id);
        if(typemovement==null){
            LOGGER.debug("No typemovement found with id: {}" , id);
            throw new EntityNotFoundException(String.valueOf(id));
        }
        return typemovement;
    }
    @Transactional(rollbackFor = EntityNotFoundException.class, value = "Dynamohr126tabsTransactionManager")
    @Override
    public TypeMovement update(TypeMovement updated) throws EntityNotFoundException {
        LOGGER.debug("Updating typemovement with information: {}" , updated);
        this.wmGenericDao.update(updated);

        Integer id = (Integer)updated.getIdTypeMovement();

        return this.wmGenericDao.findById(id);
    }

    @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
    @Override
    public long countAll() {
        return this.wmGenericDao.count();
    }
}


