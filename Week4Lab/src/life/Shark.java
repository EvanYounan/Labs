package life;

import java.util.Random;

/** A Shark in the Ocean */
public class Shark extends Organism {

	/**
     * Creates a new Shark with the given name, x and y coordinates, 
     * speed, and direction, colour, and size.
     * @param name the name of the new Shar
     * @param xCoord the x coordinate of the new Shark
     * @param yCoord the y coordinate of the new Shark
     * @param speed the speed of the new Shark
     * @param direction the direction of the new Shark,
     *        must be one of VALID_DIRECTIONS
     * @param colour the colour of the Shark
     * @param size the size of the Shark
     */
	public Shark(String name, int xCoord, int yCoord, int speed, String direction, String colour, int size) {
		super(name, xCoord, yCoord, speed, direction, colour, size);
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
	 * Type: Shark to the string to specify what type the organism is.
	 */
	public String toString() {
		return super.toString() + " Type: Shark.";
	}
}
