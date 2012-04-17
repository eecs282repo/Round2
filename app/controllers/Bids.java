package controllers;

import models.Auction;
import models.Bid;
import play.data.validation.Required;

public class Bids extends CRUD {
	/**
	 * Creates a bid
	 */
	public static void createBid(Long auction_id, @Required double ammount) {
		Auction auction = Auction.findById(auction_id);
		if(validation.hasErrors()) {
			Auctions.show(auction_id);
		}
		Bid bid = new Bid();
		bid.offer = ammount;
		bid.auction = auction;
		bid.save();
		
		auction.bids.add(bid);
		auction.save();
		Auctions.show(auction_id);
	}
}
