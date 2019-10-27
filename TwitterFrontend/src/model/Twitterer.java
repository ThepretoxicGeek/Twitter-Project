package model;

import java.sql.Timestamp;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import entities.TwitterEntity;

@ManagedBean(name = "twitterer")
@ApplicationScoped
public class Twitterer {

	private Timestamp timestamp;
	private String tweetBody;
	
	private Long tweetID;

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public String getTweetBody() {
		return tweetBody;
	}

	public void setTweetBody(String tweetBody) {
		this.tweetBody = tweetBody;
	}

	public Long getTweetID() {
		return tweetID;
	}

	public void setTweetID(Long tweetID) {
		this.tweetID = tweetID;
	}
	
	public TwitterEntity getEntity(Long _tweetID, Timestamp _timestamp) {
		TwitterEntity twitterEntity = new TwitterEntity();
		twitterEntity.setTimestamp(_timestamp);
		twitterEntity.setTweetBody(tweetBody);
		twitterEntity.setTweetID(_tweetID);
		return twitterEntity;
	}
}
