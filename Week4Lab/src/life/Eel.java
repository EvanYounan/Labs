package life;

import java.util.Random;

/** An Eel in the Ocean */
public class Eel extends Organism{

	/**
     * Creates a new Eel with the given name, x and y coordinates, 
     * speed, and direction, colour, and size.
     * @param name the name of the new Eel
     * @param xCoord the x coordinate of the new Eel
     * @param yCoord the y coordinate of the new Eel
     * @param speed the speed of the new Eel
     * @param direction the direction of the new Eel,
     *        must be one of VALID_DIRECTIONS
     * @param colour the colour of the Eel
     * @param size the size of the Eel
     */
	public Eel(String name, int xCoord, int yCoord, int speed,
	        String direction, String colour, int size) {
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
	 * Type: Eel to the string to specify what type the organism is.
	 */
	public String toString() {
		return super.toString() + " Type: Eel.";
	}

}
