/** 
 * Copyright 2011 The Apache Software Foundation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 * @author Felipe Oliveira (http://mashup.fm)
 * 
 */
package controllers;

import java.util.List;

import models.Auction;
import play.mvc.Controller;

/**
 * The Class Application - for the store's frontend
 * 
 * @author Yutong Wang
 */
public class Application extends Controller {

	/**
	 * Index. Display a list of the most recently auctions.
	 */
	public static void index() {
		List<Auction> auctions = Auction.findLatest();
		render(auctions);
	}

	
	
	
	// Below are the legacy functions from tutorial, for reference
	/**
	 * Creates the.
	 * 
	 * @param msg
	 *            the msg
	 */
/*	public static void create(String msg) {
		Tweet tweet = new Tweet();
		tweet.tweet = msg;
		tweet.save();
		render(tweet);
	}*/

	
	/**
	 * Tweets.
	 */
/*	public static void tweets() {
		List<Tweet> tweets = Tweet.findLatest();
		renderJSON(tweets);
	}*/
	
}