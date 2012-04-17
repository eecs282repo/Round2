package models;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

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
