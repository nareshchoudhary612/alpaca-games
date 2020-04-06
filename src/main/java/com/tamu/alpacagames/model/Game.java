package com.tamu.alpacagames.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Game {
	
	 	@Id
	    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GamesSeq")
	    @SequenceGenerator(name = "GamesSeq", sequenceName = "Games_SEQ" )
	 	Long gameId;
	 	String name;
	 	String creater;
	 	String genre;
	 	String description;
	 	String imageUrl;
	 	String platformType;
	 	int ageCategory;
	 	boolean available;
	 	double discount;
	 	double price;
	 	boolean homepageFlag;
		public Long getGameId() {
			return gameId;
		}
		public void setGameId(Long gameId) {
			this.gameId = gameId;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getCreater() {
			return creater;
		}
		public void setCreater(String creater) {
			this.creater = creater;
		}
		public String getGenre() {
			return genre;
		}
		public void setGenre(String genre) {
			this.genre = genre;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public String getImageUrl() {
			return imageUrl;
		}
		public void setImageUrl(String imageUrl) {
			this.imageUrl = imageUrl;
		}
		public String getPlatformType() {
			return platformType;
		}
		public void setPlatformType(String platformType) {
			this.platformType = platformType;
		}
		public int getAgeCategory() {
			return ageCategory;
		}
		public void setAgeCategory(int ageCategory) {
			this.ageCategory = ageCategory;
		}
		public boolean isAvailable() {
			return available;
		}
		public void setAvailable(boolean available) {
			this.available = available;
		}
		public double getDiscount() {
			return discount;
		}
		public void setDiscount(double discount) {
			this.discount = discount;
		}
		public double getPrice() {
			return price;
		}
		public void setPrice(double price) {
			this.price = price;
		}
		public boolean isHomepageFlag() {
			return homepageFlag;
		}
		public void setHomepageFlag(boolean homepageFlag) {
			this.homepageFlag = homepageFlag;
		}
	 	
	 	
	
	 	
	 	
}
