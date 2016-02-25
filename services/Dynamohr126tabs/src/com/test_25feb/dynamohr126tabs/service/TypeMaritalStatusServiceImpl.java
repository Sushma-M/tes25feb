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
 * ServiceImpl object for domain model class TypeMaritalStatus.
 * @see com.test_25feb.dynamohr126tabs.TypeMaritalStatus
 */
@Service("Dynamohr126tabs.TypeMaritalStatusService")
public class TypeMaritalStatusServiceImpl implements TypeMaritalStatusService {


    private static final Logger LOGGER = LoggerFactory.getLogger(TypeMaritalStatusServiceImpl.class);

    @Autowired
    @Qualifier("Dynamohr126tabs.TypeMaritalStatusDao")
    private WMGenericDao<TypeMaritalStatus, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<TypeMaritalStatus, Integer> wmGenericDao){
        this.wmGenericDao = wmGenericDao;
    }
     @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
     public Page<TypeMaritalStatus> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable){
          LOGGER.debug("Fetching all associated");
          return this.wmGenericDao.getAssociatedObjects(value, entityName, key, pageable);
     }

    @Transactional(value = "Dynamohr126tabsTransactionManager")
    @Override
    public TypeMaritalStatus create(TypeMaritalStatus typemaritalstatus) {
        LOGGER.debug("Creating a new typemaritalstatus with information: {}" , typemaritalstatus);
        return this.wmGenericDao.create(typemaritalstatus);
    }

    @Transactional(rollbackFor = EntityNotFoundException.class, value = "Dynamohr126tabsTransactionManager")
    @Override
    public TypeMaritalStatus delete(Integer typemaritalstatusId) throws EntityNotFoundException {
        LOGGER.debug("Deleting typemaritalstatus with id: {}" , typemaritalstatusId);
        TypeMaritalStatus deleted = this.wmGenericDao.findById(typemaritalstatusId);
        if (deleted == null) {
            LOGGER.debug("No typemaritalstatus found with id: {}" , typemaritalstatusId);
            throw new EntityNotFoundException(String.valueOf(typemaritalstatusId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
    @Override
    public Page<TypeMaritalStatus> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all typemaritalstatuss");
        return this.wmGenericDao.search(queryFilters, pageable);
    }
    
    @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
    @Override
    public Page<TypeMaritalStatus> findAll(Pageable pageable) {
        LOGGER.debug("Finding all typemaritalstatuss");
        return this.wmGenericDao.search(null, pageable);
    }

    @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
    @Override
    public TypeMaritalStatus findById(Integer id) throws EntityNotFoundException {
        LOGGER.debug("Finding typemaritalstatus by id: {}" , id);
        TypeMaritalStatus typemaritalstatus=this.wmGenericDao.findById(id);
        if(typemaritalstatus==null){
            LOGGER.debug("No typemaritalstatus found with id: {}" , id);
            throw new EntityNotFoundException(String.valueOf(id));
        }
        return typemaritalstatus;
    }
    @Transactional(rollbackFor = EntityNotFoundException.class, value = "Dynamohr126tabsTransactionManager")
    @Override
    public TypeMaritalStatus update(TypeMaritalStatus updated) throws EntityNotFoundException {
        LOGGER.debug("Updating typemaritalstatus with information: {}" , updated);
        this.wmGenericDao.update(updated);

        Integer id = (Integer)updated.getIdTypeEmployeeTermination();

        return this.wmGenericDao.findById(id);
    }

    @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
    @Override
    public long countAll() {
        return this.wmGenericDao.count();
    }
}


