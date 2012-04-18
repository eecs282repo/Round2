package models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinTable;
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
	
	@ManyToMany(mappedBy="tags", cascade = CascadeType.PERSIST)
	public List<Auction> auctions;
	
	public String toString(){
		return name;
	}
	
	/**
	 * Constructor, initializes item_count to zero
	 */
	public Tag(){
		item_count = 1;
	}

	/**
	 * Create if found, or create new, also if found, then increment item_count
	 * @param name
	 * @return
	 */
	public static Tag findIncOrCreateByName(String name) {
	    Tag tag = Tag.find("byName", name).first();
	    if(tag == null) {
	        tag = new Tag();
	        tag.name = name;
	    }else{
	    	tag.item_count += 1;
	    }
	    return tag;
	}
	
	public static List<Tag> findPopular(int num){
		List<Tag> tags = Tag.find("order by item_count desc").fetch(num);
		return tags;
	}
	
//	
//	public static List<Tag> findByString(String q) {
//		q.trim();
//		List<Tag> result = Tag.find("name like %q", q).fetch();
//		if(result.isEmpty()){
//			result = Tag.find("associated_words like %q", q).fetch();
//		}
//		return result;
//	}


	public int compareTo(Tag other) {
		return name.compareTo(other.name);
	}

}
