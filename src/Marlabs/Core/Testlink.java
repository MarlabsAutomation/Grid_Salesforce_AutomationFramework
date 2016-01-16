package Marlabs.Core;
import org.apache.bcel.classfile.Constant;

import Marlabs.Constants.Constants;
import TestLink.TestLink_Demo;
import testlink.api.java.client.TestLinkAPIClient;
import testlink.api.java.client.TestLinkAPIException;
import testlink.api.java.client.TestLinkAPIResults;
public class Testlink {
	
	public static void reportResult
	(String TestProject,String TestPlan,String Testcase,String TestSuite,String Build,String Notes,String Result) throws TestLinkAPIException{
		TestLinkAPIClient api=new TestLinkAPIClient(Constants.DEVKEY, Constants.testlinkURL);
		api.reportTestCaseResult(TestProject, TestPlan,Testcase,TestSuite,Build,Result);
		}

	public static void MobileTestPass(String currentTCName,String testresult)throws Exception
	{
		try
		{
			    TestLink_Demo a = new TestLink_Demo();
				String testProject="Web_Browser";
				String testPlan="ActiTime_Plan";
				String TestSuite="Mobile_Scenarios";
				String testCase=currentTCName;
				String build="Build_001";
				String notes=null;
				String result=null;
		
		result= TestLinkAPIResults.TEST_PASSED;
		notes="Executed successfully";

		a.reportResult(testProject, testPlan, testCase, build, notes, result);
		System.out.println("TL:Pass");
		}
		catch (Exception e)
		{
			System.out.println("TL:Fail");
			System.out.println(e);
		}
		
	}
	public static void MobileTestFail(String currentTCName,String testresult)throws Exception
	{
		try
		{
		
			   TestLink_Demo a = new TestLink_Demo();
				String testProject="Web_Browser";
				String testPlan="ActiTime_Plan";
				String TestSuite="Mobile_Scenarios";
				String testCase=currentTCName;
				String build="Build_001";
				String notes=null;
				String result=null;
		
		result= TestLinkAPIResults.TEST_FAILED;
		notes="Executed successfully";

		a.reportResult(testProject, testPlan, testCase, build, notes, result);
		
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		
	}
	public static void Testpass(String Browser,String currentTCName,String testresult)throws Exception
	{
		//String Web_Browser="Web_Browser";
		String Web_Browser="Sales_Force";
		try
		{
			if(Browser.contains("Chrome")){
		            TestLink_Demo a = new TestLink_Demo();
					String testProject=Web_Browser;
					String testPlan="ActiTime_Plan";
					String testCase=currentTCName;
					String TestSuite="Chrome_Browser";
					String build="Build_001";
					String notes=null;
					String result=null;
					
					result= TestLinkAPIResults.TEST_PASSED;
					notes="Executed successfully";

					a.reportResult(testProject, testPlan, testCase, build, notes, result);
					System.out.println("testlinkpass");
					
					}
					else if(Browser.contains("IE")) {
						TestLink_Demo a = new TestLink_Demo();
						String testProject=Web_Browser;
						String testPlan="ActiTime_Plan";
						String TestSuite="IE_Browser";
						String testCase=currentTCName;
						String build="Build_001";
						String notes=null;
						String result=null;
						
						result= TestLinkAPIResults.TEST_PASSED;
						notes="Executed successfully";

						a.reportResult(testProject, testPlan, testCase, build, notes, result);
						System.out.println("testlinkpass");
						
					}
					else if(Browser.contains("FE"))
					{
						TestLink_Demo a = new TestLink_Demo();
						String testProject=Web_Browser;
						String testPlan="ActiTime_Plan";
						String TestSuite="Firefox_Browser";
						String testCase=currentTCName;
						String build="Build_001";
						String notes=null;
						String result=null;
						
						result= TestLinkAPIResults.TEST_PASSED;
						notes="Executed successfully";

						a.reportResult(testProject, testPlan, testCase, build, notes, result);
						System.out.println("testlinkpass");		
					}
					else
					{
						TestLink_Demo a = new TestLink_Demo();
						String testProject=Web_Browser;
						String testPlan="ActiTime_Plan";
						String TestSuite="Safari_Browser";
						String testCase=currentTCName;
						String build="Build_001";
						String notes=null;
						String result=null;
						
						result= TestLinkAPIResults.TEST_PASSED;
						notes="Executed successfully";

						a.reportResult(testProject, testPlan, testCase, build, notes, result);
						System.out.println("testlinkpass");	
						
					}
		}
		
		
		catch (Exception e)
		{
			System.out.println(e);
		}
			}
		

	
	public static void Testfail(String Browser,String currentTCName,String testresult)throws Exception
	{
		//String Web_Browser="Web_Browser";
		 String Web_Browser="Sales_Force";
		try
		{
			if(Browser.contains("Chrome")){
				 TestLink_Demo a = new TestLink_Demo();
					String testProject=Web_Browser;
					String testPlan="ActiTime_Plan";
					String testCase=currentTCName;
					String TestSuite="Chrome_Browser";
					String build="Build_001";
					String notes=null;
					String result=null;
					
					result= TestLinkAPIResults.TEST_FAILED;
					notes="Executed successfully";

					a.reportResult(testProject, testPlan, testCase, build, notes, result);
					System.out.println("Testlink Fail");
					
					}
					else if(Browser.contains("IE")) {
						TestLink_Demo a = new TestLink_Demo();
						String testProject=Web_Browser;
						String testPlan="ActiTime_Plan";
						String TestSuite="IE_Browser";
						String testCase=currentTCName;
						String build="Build_001";
						String notes=null;
						String result=null;
						
						result= TestLinkAPIResults.TEST_FAILED;
						notes="Executed successfully";

						a.reportResult(testProject, testPlan, testCase, build, notes, result);
						System.out.println("testlink Fail");
						
						
					}
					else if(Browser.contains("FE"))
					{
						TestLink_Demo a = new TestLink_Demo();
						String testProject=Web_Browser;
						String testPlan="ActiTime_Plan";
						String TestSuite="Firefox_Browser";
						String testCase=currentTCName;
						String build="Build_001";
						String notes=null;
						String result=null;;
						
						result= TestLinkAPIResults.TEST_FAILED;
						notes="Executed successfully";

						a.reportResult(testProject, testPlan, testCase, build, notes, result);
						System.out.println("testlink Fail");		
					}
					else
					{
						TestLink_Demo a = new TestLink_Demo();
						
						String testProject=Web_Browser;
						String testPlan="ActiTime_Plan";
						String TestSuite="Safari_Browser";
						String testCase=currentTCName;
						String build="Build_001";
						String notes=null;
						String result=null;
						
						result= TestLinkAPIResults.TEST_FAILED;
						notes="Executed successfully";

						a.reportResult(testProject, testPlan, testCase, build, notes, result);
						System.out.println("testlink Fail");	
						
					}
		}
		
		
		catch (Exception e)
		{
			System.out.println(e);
		}
}
	
	
	
}