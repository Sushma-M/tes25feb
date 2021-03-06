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
 * ServiceImpl object for domain model class TypeGenerationForm.
 * @see com.test_25feb.dynamohr126tabs.TypeGenerationForm
 */
@Service("Dynamohr126tabs.TypeGenerationFormService")
public class TypeGenerationFormServiceImpl implements TypeGenerationFormService {


    private static final Logger LOGGER = LoggerFactory.getLogger(TypeGenerationFormServiceImpl.class);

    @Autowired
    @Qualifier("Dynamohr126tabs.TypeGenerationFormDao")
    private WMGenericDao<TypeGenerationForm, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<TypeGenerationForm, Integer> wmGenericDao){
        this.wmGenericDao = wmGenericDao;
    }
     @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
     public Page<TypeGenerationForm> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable){
          LOGGER.debug("Fetching all associated");
          return this.wmGenericDao.getAssociatedObjects(value, entityName, key, pageable);
     }

    @Transactional(value = "Dynamohr126tabsTransactionManager")
    @Override
    public TypeGenerationForm create(TypeGenerationForm typegenerationform) {
        LOGGER.debug("Creating a new typegenerationform with information: {}" , typegenerationform);
        return this.wmGenericDao.create(typegenerationform);
    }

    @Transactional(rollbackFor = EntityNotFoundException.class, value = "Dynamohr126tabsTransactionManager")
    @Override
    public TypeGenerationForm delete(Integer typegenerationformId) throws EntityNotFoundException {
        LOGGER.debug("Deleting typegenerationform with id: {}" , typegenerationformId);
        TypeGenerationForm deleted = this.wmGenericDao.findById(typegenerationformId);
        if (deleted == null) {
            LOGGER.debug("No typegenerationform found with id: {}" , typegenerationformId);
            throw new EntityNotFoundException(String.valueOf(typegenerationformId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
    @Override
    public Page<TypeGenerationForm> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all typegenerationforms");
        return this.wmGenericDao.search(queryFilters, pageable);
    }
    
    @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
    @Override
    public Page<TypeGenerationForm> findAll(Pageable pageable) {
        LOGGER.debug("Finding all typegenerationforms");
        return this.wmGenericDao.search(null, pageable);
    }

    @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
    @Override
    public TypeGenerationForm findById(Integer id) throws EntityNotFoundException {
        LOGGER.debug("Finding typegenerationform by id: {}" , id);
        TypeGenerationForm typegenerationform=this.wmGenericDao.findById(id);
        if(typegenerationform==null){
            LOGGER.debug("No typegenerationform found with id: {}" , id);
            throw new EntityNotFoundException(String.valueOf(id));
        }
        return typegenerationform;
    }
    @Transactional(rollbackFor = EntityNotFoundException.class, value = "Dynamohr126tabsTransactionManager")
    @Override
    public TypeGenerationForm update(TypeGenerationForm updated) throws EntityNotFoundException {
        LOGGER.debug("Updating typegenerationform with information: {}" , updated);
        this.wmGenericDao.update(updated);

        Integer id = (Integer)updated.getIdTypeEmployeePaymentMethod();

        return this.wmGenericDao.findById(id);
    }

    @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
    @Override
    public long countAll() {
        return this.wmGenericDao.count();
    }
}


