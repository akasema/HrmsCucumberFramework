package com.hrms.steps;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.hrms.pages.AddEmployeePageElements;
import com.hrms.pages.DashboardPageElements;
import com.hrms.pages.LoginPageElements;
import com.hrms.pages.PersonalDetailsPageElements;
import com.hrms.util.CommonMethods;
import com.hrms.util.ConfigsReader;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class AddEmployeeSteps extends CommonMethods {
	
	String empId;

	@Given("I am logged into HRMS")
	public void i_am_logged_into_HRMS() {
		login = new LoginPageElements();
		dashboard = new DashboardPageElements();
		addEmp = new AddEmployeePageElements();
		pdetails = new PersonalDetailsPageElements();
		
		login.login(ConfigsReader.getProperty("username"), ConfigsReader.getProperty("password"));
	}

	@Given("I navigated to Add Employee Page")
	public void i_navigated_to_Add_Employee_Page() {
		dashboard.navigateToAddEmployee();
	}

	@When("I add {string}, {string} and {string}")
	public void i_add_and_(String fName, String mName, String lName) {
		sendText(addEmp.firstName, fName);
		sendText(addEmp.middleName, mName);
		sendText(addEmp.lastName, lName);
		empId = addEmp.empId.getText();
	}

	@When("I click Save")
	public void i_click_Save() {
		click(addEmp.saveBtn);
	}

	@Then("I see Employee has been succesfully added")
	public void i_see_Employee_has_been_succesfully_added() {
		
		Assert.assertEquals("Employee is NOT being added", pdetails.empId.getText(), empId);
	}

	@Then("I see Employee with {string}, {string} and {string} is displayed")
	public void i_see_Employee_with_and_is_displayed(String fName, String mName, String lName) {
		 System.out.println(fName+" "+mName+" "+lName);
	}
	
	@When("I enter employee details")
	public void i_enter_employee_details(DataTable empDetails) {
		
		List<Map<String, String>> empDetailList=empDetails.asMaps();
		
		for(Map<String, String> map:empDetailList) {
			sendText(addEmp.firstName, map.get("FirstName"));
			sendText(addEmp.middleName, map.get("MiddleName"));
			sendText(addEmp.lastName, map.get("LastName"));
		}
	}
	
	@When("I click on Edit")
	public void clickOnEdit_SaveButton() {
		click(pdetails.edit_saveBtn);
	}
	
	@Then("I am able to modify Employee Details")
	public void modifyEmployeeDetails(DataTable modifyEmpDetail) {
		List<Map<String, String>> modifyList=modifyEmpDetail.asMaps();
		for (Map<String,String> map:modifyList) {
			//click(pdetails.edit_saveBtn);
		sendText(addEmp.drvrLicense, map.get("DriverLisence"));
		sendText(addEmp.sin, map.get("SIN"));
		sendText(addEmp.ssn, map.get("SSN"));
	//	clickRadio(addEmp.gender, map.get("Gender"));
		
		
		//click.saveBtn;
		click(pdetails.edit_saveBtn);
		
		
		}
	}
}
