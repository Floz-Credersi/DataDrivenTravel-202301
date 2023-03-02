package com.academy.travelapp;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Owner extends Base implements Processor {
	private static final String QUERY = "SELECT Id, Hunger, Name, Species FROM Animal WHERE OwnerId = '%s' ORDER BY Name";
	private static final String UPDATE = "UPDATE Animal SET ownerId = '%s' WHERE Id = '%s'";
	private static final String WRITE = "INSERT INTO Owner (Id, Name, Town) VALUES ('%s', '%s', '%s')";
	
	private String town;
	private List<Animal> pets;
	
	public Owner(String name, String town) {
		super(name);
		this.town = town;
		this.write(String.format(WRITE, this.getId().toString(), this.getName(), this.getTown()));
	}
	
	public void adoptPet(Animal animal) {
		this.write(String.format(UPDATE, this.getId().toString(), animal.getId().toString()));
	}
		
	public String getTown() {
		return this.town;
	}
	
	public List<Animal> getPets() {
		this.pets = new ArrayList<Animal>();
		this.read(this, String.format(QUERY, this.getId().toString()));		
		return this.pets;
	}
	
	public void process(ResultSet results) {
		try {
			while (results.next()) {
				String uuid = results.getString("Id");
				String name = results.getString("Name");
				int hunger = results.getInt("Hunger");
				String species = results.getString("Species");
				
				Animal pet = null;
				
				if (species.equals("C")) {
					pet = new Cat(name, uuid, hunger);
				} else if (species.equals("D")) {
					pet = new Dog(name, uuid, hunger);
				} else {
					throw new RuntimeException("Huh? What species is that!");
				}
				
				this.pets.add(pet);
			}
		} catch(Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException("Unable to process the results for an Owner!");
		}
	}
}
