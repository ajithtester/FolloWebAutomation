package com.follo.excel.read;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.follo.baseclass.Baseclass;

public class ReadFrom extends Baseclass {


	//public static String ExcelData = "./src/test/resources/ExcelFile/Follo_WebApp_Datas.xlsx";
	public static String ExcelData = "./TestData/Follo_WebApp_Datas.xlsx" ;
	
	public static  int rowcount;
	public static  int colcount;
	public static XSSFWorkbook Workbook;
	public static XSSFSheet Sheet;

	public static String Register = "Register";
	public static String Login = "Login"; 
	public static String AddDFOW = "AddDFOW";
	public static String DeleteDFOW = "DeleteDFOW";
	public static String EditDFOW  = "EditDFOW";
	public static String SearchDFOW  = "SearchDfow";
	public static String AddCompany  = "AddCompany";
	public static String AddCompanyDfow  = "AddCompanyDfow";
	public static String SearchCompany  = "SearchCompany";
	public static String DeleteCompany  = "DeleteCompany";
	public static String EditCompanyDetails  = "EditCompanyDetails";
	public static String FilterCompany  = "FilterCompany";  
	public static String InviteMembers  = "InviteMembers";
	public static String SearchMembers  = "SearchMembers";
	public static String FilterMembers  = "FilterMembers";
	public static String DeleteMembers  = "DeleteMembers";
	public static String EditMembers  = "EditMembers";
	public static String AddGates  = "AddGates"; 
	public static String EditGates  = "EditGates"; 
	public static String DeleteGates  = "DeleteGates"; 
	public static String SearchGates  = "SearchGates"; 
	public static String AddEquipment  = "AddEquipment";
	public static String EditEquipment  = "EditEquipment";
	public static String FilterEquipment  = "FilterEquipment";
	public static String SearchEquipment  = "SearchEquipment";
	public static String DeleteEquipment  = "DeleteEquipment";
	public static String AddDelivery  = "AddDelivery";
	public static String SearchDelivery  = "SearchDelivery";
	public static String FilterDelivery  = "FilterDelivery";
	public static String EditDelivery  = "EditDelivery";
	public static String Void  = "Void";
	public static String SearchVoid  = "SearchVoid";
	public static String FilterVoid  = "FilterVoid";
	public static String Restore  = "Restore";
	public static String ViewDelivery  = "ViewDelivery";
	public static String Comments  = "Comments";
	public static String ViewHistory  = "ViewHistory";
	public static String DeliverRequest  = "DeliverRequest";
	public static String ApproveOrReject  = "ApproveOrReject";
	public static String AllDeliverRequest  = "AllDeliverRequest";
	public static String SearchRequest  = "SearchRequest";
	public static String FilterRequest  = "FilterRequest";
	public static String EditRequest  = "EditRequest";
	public static String ViewRequest  = "ViewRequest";
	public static String AddComment  = "AddComment";
	public static String ViewRequestHistory  = "ViewRequestHistory";
	public static String Deliver  = "Deliver";
	public static String ApproveReject  = "ApproveReject";
	public static String VoidRequest  = "VoidRequest";
	public static String EditQueuedRequest  = "EditQueuedRequest";
	public static String DeleteQueuedRequest  = "DeleteQueuedRequest";
	public static String SearchQueuedRequest  = "SearchQueuedRequest";
	public static String FilterQueuedRequest  = "FilterQueuedRequest";
	public static String SaveQueuedRequest  = "SaveQueuedRequest";
	public static String CalendarRequest  = "CalendarRequest";
	public static String SearchCalendarRequest  = "SearchCalendarRequest";
	public static String EditCalendarRequest  = "EditCalendarRequest";
	public static String CraneCalendar  = "CraneCalendar";
	public static String ViewCraneCalendar  = "ViewCraneCalendar";
	public static String EditCraneCalendar  = "EditCraneCalendar";
	public static String FilterCraneCalendar  = "FilterCraneCalendar";
	public static String AddCraneRequest  = "AddCraneRequest";
	public static String ViewCraneRequest  = "ViewCraneRequest";
	public static String EditCraneRequest  = "EditCraneRequest";
	public static String FilterCraneRequest  = "FilterCraneRequest";
	public static String SearchCraneRequest  = "SearchCraneRequest";
	public static String VoidCraneRequest  = "VoidCraneRequest";
	public static String CompleteCrane  = "CompleteCrane";
	public static String CraneApproveReject  = "CraneApproveReject";
	
	//public static String UploadDfowFile = "./follo_web_automation-master/TestData/Automation Testing _149_1651043152623.xlsx";
	public static String UploadDfowFile = "C:\\Users\\ajithkumar.j\\Downloads\\follo_web_automation_script\\follo_web_automation-master\\TestData\\DFOW_Export_1648727904962.xlsx";
	public static String UploadCompanyFile = "D:/Automation Testing _149_1651043152623.xlsx";


	public static String Excel(int row, int col, String sheetname) throws Throwable {


		File file = new File(ExcelData);
		FileInputStream fileread = new FileInputStream(file);
		Workbook workbook = WorkbookFactory.create(fileread);
		Sheet sheet = workbook.getSheet(sheetname);
		Row rownumber = sheet.getRow(row);
		Cell value = rownumber.getCell(col);
		String data = value.toString();
		return data;
	}

	public static  int DynamicExcel( String Sheetname) throws Throwable {

		FileInputStream fileread = new FileInputStream(ExcelData);

		Workbook = new XSSFWorkbook(fileread);
		Sheet = Workbook.getSheet(Sheetname);
		rowcount = Sheet.getLastRowNum();
		return rowcount;

	}
}



