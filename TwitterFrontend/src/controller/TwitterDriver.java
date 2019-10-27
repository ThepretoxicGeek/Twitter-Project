package controller;

import java.io.IOException;

import javax.servlet.ServletException;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

public class TwitterDriver {
	
	private Twitter twitter;
	private Status status;
	
	public void tweetOut(String message) throws ServletException, TwitterException {
		twitter = TwitterFactory.getSingleton();
		twitter.setOAuthConsumer("zK2pnuTXz4XELKA50Sn64pIXJ", "XFGBQGt7RJw16eJ4xilWYZVXJSIhPbgVfDJyFHhlhK7a0DwAuZ");
		AccessToken accessToken = new AccessToken("1177360425576534016-QjD9Q4DbnAnLXoSwPZkF9A4veABpOu","JlmqDuVHwbTTc38CXCYwAvurfDq1ukxnzyjVMmN9uSh1P");		
		twitter.setOAuthAccessToken(accessToken);
		
		status = twitter.updateStatus(message);
	}

	public Long getTweetID() {
		return status.getId();
	}
}
