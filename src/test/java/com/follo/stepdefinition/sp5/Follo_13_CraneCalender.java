package com.follo.stepdefinition.sp5;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.follo.baseclass.Baseclass;
import com.follo.module.method.F_12_CalendarSettings;
import com.follo.module.method.F_13_CraneCalender;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Follo_13_CraneCalender extends Baseclass {



	@Given("User clicks Crane calendar button from the menu")
	public void user_clicks_crane_calendar_button_from_the_menu() throws Throwable {

		try {
			ClickPageUp();
			Wait(2000);
			Click("CraneCalendar", CraneCalenderLocators);

			Print("Crane calendar button is clicked");
			ExtentCucumberAdapter.addTestStepLog("Crane calendar button is clicked");

		} 
		catch (Exception e) {

			PrintError("Crane calendar button is not clicked");
			ExtentCucumberAdapter.addTestStepLog("Crane calendar button is not clicked");

		}


	}

	@Then("Crane calendar page should display")
	public void crane_calendar_page_should_display() throws Throwable {

		try {

			Waitfortheelement("Calendar", CraneCalenderLocators);

			if(IsElementDisplayed("Calendar", CraneCalenderLocators)){

				Print("Crane calendar page is displayed");
				ExtentCucumberAdapter.addTestStepLog("Crane calendar page is displayed");

			}
		}
		catch (Exception e) {

			PrintError("Crane calendar page is not displayed");
			ExtentCucumberAdapter.addTestStepLog("Crane calendar page is not displayed");
		}


	}

	@Given("User add new crane request")
	public void user_add_new_crane_request() throws Throwable {

		try {

			F_13_CraneCalender.AddCraneCalender();			
		} 
		catch (Exception e) {

			PrintError(e.getMessage());	
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());

		}


	}



	@Given("User view Crane request information")
	public void user_view_crane_request_information() throws Throwable {

		try {

			F_13_CraneCalender.ViewCraneRequestInfo();			
		} 
		catch (Exception e) {

			PrintError(e.getMessage());	
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());

		}

	}
	
	
	@Given("User edit a Crane request from the list")
	public void user_edit_a_crane_request_from_the_list() throws Throwable {


		try {

			F_13_CraneCalender.EditCraneCalendar();			
		} 
		catch (Exception e) {

			PrintError(e.getMessage());	
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());

		}
		
	}

	@Given("User filter the Crane request from the list")
	public void user_filter_the_crane_request_from_the_list() throws Throwable {
	 
		
		try {

			F_13_CraneCalender.FilterCraneCalendar();			
		} 
		catch (Exception e) {

			PrintError(e.getMessage());	
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());

		}
	}

}
