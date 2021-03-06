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
 * ServiceImpl object for domain model class CompanyInfo.
 * @see com.test_25feb.dynamohr126tabs.CompanyInfo
 */
@Service("Dynamohr126tabs.CompanyInfoService")
public class CompanyInfoServiceImpl implements CompanyInfoService {


    private static final Logger LOGGER = LoggerFactory.getLogger(CompanyInfoServiceImpl.class);

    @Autowired
    @Qualifier("Dynamohr126tabs.CompanyInfoDao")
    private WMGenericDao<CompanyInfo, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<CompanyInfo, Integer> wmGenericDao){
        this.wmGenericDao = wmGenericDao;
    }
     @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
     public Page<CompanyInfo> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable){
          LOGGER.debug("Fetching all associated");
          return this.wmGenericDao.getAssociatedObjects(value, entityName, key, pageable);
     }

    @Transactional(value = "Dynamohr126tabsTransactionManager")
    @Override
    public CompanyInfo create(CompanyInfo companyinfo) {
        LOGGER.debug("Creating a new companyinfo with information: {}" , companyinfo);
        return this.wmGenericDao.create(companyinfo);
    }

    @Transactional(rollbackFor = EntityNotFoundException.class, value = "Dynamohr126tabsTransactionManager")
    @Override
    public CompanyInfo delete(Integer companyinfoId) throws EntityNotFoundException {
        LOGGER.debug("Deleting companyinfo with id: {}" , companyinfoId);
        CompanyInfo deleted = this.wmGenericDao.findById(companyinfoId);
        if (deleted == null) {
            LOGGER.debug("No companyinfo found with id: {}" , companyinfoId);
            throw new EntityNotFoundException(String.valueOf(companyinfoId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
    @Override
    public Page<CompanyInfo> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all companyinfos");
        return this.wmGenericDao.search(queryFilters, pageable);
    }
    
    @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
    @Override
    public Page<CompanyInfo> findAll(Pageable pageable) {
        LOGGER.debug("Finding all companyinfos");
        return this.wmGenericDao.search(null, pageable);
    }

    @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
    @Override
    public CompanyInfo findById(Integer id) throws EntityNotFoundException {
        LOGGER.debug("Finding companyinfo by id: {}" , id);
        CompanyInfo companyinfo=this.wmGenericDao.findById(id);
        if(companyinfo==null){
            LOGGER.debug("No companyinfo found with id: {}" , id);
            throw new EntityNotFoundException(String.valueOf(id));
        }
        return companyinfo;
    }
    @Transactional(rollbackFor = EntityNotFoundException.class, value = "Dynamohr126tabsTransactionManager")
    @Override
    public CompanyInfo update(CompanyInfo updated) throws EntityNotFoundException {
        LOGGER.debug("Updating companyinfo with information: {}" , updated);
        this.wmGenericDao.update(updated);

        Integer id = (Integer)updated.getIdCompanyInfo();

        return this.wmGenericDao.findById(id);
    }

    @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
    @Override
    public long countAll() {
        return this.wmGenericDao.count();
    }
}


