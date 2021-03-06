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
 * ServiceImpl object for domain model class ApplicantToPosition.
 * @see com.test_25feb.dynamohr126tabs.ApplicantToPosition
 */
@Service("Dynamohr126tabs.ApplicantToPositionService")
public class ApplicantToPositionServiceImpl implements ApplicantToPositionService {


    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicantToPositionServiceImpl.class);

    @Autowired
    @Qualifier("Dynamohr126tabs.ApplicantToPositionDao")
    private WMGenericDao<ApplicantToPosition, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<ApplicantToPosition, Integer> wmGenericDao){
        this.wmGenericDao = wmGenericDao;
    }
     @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
     public Page<ApplicantToPosition> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable){
          LOGGER.debug("Fetching all associated");
          return this.wmGenericDao.getAssociatedObjects(value, entityName, key, pageable);
     }

    @Transactional(value = "Dynamohr126tabsTransactionManager")
    @Override
    public ApplicantToPosition create(ApplicantToPosition applicanttoposition) {
        LOGGER.debug("Creating a new applicanttoposition with information: {}" , applicanttoposition);
        return this.wmGenericDao.create(applicanttoposition);
    }

    @Transactional(rollbackFor = EntityNotFoundException.class, value = "Dynamohr126tabsTransactionManager")
    @Override
    public ApplicantToPosition delete(Integer applicanttopositionId) throws EntityNotFoundException {
        LOGGER.debug("Deleting applicanttoposition with id: {}" , applicanttopositionId);
        ApplicantToPosition deleted = this.wmGenericDao.findById(applicanttopositionId);
        if (deleted == null) {
            LOGGER.debug("No applicanttoposition found with id: {}" , applicanttopositionId);
            throw new EntityNotFoundException(String.valueOf(applicanttopositionId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
    @Override
    public Page<ApplicantToPosition> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all applicanttopositions");
        return this.wmGenericDao.search(queryFilters, pageable);
    }
    
    @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
    @Override
    public Page<ApplicantToPosition> findAll(Pageable pageable) {
        LOGGER.debug("Finding all applicanttopositions");
        return this.wmGenericDao.search(null, pageable);
    }

    @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
    @Override
    public ApplicantToPosition findById(Integer id) throws EntityNotFoundException {
        LOGGER.debug("Finding applicanttoposition by id: {}" , id);
        ApplicantToPosition applicanttoposition=this.wmGenericDao.findById(id);
        if(applicanttoposition==null){
            LOGGER.debug("No applicanttoposition found with id: {}" , id);
            throw new EntityNotFoundException(String.valueOf(id));
        }
        return applicanttoposition;
    }
    @Transactional(rollbackFor = EntityNotFoundException.class, value = "Dynamohr126tabsTransactionManager")
    @Override
    public ApplicantToPosition update(ApplicantToPosition updated) throws EntityNotFoundException {
        LOGGER.debug("Updating applicanttoposition with information: {}" , updated);
        this.wmGenericDao.update(updated);

        Integer id = (Integer)updated.getIdApplicantToPosition();

        return this.wmGenericDao.findById(id);
    }

    @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
    @Override
    public long countAll() {
        return this.wmGenericDao.count();
    }
}


