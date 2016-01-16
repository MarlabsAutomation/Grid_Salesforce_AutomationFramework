package Marlabs.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import twitter4j.Status;
import twitter4j.StatusUpdate;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

public class Twitter4J {

	static String consumerKeyStr = "tCIO0awVx28E9i5DPGH4w8d1Y";
	static String consumerSecretStr = "L9TSCVnxEV4d2AR55fx2fNoNfQm8fR33ZVY6uQHg29vvi3o1NC";
	static String accessTokenStr = "3888074957-iota0JX4yXM4srwFBGea006yXyCpyIGaj9YJoUD";
	static String accessTokenSecretStr = "OY0lSYxbqfbX4X2ZTByXkKCQtF8vOJ6BmxnypuWLk0nFr";

	public static void main(String[] args) throws MalformedURLException, IOException {

		try {

			Twitter twitter = new TwitterFactory().getInstance();

			twitter.setOAuthConsumer(consumerKeyStr, consumerSecretStr);

			AccessToken accessToken = new AccessToken(accessTokenStr,
					accessTokenSecretStr);

			twitter.setOAuthAccessToken(accessToken);

			
	        StatusUpdate statusUpdate = new StatusUpdate(
	                //your tweet or status message
	                " Webinar || Mobile testing strategies ||by Siva Vanapalli and Sriharsha Kumar" +
	                " || http://www.marlabs.com/mobile-testing-strategy-webinar");
	        
	        //attach any media, if you want to
	        statusUpdate.setMedia(
	                //title of media
	                "http://h1b-work-visa-usa.blogspot.com"
	                , new URL("http://www.marlabs.com/sites/default/files//logo_0.png").openStream());

	        //tweet or update status
	        Status status = twitter.updateStatus(statusUpdate);

			//twitter.updateStatus("This new update - New status");

			System.out
					.println("Successfully updated the status in Twitter."+status);
			
			
		} catch (TwitterException te) {

			te.printStackTrace();
		}
	}
}
