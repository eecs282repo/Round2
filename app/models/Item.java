package models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.Cascade;

import play.db.jpa.Model;

@Entity
public class Item extends Model{
	public String name;
	
	@ManyToMany
	public List<AssocWord> associated_word;
	
	public double average_price;
	
	@ManyToMany(cascade = {CascadeType.ALL})
	public List<Tag> categories;
	
	public String toString(){
		return name;
	}
}
