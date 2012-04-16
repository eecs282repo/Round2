package models;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import play.data.validation.MaxSize;
import play.data.validation.Required;
import play.db.jpa.Model;

@Entity
public class Auction extends Model{
	@Required
	public String name;
	
	
	@ManyToMany
	public List<Tag> tags;

	@Required
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
	@Temporal(TemporalType.TIMESTAMP)
	public Date createDate = new Date();
	
	
	public String toString(){
		return this.id + " - " + name;
	}

}
