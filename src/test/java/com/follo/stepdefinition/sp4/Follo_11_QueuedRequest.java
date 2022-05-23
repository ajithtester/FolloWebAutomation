package com.follo.stepdefinition.sp4;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.follo.baseclass.Baseclass;
import com.follo.module.method.F_11_QueuedRequest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Follo_11_QueuedRequest extends Baseclass{


	@Given("User clicks queued requests button from the menu")
	public void user_clicks_queued_requests_button_from_the_menu() throws Throwable {


		try {
			Waitfortheelement("QueuedDelivery", QueuedRequestLocators);
			if(IsElementDisplayed("QueuedDelivery", QueuedRequestLocators)) {

				Click("QueuedDelivery", QueuedRequestLocators);
				Print("Queued delivery button is clicked");
				ExtentCucumberAdapter.addTestStepLog("Queued delivery button is clicked");

			}
		} 
		catch (Exception e) {
			PrintError("Queued delivery button is not clicked");
			ExtentCucumberAdapter.addTestStepLog("Queued delivery button is not clicked");	
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());

		}


	}

	@Given("User clicks queued request import button")
	public void user_clicks_queued_request_import_button() {


	}

	@Then("Queued request list from the excel should get added")
	public void queued_request_list_from_the_excel_should_get_added() {


	}

	@Given("User edit a queued request from the list")
	public void user_edit_a_queued_request_from_the_list() throws Throwable {
		
		
		try {
		
			F_11_QueuedRequest.EditQueuedRequest();

			
		} 
		catch (Exception e) {
			
			PrintError(e.getMessage());	
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());

		}
	}
	
	@Given("User save a queued request from the list")
	public void user_save_a_queued_request_from_the_list() throws Throwable {
		
		try {
			
			F_11_QueuedRequest.SaveQueuedRequest();

			
		} 
		catch (Exception e) {
			
			PrintError(e.getMessage());	
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());

		}

	}
	
	
	@Given("User deletes a queued request from the list")
	public void user_deletes_a_queued_request_from_the_list() throws Throwable {
		
		try {
			
			F_11_QueuedRequest.DeleteRequest();

			
		} 
		catch (Exception e) {
			
			PrintError(e.getMessage());	
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());

		}
	  
	}
	
	@Given("User search and view the queued request from the list")
	public void user_search_and_view_the_queued_request_from_the_list() throws Throwable {
		
	try {
			
			F_11_QueuedRequest.SearchQueuedRequest();

			
		} 
		catch (Exception e) {
			
			PrintError(e.getMessage());	
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());

		}


	}

	@Given("User filter the queued request from the list")
	public void user_filter_the_queued_request_from_the_list() throws Throwable {
		
		
	try {
			
			F_11_QueuedRequest.FilterQueuedRequest();

			
		} 
		catch (Exception e) {
			
			PrintError(e.getMessage());	
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());

		}


	}

}
