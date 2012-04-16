package models;

import javax.persistence.Entity;


import play.data.validation.*;
import play.db.jpa.Model;

@Entity
public class Account extends Model{
	
	@Required
	public String username;
	
	public String email;
	
	
}
