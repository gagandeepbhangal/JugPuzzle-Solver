package ca.utoronto.utm.assignment1.q2;

import ca.utoronto.utm.assignment1.puzzle.Move;

/**
 * 
 * @author Gagandeep Bhangal 
 * Create a MoveString method that defines a move using the interface from class Move in 
 * package Puzzle.
 * IS-A string representation of Move
 */
public class MoveString implements Move {

	/**
	 * Declare variables to store the output message, the jug you are pouring from
	 * and the jug you are pouring to.
	 */
	private String msg = "";
	private int from, to;

	/**
	 * Construct a message you wish to output and store the jug you are pouring from
	 * as well as the jug you are pouring to.
	 * 
	 * @param from is the jug you are pouring from
	 * @param to   is the jug you are pouring to
	 */
	public MoveString(int from, int to) {
		this.msg = "Move from: " + from + " to: " + to;
		this.from = from;
		this.to = to;
	}

	/**
	 * Create a method which returns the jug you are pouring from.
	 * 
	 * @return the integer value of the jug you are pouring from.
	 */
	public int getFrom() {
		return this.from;
	}

	/**
	 * Create a method which returns the jug you are pouring to.
	 * 
	 * @return the integer value of the jug you are pouring to.
	 */
	public int getTo() {
		return this.to;
	}

	/**
	 * @return a string representation of this.
	 */
	public String toString() {
		return this.msg;
	}
}
