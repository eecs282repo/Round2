package models;

import javax.persistence.*;

import play.db.jpa.Model;

public class Bid extends Model {
	public double offer;
	public String email;
	//public User user;
	
	@ManyToOne
	public Auction auction;
	
	public String toString(){
		return "$"+offer;
	}
}
