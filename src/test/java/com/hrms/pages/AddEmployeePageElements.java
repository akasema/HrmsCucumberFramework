package com.hrms.pages;


import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testbase.BaseClass;

public class AddEmployeePageElements {

	@FindBy(id = "firstName")
	public WebElement firstName;

	@FindBy(id = "middleName")
	public WebElement middleName;
	
	@FindBy(id = "lastName")
	public WebElement lastName;
	
	@FindBy(id = "chkLogin")
	public WebElement createLoginDetails;
	
	@FindBy(id = "user_name")
	public WebElement username;
	
	@FindBy(id = "user_password")
	public WebElement userPassword;
	
	@FindBy(id = "re_password")
	public WebElement confirmUserPassword;
	
	@FindBy(id="personal_txtLicenNo")
	public WebElement drvrLicense;
	
	@FindBy(id="personal_txtSINNo")
	public WebElement sin;
	
	@FindBy(css="input[id='personal_txtNICNo']")
	  public WebElement ssn;
	
	
	@FindBy(id = "btnSave")
	public WebElement saveBtn;
	
	@FindBy(id = "employeeId")
	public WebElement empId;

	 @FindBy(css="input[id='btnSave']")
	  public WebElement edit_saveBtn;

	
	
	public AddEmployeePageElements() {
		PageFactory.initElements(BaseClass.driver, this);
	}
}