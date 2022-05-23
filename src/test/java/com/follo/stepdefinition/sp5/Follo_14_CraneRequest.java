package com.follo.stepdefinition.sp5;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.follo.baseclass.Baseclass;
import com.follo.module.method.F_10_DeliveryRequest;
import com.follo.module.method.F_14_CraneRequest;

import io.cucumber.java.en.Given;

public class Follo_14_CraneRequest extends Baseclass{


	@Given("User clicks Crane requests button from the menu")
	public void user_clicks_crane_requests_button_from_the_menu() throws Throwable {

		try {
			Wait(2000);
			Waitfortheelement("CraneRequest", CraneRequestLocators);
			if(IsElementDisplayed("CraneRequest", CraneRequestLocators)) {
				Print("Crane request button is displayed");
				Click("CraneRequest", CraneRequestLocators);
				Print("Crane request button is clicked");
				ExtentCucumberAdapter.addTestStepLog("Crane request button is clicked");			

			}
		} 
		catch (Exception e) {
			PrintError("Crane request button is not clicked");
			ExtentCucumberAdapter.addTestStepLog("Crane request button is not clicked");	
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());
			PrintError(e.getMessage());
		}

	}

	@Given("User add new Crane request")
	public void user_add_new_crane_request() throws Throwable {


		try {

			F_14_CraneRequest.AddCraneRequest();	


		} 
		catch (Exception e) {
			PrintError(e.getMessage());
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());

		}

	}
	
	@Given("User view the Crane request information")
	public void user_view_the_crane_request_information() throws Throwable {
		
		
		try {

			F_14_CraneRequest.ViewCraneRequestInfo();	


		} 
		catch (Exception e) {
			PrintError(e.getMessage());
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());

		}
	}
	
	
	@Given("User edit a crane request from the list")
	public void user_edit_a_crane_request_from_the_list() throws Throwable {
	   
		try {

			F_14_CraneRequest.EditCraneRequest();	


		} 
		catch (Exception e) {
			PrintError(e.getMessage());
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());

		}
		
	}
	
	@Given("User filter crane request from the list")
	public void user_filter_crane_request_from_the_list() throws Throwable {
	 
		try {

			F_14_CraneRequest.FilterCraneRequest();	


		} 
		catch (Exception e) {
			PrintError(e.getMessage());
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());

		}
		
	}

	@Given("User search and view the crane request from the list")
	public void user_search_and_view_the_crane_request_from_the_list() throws Throwable {
	   
		try {

			F_14_CraneRequest.SearchCraneRequest();	


		} 
		catch (Exception e) {
			PrintError(e.getMessage());
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());

		}
	}
	
	@Given("User push a crane request to void")
	public void user_push_a_crane_request_to_void() throws Throwable {

		try {

			F_14_CraneRequest.CranePushToVoid();	


		} 
		catch (Exception e) {
			PrintError(e.getMessage());
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());

		}
	}
	
	@Given("User complete the request")
	public void user_complete_the_request() throws Throwable {

		try {

			F_14_CraneRequest.CompleteRequest();	


		} 
		catch (Exception e) {
			PrintError(e.getMessage());
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());

		}
	}
	
	@Given("User approve or reject the crane request")
	public void user_approve_or_reject_the_crane_request() throws Throwable {
	   
		try {

			F_14_CraneRequest.CraneApproveReject();	


		} 
		catch (Exception e) {
			PrintError(e.getMessage());
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());

		}
	}
	
	@Given("User add a comment to a crane request")
	public void user_add_a_comment_to_a_crane_request() throws Throwable {


		try {

			F_14_CraneRequest.CraneApproveReject();	


		} 
		catch (Exception e) {
			PrintError(e.getMessage());
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());

		}
	}
}
