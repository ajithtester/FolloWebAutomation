package com.follo.stepdefinition.sp2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.follo.baseclass.Baseclass;
import com.follo.excel.read.ReadFrom;
import com.follo.module.method.F_03_DFOW;
import com.follo.module.method.F_04_Companies;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Follo_04_Companies extends Baseclass {


	@Given("User clicks Company button")
	public void user_clicks_company_button() throws Throwable {

		try {

			if(IsElementDisplayed("Companies", CompaniesLocators)) {

				Click("Companies", CompaniesLocators);


				Print("Companies button is clicked");
				ExtentCucumberAdapter.addTestStepLog("Companies button is clicked");			

			}
		} 

		catch (Exception e) {
			PrintError("Companies button is not clicked");
			ExtentCucumberAdapter.addTestStepLog("Companies button is not clicked");	
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());

		}
	}

	@Given("User add new  new companies")
	public void user_add_new_new_companies() throws Throwable {



		try {

			F_04_Companies.AddDCompany();
		} 

		catch (Exception e) {

			PrintError(e.getMessage());
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());

		}

	}

	@Given("User search and view the company")
	public void user_search_and_view_the_company() throws Throwable {

		try {

			F_04_Companies.SearchCompany();
		} 

		catch (Exception e) {
			PrintError(e.getMessage());
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());

		}

	}


	@Given("User search and filter the company")
	public void user_search_and_filter_the_company() throws Throwable {


		try {

			F_04_Companies.FilterCompany();
		} 

		catch (Exception e) {
			PrintError(e.getMessage());
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());

		}

	}


	@Given("User edits a Company from the list")
	public void user_edits_a_company_from_the_list() throws Throwable {


		try {

			F_04_Companies.EditCompany();
		} 

		catch (Exception e) {
			PrintError(e.getMessage());
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());

		}
	}

	@Given("User deletes a Company from the list")
	public void user_deletes_a_company_from_the_list() throws Throwable {

		try {

			F_04_Companies.DeleteCompany();

		} 

		catch (Exception e) {
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());
			PrintError(e.getMessage());
		}

	}

	@Given("User selects all Companies")
	public void user_selects_all_companies() throws Throwable {

		try {
			Wait(2000);
			if(IsElementDisplayed("SelectAll", CompaniesLocators)){
				Click("SelectAll", CompaniesLocators);


				Print("All companies are selected");
				ExtentCucumberAdapter.addTestStepLog("All companies are selected");
			}
		} catch (Exception e) {
			PrintError("All companies are not selected");
			ExtentCucumberAdapter.addTestStepLog("All companies are not selected");
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());
			PrintError(e.getMessage());

		}

	}

	@And("User clicks remove button and click yes in company delete popup")
	public void user_clicks_remove_button_and_click_yes_in_company_delete_popup() throws Throwable {

		try {
			if(IsElementDisplayed("RemoveButton", CompaniesLocators)){
				Click("RemoveButton", CompaniesLocators);
				Wait(2000);
				Click("YesDelete", CompaniesLocators);


				Print("Remove button is clicked");
				ExtentCucumberAdapter.addTestStepLog("Remove button is clicked");
			}
		} catch (Exception e) {
			PrintError("Remove button is not clicked");
			ExtentCucumberAdapter.addTestStepLog("Remove button is not clicked");
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());


		}

	}


	@Then("All the Companies except parent company is deleted")
	public void all_the_companies_except_parent_company_is_deleted() throws Throwable {



		try {
			int size =	SizeOfTheList("CompanyList", CompaniesLocators);

			if(size<=1) {
				Print("All companies are deleted except parent company");
				ExtentCucumberAdapter.addTestStepLog("All companies are deleted except parent company");
			}
			else {
				System.err.println(size);
			}

		} 

		catch (Exception e) {

			PrintError("All companies are not deleted");
			ExtentCucumberAdapter.addTestStepLog("All companies are not deleted");
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());

		}

	}

	@Given("User clicks import multiple button")
	public void user_clicks_import_multiple_button() throws Throwable {
		
		
		try {
			if(IsElementDisplayed("ImportMultiple", CompaniesLocators)) {
				Click("ImportMultiple", CompaniesLocators);
				ExtentCucumberAdapter.addTestStepLog("Import button is clicked");
				Print("Import button is clicked");
			}
		} catch (Exception e) {
			PrintError("Import button is not clicked");
			ExtentCucumberAdapter.addTestStepLog("Import button is not clicked");
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());

		}
	    
	}
	
	@Given("User clicks browse files to upload company list")
	public void user_clicks_browse_files_to_upload_company_list() throws Throwable {
		
		try {
			F_04_Companies.BrowseFiles();
			
			if(IsElementDisplayed("BrowseFiles", DFOWLocators)) {
				Wait(2000);
				WebElement file_input = driver.findElement(By.xpath("//label[normalize-space()='Click here to browse']"));
				Wait(4000);
				file_input.click();
				file_input.sendKeys(ReadFrom.UploadCompanyFile);
				Print(ReadFrom.UploadCompanyFile);
//				
//				//Click("BrowseFiles", DFOWLocators);
//				
//				ExtentCucumberAdapter.addTestStepLog("Browse files button is clicked");
//				Print("Browse files button is clicked");
			}
		} catch (Exception e) {
			PrintError("Browse files button is not clicked");
			ExtentCucumberAdapter.addTestStepLog("Browse files button is not clicked");
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());
			PrintError(e.getMessage());
		}
	    
	}

	@Given("User selects file to upload to upload company list")
	public void user_selects_file_to_upload_to_upload_company_list() throws Throwable {
		
		try {

			//F_04_Companies.CompanyBulkUpload();
			//Runtime.getRuntime().exec("C:\\Users\\ajithkumar.j\\Desktop\\FileUpload.exe");



		} catch (Exception e) {
			PrintError("DFOW list excel file is not selected from the system");
			ExtentCucumberAdapter.addTestStepLog("DFOW list excel file is not selected from the system");
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());
			PrintError(e.getMessage());

		}
	    
	}

	@Given("User clicks the done button to upload company list")
	public void user_clicks_the_done_button_to_upload_company_list() throws Throwable {
		
		try {
			Wait(2000);
			if(IsElementDisplayed("DoneButton", DFOWLocators)){
				Click("DoneButton", DFOWLocators);
				ExtentCucumberAdapter.addTestStepLog("Done button is clicked");

				Print("Done button is clicked");
				ClickPageDown();
			}
		} catch (Exception e) {
			PrintError("Done button is not clicked");
			ExtentCucumberAdapter.addTestStepLog("Done button is not clicked");
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());

		}
	    
	}

	@Then("Companies list from the excel should get added")
	public void companies_list_from_the_excel_should_get_added() throws Throwable {
		
		try {

			F_04_Companies.BulkSuccessfullMessage();

			if(IsElementDisplayed("FileUploaded", CompaniesLocators)){
				Print("Companies list added");
				ExtentCucumberAdapter.addTestStepLog("Companies list added");

			}
		} 
		catch (Exception e) {
			PrintError("Companies list not added");
			PrintError(e.getMessage());
			ExtentCucumberAdapter.addTestStepLog("Companies list not added");
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());
		}
	}
	    
	

}
