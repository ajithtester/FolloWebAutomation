package com.follo.enginerunner;                

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},

//tags = "@Regression", 	

//tags = "@Register" ,
tags = "@Login",

//tags = "@Error" ,

//tags = "@SP4" ,

features = {"Features_SP1" , "Features_SP2", "Features_SP3", "Features_SP4" , "Features_SP5"}, 
glue = {"com\\follo\\stepdefinition\\sp1", "com\\follo\\stepdefinition\\sp2", "com\\follo\\stepdefinition\\sp3", "com\\follo\\stepdefinition\\sp4" , "com.follo.stepdefinition.sp5" ,"\\com\\follo\\Hooks"}, 

dryRun= false)
public class EngineRunner extends AbstractTestNGCucumberTests {

}














