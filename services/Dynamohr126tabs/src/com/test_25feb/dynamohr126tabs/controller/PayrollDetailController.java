/*Copyright (c) 2016-2017 gmail.com All Rights Reserved.
 This software is the confidential and proprietary information of gmail.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with gmail.com*/

package com.test_25feb.dynamohr126tabs.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import com.test_25feb.dynamohr126tabs.service.BonusEventualService;
import com.test_25feb.dynamohr126tabs.service.DeductionEventualService;
import com.test_25feb.dynamohr126tabs.service.ListCommissionPayrollService;
import com.test_25feb.dynamohr126tabs.service.ListLoanDetailPayrollService;
import com.test_25feb.dynamohr126tabs.service.ListOvertimePayrollService;
import com.test_25feb.dynamohr126tabs.service.ListPeriodicBonusPayrollService;
import com.test_25feb.dynamohr126tabs.service.ListPeriodicDeductionPayrollService;
import com.test_25feb.dynamohr126tabs.service.ListTravelExpenseDetailService;
import com.test_25feb.dynamohr126tabs.service.PaymentCheckService;
import com.test_25feb.dynamohr126tabs.service.PayrollDetailService;


import java.io.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.hibernate.TypeMismatchException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.util.WMMultipartUtils;
import com.wavemaker.runtime.util.WMRuntimeUtils;
import com.wavemaker.runtime.file.model.DownloadResponse;
import com.wordnik.swagger.annotations.*;

import com.test_25feb.dynamohr126tabs.*;
import com.test_25feb.dynamohr126tabs.service.*;


/**
 * Controller object for domain model class PayrollDetail.
 * @see com.test_25feb.dynamohr126tabs.PayrollDetail
 */

@RestController(value = "Dynamohr126tabs.PayrollDetailController")
@Api(value = "/Dynamohr126tabs/PayrollDetail", description = "Exposes APIs to work with PayrollDetail resource.")
@RequestMapping("/Dynamohr126tabs/PayrollDetail")
public class PayrollDetailController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PayrollDetailController.class);

	@Autowired
	@Qualifier("Dynamohr126tabs.PayrollDetailService")
	private PayrollDetailService payrollDetailService;


    @Autowired
    @Qualifier("Dynamohr126tabs.ListPeriodicDeductionPayrollService")
    private ListPeriodicDeductionPayrollService listPeriodicDeductionPayrollService;


    @Autowired
    @Qualifier("Dynamohr126tabs.ListOvertimePayrollService")
    private ListOvertimePayrollService listOvertimePayrollService;


    @Autowired
    @Qualifier("Dynamohr126tabs.DeductionEventualService")
    private DeductionEventualService deductionEventualService;


    @Autowired
    @Qualifier("Dynamohr126tabs.BonusEventualService")
    private BonusEventualService bonusEventualService;


    @Autowired
    @Qualifier("Dynamohr126tabs.ListPeriodicBonusPayrollService")
    private ListPeriodicBonusPayrollService listPeriodicBonusPayrollService;


    @Autowired
    @Qualifier("Dynamohr126tabs.ListTravelExpenseDetailService")
    private ListTravelExpenseDetailService listTravelExpenseDetailService;


    @Autowired
    @Qualifier("Dynamohr126tabs.ListLoanDetailPayrollService")
    private ListLoanDetailPayrollService listLoanDetailPayrollService;


    @Autowired
    @Qualifier("Dynamohr126tabs.PaymentCheckService")
    private PaymentCheckService paymentCheckService;


    @Autowired
    @Qualifier("Dynamohr126tabs.ListCommissionPayrollService")
    private ListCommissionPayrollService listCommissionPayrollService;


	@RequestMapping(value = "/search", method = RequestMethod.POST)
	@ApiOperation(value = "Returns the list of PayrollDetail instances matching the search criteria.")
	public Page<PayrollDetail> findPayrollDetails( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
		LOGGER.debug("Rendering PayrollDetails list");
		return payrollDetailService.findAll(queryFilters, pageable);
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ApiOperation(value = "Returns the list of PayrollDetail instances.")
	public Page<PayrollDetail> getPayrollDetails(Pageable pageable) {
		LOGGER.debug("Rendering PayrollDetails list");
		return payrollDetailService.findAll(pageable);
	}

	@RequestMapping(value = "/count", method = RequestMethod.GET)
	@ApiOperation(value = "Returns the total count of PayrollDetail instances.")
	public Long countAllPayrollDetails() {
		LOGGER.debug("counting PayrollDetails");
		Long count = payrollDetailService.countAll();
		return count;
	}


    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @ApiOperation(value = "Returns the PayrollDetail instance associated with the given id.")
    public PayrollDetail getPayrollDetail(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting PayrollDetail with id: {}" , id);
        PayrollDetail instance = payrollDetailService.findById(id);
        LOGGER.debug("PayrollDetail details with id: {}" , instance);
        return instance;
    }
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @ApiOperation(value = "Deletes the PayrollDetail instance associated with the given id.")
    public boolean deletePayrollDetail(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting PayrollDetail with id: {}" , id);
        PayrollDetail deleted = payrollDetailService.delete(id);
        return deleted != null;
    }

    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @ApiOperation(value = "Updates the PayrollDetail instance associated with the given id.")
    public PayrollDetail editPayrollDetail(@PathVariable("id") Integer id, @RequestBody PayrollDetail instance) throws EntityNotFoundException {
        LOGGER.debug("Editing PayrollDetail with id: {}" , instance.getIdPayrollDetail());
        instance.setIdPayrollDetail(id);
        instance = payrollDetailService.update(instance);
        LOGGER.debug("PayrollDetail details with id: {}" , instance);
        return instance;
    }


    @RequestMapping(value="/{id:.+}/listPeriodicBonusPayrolls", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the listPeriodicBonusPayrolls instance associated with the given id.")
     public Page<ListPeriodicBonusPayroll> findAssociatedlistPeriodicBonusPayrolls(Pageable pageable, @PathVariable("id") Integer id){
        LOGGER.debug("Fetching all associated listPeriodicBonusPayrolls");
        return listPeriodicBonusPayrollService.findAssociatedValues(id,"payrollDetail","idPayrollDetail", pageable);
   }

    @RequestMapping(value="/{id:.+}/listLoanDetailPayrolls", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the listLoanDetailPayrolls instance associated with the given id.")
     public Page<ListLoanDetailPayroll> findAssociatedlistLoanDetailPayrolls(Pageable pageable, @PathVariable("id") Integer id){
        LOGGER.debug("Fetching all associated listLoanDetailPayrolls");
        return listLoanDetailPayrollService.findAssociatedValues(id,"payrollDetail","idPayrollDetail", pageable);
   }

    @RequestMapping(value="/{id:.+}/listTravelExpenseDetails", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the listTravelExpenseDetails instance associated with the given id.")
     public Page<ListTravelExpenseDetail> findAssociatedlistTravelExpenseDetails(Pageable pageable, @PathVariable("id") Integer id){
        LOGGER.debug("Fetching all associated listTravelExpenseDetails");
        return listTravelExpenseDetailService.findAssociatedValues(id,"payrollDetail","idPayrollDetail", pageable);
   }

    @RequestMapping(value="/{id:.+}/bonusEventuals", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the bonusEventuals instance associated with the given id.")
     public Page<BonusEventual> findAssociatedbonusEventuals(Pageable pageable, @PathVariable("id") Integer id){
        LOGGER.debug("Fetching all associated bonusEventuals");
        return bonusEventualService.findAssociatedValues(id,"payrollDetail","idPayrollDetail", pageable);
   }

    @RequestMapping(value="/{id:.+}/paymentChecks", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the paymentChecks instance associated with the given id.")
     public Page<PaymentCheck> findAssociatedpaymentChecks(Pageable pageable, @PathVariable("id") Integer id){
        LOGGER.debug("Fetching all associated paymentChecks");
        return paymentCheckService.findAssociatedValues(id,"payrollDetail","idPayrollDetail", pageable);
   }

    @RequestMapping(value="/{id:.+}/deductionEventuals", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the deductionEventuals instance associated with the given id.")
     public Page<DeductionEventual> findAssociateddeductionEventuals(Pageable pageable, @PathVariable("id") Integer id){
        LOGGER.debug("Fetching all associated deductionEventuals");
        return deductionEventualService.findAssociatedValues(id,"payrollDetail","idPayrollDetail", pageable);
   }

    @RequestMapping(value="/{id:.+}/listPeriodicDeductionPayrolls", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the listPeriodicDeductionPayrolls instance associated with the given id.")
     public Page<ListPeriodicDeductionPayroll> findAssociatedlistPeriodicDeductionPayrolls(Pageable pageable, @PathVariable("id") Integer id){
        LOGGER.debug("Fetching all associated listPeriodicDeductionPayrolls");
        return listPeriodicDeductionPayrollService.findAssociatedValues(id,"payrollDetail","idPayrollDetail", pageable);
   }

    @RequestMapping(value="/{id:.+}/listCommissionPayrolls", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the listCommissionPayrolls instance associated with the given id.")
     public Page<ListCommissionPayroll> findAssociatedlistCommissionPayrolls(Pageable pageable, @PathVariable("id") Integer id){
        LOGGER.debug("Fetching all associated listCommissionPayrolls");
        return listCommissionPayrollService.findAssociatedValues(id,"payrollDetail","idPayrollDetail", pageable);
   }

    @RequestMapping(value="/{id:.+}/listOvertimePayrolls", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the listOvertimePayrolls instance associated with the given id.")
     public Page<ListOvertimePayroll> findAssociatedlistOvertimePayrolls(Pageable pageable, @PathVariable("id") Integer id){
        LOGGER.debug("Fetching all associated listOvertimePayrolls");
        return listOvertimePayrollService.findAssociatedValues(id,"payrollDetail","idPayrollDetail", pageable);
   }



	@RequestMapping(value = "/", method = RequestMethod.POST)
	@ApiOperation(value = "Creates a new PayrollDetail instance.")
	public PayrollDetail createPayrollDetail(@RequestBody PayrollDetail instance) {
		LOGGER.debug("Create PayrollDetail with information: {}" , instance);
		instance = payrollDetailService.create(instance);
		LOGGER.debug("Created PayrollDetail with information: {}" , instance);
	    return instance;
	}

	/**
	 * This setter method should only be used by unit tests
	 * 
	 * @param service
	 */
	protected void setPayrollDetailService(PayrollDetailService service) {
		this.payrollDetailService = service;
	}
}
