package controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.ws.rs.GET;

import org.hibernate.validator.constraints.URL;

import entities.TwitterEntity;
import model.Twitterer;
import service.TwitterEJB;

@ApplicationScoped
@ManagedBean(name = "twittercontroller")
public class TwitterController {
	
	@EJB
	private TwitterEJB twitterEJB;

	@ManagedProperty(value="#{twitterer}")
	private Twitterer twitterer;
	
	public Twitterer getTwitterer() {
		return twitterer;
	}

	public void setTwitterer(Twitterer twitterer) {
		this.twitterer = twitterer;
	}

	private TwitterDriver driver = new TwitterDriver();

	private List<TwitterEntity> tweetList = new ArrayList<>();

	public List<TwitterEntity> getTweetList() {
		tweetList = twitterEJB.getTweets();
		return tweetList;
	}

	public String viewTweets() {
		return "tweetsList.xhtml";
	}

	@GET
	@URL()
	public String addNewTweet() {
		Date date = new Date();
		Timestamp timestamp = new Timestamp(date.getTime());
		
		tweet();
		
		twitterEJB.addNew(twitterer.getEntity(driver.getTweetID(), timestamp));
		
		return viewTweets();
	}

	public Twitterer getTweets() {
		return twitterer;
	}

	public void setTweetList(List<TwitterEntity> tweetList) {
		this.tweetList = tweetList;
	}
	
	
	private void tweet() {
		try
		{
			driver.tweetOut(twitterer.getTweetBody());
		}  catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}