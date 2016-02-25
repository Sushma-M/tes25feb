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
 * ServiceImpl object for domain model class Country.
 * @see com.test_25feb.dynamohr126tabs.Country
 */
@Service("Dynamohr126tabs.CountryService")
public class CountryServiceImpl implements CountryService {


    private static final Logger LOGGER = LoggerFactory.getLogger(CountryServiceImpl.class);

    @Autowired
    @Qualifier("Dynamohr126tabs.CountryDao")
    private WMGenericDao<Country, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Country, Integer> wmGenericDao){
        this.wmGenericDao = wmGenericDao;
    }
     @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
     public Page<Country> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable){
          LOGGER.debug("Fetching all associated");
          return this.wmGenericDao.getAssociatedObjects(value, entityName, key, pageable);
     }

    @Transactional(value = "Dynamohr126tabsTransactionManager")
    @Override
    public Country create(Country country) {
        LOGGER.debug("Creating a new country with information: {}" , country);
        return this.wmGenericDao.create(country);
    }

    @Transactional(rollbackFor = EntityNotFoundException.class, value = "Dynamohr126tabsTransactionManager")
    @Override
    public Country delete(Integer countryId) throws EntityNotFoundException {
        LOGGER.debug("Deleting country with id: {}" , countryId);
        Country deleted = this.wmGenericDao.findById(countryId);
        if (deleted == null) {
            LOGGER.debug("No country found with id: {}" , countryId);
            throw new EntityNotFoundException(String.valueOf(countryId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
    @Override
    public Page<Country> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all countrys");
        return this.wmGenericDao.search(queryFilters, pageable);
    }
    
    @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
    @Override
    public Page<Country> findAll(Pageable pageable) {
        LOGGER.debug("Finding all countrys");
        return this.wmGenericDao.search(null, pageable);
    }

    @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
    @Override
    public Country findById(Integer id) throws EntityNotFoundException {
        LOGGER.debug("Finding country by id: {}" , id);
        Country country=this.wmGenericDao.findById(id);
        if(country==null){
            LOGGER.debug("No country found with id: {}" , id);
            throw new EntityNotFoundException(String.valueOf(id));
        }
        return country;
    }
    @Transactional(rollbackFor = EntityNotFoundException.class, value = "Dynamohr126tabsTransactionManager")
    @Override
    public Country update(Country updated) throws EntityNotFoundException {
        LOGGER.debug("Updating country with information: {}" , updated);
        this.wmGenericDao.update(updated);

        Integer id = (Integer)updated.getIdCountry();

        return this.wmGenericDao.findById(id);
    }

    @Transactional(readOnly = true, value = "Dynamohr126tabsTransactionManager")
    @Override
    public long countAll() {
        return this.wmGenericDao.count();
    }
}


