package models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;

import play.db.jpa.Model;

@Entity
public class AssocWord extends Model {
	public String name;
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	public List<Tag> categories;
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	public List<Item> items;
}
