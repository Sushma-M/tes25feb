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
 * ServiceImpl object for domain model class RolePermission.
 * @see com.test_25feb.dynamohr126tabs.RolePermission
 */
@Service("Dynamohr126tabs.RolePermissionService")
public class RolePermissionServiceImpl implements RolePermissionService {


    private static final Logger LOGGER = LoggerFactory.getLogger(RolePermissionServiceImpl.class);

    @Autowired
    @Qualifier("Dynamohr126tabs.RolePermissionDao")
    private WMGenericDao<RolePermission, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<RolePermission, Integer> wmGenericDao){
        this.wmGenericDao = wmGenericDao;
    }
     @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
     public Page<RolePermission> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable){
          LOGGER.debug("Fetching all associated");
          return this.wmGenericDao.getAssociatedObjects(value, entityName, key, pageable);
     }

    @Transactional(value = "Dynamohr126tabsTransactionManager")
    @Override
    public RolePermission create(RolePermission rolepermission) {
        LOGGER.debug("Creating a new rolepermission with information: {}" , rolepermission);
        return this.wmGenericDao.create(rolepermission);
    }

    @Transactional(rollbackFor = EntityNotFoundException.class, value = "Dynamohr126tabsTransactionManager")
    @Override
    public RolePermission delete(Integer rolepermissionId) throws EntityNotFoundException {
        LOGGER.debug("Deleting rolepermission with id: {}" , rolepermissionId);
        RolePermission deleted = this.wmGenericDao.findById(rolepermissionId);
        if (deleted == null) {
            LOGGER.debug("No rolepermission found with id: {}" , rolepermissionId);
            throw new EntityNotFoundException(String.valueOf(rolepermissionId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
    @Override
    public Page<RolePermission> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all rolepermissions");
        return this.wmGenericDao.search(queryFilters, pageable);
    }
    
    @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
    @Override
    public Page<RolePermission> findAll(Pageable pageable) {
        LOGGER.debug("Finding all rolepermissions");
        return this.wmGenericDao.search(null, pageable);
    }

    @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
    @Override
    public RolePermission findById(Integer id) throws EntityNotFoundException {
        LOGGER.debug("Finding rolepermission by id: {}" , id);
        RolePermission rolepermission=this.wmGenericDao.findById(id);
        if(rolepermission==null){
            LOGGER.debug("No rolepermission found with id: {}" , id);
            throw new EntityNotFoundException(String.valueOf(id));
        }
        return rolepermission;
    }
    @Transactional(rollbackFor = EntityNotFoundException.class, value = "Dynamohr126tabsTransactionManager")
    @Override
    public RolePermission update(RolePermission updated) throws EntityNotFoundException {
        LOGGER.debug("Updating rolepermission with information: {}" , updated);
        this.wmGenericDao.update(updated);

        Integer id = (Integer)updated.getIdRolePermission();

        return this.wmGenericDao.findById(id);
    }

    @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
    @Override
    public long countAll() {
        return this.wmGenericDao.count();
    }
}


