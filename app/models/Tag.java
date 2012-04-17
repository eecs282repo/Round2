package models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;

import play.data.validation.Required;
import play.db.jpa.Model;

@Entity
public class Tag extends Model implements Comparable<Tag> {
	@Required
	public String name;
	
	public int item_count;
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	public List<Item> items;
	
	public String toString(){
		return name;
	}

	public static List<Tag> findByString(String q) {
		q.trim();
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
