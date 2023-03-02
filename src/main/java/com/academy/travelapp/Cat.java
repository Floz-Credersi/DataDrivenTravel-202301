package com.academy.travelapp;

import java.util.UUID;

public class Cat extends Animal {
	public Cat(String name) {
		super(name);
		this.species = "C";
		this.writeAnimal();
	}
	
	public Cat(String name, String uuid, int hunger) {
		super(name);
		this.species = "C";
		this.hunger = hunger;
		this.id = UUID.fromString(uuid);
	}
}
