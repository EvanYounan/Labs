package life;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javax.annotation.Resources;

/** A class that generates random strings, random colours, and random integers. */
public class RandomGenerator {
	
	ArrayList<String> sDictionary = new ArrayList<String>();
	public static final String[] COLOURS = {"blue", "red", "green", "yellow", "grey", 
			"white", "black", "pink", "orange"};
	Random rand = new Random();
	
	/**
	 * Creates a RandomWords object and creates an Arraylist of Strings from the text file
	 * ScrabbleDictionary.txt to be used for random String generation.
	 */
	public RandomGenerator() 
	{
		File file = new File("resources/ScrabbleDictionary.txt");
		String absolutePath = file.getAbsolutePath();
		
		try(BufferedReader br = new BufferedReader(new FileReader(absolutePath))) 
		{
			String line = br.readLine();
			
			while (line != null) {
				sDictionary.add(line);
				line = br.readLine();
			}
		} catch (IOException e) {
			System.out.println("The file was not found!");
		}
	}
	
	/**
	 * Return a random String of the Scrabble Dictionary.
	 * 
	 * @return
	 * 		random String from the Scrabble Dictionary
	 */
	public String generateString() {
		int randomX = rand.nextInt(sDictionary.size());
		return sDictionary.get(randomX);
	}
	
	/**
	 * Return a random colour from the COLOURS list.
	 * 
	 * @return
	 * 		random colour from COLOURS as a String
	 */
	public String generateColour() {
		return COLOURS[rand.nextInt(COLOURS.length)];
	}
	
	/**
	 * Return a random integer from 0 to bound-1
	 * 
	 * @param bound upper bound of the range (0 to bound-1)
	 * @return
	 * 		An integer from 0 to bound-1
	 */
	public int generateInt(int bound) {
		return rand.nextInt(bound);
	}
}
