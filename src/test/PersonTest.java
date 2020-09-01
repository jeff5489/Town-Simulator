package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import primary.Occupations;
import primary.Person;

class PersonTest {

	@Test
	void shouldPersonBuyVegFoodTest() {
		Person tom = new Person(0, Occupations.FARMER);
		tom.setVegetarianFoodAmount(0);
		assertTrue(tom.shouldPersonBuyVegFood(), "vegetarianFoodAmount <= randVegAmount is false");
	}

}
