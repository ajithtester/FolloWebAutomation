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

public class F_13_CraneCalender extends Baseclass {



	public static void AddCraneCalender() throws Throwable {

		ReadFrom.DynamicExcel(ReadFrom.CraneCalendar);

		try {
			for(int CraneCalendar =1; CraneCalendar<=ReadFrom.rowcount; CraneCalendar++)		{	

				Wait(4000);
				PrintError("Add Crane Calendar Started");
				Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
						.withTimeout(Duration.ofSeconds(120))
						.pollingEvery(Duration.ofSeconds(5))
						.ignoring(ElementClickInterceptedException.class);


				fluentWait.until(new Function<WebDriver, WebElement>() {
					public WebElement apply(WebDriver driver) {
						return driver.findElement(By.xpath("(//button[@type='button'])[1]"));
					}
				});

				if(IsElementDisplayed("CreateNew", CraneCalenderLocators)){
					JsClick("CreateNew", CraneCalenderLocators);
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

				if(IsElementDisplayed("Description", CraneCalenderLocators)) {
					Print("Delivery popup is opened");
					ExtentCucumberAdapter.addTestStepLog("Delivery popup is opened");
				}

				TypeDataInTheField("Description", CraneCalenderLocators, ReadFrom.Excel(CraneCalendar, 0, ReadFrom.CraneCalendar));
				Print("Description is entered as : " + ReadFrom.Excel(CraneCalendar, 0, ReadFrom.CraneCalendar));
				ExtentCucumberAdapter.addTestStepLog("Description is entered as : " + ReadFrom.Excel(CraneCalendar, 0, ReadFrom.CraneCalendar));


				Click("Company", CraneCalenderLocators);
				ExtentCucumberAdapter.addTestStepLog("Company dropdown is clicked");

				String CompanyInExcel = ReadFrom.Excel(CraneCalendar, 1, ReadFrom.CraneCalendar);
				Print(CompanyInExcel);

				int countofthelist = 	SizeOfTheList("CompanyAdd", CraneCalenderLocators);
				Print("No of elements : " + countofthelist);

				for(int DropdownValues =1; DropdownValues<=countofthelist; DropdownValues++)		{	

					WebElement Company = 	FindElement("CompanyAddList", CraneCalenderLocators, DropdownValues);
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

				Click("Dfow", CraneCalenderLocators);
				ExtentCucumberAdapter.addTestStepLog("Dfow dropdown is clicked");

				String DfowInExcel = ReadFrom.Excel(CraneCalendar, 2,ReadFrom.CraneCalendar);
				Print(DfowInExcel);

				int rowcountofthelist = 	SizeOfTheList("DfowAdd", CraneCalenderLocators);
				Print("No of elements : " + rowcountofthelist);

				for(int DropdownValues =1; DropdownValues<=rowcountofthelist; DropdownValues++)		{	
					WebElement Dfow = 	FindElement("DfowAddList", CraneCalenderLocators, DropdownValues);
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

				SelectFromVisibleText("EquipmentDropdown", CraneCalenderLocators, ReadFrom.Excel(CraneCalendar, 10, ReadFrom.CraneCalendar));
				Print("Equipment dropdown is selected as : " + ReadFrom.Excel(CraneCalendar, 10, ReadFrom.CraneCalendar));
				ExtentCucumberAdapter.addTestStepLog("Equipment dropdown is selected as : " + ReadFrom.Excel(CraneCalendar, 10, ReadFrom.CraneCalendar));


				Clear("DeliveryDate", CraneCalenderLocators);
				TypeDataInTheField("DeliveryDate", CraneCalenderLocators, ReadFrom.Excel(CraneCalendar, 3, ReadFrom.CraneCalendar));
				Print("Start date is entered as : " + ReadFrom.Excel(CraneCalendar, 3, ReadFrom.CraneCalendar));
				ExtentCucumberAdapter.addTestStepLog("Start date is entered as : " + ReadFrom.Excel(CraneCalendar, 3, ReadFrom.CraneCalendar));

				///////

				Wait(2000);
				Clear("FromHrs", CraneCalenderLocators);
				TypeDataInTheField("FromHrs", CraneCalenderLocators, ReadFrom.Excel(CraneCalendar, 4, ReadFrom.CraneCalendar));
				Print("From hrs is entered as : " + ReadFrom.Excel(CraneCalendar, 4, ReadFrom.CraneCalendar));
				ExtentCucumberAdapter.addTestStepLog("From hrs is entered as : " + ReadFrom.Excel(CraneCalendar, 4, ReadFrom.CraneCalendar));

				Wait(2000);
				Clear("FromMin", CraneCalenderLocators);
				TypeDataInTheField("FromMin", CraneCalenderLocators, ReadFrom.Excel(CraneCalendar, 5, ReadFrom.CraneCalendar));
				Print("From min is entered as : " + ReadFrom.Excel(CraneCalendar, 5, ReadFrom.CraneCalendar));
				ExtentCucumberAdapter.addTestStepLog("From min is entered as : " + ReadFrom.Excel(CraneCalendar, 5, ReadFrom.CraneCalendar));

				Wait(2000);
				String ExcelMeridian = ReadFrom.Excel(CraneCalendar, 6, ReadFrom.CraneCalendar);
				Print("eXCEL" + ExcelMeridian);
				String Meridian = GetText("FromMeridian", CraneCalenderLocators);
				Print("WEB" + Meridian);
				if(IsEqual(Meridian, ExcelMeridian)) {


				}
				else {
					Click("FromMeridian", CraneCalenderLocators);
				}

				Wait(2000);
				Clear("ToHrs", CraneCalenderLocators);
				TypeDataInTheField("ToHrs", CraneCalenderLocators, ReadFrom.Excel(CraneCalendar, 7, ReadFrom.CraneCalendar));
				Print("To hrs is entered as : " + ReadFrom.Excel(CraneCalendar, 7, ReadFrom.CraneCalendar));
				ExtentCucumberAdapter.addTestStepLog("To hrs is entered as : " + ReadFrom.Excel(CraneCalendar, 7, ReadFrom.CraneCalendar));

				Wait(2000);
				Clear("ToMin", CraneCalenderLocators);
				TypeDataInTheField("ToMin", CraneCalenderLocators, ReadFrom.Excel(CraneCalendar, 8, ReadFrom.CraneCalendar));
				Print("To min is entered as : " + ReadFrom.Excel(CraneCalendar, 8, ReadFrom.CraneCalendar));
				ExtentCucumberAdapter.addTestStepLog("To min is entered as : " + ReadFrom.Excel(CraneCalendar, 8, ReadFrom.CraneCalendar));

				Wait(2000);
				String ExcelMeridian1 = ReadFrom.Excel(CraneCalendar, 9, ReadFrom.CraneCalendar);
				String Meridian1 = GetText("ToMeridian", CraneCalenderLocators);
				if(IsEqual(Meridian1, ExcelMeridian1)) {


				}
				else {
					Click("ToMeridian", CraneCalenderLocators);
					Print("selected2");
				}


				Wait(2000);
				Clear("PickingFrom", CraneCalenderLocators);
				TypeDataInTheField("PickingFrom", CraneCalenderLocators, ReadFrom.Excel(CraneCalendar, 11, ReadFrom.CraneCalendar));
				Print("Picking from is entered as : " + ReadFrom.Excel(CraneCalendar, 11, ReadFrom.CraneCalendar));
				ExtentCucumberAdapter.addTestStepLog("Picking from is entered as : " + ReadFrom.Excel(CraneCalendar, 11, ReadFrom.CraneCalendar));

				Wait(2000);
				Clear("PickingTo", CraneCalenderLocators);
				TypeDataInTheField("PickingTo", CraneCalenderLocators, ReadFrom.Excel(CraneCalendar, 12, ReadFrom.CraneCalendar));
				Print("Picking to is entered as : " + ReadFrom.Excel(CraneCalendar, 12, ReadFrom.CraneCalendar));
				ExtentCucumberAdapter.addTestStepLog("Picking to is entered as : " + ReadFrom.Excel(CraneCalendar, 12, ReadFrom.CraneCalendar));

				Wait(2000);
				MoveToElement("AdditionalText", CraneCalenderLocators);
				Clear("AdditionalText", CraneCalenderLocators);
				TypeDataInTheField("AdditionalText", CraneCalenderLocators, ReadFrom.Excel(CraneCalendar, 13, ReadFrom.CraneCalendar));
				Print("Additional text is entered as : " + ReadFrom.Excel(CraneCalendar, 13, ReadFrom.CraneCalendar));
				ExtentCucumberAdapter.addTestStepLog("Additional text is entered as : " + ReadFrom.Excel(CraneCalendar, 13, ReadFrom.CraneCalendar));

				Wait(4000);	

				MoveToElement("SubmitButton", CraneCalenderLocators);

				Click("SubmitButton", CraneCalenderLocators);

				Wait<WebDriver> fluentWait11 = new FluentWait<WebDriver>(driver)
						.withTimeout(Duration.ofSeconds(120))
						.pollingEvery(Duration.ofSeconds(5))
						.ignoring(NoSuchElementException.class);


				fluentWait11.until(new Function<WebDriver, WebElement>() {
					public WebElement apply(WebDriver driver) {
						return driver.findElement(By.xpath("//div[@aria-label='Crane Request Created Successfully.']"));
					}
				});

				if(IsElementDisplayed("DeliveryAdded", CraneCalenderLocators)) {
					Click("DeliveryAdded", CraneCalenderLocators);
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


	public static void SearchMonth(int Row , String Excel) throws Throwable {

		Wait(6000);
		String Date = "False";
		while(Date=="False") {
			WebElement CalendarYear = getElement("CalendarYear", CraneCalenderLocators);	
			explicitwaitclickable(CalendarYear);
			String CalendarMonth =  GetText("CalendarYear", CraneCalenderLocators);		
			String	MonthValue = CalendarMonth.split(" ")[0];

			String Month = ReadFrom.Excel(Row, 0, Excel);

			if(IsEqual(MonthValue, Month) ) {
				Print("Month selected is : " + MonthValue);
				ExtentCucumberAdapter.addTestStepLog("Month selected is : " + MonthValue);

				Date = "True"; 

			}
			else {
				Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
						.withTimeout(Duration.ofSeconds(120))
						.pollingEvery(Duration.ofSeconds(5))
						.ignoring(ElementClickInterceptedException.class);


				fluentWait.until(new Function<WebDriver, WebElement>() {
					public WebElement apply(WebDriver driver) {
						return driver.findElement(By.xpath("//div[1]/div[2]/div/button[3]/span"));
					}
				});
				JsClick("NextMonthCalendar", CraneCalenderLocators);

				//	Print("Next month button is Clicked");
				//	ExtentCucumberAdapter.addTestStepLog("Next month button is Clicked");

				Wait<WebDriver> fluentWait1 = new FluentWait<WebDriver>(driver)
						.withTimeout(Duration.ofSeconds(120))
						.pollingEvery(Duration.ofSeconds(5))
						.ignoring(ElementClickInterceptedException.class);


				fluentWait1.until(new Function<WebDriver, WebElement>() {
					public WebElement apply(WebDriver driver) {
						return driver.findElement(By.xpath("//div[1]/div[2]/div/button[3]/span"));
					}
				});
			}
		}
	} 



	public static void SearchYear(int Row , String Excel) throws Throwable {

		Wait(6000);


		String Date = "False";
		while(Date=="False") {

			String CalendarYear =  GetText("CalendarYear", CraneCalenderLocators);		

			String	YearValue = CalendarYear.split(" ", 2)[1];
			String Year = ReadFrom.Excel(Row, 1, Excel);

			int i=Integer.parseInt(YearValue);  
			int k=Integer.parseInt(Year);  

			if(IsEqual(Year, YearValue) ) {
				Print("Year selected is : " + YearValue);
				ExtentCucumberAdapter.addTestStepLog("Year selected is : " + YearValue);
				Date = "True"; 
			}

			else if(i>k) {
				Wait(3000);
				Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
						.withTimeout(Duration.ofSeconds(120))
						.pollingEvery(Duration.ofSeconds(5))
						.ignoring(ElementClickInterceptedException.class);


				fluentWait.until(new Function<WebDriver, WebElement>() {
					public WebElement apply(WebDriver driver) {
						return driver.findElement(By.xpath("//span[@class='fc-icon fc-icon-chevrons-left']"));
					}
				});

				JsClick("PreviousYearCalendar", CraneCalenderLocators);

				Print("Previous year button is Clicked");
				ExtentCucumberAdapter.addTestStepLog("Previous year button is Clicked");

				Wait<WebDriver> fluentWait1 = new FluentWait<WebDriver>(driver)
						.withTimeout(Duration.ofSeconds(120))
						.pollingEvery(Duration.ofSeconds(5))
						.ignoring(ElementClickInterceptedException.class);


				fluentWait1.until(new Function<WebDriver, WebElement>() {
					public WebElement apply(WebDriver driver) {
						return driver.findElement(By.xpath("//*[@id=\"calendar\"]/div[1]/div[2]/div/h2"));
					}
				});

			}
			else {
				Wait(3000);
				Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
						.withTimeout(Duration.ofSeconds(120))
						.pollingEvery(Duration.ofSeconds(5))
						.ignoring(ElementClickInterceptedException.class);


				fluentWait.until(new Function<WebDriver, WebElement>() {
					public WebElement apply(WebDriver driver) {
						return driver.findElement(By.xpath("//span[@class='fc-icon fc-icon-chevrons-right']"));
					}
				});
				//Waitfortheelement("NextYearCalendar", CraneCalenderLocators);
				JsClick("NextYearCalendar", CraneCalenderLocators);

				//Print("Next year button is Clicked");
				//ExtentCucumberAdapter.addTestStepLog("Next year button is Clicked");

				Wait<WebDriver> fluentWait1 = new FluentWait<WebDriver>(driver)
						.withTimeout(Duration.ofSeconds(120))
						.pollingEvery(Duration.ofSeconds(5))
						.ignoring(ElementClickInterceptedException.class);


				fluentWait1.until(new Function<WebDriver, WebElement>() {
					public WebElement apply(WebDriver driver) {
						return driver.findElement(By.xpath("//*[@id=\"calendar\"]/div[1]/div[2]/div/h2"));
					}
				});
			}
		}


	}


	public static void ViewCraneRequestInfo() throws Throwable {

		PrintError("View Crane Request Info started");

		ReadFrom.DynamicExcel(ReadFrom.ViewCraneCalendar);
		try {

			for(int ViewCraneCalendar =1; ViewCraneCalendar<=ReadFrom.rowcount; ViewCraneCalendar++)	{


				SearchMonth(ViewCraneCalendar, ReadFrom.ViewCraneCalendar);
				SearchYear(ViewCraneCalendar, ReadFrom.ViewCraneCalendar);

				Wait<WebDriver> fluentWait11 = new FluentWait<WebDriver>(driver)
						.withTimeout(Duration.ofSeconds(120))
						.pollingEvery(Duration.ofSeconds(10))
						.ignoring(NoSuchElementException.class);


				fluentWait11.until(new Function<WebDriver, WebElement>() {
					public WebElement apply(WebDriver driver) {
						return driver.findElement(By.xpath("(//td/div/div[2]/div/a/div[3]/div/p)"));
					}
				});

				int rowcount = 	SizeOfTheList("DeliveryRequestLists", CraneCalenderLocators);
				Print("No of elements : " + rowcount);

				for(int DeliveryLists =1; DeliveryLists<=rowcount; DeliveryLists++)		{

					Wait<WebDriver> fluentWait111 = new FluentWait<WebDriver>(driver)
							.withTimeout(Duration.ofSeconds(120))
							.pollingEvery(Duration.ofSeconds(10))
							.ignoring(NoSuchElementException.class);


					fluentWait111.until(new Function<WebDriver, WebElement>() {
						public WebElement apply(WebDriver driver) {
							return driver.findElement(By.xpath("(//td/div/div[2]/div/a/div[3]/div/p)"));
						}
					});

					WebElement Delivery =	FindElement("DeliveryRequestList", CraneCalenderLocators, DeliveryLists);

					String DeliveryName = 	GetTextFromTheElement(Delivery);

					String ViewInfo =	ReadFrom.Excel(ViewCraneCalendar, 2, ReadFrom.ViewCraneCalendar);


					if(IsEqual(DeliveryName, ViewInfo)) {

						JsClick(Delivery);
						ExtentCucumberAdapter.addTestStepLog(DeliveryName + " : is clicked");
						Print(DeliveryName + " : is clicked");


						Wait<WebDriver> CompanyInFilter = new FluentWait<WebDriver>(driver)
								.withTimeout(Duration.ofSeconds(120))
								.pollingEvery(Duration.ofSeconds(10))
								.ignoring(NoSuchElementException.class);


						CompanyInFilter.until(new Function<WebDriver, WebElement>() {
							public WebElement apply(WebDriver driver) {
								return driver.findElement(By.xpath("//div[3]/div[1]/span/span/em")); 
							}
						});

						JsClick("Expand", CraneCalenderLocators);

						ExtentCucumberAdapter.addTestStepLog("Expand button is clicked");
						Print("Expand button is clicked");

						Wait<WebDriver> fluentWait1 = new FluentWait<WebDriver>(driver)
								.withTimeout(Duration.ofSeconds(120))
								.pollingEvery(Duration.ofSeconds(5))
								.ignoring(NoSuchElementException.class);


						fluentWait1.until(new Function<WebDriver, WebElement>() {
							public WebElement apply(WebDriver driver) {
								return driver.findElement(By.xpath("//h4[normalize-space()='Crane Request Status']"));
							}
						});

						if(IsElementDisplayed("ViewDetails", CraneCalenderLocators)) {
							Print(DeliveryName + " : Delivery info is viewed");
							ExtentCucumberAdapter.addTestStepLog(DeliveryName + " : Delivery info is viewed");

							JsClick("ClosePopup", CraneCalenderLocators);

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


	public static void EditCraneCalendar() throws Throwable {

		PrintError("Edit delivery started");
		ReadFrom.DynamicExcel(ReadFrom.EditCraneCalendar);
		try {

			for(int EditCraneCalendar =1; EditCraneCalendar<=ReadFrom.rowcount; EditCraneCalendar++)	{

				SearchMonth(EditCraneCalendar, ReadFrom.EditCraneCalendar);
				SearchYear(EditCraneCalendar, ReadFrom.EditCraneCalendar);

				Wait<WebDriver> fluentWait11 = new FluentWait<WebDriver>(driver)
						.withTimeout(Duration.ofSeconds(120))
						.pollingEvery(Duration.ofSeconds(10))
						.ignoring(NoSuchElementException.class);


				fluentWait11.until(new Function<WebDriver, WebElement>() {
					public WebElement apply(WebDriver driver) {
						return driver.findElement(By.xpath("(//td/div/div[2]/div/a/div[3]/div/p)"));
					}
				});

				int rowcount = 	SizeOfTheList("DeliveryRequestLists", CraneCalenderLocators);
				Print("No of elements : " + rowcount);

				for(int DeliveryLists =1; DeliveryLists<=rowcount; DeliveryLists++)		{

					Wait<WebDriver> fluentWait111 = new FluentWait<WebDriver>(driver)
							.withTimeout(Duration.ofSeconds(120))
							.pollingEvery(Duration.ofSeconds(10))
							.ignoring(NoSuchElementException.class);


					fluentWait111.until(new Function<WebDriver, WebElement>() {
						public WebElement apply(WebDriver driver) {
							return driver.findElement(By.xpath("(//td/div/div[2]/div/a/div[3]/div/p)"));
						}
					});

					WebElement Delivery =	FindElement("DeliveryRequestList", CraneCalenderLocators, DeliveryLists);

					String DeliveryName = 	GetTextFromTheElement(Delivery);

					String EditIt =	ReadFrom.Excel(EditCraneCalendar, 2, ReadFrom.EditCraneCalendar);


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
								return driver.findElement(By.xpath("//button[normalize-space()='Edit']"));
							}
						});

						JsClick("EditButton", CraneCalenderLocators);
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

						if(IsElementDisplayed("Description", CraneCalenderLocators)) {
							Print("Delivery popup is opened");
							ExtentCucumberAdapter.addTestStepLog("Delivery popup is opened");
						}

						Clear("Description", CraneCalenderLocators);
						TypeDataInTheField("Description", CraneCalenderLocators, ReadFrom.Excel(EditCraneCalendar, 3, ReadFrom.EditCraneCalendar));
						Print("Description is entered as : " + ReadFrom.Excel(EditCraneCalendar, 3, ReadFrom.EditCraneCalendar));
						ExtentCucumberAdapter.addTestStepLog("Description is entered as : " + ReadFrom.Excel(EditCraneCalendar, 3, ReadFrom.EditCraneCalendar));

						Wait(2000);
						Click("CompanyEdit", CraneCalenderLocators);
						Print("company");
						Wait(2000);
						Click("CompanySelectAll", CraneCalenderLocators);
						Wait(2000);
						Click("UnselectAll", CraneCalenderLocators);
						ExtentCucumberAdapter.addTestStepLog("Company dropdown is clicked");

						Wait(3000);
						String CompanyInExcel = ReadFrom.Excel(EditCraneCalendar, 4, ReadFrom.EditCraneCalendar);
						Print(CompanyInExcel);

						int countofthelist = 	SizeOfTheList("CompanyDropdown", CraneCalenderLocators);
						Print("No of elements : " + countofthelist);

						for(int DropdownValues =1; DropdownValues<=countofthelist; DropdownValues++)		{	

							WebElement Company = 	FindElement("CompanyList", CraneCalenderLocators, DropdownValues);
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

						Wait(2000);
						Click("DfowEdit", CraneCalenderLocators);
						Wait(2000);
						Click("DfowSelectAll", CraneCalenderLocators);
						Wait(2000);
						Click("UnselectAll", CraneCalenderLocators);

						Wait(3000);
						String DfowInExcel = ReadFrom.Excel(EditCraneCalendar, 5,ReadFrom.EditCraneCalendar);
						Print(DfowInExcel);

						int rowcountofthelist = 	SizeOfTheList("DfowDropdown", CraneCalenderLocators);
						Print("No of elements : " + rowcountofthelist);

						for(int DropdownValues =1; DropdownValues<=rowcountofthelist; DropdownValues++)		{	
							WebElement Dfow = 	FindElement("DfowList", CraneCalenderLocators, DropdownValues);
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

						SelectFromVisibleText("EquipmentDropdown", CraneCalenderLocators, ReadFrom.Excel(EditCraneCalendar, 13, ReadFrom.EditCraneCalendar));
						Print("Equipment dropdown is selected as : " + ReadFrom.Excel(EditCraneCalendar, 13, ReadFrom.EditCraneCalendar));
						ExtentCucumberAdapter.addTestStepLog("Equipment dropdown is selected as : " + ReadFrom.Excel(EditCraneCalendar, 13, ReadFrom.EditCraneCalendar));


						Clear("DeliveryDate", CraneCalenderLocators);
						TypeDataInTheField("DeliveryDate", CraneCalenderLocators, ReadFrom.Excel(EditCraneCalendar, 6, ReadFrom.EditCraneCalendar));
						Print("Start date is entered as : " + ReadFrom.Excel(EditCraneCalendar, 6, ReadFrom.EditCraneCalendar));
						ExtentCucumberAdapter.addTestStepLog("Start date is entered as : " + ReadFrom.Excel(EditCraneCalendar, 6, ReadFrom.EditCraneCalendar));

						///////

						Wait(2000);
						Clear("FromHrs", CraneCalenderLocators);
						TypeDataInTheField("FromHrs", CraneCalenderLocators, ReadFrom.Excel(EditCraneCalendar, 7, ReadFrom.EditCraneCalendar));
						Print("From hrs is entered as : " + ReadFrom.Excel(EditCraneCalendar, 7, ReadFrom.EditCraneCalendar));
						ExtentCucumberAdapter.addTestStepLog("From hrs is entered as : " + ReadFrom.Excel(EditCraneCalendar, 7, ReadFrom.EditCraneCalendar));

						Wait(2000);
						Clear("FromMin", CraneCalenderLocators);
						TypeDataInTheField("FromMin", CraneCalenderLocators, ReadFrom.Excel(EditCraneCalendar, 8, ReadFrom.EditCraneCalendar));
						Print("From min is entered as : " + ReadFrom.Excel(EditCraneCalendar, 8, ReadFrom.EditCraneCalendar));
						ExtentCucumberAdapter.addTestStepLog("From min is entered as : " + ReadFrom.Excel(EditCraneCalendar, 8, ReadFrom.EditCraneCalendar));

						Wait(2000);
						String ExcelMeridian = ReadFrom.Excel(EditCraneCalendar, 9, ReadFrom.EditCraneCalendar);
						Print("eXCEL" + ExcelMeridian);
						String Meridian = GetText("FromMeridian", CraneCalenderLocators);
						Print("WEB" + Meridian);
						if(IsEqual(Meridian, ExcelMeridian)) {


						}
						else {
							Click("FromMeridian", CraneCalenderLocators);
						}

						Wait(2000);
						Clear("ToHrs", CraneCalenderLocators);
						TypeDataInTheField("ToHrs", CraneCalenderLocators, ReadFrom.Excel(EditCraneCalendar, 10, ReadFrom.EditCraneCalendar));
						Print("To hrs is entered as : " + ReadFrom.Excel(EditCraneCalendar, 10, ReadFrom.EditCraneCalendar));
						ExtentCucumberAdapter.addTestStepLog("To hrs is entered as : " + ReadFrom.Excel(EditCraneCalendar, 10, ReadFrom.EditCraneCalendar));

						Wait(2000);
						Clear("ToMin", CraneCalenderLocators);
						TypeDataInTheField("ToMin", CraneCalenderLocators, ReadFrom.Excel(EditCraneCalendar, 11, ReadFrom.EditCraneCalendar));
						Print("To min is entered as : " + ReadFrom.Excel(EditCraneCalendar, 11, ReadFrom.EditCraneCalendar));
						ExtentCucumberAdapter.addTestStepLog("To min is entered as : " + ReadFrom.Excel(EditCraneCalendar, 11, ReadFrom.EditCraneCalendar));

						Wait(2000);
						String ExcelMeridian1 = ReadFrom.Excel(EditCraneCalendar, 12, ReadFrom.EditCraneCalendar);
						String Meridian1 = GetText("ToMeridian", CraneCalenderLocators);
						if(IsEqual(Meridian1, ExcelMeridian1)) {


						}
						else {
							Click("ToMeridian", CraneCalenderLocators);
							Print("selected2");
						}


						Wait(2000);

						TypeDataInTheField("PickingFrom", CraneCalenderLocators, ReadFrom.Excel(EditCraneCalendar, 14, ReadFrom.EditCraneCalendar));
						Print("Picking from is entered as : " + ReadFrom.Excel(EditCraneCalendar, 14, ReadFrom.EditCraneCalendar));
						ExtentCucumberAdapter.addTestStepLog("Picking from is entered as : " + ReadFrom.Excel(EditCraneCalendar, 14, ReadFrom.EditCraneCalendar));

						Wait(2000);
						TypeDataInTheField("PickingTo", CraneCalenderLocators, ReadFrom.Excel(EditCraneCalendar, 15, ReadFrom.EditCraneCalendar));
						Print("Picking to is entered as : " + ReadFrom.Excel(EditCraneCalendar, 15, ReadFrom.EditCraneCalendar));
						ExtentCucumberAdapter.addTestStepLog("Picking to is entered as : " + ReadFrom.Excel(EditCraneCalendar, 15, ReadFrom.EditCraneCalendar));

						Wait(2000);
						MoveToElement("AdditionalText", CraneCalenderLocators);
						TypeDataInTheField("AdditionalText", CraneCalenderLocators, ReadFrom.Excel(EditCraneCalendar, 16, ReadFrom.EditCraneCalendar));
						Print("Additional text is entered as : " + ReadFrom.Excel(EditCraneCalendar, 16, ReadFrom.EditCraneCalendar));
						ExtentCucumberAdapter.addTestStepLog("Additional text is entered as : " + ReadFrom.Excel(EditCraneCalendar, 16, ReadFrom.EditCraneCalendar));

						Wait(4000);	

						MoveToElement("SubmitButton", CraneCalenderLocators);

						Click("SubmitButton", CraneCalenderLocators);

						Wait<WebDriver> CraneRequestCreated = new FluentWait<WebDriver>(driver)
								.withTimeout(Duration.ofSeconds(120))
								.pollingEvery(Duration.ofSeconds(5))
								.ignoring(NoSuchElementException.class);


						CraneRequestCreated.until(new Function<WebDriver, WebElement>() {
							public WebElement apply(WebDriver driver) {
								return driver.findElement(By.xpath("//div[@aria-label='Crane Request Updated Successfully.']"));
							}
						});

						if(IsElementDisplayed("CraneRequestUpdated", CraneCalenderLocators)) {
							Click("CraneRequestUpdated", CraneCalenderLocators);
							Print("Crane request updated");
						}
						else {
							PrintError("Crane request not updated");
						}
						Wait(3000);
					}
				}}
		}
		catch (Exception e) {
			PrintError(e.getMessage());
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());
		}
	}
	public static void FilterCraneCalendar() throws Throwable {

		PrintError("Filter delivery started");
		ReadFrom.DynamicExcel(ReadFrom.FilterCraneCalendar);

		try {

			for(int FilterCraneCalendar =1; FilterCraneCalendar<=ReadFrom.rowcount; FilterCraneCalendar++)	{

				SearchMonth(FilterCraneCalendar, ReadFrom.FilterCraneCalendar);
				SearchYear(FilterCraneCalendar, ReadFrom.FilterCraneCalendar);


				Wait(4000);
				try {

					JsClick("FilterIcon", CraneCalenderLocators);
					ExtentCucumberAdapter.addTestStepLog("Filter icon is clicked");
					Print("Filter icon is clicked");


					Wait<WebDriver> CompanyInFilter = new FluentWait<WebDriver>(driver)
							.withTimeout(Duration.ofSeconds(120))
							.pollingEvery(Duration.ofSeconds(10))
							.ignoring(NoSuchElementException.class);


					CompanyInFilter.until(new Function<WebDriver, WebElement>() {
						public WebElement apply(WebDriver driver) {
							return driver.findElement(By.xpath("(//select[@id='equipmentFilter1'])[1]"));
						}
					});
					Wait(7000);

					SelectFromVisibleText("EquipmentInFilter", CraneCalenderLocators, ReadFrom.Excel(FilterCraneCalendar, 2, ReadFrom.FilterCraneCalendar));

					ExtentCucumberAdapter.addTestStepLog(ReadFrom.Excel(FilterCraneCalendar, 2, ReadFrom.FilterCraneCalendar) + " is selected from the dropdown");
					Print(ReadFrom.Excel(FilterCraneCalendar, 2, ReadFrom.FilterCraneCalendar) + " is selected from the dropdown");

					Wait(2000);

					JsClick("ApplyButton", CraneCalenderLocators);
					ExtentCucumberAdapter.addTestStepLog("Apply button is clicked");
					Print("Apply button is clicked");

				}
				catch (Exception e) {
					Print(e.getMessage());
				}


				Wait(2000);
				JsClick("FilterIcon", CraneCalenderLocators);
				Wait(2000);
				JsClick("ResetButton", CraneCalenderLocators);
				ExtentCucumberAdapter.addTestStepLog("Reset button is clicked");
				Print("Reset button is clicked");


			}
		}
		catch (Exception e) {
			PrintError(e.getMessage());
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());
		}
	}

}
