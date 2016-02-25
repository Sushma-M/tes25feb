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
 * ServiceImpl object for domain model class TypeIncident.
 * @see com.test_25feb.dynamohr126tabs.TypeIncident
 */
@Service("Dynamohr126tabs.TypeIncidentService")
public class TypeIncidentServiceImpl implements TypeIncidentService {


    private static final Logger LOGGER = LoggerFactory.getLogger(TypeIncidentServiceImpl.class);

    @Autowired
    @Qualifier("Dynamohr126tabs.TypeIncidentDao")
    private WMGenericDao<TypeIncident, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<TypeIncident, Integer> wmGenericDao){
        this.wmGenericDao = wmGenericDao;
    }
     @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
     public Page<TypeIncident> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable){
          LOGGER.debug("Fetching all associated");
          return this.wmGenericDao.getAssociatedObjects(value, entityName, key, pageable);
     }

    @Transactional(value = "Dynamohr126tabsTransactionManager")
    @Override
    public TypeIncident create(TypeIncident typeincident) {
        LOGGER.debug("Creating a new typeincident with information: {}" , typeincident);
        return this.wmGenericDao.create(typeincident);
    }

    @Transactional(rollbackFor = EntityNotFoundException.class, value = "Dynamohr126tabsTransactionManager")
    @Override
    public TypeIncident delete(Integer typeincidentId) throws EntityNotFoundException {
        LOGGER.debug("Deleting typeincident with id: {}" , typeincidentId);
        TypeIncident deleted = this.wmGenericDao.findById(typeincidentId);
        if (deleted == null) {
            LOGGER.debug("No typeincident found with id: {}" , typeincidentId);
            throw new EntityNotFoundException(String.valueOf(typeincidentId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
    @Override
    public Page<TypeIncident> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all typeincidents");
        return this.wmGenericDao.search(queryFilters, pageable);
    }
    
    @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
    @Override
    public Page<TypeIncident> findAll(Pageable pageable) {
        LOGGER.debug("Finding all typeincidents");
        return this.wmGenericDao.search(null, pageable);
    }

    @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
    @Override
    public TypeIncident findById(Integer id) throws EntityNotFoundException {
        LOGGER.debug("Finding typeincident by id: {}" , id);
        TypeIncident typeincident=this.wmGenericDao.findById(id);
        if(typeincident==null){
            LOGGER.debug("No typeincident found with id: {}" , id);
            throw new EntityNotFoundException(String.valueOf(id));
        }
        return typeincident;
    }
    @Transactional(rollbackFor = EntityNotFoundException.class, value = "Dynamohr126tabsTransactionManager")
    @Override
    public TypeIncident update(TypeIncident updated) throws EntityNotFoundException {
        LOGGER.debug("Updating typeincident with information: {}" , updated);
        this.wmGenericDao.update(updated);

        Integer id = (Integer)updated.getIdTypeIncident();

        return this.wmGenericDao.findById(id);
    }

    @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
    @Override
    public long countAll() {
        return this.wmGenericDao.count();
    }
}

