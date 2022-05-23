package com.follo.stepdefinition.sp3;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.follo.baseclass.Baseclass;
import com.follo.module.method.F_07_Equipment;
import com.follo.module.method.F_09_Void;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Follo_09_Void extends Baseclass {





	@Given("User clicks Void button")
	public void user_clicks_void_button() throws Throwable {

		try {
			Wait(5000);
			if(IsElementDisplayed("DeliveryCalendar", DFOWLocators)) {
				Click("DeliveryCalendar", DFOWLocators);

				ClickPageDown();

				Click("Settings", DFOWLocators);
				Print("Settings button is clicked");
			}
			ClickPageDown();
			Wait(2000);
			ClickPageDown();
	
			F_09_Void.VoidList();

			if(IsElementDisplayed("VoidList", VoidLocators)){
				Print("Void list button is displayed");
				Click("VoidList", VoidLocators);
				Print("Void list button is clicked");
				ExtentCucumberAdapter.addTestStepLog("Void list button is clicked");

			}
		} 
		catch (Exception e) {
			PrintError("Void list button is not clicked");
			PrintError(e.getMessage());
			ExtentCucumberAdapter.addTestStepLog("Void list button is not clicked");
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());
		}


	}

	@Given("User search and view the void request")
	public void user_search_and_view_the_void_request() throws Throwable {

		try {

			F_09_Void.SearchVoid();
		} 
		catch (Exception e) {

			PrintError(e.getMessage());
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());
		}

	}

	@Given("User filter void request")
	public void user_filter_void_request() throws Throwable {

		try {

			F_09_Void.FilterVoid();
		} 
		catch (Exception e) {

			PrintError(e.getMessage());
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());
		}

	}
	
	@Given("User restore Void request")
	public void user_restore_void_request() throws Throwable {
	
		try {

			F_09_Void.RestoreDelivery();
		} 
		catch (Exception e) {

			PrintError(e.getMessage());
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());
		}
		
	}
	
	
}
