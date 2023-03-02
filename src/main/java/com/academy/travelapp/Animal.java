package com.academy.travelapp;

public class Animal extends Base {
	protected static final String WRITE = "INSERT INTO Animal (Id, Name, Hunger, Species, OwnerId) VALUES ('%s', '%s', %d, '%s', NULL)";
	
	protected int hunger;
	protected String species;
	
	public Animal(String name) {
		super(name);
		this.hunger = 50;
	}
	
	public int getHunger() {
		return this.hunger;
	}
	
	public String getSpecies() {
		return this.species;
	}
	
	public void feeds() {
		
	}
	
	public void runs() {
		
	}
	
	protected void writeAnimal() {
		this.write(String.format(WRITE, this.getId().toString(), this.getName(), this.getHunger(), this.getSpecies()));
	}
}
