package controllers;

import java.util.List;

import models.Auction;
import models.Bid;
//import models.Tag;
import play.mvc.Controller;

/**
 * 
 * @author Yutong Wang
 *
 */
public class Shop extends Controller {
	public static void index() {
		render();
	}
	
	/**
	 * Creates an auction
	 */
	public static void createAuction() {
		Auction auction = new Auction();
		// TODO: Get the parameters
		auction.save();
		render(auction);
	}
	
	/**
	 * Creates a bid
	 */
	public static void createBid() {
		Bid bid = new Bid();
		bid.save();
		render(bid);
	}
	
	/**
	 * Gets a list of recently entered queries from all users
	 */
	public static void getRecentQueries() {
		render();
	}
	
	/**
	 * Searches for an item
	 */
	public static void searchItem() {
		// TODO: Renders the search result
		render();
	}
	
	/**
	 * Search for category based on input string, SQL "WHERE category.name LIKE searchString"
	 */
//	public static void searchTag(String q) {
//		List<Tag> categories = Tag.findByString(q);
//		render(categories);
//	}
//	
	/**
	 * Renders a list of the most popular categories
	 */
	public static void getPopularCategories(){
		render();
	}


}