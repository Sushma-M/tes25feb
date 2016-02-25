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
 * ServiceImpl object for domain model class TypeEmployeePayment.
 * @see com.test_25feb.dynamohr126tabs.TypeEmployeePayment
 */
@Service("Dynamohr126tabs.TypeEmployeePaymentService")
public class TypeEmployeePaymentServiceImpl implements TypeEmployeePaymentService {


    private static final Logger LOGGER = LoggerFactory.getLogger(TypeEmployeePaymentServiceImpl.class);

    @Autowired
    @Qualifier("Dynamohr126tabs.TypeEmployeePaymentDao")
    private WMGenericDao<TypeEmployeePayment, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<TypeEmployeePayment, Integer> wmGenericDao){
        this.wmGenericDao = wmGenericDao;
    }
     @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
     public Page<TypeEmployeePayment> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable){
          LOGGER.debug("Fetching all associated");
          return this.wmGenericDao.getAssociatedObjects(value, entityName, key, pageable);
     }

    @Transactional(value = "Dynamohr126tabsTransactionManager")
    @Override
    public TypeEmployeePayment create(TypeEmployeePayment typeemployeepayment) {
        LOGGER.debug("Creating a new typeemployeepayment with information: {}" , typeemployeepayment);
        return this.wmGenericDao.create(typeemployeepayment);
    }

    @Transactional(rollbackFor = EntityNotFoundException.class, value = "Dynamohr126tabsTransactionManager")
    @Override
    public TypeEmployeePayment delete(Integer typeemployeepaymentId) throws EntityNotFoundException {
        LOGGER.debug("Deleting typeemployeepayment with id: {}" , typeemployeepaymentId);
        TypeEmployeePayment deleted = this.wmGenericDao.findById(typeemployeepaymentId);
        if (deleted == null) {
            LOGGER.debug("No typeemployeepayment found with id: {}" , typeemployeepaymentId);
            throw new EntityNotFoundException(String.valueOf(typeemployeepaymentId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
    @Override
    public Page<TypeEmployeePayment> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all typeemployeepayments");
        return this.wmGenericDao.search(queryFilters, pageable);
    }
    
    @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
    @Override
    public Page<TypeEmployeePayment> findAll(Pageable pageable) {
        LOGGER.debug("Finding all typeemployeepayments");
        return this.wmGenericDao.search(null, pageable);
    }

    @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
    @Override
    public TypeEmployeePayment findById(Integer id) throws EntityNotFoundException {
        LOGGER.debug("Finding typeemployeepayment by id: {}" , id);
        TypeEmployeePayment typeemployeepayment=this.wmGenericDao.findById(id);
        if(typeemployeepayment==null){
            LOGGER.debug("No typeemployeepayment found with id: {}" , id);
            throw new EntityNotFoundException(String.valueOf(id));
        }
        return typeemployeepayment;
    }
    @Transactional(rollbackFor = EntityNotFoundException.class, value = "Dynamohr126tabsTransactionManager")
    @Override
    public TypeEmployeePayment update(TypeEmployeePayment updated) throws EntityNotFoundException {
        LOGGER.debug("Updating typeemployeepayment with information: {}" , updated);
        this.wmGenericDao.update(updated);

        Integer id = (Integer)updated.getIdTypeEmployeePayment();

        return this.wmGenericDao.findById(id);
    }

    @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
    @Override
    public long countAll() {
        return this.wmGenericDao.count();
    }
}

