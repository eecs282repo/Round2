package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import play.data.validation.Required;
import play.db.jpa.Model;

@Entity
public class Tag extends Model implements Comparable<Tag> {
	@Required
	public String name;
	
	public int item_count;
	
	@ManyToMany
	public List<Item> items;
	
	@ManyToMany
	public List<AssocWord> associated_words;
	
	public String toString(){
		return name;
	}

	public static List<Tag> findByString(String q) {
		List<Tag> result = Tag.find("name like %q", q).fetch();
		if(result.isEmpty()){
			result = Tag.find("associated_words like %q", q).fetch();
		}
		return result;
	}


	public int compareTo(Tag other) {
		return name.compareTo(other.name);
	}

}
