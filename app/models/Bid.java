package models;

import java.util.List;

import javax.persistence.*;

import play.db.jpa.Model;

@Entity
public class Bid extends Model {
	
	
	public double offer;
	public String email;

	@ManyToOne
	public Account account;
	
	@OneToMany(mappedBy="bid", cascade=CascadeType.ALL)
	public List<Message> messages;
	
	@ManyToOne
	public Auction auction;
	
	public String toString(){
		return "$"+offer;
	}
}
