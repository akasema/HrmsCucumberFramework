package com.hrms.testbase;

import com.hrms.pages.AddEmployeePageElements;
import com.hrms.pages.DashboardPageElements;
import com.hrms.pages.LoginPageElements;
import com.hrms.pages.PersonalDetailsPageElements;

public class PageInitializer extends BaseClass{
	protected static LoginPageElements login;
	protected static AddEmployeePageElements addEmp;
	protected static DashboardPageElements dashboard;
	protected static PersonalDetailsPageElements pdetails;
public static void initializeAllPages() {
	login = new LoginPageElements();
	dashboard = new DashboardPageElements();
	addEmp = new AddEmployeePageElements();
	pdetails = new PersonalDetailsPageElements();
}

}
