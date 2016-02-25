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
 * ServiceImpl object for domain model class IsrDetail.
 * @see com.test_25feb.dynamohr126tabs.IsrDetail
 */
@Service("Dynamohr126tabs.IsrDetailService")
public class IsrDetailServiceImpl implements IsrDetailService {


    private static final Logger LOGGER = LoggerFactory.getLogger(IsrDetailServiceImpl.class);

    @Autowired
    @Qualifier("Dynamohr126tabs.IsrDetailDao")
    private WMGenericDao<IsrDetail, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<IsrDetail, Integer> wmGenericDao){
        this.wmGenericDao = wmGenericDao;
    }
     @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
     public Page<IsrDetail> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable){
          LOGGER.debug("Fetching all associated");
          return this.wmGenericDao.getAssociatedObjects(value, entityName, key, pageable);
     }

    @Transactional(value = "Dynamohr126tabsTransactionManager")
    @Override
    public IsrDetail create(IsrDetail isrdetail) {
        LOGGER.debug("Creating a new isrdetail with information: {}" , isrdetail);
        return this.wmGenericDao.create(isrdetail);
    }

    @Transactional(rollbackFor = EntityNotFoundException.class, value = "Dynamohr126tabsTransactionManager")
    @Override
    public IsrDetail delete(Integer isrdetailId) throws EntityNotFoundException {
        LOGGER.debug("Deleting isrdetail with id: {}" , isrdetailId);
        IsrDetail deleted = this.wmGenericDao.findById(isrdetailId);
        if (deleted == null) {
            LOGGER.debug("No isrdetail found with id: {}" , isrdetailId);
            throw new EntityNotFoundException(String.valueOf(isrdetailId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
    @Override
    public Page<IsrDetail> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all isrdetails");
        return this.wmGenericDao.search(queryFilters, pageable);
    }
    
    @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
    @Override
    public Page<IsrDetail> findAll(Pageable pageable) {
        LOGGER.debug("Finding all isrdetails");
        return this.wmGenericDao.search(null, pageable);
    }

    @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
    @Override
    public IsrDetail findById(Integer id) throws EntityNotFoundException {
        LOGGER.debug("Finding isrdetail by id: {}" , id);
        IsrDetail isrdetail=this.wmGenericDao.findById(id);
        if(isrdetail==null){
            LOGGER.debug("No isrdetail found with id: {}" , id);
            throw new EntityNotFoundException(String.valueOf(id));
        }
        return isrdetail;
    }
    @Transactional(rollbackFor = EntityNotFoundException.class, value = "Dynamohr126tabsTransactionManager")
    @Override
    public IsrDetail update(IsrDetail updated) throws EntityNotFoundException {
        LOGGER.debug("Updating isrdetail with information: {}" , updated);
        this.wmGenericDao.update(updated);

        Integer id = (Integer)updated.getIdIsrDetail();

        return this.wmGenericDao.findById(id);
    }

    @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
    @Override
    public long countAll() {
        return this.wmGenericDao.count();
    }
}

