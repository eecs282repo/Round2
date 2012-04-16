package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import play.db.jpa.Model;

@Entity
public class AssocWord extends Model {
	public String name;
	
	@ManyToMany
	public List<Tag> categories;
	
	@ManyToMany
	public List<Item> items;
}
