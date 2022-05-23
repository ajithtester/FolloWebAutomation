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

public class F_12_CalendarSettings extends Baseclass {


		public static void AddEvent() throws Throwable {
	
			ReadFrom.DynamicExcel(ReadFrom.CalendarRequest);
	
			try {
	
				for(int CalendarAddRequest =1; CalendarAddRequest<=ReadFrom.rowcount; CalendarAddRequest++)		{	
	
					Wait(4000);
					PrintError("Calendar started");
					Click("AddButton", CalendarSettingsLocators);
					Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
							.withTimeout(Duration.ofSeconds(120))
							.pollingEvery(Duration.ofSeconds(5))
							.ignoring(NoSuchElementException.class);
	
	
					fluentWait.until(new Function<WebDriver, WebElement>() {
						public WebElement apply(WebDriver driver) {
							return driver.findElement(By.xpath("//input[@placeholder='Description']"));
						}
					});
	
					if(IsElementDisplayed("Description", CalendarSettingsLocators)) {
						Print("Calendar request popup is opened");
						ExtentCucumberAdapter.addTestStepLog("Calendar request popup is opened");
					}
	
					TypeDataInTheField("Description", CalendarSettingsLocators, ReadFrom.Excel(CalendarAddRequest, 0, ReadFrom.CalendarRequest));
					Print("Description is entered as : " + ReadFrom.Excel(CalendarAddRequest, 0, ReadFrom.CalendarRequest));
					ExtentCucumberAdapter.addTestStepLog("Description is entered as : " + ReadFrom.Excel(CalendarAddRequest, 0, ReadFrom.CalendarRequest));
	
	
					Wait(2000);
					String AllDay = ReadFrom.Excel(CalendarAddRequest, 1, ReadFrom.CalendarRequest);
	
					if(IsEqual(AllDay, "No")) {
	
						Wait(2000);
						Clear("FromHH", CalendarSettingsLocators);
						TypeDataInTheField("FromHH", CalendarSettingsLocators, ReadFrom.Excel(CalendarAddRequest, 2, ReadFrom.CalendarRequest));
						Print("From hrs is entered as : " + ReadFrom.Excel(CalendarAddRequest, 2, ReadFrom.CalendarRequest));
						ExtentCucumberAdapter.addTestStepLog("From hrs is entered as : " + ReadFrom.Excel(CalendarAddRequest, 2, ReadFrom.CalendarRequest));
	
						Wait(2000);
						Clear("FromMM", CalendarSettingsLocators);
						TypeDataInTheField("FromMM", CalendarSettingsLocators, ReadFrom.Excel(CalendarAddRequest, 3, ReadFrom.CalendarRequest));
						Print("From min is entered as : " + ReadFrom.Excel(CalendarAddRequest, 3, ReadFrom.CalendarRequest));
						ExtentCucumberAdapter.addTestStepLog("From min is entered as : " + ReadFrom.Excel(CalendarAddRequest, 3, ReadFrom.CalendarRequest));
	
						Wait(2000);
						String ExcelMeridian = ReadFrom.Excel(CalendarAddRequest, 4, ReadFrom.CalendarRequest);
						Print("eXCEL" + ExcelMeridian);
						String Meridian = GetText("FromMeridian", CalendarSettingsLocators);
						Print("WEB" + Meridian);
						if(IsEqual(Meridian, ExcelMeridian)) {
	
	
						}
						else {
							Wait(2000);
							Click("FromMeridian", CalendarSettingsLocators);
							Print("selected");
						}
	
						Wait(2000);
						Clear("EndHH", CalendarSettingsLocators);
						TypeDataInTheField("EndHH", CalendarSettingsLocators, ReadFrom.Excel(CalendarAddRequest, 5, ReadFrom.CalendarRequest));
						Print("To hrs is entered as : " + ReadFrom.Excel(CalendarAddRequest, 5, ReadFrom.CalendarRequest));
						ExtentCucumberAdapter.addTestStepLog("To hrs is entered as : " + ReadFrom.Excel(CalendarAddRequest, 5, ReadFrom.CalendarRequest));
	
						Wait(2000);
						Clear("EndMM", CalendarSettingsLocators);
						TypeDataInTheField("EndMM", CalendarSettingsLocators, ReadFrom.Excel(CalendarAddRequest, 6, ReadFrom.CalendarRequest));
						Print("To min is entered as : " + ReadFrom.Excel(CalendarAddRequest, 6, ReadFrom.CalendarRequest));
						ExtentCucumberAdapter.addTestStepLog("To min is entered as : " + ReadFrom.Excel(CalendarAddRequest, 6, ReadFrom.CalendarRequest));
	
						Wait(2000);
						String ExcelMeridian1 = ReadFrom.Excel(CalendarAddRequest, 7, ReadFrom.CalendarRequest);
						String Meridian1 = GetText("EndMeridian", CalendarSettingsLocators);
						if(IsEqual(Meridian1, ExcelMeridian1)) {
	
	
						}
						else {
							Wait(2000);
							Click("EndMeridian", CalendarSettingsLocators);				
						}
					}
					else if (IsEqual(AllDay, "Yes")) {
						Wait(2000);
						Click("AllDay", CalendarSettingsLocators);
						Print("All day option is selected");
						ExtentCucumberAdapter.addTestStepLog("All day option is selected");
					}
	
					Wait(2000);
					Click("StartDate", CalendarSettingsLocators);
					Print("Start date is clicked");
					ExtentCucumberAdapter.addTestStepLog("Start date is clicked");
	
	
					Wait(2000);
	
					Clear("StartDate", CalendarSettingsLocators);
					TypeDataInTheField("StartDate", CalendarSettingsLocators, ReadFrom.Excel(CalendarAddRequest, 8, ReadFrom.CalendarRequest));
					Print("Start date is entered as : " + ReadFrom.Excel(CalendarAddRequest, 8, ReadFrom.CalendarRequest));
					ExtentCucumberAdapter.addTestStepLog("Start date is entered as : " + ReadFrom.Excel(CalendarAddRequest, 8, ReadFrom.CalendarRequest));
	
					Wait(2000);
					Clear("ToDate", CalendarSettingsLocators);
					TypeDataInTheField("ToDate", CalendarSettingsLocators, ReadFrom.Excel(CalendarAddRequest, 9, ReadFrom.CalendarRequest));
					Print("To date is entered as : " + ReadFrom.Excel(CalendarAddRequest, 9, ReadFrom.CalendarRequest));
					ExtentCucumberAdapter.addTestStepLog("To date is entered as : " + ReadFrom.Excel(CalendarAddRequest, 9, ReadFrom.CalendarRequest));
	
	
					String DeliveryCalendar = ReadFrom.Excel(CalendarAddRequest, 10, ReadFrom.CalendarRequest);
	
					if(IsEqual(DeliveryCalendar, "No")) {
	
	
					}
	
					else if (IsEqual(DeliveryCalendar, "Yes")) {
						Wait(2000);
						Click("DeliveryCalendar", CalendarSettingsLocators);
						Print("Delivery calendar option is selected");
						ExtentCucumberAdapter.addTestStepLog("Delivery calendar option is selected");
	
	
					}
	
					String CraneCalendar = ReadFrom.Excel(CalendarAddRequest, 11, ReadFrom.CalendarRequest);
	
					if(IsEqual(CraneCalendar, "No")) {
	
	
					}
	
					else if (IsEqual(CraneCalendar, "Yes")) {
						Wait(2000);
						Click("CraneCalendar", CalendarSettingsLocators);
						Print("Crane calendar option is selected");
						ExtentCucumberAdapter.addTestStepLog("Crane calendar option is selected");
	
					}
	
					Wait(2000);
					SelectFromVisibleText("RecurrenceDropdown", CalendarSettingsLocators, ReadFrom.Excel(CalendarAddRequest, 12, ReadFrom.CalendarRequest));
					Print("Recurrence dropdown is selected as : " + ReadFrom.Excel(CalendarAddRequest, 12, ReadFrom.CalendarRequest));
					ExtentCucumberAdapter.addTestStepLog("Recurrence dropdown is selected as : " + ReadFrom.Excel(CalendarAddRequest, 12, ReadFrom.CalendarRequest));
	
					String RecurrenceDropdown = ReadFrom.Excel(CalendarAddRequest, 12, ReadFrom.CalendarRequest);
					switch (RecurrenceDropdown) {
	
					case "Does Not Repeat":
	
						Wait(2000);
						MoveToElement("SubmitButton", CalendarSettingsLocators);
						Click("SubmitButton", CalendarSettingsLocators);
						Print("Submit button is clicked");
						ExtentCucumberAdapter.addTestStepLog("Submit button is clicked");
	
						EvenAddedPopup();
						break;
	
					case "Daily":
	
						Wait(2000);
						TypeDataInTheField("RepeatEveryCount", CalendarSettingsLocators, ReadFrom.Excel(CalendarAddRequest, 13, ReadFrom.CalendarRequest));
						Print("To date is entered as : " + ReadFrom.Excel(CalendarAddRequest, 13, ReadFrom.CalendarRequest));
						ExtentCucumberAdapter.addTestStepLog("To date is entered as : " + ReadFrom.Excel(CalendarAddRequest, 13, ReadFrom.CalendarRequest));
	
						Wait(2000);
						MoveToElement("SubmitButton", CalendarSettingsLocators);
	
						Click("SubmitButton", CalendarSettingsLocators);
						Print("Submit button is clicked");
						ExtentCucumberAdapter.addTestStepLog("Submit button is clicked");
						EvenAddedPopup();
						break;
	
					case "Weekly":
	
						Wait(2000);
						TypeDataInTheField("RepeatEveryCount", CalendarSettingsLocators, ReadFrom.Excel(CalendarAddRequest, 13, ReadFrom.CalendarRequest));
						Print("To date is entered as : " + ReadFrom.Excel(CalendarAddRequest, 13, ReadFrom.CalendarRequest));
						ExtentCucumberAdapter.addTestStepLog("To date is entered as : " + ReadFrom.Excel(CalendarAddRequest, 13, ReadFrom.CalendarRequest));
	
						Wait(2000);
						MoveToElement("SubmitButton", CalendarSettingsLocators);
	
						Click("SubmitButton", CalendarSettingsLocators);
						Print("Submit button is clicked");
						ExtentCucumberAdapter.addTestStepLog("Submit button is clicked");
						EvenAddedPopup();
						break;
	
					case "Monthly":
	
						Wait(2000);
						TypeDataInTheField("RepeatEveryCount", CalendarSettingsLocators, ReadFrom.Excel(CalendarAddRequest, 13, ReadFrom.CalendarRequest));
						Print("To date is entered as : " + ReadFrom.Excel(CalendarAddRequest, 13, ReadFrom.CalendarRequest));
						ExtentCucumberAdapter.addTestStepLog("To date is entered as : " + ReadFrom.Excel(CalendarAddRequest, 13, ReadFrom.CalendarRequest));
	
						if(IsEqual(CraneCalendar, "On day")) {						
							Click("OnDay", CalendarSettingsLocators);	
							Print("OnDay option is clicked");
							ExtentCucumberAdapter.addTestStepLog("OnDay option is clicked");
						}
						else if(IsEqual(CraneCalendar, "On the First")){						
							Click("OnFirstDay", CalendarSettingsLocators);
							Print("OnFirstDay option is clicked");
							ExtentCucumberAdapter.addTestStepLog("OnDay option is clicked");
						}
	
						MoveToElement("SubmitButton", CalendarSettingsLocators);
	
						Click("SubmitButton", CalendarSettingsLocators);
						Print("Submit button is clicked");
						ExtentCucumberAdapter.addTestStepLog("Submit button is clicked");
	
						EvenAddedPopup();
						break;
	
					case "Yearly":	
	
						if(IsEqual(CraneCalendar, "On day")) {						
							Click("OnDay", CalendarSettingsLocators);	
							Print("OnDay option is clicked");
							ExtentCucumberAdapter.addTestStepLog("OnDay option is clicked");
						}
						else if(IsEqual(CraneCalendar, "On the First")){						
							Click("OnFirstDay", CalendarSettingsLocators);
							Click("OnFirstDay", CalendarSettingsLocators);
							Print("OnFirstDay option is clicked");
						}
	
						MoveToElement("SubmitButton", CalendarSettingsLocators);
						Click("SubmitButton", CalendarSettingsLocators);
						Print("Submit button is clicked");
						ExtentCucumberAdapter.addTestStepLog("Submit button is clicked");
	
						EvenAddedPopup();
						break;
	
					default:
	
	
						Wait(2000);
					}
	
				}
			}
			catch (Exception e) {
				PrintError(e.getMessage());
				ExtentCucumberAdapter.addTestStepLog(e.getMessage());
			}
		}
	
	
	public static void EvenAddedPopup() throws Throwable {

		Wait<WebDriver> fluentWait11 = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(120))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class);


		fluentWait11.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.xpath("//div[@aria-label='Event added']"));
			}
		});

		if(IsElementDisplayed("EventAdded", CalendarSettingsLocators)) {
			Click("EventAdded", CalendarSettingsLocators);
			Print("Event added successfully");
		}
		else {
			PrintError("Event add failed");
		}

	}
	
	
	public static void EventUpdatedPopup() throws Throwable {

		Wait<WebDriver> fluentWait11 = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(120))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class);


		fluentWait11.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.xpath("//div[@aria-label='Event updated']"));
			}
		});

		if(IsElementDisplayed("EventUpdated", CalendarSettingsLocators)) {
			Click("EventUpdated", CalendarSettingsLocators);
			Print("Event updated successfully");
		}
		else {
			PrintError("Event updated failed");
		}

	}

	public static void SearchYear(int Row , String Excel) throws Throwable {

		Wait(6000);


		String Date = "False";
		while(Date=="False") {

			String CalendarYear =  GetText("CalendarYear", CalendarSettingsLocators);		

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
						return driver.findElement(By.xpath("//div[1]/div[2]/div/button[1]/span"));
					}
				});

				JsClick("PreviousYearCalendar", CalendarSettingsLocators);

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
						return driver.findElement(By.xpath("//div[1]/div[2]/div/button[4]/span"));
					}
				});

				JsClick("NextYearCalendar", CalendarSettingsLocators);


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
			WebElement CalendarYear = getElement("CalendarYear", CalendarSettingsLocators);	
			explicitwaitclickable(CalendarYear);
			String CalendarMonth =  GetText("CalendarYear", CalendarSettingsLocators);		
			String	MonthValue = CalendarMonth.split(" ")[0];

			String Month = ReadFrom.Excel(Row, 0, Excel);

			if(IsEqual(MonthValue, Month) ) {
				Print("Month is selected");
				ExtentCucumberAdapter.addTestStepLog("Month is selected");

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
				JsClick("NextMonthCalendar", CalendarSettingsLocators);

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



	public static void SearchEvent() throws Throwable {

		PrintError("Search delivery started");
		ReadFrom.DynamicExcel(ReadFrom.SearchCalendarRequest);

		try {
			JsClick("SearchIcon", CalendarSettingsLocators);
			for(int SearchCalendarRequest =1; SearchCalendarRequest<=ReadFrom.rowcount; SearchCalendarRequest++)	{

				SearchMonth(SearchCalendarRequest, ReadFrom.SearchCalendarRequest);
				SearchYear(SearchCalendarRequest, ReadFrom.SearchCalendarRequest);


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


					TypeDataInTheField("Search", CalendarSettingsLocators, ReadFrom.Excel(SearchCalendarRequest, 2, ReadFrom.SearchCalendarRequest));
					ExtentCucumberAdapter.addTestStepLog(ReadFrom.Excel(SearchCalendarRequest, 2, ReadFrom.SearchCalendarRequest) + " is entered in the search bar");
					Print(ReadFrom.Excel(SearchCalendarRequest, 2, ReadFrom.SearchCalendarRequest) + " is entered in the search bar");

					Wait(6000);

					String DeliveryRequestName = ReadFrom.Excel(SearchCalendarRequest, 2, ReadFrom.SearchCalendarRequest);
					String Request = "(//div[contains(text(),'" + DeliveryRequestName + "')])[1]" ;

					WebElement Req = 	FindTheElement(Request);

					if(IsElementDisplayed(Req)) {
						Print("Displayed value is : " + DeliveryRequestName);
						ExtentCucumberAdapter.addTestStepLog("Displayed value is : " + DeliveryRequestName);
					}
					else
					{
						PrintError("Displayed value is : " + DeliveryRequestName);
						ExtentCucumberAdapter.addTestStepLog("Displayed value is : " + DeliveryRequestName);
					}
				}
				catch (Exception e) {
					Print(e.getMessage());
				}
				Wait(5000);
				Clear("Search", CalendarSettingsLocators);
				Wait(3000);
				JsClick("CloseSearch", CalendarSettingsLocators);
				ExtentCucumberAdapter.addTestStepLog("Clear search button is clicked");
				Print("Clear search button is clicked");


			}
		}
		catch (Exception e) {
			PrintError(e.getMessage());
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());
		}
	}


	public static void EditEvent() throws Throwable {

		ReadFrom.DynamicExcel(ReadFrom.EditCalendarRequest);
		Print("sss" + ReadFrom.rowcount);

		try {

			for(int CalendarEditRequest =1; CalendarEditRequest<=ReadFrom.rowcount; CalendarEditRequest++)	{

				SearchMonth(CalendarEditRequest, ReadFrom.EditCalendarRequest);
				SearchYear(CalendarEditRequest, ReadFrom.EditCalendarRequest);

				Wait(6000);
				Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
						.withTimeout(Duration.ofSeconds(120))
						.pollingEvery(Duration.ofSeconds(5))
						.ignoring(NoSuchElementException.class);


				fluentWait.until(new Function<WebDriver, WebElement>() {
					public WebElement apply(WebDriver driver) {
						return driver.findElement(By.xpath("(//div[@class='ng-star-inserted']//div//div//div[2]//img[1])"));
					}
				});
				int rowcount = SizeOfTheList("EditButton", CalendarSettingsLocators);
				Print("rowcount" + rowcount);

				for(int EditButton =1; EditButton<=rowcount; EditButton++)	{

					WebElement EquipmentList =	FindElement("RequestList" , CalendarSettingsLocators , EditButton);
					Print("EquipmentList" + EquipmentList);
					String EquipmentListList = 	GetTextFromTheElement(EquipmentList);
					Print(EquipmentListList);

					String EditIt =	ReadFrom.Excel(CalendarEditRequest, 2, ReadFrom.EditCalendarRequest);

					Print(EditIt);
					if(IsEqual(EquipmentListList, EditIt)) {

						Wait(15000);
						Print("yes");
						WebElement Edit =	FindElement("EditButtonList" ,CalendarSettingsLocators,  EditButton);
						//						
						Print("Edit " + EditButton);
						Click(Edit);


						///////////////////
						Wait<WebDriver> Description = new FluentWait<WebDriver>(driver)
								.withTimeout(Duration.ofSeconds(120))
								.pollingEvery(Duration.ofSeconds(5))
								.ignoring(NoSuchElementException.class);


						Description.until(new Function<WebDriver, WebElement>() {
							public WebElement apply(WebDriver driver) {
								return driver.findElement(By.xpath("//input[@placeholder='Description']"));
							}
						});

						if(IsElementDisplayed("Description", CalendarSettingsLocators)) {
							Print("Calendar request popup is opened");
							ExtentCucumberAdapter.addTestStepLog("Calendar request popup is opened");
						}

						Wait(2000);
						
						Clear("Description", CalendarSettingsLocators);
						TypeDataInTheField("Description", CalendarSettingsLocators, ReadFrom.Excel(CalendarEditRequest, 3, ReadFrom.EditCalendarRequest));
						Print("Description is entered as : " + ReadFrom.Excel(CalendarEditRequest, 3, ReadFrom.EditCalendarRequest));
						ExtentCucumberAdapter.addTestStepLog("Description is entered as : " + ReadFrom.Excel(CalendarEditRequest, 3, ReadFrom.EditCalendarRequest));


						Wait(2000);
						
//						if(getElement("FromHH", CalendarSettingsLocators).isEnabled()) {
//							
//						}
//						else {
//						JsClick("AllDay", CalendarSettingsLocators);
//						}
					//	JsClick("AllDay", CalendarSettingsLocators);
						String AllDay = ReadFrom.Excel(CalendarEditRequest, 4, ReadFrom.EditCalendarRequest);

						if(IsEqual(AllDay, "No")) {

							Wait(5000);
							Clear("FromHH", CalendarSettingsLocators);
							TypeDataInTheField("FromHH", CalendarSettingsLocators, ReadFrom.Excel(CalendarEditRequest, 5, ReadFrom.EditCalendarRequest));
							Print("From hrs is entered as : " + ReadFrom.Excel(CalendarEditRequest, 5, ReadFrom.EditCalendarRequest));
							ExtentCucumberAdapter.addTestStepLog("From hrs is entered as : " + ReadFrom.Excel(CalendarEditRequest, 5, ReadFrom.EditCalendarRequest));

							Wait(2000);
							Clear("FromMM", CalendarSettingsLocators);
							TypeDataInTheField("FromMM", CalendarSettingsLocators, ReadFrom.Excel(CalendarEditRequest, 6, ReadFrom.EditCalendarRequest));
							Print("From min is entered as : " + ReadFrom.Excel(CalendarEditRequest, 6, ReadFrom.EditCalendarRequest));
							ExtentCucumberAdapter.addTestStepLog("From min is entered as : " + ReadFrom.Excel(CalendarEditRequest, 6, ReadFrom.EditCalendarRequest));

							Wait(2000);
							String ExcelMeridian = ReadFrom.Excel(CalendarEditRequest, 7, ReadFrom.EditCalendarRequest);
							Print("eXCEL" + ExcelMeridian);
							String Meridian = GetText("FromMeridian", CalendarSettingsLocators);
							Print("WEB" + Meridian);
							if(IsEqual(Meridian, ExcelMeridian)) {


							}
							else {
								Wait(2000);
								Click("FromMeridian", CalendarSettingsLocators);
								Print("selected");
							}

							Wait(2000);
							Clear("EndHH", CalendarSettingsLocators);
							TypeDataInTheField("EndHH", CalendarSettingsLocators, ReadFrom.Excel(CalendarEditRequest, 8, ReadFrom.EditCalendarRequest));
							Print("To hrs is entered as : " + ReadFrom.Excel(CalendarEditRequest, 8, ReadFrom.EditCalendarRequest));
							ExtentCucumberAdapter.addTestStepLog("To hrs is entered as : " + ReadFrom.Excel(CalendarEditRequest, 8, ReadFrom.EditCalendarRequest));

							Wait(2000);
							Clear("EndMM", CalendarSettingsLocators);
							TypeDataInTheField("EndMM", CalendarSettingsLocators, ReadFrom.Excel(CalendarEditRequest, 9, ReadFrom.EditCalendarRequest));
							Print("To min is entered as : " + ReadFrom.Excel(CalendarEditRequest, 9, ReadFrom.EditCalendarRequest));
							ExtentCucumberAdapter.addTestStepLog("To min is entered as : " + ReadFrom.Excel(CalendarEditRequest, 9, ReadFrom.EditCalendarRequest));

							Wait(2000);
							String ExcelMeridian1 = ReadFrom.Excel(CalendarEditRequest, 10, ReadFrom.EditCalendarRequest);
							String Meridian1 = GetText("EndMeridian", CalendarSettingsLocators);
							if(IsEqual(Meridian1, ExcelMeridian1)) {


							}
							else {
								Wait(2000);
								Click("EndMeridian", CalendarSettingsLocators);				
							}
						}
						else if (IsEqual(AllDay, "Yes")) {
							Wait(2000);
							Click("AllDay", CalendarSettingsLocators);
							Print("All day option is selected");
							ExtentCucumberAdapter.addTestStepLog("All day option is selected");
						}

						Wait(2000);
						Click("StartDate", CalendarSettingsLocators);
						Print("Start date is clicked");
						ExtentCucumberAdapter.addTestStepLog("Start date is clicked");


						Wait(2000);

						Clear("StartDate", CalendarSettingsLocators);
						TypeDataInTheField("StartDate", CalendarSettingsLocators, ReadFrom.Excel(CalendarEditRequest, 11, ReadFrom.EditCalendarRequest));
						Print("Start date is entered as : " + ReadFrom.Excel(CalendarEditRequest, 11, ReadFrom.EditCalendarRequest));
						ExtentCucumberAdapter.addTestStepLog("Start date is entered as : " + ReadFrom.Excel(CalendarEditRequest, 11, ReadFrom.EditCalendarRequest));

						Wait(2000);
						Clear("ToDate", CalendarSettingsLocators);
						TypeDataInTheField("ToDate", CalendarSettingsLocators, ReadFrom.Excel(CalendarEditRequest, 12, ReadFrom.EditCalendarRequest));
						Print("To date is entered as : " + ReadFrom.Excel(CalendarEditRequest, 12, ReadFrom.EditCalendarRequest));
						ExtentCucumberAdapter.addTestStepLog("To date is entered as : " + ReadFrom.Excel(CalendarEditRequest, 12, ReadFrom.EditCalendarRequest));

						Wait(2000);
						Click("DeliveryCalendar", CalendarSettingsLocators);
						String DeliveryCalendar = ReadFrom.Excel(CalendarEditRequest, 13, ReadFrom.EditCalendarRequest);

						if(IsEqual(DeliveryCalendar, "No")) {


						}

						else if (IsEqual(DeliveryCalendar, "Yes")) {
							Wait(2000);
							Click("DeliveryCalendar", CalendarSettingsLocators);
							Print("Delivery calendar option is selected");
							ExtentCucumberAdapter.addTestStepLog("Delivery calendar option is selected");


						}

						Wait(2000);
						Click("CraneCalendar", CalendarSettingsLocators);
						String CraneCalendar = ReadFrom.Excel(CalendarEditRequest, 14, ReadFrom.EditCalendarRequest);

						if(IsEqual(CraneCalendar, "No")) {


						}

						else if (IsEqual(CraneCalendar, "Yes")) {
							Wait(2000);
							Click("CraneCalendar", CalendarSettingsLocators);
							Print("Crane calendar option is selected");
							ExtentCucumberAdapter.addTestStepLog("Crane calendar option is selected");

						}

						Wait(2000);
						SelectFromVisibleText("RecurrenceDropdown", CalendarSettingsLocators, ReadFrom.Excel(CalendarEditRequest, 15, ReadFrom.EditCalendarRequest));
						Print("Recurrence dropdown is selected as : " + ReadFrom.Excel(CalendarEditRequest, 15, ReadFrom.EditCalendarRequest));
						ExtentCucumberAdapter.addTestStepLog("Recurrence dropdown is selected as : " + ReadFrom.Excel(CalendarEditRequest, 15, ReadFrom.EditCalendarRequest));

						String RecurrenceDropdown = ReadFrom.Excel(CalendarEditRequest, 15, ReadFrom.EditCalendarRequest);
						switch (RecurrenceDropdown) {

						case "Does Not Repeat":

							Wait(2000);
							MoveToElement("SubmitButton", CalendarSettingsLocators);
							Click("SubmitButton", CalendarSettingsLocators);
							Print("Submit button is clicked");
							ExtentCucumberAdapter.addTestStepLog("Submit button is clicked");

							EventUpdatedPopup();
							break;

						case "Daily":

							Wait(2000);
							Clear("RepeatEveryCount", CalendarSettingsLocators);
							TypeDataInTheField("RepeatEveryCount", CalendarSettingsLocators, ReadFrom.Excel(CalendarEditRequest, 16, ReadFrom.EditCalendarRequest));
							Print("To date is entered as : " + ReadFrom.Excel(CalendarEditRequest, 16, ReadFrom.EditCalendarRequest));
							ExtentCucumberAdapter.addTestStepLog("To date is entered as : " + ReadFrom.Excel(CalendarEditRequest, 16, ReadFrom.EditCalendarRequest));

							Wait(2000);
							MoveToElement("SubmitButton", CalendarSettingsLocators);

							Click("SubmitButton", CalendarSettingsLocators);
							Print("Submit button is clicked");
							ExtentCucumberAdapter.addTestStepLog("Submit button is clicked");
							EventUpdatedPopup();
							break;

						case "Weekly":

							Wait(2000);
							Clear("RepeatEveryCount", CalendarSettingsLocators);
							TypeDataInTheField("RepeatEveryCount", CalendarSettingsLocators, ReadFrom.Excel(CalendarEditRequest, 16, ReadFrom.EditCalendarRequest));
							Print("To date is entered as : " + ReadFrom.Excel(CalendarEditRequest, 16, ReadFrom.EditCalendarRequest));
							ExtentCucumberAdapter.addTestStepLog("To date is entered as : " + ReadFrom.Excel(CalendarEditRequest, 16, ReadFrom.EditCalendarRequest));

							Wait(2000);
							MoveToElement("SubmitButton", CalendarSettingsLocators);

							Click("SubmitButton", CalendarSettingsLocators);
							Print("Submit button is clicked");
							ExtentCucumberAdapter.addTestStepLog("Submit button is clicked");
							EventUpdatedPopup();
							break;

						case "Monthly":

							Wait(2000);
							Clear("RepeatEveryCount", CalendarSettingsLocators);
							TypeDataInTheField("RepeatEveryCount", CalendarSettingsLocators, ReadFrom.Excel(CalendarEditRequest, 16, ReadFrom.EditCalendarRequest));
							Print("To date is entered as : " + ReadFrom.Excel(CalendarEditRequest, 16, ReadFrom.EditCalendarRequest));
							ExtentCucumberAdapter.addTestStepLog("To date is entered as : " + ReadFrom.Excel(CalendarEditRequest, 16, ReadFrom.EditCalendarRequest));

							if(IsEqual(CraneCalendar, "On day")) {						
								Click("OnDay", CalendarSettingsLocators);	
								Print("OnDay option is clicked");
								ExtentCucumberAdapter.addTestStepLog("OnDay option is clicked");
							}
							else if(IsEqual(CraneCalendar, "On the First")){						
								Click("OnFirstDay", CalendarSettingsLocators);
								Print("OnFirstDay option is clicked");
								ExtentCucumberAdapter.addTestStepLog("OnDay option is clicked");
							}

							MoveToElement("SubmitButton", CalendarSettingsLocators);

							Click("SubmitButton", CalendarSettingsLocators);
							Print("Submit button is clicked");
							ExtentCucumberAdapter.addTestStepLog("Submit button is clicked");

							EventUpdatedPopup();
							break;

						case "Yearly":	

							if(IsEqual(CraneCalendar, "On day")) {						
								Click("OnDay", CalendarSettingsLocators);	
								Print("OnDay option is clicked");
								ExtentCucumberAdapter.addTestStepLog("OnDay option is clicked");
							}
							else if(IsEqual(CraneCalendar, "On the First")){						
								Click("OnFirstDay", CalendarSettingsLocators);
								Click("OnFirstDay", CalendarSettingsLocators);
								Print("OnFirstDay option is clicked");
							}

							MoveToElement("SubmitButton", CalendarSettingsLocators);
							Click("SubmitButton", CalendarSettingsLocators);
							Print("Submit button is clicked");
							ExtentCucumberAdapter.addTestStepLog("Submit button is clicked");

							EventUpdatedPopup();
							break;

						default:


							Wait(2000);
						}

					///////////
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
}
