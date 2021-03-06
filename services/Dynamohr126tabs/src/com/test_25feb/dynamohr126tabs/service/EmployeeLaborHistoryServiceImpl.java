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
 * ServiceImpl object for domain model class EmployeeLaborHistory.
 * @see com.test_25feb.dynamohr126tabs.EmployeeLaborHistory
 */
@Service("Dynamohr126tabs.EmployeeLaborHistoryService")
public class EmployeeLaborHistoryServiceImpl implements EmployeeLaborHistoryService {


    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeLaborHistoryServiceImpl.class);

    @Autowired
    @Qualifier("Dynamohr126tabs.EmployeeLaborHistoryDao")
    private WMGenericDao<EmployeeLaborHistory, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<EmployeeLaborHistory, Integer> wmGenericDao){
        this.wmGenericDao = wmGenericDao;
    }
     @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
     public Page<EmployeeLaborHistory> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable){
          LOGGER.debug("Fetching all associated");
          return this.wmGenericDao.getAssociatedObjects(value, entityName, key, pageable);
     }

    @Transactional(value = "Dynamohr126tabsTransactionManager")
    @Override
    public EmployeeLaborHistory create(EmployeeLaborHistory employeelaborhistory) {
        LOGGER.debug("Creating a new employeelaborhistory with information: {}" , employeelaborhistory);
        return this.wmGenericDao.create(employeelaborhistory);
    }

    @Transactional(rollbackFor = EntityNotFoundException.class, value = "Dynamohr126tabsTransactionManager")
    @Override
    public EmployeeLaborHistory delete(Integer employeelaborhistoryId) throws EntityNotFoundException {
        LOGGER.debug("Deleting employeelaborhistory with id: {}" , employeelaborhistoryId);
        EmployeeLaborHistory deleted = this.wmGenericDao.findById(employeelaborhistoryId);
        if (deleted == null) {
            LOGGER.debug("No employeelaborhistory found with id: {}" , employeelaborhistoryId);
            throw new EntityNotFoundException(String.valueOf(employeelaborhistoryId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
    @Override
    public Page<EmployeeLaborHistory> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all employeelaborhistorys");
        return this.wmGenericDao.search(queryFilters, pageable);
    }
    
    @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
    @Override
    public Page<EmployeeLaborHistory> findAll(Pageable pageable) {
        LOGGER.debug("Finding all employeelaborhistorys");
        return this.wmGenericDao.search(null, pageable);
    }

    @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
    @Override
    public EmployeeLaborHistory findById(Integer id) throws EntityNotFoundException {
        LOGGER.debug("Finding employeelaborhistory by id: {}" , id);
        EmployeeLaborHistory employeelaborhistory=this.wmGenericDao.findById(id);
        if(employeelaborhistory==null){
            LOGGER.debug("No employeelaborhistory found with id: {}" , id);
            throw new EntityNotFoundException(String.valueOf(id));
        }
        return employeelaborhistory;
    }
    @Transactional(rollbackFor = EntityNotFoundException.class, value = "Dynamohr126tabsTransactionManager")
    @Override
    public EmployeeLaborHistory update(EmployeeLaborHistory updated) throws EntityNotFoundException {
        LOGGER.debug("Updating employeelaborhistory with information: {}" , updated);
        this.wmGenericDao.update(updated);

        Integer id = (Integer)updated.getIdEmployeeLaborHistory();

        return this.wmGenericDao.findById(id);
    }

    @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
    @Override
    public long countAll() {
        return this.wmGenericDao.count();
    }
}


