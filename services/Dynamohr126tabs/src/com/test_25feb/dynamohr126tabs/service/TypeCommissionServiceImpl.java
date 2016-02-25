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
 * ServiceImpl object for domain model class TypeCommission.
 * @see com.test_25feb.dynamohr126tabs.TypeCommission
 */
@Service("Dynamohr126tabs.TypeCommissionService")
public class TypeCommissionServiceImpl implements TypeCommissionService {


    private static final Logger LOGGER = LoggerFactory.getLogger(TypeCommissionServiceImpl.class);

    @Autowired
    @Qualifier("Dynamohr126tabs.TypeCommissionDao")
    private WMGenericDao<TypeCommission, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<TypeCommission, Integer> wmGenericDao){
        this.wmGenericDao = wmGenericDao;
    }
     @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
     public Page<TypeCommission> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable){
          LOGGER.debug("Fetching all associated");
          return this.wmGenericDao.getAssociatedObjects(value, entityName, key, pageable);
     }

    @Transactional(value = "Dynamohr126tabsTransactionManager")
    @Override
    public TypeCommission create(TypeCommission typecommission) {
        LOGGER.debug("Creating a new typecommission with information: {}" , typecommission);
        return this.wmGenericDao.create(typecommission);
    }

    @Transactional(rollbackFor = EntityNotFoundException.class, value = "Dynamohr126tabsTransactionManager")
    @Override
    public TypeCommission delete(Integer typecommissionId) throws EntityNotFoundException {
        LOGGER.debug("Deleting typecommission with id: {}" , typecommissionId);
        TypeCommission deleted = this.wmGenericDao.findById(typecommissionId);
        if (deleted == null) {
            LOGGER.debug("No typecommission found with id: {}" , typecommissionId);
            throw new EntityNotFoundException(String.valueOf(typecommissionId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
    @Override
    public Page<TypeCommission> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all typecommissions");
        return this.wmGenericDao.search(queryFilters, pageable);
    }
    
    @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
    @Override
    public Page<TypeCommission> findAll(Pageable pageable) {
        LOGGER.debug("Finding all typecommissions");
        return this.wmGenericDao.search(null, pageable);
    }

    @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
    @Override
    public TypeCommission findById(Integer id) throws EntityNotFoundException {
        LOGGER.debug("Finding typecommission by id: {}" , id);
        TypeCommission typecommission=this.wmGenericDao.findById(id);
        if(typecommission==null){
            LOGGER.debug("No typecommission found with id: {}" , id);
            throw new EntityNotFoundException(String.valueOf(id));
        }
        return typecommission;
    }
    @Transactional(rollbackFor = EntityNotFoundException.class, value = "Dynamohr126tabsTransactionManager")
    @Override
    public TypeCommission update(TypeCommission updated) throws EntityNotFoundException {
        LOGGER.debug("Updating typecommission with information: {}" , updated);
        this.wmGenericDao.update(updated);

        Integer id = (Integer)updated.getIdTypeCommission();

        return this.wmGenericDao.findById(id);
    }

    @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
    @Override
    public long countAll() {
        return this.wmGenericDao.count();
    }
}

