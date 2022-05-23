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

public class F_14_CraneRequest extends Baseclass{




	public static void AddCraneRequest() throws Throwable {

		ReadFrom.DynamicExcel(ReadFrom.AddCraneRequest);

		try {
			for(int AddCraneRequest =1; AddCraneRequest<=ReadFrom.rowcount; AddCraneRequest++)		{	

				Wait(4000);
				PrintError("Add Crane Calendar Started");
				Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
						.withTimeout(Duration.ofSeconds(120))
						.pollingEvery(Duration.ofSeconds(5))
						.ignoring(ElementClickInterceptedException.class);


				fluentWait.until(new Function<WebDriver, WebElement>() {
					public WebElement apply(WebDriver driver) {
						return driver.findElement(By.xpath("//button[normalize-space()='Create New']"));
					}
				});

				if(IsElementDisplayed("CreateNew", CraneRequestLocators)){
					JsClick("CreateNew", CraneRequestLocators);
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

				if(IsElementDisplayed("Description", CraneRequestLocators)) {
					Print("Delivery popup is opened");
					ExtentCucumberAdapter.addTestStepLog("Delivery popup is opened");
				}

				TypeDataInTheField("Description", CraneRequestLocators, ReadFrom.Excel(AddCraneRequest, 0, ReadFrom.AddCraneRequest));
				Print("Description is entered as : " + ReadFrom.Excel(AddCraneRequest, 0, ReadFrom.AddCraneRequest));
				ExtentCucumberAdapter.addTestStepLog("Description is entered as : " + ReadFrom.Excel(AddCraneRequest, 0, ReadFrom.AddCraneRequest));


				Click("Company", CraneRequestLocators);
				ExtentCucumberAdapter.addTestStepLog("Company dropdown is clicked");

				String CompanyInExcel = ReadFrom.Excel(AddCraneRequest, 1, ReadFrom.AddCraneRequest);
				Print(CompanyInExcel);

				int countofthelist = 	SizeOfTheList("CompanyAdd", CraneRequestLocators);
				Print("No of elements : " + countofthelist);

				for(int DropdownValues =1; DropdownValues<=countofthelist; DropdownValues++)		{	

					WebElement Company = 	FindElement("CompanyAddList", CraneRequestLocators, DropdownValues);
					String CompanyInDropdown = 	GetTextFromTheElement(Company);
					Print(CompanyInDropdown);

					if(IsEqual(CompanyInDropdown, CompanyInExcel)){
						Click(Company);

						ExtentCucumberAdapter.addTestStepLog(CompanyInDropdown + " is selected from the dropdown");
						Print(CompanyInDropdown + " is selected from the dropdown");
						break;
					}
				}	
				///////////////////////

				Click("Dfow", CraneRequestLocators);
				ExtentCucumberAdapter.addTestStepLog("Dfow dropdown is clicked");

				String DfowInExcel = ReadFrom.Excel(AddCraneRequest, 2,ReadFrom.AddCraneRequest);
				Print(DfowInExcel);

				int rowcountofthelist = 	SizeOfTheList("DfowAdd", CraneRequestLocators);
				Print("No of elements : " + rowcountofthelist);

				for(int DropdownValues =1; DropdownValues<=rowcountofthelist; DropdownValues++)		{	
					WebElement Dfow = 	FindElement("DfowAddList", CraneRequestLocators, DropdownValues);
					String DfowInDropdown = 	GetTextFromTheElement(Dfow);
					Print(DfowInDropdown);


					if(IsEqual(DfowInDropdown, DfowInExcel)){
						Click(Dfow);
						ExtentCucumberAdapter.addTestStepLog(DfowInDropdown + " is selected from the dropdown");
						Print("Dfow is selected as : " + DfowInDropdown );
						break;
					}
				}	

				/////////////////////////////////////

				SelectFromVisibleText("EquipmentDropdown", CraneRequestLocators, ReadFrom.Excel(AddCraneRequest, 10, ReadFrom.AddCraneRequest));
				Print("Equipment dropdown is selected as : " + ReadFrom.Excel(AddCraneRequest, 10, ReadFrom.AddCraneRequest));
				ExtentCucumberAdapter.addTestStepLog("Equipment dropdown is selected as : " + ReadFrom.Excel(AddCraneRequest, 10, ReadFrom.AddCraneRequest));


				Clear("DeliveryDate", CraneRequestLocators);
				TypeDataInTheField("DeliveryDate", CraneRequestLocators, ReadFrom.Excel(AddCraneRequest, 3, ReadFrom.AddCraneRequest));
				Print("Start date is entered as : " + ReadFrom.Excel(AddCraneRequest, 3, ReadFrom.AddCraneRequest));
				ExtentCucumberAdapter.addTestStepLog("Start date is entered as : " + ReadFrom.Excel(AddCraneRequest, 3, ReadFrom.AddCraneRequest));

				///////

				Wait(2000);
				Clear("FromHrs", CraneRequestLocators);
				TypeDataInTheField("FromHrs", CraneRequestLocators, ReadFrom.Excel(AddCraneRequest, 4, ReadFrom.AddCraneRequest));
				Print("From hrs is entered as : " + ReadFrom.Excel(AddCraneRequest, 4, ReadFrom.AddCraneRequest));
				ExtentCucumberAdapter.addTestStepLog("From hrs is entered as : " + ReadFrom.Excel(AddCraneRequest, 4, ReadFrom.AddCraneRequest));

				Wait(2000);
				Clear("FromMin", CraneRequestLocators);
				TypeDataInTheField("FromMin", CraneRequestLocators, ReadFrom.Excel(AddCraneRequest, 5, ReadFrom.AddCraneRequest));
				Print("From min is entered as : " + ReadFrom.Excel(AddCraneRequest, 5, ReadFrom.AddCraneRequest));
				ExtentCucumberAdapter.addTestStepLog("From min is entered as : " + ReadFrom.Excel(AddCraneRequest, 5, ReadFrom.AddCraneRequest));

				Wait(2000);
				String ExcelMeridian = ReadFrom.Excel(AddCraneRequest, 6, ReadFrom.AddCraneRequest);
				Print("eXCEL" + ExcelMeridian);
				String Meridian = GetText("FromMeridian", CraneRequestLocators);
				Print("WEB" + Meridian);
				if(IsEqual(Meridian, ExcelMeridian)) {


				}
				else {
					Click("FromMeridian", CraneRequestLocators);
				}

				Wait(2000);
				Clear("ToHrs", CraneRequestLocators);
				TypeDataInTheField("ToHrs", CraneRequestLocators, ReadFrom.Excel(AddCraneRequest, 7, ReadFrom.AddCraneRequest));
				Print("To hrs is entered as : " + ReadFrom.Excel(AddCraneRequest, 7, ReadFrom.AddCraneRequest));
				ExtentCucumberAdapter.addTestStepLog("To hrs is entered as : " + ReadFrom.Excel(AddCraneRequest, 7, ReadFrom.AddCraneRequest));

				Wait(2000);
				Clear("ToMin", CraneRequestLocators);
				TypeDataInTheField("ToMin", CraneRequestLocators, ReadFrom.Excel(AddCraneRequest, 8, ReadFrom.AddCraneRequest));
				Print("To min is entered as : " + ReadFrom.Excel(AddCraneRequest, 8, ReadFrom.AddCraneRequest));
				ExtentCucumberAdapter.addTestStepLog("To min is entered as : " + ReadFrom.Excel(AddCraneRequest, 8, ReadFrom.AddCraneRequest));

				Wait(2000);
				String ExcelMeridian1 = ReadFrom.Excel(AddCraneRequest, 9, ReadFrom.AddCraneRequest);
				String Meridian1 = GetText("ToMeridian", CraneRequestLocators);
				if(IsEqual(Meridian1, ExcelMeridian1)) {


				}
				else {
					Click("ToMeridian", CraneRequestLocators);
					Print("selected2");
				}


				Wait(2000);
				Clear("PickingFrom", CraneRequestLocators);
				TypeDataInTheField("PickingFrom", CraneRequestLocators, ReadFrom.Excel(AddCraneRequest, 11, ReadFrom.AddCraneRequest));
				Print("Picking from is entered as : " + ReadFrom.Excel(AddCraneRequest, 11, ReadFrom.AddCraneRequest));
				ExtentCucumberAdapter.addTestStepLog("Picking from is entered as : " + ReadFrom.Excel(AddCraneRequest, 11, ReadFrom.AddCraneRequest));

				Wait(2000);
				Clear("PickingTo", CraneRequestLocators);
				TypeDataInTheField("PickingTo", CraneRequestLocators, ReadFrom.Excel(AddCraneRequest, 12, ReadFrom.AddCraneRequest));
				Print("Picking to is entered as : " + ReadFrom.Excel(AddCraneRequest, 12, ReadFrom.AddCraneRequest));
				ExtentCucumberAdapter.addTestStepLog("Picking to is entered as : " + ReadFrom.Excel(AddCraneRequest, 12, ReadFrom.AddCraneRequest));

				Wait(2000);
				MoveToElement("AdditionalText", CraneRequestLocators);
				Clear("AdditionalText", CraneRequestLocators);
				TypeDataInTheField("AdditionalText", CraneRequestLocators, ReadFrom.Excel(AddCraneRequest, 13, ReadFrom.AddCraneRequest));
				Print("Additional text is entered as : " + ReadFrom.Excel(AddCraneRequest, 13, ReadFrom.AddCraneRequest));
				ExtentCucumberAdapter.addTestStepLog("Additional text is entered as : " + ReadFrom.Excel(AddCraneRequest, 13, ReadFrom.AddCraneRequest));

				Wait(4000);	

				MoveToElement("SubmitButton", CraneRequestLocators);

				Click("SubmitButton", CraneRequestLocators);

				Wait<WebDriver> fluentWait11 = new FluentWait<WebDriver>(driver)
						.withTimeout(Duration.ofSeconds(120))
						.pollingEvery(Duration.ofSeconds(5))
						.ignoring(NoSuchElementException.class);


				fluentWait11.until(new Function<WebDriver, WebElement>() {
					public WebElement apply(WebDriver driver) {
						return driver.findElement(By.xpath("//div[@aria-label='Crane Request Created Successfully.']"));
					}
				});

				if(IsElementDisplayed("DeliveryAdded", CraneRequestLocators)) {
					Click("DeliveryAdded", CraneRequestLocators);
					Print("Delivery request added");
				}
				else {
					PrintError("Delivery not added");
				}
				Wait(3000);
			}
		}
		catch (Exception e) {
			PrintError(e.getMessage());
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());
		}
	}



	public static void ViewCraneRequestInfo() throws Throwable {
		PrintError("ViewCraneRequestInfo started");
		ReadFrom.DynamicExcel(ReadFrom.ViewCraneRequest);
		try {
			Wait(3000);
			for(int ViewCraneRequest =1; ViewCraneRequest<=ReadFrom.rowcount; ViewCraneRequest++)	{
				Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
						.withTimeout(Duration.ofSeconds(120))
						.pollingEvery(Duration.ofSeconds(5))
						.ignoring(NoSuchElementException.class);


				WebElement waits = fluentWait.until(new Function<WebDriver, WebElement>() {
					public WebElement apply(WebDriver driver) {
						return driver.findElement(By.xpath("(//div/table/tbody/tr/td[2]/span/u)"));
					}
				});

				int rowcount = 	SizeOfTheList("CraneRequestLists", CraneRequestLocators);
				Print("No of elements : " + rowcount);

				for(int DeliveryLists =1; DeliveryLists<=rowcount; DeliveryLists++)		{


					WebElement Delivery =	FindElement("CraneRequestList", CraneRequestLocators, DeliveryLists);

					String DeliveryName = 	GetTextFromTheElement(Delivery);

					String EditIt =	ReadFrom.Excel(ViewCraneRequest, 0, ReadFrom.ViewCraneRequest);

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
								return driver.findElement(By.xpath("//h4[normalize-space()='Crane Request Status']"));
							}
						});

						ExtentCucumberAdapter.addTestStepLog(DeliveryName + " : info viewed");
						Print(DeliveryName + " : info viewed");

						if(IsElementDisplayed("ViewDetails", CraneRequestLocators)) {
							Waitfortheelement("ClosePopup", CraneRequestLocators);

							JsClick("ClosePopup", CraneRequestLocators);

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


	public static void EditCraneRequest() throws Throwable {
		PrintError("Edit delivery started");
		ReadFrom.DynamicExcel(ReadFrom.EditCraneRequest);
		try {

			for(int EditCraneRequest =1; EditCraneRequest<=ReadFrom.rowcount; EditCraneRequest++)	{


				int rowcount = 	SizeOfTheList("CraneRequestLists", CraneRequestLocators);
				Print("No of elements : " + rowcount);

				for(int DeliveryLists =1; DeliveryLists<=rowcount; DeliveryLists++)		{


					WebElement Delivery =	FindElement("CraneRequestList", CraneRequestLocators, DeliveryLists);

					String DeliveryName = 	GetTextFromTheElement(Delivery);

					String EditIt =	ReadFrom.Excel(EditCraneRequest, 0, ReadFrom.EditCraneRequest);


					if(IsEqual(DeliveryName, EditIt)) {

						WebElement EditButton =	FindElement("EditCraneRequest", CraneRequestLocators, DeliveryLists);

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

						if(IsElementDisplayed("Description", CraneRequestLocators)) {
							Print("Delivery popup is opened");
							ExtentCucumberAdapter.addTestStepLog("Delivery popup is opened");
						}

						Clear("Description", CraneRequestLocators);
						TypeDataInTheField("Description", CraneRequestLocators, ReadFrom.Excel(EditCraneRequest, 1, ReadFrom.EditCraneRequest));
						Print("Description is entered as : " + ReadFrom.Excel(EditCraneRequest, 1, ReadFrom.EditCraneRequest));
						ExtentCucumberAdapter.addTestStepLog("Description is entered as : " + ReadFrom.Excel(EditCraneRequest, 1, ReadFrom.EditCraneRequest));

						SelectFromVisibleText("EquipmentDropdown", CraneRequestLocators, ReadFrom.Excel(EditCraneRequest, 2, ReadFrom.EditCraneRequest));
						Print("Equipment dropdown is selected as : " + ReadFrom.Excel(EditCraneRequest, 2, ReadFrom.EditCraneRequest));
						ExtentCucumberAdapter.addTestStepLog("Equipment dropdown is selected as : " + ReadFrom.Excel(EditCraneRequest, 2, ReadFrom.EditCraneRequest));

						Wait(2000);

						Clear("PickingFrom", CraneRequestLocators);
						TypeDataInTheField("PickingFrom", CraneRequestLocators, ReadFrom.Excel(EditCraneRequest, 13, ReadFrom.EditCraneRequest));
						Print("Picking from is entered as : " + ReadFrom.Excel(EditCraneRequest, 13, ReadFrom.EditCraneRequest));
						ExtentCucumberAdapter.addTestStepLog("Picking from is entered as : " + ReadFrom.Excel(EditCraneRequest, 13, ReadFrom.EditCraneRequest));

						Wait(2000);
						Clear("PickingTo", CraneRequestLocators);
						TypeDataInTheField("PickingTo", CraneRequestLocators, ReadFrom.Excel(EditCraneRequest, 14, ReadFrom.EditCraneRequest));
						Print("Picking to is entered as : " + ReadFrom.Excel(EditCraneRequest, 14, ReadFrom.EditCraneRequest));
						ExtentCucumberAdapter.addTestStepLog("Picking to is entered as : " + ReadFrom.Excel(EditCraneRequest, 14, ReadFrom.EditCraneRequest));


						Wait(2000);
						MoveToElement("AdditionalText", CraneRequestLocators);
						Clear("AdditionalText", CraneRequestLocators);
						TypeDataInTheField("AdditionalText", CraneRequestLocators, ReadFrom.Excel(EditCraneRequest, 3, ReadFrom.EditCraneRequest));
						Print("Additional text is entered as : " + ReadFrom.Excel(EditCraneRequest, 3, ReadFrom.EditCraneRequest));
						ExtentCucumberAdapter.addTestStepLog("Additional text is entered as : " + ReadFrom.Excel(EditCraneRequest, 3, ReadFrom.EditCraneRequest));

						Clear("DeliveryDate", CraneRequestLocators);
						TypeDataInTheField("DeliveryDate", CraneRequestLocators, ReadFrom.Excel(EditCraneRequest, 4, ReadFrom.EditCraneRequest));
						Print("Start date is entered as : " + ReadFrom.Excel(EditCraneRequest, 4, ReadFrom.EditCraneRequest));
						ExtentCucumberAdapter.addTestStepLog("Start date is entered as : " + ReadFrom.Excel(EditCraneRequest, 4, ReadFrom.EditCraneRequest));

						Wait(3000);


						///////////////////////

						JsClick("DfowEdit", CraneRequestLocators);


						ExtentCucumberAdapter.addTestStepLog("Dfow dropdown is clicked");

						Click("SelectAll", CraneRequestLocators);
						Wait(2000);
						Click("SelectAll", CraneRequestLocators);
						Wait(2000);


						String DfowInExcel = ReadFrom.Excel(EditCraneRequest, 5, ReadFrom.EditCraneRequest);


						int rowcountofthelist = 	SizeOfTheList("DfowListEdit", CraneRequestLocators);
						Print("No of elements : " + rowcountofthelist);

						for(int DropdownValues =1; DropdownValues<=rowcountofthelist; DropdownValues++)		{	
							WebElement Dfow = 	FindElement("DfowListEdits", CraneRequestLocators, DropdownValues);
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
						JsClick("CompanyEdit", CraneRequestLocators);

						ExtentCucumberAdapter.addTestStepLog("Company dropdown is clicked");
						Print("Company dropdown is clicked");

						Click("UnselectAll", CraneRequestLocators);
						Wait(2000);
						Click("UnselectAll", CraneRequestLocators);
						Wait(2000);


						String CompanyInExcel = ReadFrom.Excel(EditCraneRequest, 6, ReadFrom.EditCraneRequest);


						int countofthelist = 	SizeOfTheList("CompanyListEdit", CraneRequestLocators);
						Print("No of elements : " + countofthelist);

						for(int DropdownValues =1; DropdownValues<=countofthelist; DropdownValues++)		{	
							WebElement Company = 	FindElement("CompanyListEdits", CraneRequestLocators, DropdownValues);
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
						Clear("FromHrs", CraneRequestLocators);
						TypeDataInTheField("FromHrs", CraneRequestLocators, ReadFrom.Excel(EditCraneRequest, 7, ReadFrom.EditCraneRequest));
						Print("From hrs is entered as : " + ReadFrom.Excel(EditCraneRequest, 7, ReadFrom.EditCraneRequest));
						ExtentCucumberAdapter.addTestStepLog("From hrs is entered as : " + ReadFrom.Excel(EditCraneRequest, 7, ReadFrom.EditCraneRequest));

						Wait(2000);
						Clear("FromMin", CraneRequestLocators);
						TypeDataInTheField("FromMin", CraneRequestLocators, ReadFrom.Excel(EditCraneRequest, 8, ReadFrom.EditCraneRequest));
						Print("From min is entered as : " + ReadFrom.Excel(EditCraneRequest, 8, ReadFrom.EditCraneRequest));
						ExtentCucumberAdapter.addTestStepLog("From min is entered as : " + ReadFrom.Excel(EditCraneRequest, 8, ReadFrom.EditCraneRequest));

						Wait(2000);
						String ExcelMeridian = ReadFrom.Excel(EditCraneRequest, 9, ReadFrom.EditCraneRequest);

						String Meridian = GetText("FromMeridian", CraneRequestLocators);

						if(IsEqual(Meridian, ExcelMeridian)) {


						}
						else {
							Click("FromMeridian", CraneRequestLocators);
							Print("selected");
						}

						Wait(2000);
						Clear("ToHrs", CraneRequestLocators);
						TypeDataInTheField("ToHrs", CraneRequestLocators, ReadFrom.Excel(EditCraneRequest, 10, ReadFrom.EditCraneRequest));
						Print("To hrs is entered as : " + ReadFrom.Excel(EditCraneRequest, 10, ReadFrom.EditCraneRequest));
						ExtentCucumberAdapter.addTestStepLog("To hrs is entered as : " + ReadFrom.Excel(EditCraneRequest, 10, ReadFrom.EditCraneRequest));

						Wait(2000);
						Clear("ToMin", CraneRequestLocators);
						TypeDataInTheField("ToMin", CraneRequestLocators, ReadFrom.Excel(EditCraneRequest, 11, ReadFrom.EditCraneRequest));
						Print("To min is entered as : " + ReadFrom.Excel(EditCraneRequest, 11, ReadFrom.EditCraneRequest));
						ExtentCucumberAdapter.addTestStepLog("To min is entered as : " + ReadFrom.Excel(EditCraneRequest, 11, ReadFrom.EditCraneRequest));

						Wait(2000);
						String ExcelMeridian1 = ReadFrom.Excel(EditCraneRequest, 12, ReadFrom.EditCraneRequest);
						String Meridian1 = GetText("ToMeridian", CraneRequestLocators);
						if(IsEqual(Meridian1, ExcelMeridian1)) {


						}
						else {
							Click("ToMeridian", CraneRequestLocators);

						}

						MoveToElement("SubmitButton", CraneRequestLocators);

						Click("SubmitButton", CraneRequestLocators);
						ExtentCucumberAdapter.addTestStepLog("Submit button is clicked");
						Print("Submit button is clicked");

						Wait<WebDriver> fluentWait1111 = new FluentWait<WebDriver>(driver)
								.withTimeout(Duration.ofSeconds(120))
								.pollingEvery(Duration.ofSeconds(5))
								.ignoring(NoSuchElementException.class);


						fluentWait1111.until(new Function<WebDriver, WebElement>() {
							public WebElement apply(WebDriver driver) {
								return driver.findElement(By.xpath("//div[@aria-label='Crane Request Updated Successfully.']"));
							}
						});

						if(IsElementDisplayed("CraneRequestUpdated", CraneRequestLocators)) {
							Click("CraneRequestUpdated", CraneRequestLocators);
							Print("Crane request updated");
							ExtentCucumberAdapter.addTestStepLog("Crane request updated");

						}
						else {
							PrintError("Crane request failed");
							ExtentCucumberAdapter.addTestStepLog("Crane request failed");
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

	public static void FilterCraneRequest() throws Throwable {


		ReadFrom.DynamicExcel(ReadFrom.FilterCraneRequest);
		Print("Filter Request started");

		try {

			for(int Filter =1; Filter<=ReadFrom.rowcount; Filter++)	{

				Click("FilterIcon", CraneRequestLocators);
				ExtentCucumberAdapter.addTestStepLog("Filter icon is clicked");
				Print("Filter icon is clicked");
				Wait(6000);


				SelectFromVisibleText("EquipmentInFilter", CraneRequestLocators, ReadFrom.Excel(Filter, 0, ReadFrom.FilterCraneRequest));
				ExtentCucumberAdapter.addTestStepLog("Equipment is selected as : " + ReadFrom.Excel(Filter, 0, ReadFrom.FilterCraneRequest));
				Print("Equipment is selected as : " + ReadFrom.Excel(Filter, 0, ReadFrom.FilterCraneRequest));

				Click("FilterApply", CraneRequestLocators);
				ExtentCucumberAdapter.addTestStepLog("Filter apply button is clicked");
				Print("Filter apply button is clicked");
				Wait(3000);

				int rowcount = 	SizeOfTheList("CraneRequestLists", CraneRequestLocators);
				Print("No of Request displayed : " + rowcount);


				for(int RequestLists =1; RequestLists<=rowcount; RequestLists++)	{

					WebElement Equipment =	FindElement("EquipmentList" , CraneRequestLocators, RequestLists );
					String EquipmentName =	GetTextFromTheElement(Equipment);

					Wait(2000);

					WebElement Request =	FindElement("CraneRequestList" , CraneRequestLocators, RequestLists );
					String RequestName =	GetTextFromTheElement(Request);

					Wait(2000);

					String FilteredValue = ReadFrom.Excel(Filter, 0, ReadFrom.FilterCraneRequest);


					if(	IsEqual(EquipmentName, FilteredValue)) {

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
				JsClick("FilterIcon", CraneRequestLocators);
				ExtentCucumberAdapter.addTestStepLog("Filter icon button is clicked");
				Print("Filter icon button is clicked");

				Wait(3000);
				JsClick("FilterReset" , CraneRequestLocators);
				ExtentCucumberAdapter.addTestStepLog("Filter reset button is clicked");
				Print("Filter reset button is clicked");

				Wait(3000);
				//	Clear("SearchDfow", DFOWLocators);

			}
		}
		catch (Exception e) {
			PrintError(e.getMessage());
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());
		}
	}

	public static void SearchCraneRequest() throws Throwable {


		ReadFrom.DynamicExcel(ReadFrom.SearchCraneRequest);

		try {

			Click("SearchIcon", CraneRequestLocators);

			for(int Search =1; Search<=ReadFrom.rowcount; Search++)	{

				Wait(2000);

				TypeDataInTheField("Search", CraneRequestLocators, ReadFrom.Excel(Search, 0, ReadFrom.SearchCraneRequest));
				ExtentCucumberAdapter.addTestStepLog(ReadFrom.Excel(Search, 0, ReadFrom.SearchCraneRequest) + " is entered in the search bar");
				Print(ReadFrom.Excel(Search, 0, ReadFrom.SearchCraneRequest) + " is entered in the search bar");

				Wait(5000);


				int rowcount = 	SizeOfTheList("CraneRequestLists", CraneRequestLocators);
				Print("No of request names displayed : " + rowcount);

				for(int Searchedrequest =1; Searchedrequest<=rowcount; Searchedrequest++)	{

					WebElement Request =	FindElement("CraneRequestList", CraneRequestLocators, Searchedrequest);
					String Requestname =	GetTextFromTheElement(Request);

					Wait(2000);

					String SearchedValue = ReadFrom.Excel(Search, 0, ReadFrom.SearchCraneRequest);



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
				Clear("Search", CraneRequestLocators);
				Wait(3000);
				Click("CloseSearch", CraneRequestLocators);
				ExtentCucumberAdapter.addTestStepLog("Clear search button is clicked");
				Print("Clear search button is clicked");


			}
		}
		catch (Exception e) {
			PrintError(e.getMessage());
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());
		}
	}

	public static void CranePushToVoid() throws Throwable {

		PrintError("Push delivery started");
		ReadFrom.DynamicExcel(ReadFrom.VoidCraneRequest);
		try {

			for(int VoidCraneRequest =1; VoidCraneRequest<=ReadFrom.rowcount; VoidCraneRequest++)	{

				int rowcount = 	SizeOfTheList("CraneRequestLists", CraneRequestLocators);
				Print("No of elements : " + rowcount);

				for(int DeliveryLists =1; DeliveryLists<=rowcount; DeliveryLists++)		{

					WebElement Delivery =	FindElement("CraneRequestList", CraneRequestLocators, DeliveryLists);

					String DeliveryName = 	GetTextFromTheElement(Delivery);

					String EditIt =	ReadFrom.Excel(VoidCraneRequest, 0, ReadFrom.VoidCraneRequest);


					if(IsEqual(DeliveryName, EditIt)) {

						JsClick(Delivery);
						ExtentCucumberAdapter.addTestStepLog(DeliveryName + " : is clicked");
						Print(DeliveryName + " : is clicked");

						Wait<WebDriver> CompanyInFilter = new FluentWait<WebDriver>(driver)
								.withTimeout(Duration.ofSeconds(120))
								.pollingEvery(Duration.ofSeconds(10))
								.ignoring(NoSuchElementException.class);


						CompanyInFilter.until(new Function<WebDriver, WebElement>() {
							public WebElement apply(WebDriver driver) {
								return driver.findElement(By.xpath("//button[normalize-space()='Void']"));
							}
						});

						JsClick("VoidButton", CraneRequestLocators);
						ExtentCucumberAdapter.addTestStepLog("Void button is clicked");
						Print("Void button is clicked");

						Wait(2000);
						Click("VoidYes", CraneRequestLocators);
						ExtentCucumberAdapter.addTestStepLog("Yes button is clicked");
						Print("Yes button is clicked");

						Wait<WebDriver> fluentWait1111 = new FluentWait<WebDriver>(driver)
								.withTimeout(Duration.ofSeconds(120))
								.pollingEvery(Duration.ofSeconds(5))
								.ignoring(NoSuchElementException.class);


						fluentWait1111.until(new Function<WebDriver, WebElement>() {
							public WebElement apply(WebDriver driver) {
								return driver.findElement(By.xpath("//div[@aria-label='Crane Request Marked as Void Successfully.']"));
							}
						});

						if(IsElementDisplayed("CraneVoidSuccessfull", CraneRequestLocators)) {
							Click("CraneVoidSuccessfull", CraneRequestLocators);
							Print(DeliveryName + " : is pushed to void");
							ExtentCucumberAdapter.addTestStepLog(DeliveryName + " : is pushed to void");

							Wait(3000);



						}
						else {
							PrintError("Void push is failed");
							ExtentCucumberAdapter.addTestStepLog("Void push is failed");
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

	public static void CompleteRequest() throws Throwable {

		PrintError("Completed started");
		ReadFrom.DynamicExcel(ReadFrom.CompleteCrane);
		try {

			for(int CompleteCrane =1; CompleteCrane<=ReadFrom.rowcount; CompleteCrane++)	{

				int rowcount = 	SizeOfTheList("CraneRequestLists", CraneRequestLocators);
				Print("No of elements : " + rowcount);

				for(int DeliveryLists =1; DeliveryLists<=rowcount; DeliveryLists++)		{

					WebElement Delivery =	FindElement("CraneRequestList", CraneRequestLocators, DeliveryLists);
					String DeliveryName = 	GetTextFromTheElement(Delivery);
					String EditIt =	ReadFrom.Excel(CompleteCrane, 0, ReadFrom.CompleteCrane);
					if(IsEqual(DeliveryName, EditIt)) {
						Print(EditIt);
						Print(DeliveryName);
						JsClick(Delivery);
						ExtentCucumberAdapter.addTestStepLog(DeliveryName + " : is clicked");
						Print(DeliveryName + " : is clicked");

						Wait<WebDriver> CompanyInFilter = new FluentWait<WebDriver>(driver)
								.withTimeout(Duration.ofSeconds(120))
								.pollingEvery(Duration.ofSeconds(10))
								.ignoring(NoSuchElementException.class);
						CompanyInFilter.until(new Function<WebDriver, WebElement>() {
							public WebElement apply(WebDriver driver) {
								return driver.findElement(By.xpath("//label[normalize-space()='Completed']"));
							}
						});

						JsClick("CompletedButton", CraneRequestLocators);
						ExtentCucumberAdapter.addTestStepLog("Completed button is clicked");
						Print("Completed button is clicked");
						Wait(2000);

						JsClick("Save", CraneRequestLocators);
						ExtentCucumberAdapter.addTestStepLog("Save button is clicked");
						Print("Save button is clicked");

						Wait(2000);
						Click("CompleteYes", CraneRequestLocators);
						ExtentCucumberAdapter.addTestStepLog("Yes button is clicked");
						Print("Yes button is clicked");
						break;
					}


					//
					Wait<WebDriver> CompletedSuccessfully = new FluentWait<WebDriver>(driver)
							.withTimeout(Duration.ofSeconds(120))
							.pollingEvery(Duration.ofSeconds(10))
							.ignoring(NoSuchElementException.class);
					CompletedSuccessfully.until(new Function<WebDriver, WebElement>() {
						public WebElement apply(WebDriver driver) {
							return driver.findElement(By.xpath("//div[@aria-label='Completed Successfully.']"));
						}
					});
					if(IsElementDisplayed("CompletedSuccessfully", CraneRequestLocators)) {
						//Click("CompletedSuccessfully", CraneRequestLocators);
						Print(DeliveryName + " : is marked completed");
						ExtentCucumberAdapter.addTestStepLog(DeliveryName + " : is marked completed");

						Wait(3000);
						Click("ClosePopup", CraneRequestLocators);
						ExtentCucumberAdapter.addTestStepLog("Close button is clicked");
						Print("Close button is clicked");
					}
					else {
						PrintError("Complete is failed");
						ExtentCucumberAdapter.addTestStepLog("Complete is failed");
					}

				}
			}
		}
		catch (Exception e) {
			PrintError(e.getMessage());
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());
		}

	}

	
	
	public static void CraneApproveReject() throws Throwable {

		PrintError("Approve Or Reject started");
		ReadFrom.DynamicExcel(ReadFrom.CraneApproveReject);
		try {

			for(int CraneApproveReject =1; CraneApproveReject<=ReadFrom.rowcount; CraneApproveReject++)	{
				
				int rowcount = 	SizeOfTheList("CraneRequestLists", CraneRequestLocators);
				Print("No of elements : " + rowcount);
				
				for(int Request =1; Request<=rowcount; Request++)	{
					WebElement CraneReq =	FindElement("CraneRequestList", CraneRequestLocators, Request);
					String CraneReqName = 	GetTextFromTheElement(CraneReq);
					Print(CraneReqName);
					String FromExcel = ReadFrom.Excel(1, 0, ReadFrom.CraneApproveReject);
					Print(FromExcel);
					if(IsEqual(CraneReqName, FromExcel)) {
						
						WebElement EditButton =	FindElement("EditCraneRequest", CraneRequestLocators, Request);

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

						if(IsElementDisplayed("Description", CraneRequestLocators)) {
							Print("Delivery popup is opened");
							ExtentCucumberAdapter.addTestStepLog("Delivery popup is opened");
						}

						Clear("Description", CraneRequestLocators);
						TypeDataInTheField("Description", CraneRequestLocators, ReadFrom.Excel(CraneApproveReject, 0, ReadFrom.CraneApproveReject));
						Print("Description is entered as : " + ReadFrom.Excel(CraneApproveReject, 0, ReadFrom.CraneApproveReject));
						ExtentCucumberAdapter.addTestStepLog("Description is entered as : " + ReadFrom.Excel(CraneApproveReject, 0, ReadFrom.CraneApproveReject));
					
					}
					
				}
	
			}
		}
		catch (Exception e) {
			PrintError(e.getMessage());
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());
		}


	}
	
	public static void Comment() throws Throwable {
		
		
		
	}
	
	
	}


