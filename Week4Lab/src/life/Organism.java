package life;

/**
 * An Organism in a tide pool.
 */
public abstract class Organism {
    
    /** 
     * An Organism can move in one of these directions.
     */
    public static final String [] VALID_DIRECTIONS = 
        {"north", "south", "east", "west"};
    
    /** The Organism's name. */
    protected String name;

    /** The Organism's x coordinate. */
    protected int xCoord;

    /** The Organism's y coordinate. */
    protected int yCoord;   

    /** The number of units of distance the Organism moves in a unit of time.*/
    protected int speed;    

    /** The direction the Organism will move (one of VALID_DIRECTIONS). */
    protected String direction; 
    
    /** The colour of the Organism */
    protected String colour = "";
    
    /** The size of the Organism */
    protected int size;
    
    /**
     * Creates a new Organism with the given name, x and y coordinates, 
     * speed, and direction.
     * @param name the name of the new Organism
     * @param xCoord the x coordinate of the new Organism
     * @param yCoord the y coordinate of the new Organism
     * @param speed the speed of the new Organism
     * @param direction the direction of the new Organism,
     *        must be one of VALID_DIRECTIONS
     */
    public Organism(String name, int xCoord, int yCoord, int speed,
        String direction, String colour, int size) {
        this.name = name;
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        this.direction = direction;
        this.speed = speed;
        this.colour = colour;
        this.size = size;
    }
    
    /**
     * Changes the position of this Organism according its current 
     * speed and direction: move for one unit of time.
     */
    public void move() {
        switch (direction) {
        case "north": yCoord += speed; break;
        case "south": yCoord -= speed; break;
        case "east": xCoord += speed; break;
        case "west": xCoord -= speed;
        }
    }
    
    /**
     * Return a string representation of the Organism
     * 
     * return
     * 		String description of the organism
     */
    public String toString() {
    	return "Name: " + this.name + " (" + this.xCoord + ", " + this.yCoord + ")." + " Speed: "
    			+ this.speed + ". Size: " + this.size + ".";
    }
}
