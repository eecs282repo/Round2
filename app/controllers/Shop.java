package controllers;

import java.util.List;

import models.Auction;
import models.Bid;
import models.Item;
import models.Tag;
import play.data.validation.Required;
import play.mvc.Controller;

/**
 * 
 * @author Yutong Wang
 *
 */
public class Shop extends Controller {
	
	public static void index() {
		renderJSON(Item.findAll());
	}
	
	public static void itemSearch() {
		render();
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
	public static void searchItem(String q) {
		// TODO: Add spaces between the strings so that you can union stuff
		
		List<Item> items = Item.find("lower(name) like ?", '%' + q.toLowerCase() + '%').fetch();
//		if(items.size()==0){
//			Item e = new Item();
//			e.name = "Item not found";
//			items.add(e);
//		}
		render(items);
	}
	
	/**
	 * Search for category based on input string, SQL "WHERE category.name LIKE searchString"
	 */
//	public static void searchTag(String itemName) {
//		List<Tag> categories = Tag.findByString(itemName);
//		render(categories);
//	}
	
	/**
	 * Renders a list of the most popular categories
	 */
//	public static void getPopularCategories(){
//		render();
//	}


}