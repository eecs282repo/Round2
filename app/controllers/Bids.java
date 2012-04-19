package controllers;

import models.Auction;
import models.Bid;
import play.data.validation.Required;

public class Bids extends CRUD {
	/**
	 * Creates a bid
	 */
	public static void createBid(Long auction_id, @Required double ammount, String email) {
		Auction auction = Auction.findById(auction_id);
		if(validation.hasErrors()) {
			Auctions.view(auction_id);
		}
		Bid bid = new Bid();
		bid.offer = ammount;
		bid.auction = auction;
		bid.email = email;
		bid.save();
		
		auction.bids.add(bid);
		auction.save();
		Auctions.view(auction_id);
	}
}
