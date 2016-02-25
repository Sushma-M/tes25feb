/*Copyright (c) 2016-2017 gmail.com All Rights Reserved.
 This software is the confidential and proprietary information of gmail.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with gmail.com*/

package com.test_25feb.dynamohr126tabs.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import com.test_25feb.dynamohr126tabs.service.BonusEventualService;
import com.test_25feb.dynamohr126tabs.service.BonusPeriodicService;
import com.test_25feb.dynamohr126tabs.service.CurrencyService;
import com.test_25feb.dynamohr126tabs.service.DeductionEventualService;
import com.test_25feb.dynamohr126tabs.service.DeductionPeriodicService;
import com.test_25feb.dynamohr126tabs.service.EmployeeSalaryService;
import com.test_25feb.dynamohr126tabs.service.IsrDetailService;
import com.test_25feb.dynamohr126tabs.service.ListCelphoneDetailPayrollService;
import com.test_25feb.dynamohr126tabs.service.ListCommissionEmployeeService;
import com.test_25feb.dynamohr126tabs.service.ListCommissionPayrollService;
import com.test_25feb.dynamohr126tabs.service.ListEmployeePhoneService;
import com.test_25feb.dynamohr126tabs.service.ListLoanDetailPayrollService;
import com.test_25feb.dynamohr126tabs.service.ListOvertimePayrollService;
import com.test_25feb.dynamohr126tabs.service.ListPeriodicBonusEmployeeService;
import com.test_25feb.dynamohr126tabs.service.ListPeriodicBonusPayrollService;
import com.test_25feb.dynamohr126tabs.service.ListPeriodicDeductionEmployeeService;
import com.test_25feb.dynamohr126tabs.service.ListPeriodicDeductionPayrollService;
import com.test_25feb.dynamohr126tabs.service.ListTravelExpenseDetailService;
import com.test_25feb.dynamohr126tabs.service.LoanService;
import com.test_25feb.dynamohr126tabs.service.MobileNumberService;
import com.test_25feb.dynamohr126tabs.service.OverTimeSegmentPayrollService;
import com.test_25feb.dynamohr126tabs.service.PaymentLoanManualService;
import com.test_25feb.dynamohr126tabs.service.PayrollDetailService;
import com.test_25feb.dynamohr126tabs.service.PayrollService;
import com.test_25feb.dynamohr126tabs.service.TravelExpenseService;
import com.test_25feb.dynamohr126tabs.service.TypeExtraHourSegmentService;


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
 * Controller object for domain model class Currency.
 * @see com.test_25feb.dynamohr126tabs.Currency
 */

@RestController(value = "Dynamohr126tabs.CurrencyController")
@Api(value = "/Dynamohr126tabs/Currency", description = "Exposes APIs to work with Currency resource.")
@RequestMapping("/Dynamohr126tabs/Currency")
public class CurrencyController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CurrencyController.class);

	@Autowired
	@Qualifier("Dynamohr126tabs.CurrencyService")
	private CurrencyService currencyService;


    @Autowired
    @Qualifier("Dynamohr126tabs.PayrollDetailService")
    private PayrollDetailService payrollDetailService;


    @Autowired
    @Qualifier("Dynamohr126tabs.ListCelphoneDetailPayrollService")
    private ListCelphoneDetailPayrollService listCelphoneDetailPayrollService;


    @Autowired
    @Qualifier("Dynamohr126tabs.ListCommissionEmployeeService")
    private ListCommissionEmployeeService listCommissionEmployeeService;


    @Autowired
    @Qualifier("Dynamohr126tabs.ListPeriodicDeductionPayrollService")
    private ListPeriodicDeductionPayrollService listPeriodicDeductionPayrollService;


    @Autowired
    @Qualifier("Dynamohr126tabs.LoanService")
    private LoanService loanService;


    @Autowired
    @Qualifier("Dynamohr126tabs.ListEmployeePhoneService")
    private ListEmployeePhoneService listEmployeePhoneService;


    @Autowired
    @Qualifier("Dynamohr126tabs.DeductionEventualService")
    private DeductionEventualService deductionEventualService;


    @Autowired
    @Qualifier("Dynamohr126tabs.ListPeriodicDeductionEmployeeService")
    private ListPeriodicDeductionEmployeeService listPeriodicDeductionEmployeeService;


    @Autowired
    @Qualifier("Dynamohr126tabs.BonusPeriodicService")
    private BonusPeriodicService bonusPeriodicService;


    @Autowired
    @Qualifier("Dynamohr126tabs.ListLoanDetailPayrollService")
    private ListLoanDetailPayrollService listLoanDetailPayrollService;


    @Autowired
    @Qualifier("Dynamohr126tabs.TravelExpenseService")
    private TravelExpenseService travelExpenseService;


    @Autowired
    @Qualifier("Dynamohr126tabs.ListCommissionPayrollService")
    private ListCommissionPayrollService listCommissionPayrollService;


    @Autowired
    @Qualifier("Dynamohr126tabs.MobileNumberService")
    private MobileNumberService mobileNumberService;


    @Autowired
    @Qualifier("Dynamohr126tabs.IsrDetailService")
    private IsrDetailService isrDetailService;


    @Autowired
    @Qualifier("Dynamohr126tabs.ListPeriodicBonusPayrollService")
    private ListPeriodicBonusPayrollService listPeriodicBonusPayrollService;


    @Autowired
    @Qualifier("Dynamohr126tabs.ListTravelExpenseDetailService")
    private ListTravelExpenseDetailService listTravelExpenseDetailService;


    @Autowired
    @Qualifier("Dynamohr126tabs.PayrollService")
    private PayrollService payrollService;


    @Autowired
    @Qualifier("Dynamohr126tabs.EmployeeSalaryService")
    private EmployeeSalaryService employeeSalaryService;


    @Autowired
    @Qualifier("Dynamohr126tabs.ListPeriodicBonusEmployeeService")
    private ListPeriodicBonusEmployeeService listPeriodicBonusEmployeeService;


    @Autowired
    @Qualifier("Dynamohr126tabs.TypeExtraHourSegmentService")
    private TypeExtraHourSegmentService typeExtraHourSegmentService;


    @Autowired
    @Qualifier("Dynamohr126tabs.BonusEventualService")
    private BonusEventualService bonusEventualService;


    @Autowired
    @Qualifier("Dynamohr126tabs.ListOvertimePayrollService")
    private ListOvertimePayrollService listOvertimePayrollService;


    @Autowired
    @Qualifier("Dynamohr126tabs.PaymentLoanManualService")
    private PaymentLoanManualService paymentLoanManualService;


    @Autowired
    @Qualifier("Dynamohr126tabs.OverTimeSegmentPayrollService")
    private OverTimeSegmentPayrollService overTimeSegmentPayrollService;


    @Autowired
    @Qualifier("Dynamohr126tabs.DeductionPeriodicService")
    private DeductionPeriodicService deductionPeriodicService;


	@RequestMapping(value = "/search", method = RequestMethod.POST)
	@ApiOperation(value = "Returns the list of Currency instances matching the search criteria.")
	public Page<Currency> findCurrencys( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
		LOGGER.debug("Rendering Currencys list");
		return currencyService.findAll(queryFilters, pageable);
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ApiOperation(value = "Returns the list of Currency instances.")
	public Page<Currency> getCurrencys(Pageable pageable) {
		LOGGER.debug("Rendering Currencys list");
		return currencyService.findAll(pageable);
	}

	@RequestMapping(value = "/count", method = RequestMethod.GET)
	@ApiOperation(value = "Returns the total count of Currency instances.")
	public Long countAllCurrencys() {
		LOGGER.debug("counting Currencys");
		Long count = currencyService.countAll();
		return count;
	}


    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @ApiOperation(value = "Returns the Currency instance associated with the given id.")
    public Currency getCurrency(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting Currency with id: {}" , id);
        Currency instance = currencyService.findById(id);
        LOGGER.debug("Currency details with id: {}" , instance);
        return instance;
    }
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @ApiOperation(value = "Deletes the Currency instance associated with the given id.")
    public boolean deleteCurrency(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting Currency with id: {}" , id);
        Currency deleted = currencyService.delete(id);
        return deleted != null;
    }

    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @ApiOperation(value = "Updates the Currency instance associated with the given id.")
    public Currency editCurrency(@PathVariable("id") Integer id, @RequestBody Currency instance) throws EntityNotFoundException {
        LOGGER.debug("Editing Currency with id: {}" , instance.getIdCurrency());
        instance.setIdCurrency(id);
        instance = currencyService.update(instance);
        LOGGER.debug("Currency details with id: {}" , instance);
        return instance;
    }


    @RequestMapping(value="/{id:.+}/listPeriodicBonusPayrolls", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the listPeriodicBonusPayrolls instance associated with the given id.")
     public Page<ListPeriodicBonusPayroll> findAssociatedlistPeriodicBonusPayrolls(Pageable pageable, @PathVariable("id") Integer id){
        LOGGER.debug("Fetching all associated listPeriodicBonusPayrolls");
        return listPeriodicBonusPayrollService.findAssociatedValues(id,"currency","idCurrency", pageable);
   }

    @RequestMapping(value="/{id:.+}/listLoanDetailPayrolls", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the listLoanDetailPayrolls instance associated with the given id.")
     public Page<ListLoanDetailPayroll> findAssociatedlistLoanDetailPayrolls(Pageable pageable, @PathVariable("id") Integer id){
        LOGGER.debug("Fetching all associated listLoanDetailPayrolls");
        return listLoanDetailPayrollService.findAssociatedValues(id,"currency","idCurrency", pageable);
   }

    @RequestMapping(value="/{id:.+}/listCommissionEmployees", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the listCommissionEmployees instance associated with the given id.")
     public Page<ListCommissionEmployee> findAssociatedlistCommissionEmployees(Pageable pageable, @PathVariable("id") Integer id){
        LOGGER.debug("Fetching all associated listCommissionEmployees");
        return listCommissionEmployeeService.findAssociatedValues(id,"currency","idCurrency", pageable);
   }

    @RequestMapping(value="/{id:.+}/listPeriodicBonusEmployees", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the listPeriodicBonusEmployees instance associated with the given id.")
     public Page<ListPeriodicBonusEmployee> findAssociatedlistPeriodicBonusEmployees(Pageable pageable, @PathVariable("id") Integer id){
        LOGGER.debug("Fetching all associated listPeriodicBonusEmployees");
        return listPeriodicBonusEmployeeService.findAssociatedValues(id,"currency","idCurrency", pageable);
   }

    @RequestMapping(value="/{id:.+}/deductionPeriodics", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the deductionPeriodics instance associated with the given id.")
     public Page<DeductionPeriodic> findAssociateddeductionPeriodics(Pageable pageable, @PathVariable("id") Integer id){
        LOGGER.debug("Fetching all associated deductionPeriodics");
        return deductionPeriodicService.findAssociatedValues(id,"currency","idCurrency", pageable);
   }

    @RequestMapping(value="/{id:.+}/mobileNumbers", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the mobileNumbers instance associated with the given id.")
     public Page<MobileNumber> findAssociatedmobileNumbers(Pageable pageable, @PathVariable("id") Integer id){
        LOGGER.debug("Fetching all associated mobileNumbers");
        return mobileNumberService.findAssociatedValues(id,"currency","idCurrency", pageable);
   }

    @RequestMapping(value="/{id:.+}/payrolls", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the payrolls instance associated with the given id.")
     public Page<Payroll> findAssociatedpayrolls(Pageable pageable, @PathVariable("id") Integer id){
        LOGGER.debug("Fetching all associated payrolls");
        return payrollService.findAssociatedValues(id,"currency","idCurrency", pageable);
   }

    @RequestMapping(value="/{id:.+}/typeExtraHourSegments", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the typeExtraHourSegments instance associated with the given id.")
     public Page<TypeExtraHourSegment> findAssociatedtypeExtraHourSegments(Pageable pageable, @PathVariable("id") Integer id){
        LOGGER.debug("Fetching all associated typeExtraHourSegments");
        return typeExtraHourSegmentService.findAssociatedValues(id,"currency","idCurrency", pageable);
   }

    @RequestMapping(value="/{id:.+}/listPeriodicDeductionEmployees", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the listPeriodicDeductionEmployees instance associated with the given id.")
     public Page<ListPeriodicDeductionEmployee> findAssociatedlistPeriodicDeductionEmployees(Pageable pageable, @PathVariable("id") Integer id){
        LOGGER.debug("Fetching all associated listPeriodicDeductionEmployees");
        return listPeriodicDeductionEmployeeService.findAssociatedValues(id,"currency","idCurrency", pageable);
   }

    @RequestMapping(value="/{id:.+}/bonusEventuals", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the bonusEventuals instance associated with the given id.")
     public Page<BonusEventual> findAssociatedbonusEventuals(Pageable pageable, @PathVariable("id") Integer id){
        LOGGER.debug("Fetching all associated bonusEventuals");
        return bonusEventualService.findAssociatedValues(id,"currency","idCurrency", pageable);
   }

    @RequestMapping(value="/{id:.+}/deductionEventuals", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the deductionEventuals instance associated with the given id.")
     public Page<DeductionEventual> findAssociateddeductionEventuals(Pageable pageable, @PathVariable("id") Integer id){
        LOGGER.debug("Fetching all associated deductionEventuals");
        return deductionEventualService.findAssociatedValues(id,"currency","idCurrency", pageable);
   }

    @RequestMapping(value="/{id:.+}/listPeriodicDeductionPayrolls", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the listPeriodicDeductionPayrolls instance associated with the given id.")
     public Page<ListPeriodicDeductionPayroll> findAssociatedlistPeriodicDeductionPayrolls(Pageable pageable, @PathVariable("id") Integer id){
        LOGGER.debug("Fetching all associated listPeriodicDeductionPayrolls");
        return listPeriodicDeductionPayrollService.findAssociatedValues(id,"currency","idCurrency", pageable);
   }

    @RequestMapping(value="/{id:.+}/listOvertimePayrolls", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the listOvertimePayrolls instance associated with the given id.")
     public Page<ListOvertimePayroll> findAssociatedlistOvertimePayrolls(Pageable pageable, @PathVariable("id") Integer id){
        LOGGER.debug("Fetching all associated listOvertimePayrolls");
        return listOvertimePayrollService.findAssociatedValues(id,"currency","idCurrency", pageable);
   }

    @RequestMapping(value="/{id:.+}/travelExpenses", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the travelExpenses instance associated with the given id.")
     public Page<TravelExpense> findAssociatedtravelExpenses(Pageable pageable, @PathVariable("id") Integer id){
        LOGGER.debug("Fetching all associated travelExpenses");
        return travelExpenseService.findAssociatedValues(id,"currency","idCurrency", pageable);
   }

    @RequestMapping(value="/{id:.+}/loans", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the loans instance associated with the given id.")
     public Page<Loan> findAssociatedloans(Pageable pageable, @PathVariable("id") Integer id){
        LOGGER.debug("Fetching all associated loans");
        return loanService.findAssociatedValues(id,"currency","idCurrency", pageable);
   }

    @RequestMapping(value="/{id:.+}/overTimeSegmentPayrolls", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the overTimeSegmentPayrolls instance associated with the given id.")
     public Page<OverTimeSegmentPayroll> findAssociatedoverTimeSegmentPayrolls(Pageable pageable, @PathVariable("id") Integer id){
        LOGGER.debug("Fetching all associated overTimeSegmentPayrolls");
        return overTimeSegmentPayrollService.findAssociatedValues(id,"currency","idCurrency", pageable);
   }

    @RequestMapping(value="/{id:.+}/payrollDetails", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the payrollDetails instance associated with the given id.")
     public Page<PayrollDetail> findAssociatedpayrollDetails(Pageable pageable, @PathVariable("id") Integer id){
        LOGGER.debug("Fetching all associated payrollDetails");
        return payrollDetailService.findAssociatedValues(id,"currency","idCurrency", pageable);
   }

    @RequestMapping(value="/{id:.+}/listCelphoneDetailPayrolls", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the listCelphoneDetailPayrolls instance associated with the given id.")
     public Page<ListCelphoneDetailPayroll> findAssociatedlistCelphoneDetailPayrolls(Pageable pageable, @PathVariable("id") Integer id){
        LOGGER.debug("Fetching all associated listCelphoneDetailPayrolls");
        return listCelphoneDetailPayrollService.findAssociatedValues(id,"currency","idCurrency", pageable);
   }

    @RequestMapping(value="/{id:.+}/employeeSalaries", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the employeeSalaries instance associated with the given id.")
     public Page<EmployeeSalary> findAssociatedemployeeSalaries(Pageable pageable, @PathVariable("id") Integer id){
        LOGGER.debug("Fetching all associated employeeSalaries");
        return employeeSalaryService.findAssociatedValues(id,"currency","idCurrency", pageable);
   }

    @RequestMapping(value="/{id:.+}/paymentLoanManuals", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the paymentLoanManuals instance associated with the given id.")
     public Page<PaymentLoanManual> findAssociatedpaymentLoanManuals(Pageable pageable, @PathVariable("id") Integer id){
        LOGGER.debug("Fetching all associated paymentLoanManuals");
        return paymentLoanManualService.findAssociatedValues(id,"currency","idCurrency", pageable);
   }

    @RequestMapping(value="/{id:.+}/listTravelExpenseDetails", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the listTravelExpenseDetails instance associated with the given id.")
     public Page<ListTravelExpenseDetail> findAssociatedlistTravelExpenseDetails(Pageable pageable, @PathVariable("id") Integer id){
        LOGGER.debug("Fetching all associated listTravelExpenseDetails");
        return listTravelExpenseDetailService.findAssociatedValues(id,"currency","idCurrency", pageable);
   }

    @RequestMapping(value="/{id:.+}/listEmployeePhones", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the listEmployeePhones instance associated with the given id.")
     public Page<ListEmployeePhone> findAssociatedlistEmployeePhones(Pageable pageable, @PathVariable("id") Integer id){
        LOGGER.debug("Fetching all associated listEmployeePhones");
        return listEmployeePhoneService.findAssociatedValues(id,"currency","idCurrency", pageable);
   }

    @RequestMapping(value="/{id:.+}/isrDetails", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the isrDetails instance associated with the given id.")
     public Page<IsrDetail> findAssociatedisrDetails(Pageable pageable, @PathVariable("id") Integer id){
        LOGGER.debug("Fetching all associated isrDetails");
        return isrDetailService.findAssociatedValues(id,"currency","idCurrency", pageable);
   }

    @RequestMapping(value="/{id:.+}/listCommissionPayrolls", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the listCommissionPayrolls instance associated with the given id.")
     public Page<ListCommissionPayroll> findAssociatedlistCommissionPayrolls(Pageable pageable, @PathVariable("id") Integer id){
        LOGGER.debug("Fetching all associated listCommissionPayrolls");
        return listCommissionPayrollService.findAssociatedValues(id,"currency","idCurrency", pageable);
   }

    @RequestMapping(value="/{id:.+}/bonusPeriodics", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the bonusPeriodics instance associated with the given id.")
     public Page<BonusPeriodic> findAssociatedbonusPeriodics(Pageable pageable, @PathVariable("id") Integer id){
        LOGGER.debug("Fetching all associated bonusPeriodics");
        return bonusPeriodicService.findAssociatedValues(id,"currency","idCurrency", pageable);
   }



	@RequestMapping(value = "/", method = RequestMethod.POST)
	@ApiOperation(value = "Creates a new Currency instance.")
	public Currency createCurrency(@RequestBody Currency instance) {
		LOGGER.debug("Create Currency with information: {}" , instance);
		instance = currencyService.create(instance);
		LOGGER.debug("Created Currency with information: {}" , instance);
	    return instance;
	}

	/**
	 * This setter method should only be used by unit tests
	 * 
	 * @param service
	 */
	protected void setCurrencyService(CurrencyService service) {
		this.currencyService = service;
	}
}

