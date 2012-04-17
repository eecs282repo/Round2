package controllers;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import models.Auction;
import models.Tag;
import play.data.validation.Required;

public class Auctions extends CRUD {
	
	public static void form() {
		render();
	}

	/**
	 * Creates the individual auction page, for Views, see Application/getAuction.html
	 * @param id
	 */
	public static void show(Long id) {
		Auction auction = Auction.findById(id);
		render(auction);
	}
		
	/**
	 * Creates an auction from a post request.
	 * @param name
	 * @param tags
	 * @param description
	 * @param image
	 * @param price
	 */
	public static void save(@Required String name, String tags, 
			@Required String description, String image, double price) {
		
		Auction auction = new Auction();
		auction.name = name;
		auction.description = description;
		auction.price = price;
		auction.image = image;
		auction.tags = new TreeSet<Tag>();
		
		String[] tagsArray = tags.split(",");
		for(String tagstring : tagsArray){
			Tag mytag = Tag.findIncOrCreateByName(tagstring);
			if(mytag!=null){
				auction.tags.add(mytag);
			}
			mytag.save();
		}
		auction.save();
		show(auction.id);
	}

}
