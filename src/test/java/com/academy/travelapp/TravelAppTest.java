package com.academy.travelapp;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.sql.ResultSet;
import java.util.List;

import org.junit.Test;

final class ProcessorTest implements Processor {
	public void process(ResultSet results) {
		try {
			// Would normally next in while loop
			assertTrue(results.next());
			
			// Test hello column data	
			String hello = results.getString("hello");
			assertTrue(hello.equals("Academy"));
			
			// Test world column data
			String world = results.getString("world");
			assertTrue(world.equals("Cool"));
			
			// Should be no more rows
			assertFalse(results.next());
		} catch (Exception ex) {
			ex.printStackTrace();
			assertTrue(false);
		}
	}
}

public class TravelAppTest {
    /*@Test
    public void shouldReadAndWrite() {
		try (TravelAppDB db = new TravelAppDB(); TravelApp app = new TravelApp()) {			
			app.write("CREATE TABLE IF NOT EXISTS hi(hello VARCHAR(10), world VARCHAR(10))");
			app.write("INSERT INTO hi (hello, world) VALUES ('Academy', 'Cool')");
			app.read(new ProcessorTest(), "SELECT hello, world FROM hi");
			app.write("DROP TABLE hi");
	        assertTrue(true);
		}
    }*/
    
	/*
    @Test
    public void writeOwner() {
    	//new Owner("Floz", "Bridgnorth");
    	//new Cat("Tiddles");
    	assertTrue(true);
    }
    */
	
	@Test
	public void sanityCheckPetOwnership() {
		Animal john = new Cat("John");
		Animal peter = new Cat("Peter");
		Animal reginald = new Dog("Reginald");
		Owner harvey = new Owner("Harvey", "Skegness");
		
		harvey.adoptPet(reginald);
		harvey.adoptPet(john);
		harvey.adoptPet(peter);

		List<Animal> pets = harvey.getPets();
		assertTrue(pets.size() == 3);
		assertTrue(pets.get(0).getName().equals("John"));
		assertTrue(pets.get(1).getName().equals("Peter"));
		assertTrue(pets.get(2).getName().equals("Reginald"));
	}
	
	
}