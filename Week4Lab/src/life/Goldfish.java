package life;

import java.util.Random;

/** A Goldfish in the Ocean */
public class Goldfish extends Organism {
	
    /**
     * Creates a new Goldfish with the given name, x and y coordinates, 
     * speed, and direction, colour, and size.
     * @param name the name of the new Goldfish
     * @param xCoord the x coordinate of the new Goldfish
     * @param yCoord the y coordinate of the new Goldfish
     * @param speed the speed of the new Goldfish
     * @param direction the direction of the new Goldfish,
     *        must be one of VALID_DIRECTIONS
     * @param colour the colour of the Goldfish
     * @param size the size of the Goldfish
     */
	public Goldfish(String name, int xCoord, int yCoord, int speed,
	        String direction, String colour, int size) {
		super(name, xCoord, yCoord, speed, direction, colour, size);
		
	}

	/**
	 * Return the colour of the Goldfish.
	 * 
	 * @return
	 * 		String representation of the colour of the Goldfish.
	 */		
	public String getColour() {
		return colour;
	}

	/**
	 * Set the colour of the Goldfish to colour.
	 */
	public void setColour(String colour) {
		this.colour = colour;
	}
	
	@Override
	/**
	 * Overrides the move() method of abstract class Organism, randomizing the direction
	 * of the movement and calling the abstracts move method.
	 */
	public void move() {
		Random rand = new Random();
		int y = rand.nextInt(4);
		super.direction = VALID_DIRECTIONS[y];
		super.move();
	}
	
	@Override
	/**
	 * Overrides the toString method of the abstract class Organism, adding the statement
	 * Type: Goldfish to the string to specify what type the organism is.
	 */
	public String toString() {
		return super.toString() + " Type: Goldfish.";
	}
}
