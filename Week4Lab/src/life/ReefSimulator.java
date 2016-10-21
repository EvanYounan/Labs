package life;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * A simulation of a Reef
 * @author Evannnn
 */
public class ReefSimulator {
	public static ArrayList<String> usedString = new ArrayList<String>();
	RandomGenerator dict = new RandomGenerator();
	
	public String generateProperString() {
		String tempStr = dict.generateString();
		if (usedString.contains(tempStr)) {
			generateProperString();
		}
		return tempStr;
	}
	
	public static void main(String[] args) {
		//Create a Reef
		Reef coralReef = new Reef("Coral Reef", 50);
		LinkedList<Organism> listOfTempOrganisms = new LinkedList<Organism>();
		RandomGenerator dict = new RandomGenerator();
		ReefSimulator x = new ReefSimulator();
		//append Eels, Goldfishes, Sharks, and Algaes to a LinkedList of Organisms
		for (int i = 0; i < 10; i++) {
			//eels have a size of 10-25
			listOfTempOrganisms.add(new Eel(x.generateProperString(), 0, 0, dict.generateInt(5), 
					"north", dict.generateColour(), dict.generateInt(15)+10));
			//goldfish have a size of 3-9
			listOfTempOrganisms.add(new Goldfish(x.generateProperString(), 0, 0, dict.generateInt(5)+1, 
					"north", dict.generateColour(), dict.generateInt(6)+3));
			//Algae (example Seaweed) don't move
			listOfTempOrganisms.add(new Algae(x.generateProperString(), 0, 0, 0, 
					"north", dict.generateColour(), 1));
			//sharks are much bigger and move quick
			listOfTempOrganisms.add(new Shark(x.generateProperString(), 0, 0, dict.generateInt(5), 
					"north", dict.generateColour(), dict.generateInt(25)+20));
		}
		
		//Add all the Organisms in the LinkedList to the Reef
		for (Organism y : listOfTempOrganisms) {
			coralReef.addOrganism(y);
		}
		
		//print the contents of the Reef
		System.out.println(coralReef);
		System.out.println(coralReef.getSize());
		System.out.println(""); //spacing for the output
		System.out.println("Moving all organisms");
		System.out.println(""); //spacing for the output
		
		//move all the organisms in the Reef
		coralReef.moveAllOrganisms();
		System.out.println("New positions of all organisms:");
		System.out.println("");
		System.out.println(coralReef);
		System.out.println("Trying to consume--------------");
		
		//Consume any organisms that are in the same position and differ in size.
		coralReef.checkConsume();
		System.out.println("");
		System.out.println("Displaying the new reef after consumptions");
		System.out.println("");
		System.out.println(coralReef);
		System.out.println("This is the size of the coral reef " + coralReef.getSize());
		
	}
}
