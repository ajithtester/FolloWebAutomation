package com.follo.stepdefinition.sp4;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.follo.baseclass.Baseclass;
import com.follo.module.method.F_11_QueuedRequest;
import com.follo.module.method.F_12_CalendarSettings;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class Follo_12_CalendarSettings extends Baseclass {
	
	
	@Given("User clicks settings button from the menu")
	public void user_clicks_settings_button_from_the_menu() throws Throwable {
		

		try {
		
			Click("Settings", CalendarSettingsLocators);
			Wait(2000);
			ClickPageDown();
			if(IsElementDisplayed("CalendarSettings", CalendarSettingsLocators)){
				Print("Calendar settings button is displayed");
				ExtentCucumberAdapter.addTestStepLog("Calendar settings button is displayed");

			}
		
		} 
		catch (Exception e) {
			
			PrintError("Calendar settings button is not displayed");
			ExtentCucumberAdapter.addTestStepLog("Calendar settings button is not displayed");

		}
	   
	    
	}

	@And("User clicks Calendar settings button from the menu")
	public void user_clicks_calendar_settings_button_from_the_menu() throws Throwable {
		
		try {
			
			Click("CalendarSettings", CalendarSettingsLocators);
			Waitfortheelement("Calendar", CalendarSettingsLocators);
			if(IsElementDisplayed("Calendar", CalendarSettingsLocators)){
				
				Print("Calendar settings button is clicked");
				ExtentCucumberAdapter.addTestStepLog("Calendar settings button is clicked");

			}
		
		} 
		catch (Exception e) {
			
			PrintError("Calendar settings button is not clicked");
			ExtentCucumberAdapter.addTestStepLog("Calendar settings button is not clicked");

		}
	   
	    
	}

	@Given("User add new event in Calendar settings")
	public void user_add_new_event_in_calendar_settings() throws Throwable {
	   
		
		try {
			
			F_12_CalendarSettings.AddEvent();			
		} 
		catch (Exception e) {
			
			PrintError(e.getMessage());	
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());

		}
	}
	
	@Given("User search and view the event from the calendar settings")
	public void user_search_and_view_the_event_from_the_calendar_settings() throws Throwable {

		
		try {
			
			F_12_CalendarSettings.SearchEvent();

			
		} 
		catch (Exception e) {
			
			PrintError(e.getMessage());	
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());

		}
	}
	
	@Given("User edit a event request from the calendar settings")
	public void user_edit_a_event_request_from_the_calendar_settings() throws Throwable {
		
	try {
			
			F_12_CalendarSettings.EditEvent();

			
		} 
		catch (Exception e) {
			
			PrintError(e.getMessage());	
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());

		}
	}
}
