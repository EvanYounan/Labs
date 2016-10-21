package life;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

/** A Reef in the Ocean */
public class Reef {
	/** Name of the Reef */
	private String name = "";
	
	/** Map to hold the Organisms in the Reef */
	private Map<String, Organism> organisms;
	
	/** Number of Organisms in the Reef */
	private int size = 0;
	
	/** Maximum amount of Organisms the Reef can hold */
	private int maximumCapacity;
	
	/**
	 * Creates a new Reef with the given name and maximum capacity. Also initializes a 
	 * HashMap to hold all of the Organisms in the Reef.
	 * @param name the name of the Reef
	 * @param maximumCapacity the maximum capacity of the reef
	 */
	public Reef(String name, int maximumCapacity) {
		this.name = name;
		this.maximumCapacity = maximumCapacity;
		this.organisms = new HashMap<String, Organism>();
	}
	
	/**
	 * Adds an Organism x to the Reef if there is space for the Organism.
	 * 
	 * @param x Organism the Organism to be added to the Reef
	 */
	public void addOrganism(Organism x) {
		if (this.size < this.maximumCapacity) {
			this.organisms.put(x.name, x);	
			this.size += 1;
		} else {
			System.out.println("Could not add " + x.name + " because " + this.name + 
					" is full!");
		}
	}
	
	/**
	 * Return a list of the Organisms in the Reef
	 * @return
	 * 		a list of all the Organisms in the Reef
	 */	
	public Collection<Organism> getOrganisms() {
		return this.organisms.values();
	}
	
	/**
	 * Return the name of the Reef
	 * @return
	 * 		the name of the Reef as a String
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set the name of the Reef to name
	 * @param name the new name of the Reef
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Return the amount of Organisms in the Reef
	 * @return
	 * 		amount of Organisms in the Reef as an int
	 */	
	public int getSize() {
		return size;
	}

	/**
	 * Return the maximum amount of Organisms the Reef can hold.
	 * @return
	 * 		maximum Organisms Reef can hold.
	 */
	public int getMaximumCapacity() {
		return maximumCapacity;
	}

	/**
	 * Set the maximum capacity of the Reef to maximumCapacity
	 * @param maximumCapacity the new maximum capacity of the Reef
	 */
	public void setMaximumCapacity(int maximumCapacity) {
		this.maximumCapacity = maximumCapacity;
	}
	
	/**
	 * Try to remove Organism x from the Reef and checkConsume again with the new 
	 * Map of Organisms
	 * @param x Organism to be removed
	 */
	public void removeOrganism(Organism x) {
		try {
			this.organisms.remove(x.name);
			this.size -= 1;
		} catch(Exception e) {
			System.out.println("That organism was not found in " + this.name + "!");
		} finally {
			checkConsume();
		}
	}
	
	/**
	 * Move all of the Organisms in the Reef
	 */
	public void moveAllOrganisms() {
		for (Organism x : this.getOrganisms()) {
			x.move();
		}
	}
	
	/**
	 * Check if any Organisms can be consumed. Organisms can be consumed if two or more 
	 * Organisms share the same coordinate and differ in size. The larger organism will eat 
	 * the smaller ones.
	 */
	public void checkConsume() {
		int tempSize = 0;
		for (Organism x : this.getOrganisms()) {
			tempSize = this.size;
			for (Organism z : this.getOrganisms()) {
				consume(x, z);
				if (this.size < tempSize) {
					break;
				}
			}
			if (this.size < tempSize) {
				break;
			}
		}
	}
	
	/**
	 * Return a string representation of the Reef 
	 * 
	 * return retString the string representation of the Reef
	 */
	public String toString() {
		String retString = "------------------" + this.name + 
				"------------------" + "\n";
		if (this.getSize() != 0) {
			for (Organism x : this.getOrganisms()) 
			{
				retString += x.toString() + "\n";
			}
		}
		return retString;
	}

	/**
	 * Check if Organism x can consume Organism y and vice versa by checking if they
	 * share the same coordinates and differ in size.
	 * @param x Organism to consume or be consumed
	 * @param y Organism to consume or be consumed
	 */
	public void consume(Organism x, Organism y) {
		if (x.xCoord == y.xCoord && x.yCoord == y.yCoord && x.type != y.type) 
		{
			if (x.size > y.size) {
				System.out.println(x.name + " ate " + y.name);
				this.removeOrganism(y);
			} else if (x.size < y.size) {
				System.out.println(y.name + " ate " + x.name);
				this.removeOrganism(x);
			}
		}
	}
}
