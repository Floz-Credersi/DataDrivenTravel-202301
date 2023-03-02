package com.academy.travelapp;

import java.util.UUID;

public class Dog extends Animal {
	public Dog(String name) {
		super(name);
		this.species = "D";
		this.writeAnimal();
	}
	
	public Dog(String name, String uuid, int hunger) {
		super(name);
		this.species = "D";
		this.hunger = hunger;
		this.id = UUID.fromString(uuid);
	}
}
