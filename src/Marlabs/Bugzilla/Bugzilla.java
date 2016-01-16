package Marlabs.Bugzilla;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.apache.commons.httpclient.HttpClient;
import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;
import org.apache.xmlrpc.client.XmlRpcCommonsTransportFactory;

import Marlabs.Constants.Constants;


public class Bugzilla {

	public static void main(String[] args) throws MalformedURLException {
				
		/*bug("Summary - Automation execution", "Description");
				
		System.out.println("Success");*/

	}
	
	
	private static XmlRpcClient initClient(){
		
        HttpClient httpClient = new HttpClient();
        XmlRpcClient rpcClient = new XmlRpcClient();
        XmlRpcCommonsTransportFactory factory = new XmlRpcCommonsTransportFactory(rpcClient);
        XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
		
        factory.setHttpClient(httpClient);
        rpcClient.setTransportFactory(factory);
        try {
			config.setServerURL(new URL(Constants.Bug_URL));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        rpcClient.setConfig(config);
		
        
       /* 
		XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
		URL urlobj = new URL(Constants.Bug_URL + "/xmlrpc.cgi");
		if(urlobj.getHost() == null) throw new MalformedURLException();
		config.setServerURL(urlobj);
			XmlRpcClient client = new XmlRpcClient();
	       XmlRpcCommonsTransportFactory transportFactory = new XmlRpcCommonsTransportFactory(client);
	       // set the HttpClient so that we retain cookies
	       transportFactory.setHttpClient(new HttpClient());
	       client.setTransportFactory(transportFactory);
	       client.setConfig(config);*/
	       
	       return rpcClient;
	}
	
	public static String login() throws MalformedURLException, XmlRpcException{
		String token = null;
		
        XmlRpcClient rpcClient = initClient();
        //Login
        ArrayList<Object> params = new ArrayList<Object>();
        Hashtable<String, Object> executionData = new Hashtable<String, Object>();
        executionData.put("login", Constants.Bug_UN);
        executionData.put("password", Constants.Bug_PW);
        executionData.put("remember", true);
        params.add(executionData);
        
        HashMap result = (HashMap) rpcClient.execute("User.login", params);
        System.out.println("Results: "+result);
        token  = (String) result.get("token");
        System.out.println("Bugzilla_token: "+token);
		
		return token;
	}
	
	public static void bug(String summary, String desc) throws MalformedURLException {
	    try {
	        XmlRpcClient rpcClient = initClient();
	        //Login
	        String Bugzilla_token = login();
	        
	        //Bug creation
	        ArrayList<Object> params = new ArrayList<Object>();
	        Hashtable<String, Object> executionData = new Hashtable<String, Object>();
	               
	        executionData.put("Bugzilla_token", Bugzilla_token);
	        executionData.put("product", Constants.Bug_Product);
	        executionData.put("component", Constants.Bug_Component);
	        executionData.put("version", Constants.Bug_Version);
	        executionData.put("op_sys", Constants.Bug_OS);
	        executionData.put("platform", Constants.Bug_Platform);
	        executionData.put("priority", Constants.Bug_Priority);
	        executionData.put("severity", Constants.Bug_Severity);
	        executionData.put("summary", summary);
	        executionData.put("description", desc);
	        
	        params.add(executionData);
	        
	        HashMap result = (HashMap) rpcClient.execute("Bug.create", params);
	        
	        int BugID = (Integer) result.get("id");
	        System.out.println("Bug ID: "+BugID);
	        //return result1;
	        
	    } catch (XmlRpcException e) {
	        e.printStackTrace();
	    }
	    //return null;
	}
}
