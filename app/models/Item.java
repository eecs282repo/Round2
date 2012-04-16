package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import play.db.jpa.Model;

@Entity
public class Item extends Model{
	public String name;
	
	@ManyToMany
	public List<AssocWord> associated_word;
	
	public double average_price;
	
	@ManyToMany
	public List<Tag> categories;
}
