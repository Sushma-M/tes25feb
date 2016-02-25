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
 * ServiceImpl object for domain model class ListTravelExpenseDetail.
 * @see com.test_25feb.dynamohr126tabs.ListTravelExpenseDetail
 */
@Service("Dynamohr126tabs.ListTravelExpenseDetailService")
public class ListTravelExpenseDetailServiceImpl implements ListTravelExpenseDetailService {


    private static final Logger LOGGER = LoggerFactory.getLogger(ListTravelExpenseDetailServiceImpl.class);

    @Autowired
    @Qualifier("Dynamohr126tabs.ListTravelExpenseDetailDao")
    private WMGenericDao<ListTravelExpenseDetail, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<ListTravelExpenseDetail, Integer> wmGenericDao){
        this.wmGenericDao = wmGenericDao;
    }
     @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
     public Page<ListTravelExpenseDetail> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable){
          LOGGER.debug("Fetching all associated");
          return this.wmGenericDao.getAssociatedObjects(value, entityName, key, pageable);
     }

    @Transactional(value = "Dynamohr126tabsTransactionManager")
    @Override
    public ListTravelExpenseDetail create(ListTravelExpenseDetail listtravelexpensedetail) {
        LOGGER.debug("Creating a new listtravelexpensedetail with information: {}" , listtravelexpensedetail);
        return this.wmGenericDao.create(listtravelexpensedetail);
    }

    @Transactional(rollbackFor = EntityNotFoundException.class, value = "Dynamohr126tabsTransactionManager")
    @Override
    public ListTravelExpenseDetail delete(Integer listtravelexpensedetailId) throws EntityNotFoundException {
        LOGGER.debug("Deleting listtravelexpensedetail with id: {}" , listtravelexpensedetailId);
        ListTravelExpenseDetail deleted = this.wmGenericDao.findById(listtravelexpensedetailId);
        if (deleted == null) {
            LOGGER.debug("No listtravelexpensedetail found with id: {}" , listtravelexpensedetailId);
            throw new EntityNotFoundException(String.valueOf(listtravelexpensedetailId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
    @Override
    public Page<ListTravelExpenseDetail> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all listtravelexpensedetails");
        return this.wmGenericDao.search(queryFilters, pageable);
    }
    
    @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
    @Override
    public Page<ListTravelExpenseDetail> findAll(Pageable pageable) {
        LOGGER.debug("Finding all listtravelexpensedetails");
        return this.wmGenericDao.search(null, pageable);
    }

    @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
    @Override
    public ListTravelExpenseDetail findById(Integer id) throws EntityNotFoundException {
        LOGGER.debug("Finding listtravelexpensedetail by id: {}" , id);
        ListTravelExpenseDetail listtravelexpensedetail=this.wmGenericDao.findById(id);
        if(listtravelexpensedetail==null){
            LOGGER.debug("No listtravelexpensedetail found with id: {}" , id);
            throw new EntityNotFoundException(String.valueOf(id));
        }
        return listtravelexpensedetail;
    }
    @Transactional(rollbackFor = EntityNotFoundException.class, value = "Dynamohr126tabsTransactionManager")
    @Override
    public ListTravelExpenseDetail update(ListTravelExpenseDetail updated) throws EntityNotFoundException {
        LOGGER.debug("Updating listtravelexpensedetail with information: {}" , updated);
        this.wmGenericDao.update(updated);

        Integer id = (Integer)updated.getIdListTravelExpenseDetail();

        return this.wmGenericDao.findById(id);
    }

    @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
    @Override
    public long countAll() {
        return this.wmGenericDao.count();
    }
}

