package models;

import java.util.List;

import javax.persistence.*;

import play.db.jpa.Model;

@Entity
public class Bid extends Model {
	
	
	public double offer;
	public String email;

	@OneToMany(mappedBy="bid", cascade=CascadeType.ALL)
	public List<Message> messages;
	
	@ManyToOne
	public Auction auction;
	/*
	@ManyToOne
	public Account account;
	*/
	
	public String toString(){
		return "$"+offer + "  Contact: " + email;
	}
}
