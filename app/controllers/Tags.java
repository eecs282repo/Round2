package controllers;

import java.util.List;

import models.Auction;
import models.Tag;

public class Tags extends CRUD {

	public static void view(Long id) {
		Tag tag = Tag.findById(id);
		render(tag);
	}
}
