package com.follo.stepdefinition.sp4;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.follo.baseclass.Baseclass;
import com.follo.module.method.F_10_DeliveryRequest;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Follo_10_DeliveryRequest extends Baseclass {

	@Given("User clicks All requests button from the menu")
	public void user_clicks_all_requests_button_from_the_menu() throws Throwable {

		try {

			Wait(3000);
			if(IsElementDisplayed("AllRequest", DeliveryRequestLocators)) {

				JsClick("AllRequest", DeliveryRequestLocators);
				Wait(2000);
				ClickPageDown();
				Print("All request button is clicked");
				ExtentCucumberAdapter.addTestStepLog("All request button is clicked");		

			}
		} 
		catch (Exception e) {
			PrintError("All request button is not clicked");
			ExtentCucumberAdapter.addTestStepLog("All request button is not clicked");	
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());

		}	    
	}

	@Given("User clicks Delivery requests button from the menu")
	public void user_clicks_delivery_requests_button_from_the_menu() throws Throwable {

		try {

			if(IsElementDisplayed("DeliveryRequestFromMenu", DeliveryRequestLocators)) {

				Click("DeliveryRequestFromMenu", DeliveryRequestLocators);
				Print("Delivery request button is clicked");
				ExtentCucumberAdapter.addTestStepLog("Delivery request button is clicked");			

			}
		} 
		catch (Exception e) {
			PrintError("Delivery request button is not clicked");
			ExtentCucumberAdapter.addTestStepLog("Delivery request button is not clicked");	
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());

		}
	}

	@Given("User add new delivery request")
	public void user_add_new_delivery_request() throws Throwable {


		try {

			F_10_DeliveryRequest.AddDeliverRequest();	


		} 
		catch (Exception e) {
			PrintError(e.getMessage());
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());

		}

	}

	@Given("User search and view the delivery request from the list")
	public void user_search_and_view_the_delivery_request_from_the_list() throws Throwable {


		try {

			F_10_DeliveryRequest.SearchRequest();	


		} 
		catch (Exception e) {
			PrintError(e.getMessage());
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());

		}
	}

	@Given("User edit a delivery request from the list")
	public void user_edit_a_delivery_request_from_the_list() throws Throwable {


		try {

			F_10_DeliveryRequest.EditRequest();	


		} 
		catch (Exception e) {
			PrintError(e.getMessage());
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());

		}

	}

	@Given("User filter the delivery request from the list")
	public void user_filter_the_delivery_request_from_the_list() throws Throwable {


		try {

			F_10_DeliveryRequest.FilterRequest();	


		} 
		catch (Exception e) {
			PrintError(e.getMessage());
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());

		}

	}

	@Given("User view the request information")
	public void user_view_the_request_information() throws Throwable {

		try {

			F_10_DeliveryRequest.ViewRequestInfo();	


		} 
		catch (Exception e) {
			PrintError(e.getMessage());
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());

		}


	}

	@And("User add a comment to the request")
	public void user_add_a_comment_to_the_request() throws Throwable {

		try {

			F_10_DeliveryRequest.AddComment();	


		} 
		catch (Exception e) {
			PrintError(e.getMessage());
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());

		}


	}

	@And("User view the history of the request")
	public void user_view_the_history_of_the_request() throws Throwable {

		try {

			F_10_DeliveryRequest.ViewHistoryInfo();		
		} 
		catch (Exception e) {
			PrintError(e.getMessage());
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());

		}


	}

	@Then("User deliver the request")
	public void user_deliver_the_request() throws Throwable {

		try {

			F_10_DeliveryRequest.Deliver();	


		} 
		catch (Exception e) {
			PrintError(e.getMessage());
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());

		}


	}

	@Given("User approve or reject the delivery request")
	public void user_approve_or_reject_the_delivery_request() throws Throwable {

		try {

			F_10_DeliveryRequest.ApproveOrReject();	


		} 
		catch (Exception e) {
			PrintError(e.getMessage());
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());

		}

	}

	@Given("User push a request to void")
	public void user_push_a_request_to_void() throws Throwable {

		try {

			F_10_DeliveryRequest.PushToVoid();	


		} 
		catch (Exception e) {
			PrintError(e.getMessage());
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());

		}
	}

}
