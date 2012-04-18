package models;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import play.data.validation.MaxSize;
import play.data.validation.Required;
import play.db.jpa.Model;

@Entity
public class Auction extends Model{
	
	
	@Required
	public String name;
	
	@OneToMany(mappedBy="auction", cascade=CascadeType.ALL)
	public List<Bid> bids;
	
	@ManyToMany(cascade=CascadeType.PERSIST)
	public Set<Tag> tags;

	@MaxSize(500)
	public String description;
	
	@ManyToOne
	public Item item;
	
	@ManyToOne
	public Account account;

	public String image;
	
	public static List<Auction> findLatest(){
		return Auction.findAll();
	}

	public double price;

	
	@Required
	@Temporal(TemporalType.DATE)
	public Date createDate = new Date();
	
	
	public String toString(){
		return this.id + " - " + name;
	}

}
