package edu.gatech.oad.antlab.person;
import java.util.Random;

/**
 *  A simple class for person 2
 *  returns their name and a
 *  modified string 
 *
 * @author Bob
 * @version 1.1
 */
public class Person2 {
    /** Holds the persons real name */
    private String name;
	 	/**
	 * The constructor, takes in the persons
	 * name
	 * @param pname the person's real name
	 */
	 public Person2(String pname) {
	   name = pname;
	 }
	/**
	 * This method should take the string
	 * input and return its characters in
	 * random order.
	 * given "gtg123b" it should return
	 * something like "g3tb1g2".
	 *
	 * @param input the string to be modified
	 * @return the modified string
	 */
	private String calc(String input) {
	  String randomed = "";
	  while (input.length() > 0) {
		  int index = 43894389%input.length();
		  char c = input.charAt(index); 
		  randomed = randomed + c;
		  input = input.replace(c, ' ');
          String input1 = (String) input.subSequence(0, index);
		  String input2 = (String) input.subSequence(index, input.length());
		  input1 = input1.trim();
          input2 = input2.trim();
          input = input1 + input2;
          System.out.println(input);
	  }
	  return randomed;
	}
    
	/**
	 * Return a string rep of this object
	 * that varies with an input string
	 *
	 * @param input the varying string
	 * @return the string representing the 
	 *         object
	 */
	public String toString(String input) {
	  return name + calc(input);
	}
}
