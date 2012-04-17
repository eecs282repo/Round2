package models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PreRemove;

import org.hibernate.annotations.Cascade;

import play.db.jpa.Model;

@Entity
public class Item extends Model{
	
	public String name;
	
	@OneToMany(mappedBy="item", cascade=CascadeType.PERSIST)
	public List<Auction> auctions;
	
	public double average_price;
	
	@ManyToMany(cascade = {CascadeType.PERSIST})
	public List<Tag> tags;
	
	/**
	 * Manually remove all references, because Hibernate is not as diligent as once though. 
	 */
	@PreRemove
	public void unsetAuctionHasItem() {
		System.out.println("Deleting!!!!!!!!");
		for(Auction auction : (List<Auction>)auctions){
			auction.item = null;
			auction.save();
		}
		System.out.println("Done");
	}
	
	public String toString(){
		return name;
	}
}
