package com.follo.module.method;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.follo.baseclass.Baseclass;
import com.follo.excel.read.ReadFrom;

public class F_08_DeliveryCalendar extends Baseclass {




	public static void Adddelivery() throws Throwable {
		PrintError("Add delivery Started");

		ReadFrom.DynamicExcel(ReadFrom.AddDelivery);

		try {
			for(int AddDelivery =1; AddDelivery<=ReadFrom.rowcount; AddDelivery++)		{	

				Wait(4000);
				Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
						.withTimeout(Duration.ofSeconds(120))
						.pollingEvery(Duration.ofSeconds(5))
						.ignoring(ElementClickInterceptedException.class);


				fluentWait.until(new Function<WebDriver, WebElement>() {
					public WebElement apply(WebDriver driver) {
						return driver.findElement(By.xpath("(//button[@type='button'])[1]"));
					}
				});

				if(IsElementDisplayed("Add", DeliveryCalendarLocators)){
					JsClick("Add", DeliveryCalendarLocators);
					Print("Add button is clicked");
					ExtentCucumberAdapter.addTestStepLog("Add button is clicked");

				}
				else
				{
					PrintError("Add button is not clicked");
					ExtentCucumberAdapter.addTestStepLog("Add button is not clicked");
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

				if(IsElementDisplayed("Description", DeliveryCalendarLocators)) {
					Print("Delivery popup is opened");
					ExtentCucumberAdapter.addTestStepLog("Delivery popup is opened");
				}

				TypeDataInTheField("Description", DeliveryCalendarLocators, ReadFrom.Excel(AddDelivery, 0, ReadFrom.AddDelivery));
				Print("Description is entered as : " + ReadFrom.Excel(AddDelivery, 0, ReadFrom.AddDelivery));
				ExtentCucumberAdapter.addTestStepLog("Description is entered as : " + ReadFrom.Excel(AddDelivery, 0, ReadFrom.AddDelivery));

				SelectFromVisibleText("GateDropdown", DeliveryCalendarLocators, ReadFrom.Excel(AddDelivery, 1, ReadFrom.AddDelivery));
				Print("Gate dropdown is selected as : " + ReadFrom.Excel(AddDelivery, 1, ReadFrom.AddDelivery));
				ExtentCucumberAdapter.addTestStepLog("Gate dropdown is selected as : " + ReadFrom.Excel(AddDelivery, 1, ReadFrom.AddDelivery));



				SelectFromVisibleText("EquipmentDropdown", DeliveryCalendarLocators, ReadFrom.Excel(AddDelivery, 2, ReadFrom.AddDelivery));
				Print("Equipment dropdown is selected as : " + ReadFrom.Excel(AddDelivery, 2, ReadFrom.AddDelivery));
				ExtentCucumberAdapter.addTestStepLog("Equipment dropdown is selected as : " + ReadFrom.Excel(AddDelivery, 2, ReadFrom.AddDelivery));

				Wait(2000);
				try {
					if(IsElementDisplayed("PickingFrom", DeliveryCalendarLocators)) {

						TypeDataInTheField("PickingFrom", DeliveryCalendarLocators, ReadFrom.Excel(AddDelivery, 16, ReadFrom.AddDelivery));
						Print("Picking from is entered as : " + ReadFrom.Excel(AddDelivery, 16, ReadFrom.AddDelivery));
						ExtentCucumberAdapter.addTestStepLog("Picking from is entered as : " + ReadFrom.Excel(AddDelivery, 16, ReadFrom.AddDelivery));

						Wait(2000);
						TypeDataInTheField("PickingTo", DeliveryCalendarLocators, ReadFrom.Excel(AddDelivery, 17, ReadFrom.AddDelivery));
						Print("Picking to is entered as : " + ReadFrom.Excel(AddDelivery, 17, ReadFrom.AddDelivery));
						ExtentCucumberAdapter.addTestStepLog("Picking to is entered as : " + ReadFrom.Excel(AddDelivery, 17, ReadFrom.AddDelivery));

					}

				} catch (Exception e) {
					{
						Print("Delivery request equipment is selected");
						ExtentCucumberAdapter.addTestStepLog("Delivery request equipment is selected");

					}
				}

				Wait(2000);
				MoveToElement("AdditionalText", DeliveryCalendarLocators);
				TypeDataInTheField("AdditionalText", DeliveryCalendarLocators, ReadFrom.Excel(AddDelivery, 3, ReadFrom.AddDelivery));
				Print("Additional text is entered as : " + ReadFrom.Excel(AddDelivery, 3, ReadFrom.AddDelivery));
				ExtentCucumberAdapter.addTestStepLog("Additional text is entered as : " + ReadFrom.Excel(AddDelivery, 3, ReadFrom.AddDelivery));

				TypeDataInTheField("VehicleDetails", DeliveryCalendarLocators, ReadFrom.Excel(AddDelivery, 4, ReadFrom.AddDelivery));
				Print("Vehicle details is entered as : " + ReadFrom.Excel(AddDelivery, 4, ReadFrom.AddDelivery));
				ExtentCucumberAdapter.addTestStepLog("Vehicle details is entered as : " + ReadFrom.Excel(AddDelivery, 4, ReadFrom.AddDelivery));


				Click("DeliveryDate", DeliveryCalendarLocators);

				Wait(2000);
				CalendarMethod(AddDelivery);


				///////////////////////

				Click("Dfow", DeliveryCalendarLocators);
				ExtentCucumberAdapter.addTestStepLog("Dfow dropdown is clicked");

				String DfowInExcel = ReadFrom.Excel(AddDelivery, 8,ReadFrom.AddDelivery);



				int rowcountofthelist = 	SizeOfTheList("DfowList", DeliveryCalendarLocators);
				Print("No of elements : " + rowcountofthelist);

				for(int DropdownValues =1; DropdownValues<=rowcountofthelist; DropdownValues++)		{	
					WebElement Dfow = 	FindElement("DfowInDropdown", DeliveryCalendarLocators, DropdownValues);
					String DfowInDropdown = 	GetTextFromTheElement(Dfow);
					Print(DfowInDropdown);


					if(IsEqual(DfowInDropdown, DfowInExcel)){
						Click(Dfow);

						ExtentCucumberAdapter.addTestStepLog("Dfow is selected as : " + DfowInDropdown );
						Print("Dfow is selected as : " + DfowInDropdown );
						break;
					}
				}	

				/////////////////////////////////////

				Click("Company", DeliveryCalendarLocators);
				ExtentCucumberAdapter.addTestStepLog("Company dropdown is clicked");

				String CompanyInExcel = ReadFrom.Excel(AddDelivery, 9,ReadFrom.AddDelivery);


				int countofthelist = 	SizeOfTheList("CompanyList", DeliveryCalendarLocators);
				Print("No of elements : " + countofthelist);

				for(int DropdownValues =1; DropdownValues<=countofthelist; DropdownValues++)		{	
					WebElement Company = 	FindElement("CompanyInDropdown", DeliveryCalendarLocators, DropdownValues);
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
						ExtentCucumberAdapter.addTestStepLog("Not matched");
					}
				}	

				Wait(2000);
				Clear("FromHrs", DeliveryCalendarLocators);
				TypeDataInTheField("FromHrs", DeliveryCalendarLocators, ReadFrom.Excel(AddDelivery, 10, ReadFrom.AddDelivery));
				Print("From hrs is entered as : " + ReadFrom.Excel(AddDelivery, 10, ReadFrom.AddDelivery));
				ExtentCucumberAdapter.addTestStepLog("From hrs is entered as : " + ReadFrom.Excel(AddDelivery, 10, ReadFrom.AddDelivery));

				Wait(2000);
				Clear("FromMin", DeliveryCalendarLocators);
				TypeDataInTheField("FromMin", DeliveryCalendarLocators, ReadFrom.Excel(AddDelivery, 11, ReadFrom.AddDelivery));
				Print("From min is entered as : " + ReadFrom.Excel(AddDelivery, 11, ReadFrom.AddDelivery));
				ExtentCucumberAdapter.addTestStepLog("From min is entered as : " + ReadFrom.Excel(AddDelivery, 11, ReadFrom.AddDelivery));

				Wait(2000);
				String ExcelMeridian = ReadFrom.Excel(AddDelivery, 12, ReadFrom.AddDelivery);

				String Meridian = GetText("FromMeridian", DeliveryCalendarLocators);

				if(IsEqual(Meridian, ExcelMeridian)) {


				}
				else {
					Click("FromMeridian", DeliveryCalendarLocators);
					Print("selected");
				}

				Wait(2000);
				Clear("ToHrs", DeliveryCalendarLocators);
				TypeDataInTheField("ToHrs", DeliveryCalendarLocators, ReadFrom.Excel(AddDelivery, 13, ReadFrom.AddDelivery));
				Print("To hrs is entered as : " + ReadFrom.Excel(AddDelivery, 13, ReadFrom.AddDelivery));
				ExtentCucumberAdapter.addTestStepLog("To hrs is entered as : " + ReadFrom.Excel(AddDelivery, 13, ReadFrom.AddDelivery));

				Wait(2000);
				Clear("ToMin", DeliveryCalendarLocators);
				TypeDataInTheField("ToMin", DeliveryCalendarLocators, ReadFrom.Excel(AddDelivery, 14, ReadFrom.AddDelivery));
				Print("To min is entered as : " + ReadFrom.Excel(AddDelivery, 14, ReadFrom.AddDelivery));
				ExtentCucumberAdapter.addTestStepLog("To min is entered as : " + ReadFrom.Excel(AddDelivery, 14, ReadFrom.AddDelivery));

				Wait(2000);
				String ExcelMeridian1 = ReadFrom.Excel(AddDelivery, 14, ReadFrom.AddDelivery);
				String Meridian1 = GetText("ToMeridian", DeliveryCalendarLocators);
				if(IsEqual(Meridian1, ExcelMeridian1)) {


				}
				else {
					Click("ToMeridian", DeliveryCalendarLocators);

				}

				MoveToElement("SubmitButton", DeliveryCalendarLocators);

				Click("SubmitButton", DeliveryCalendarLocators);

				Wait<WebDriver> fluentWait11 = new FluentWait<WebDriver>(driver)
						.withTimeout(Duration.ofSeconds(120))
						.pollingEvery(Duration.ofSeconds(5))
						.ignoring(NoSuchElementException.class);


				fluentWait11.until(new Function<WebDriver, WebElement>() {
					public WebElement apply(WebDriver driver) {
						return driver.findElement(By.xpath("//div[@aria-label='Delivery Request Created Successfully.']"));
					}
				});

				if(IsElementDisplayed("DeliveryAdded", DeliveryCalendarLocators)) {
					Click("DeliveryAdded", DeliveryCalendarLocators);
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




	public static void CalendarMethod(int AddDelivery ) throws Throwable {

		Click("Currentyear", DeliveryCalendarLocators);
		Wait(3000);

		String Year = "False";
		while(Year=="False") {
			if(driver.findElements(By.xpath("//span[normalize-space()='"+ ReadFrom.Excel(AddDelivery, 5, ReadFrom.AddDelivery) +"']")).size()>0){
				driver.findElement(By.xpath("//span[normalize-space()='"+ ReadFrom.Excel(AddDelivery, 5, ReadFrom.AddDelivery) +"']")).click();

				ExtentCucumberAdapter.addTestStepLog("Year is selected as : " + ReadFrom.Excel(AddDelivery, 5, ReadFrom.AddDelivery));
				Print("Year is selected as : " + ReadFrom.Excel(AddDelivery, 5, ReadFrom.AddDelivery));

				Year = "True";
			}
			else {

				Click("Nextyear", DeliveryCalendarLocators);
			}
		}

		String Month = "False";
		while(Month=="False") {
			Wait(3000);

			if(driver.findElements(By.xpath("//span[normalize-space()='"+ ReadFrom.Excel(AddDelivery, 6, ReadFrom.AddDelivery) +"']")).size()>0){
				driver.findElement(By.xpath("//span[normalize-space()='"+ ReadFrom.Excel(AddDelivery, 6, ReadFrom.AddDelivery) +"']")).click();

				Print("Month is selected as : " + ReadFrom.Excel(AddDelivery, 6, ReadFrom.AddDelivery));
				ExtentCucumberAdapter.addTestStepLog("Month is selected as : " + ReadFrom.Excel(AddDelivery, 6, ReadFrom.AddDelivery));
				Month = "True";
			}
			else {
				PrintError("Month is not available");
			}
		}

		String Date = "False";
		while(Date=="False") {
			Wait(3000);
			if(driver.findElements(By.xpath("//span[normalize-space()='"+ ReadFrom.Excel(AddDelivery, 7, ReadFrom.AddDelivery) +"']")).size()>0){
				driver.findElement(By.xpath("//span[normalize-space()='"+ ReadFrom.Excel(AddDelivery, 7, ReadFrom.AddDelivery) +"']")).click();

				Print("Date is selected as : " + ReadFrom.Excel(AddDelivery, 7, ReadFrom.AddDelivery));
				ExtentCucumberAdapter.addTestStepLog("Date is selected as : " + ReadFrom.Excel(AddDelivery, 7, ReadFrom.AddDelivery));
				Date = "True";

			}
			else {

				PrintError("Date is not available");
			}
		}
	}

	public static void SearchYear(int Row , String Excel) throws Throwable {

		Wait(6000);


		String Date = "False";
		while(Date=="False") {

			String CalendarYear =  GetText("CalendarYear", DeliveryCalendarLocators);		

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
						return driver.findElement(By.xpath("//*[@id=\"calendar\"]/div[1]/div[2]/div/button[1]/span"));
					}
				});

				JsClick("PreviousYearCalendar", DeliveryCalendarLocators);
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
						return driver.findElement(By.xpath("//*[@id=\"calendar\"]/div[1]/div[2]/div/button[4]/span"));
					}
				});
				//Waitfortheelement("NextYearCalendar", DeliveryCalendarLocators);
				JsClick("NextYearCalendar", DeliveryCalendarLocators);

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

	public static void SearchMonth(int Row , String Excel) throws Throwable {

		Wait(6000);
		String Date = "False";
		while(Date=="False") {
			WebElement CalendarYear = getElement("CalendarYear", DeliveryCalendarLocators);	
			explicitwaitclickable(CalendarYear);
			String CalendarMonth =  GetText("CalendarYear", DeliveryCalendarLocators);		
			String	MonthValue = CalendarMonth.split(" ")[0];

			String Month = ReadFrom.Excel(Row, 0, Excel);

			if(IsEqual(MonthValue, Month) ) {
				Print("Month is selected : " + MonthValue);
				ExtentCucumberAdapter.addTestStepLog("Month is selected : " + MonthValue);

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
				JsClick("NextMonthCalendar", DeliveryCalendarLocators);


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




	public static void SearchDelivery() throws Throwable {

		PrintError("Search delivery started");
		ReadFrom.DynamicExcel(ReadFrom.SearchDelivery);

		try {
			Refresh();
			JsClick("SearchIcon", DeliveryCalendarLocators);
			for(int SearchDelivery =1; SearchDelivery<=ReadFrom.rowcount; SearchDelivery++)	{

				SearchMonth(SearchDelivery, ReadFrom.SearchDelivery);
				SearchYear(SearchDelivery, ReadFrom.SearchDelivery);


				Wait<WebDriver> fluentWait1 = new FluentWait<WebDriver>(driver)
						.withTimeout(Duration.ofSeconds(120))
						.pollingEvery(Duration.ofSeconds(10))
						.ignoring(ElementClickInterceptedException.class);


				fluentWait1.until(new Function<WebDriver, WebElement>() {
					public WebElement apply(WebDriver driver) {
						return driver.findElement(By.xpath("//input[@placeholder='What you are looking for?']"));
					}
				});


				Wait(2000);

				try {

					Wait(5000);

					Wait<WebDriver> fluentWait11 = new FluentWait<WebDriver>(driver)
							.withTimeout(Duration.ofSeconds(120))
							.pollingEvery(Duration.ofSeconds(10))
							.ignoring(NoSuchElementException.class);


					fluentWait11.until(new Function<WebDriver, WebElement>() {
						public WebElement apply(WebDriver driver) {
							return driver.findElement(By.xpath("(//td/div/div[2]/div/a/div[3]/div/p)"));
						}
					});

					TypeDataInTheField("Search", DeliveryCalendarLocators, ReadFrom.Excel(SearchDelivery, 2, ReadFrom.SearchDelivery));
					ExtentCucumberAdapter.addTestStepLog(ReadFrom.Excel(SearchDelivery, 2, ReadFrom.SearchDelivery) + " is entered in the search bar");
					Print(ReadFrom.Excel(SearchDelivery, 2, ReadFrom.SearchDelivery) + " is entered in the search bar");

					String delivery = ReadFrom.Excel(SearchDelivery, 2, ReadFrom.SearchDelivery);
					FindElement(delivery);
					int rowcount = 	SizeOfTheList("DeliveryRequestLists", DeliveryCalendarLocators);
					Print("No of Delivery request displayed : " + rowcount);

					List<WebElement> c = 		getElements("DeliveryRequestLists", DeliveryCalendarLocators);
					for (WebElement webElement : c) {
						String DeliveryRequestName = 	GetTextFromTheElement(webElement);

						String Excelvalue = 	ReadFrom.Excel(SearchDelivery, 2, ReadFrom.SearchDelivery);
						if(IsEqual(Excelvalue, DeliveryRequestName)) {
							Print("Displayed value is : " + DeliveryRequestName);
							ExtentCucumberAdapter.addTestStepLog("Displayed value is : " + DeliveryRequestName);
						}
						else
						{
							PrintError("Displayed value is : " + DeliveryRequestName);
							ExtentCucumberAdapter.addTestStepLog("Displayed value is : " + DeliveryRequestName);
						}

					}

				}
				catch (Exception e) {
					Print(e.getMessage());
				}
				Wait(5000);
				Clear("Search", DeliveryCalendarLocators);
				Wait(3000);
				JsClick("CloseSearch", DeliveryCalendarLocators);
				ExtentCucumberAdapter.addTestStepLog("Clear search button is clicked");
				Print("Clear search button is clicked");


			}
		}
		catch (Exception e) {
			PrintError(e.getMessage());
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());
		}
	}

	public static void FilterDelivery() throws Throwable {

		PrintError("Filter delivery started");
		ReadFrom.DynamicExcel(ReadFrom.FilterDelivery);

		try {

			for(int FilterDelivery =1; FilterDelivery<=ReadFrom.rowcount; FilterDelivery++)	{

				SearchMonth(FilterDelivery, ReadFrom.FilterDelivery);
				SearchYear(FilterDelivery, ReadFrom.FilterDelivery);



				Wait<WebDriver> fluentWait1 = new FluentWait<WebDriver>(driver)
						.withTimeout(Duration.ofSeconds(120))
						.pollingEvery(Duration.ofSeconds(10))
						.ignoring(NoSuchElementException.class);


				fluentWait1.until(new Function<WebDriver, WebElement>() {
					public WebElement apply(WebDriver driver) {
						return driver.findElement(By.xpath("(//td/div/div[2]/div/a/div[3]/div/p)"));
					}
				});

				try {

					JsClick("FilterIcon", DeliveryCalendarLocators);
					ExtentCucumberAdapter.addTestStepLog("Filter icon is clicked");
					Print("Filter icon is clicked");


					Wait<WebDriver> CompanyInFilter = new FluentWait<WebDriver>(driver)
							.withTimeout(Duration.ofSeconds(120))
							.pollingEvery(Duration.ofSeconds(10))
							.ignoring(NoSuchElementException.class);


					CompanyInFilter.until(new Function<WebDriver, WebElement>() {
						public WebElement apply(WebDriver driver) {
							return driver.findElement(By.xpath("//select[@formcontrolname='companyFilter']"));
						}
					});
					Wait(7000);

					SelectFromVisibleText("CompanyInFilter", DeliveryCalendarLocators, ReadFrom.Excel(FilterDelivery, 2, ReadFrom.FilterDelivery));

					ExtentCucumberAdapter.addTestStepLog(ReadFrom.Excel(FilterDelivery, 2, ReadFrom.FilterDelivery) + " is selected from the dropdown");
					Print(ReadFrom.Excel(FilterDelivery, 2, ReadFrom.FilterDelivery) + " is selected from the dropdown");

					Wait(2000);

					JsClick("ApplyButton", DeliveryCalendarLocators);
					ExtentCucumberAdapter.addTestStepLog("Apply button is clicked");
					Print("Apply button is clicked");

					Wait<WebDriver> fluentWait111 = new FluentWait<WebDriver>(driver)
							.withTimeout(Duration.ofSeconds(120))
							.pollingEvery(Duration.ofSeconds(10))
							.ignoring(NoSuchElementException.class);


					fluentWait111.until(new Function<WebDriver, WebElement>() {
						public WebElement apply(WebDriver driver) {
							return driver.findElement(By.xpath("(//td/div/div[2]/div/a/div[3]/div/p)"));
						}
					});



					int rowcount = 	SizeOfTheList("DeliveryRequestLists", DeliveryCalendarLocators);
					Print("No of Delivery request displayed : " + rowcount);

					List<WebElement> DeliveryRequestList = 	getElements("DeliveryRequestLists", DeliveryCalendarLocators);
					for (WebElement webElement : DeliveryRequestList) {
						String DeliveryRequestName = 	GetTextFromTheElement(webElement);

						String Excelvalue = 	ReadFrom.Excel(FilterDelivery, 2, ReadFrom.FilterDelivery);
						if(IsEqual(Excelvalue, DeliveryRequestName)) {
							Print("Displayed value is : " + DeliveryRequestName);
							ExtentCucumberAdapter.addTestStepLog("Displayed value is : " + DeliveryRequestName);
						}
						else
						{
							PrintError("Displayed value is : " + DeliveryRequestName);
							ExtentCucumberAdapter.addTestStepLog("Displayed value is : " + DeliveryRequestName);
						}

					}

				}
				catch (Exception e) {
					Print(e.getMessage());
				}


				Wait(2000);
				JsClick("FilterIcon", DeliveryCalendarLocators);
				Wait(2000);
				JsClick("ResetButton", DeliveryCalendarLocators);
				ExtentCucumberAdapter.addTestStepLog("Reset button is clicked");
				Print("Reset button is clicked");


			}
		}
		catch (Exception e) {
			PrintError(e.getMessage());
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());
		}
	}


	public static void EditDelivery() throws Throwable {

		PrintError("Edit delivery started");
		ReadFrom.DynamicExcel(ReadFrom.EditDelivery);
		try {

			for(int EditDelivery =1; EditDelivery<=ReadFrom.rowcount; EditDelivery++)	{

				SearchMonth(EditDelivery, ReadFrom.EditDelivery);
				SearchYear(EditDelivery, ReadFrom.EditDelivery);

				Wait<WebDriver> fluentWait11 = new FluentWait<WebDriver>(driver)
						.withTimeout(Duration.ofSeconds(120))
						.pollingEvery(Duration.ofSeconds(10))
						.ignoring(NoSuchElementException.class);


				fluentWait11.until(new Function<WebDriver, WebElement>() {
					public WebElement apply(WebDriver driver) {
						return driver.findElement(By.xpath("(//td/div/div[2]/div/a/div[3]/div/p)"));
					}
				});

				int rowcount = 	SizeOfTheList("DeliveryRequestLists", DeliveryCalendarLocators);
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

					WebElement Delivery =	FindElement("DeliveryRequestList", DeliveryCalendarLocators, DeliveryLists);

					String DeliveryName = 	GetTextFromTheElement(Delivery);

					String EditIt =	ReadFrom.Excel(EditDelivery, 2, ReadFrom.EditDelivery);


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

						JsClick("EditButton", DeliveryCalendarLocators);
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

						if(IsElementDisplayed("Description", DeliveryCalendarLocators)) {
							Print("Delivery popup is opened");
							ExtentCucumberAdapter.addTestStepLog("Delivery popup is opened");
						}

						Clear("Description", DeliveryCalendarLocators);
						TypeDataInTheField("Description", DeliveryCalendarLocators, ReadFrom.Excel(EditDelivery, 3, ReadFrom.EditDelivery));
						Print("Description is entered as : " + ReadFrom.Excel(EditDelivery, 3, ReadFrom.EditDelivery));
						ExtentCucumberAdapter.addTestStepLog("Description is entered as : " + ReadFrom.Excel(EditDelivery, 3, ReadFrom.EditDelivery));

						SelectFromVisibleText("GateDropdown", DeliveryCalendarLocators, ReadFrom.Excel(EditDelivery, 4, ReadFrom.EditDelivery));
						Print("Gate dropdown is selected as : " + ReadFrom.Excel(EditDelivery, 4, ReadFrom.EditDelivery));
						ExtentCucumberAdapter.addTestStepLog("Gate dropdown is selected as : " + ReadFrom.Excel(EditDelivery, 4, ReadFrom.EditDelivery));



						SelectFromVisibleText("EquipmentDropdown", DeliveryCalendarLocators, ReadFrom.Excel(EditDelivery, 5, ReadFrom.EditDelivery));
						Print("Equipment dropdown is selected as : " + ReadFrom.Excel(EditDelivery, 5, ReadFrom.EditDelivery));
						ExtentCucumberAdapter.addTestStepLog("Equipment dropdown is selected as : " + ReadFrom.Excel(EditDelivery, 5, ReadFrom.EditDelivery));

						Wait(2000);
						try {
							if(IsElementDisplayed("PickingFrom", DeliveryCalendarLocators)) {
								Clear("PickingFrom", DeliveryCalendarLocators);
								TypeDataInTheField("PickingFrom", DeliveryCalendarLocators, ReadFrom.Excel(EditDelivery, 19, ReadFrom.EditDelivery));
								Print("Picking from is entered as : " + ReadFrom.Excel(EditDelivery, 19, ReadFrom.EditDelivery));
								ExtentCucumberAdapter.addTestStepLog("Picking from is entered as : " + ReadFrom.Excel(EditDelivery, 19, ReadFrom.EditDelivery));

								Wait(2000);
								Clear("PickingTo", DeliveryCalendarLocators);
								TypeDataInTheField("PickingTo", DeliveryCalendarLocators, ReadFrom.Excel(EditDelivery, 20, ReadFrom.EditDelivery));
								Print("Picking to is entered as : " + ReadFrom.Excel(EditDelivery, 20, ReadFrom.EditDelivery));
								ExtentCucumberAdapter.addTestStepLog("Picking to is entered as : " + ReadFrom.Excel(EditDelivery, 20, ReadFrom.EditDelivery));

							}

						} catch (Exception e) {
							{
								PrintError("Delivery request equipment is  selected");
								ExtentCucumberAdapter.addTestStepLog("Delivery request equipment is  selected");

							}
						}

						Wait(2000);
						MoveToElement("AdditionalText", DeliveryCalendarLocators);
						Clear("AdditionalText", DeliveryCalendarLocators);
						TypeDataInTheField("AdditionalText", DeliveryCalendarLocators, ReadFrom.Excel(EditDelivery, 6, ReadFrom.EditDelivery));
						Print("Additional text is entered as : " + ReadFrom.Excel(EditDelivery, 6, ReadFrom.EditDelivery));
						ExtentCucumberAdapter.addTestStepLog("Additional text is entered as : " + ReadFrom.Excel(EditDelivery, 6, ReadFrom.EditDelivery));

						Clear("VehicleDetails", DeliveryCalendarLocators);
						TypeDataInTheField("VehicleDetails", DeliveryCalendarLocators, ReadFrom.Excel(EditDelivery, 7, ReadFrom.EditDelivery));
						Print("Vehicle details is entered as : " + ReadFrom.Excel(EditDelivery, 7, ReadFrom.EditDelivery));
						ExtentCucumberAdapter.addTestStepLog("Vehicle details is entered as : " + ReadFrom.Excel(EditDelivery, 7, ReadFrom.EditDelivery));


						Click("DeliveryDate", DeliveryCalendarLocators);

						Wait(2000);
						Click("Currentyear", DeliveryCalendarLocators);
						Wait(3000);

						String Year = "False";
						while(Year=="False") {
							if(driver.findElements(By.xpath("//span[normalize-space()='"+ ReadFrom.Excel(EditDelivery, 8, ReadFrom.EditDelivery) +"']")).size()>0){
								driver.findElement(By.xpath("//span[normalize-space()='"+ ReadFrom.Excel(EditDelivery, 8, ReadFrom.EditDelivery) +"']")).click();

								ExtentCucumberAdapter.addTestStepLog("Year is selected as : " + ReadFrom.Excel(EditDelivery, 8, ReadFrom.EditDelivery));
								Print("Year is selected as : " + ReadFrom.Excel(EditDelivery, 8, ReadFrom.EditDelivery));

								Year = "True";
							}
							else {

								Click("Nextyear", DeliveryCalendarLocators);
							}
						}

						String Month = "False";
						while(Month=="False") {

							if(driver.findElements(By.xpath("//span[normalize-space()='"+ ReadFrom.Excel(EditDelivery, 9, ReadFrom.EditDelivery) +"']")).size()>0){
								driver.findElement(By.xpath("//span[normalize-space()='"+ ReadFrom.Excel(EditDelivery, 9, ReadFrom.EditDelivery) +"']")).click();

								Print("Month is selected as : " + ReadFrom.Excel(EditDelivery, 9, ReadFrom.EditDelivery));
								ExtentCucumberAdapter.addTestStepLog("Month is selected as : " + ReadFrom.Excel(EditDelivery, 9, ReadFrom.EditDelivery));
								Month = "True";
							}
							else {
								PrintError("Month is not available");
							}
						}

						String Date = "False";
						while(Date=="False") {
							if(driver.findElements(By.xpath("//span[normalize-space()='"+ ReadFrom.Excel(EditDelivery, 10, ReadFrom.EditDelivery) +"']")).size()>0){
								driver.findElement(By.xpath("//span[normalize-space()='"+ ReadFrom.Excel(EditDelivery, 10, ReadFrom.EditDelivery) +"']")).click();

								Print("Date is selected as : " + ReadFrom.Excel(EditDelivery, 10, ReadFrom.EditDelivery));
								ExtentCucumberAdapter.addTestStepLog("Date is selected as : " + ReadFrom.Excel(EditDelivery, 10, ReadFrom.EditDelivery));
								Date = "True";

							}
							else {

								PrintError("Date is not available");
							}
						}


						///////////////////////

						JsClick("DfowEdit", DeliveryCalendarLocators);


						ExtentCucumberAdapter.addTestStepLog("Dfow dropdown is clicked");

						Click("SelectAll", DeliveryCalendarLocators);
						Wait(2000);
						Click("SelectAll", DeliveryCalendarLocators);
						Wait(2000);
						Click("Dfow", DeliveryCalendarLocators);

						String DfowInExcel = ReadFrom.Excel(EditDelivery, 11,ReadFrom.EditDelivery);


						int rowcountofthelist = 	SizeOfTheList("DfowListEdit", DeliveryCalendarLocators);
						Print("No of elements : " + rowcountofthelist);

						for(int DropdownValues =1; DropdownValues<=rowcountofthelist; DropdownValues++)		{	
							WebElement Dfow = 	FindElement("DfowListEdits", DeliveryCalendarLocators, DropdownValues);
							String DfowInDropdown = 	GetTextFromTheElement(Dfow);



							if(IsEqual(DfowInDropdown, DfowInExcel)){
								Click(Dfow);

								ExtentCucumberAdapter.addTestStepLog("Dfow is selected as : " + DfowInDropdown );
								Print("Dfow is selected as : " + DfowInDropdown );
								break;
							}
						}	

						/////////////////////////////////////
						JsClick("CompanyEdit", DeliveryCalendarLocators);
						//Click("Company", DeliveryCalendarLocators);

						ExtentCucumberAdapter.addTestStepLog("Company dropdown is clicked");
						Print("Company dropdown is clicked");

						Click("UnselectAll", DeliveryCalendarLocators);
						Wait(2000);
						Click("UnselectAll", DeliveryCalendarLocators);
						Wait(2000);
						Click("ResCompany", DeliveryCalendarLocators);

						String CompanyInExcel = ReadFrom.Excel(EditDelivery, 12,ReadFrom.EditDelivery);


						int countofthelist = 	SizeOfTheList("CompanyListEdit", DeliveryCalendarLocators);
						Print("No of elements : " + countofthelist);

						for(int DropdownValues =1; DropdownValues<=countofthelist; DropdownValues++)		{	
							WebElement Company = 	FindElement("CompanyListEdits", DeliveryCalendarLocators, DropdownValues);
							String CompanyInDropdown = 	GetTextFromTheElement(Company);

							if(IsEqual(CompanyInDropdown, CompanyInExcel)){
								Click(Company);

								ExtentCucumberAdapter.addTestStepLog("Dfow is selected as : " + CompanyInDropdown );
								Print("Dfow is selected as : " + CompanyInDropdown );
								break;
							}
							else {
								PrintError("Not matched");
								ExtentCucumberAdapter.addTestStepLog("Not matched");
							}
						}	

						Wait(2000);
						Clear("FromHrs", DeliveryCalendarLocators);
						TypeDataInTheField("FromHrs", DeliveryCalendarLocators, ReadFrom.Excel(EditDelivery, 13, ReadFrom.EditDelivery));
						Print("From hrs is entered as : " + ReadFrom.Excel(EditDelivery, 13, ReadFrom.EditDelivery));
						ExtentCucumberAdapter.addTestStepLog("From hrs is entered as : " + ReadFrom.Excel(EditDelivery, 13, ReadFrom.EditDelivery));

						Wait(2000);
						Clear("FromMin", DeliveryCalendarLocators);
						TypeDataInTheField("FromMin", DeliveryCalendarLocators, ReadFrom.Excel(EditDelivery, 14, ReadFrom.EditDelivery));
						Print("From min is entered as : " + ReadFrom.Excel(EditDelivery, 14, ReadFrom.EditDelivery));
						ExtentCucumberAdapter.addTestStepLog("From min is entered as : " + ReadFrom.Excel(EditDelivery, 14, ReadFrom.EditDelivery));

						Wait(2000);
						String ExcelMeridian = ReadFrom.Excel(EditDelivery, 15, ReadFrom.EditDelivery);

						String Meridian = GetText("FromMeridian", DeliveryCalendarLocators);

						if(IsEqual(Meridian, ExcelMeridian)) {


						}
						else {
							Click("FromMeridian", DeliveryCalendarLocators);
							Print("selected");
						}

						Wait(2000);
						Clear("ToHrs", DeliveryCalendarLocators);
						TypeDataInTheField("ToHrs", DeliveryCalendarLocators, ReadFrom.Excel(EditDelivery, 16, ReadFrom.EditDelivery));
						Print("To hrs is entered as : " + ReadFrom.Excel(EditDelivery, 16, ReadFrom.EditDelivery));
						ExtentCucumberAdapter.addTestStepLog("To hrs is entered as : " + ReadFrom.Excel(EditDelivery, 16, ReadFrom.EditDelivery));

						Wait(2000);
						Clear("ToMin", DeliveryCalendarLocators);
						TypeDataInTheField("ToMin", DeliveryCalendarLocators, ReadFrom.Excel(EditDelivery, 17, ReadFrom.EditDelivery));
						Print("To min is entered as : " + ReadFrom.Excel(EditDelivery, 17, ReadFrom.EditDelivery));
						ExtentCucumberAdapter.addTestStepLog("To min is entered as : " + ReadFrom.Excel(EditDelivery, 17, ReadFrom.EditDelivery));

						Wait(2000);
						String ExcelMeridian1 = ReadFrom.Excel(EditDelivery, 18, ReadFrom.EditDelivery);
						String Meridian1 = GetText("ToMeridian", DeliveryCalendarLocators);
						if(IsEqual(Meridian1, ExcelMeridian1)) {


						}
						else {
							Click("ToMeridian", DeliveryCalendarLocators);

						}

						MoveToElement("SubmitButton", DeliveryCalendarLocators);

						Click("SubmitButton", DeliveryCalendarLocators);
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

						if(IsElementDisplayed("DeliveryUpdated", DeliveryCalendarLocators)) {
							Click("DeliveryUpdated", DeliveryCalendarLocators);
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

	public static void PushToVoid() throws Throwable {

		PrintError("Push delivery started");
		ReadFrom.DynamicExcel(ReadFrom.Void);
		try {

			for(int Void =1; Void<=ReadFrom.rowcount; Void++)	{


				SearchMonth(Void, ReadFrom.Void);
				SearchYear(Void, ReadFrom.Void);

				Wait<WebDriver> fluentWait11 = new FluentWait<WebDriver>(driver)
						.withTimeout(Duration.ofSeconds(120))
						.pollingEvery(Duration.ofSeconds(10))
						.ignoring(NoSuchElementException.class);


				fluentWait11.until(new Function<WebDriver, WebElement>() {
					public WebElement apply(WebDriver driver) {
						return driver.findElement(By.xpath("(//td/div/div[2]/div/a/div[3]/div/p)"));
					}
				});

				int rowcount = 	SizeOfTheList("DeliveryRequestLists", DeliveryCalendarLocators);
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

					WebElement Delivery =	FindElement("DeliveryRequestList", DeliveryCalendarLocators, DeliveryLists);

					String DeliveryName = 	GetTextFromTheElement(Delivery);

					String EditIt =	ReadFrom.Excel(Void, 2, ReadFrom.Void);


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

						JsClick("VoidButton", DeliveryCalendarLocators);
						ExtentCucumberAdapter.addTestStepLog("Void button is clicked");
						Print("Void button is clicked");

						Wait(2000);
						Click("VoidYes", DeliveryCalendarLocators);
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

						if(IsElementDisplayed("VoidSuccessfull", DeliveryCalendarLocators)) {
							Click("VoidSuccessfull", DeliveryCalendarLocators);
							Print(DeliveryName + " : is pushed to void");
							ExtentCucumberAdapter.addTestStepLog(DeliveryName + " : is pushed to void");

							Wait(3000);
							//Stale("DeliveryCalendar", DeliveryCalendarLocators);
							JsClick("DeliveryCalendar", DeliveryCalendarLocators);
							ExtentCucumberAdapter.addTestStepLog("Delivery calendar button is clicked");
							Print("Delivery calendar button is clicked");


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

	public static void ViewDeliveryInfo() throws Throwable {
		PrintError("View delivery started");
		ReadFrom.DynamicExcel(ReadFrom.ViewDelivery);
		try {

			for(int ViewDelivery =1; ViewDelivery<=ReadFrom.rowcount; ViewDelivery++)	{


				SearchMonth(ViewDelivery, ReadFrom.ViewDelivery);
				SearchYear(ViewDelivery, ReadFrom.ViewDelivery);

				Wait<WebDriver> fluentWait11 = new FluentWait<WebDriver>(driver)
						.withTimeout(Duration.ofSeconds(120))
						.pollingEvery(Duration.ofSeconds(10))
						.ignoring(NoSuchElementException.class);


				fluentWait11.until(new Function<WebDriver, WebElement>() {
					public WebElement apply(WebDriver driver) {
						return driver.findElement(By.xpath("(//td/div/div[2]/div/a/div[3]/div/p)"));
					}
				});

				int rowcount = 	SizeOfTheList("DeliveryRequestLists", DeliveryCalendarLocators);
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

					WebElement Delivery =	FindElement("DeliveryRequestList", DeliveryCalendarLocators, DeliveryLists);

					String DeliveryName = 	GetTextFromTheElement(Delivery);
					Print(DeliveryName);
					String ViewInfo =	ReadFrom.Excel(ViewDelivery, 2, ReadFrom.ViewDelivery);
					Print(ViewInfo);

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
								return driver.findElement(By.xpath("//div[1]/div[1]/span/span/em"));
							}
						});

						JsClick("Expand", DeliveryCalendarLocators);

						ExtentCucumberAdapter.addTestStepLog("Expand button is clicked");
						Print("Expand button is clicked");

						Wait<WebDriver> fluentWait1 = new FluentWait<WebDriver>(driver)
								.withTimeout(Duration.ofSeconds(120))
								.pollingEvery(Duration.ofSeconds(5))
								.ignoring(NoSuchElementException.class);


						fluentWait1.until(new Function<WebDriver, WebElement>() {
							public WebElement apply(WebDriver driver) {
								return driver.findElement(By.xpath("//h4[normalize-space()='Delivery Status']"));
							}
						});

						if(IsElementDisplayed("ViewDetails", DeliveryCalendarLocators)) {
							Print(DeliveryName + " : Delivery info is viewed");
							ExtentCucumberAdapter.addTestStepLog(DeliveryName + " : Delivery info is viewed");

							JsClick("ClosePopup", DeliveryCalendarLocators);

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

	public static void AddComment() throws Throwable {

		PrintError("Add comment started");
		ReadFrom.DynamicExcel(ReadFrom.Comments);
		try {

			for(int Comments =1; Comments<=ReadFrom.rowcount; Comments++)	{


				SearchMonth(Comments, ReadFrom.Comments);
				SearchYear(Comments, ReadFrom.Comments);

				Wait<WebDriver> fluentWait11 = new FluentWait<WebDriver>(driver)
						.withTimeout(Duration.ofSeconds(120))
						.pollingEvery(Duration.ofSeconds(10))
						.ignoring(NoSuchElementException.class);


				fluentWait11.until(new Function<WebDriver, WebElement>() {
					public WebElement apply(WebDriver driver) {
						return driver.findElement(By.xpath("(//td/div/div[2]/div/a/div[3]/div/p)"));
					}
				});

				int rowcount = 	SizeOfTheList("DeliveryRequestLists", DeliveryCalendarLocators);
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

					WebElement Delivery =	FindElement("DeliveryRequestList", DeliveryCalendarLocators, DeliveryLists);

					String DeliveryName = 	GetTextFromTheElement(Delivery);

					String ViewInfo =	ReadFrom.Excel(Comments, 2, ReadFrom.Comments);


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
								return driver.findElement(By.xpath("//div[1]/div[1]/span/span/em"));
							}
						});

						JsClick("Expand", DeliveryCalendarLocators);
						ExtentCucumberAdapter.addTestStepLog("Expand button is clicked");
						Print("Expand button is clicked");

						Wait<WebDriver> fluentWait1 = new FluentWait<WebDriver>(driver)
								.withTimeout(Duration.ofSeconds(120))
								.pollingEvery(Duration.ofSeconds(5))
								.ignoring(NoSuchElementException.class);


						fluentWait1.until(new Function<WebDriver, WebElement>() {
							public WebElement apply(WebDriver driver) {
								return driver.findElement(By.xpath("//h4[normalize-space()='Delivery Status']"));
							}
						});

						if(IsElementDisplayed("ViewDetails", DeliveryCalendarLocators)) {
							JsClick("Comments", DeliveryCalendarLocators);
							ExtentCucumberAdapter.addTestStepLog("Comment button is clicked");
							Print("Comment button is clicked");

							TypeDataInTheField("AddComment", DeliveryCalendarLocators, ReadFrom.Excel(Comments, 3, ReadFrom.Comments));
							Print("Comment is entered as : " + ReadFrom.Excel(Comments, 3, ReadFrom.Comments));
							ExtentCucumberAdapter.addTestStepLog("Description is entered as : " + ReadFrom.Excel(Comments, 3, ReadFrom.Comments));

							JsClick("SubmitButton", DeliveryCalendarLocators);
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

						}

						if(IsElementDisplayed("CommentaddedSuccessfully", DeliveryCalendarLocators)) {
							JsClick("CommentaddedSuccessfully", DeliveryCalendarLocators);
							Print("Comment added Successfully");
							ExtentCucumberAdapter.addTestStepLog("Comment added Successfully");

							JsClick("ClosePopup", DeliveryCalendarLocators);
							ExtentCucumberAdapter.addTestStepLog("Close popup is clicked");
							Print("Close popup is clicked");
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

	public static void ViewHistory() throws Throwable {
		PrintError("View history started");
		ReadFrom.DynamicExcel(ReadFrom.ViewDelivery);
		try {

			for(int ViewDelivery =1; ViewDelivery<=ReadFrom.rowcount; ViewDelivery++)	{


				SearchMonth(ViewDelivery, ReadFrom.ViewDelivery);
				SearchYear(ViewDelivery, ReadFrom.ViewDelivery);

				Wait<WebDriver> fluentWait11 = new FluentWait<WebDriver>(driver)
						.withTimeout(Duration.ofSeconds(120))
						.pollingEvery(Duration.ofSeconds(10))
						.ignoring(NoSuchElementException.class);


				fluentWait11.until(new Function<WebDriver, WebElement>() {
					public WebElement apply(WebDriver driver) {
						return driver.findElement(By.xpath("(//td/div/div[2]/div/a/div[3]/div/p)"));
					}
				});

				int rowcount = 	SizeOfTheList("DeliveryRequestLists", DeliveryCalendarLocators);
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

					WebElement Delivery =	FindElement("DeliveryRequestList", DeliveryCalendarLocators, DeliveryLists);

					String DeliveryName = 	GetTextFromTheElement(Delivery);

					String ViewInfo =	ReadFrom.Excel(ViewDelivery, 2, ReadFrom.ViewDelivery);


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
								return driver.findElement(By.xpath("//div[1]/div[1]/span/span/em"));
							}
						});

						JsClick("Expand", DeliveryCalendarLocators);
						ExtentCucumberAdapter.addTestStepLog("Expand button is clicked");
						Print("Expand button is clicked");

						Wait<WebDriver> fluentWait1 = new FluentWait<WebDriver>(driver)
								.withTimeout(Duration.ofSeconds(120))
								.pollingEvery(Duration.ofSeconds(5))
								.ignoring(NoSuchElementException.class);


						fluentWait1.until(new Function<WebDriver, WebElement>() {
							public WebElement apply(WebDriver driver) {
								return driver.findElement(By.xpath("//h4[normalize-space()='Delivery Status']"));
							}
						});

						if(IsElementDisplayed("ViewDetails", DeliveryCalendarLocators)) {

							JsClick("History", DeliveryCalendarLocators);
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
						}

						if(IsElementDisplayed("HistoryPage", DeliveryCalendarLocators)) {

							Print(DeliveryName + " : History page is viewed");
							ExtentCucumberAdapter.addTestStepLog(DeliveryName + " : History page is viewed");

							JsClick("ClosePopup", DeliveryCalendarLocators);
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
		ReadFrom.DynamicExcel(ReadFrom.DeliverRequest);
		try {

			for(int DeliverRequest =1; DeliverRequest<=ReadFrom.rowcount; DeliverRequest++)	{


				SearchMonth(DeliverRequest, ReadFrom.DeliverRequest);
				SearchYear(DeliverRequest, ReadFrom.DeliverRequest);

				Wait<WebDriver> fluentWait11 = new FluentWait<WebDriver>(driver)
						.withTimeout(Duration.ofSeconds(120))
						.pollingEvery(Duration.ofSeconds(10))
						.ignoring(NoSuchElementException.class);


				fluentWait11.until(new Function<WebDriver, WebElement>() {
					public WebElement apply(WebDriver driver) {
						return driver.findElement(By.xpath("(//td/div/div[2]/div/a/div[3]/div/p)"));
					}
				});

				int rowcount = 	SizeOfTheList("DeliveryRequestLists", DeliveryCalendarLocators);
				Print("No of elements : " + rowcount);

				for(int Deliver =1; Deliver<=rowcount; Deliver++)		{

					Wait<WebDriver> fluentWait111 = new FluentWait<WebDriver>(driver)
							.withTimeout(Duration.ofSeconds(120))
							.pollingEvery(Duration.ofSeconds(10))
							.ignoring(NoSuchElementException.class);


					fluentWait111.until(new Function<WebDriver, WebElement>() {
						public WebElement apply(WebDriver driver) {
							return driver.findElement(By.xpath("(//td/div/div[2]/div/a/div[3]/div/p)"));
						}
					});

					WebElement Delivery =	FindElement("DeliveryRequestList", DeliveryCalendarLocators, Deliver);

					String DeliveryName = 	GetTextFromTheElement(Delivery);

					String ViewInfo =	ReadFrom.Excel(DeliverRequest, 2, ReadFrom.ViewDelivery);


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
								return driver.findElement(By.xpath("//div[1]/div[1]/span/span/em"));
							}
						});

						JsClick("Expand", DeliveryCalendarLocators);
						ExtentCucumberAdapter.addTestStepLog("Expand button is clicked");
						Print("Expand button is clicked");

						Wait<WebDriver> fluentWait1 = new FluentWait<WebDriver>(driver)
								.withTimeout(Duration.ofSeconds(120))
								.pollingEvery(Duration.ofSeconds(5))
								.ignoring(NoSuchElementException.class);


						fluentWait1.until(new Function<WebDriver, WebElement>() {
							public WebElement apply(WebDriver driver) {
								return driver.findElement(By.xpath("//h4[normalize-space()='Delivery Status']"));
							}
						});

						if(IsElementDisplayed("ViewDetails", DeliveryCalendarLocators)) {

							JsClick("Deliver", DeliveryCalendarLocators);
							ExtentCucumberAdapter.addTestStepLog("Deliver button is clicked");
							Print("Deliver button is clicked");
							Wait(2000);
							JsClick("Save", DeliveryCalendarLocators);
							ExtentCucumberAdapter.addTestStepLog("Save button is clicked");
							Print("Save button is clicked");
							Wait(2000);
							JsClick("YesButton", DeliveryCalendarLocators);
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
						}

						if(IsElementDisplayed("DeliveredSuccessfully", DeliveryCalendarLocators)) {

							Print(DeliveryName + " : is delivered successfully");
							ExtentCucumberAdapter.addTestStepLog(DeliveryName + " : is delivered successfully");

							JsClick("ClosePopup", DeliveryCalendarLocators);
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
		PrintError("Approve Or Reject started");
		ReadFrom.DynamicExcel(ReadFrom.ApproveOrReject);
		try {

			for(int ApproveOrReject =1; ApproveOrReject<=ReadFrom.rowcount; ApproveOrReject++)	{


				SearchMonth(ApproveOrReject, ReadFrom.ApproveOrReject);
				SearchYear(ApproveOrReject, ReadFrom.ApproveOrReject);

				Wait<WebDriver> fluentWait11 = new FluentWait<WebDriver>(driver)
						.withTimeout(Duration.ofSeconds(120))
						.pollingEvery(Duration.ofSeconds(10))
						.ignoring(NoSuchElementException.class);


				fluentWait11.until(new Function<WebDriver, WebElement>() {
					public WebElement apply(WebDriver driver) {
						return driver.findElement(By.xpath("(//td/div/div[2]/div/a/div[3]/div/p)"));
					}
				});


				List<WebElement> Texts =		GetTextFromElements("DeliveryRequestLists", DeliveryCalendarLocators);

				for (WebElement webElement : Texts) {

					String secName = GetTextFromTheElement(webElement);
					Print(secName);
					String EditIt =	ReadFrom.Excel(ApproveOrReject, 2, ReadFrom.ApproveOrReject);
					Print(EditIt);

					Wait(2000);

					if(IsEqual(secName, EditIt)) {

						JsClick(webElement);	
						ExtentCucumberAdapter.addTestStepLog(secName + " : is clicked");
						Print(secName + " : is clicked");
					}

				}

				Wait<WebDriver> CompanyInFilter = new FluentWait<WebDriver>(driver)
						.withTimeout(Duration.ofSeconds(120))
						.pollingEvery(Duration.ofSeconds(10))
						.ignoring(NoSuchElementException.class);


				CompanyInFilter.until(new Function<WebDriver, WebElement>() {
					public WebElement apply(WebDriver driver) {
						return driver.findElement(By.xpath("//button[normalize-space()='Edit']"));
					}
				});

				JsClick("EditButton", DeliveryCalendarLocators);
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

				if(IsElementDisplayed("Description", DeliveryCalendarLocators)) {
					Print("Delivery popup is opened");
					ExtentCucumberAdapter.addTestStepLog("Delivery popup is opened");
				}

				Clear("Description", DeliveryCalendarLocators);
				TypeDataInTheField("Description", DeliveryCalendarLocators, ReadFrom.Excel(ApproveOrReject, 2, ReadFrom.ApproveOrReject));
				Print("Description is entered as : " + ReadFrom.Excel(ApproveOrReject, 2, ReadFrom.ApproveOrReject));
				ExtentCucumberAdapter.addTestStepLog("Description is entered as : " + ReadFrom.Excel(ApproveOrReject, 2, ReadFrom.ApproveOrReject));


				MoveToElement("SubmitButton", DeliveryCalendarLocators);

				Click("SubmitButton", DeliveryCalendarLocators);
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


				Refresh();
				Wait<WebDriver> Calendar = new FluentWait<WebDriver>(driver)
						.withTimeout(Duration.ofSeconds(120))
						.pollingEvery(Duration.ofSeconds(10))
						.ignoring(NoSuchElementException.class);


				Calendar.until(new Function<WebDriver, WebElement>() {
					public WebElement apply(WebDriver driver) {
						return driver.findElement(By.xpath("//*[@id=\"calendar\"]/div[1]/div[2]/div/h2"));
					}
				});

				Wait(2000);

				SearchMonth(ApproveOrReject, ReadFrom.ApproveOrReject);
				SearchYear(ApproveOrReject, ReadFrom.ApproveOrReject);

				Wait<WebDriver> d2 = new FluentWait<WebDriver>(driver)
						.withTimeout(Duration.ofSeconds(120))
						.pollingEvery(Duration.ofSeconds(10))
						.ignoring(NoSuchElementException.class);


				d2.until(new Function<WebDriver, WebElement>() {
					public WebElement apply(WebDriver driver) {
						return driver.findElement(By.xpath("(//td/div/div[2]/div/a/div[3]/div/p)"));
					}
				});


				List<WebElement> Text =		GetTextFromElements("DeliveryRequestLists", DeliveryCalendarLocators);
				for (WebElement webElement : Text) {
					String Name = GetTextFromTheElement(webElement);
					String EditName =	ReadFrom.Excel(ApproveOrReject, 2, ReadFrom.ApproveOrReject);

					Wait(2000);

					if(IsEqual(Name, EditName)) {		
						JsClick(webElement);
						ExtentCucumberAdapter.addTestStepLog(webElement + " : is clicked");
						Print(webElement + " : is clicked");
					}

				}

				new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(120))
				.pollingEvery(Duration.ofSeconds(10))
				.ignoring(NoSuchElementException.class);


				CompanyInFilter.until(new Function<WebDriver, WebElement>() {
					public WebElement apply(WebDriver driver) {
						return driver.findElement(By.xpath("//div[1]/div[1]/span/span/em"));
					}
				});

				JsClick("Expand", DeliveryCalendarLocators);
				ExtentCucumberAdapter.addTestStepLog("Expand button is clicked");
				Print("Expand button is clicked");


				new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(120))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class);


				fluentWait1.until(new Function<WebDriver, WebElement>() {
					public WebElement apply(WebDriver driver) {
						return driver.findElement(By.xpath("//h4[normalize-space()='Delivery Status']"));
					}
				});

				if(IsElementDisplayed("ViewDetails", DeliveryCalendarLocators)) {
					Wait(2000);	new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(120))
					.pollingEvery(Duration.ofSeconds(5))
					.ignoring(NoSuchElementException.class);


					fluentWait1.until(new Function<WebDriver, WebElement>() {
						public WebElement apply(WebDriver driver) {
							return driver.findElement(By.xpath("//div[@class='form-group mb-0']//select[@class='form-control fs12 material-input pr-5']"));
						}
					});

					SelectFromVisibleText("SelectStatus", DeliveryCalendarLocators, ReadFrom.Excel(ApproveOrReject, 3, ReadFrom.ApproveOrReject));
					Print("Status is selected as : " + ReadFrom.Excel(ApproveOrReject, 3, ReadFrom.ApproveOrReject));
					ExtentCucumberAdapter.addTestStepLog("Status is selected as : " + ReadFrom.Excel(ApproveOrReject, 3, ReadFrom.ApproveOrReject));

					Wait(2000);
					JsClick("Save", DeliveryCalendarLocators);
					ExtentCucumberAdapter.addTestStepLog("Save button is clicked");
					Print("Save button is clicked");


					String Status = ReadFrom.Excel(ApproveOrReject, 3, ReadFrom.ApproveOrReject);

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
						JsClick("ClosePopup", DeliveryCalendarLocators);
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
						JsClick("ClosePopup", DeliveryCalendarLocators);
						ExtentCucumberAdapter.addTestStepLog("Close popup button is clicked");
						Print("Close popup button is clicked");
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