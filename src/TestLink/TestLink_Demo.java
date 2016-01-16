package TestLink;
import java.util.Arrays;

import testlink.api.java.client.TestLinkAPIClient;
import testlink.api.java.client.TestLinkAPIException;
import testlink.api.java.client.TestLinkAPIResults;

import org.junit.Test;


public class TestLink_Demo {
	public static String DEVKEY="d8283c67f63deb539308236cc3981d05";
	public static String URL="http://localhost/testlink/lib/api/xmlrpc/v1/xmlrpc.php";
	
	public static void reportResult(String TestProject,String TestPlan,String Testcase,String Build,String Notes,String Result) throws TestLinkAPIException{
		TestLinkAPIClient api=new TestLinkAPIClient(DEVKEY, URL);
		api.reportTestCaseResult(TestProject, TestPlan, Testcase, Build, Notes, Result);
		}
	

	
	@Test
	public void Test1()throws Exception
	{
		try
		{
		
		TestLink_Demo a = new TestLink_Demo();
		String testProject="Chrome_Testcases";
		String testPlan="ActiTime_Plan";
		String testCase="TC01_ActiTime_Login";
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

}
