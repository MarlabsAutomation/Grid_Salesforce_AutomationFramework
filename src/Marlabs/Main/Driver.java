package Marlabs.Main;

import Marlabs.Constants.Constants;
import Marlabs.Core.Xls_Reader;
import Marlabs.Drivers.ExecuteThread;
import Marlabs.Objects.OR;

public class Driver extends ExecuteThread{
	
	
	public static void main(String[] args) throws InterruptedException {
		
		//Initialize the excel and get the configured values
		Xls_Reader excel = new Xls_Reader(Constants.TestSuitePath);
		
		//Selected suite
		Constants.SelectedSuite=excel.getCellData(Constants.TestSuiteSheetname, 1, 3);
		
		//Generate Run ID and add Test cases flagged yes
		flaggedTestCases();
		//System.out.println("Suite Name "+Constants.SelectedSuite);
		
		//get the value for IE browser
		Constants.IE = excel.getCellData(Constants.TestSuiteSheetname, 1, 2);
		//get the value for Chrome browser
		Constants.Chrome =excel.getCellData(Constants.TestSuiteSheetname, 2, 2);
		//get the value for Firefox browser
		Constants.Firefox =excel.getCellData(Constants.TestSuiteSheetname, 3, 2);		
		//Safari browser
		Constants.Safari =excel.getCellData(Constants.TestSuiteSheetname, 5, 2);		
		//get the value for Firefox browser
		Constants.Mobile =excel.getCellData(Constants.TestSuiteSheetname, 4, 2);
		//get the type of framework selected
		Constants.SelectedFramework =excel.getCellData(Constants.TestSuiteSheetname, 2, 3);
		
		//Get all the objects from Excel and store it an array
		OR.storeObjects();
		
		//Start the browser instance based on selected options.
		execute(Constants.IE,Constants.Chrome,Constants.Firefox, Constants.Safari, Constants.Mobile);
		
	}
	
}
