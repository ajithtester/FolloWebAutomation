package com.follo.module.method;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.follo.baseclass.Baseclass;
import com.follo.excel.read.ReadFrom;


public class F_10_DeliveryRequest extends Baseclass {


	public static void AddDeliverRequest() throws Throwable {
		PrintError("Add deliver request Started");
		ReadFrom.DynamicExcel(ReadFrom.AllDeliverRequest);

		try {
			for(int AllDeliverRequest =1; AllDeliverRequest<=ReadFrom.rowcount; AllDeliverRequest++)		{	

				Wait(4000);
				PrintError("Add delivery started");
				Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
						.withTimeout(Duration.ofSeconds(120))
						.pollingEvery(Duration.ofSeconds(5))
						.ignoring(ElementClickInterceptedException.class);


				fluentWait.until(new Function<WebDriver, WebElement>() {
					public WebElement apply(WebDriver driver) {
						return driver.findElement(By.xpath("(//button[@type='button'])[1]"));
					}
				});

				if(IsElementDisplayed("CreateNew", DeliveryRequestLocators)){
					JsClick("CreateNew", DeliveryRequestLocators);
					Print("Create new button is clicked");
					ExtentCucumberAdapter.addTestStepLog("Create new button is clicked");

				}
				else
				{
					PrintError("Create new button is not clicked");
					ExtentCucumberAdapter.addTestStepLog("Create new button is not clicked");
				}


				Wait<WebDriver> fluentWait1 = new FluentWait<WebDriver>(driver)
						.withTimeout(Duration.ofSeconds(120))
						.pollingEvery(Duration.ofSeconds(5))
						.ignoring(NoSuchElementException.class);


				fluentWait1.until(new Function<WebDriver, WebElement>() {
					public WebElement apply(WebDriver driver) {
						return driver.findElement(By.xpath("//textarea[@placeholder='Enter Description']"));
					}
				});

				if(IsElementDisplayed("Description", DeliveryRequestLocators)) {
					Print("Delivery popup is opened");
					ExtentCucumberAdapter.addTestStepLog("Delivery popup is opened");
				}

				TypeDataInTheField("Description", DeliveryRequestLocators, ReadFrom.Excel(AllDeliverRequest, 0, ReadFrom.AllDeliverRequest));
				Print("Description is entered as : " + ReadFrom.Excel(AllDeliverRequest, 0, ReadFrom.AllDeliverRequest));
				ExtentCucumberAdapter.addTestStepLog("Description is entered as : " + ReadFrom.Excel(AllDeliverRequest, 0, ReadFrom.AllDeliverRequest));

				SelectFromVisibleText("GateDropdown", DeliveryRequestLocators, ReadFrom.Excel(AllDeliverRequest, 1, ReadFrom.AllDeliverRequest));
				Print("Gate dropdown is selected as : " + ReadFrom.Excel(AllDeliverRequest, 1, ReadFrom.AllDeliverRequest));
				ExtentCucumberAdapter.addTestStepLog("Gate dropdown is selected as : " + ReadFrom.Excel(AllDeliverRequest, 1, ReadFrom.AllDeliverRequest));



				SelectFromVisibleText("EquipmentDropdown", DeliveryRequestLocators, ReadFrom.Excel(AllDeliverRequest, 2, ReadFrom.AllDeliverRequest));
				Print("Equipment dropdown is selected as : " + ReadFrom.Excel(AllDeliverRequest, 2, ReadFrom.AllDeliverRequest));
				ExtentCucumberAdapter.addTestStepLog("Equipment dropdown is selected as : " + ReadFrom.Excel(AllDeliverRequest, 2, ReadFrom.AllDeliverRequest));

				Wait(2000);
				try {
					if(IsElementDisplayed("PickingFrom", DeliveryRequestLocators)) {

						TypeDataInTheField("PickingFrom", DeliveryRequestLocators, ReadFrom.Excel(AllDeliverRequest, 14, ReadFrom.AllDeliverRequest));
						Print("Picking from is entered as : " + ReadFrom.Excel(AllDeliverRequest, 14, ReadFrom.AllDeliverRequest));
						ExtentCucumberAdapter.addTestStepLog("Picking from is entered as : " + ReadFrom.Excel(AllDeliverRequest, 14, ReadFrom.AllDeliverRequest));

						Wait(2000);
						TypeDataInTheField("PickingTo", DeliveryRequestLocators, ReadFrom.Excel(AllDeliverRequest, 15, ReadFrom.AllDeliverRequest));
						Print("Picking to is entered as : " + ReadFrom.Excel(AllDeliverRequest, 15, ReadFrom.AllDeliverRequest));
						ExtentCucumberAdapter.addTestStepLog("Picking to is entered as : " + ReadFrom.Excel(AllDeliverRequest, 15, ReadFrom.AllDeliverRequest));

					}

				} catch (Exception e) {
					{
						Print("Delivery request equipment is selected");
						ExtentCucumberAdapter.addTestStepLog("Delivery request equipment is selected");

					}
				}

				Wait(2000);
				MoveToElement("AdditionalText", DeliveryRequestLocators);
				TypeDataInTheField("AdditionalText", DeliveryRequestLocators, ReadFrom.Excel(AllDeliverRequest, 3, ReadFrom.AllDeliverRequest));
				Print("Additional text is entered as : " + ReadFrom.Excel(AllDeliverRequest, 3, ReadFrom.AllDeliverRequest));
				ExtentCucumberAdapter.addTestStepLog("Additional text is entered as : " + ReadFrom.Excel(AllDeliverRequest, 3, ReadFrom.AllDeliverRequest));

				TypeDataInTheField("VehicleDetails", DeliveryRequestLocators, ReadFrom.Excel(AllDeliverRequest, 4, ReadFrom.AllDeliverRequest));
				Print("Vehicle details is entered as : " + ReadFrom.Excel(AllDeliverRequest, 4, ReadFrom.AllDeliverRequest));
				ExtentCucumberAdapter.addTestStepLog("Vehicle details is entered as : " + ReadFrom.Excel(AllDeliverRequest, 4, ReadFrom.AllDeliverRequest));


			//	Click("DeliveryDate", DeliveryRequestLocators);

				Wait(4000);
			//	CalendarMethod(AllDeliverRequest);

				Clear("DeliveryDate", DeliveryRequestLocators);
				TypeDataInTheField("DeliveryDate", DeliveryRequestLocators, ReadFrom.Excel(AllDeliverRequest, 5, ReadFrom.AllDeliverRequest));
				Print("Start date is entered as : " + ReadFrom.Excel(AllDeliverRequest, 5, ReadFrom.AllDeliverRequest));
				ExtentCucumberAdapter.addTestStepLog("Start date is entered as : " + ReadFrom.Excel(AllDeliverRequest, 5, ReadFrom.AllDeliverRequest));


				///////////////////////

				Click("Dfow", DeliveryRequestLocators);
				ExtentCucumberAdapter.addTestStepLog("Dfow dropdown is clicked");

				String DfowInExcel = ReadFrom.Excel(AllDeliverRequest, 6,ReadFrom.AllDeliverRequest);
				Print(DfowInExcel);

				int rowcountofthelist = 	SizeOfTheList("DfowList", DeliveryRequestLocators);
				Print("No of elements : " + rowcountofthelist);

				for(int DropdownValues =1; DropdownValues<=rowcountofthelist; DropdownValues++)		{	
					WebElement Dfow = 	FindElement("DfowInDropdown", DeliveryRequestLocators, DropdownValues);
					String DfowInDropdown = 	GetTextFromTheElement(Dfow);
					Print(DfowInDropdown);


					if(IsEqual(DfowInDropdown, DfowInExcel)){
						Click(Dfow);

						ExtentCucumberAdapter.addTestStepLog("Dfow is selected as : " + DfowInDropdown );
						Print("Dfow is selected as : " + DfowInDropdown );
						break;
					}
					else {
						

					}
				}	

				/////////////////////////////////////

				Click("Company", DeliveryRequestLocators);
				ExtentCucumberAdapter.addTestStepLog("Company dropdown is clicked");

				String CompanyInExcel = ReadFrom.Excel(AllDeliverRequest, 7,ReadFrom.AllDeliverRequest);
				Print(CompanyInExcel);

				int countofthelist = 	SizeOfTheList("CompanyList", DeliveryRequestLocators);
				Print("No of elements : " + countofthelist);

				for(int DropdownValues =1; DropdownValues<=countofthelist; DropdownValues++)		{	
					WebElement Company = 	FindElement("CompanyInDropdown", DeliveryRequestLocators, DropdownValues);
					String CompanyInDropdown = 	GetTextFromTheElement(Company);
					Print(CompanyInDropdown);


					if(IsEqual(CompanyInDropdown, CompanyInExcel)){
						Click(Company);

						ExtentCucumberAdapter.addTestStepLog("Dfow is selected as : " + CompanyInDropdown );
						Print("Dfow is selected as : " + CompanyInDropdown );
						break;
					}
					else {
						PrintError("Not matched");

					}
				}	

				Wait(2000);
				Clear("FromHrs", DeliveryRequestLocators);
				TypeDataInTheField("FromHrs", DeliveryRequestLocators, ReadFrom.Excel(AllDeliverRequest, 8, ReadFrom.AllDeliverRequest));
				Print("From hrs is entered as : " + ReadFrom.Excel(AllDeliverRequest, 8, ReadFrom.AllDeliverRequest));
				ExtentCucumberAdapter.addTestStepLog("From hrs is entered as : " + ReadFrom.Excel(AllDeliverRequest, 8, ReadFrom.AllDeliverRequest));

				Wait(2000);
				Clear("FromMin", DeliveryRequestLocators);
				TypeDataInTheField("FromMin", DeliveryRequestLocators, ReadFrom.Excel(AllDeliverRequest, 9, ReadFrom.AllDeliverRequest));
				Print("From min is entered as : " + ReadFrom.Excel(AllDeliverRequest, 9, ReadFrom.AllDeliverRequest));
				ExtentCucumberAdapter.addTestStepLog("From min is entered as : " + ReadFrom.Excel(AllDeliverRequest, 9, ReadFrom.AllDeliverRequest));

				Wait(2000);
				String ExcelMeridian = ReadFrom.Excel(AllDeliverRequest, 10, ReadFrom.AllDeliverRequest);
			
				String Meridian = GetText("FromMeridian", DeliveryRequestLocators);
			
				if(IsEqual(Meridian, ExcelMeridian)) {


				}
				else {
					Click("FromMeridian", DeliveryRequestLocators);
					Print("selected");
				}

				Wait(2000);
				Clear("ToHrs", DeliveryRequestLocators);
				TypeDataInTheField("ToHrs", DeliveryRequestLocators, ReadFrom.Excel(AllDeliverRequest, 11, ReadFrom.AllDeliverRequest));
				Print("To hrs is entered as : " + ReadFrom.Excel(AllDeliverRequest, 11, ReadFrom.AllDeliverRequest));
				ExtentCucumberAdapter.addTestStepLog("To hrs is entered as : " + ReadFrom.Excel(AllDeliverRequest, 11, ReadFrom.AllDeliverRequest));

				Wait(2000);
				Clear("ToMin", DeliveryRequestLocators);
				TypeDataInTheField("ToMin", DeliveryRequestLocators, ReadFrom.Excel(AllDeliverRequest, 12, ReadFrom.AllDeliverRequest));
				Print("To min is entered as : " + ReadFrom.Excel(AllDeliverRequest, 12, ReadFrom.AllDeliverRequest));
				ExtentCucumberAdapter.addTestStepLog("To min is entered as : " + ReadFrom.Excel(AllDeliverRequest, 12, ReadFrom.AllDeliverRequest));

				Wait(2000);
				String ExcelMeridian1 = ReadFrom.Excel(AllDeliverRequest, 13, ReadFrom.AllDeliverRequest);
				String Meridian1 = GetText("ToMeridian", DeliveryRequestLocators);
				if(IsEqual(Meridian1, ExcelMeridian1)) {


				}
				else {
					Click("ToMeridian", DeliveryRequestLocators);
					
				}

				MoveToElement("SubmitButton", DeliveryRequestLocators);

				Click("SubmitButton", DeliveryRequestLocators);

				Wait<WebDriver> fluentWait11 = new FluentWait<WebDriver>(driver)
						.withTimeout(Duration.ofSeconds(120))
						.pollingEvery(Duration.ofSeconds(5))
						.ignoring(NoSuchElementException.class);


				fluentWait11.until(new Function<WebDriver, WebElement>() {
					public WebElement apply(WebDriver driver) {
						return driver.findElement(By.xpath("//div[@aria-label='Delivery Request Created Successfully.']"));
					}
				});

				if(IsElementDisplayed("DeliveryAdded", DeliveryRequestLocators)) {
					Click("DeliveryAdded", DeliveryRequestLocators);
					Print("Delivery request added");
				}
				else {
					PrintError("Delivery request failed");
				}
				Wait(3000);
			}
		}
		catch (Exception e) {
			PrintError(e.getMessage());
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());
		}
	}

	public static void CalendarMethod(int AllDeliverRequest ) throws Throwable {

		Click("Currentyear", DeliveryRequestLocators);
		Wait(3000);

		String Year = "False";
		while(Year=="False") {
			if(driver.findElements(By.xpath("//span[normalize-space()='"+ ReadFrom.Excel(AllDeliverRequest, 5, ReadFrom.AllDeliverRequest) +"']")).size()>0){
				driver.findElement(By.xpath("//span[normalize-space()='"+ ReadFrom.Excel(AllDeliverRequest, 5, ReadFrom.AllDeliverRequest) +"']")).click();

				ExtentCucumberAdapter.addTestStepLog("Year is selected as : " + ReadFrom.Excel(AllDeliverRequest, 5, ReadFrom.AllDeliverRequest));
				Print("Year is selected as : " + ReadFrom.Excel(AllDeliverRequest, 5, ReadFrom.AllDeliverRequest));

				Year = "True";
			}
			else {

				Click("Nextyear", DeliveryRequestLocators);
			}
		}

		String Month = "False";
		while(Month=="False") {
			Wait(3000);

			if(driver.findElements(By.xpath("//span[normalize-space()='"+ ReadFrom.Excel(AllDeliverRequest, 6, ReadFrom.AllDeliverRequest) +"']")).size()>0){
				driver.findElement(By.xpath("//span[normalize-space()='"+ ReadFrom.Excel(AllDeliverRequest, 6, ReadFrom.AllDeliverRequest) +"']")).click();

				Print("Month is selected as : " + ReadFrom.Excel(AllDeliverRequest, 6, ReadFrom.AllDeliverRequest));
				ExtentCucumberAdapter.addTestStepLog("Month is selected as : " + ReadFrom.Excel(AllDeliverRequest, 6, ReadFrom.AllDeliverRequest));
				Month = "True";
			}
			else {
				PrintError("Month is not available");
			}
		}

		String Date = "False";
		while(Date=="False") {
			Wait(5000);
			if(driver.findElements(By.xpath("//span[normalize-space()='"+ ReadFrom.Excel(AllDeliverRequest, 7, ReadFrom.AllDeliverRequest) +"']")).size()>0){
				driver.findElement(By.xpath("//span[normalize-space()='"+ ReadFrom.Excel(AllDeliverRequest, 7, ReadFrom.AllDeliverRequest) +"']")).click();

				Print("Date is selected as : " + ReadFrom.Excel(AllDeliverRequest, 7, ReadFrom.AllDeliverRequest));
				ExtentCucumberAdapter.addTestStepLog("Date is selected as : " + ReadFrom.Excel(AllDeliverRequest, 7, ReadFrom.AllDeliverRequest));
				Date = "True";

			}
			else {

				PrintError("Date is not available");
			}
		}
	}


	public static void SearchRequest() throws Throwable {

		PrintError("Search request Started");
		ReadFrom.DynamicExcel(ReadFrom.SearchRequest);

		try {

			Click("SearchIcon", DeliveryRequestLocators);

			for(int Search =1; Search<=ReadFrom.rowcount; Search++)	{


				Wait(2000);

				TypeDataInTheField("Search", DeliveryRequestLocators, ReadFrom.Excel(Search, 0, ReadFrom.SearchRequest));
				ExtentCucumberAdapter.addTestStepLog(ReadFrom.Excel(Search, 0, ReadFrom.SearchRequest) + " is entered in the search bar");
				Print(ReadFrom.Excel(Search, 0, ReadFrom.SearchRequest) + " is entered in the search bar");

				Wait(5000);


				int rowcount = 	SizeOfTheList("DeliveryRequestLists", DeliveryRequestLocators);
				Print("No of request names displayed : " + rowcount);

				for(int Searchedrequest =1; Searchedrequest<=rowcount; Searchedrequest++)	{

					WebElement Request =	FindElement("DeliveryRequestList", DeliveryRequestLocators, Searchedrequest);
					String Requestname =	GetTextFromTheElement(Request);

					Wait(2000);

					String SearchedValue = ReadFrom.Excel(Search, 0, ReadFrom.SearchRequest);



					if(IsEqual(Requestname, SearchedValue)) {

						Wait(2000);
						Print("Displayed value is : " + Requestname);
						ExtentCucumberAdapter.addTestStepLog("Displayed value is : " + Requestname);

						Wait(3000);

					}
					else {
						PrintError("Displayed value is : " + Requestname);
						ExtentCucumberAdapter.addTestStepLog("Displayed value is : " + Requestname);
					}


				}
				Wait(3000);
				Clear("Search", DeliveryRequestLocators);
				Wait(3000);
				Click("CloseSearch", DeliveryRequestLocators);
				ExtentCucumberAdapter.addTestStepLog("Clear search button is clicked");
				Print("Clear search button is clicked");


			}
		}
		catch (Exception e) {
			PrintError(e.getMessage());
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());
		}
	}



	public static void EditRequest() throws Throwable {
		PrintError("Edit delivery started");
		ReadFrom.DynamicExcel(ReadFrom.EditRequest);
		try {

			for(int EditRequest =1; EditRequest<=ReadFrom.rowcount; EditRequest++)	{


				int rowcount = 	SizeOfTheList("DeliveryRequestLists", DeliveryRequestLocators);
				Print("No of elements : " + rowcount);

				for(int DeliveryLists =1; DeliveryLists<=rowcount; DeliveryLists++)		{


					WebElement Delivery =	FindElement("DeliveryRequestList", DeliveryRequestLocators, DeliveryLists);

					String DeliveryName = 	GetTextFromTheElement(Delivery);

					String EditIt =	ReadFrom.Excel(EditRequest, 0, ReadFrom.EditRequest);


					if(IsEqual(DeliveryName, EditIt)) {

						WebElement EditButton =	FindElement("EditRequest", DeliveryRequestLocators, DeliveryLists);

						JsClick(EditButton);

						ExtentCucumberAdapter.addTestStepLog("Edit button is clicked");
						Print("Edit button is clicked");


						Wait<WebDriver> fluentWait1 = new FluentWait<WebDriver>(driver)
								.withTimeout(Duration.ofSeconds(120))
								.pollingEvery(Duration.ofSeconds(5))
								.ignoring(NoSuchElementException.class);


						fluentWait1.until(new Function<WebDriver, WebElement>() {
							public WebElement apply(WebDriver driver) {
								return driver.findElement(By.xpath("//textarea[@placeholder='Enter Description']"));
							}
						});

						if(IsElementDisplayed("Description", DeliveryRequestLocators)) {
							Print("Delivery popup is opened");
							ExtentCucumberAdapter.addTestStepLog("Delivery popup is opened");
						}

						Clear("Description", DeliveryRequestLocators);
						TypeDataInTheField("Description", DeliveryRequestLocators, ReadFrom.Excel(EditRequest, 1, ReadFrom.EditRequest));
						Print("Description is entered as : " + ReadFrom.Excel(EditRequest, 1, ReadFrom.EditRequest));
						ExtentCucumberAdapter.addTestStepLog("Description is entered as : " + ReadFrom.Excel(EditRequest, 1, ReadFrom.EditRequest));

						SelectFromVisibleText("GateDropdown", DeliveryRequestLocators, ReadFrom.Excel(EditRequest, 2, ReadFrom.EditRequest));
						Print("Gate dropdown is selected as : " + ReadFrom.Excel(EditRequest, 2, ReadFrom.EditRequest));
						ExtentCucumberAdapter.addTestStepLog("Gate dropdown is selected as : " + ReadFrom.Excel(EditRequest, 2, ReadFrom.EditRequest));



						SelectFromVisibleText("EquipmentDropdown", DeliveryRequestLocators, ReadFrom.Excel(EditRequest, 3, ReadFrom.EditRequest));
						Print("Equipment dropdown is selected as : " + ReadFrom.Excel(EditRequest, 3, ReadFrom.EditRequest));
						ExtentCucumberAdapter.addTestStepLog("Equipment dropdown is selected as : " + ReadFrom.Excel(EditRequest, 3, ReadFrom.EditRequest));

						Wait(2000);
						try {
							if(IsElementDisplayed("PickingFrom", DeliveryRequestLocators)) {
								Clear("PickingFrom", DeliveryRequestLocators);
								TypeDataInTheField("PickingFrom", DeliveryRequestLocators, ReadFrom.Excel(EditRequest, 15, ReadFrom.EditRequest));
								Print("Picking from is entered as : " + ReadFrom.Excel(EditRequest, 15, ReadFrom.EditRequest));
								ExtentCucumberAdapter.addTestStepLog("Picking from is entered as : " + ReadFrom.Excel(EditRequest, 15, ReadFrom.EditRequest));

								Wait(2000);
								Clear("PickingTo", DeliveryRequestLocators);
								TypeDataInTheField("PickingTo", DeliveryRequestLocators, ReadFrom.Excel(EditRequest, 16, ReadFrom.EditRequest));
								Print("Picking to is entered as : " + ReadFrom.Excel(EditRequest, 16, ReadFrom.EditRequest));
								ExtentCucumberAdapter.addTestStepLog("Picking to is entered as : " + ReadFrom.Excel(EditRequest, 16, ReadFrom.EditRequest));

							}

						} catch (Exception e) {
							{
								PrintError("Delivery request equipment is  selected");
								ExtentCucumberAdapter.addTestStepLog("Delivery request equipment is  selected");

							}
						}

						Wait(2000);
						MoveToElement("AdditionalText", DeliveryRequestLocators);
						Clear("AdditionalText", DeliveryRequestLocators);
						TypeDataInTheField("AdditionalText", DeliveryRequestLocators, ReadFrom.Excel(EditRequest, 4, ReadFrom.EditRequest));
						Print("Additional text is entered as : " + ReadFrom.Excel(EditRequest, 4, ReadFrom.EditRequest));
						ExtentCucumberAdapter.addTestStepLog("Additional text is entered as : " + ReadFrom.Excel(EditRequest, 4, ReadFrom.EditRequest));

						Clear("VehicleDetails", DeliveryRequestLocators);
						TypeDataInTheField("VehicleDetails", DeliveryRequestLocators, ReadFrom.Excel(EditRequest, 5, ReadFrom.EditRequest));
						Print("Vehicle details is entered as : " + ReadFrom.Excel(EditRequest, 5, ReadFrom.EditRequest));
						ExtentCucumberAdapter.addTestStepLog("Vehicle details is entered as : " + ReadFrom.Excel(EditRequest, 5, ReadFrom.EditRequest));


						//Click("DeliveryDate", DeliveryRequestLocators);

						Clear("DeliveryDate", DeliveryRequestLocators);
						TypeDataInTheField("DeliveryDate", DeliveryRequestLocators, ReadFrom.Excel(EditRequest, 6, ReadFrom.EditRequest));
						Print("Start date is entered as : " + ReadFrom.Excel(EditRequest, 6, ReadFrom.EditRequest));
						ExtentCucumberAdapter.addTestStepLog("Start date is entered as : " + ReadFrom.Excel(EditRequest, 6, ReadFrom.EditRequest));

						Wait(3000);

					
						///////////////////////

						JsClick("DfowEdit", DeliveryRequestLocators);


						ExtentCucumberAdapter.addTestStepLog("Dfow dropdown is clicked");

						Click("SelectAll", DeliveryRequestLocators);
						Wait(2000);
						Click("SelectAll", DeliveryRequestLocators);
						Wait(2000);
						Click("Dfow", DeliveryRequestLocators);

						String DfowInExcel = ReadFrom.Excel(EditRequest, 7, ReadFrom.EditRequest);


						int rowcountofthelist = 	SizeOfTheList("DfowListEdit", DeliveryRequestLocators);
						Print("No of elements : " + rowcountofthelist);

						for(int DropdownValues =1; DropdownValues<=rowcountofthelist; DropdownValues++)		{	
							WebElement Dfow = 	FindElement("DfowListEdits", DeliveryRequestLocators, DropdownValues);
							String DfowInDropdown = 	GetTextFromTheElement(Dfow);



							if(IsEqual(DfowInDropdown, DfowInExcel)){
								Click(Dfow);

								ExtentCucumberAdapter.addTestStepLog("Dfow is selected as : " + DfowInDropdown );
								Print("Dfow is selected as : " + DfowInDropdown );
								break;
							}
							else {
								PrintError("Not matched");

							}
						}	

						/////////////////////////////////////
						JsClick("CompanyEdit", DeliveryRequestLocators);
						//Click("Company", DeliveryRequestLocators);

						ExtentCucumberAdapter.addTestStepLog("Company dropdown is clicked");
						Print("Company dropdown is clicked");

						Click("UnselectAll", DeliveryRequestLocators);
						Wait(2000);
						Click("UnselectAll", DeliveryRequestLocators);
						Wait(2000);
						Click("ResCompany", DeliveryRequestLocators);

						String CompanyInExcel = ReadFrom.Excel(EditRequest, 8, ReadFrom.EditRequest);


						int countofthelist = 	SizeOfTheList("CompanyListEdit", DeliveryRequestLocators);
						Print("No of elements : " + countofthelist);

						for(int DropdownValues =1; DropdownValues<=countofthelist; DropdownValues++)		{	
							WebElement Company = 	FindElement("CompanyListEdits", DeliveryRequestLocators, DropdownValues);
							String CompanyInDropdown = 	GetTextFromTheElement(Company);

							if(IsEqual(CompanyInDropdown, CompanyInExcel)){
								Click(Company);

								ExtentCucumberAdapter.addTestStepLog("Dfow is selected as : " + CompanyInDropdown );
								Print("Dfow is selected as : " + CompanyInDropdown );
								break;
							}
							else {
								PrintError("Not matched");

							}
						}	

						Wait(2000);
						Clear("FromHrs", DeliveryRequestLocators);
						TypeDataInTheField("FromHrs", DeliveryRequestLocators, ReadFrom.Excel(EditRequest, 9, ReadFrom.EditRequest));
						Print("From hrs is entered as : " + ReadFrom.Excel(EditRequest, 9, ReadFrom.EditRequest));
						ExtentCucumberAdapter.addTestStepLog("From hrs is entered as : " + ReadFrom.Excel(EditRequest, 9, ReadFrom.EditRequest));

						Wait(2000);
						Clear("FromMin", DeliveryRequestLocators);
						TypeDataInTheField("FromMin", DeliveryRequestLocators, ReadFrom.Excel(EditRequest, 10, ReadFrom.EditRequest));
						Print("From min is entered as : " + ReadFrom.Excel(EditRequest, 10, ReadFrom.EditRequest));
						ExtentCucumberAdapter.addTestStepLog("From min is entered as : " + ReadFrom.Excel(EditRequest, 10, ReadFrom.EditRequest));

						Wait(2000);
						String ExcelMeridian = ReadFrom.Excel(EditRequest, 11, ReadFrom.EditRequest);

						String Meridian = GetText("FromMeridian", DeliveryRequestLocators);

						if(IsEqual(Meridian, ExcelMeridian)) {


						}
						else {
							Click("FromMeridian", DeliveryRequestLocators);
							Print("selected");
						}

						Wait(2000);
						Clear("ToHrs", DeliveryRequestLocators);
						TypeDataInTheField("ToHrs", DeliveryRequestLocators, ReadFrom.Excel(EditRequest, 12, ReadFrom.EditRequest));
						Print("To hrs is entered as : " + ReadFrom.Excel(EditRequest, 12, ReadFrom.EditRequest));
						ExtentCucumberAdapter.addTestStepLog("To hrs is entered as : " + ReadFrom.Excel(EditRequest, 12, ReadFrom.EditRequest));

						Wait(2000);
						Clear("ToMin", DeliveryRequestLocators);
						TypeDataInTheField("ToMin", DeliveryRequestLocators, ReadFrom.Excel(EditRequest, 13, ReadFrom.EditRequest));
						Print("To min is entered as : " + ReadFrom.Excel(EditRequest, 13, ReadFrom.EditRequest));
						ExtentCucumberAdapter.addTestStepLog("To min is entered as : " + ReadFrom.Excel(EditRequest, 13, ReadFrom.EditRequest));

						Wait(2000);
						String ExcelMeridian1 = ReadFrom.Excel(EditRequest, 14, ReadFrom.EditRequest);
						String Meridian1 = GetText("ToMeridian", DeliveryRequestLocators);
						if(IsEqual(Meridian1, ExcelMeridian1)) {


						}
						else {
							Click("ToMeridian", DeliveryRequestLocators);

						}

						MoveToElement("SubmitButton", DeliveryRequestLocators);

						Click("SubmitButton", DeliveryRequestLocators);
						ExtentCucumberAdapter.addTestStepLog("Submit button is clicked");
						Print("Submit button is clicked");

						Wait<WebDriver> fluentWait1111 = new FluentWait<WebDriver>(driver)
								.withTimeout(Duration.ofSeconds(120))
								.pollingEvery(Duration.ofSeconds(5))
								.ignoring(NoSuchElementException.class);


						fluentWait1111.until(new Function<WebDriver, WebElement>() {
							public WebElement apply(WebDriver driver) {
								return driver.findElement(By.xpath("//div[@aria-label='Delivery Request Updated Successfully.']"));
							}
						});

						if(IsElementDisplayed("DeliveryUpdated", DeliveryRequestLocators)) {
							Click("DeliveryUpdated", DeliveryRequestLocators);
							Print("Delivery request updated");
							ExtentCucumberAdapter.addTestStepLog("Delivery request updated");

						}
						else {
							PrintError("Delivery request failed");
							ExtentCucumberAdapter.addTestStepLog("Delivery request failed");
						}	

						Wait(5000);
						break;

					}

				}
			}
		}
		catch (Exception e) {
			PrintError(e.getMessage());
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());
		}

	}

	public static void FilterRequest() throws Throwable {

		PrintError("Filter request Started");
		ReadFrom.DynamicExcel(ReadFrom.FilterRequest);
		Print("Filter Request started");

		try {

			for(int Filter =1; Filter<=ReadFrom.rowcount; Filter++)	{

				Click("FilterIcon", DeliveryRequestLocators);
				ExtentCucumberAdapter.addTestStepLog("Filter icon is clicked");
				Print("Filter icon is clicked");
				Wait(6000);


				SelectFromVisibleText("EquipmentInFilter", DeliveryRequestLocators, ReadFrom.Excel(Filter, 0, ReadFrom.FilterRequest));
				ExtentCucumberAdapter.addTestStepLog("Equipment is selected as : " + ReadFrom.Excel(Filter, 0, ReadFrom.FilterRequest));
				Print("Equipment is selected as : " + ReadFrom.Excel(Filter, 0, ReadFrom.FilterRequest));

				Click("FilterApply", DeliveryRequestLocators);
				ExtentCucumberAdapter.addTestStepLog("Filter apply button is clicked");
				Print("Filter apply button is clicked");
				Wait(3000);

				
				Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
						.withTimeout(Duration.ofSeconds(120))
						.pollingEvery(Duration.ofSeconds(5))
						.ignoring(NoSuchElementException.class);


				WebElement waits = fluentWait.until(new Function<WebDriver, WebElement>() {
					public WebElement apply(WebDriver driver) {
						return driver.findElement(By.xpath("(//div/table/tbody/tr/td[3]/span/u)"));
					}
				});
				
				
				int rowcount = 	SizeOfTheList("DeliveryRequestLists", DeliveryRequestLocators);
				Print("No of Request displayed : " + rowcount);


				for(int RequestLists =1; RequestLists<=rowcount; RequestLists++)	{

					WebElement Request =	FindElement("EquipmentList" , DeliveryRequestLocators, RequestLists );
					String RequestName =	GetTextFromTheElement(Request);

					Wait(2000);

					String FilteredValue = ReadFrom.Excel(Filter, 0, ReadFrom.FilterRequest);


					if(	IsEqual(RequestName, FilteredValue)) {

						Wait(2000);
						Print("Filtered value is : " + FilteredValue + " : Request name is : " + RequestName);
						ExtentCucumberAdapter.addTestStepLog("Filtered value is : " + FilteredValue + " : Request name is : " + RequestName);
						Wait(3000);
//						/ScreenShots(null);

					}
					else {
						PrintError("Filtered value is : " + FilteredValue + " : Request name is : " + RequestName);
						ExtentCucumberAdapter.addTestStepLog("Filtered value is : " + FilteredValue + " : Request name is : " + RequestName);
					}


				}
				JsClick("FilterIcon", DeliveryRequestLocators);
				ExtentCucumberAdapter.addTestStepLog("Filter icon button is clicked");
				Print("Filter icon button is clicked");

				Wait(3000);
				JsClick("FilterReset", DeliveryRequestLocators);
				ExtentCucumberAdapter.addTestStepLog("Filter reset button is clicked");
				Print("Filter reset button is clicked");

				Wait(3000);
				Wait<WebDriver> Reset = new FluentWait<WebDriver>(driver)
						.withTimeout(Duration.ofSeconds(120))
						.pollingEvery(Duration.ofSeconds(5))
						.ignoring(NoSuchElementException.class);


				WebElement wait = Reset.until(new Function<WebDriver, WebElement>() {
					public WebElement apply(WebDriver driver) {
						return driver.findElement(By.xpath("(//div/table/tbody/tr/td[3]/span/u)"));
					}
				});
				//	Clear("SearchDfow", DFOWLocators);

			}
		}
		catch (Exception e) {
			PrintError(e.getMessage());
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());
		}
	}

	public static void ViewRequestInfo() throws Throwable {
		PrintError("View request info started");
		ReadFrom.DynamicExcel(ReadFrom.ViewRequest);
		try {

			for(int ViewRequest =1; ViewRequest<=ReadFrom.rowcount; ViewRequest++)	{


				int rowcount = 	SizeOfTheList("DeliveryRequestLists", DeliveryRequestLocators);
				Print("No of elements : " + rowcount);

				for(int DeliveryLists =1; DeliveryLists<=rowcount; DeliveryLists++)		{


					WebElement Delivery =	FindElement("DeliveryRequestList", DeliveryRequestLocators, DeliveryLists);

					String DeliveryName = 	GetTextFromTheElement(Delivery);

					String EditIt =	ReadFrom.Excel(ViewRequest, 0, ReadFrom.ViewRequest);

					if(IsEqual(DeliveryName, EditIt)) {

						JsClick(Delivery);

						ExtentCucumberAdapter.addTestStepLog(DeliveryName + " : is clicked");
						Print(DeliveryName + " : is clicked");


						Wait<WebDriver> fluentWait1 = new FluentWait<WebDriver>(driver)
								.withTimeout(Duration.ofSeconds(120))
								.pollingEvery(Duration.ofSeconds(5))
								.ignoring(NoSuchElementException.class);


						fluentWait1.until(new Function<WebDriver, WebElement>() {
							public WebElement apply(WebDriver driver) {
								return driver.findElement(By.xpath("//h4[normalize-space()='Delivery Status']"));
							}
						});

						ExtentCucumberAdapter.addTestStepLog(DeliveryName + " : info viewed");
						Print(DeliveryName + " : info viewed");

						if(IsElementDisplayed("ViewDetails", DeliveryRequestLocators)) {
							Waitfortheelement("ClosePopup", DeliveryRequestLocators);

							JsClick("ClosePopup", DeliveryRequestLocators);

							ExtentCucumberAdapter.addTestStepLog("Close popup button is clicked");
							Print("Close popup button is clicked");
							Wait(2000);
						}
					}
				}
			}
		}
		catch (Exception e) {
			PrintError(e.getMessage());
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());
		}

	}

	public static void AddComment() throws Throwable {
		PrintError("Add comment started");
		ReadFrom.DynamicExcel(ReadFrom.AddComment);
		try {

			for(int Comments =1; Comments<=ReadFrom.rowcount; Comments++)	{


				int rowcount = 	SizeOfTheList("DeliveryRequestLists", DeliveryRequestLocators);
				Print("No of elements : " + rowcount);

				for(int DeliveryLists =1; DeliveryLists<=rowcount; DeliveryLists++)		{


					WebElement Delivery =	FindElement("DeliveryRequestList", DeliveryRequestLocators, DeliveryLists);

					String DeliveryName = 	GetTextFromTheElement(Delivery);

					String AddComment =	ReadFrom.Excel(Comments, 0, ReadFrom.AddComment);

					if(IsEqual(DeliveryName, AddComment)) {

						JsClick(Delivery);

						ExtentCucumberAdapter.addTestStepLog(DeliveryName + " : is clicked");
						Print(DeliveryName + " : is clicked");


						Wait<WebDriver> fluentWait1 = new FluentWait<WebDriver>(driver)
								.withTimeout(Duration.ofSeconds(120))
								.pollingEvery(Duration.ofSeconds(5))
								.ignoring(NoSuchElementException.class);


						fluentWait1.until(new Function<WebDriver, WebElement>() {
							public WebElement apply(WebDriver driver) {
								return driver.findElement(By.xpath("//h4[normalize-space()='Delivery Status']"));
							}
						});
					
						Wait(3000);
						//	Stale("ViewDetails", DeliveryRequestLocators);
						Waitfortheelement("ViewDetails", DeliveryRequestLocators);
						//if(IsElementDisplayed("ViewDetails", DeliveryRequestLocators)) {

						Waitfortheelement("Comments", DeliveryRequestLocators);
						JsClick("Comments", DeliveryRequestLocators);
						ExtentCucumberAdapter.addTestStepLog("Comment button is clicked");
						Print("Comment button is clicked");

						TypeDataInTheField("AddComment", DeliveryRequestLocators, ReadFrom.Excel(Comments, 1, ReadFrom.AddComment));
						Print("Comment is entered as : " + ReadFrom.Excel(Comments, 1, ReadFrom.AddComment));
						ExtentCucumberAdapter.addTestStepLog("Description is entered as : " + ReadFrom.Excel(Comments, 1, ReadFrom.AddComment));

						MoveToElement("SubmitButton", DeliveryRequestLocators);
						JsClick("SubmitButton", DeliveryRequestLocators);
						ExtentCucumberAdapter.addTestStepLog("Submit button is clicked");
						Print("Submit button is clicked");

						Wait<WebDriver> fluentWait1111 = new FluentWait<WebDriver>(driver)
								.withTimeout(Duration.ofSeconds(120))
								.pollingEvery(Duration.ofSeconds(5))
								.ignoring(NoSuchElementException.class);


						fluentWait1111.until(new Function<WebDriver, WebElement>() {
							public WebElement apply(WebDriver driver) {
								return driver.findElement(By.xpath("//div[@aria-label='Comment added successfully.']"));
							}
						});

						if(IsElementDisplayed("CommentaddedSuccessfully", DeliveryRequestLocators)) {
							Waitfortheelement("CommentaddedSuccessfully", DeliveryRequestLocators);
							JsClick("CommentaddedSuccessfully", DeliveryRequestLocators);
							Print("Comment added Successfully");
							ExtentCucumberAdapter.addTestStepLog("Comment added Successfully");

							JsClick("ClosePopup", DeliveryRequestLocators);
							ExtentCucumberAdapter.addTestStepLog("Close popup is clicked");
							Print("Close popup is clicked");
						}
						//	}
					}


				}
			}
		}
		catch (Exception e) {
			PrintError(e.getMessage());
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());
		}

	}

	public static void ViewHistoryInfo() throws Throwable {
		PrintError("View history info started");
		ReadFrom.DynamicExcel(ReadFrom.ViewRequestHistory);
		try {

			for(int ViewRequest =1; ViewRequest<=ReadFrom.rowcount; ViewRequest++)	{


				int rowcount = 	SizeOfTheList("DeliveryRequestLists", DeliveryRequestLocators);
				Print("No of elements : " + rowcount);

				for(int DeliveryLists =1; DeliveryLists<=rowcount; DeliveryLists++)		{


					WebElement Delivery =	FindElement("DeliveryRequestList", DeliveryRequestLocators, DeliveryLists);

					String DeliveryName = 	GetTextFromTheElement(Delivery);

					String EditIt =	ReadFrom.Excel(ViewRequest, 0, ReadFrom.ViewRequestHistory);

					if(IsEqual(DeliveryName, EditIt)) {

						JsClick(Delivery);

						ExtentCucumberAdapter.addTestStepLog(DeliveryName + " : is clicked");
						Print(DeliveryName + " : is clicked");


						Wait<WebDriver> fluentWait1 = new FluentWait<WebDriver>(driver)
								.withTimeout(Duration.ofSeconds(120))
								.pollingEvery(Duration.ofSeconds(5))
								.ignoring(NoSuchElementException.class);


						fluentWait1.until(new Function<WebDriver, WebElement>() {
							public WebElement apply(WebDriver driver) {
								return driver.findElement(By.xpath("//h4[normalize-space()='Delivery Status']"));
							}
						});
						Print("came in ");
						Wait(2000);
						Waitfortheelement("History", DeliveryRequestLocators);
						JsClick("History", DeliveryRequestLocators);
						ExtentCucumberAdapter.addTestStepLog("History button is clicked");
						Print("History button is clicked");

						Wait<WebDriver> s = new FluentWait<WebDriver>(driver)
								.withTimeout(Duration.ofSeconds(120))
								.pollingEvery(Duration.ofSeconds(5))
								.ignoring(NoSuchElementException.class);


						s.until(new Function<WebDriver, WebElement>() {
							public WebElement apply(WebDriver driver) {
								return driver.findElement(By.xpath("//app-history//li[1]//p[1]"));
							}
						});

						if(IsElementDisplayed("HistoryPage", DeliveryRequestLocators)) {

							Print(DeliveryName + " : History page is viewed");
							ExtentCucumberAdapter.addTestStepLog(DeliveryName + " : History page is viewed");

							JsClick("ClosePopup", DeliveryRequestLocators);
							ExtentCucumberAdapter.addTestStepLog("Close popup button is clicked");
							Print("Close popup button is clicked");
						}
					}
				}
			}
		}
		catch (Exception e) {
			PrintError(e.getMessage());
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());
		}

	}

	public static void Deliver() throws Throwable {
		PrintError("Deliver started");
		ReadFrom.DynamicExcel(ReadFrom.Deliver);
		try {

			for(int Deliver =1; Deliver<=ReadFrom.rowcount; Deliver++)	{


				int rowcount = 	SizeOfTheList("DeliveryRequestLists", DeliveryRequestLocators);
				Print("No of elements : " + rowcount);

				for(int DeliveryLists =1; DeliveryLists<=rowcount; DeliveryLists++)		{


					WebElement Delivery =	FindElement("DeliveryRequestList", DeliveryRequestLocators, DeliveryLists);

					String DeliveryName = 	GetTextFromTheElement(Delivery);

					String DeliverIt =	ReadFrom.Excel(Deliver, 0, ReadFrom.Deliver);

					if(IsEqual(DeliveryName, DeliverIt)) {

						JsClick(Delivery);

						ExtentCucumberAdapter.addTestStepLog(DeliveryName + " : is clicked");
						Print(DeliveryName + " : is clicked");


						Wait<WebDriver> fluentWait1 = new FluentWait<WebDriver>(driver)
								.withTimeout(Duration.ofSeconds(120))
								.pollingEvery(Duration.ofSeconds(5))
								.ignoring(NoSuchElementException.class);


						fluentWait1.until(new Function<WebDriver, WebElement>() {
							public WebElement apply(WebDriver driver) {
								return driver.findElement(By.xpath("//h4[normalize-space()='Delivery Status']"));
							}
						});

						Wait(2000);
						JsClick("Deliver", DeliveryRequestLocators);
						ExtentCucumberAdapter.addTestStepLog("Deliver button is clicked");
						Print("Deliver button is clicked");
						Wait(2000);
						JsClick("Save", DeliveryRequestLocators);
						ExtentCucumberAdapter.addTestStepLog("Save button is clicked");
						Print("Save button is clicked");
						Wait(2000);
						JsClick("YesButton", DeliveryRequestLocators);
						ExtentCucumberAdapter.addTestStepLog("Yes button is clicked");
						Print("Yes button is clicked");

						Wait<WebDriver> s = new FluentWait<WebDriver>(driver)
								.withTimeout(Duration.ofSeconds(120))
								.pollingEvery(Duration.ofSeconds(5))
								.ignoring(NoSuchElementException.class);


						s.until(new Function<WebDriver, WebElement>() {
							public WebElement apply(WebDriver driver) {
								return driver.findElement(By.xpath("//div[@aria-label='Delivered Successfully.']"));
							}
						});

						if(IsElementDisplayed("DeliveredSuccessfully", DeliveryRequestLocators)) {

							Print(DeliveryName + " : is delivered successfully");
							ExtentCucumberAdapter.addTestStepLog(DeliveryName + " : is delivered successfully");

							JsClick("ClosePopup", DeliveryRequestLocators);
							ExtentCucumberAdapter.addTestStepLog("Close popup button is clicked");
							Print("Close popup button is clicked");
						}
					}
				}
			}
		}
		catch (Exception e) {
			PrintError(e.getMessage());
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());
		}

	}


	public static void ApproveOrReject() throws Throwable {
		PrintError("Approve or reject started");
		ReadFrom.DynamicExcel(ReadFrom.ApproveReject);
		try {

			for(int ApproveReject =1; ApproveReject<=ReadFrom.rowcount; ApproveReject++)	{


				int rowcount = 	SizeOfTheList("DeliveryRequestLists", DeliveryRequestLocators);
				Print("No of elements : " + rowcount);

				for(int DeliveryLists =1; DeliveryLists<=rowcount; DeliveryLists++)		{


					WebElement Delivery =	FindElement("DeliveryRequestList", DeliveryRequestLocators, DeliveryLists);

					String DeliveryName = 	GetTextFromTheElement(Delivery);

					String DeliverIt =	ReadFrom.Excel(ApproveReject, 0, ReadFrom.ApproveReject);

					if(IsEqual(DeliveryName, DeliverIt)) {

						WebElement EditButton =	FindElement("EditRequest", DeliveryRequestLocators, DeliveryLists);

						JsClick(EditButton);
						ExtentCucumberAdapter.addTestStepLog("Edit button is clicked");
						Print("Edit button is clicked");

						Wait<WebDriver> Description = new FluentWait<WebDriver>(driver)
								.withTimeout(Duration.ofSeconds(120))
								.pollingEvery(Duration.ofSeconds(5))
								.ignoring(NoSuchElementException.class);


						Description.until(new Function<WebDriver, WebElement>() {
							public WebElement apply(WebDriver driver) {
								return driver.findElement(By.xpath("//textarea[@placeholder='Enter Description']"));
							}
						});


						Clear("Description", DeliveryRequestLocators);
						TypeDataInTheField("Description", DeliveryRequestLocators, ReadFrom.Excel(ApproveReject, 0, ReadFrom.ApproveReject));
						Print("Description is entered as : " + ReadFrom.Excel(ApproveReject, 0, ReadFrom.ApproveReject));
						ExtentCucumberAdapter.addTestStepLog("Description is entered as : " + ReadFrom.Excel(ApproveReject, 0, ReadFrom.ApproveReject));


						MoveToElement("SubmitButton", DeliveryRequestLocators);

						Click("SubmitButton", DeliveryRequestLocators);
						ExtentCucumberAdapter.addTestStepLog("Submit button is clicked");
						Print("Submit button is clicked");

						Wait<WebDriver> fluentWait1111 = new FluentWait<WebDriver>(driver)
								.withTimeout(Duration.ofSeconds(120))
								.pollingEvery(Duration.ofSeconds(5))
								.ignoring(NoSuchElementException.class);


						fluentWait1111.until(new Function<WebDriver, WebElement>() {
							public WebElement apply(WebDriver driver) {
								return driver.findElement(By.xpath("//div[@aria-label='Delivery Request Updated Successfully.']"));
							}
						});



						List<WebElement> Text =		GetTextFromElements("DeliveryRequestLists", DeliveryRequestLocators);
						for (WebElement webElement : Text) {
							String Name = GetTextFromTheElement(webElement);
							String EditName =	ReadFrom.Excel(ApproveReject, 0, ReadFrom.ApproveReject);

							Wait(2000);

							if(IsEqual(Name, EditName)) {		
								JsClick(webElement);
								ExtentCucumberAdapter.addTestStepLog(Name + " : is clicked");
								Print(Name + " : is clicked");
							}

						}

						Wait(2000);
						SelectFromVisibleText("SelectStatus", DeliveryRequestLocators, ReadFrom.Excel(ApproveReject, 1, ReadFrom.ApproveReject));
						Print("Status is selected as : " + ReadFrom.Excel(ApproveReject, 1, ReadFrom.ApproveReject));
						ExtentCucumberAdapter.addTestStepLog("Status is selected as : " + ReadFrom.Excel(ApproveReject, 1, ReadFrom.ApproveReject));

						Wait(2000);
						JsClick("Save", DeliveryRequestLocators);
						ExtentCucumberAdapter.addTestStepLog("Save button is clicked");
						Print("Save button is clicked");


						String Status = ReadFrom.Excel(ApproveReject, 1, ReadFrom.ApproveReject);

						if (IsEqual(Status, "Approved")) {
							Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
									.withTimeout(Duration.ofSeconds(120))
									.pollingEvery(Duration.ofSeconds(5))
									.ignoring(NoSuchElementException.class);


							fluentWait.until(new Function<WebDriver, WebElement>() {
								public WebElement apply(WebDriver driver) {
									return driver.findElement(By.xpath("//div[@aria-label='Approved Successfully.']"));
								}
							});
							ExtentCucumberAdapter.addTestStepLog("Delivery request is approved");
							Print("Delivery request is approved");
							Wait(3000);
							JsClick("ClosePopup", DeliveryRequestLocators);
							ExtentCucumberAdapter.addTestStepLog("Close popup button is clicked");
							Print("Close popup button is clicked");

						}
						else if(IsEqual(Status, "Declined")) {
							Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
									.withTimeout(Duration.ofSeconds(120))
									.pollingEvery(Duration.ofSeconds(5))
									.ignoring(NoSuchElementException.class);


							fluentWait.until(new Function<WebDriver, WebElement>() {
								public WebElement apply(WebDriver driver) {
									return driver.findElement(By.xpath("//div[@aria-label='Declined Successfully.']"));
								}
							});
							ExtentCucumberAdapter.addTestStepLog("Delivery request is declined");
							Print("Delivery request is declined");
							Wait(3000);
							JsClick("ClosePopup", DeliveryRequestLocators);
							ExtentCucumberAdapter.addTestStepLog("Close popup button is clicked");
							Print("Close popup button is clicked");
						}
					}
					break;
				}
			}
		}
		catch (Exception e) {
			PrintError(e.getMessage());
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());
		}

	}
	
	public static void PushToVoid() throws Throwable {
		PrintError("Push to void started");
		ReadFrom.DynamicExcel(ReadFrom.VoidRequest);
		try {

			for(int Deliver =1; Deliver<=ReadFrom.rowcount; Deliver++)	{


				int rowcount = 	SizeOfTheList("DeliveryRequestLists", DeliveryRequestLocators);
				Print("No of elements : " + rowcount);

				for(int DeliveryLists =1; DeliveryLists<=rowcount; DeliveryLists++)		{


					WebElement Delivery =	FindElement("DeliveryRequestList", DeliveryRequestLocators, DeliveryLists);

					String DeliveryName = 	GetTextFromTheElement(Delivery);

					String DeliverIt =	ReadFrom.Excel(Deliver, 0, ReadFrom.VoidRequest);

					if(IsEqual(DeliveryName, DeliverIt)) {

						JsClick(Delivery);

						ExtentCucumberAdapter.addTestStepLog(DeliveryName + " : is clicked");
						Print(DeliveryName + " : is clicked");


						Wait<WebDriver> fluentWait1 = new FluentWait<WebDriver>(driver)
								.withTimeout(Duration.ofSeconds(120))
								.pollingEvery(Duration.ofSeconds(5))
								.ignoring(NoSuchElementException.class);


						fluentWait1.until(new Function<WebDriver, WebElement>() {
							public WebElement apply(WebDriver driver) {
								return driver.findElement(By.xpath("//h4[normalize-space()='Delivery Status']"));
							}
						});

						Wait(2000);
						JsClick("VoidButton", DeliveryRequestLocators);
						ExtentCucumberAdapter.addTestStepLog("Void button is clicked");
						Print("Void button is clicked");

						Wait(2000);
						Click("VoidYes", DeliveryRequestLocators);
						ExtentCucumberAdapter.addTestStepLog("Yes button is clicked");
						Print("Yes button is clicked");

						Wait<WebDriver> fluentWait1111 = new FluentWait<WebDriver>(driver)
								.withTimeout(Duration.ofSeconds(120))
								.pollingEvery(Duration.ofSeconds(5))
								.ignoring(NoSuchElementException.class);


						fluentWait1111.until(new Function<WebDriver, WebElement>() {
							public WebElement apply(WebDriver driver) {
								return driver.findElement(By.xpath("//div[@aria-label='Delivery Request Marked as Void Successfully.']"));
							}
						});

						if(IsElementDisplayed("VoidSuccessfull", DeliveryRequestLocators)) {
							Click("VoidSuccessfull", DeliveryRequestLocators);
							Print(DeliveryName + " : is pushed to void");
							ExtentCucumberAdapter.addTestStepLog(DeliveryName + " : is pushed to void");
							break ;
						
							//Stale("DeliveryCalendar", DeliveryRequestLocators);
						


						}
						else {
							PrintError("Void push is failed");
							ExtentCucumberAdapter.addTestStepLog("Void push is failed");
						}	

					}
					
				}
				
				
			}
		}
		catch (Exception e) {
			PrintError(e.getMessage());
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());
		}

	}

}
