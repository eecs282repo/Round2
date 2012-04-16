package models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import play.db.jpa.Model;

@Entity
public class Message extends Model {
	
	public String msg_body;
	
	@ManyToOne
	public Bid bid;
	
	public String toString(){
		return msg_body;
	}
}
