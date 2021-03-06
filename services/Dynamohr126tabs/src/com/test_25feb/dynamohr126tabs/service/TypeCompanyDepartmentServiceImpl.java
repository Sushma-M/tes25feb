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
 * ServiceImpl object for domain model class TypeCompanyDepartment.
 * @see com.test_25feb.dynamohr126tabs.TypeCompanyDepartment
 */
@Service("Dynamohr126tabs.TypeCompanyDepartmentService")
public class TypeCompanyDepartmentServiceImpl implements TypeCompanyDepartmentService {


    private static final Logger LOGGER = LoggerFactory.getLogger(TypeCompanyDepartmentServiceImpl.class);

    @Autowired
    @Qualifier("Dynamohr126tabs.TypeCompanyDepartmentDao")
    private WMGenericDao<TypeCompanyDepartment, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<TypeCompanyDepartment, Integer> wmGenericDao){
        this.wmGenericDao = wmGenericDao;
    }
     @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
     public Page<TypeCompanyDepartment> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable){
          LOGGER.debug("Fetching all associated");
          return this.wmGenericDao.getAssociatedObjects(value, entityName, key, pageable);
     }

    @Transactional(value = "Dynamohr126tabsTransactionManager")
    @Override
    public TypeCompanyDepartment create(TypeCompanyDepartment typecompanydepartment) {
        LOGGER.debug("Creating a new typecompanydepartment with information: {}" , typecompanydepartment);
        return this.wmGenericDao.create(typecompanydepartment);
    }

    @Transactional(rollbackFor = EntityNotFoundException.class, value = "Dynamohr126tabsTransactionManager")
    @Override
    public TypeCompanyDepartment delete(Integer typecompanydepartmentId) throws EntityNotFoundException {
        LOGGER.debug("Deleting typecompanydepartment with id: {}" , typecompanydepartmentId);
        TypeCompanyDepartment deleted = this.wmGenericDao.findById(typecompanydepartmentId);
        if (deleted == null) {
            LOGGER.debug("No typecompanydepartment found with id: {}" , typecompanydepartmentId);
            throw new EntityNotFoundException(String.valueOf(typecompanydepartmentId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
    @Override
    public Page<TypeCompanyDepartment> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all typecompanydepartments");
        return this.wmGenericDao.search(queryFilters, pageable);
    }
    
    @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
    @Override
    public Page<TypeCompanyDepartment> findAll(Pageable pageable) {
        LOGGER.debug("Finding all typecompanydepartments");
        return this.wmGenericDao.search(null, pageable);
    }

    @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
    @Override
    public TypeCompanyDepartment findById(Integer id) throws EntityNotFoundException {
        LOGGER.debug("Finding typecompanydepartment by id: {}" , id);
        TypeCompanyDepartment typecompanydepartment=this.wmGenericDao.findById(id);
        if(typecompanydepartment==null){
            LOGGER.debug("No typecompanydepartment found with id: {}" , id);
            throw new EntityNotFoundException(String.valueOf(id));
        }
        return typecompanydepartment;
    }
    @Transactional(rollbackFor = EntityNotFoundException.class, value = "Dynamohr126tabsTransactionManager")
    @Override
    public TypeCompanyDepartment update(TypeCompanyDepartment updated) throws EntityNotFoundException {
        LOGGER.debug("Updating typecompanydepartment with information: {}" , updated);
        this.wmGenericDao.update(updated);

        Integer id = (Integer)updated.getIdTypeCompanyDepartment();

        return this.wmGenericDao.findById(id);
    }

    @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
    @Override
    public long countAll() {
        return this.wmGenericDao.count();
    }
}


