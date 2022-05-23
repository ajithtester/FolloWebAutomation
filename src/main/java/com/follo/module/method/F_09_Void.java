package com.follo.module.method;

import java.time.Duration;
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

public class F_09_Void extends Baseclass {


	public static void SettingsButton() throws Throwable {

		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(120))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(ElementClickInterceptedException.class);


		fluentWait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.xpath("//span[contains(text(),'Delivery Calendar')]"));
			}
		});
	}

	public static void VoidList() throws Throwable {

		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(120))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(ElementClickInterceptedException.class);


		fluentWait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.xpath("//span[contains(text(),'Void List')]"));
			}
		});
	}

	public static void SearchVoid() throws Throwable {

		PrintError("Search void Started");
		ReadFrom.DynamicExcel(ReadFrom.SearchVoid);

		try {

			for(int Search =1; Search<=ReadFrom.rowcount; Search++)	{

				Click("SearchButton", VoidLocators);
				Wait(2000);

				TypeDataInTheField("Search", VoidLocators, ReadFrom.Excel(Search, 0, ReadFrom.SearchVoid));
				ExtentCucumberAdapter.addTestStepLog(ReadFrom.Excel(Search, 0, ReadFrom.SearchVoid) + " is entered in the search bar");
				Print(ReadFrom.Excel(Search, 0, ReadFrom.SearchVoid) + " is entered in the search bar");

				Wait(5000);


				int rowcount = 	SizeOfTheList("RequestNameList", VoidLocators);
				Print("No of request names displayed : " + rowcount);

				for(int Searchedrequest =1; Searchedrequest<=rowcount; Searchedrequest++)	{

					WebElement Request =	FindElement("RequestList", VoidLocators, Searchedrequest);
					String Requestname =	GetTextFromTheElement(Request);

					Wait(2000);

					String SearchedValue = ReadFrom.Excel(Search, 0, ReadFrom.SearchVoid);



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
				Clear("Search", VoidLocators);
				Wait(3000);
				Click("ClearSearch", VoidLocators);
				ExtentCucumberAdapter.addTestStepLog("Clear search button is clicked");
				Print("Clear search button is clicked");


			}
		}
		catch (Exception e) {
			PrintError(e.getMessage());
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());
		}
	}

	public static void FilterVoid() throws Throwable {

		PrintError("Filter void Started");
		ReadFrom.DynamicExcel(ReadFrom.FilterVoid);

		try {

			for(int Filter =1; Filter<=ReadFrom.rowcount; Filter++)	{

				Click("FilterIcon", VoidLocators);
				ExtentCucumberAdapter.addTestStepLog("Filter icon is clicked");
				Print("Filter icon is clicked");
				Wait(6000);


				SelectFromVisibleText("EquipmentInFilter", VoidLocators, ReadFrom.Excel(Filter, 0, ReadFrom.FilterVoid));
				ExtentCucumberAdapter.addTestStepLog("Equipment is selected as : " + ReadFrom.Excel(Filter, 0, ReadFrom.FilterVoid));
				Print("Equipment is selected as : " + ReadFrom.Excel(Filter, 0, ReadFrom.FilterVoid));

				Click("FilterApply", VoidLocators);
				ExtentCucumberAdapter.addTestStepLog("Filter apply button is clicked");
				Print("Filter apply button is clicked");
				Wait(3000);

				int rowcount = 	SizeOfTheList("RequestNameList", VoidLocators);
				Print("No of Request displayed : " + rowcount);


				for(int RequestLists =1; RequestLists<=rowcount; RequestLists++)	{

					WebElement Request =	FindElement("RequestList" , VoidLocators, RequestLists );
					String RequestName =	GetTextFromTheElement(Request);

					Wait(2000);

					String FilteredValue = ReadFrom.Excel(Filter, 0, ReadFrom.FilterVoid);


					if(	IsEqual(RequestName, FilteredValue)) {

						Wait(2000);
						Print("Displayed value is : " + RequestName);
						ExtentCucumberAdapter.addTestStepLog("Displayed value is : " + RequestName);
						Wait(3000);

					}
					else {
						PrintError("Displayed value is : " + RequestName);
						ExtentCucumberAdapter.addTestStepLog("Displayed value is : " + RequestName);
					}


				}
				JsClick("FilterIcon", VoidLocators);
				ExtentCucumberAdapter.addTestStepLog("Filter icon button is clicked");
				Print("Filter icon button is clicked");

				Wait(3000);
				JsClick("FilterReset", VoidLocators);
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

	public static void RestoreDelivery() throws Throwable {
		PrintError("Restore delivery Started");
		ReadFrom.DynamicExcel(ReadFrom.Restore);
		try {

			for(int RestoreDelivery =1; RestoreDelivery<=ReadFrom.rowcount; RestoreDelivery++)	{

				Print("No of excel : " + ReadFrom.rowcount);
				int rowcount = 	SizeOfTheList("RequestNameList", VoidLocators);
				

				for(int RestoreButton =1; RestoreButton<=rowcount; RestoreButton++)	{

					WebElement RestoreRequest =	FindElement("RequestList", VoidLocators, RestoreButton);

					String RestoreRequestName = 	GetTextFromTheElement(RestoreRequest);

					

					String Restore =	ReadFrom.Excel(RestoreDelivery, 0, ReadFrom.Restore);
					Print(Restore);

					if(IsEqual(RestoreRequestName, Restore)) {

						Wait(2000);

						WebElement RestoreCheckBox =	FindElement("RestoreRequest" ,VoidLocators, RestoreButton);
						Click(RestoreCheckBox);
						Wait(2000);
						Print("Selected request is : " + ReadFrom.Excel(RestoreDelivery, 0, ReadFrom.Restore));
						ExtentCucumberAdapter.addTestStepLog("Selected request is : " + ReadFrom.Excel(RestoreDelivery, 0, ReadFrom.Restore));

					}
				}
			}
			Wait(2000);
			Click("RestoreButton", VoidLocators);
			Wait(2000);
			Click("YesRestore", VoidLocators);
			ExtentCucumberAdapter.addTestStepLog("Request is selected and yes restore button is clicked");
			Print("Request is selected and yes restore button is clicked");

			Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(120))
					.pollingEvery(Duration.ofSeconds(5))
					.ignoring(NoSuchElementException.class);

			fluentWait.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					return driver.findElement(By.xpath("//div[@aria-label='Request Restored Successfully.']"));
				}
			});

			if(IsElementDisplayed("RestoredSuccessfully", VoidLocators)){
				Click("RestoredSuccessfully", VoidLocators);
				Print("Request restore is successfull");
				ExtentCucumberAdapter.addTestStepLog("Request restore is successfull");

			}else {
				PrintError("Request restore is not successfull");
				ExtentCucumberAdapter.addTestStepLog("Request restore is not successfull");

				Wait(3000);



			}

		}
		catch (Exception e) {
			PrintError(e.getMessage());
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());
		}
	}

}


