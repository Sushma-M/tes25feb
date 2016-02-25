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
 * ServiceImpl object for domain model class ApplicantAppointment.
 * @see com.test_25feb.dynamohr126tabs.ApplicantAppointment
 */
@Service("Dynamohr126tabs.ApplicantAppointmentService")
public class ApplicantAppointmentServiceImpl implements ApplicantAppointmentService {


    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicantAppointmentServiceImpl.class);

    @Autowired
    @Qualifier("Dynamohr126tabs.ApplicantAppointmentDao")
    private WMGenericDao<ApplicantAppointment, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<ApplicantAppointment, Integer> wmGenericDao){
        this.wmGenericDao = wmGenericDao;
    }
     @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
     public Page<ApplicantAppointment> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable){
          LOGGER.debug("Fetching all associated");
          return this.wmGenericDao.getAssociatedObjects(value, entityName, key, pageable);
     }

    @Transactional(value = "Dynamohr126tabsTransactionManager")
    @Override
    public ApplicantAppointment create(ApplicantAppointment applicantappointment) {
        LOGGER.debug("Creating a new applicantappointment with information: {}" , applicantappointment);
        return this.wmGenericDao.create(applicantappointment);
    }

    @Transactional(rollbackFor = EntityNotFoundException.class, value = "Dynamohr126tabsTransactionManager")
    @Override
    public ApplicantAppointment delete(Integer applicantappointmentId) throws EntityNotFoundException {
        LOGGER.debug("Deleting applicantappointment with id: {}" , applicantappointmentId);
        ApplicantAppointment deleted = this.wmGenericDao.findById(applicantappointmentId);
        if (deleted == null) {
            LOGGER.debug("No applicantappointment found with id: {}" , applicantappointmentId);
            throw new EntityNotFoundException(String.valueOf(applicantappointmentId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
    @Override
    public Page<ApplicantAppointment> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all applicantappointments");
        return this.wmGenericDao.search(queryFilters, pageable);
    }
    
    @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
    @Override
    public Page<ApplicantAppointment> findAll(Pageable pageable) {
        LOGGER.debug("Finding all applicantappointments");
        return this.wmGenericDao.search(null, pageable);
    }

    @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
    @Override
    public ApplicantAppointment findById(Integer id) throws EntityNotFoundException {
        LOGGER.debug("Finding applicantappointment by id: {}" , id);
        ApplicantAppointment applicantappointment=this.wmGenericDao.findById(id);
        if(applicantappointment==null){
            LOGGER.debug("No applicantappointment found with id: {}" , id);
            throw new EntityNotFoundException(String.valueOf(id));
        }
        return applicantappointment;
    }
    @Transactional(rollbackFor = EntityNotFoundException.class, value = "Dynamohr126tabsTransactionManager")
    @Override
    public ApplicantAppointment update(ApplicantAppointment updated) throws EntityNotFoundException {
        LOGGER.debug("Updating applicantappointment with information: {}" , updated);
        this.wmGenericDao.update(updated);

        Integer id = (Integer)updated.getIdApplicantAppointment();

        return this.wmGenericDao.findById(id);
    }

    @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
    @Override
    public long countAll() {
        return this.wmGenericDao.count();
    }
}

