package service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.TwitterEntity;

/**
 * Session Bean implementation class TwitterEJB
 */
@Stateless
@LocalBean
public class TwitterEJB {

	@PersistenceContext(unitName = "twitterer")
	private EntityManager em;
	
    /**
     * Default constructor. 
     */
    public TwitterEJB() {
        // TODO Auto-generated constructor stub
    }

    public void addNew(TwitterEntity twitterEntity)
    {
    	System.out.println("============================");
    	em.persist(twitterEntity);
    	System.out.println("============================");
    }
    
    public List<TwitterEntity> getTweets() {
		return new ArrayList<TwitterEntity>(
				em.createQuery("Select twt From twitter_tbl AS twt", TwitterEntity.class).getResultList());
	}
}
