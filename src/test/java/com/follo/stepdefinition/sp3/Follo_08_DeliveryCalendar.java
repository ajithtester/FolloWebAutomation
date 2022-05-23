package com.follo.stepdefinition.sp3;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.follo.baseclass.Baseclass;
import com.follo.module.method.F_07_Equipment;
import com.follo.module.method.F_08_DeliveryCalendar;
import com.follo.module.method.F_09_Void;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Follo_08_DeliveryCalendar extends Baseclass {

	@Given("User clicks delivery calendar button")
	public void user_clicks_delivery_calendar_button() throws Throwable {

		try {


			Click("DFOW", DFOWLocators);

			ClickPageUp();

			if(IsElementDisplayed("DeliveryCalendar", DeliveryCalendarLocators)){
				Print("Delivery calendar button is displayed");
				Click("DeliveryCalendar", DeliveryCalendarLocators);
				Print("Delivery calendar button is clicked");
				ExtentCucumberAdapter.addTestStepLog("Delivery calendar button is clicked");

			}
		} 
		catch (Exception e) {
			PrintError("Delivery calendar button is not clicked");
			PrintError(e.getMessage());
			ExtentCucumberAdapter.addTestStepLog("Delivery calendar button is not clicked");
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());
		}

	}

	@Given("User adds new delivery")
	public void user_adds_new_delivery() throws Throwable {

		try {

			F_08_DeliveryCalendar.Adddelivery();
		} 
		catch (Exception e) {

			PrintError(e.getMessage());
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());
		}
	}

	@Given("User search and view the delivery request")
	public void user_search_and_view_the_delivery_request() throws Throwable {

		try {

			F_08_DeliveryCalendar.SearchDelivery();


		} 
		catch (Exception e) {

			PrintError(e.getMessage());
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());
		}
	}


	@Given("User edit a delivery request")
	public void user_edit_a_delivery_request() throws Throwable {


		try {

			F_08_DeliveryCalendar.EditDelivery();

		} 
		catch (Exception e) {

			PrintError(e.getMessage());
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());
		}
	}


	@Given("User filter the delivery request based on company name")
	public void user_filter_the_delivery_request_based_on_company_name() throws Throwable {

		try {

			F_08_DeliveryCalendar.FilterDelivery();

		} 
		catch (Exception e) {

			PrintError(e.getMessage());
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());
		}
	}

	@Given("User view the request info")
	public void user_view_the_request_info() throws Throwable {

		try {

			//F_08_DeliveryCalendar.ViewDeliveryInfo();
		} 
		catch (Exception e) {

			PrintError(e.getMessage());
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());
		}
	}

	@And("User add a comment")
	public void user_add_a_comment() throws Throwable {

		try {

			F_08_DeliveryCalendar.AddComment();
		} 
		catch (Exception e) {

			PrintError(e.getMessage());
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());
		}

	}

	@And("User view history")
	public void user_view_history() throws Throwable {

		try {

			//F_08_DeliveryCalendar.ViewHistory();
		} 
		catch (Exception e) {

			PrintError(e.getMessage());
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());
		}

	}

	@Then("User delivers the request")
	public void user_delivers_the_request() throws Throwable {


		try {

			//F_08_DeliveryCalendar.Deliver();
		} 
		catch (Exception e) {

			PrintError(e.getMessage());
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());
		}

	}

	@Given("User approve or reject the request")
	public void user_approve_or_reject_the_request() throws Throwable {

		try {

			F_08_DeliveryCalendar.ApproveOrReject();
		} 
		catch (Exception e) {

			PrintError(e.getMessage());
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());
		}
	}


	@Given("User push a delivery request to void")
	public void user_push_a_delivery_request_to_void() throws Throwable {

		try {

			F_08_DeliveryCalendar.PushToVoid();

		} 
		catch (Exception e) {

			PrintError(e.getMessage());
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());
		}

	}
}
