package ca.utoronto.utm.assignment1.q2;

import ca.utoronto.utm.assignment1.puzzle.Puzzle;
import ca.utoronto.utm.assignment1.puzzle.States;

/**
 * 
 * @author Gagandeep Bhangal
 * IS-A object of puzzle
 * HAS-A jug object
 * RESPONDS-TO solve in puzzle
 */
public class JugPuzzle extends Puzzle {

	private Jug[] jugs;
	private int numMoves = 0;
	private MoveString[] allPossibleMoves;

	/**
	 * Construct a new JugPuzzle. A Jug Puzzle consists of three Jugs (numbered 0,1
	 * and 2) with capacities 8,5 and 3 respectively. To start, jug 0 is full and
	 * the other 2 are empty.
	 */
	public JugPuzzle() {
		jugs = new Jug[3];
		jugs[0] = new Jug(8);
		jugs[1] = new Jug(5);
		jugs[2] = new Jug(3);
		jugs[0].setAmount(8);
	}

	/**
	 * If jug 0 and jug 1 both have exactly 4 units of liquid in them, the puzzle is
	 * solved
	 * 
	 * @return whether the puzzle meets the conditions to be solved.
	 */
	public boolean isPuzzleSolved() {
		if (jugs[0].getAmount() == 4 && jugs[1].getAmount() == 4) {
			return true;
		}
		return false;
	}

	/**
	 * Spill liquid from jug a into jug b Update the new capacities
	 * 
	 * @param a is the jug you are spilling from
	 * @param b is the jug you are spilling to
	 */
	public void move(int a, int b) {
		int difference = jugs[b].getCapacity() - jugs[b].getAmount();
		int newAmount1 = difference;
		int diffA = jugs[a].getAmount() - difference;
		if (diffA < 0) {
			while (diffA < 0) {
				difference -= 1;
				diffA = jugs[a].getAmount() - difference;
			}
		}
		newAmount1 = jugs[a].getAmount() - difference;
		int newAmount2 = jugs[b].getAmount() + difference;
		jugs[a].setAmount(newAmount1);
		jugs[b].setAmount(newAmount2);
		numMoves += 1;
	}

	/**
	 * @return the number of moves carried out so far
	 */
	public int getMoves() {
		return numMoves;
	}

	/**
	 * @return a string representation of this
	 */
	public String toString() {
		return numMoves + "  0:(" + jugs[0].getAmount() + "/" + jugs[0].getCapacity() + ")  1:(" + jugs[1].getAmount()
				+ "/" + jugs[1].getCapacity() + ")  2:(" + jugs[2].getAmount() + "/" + jugs[2].getCapacity() + ")";
	}

	/**
	 * Create an array of all the possible moves in the JugPuzzle and a new
	 * temporary JugPuzzle to play as a copy. Loop through the possible moves with
	 * object MoveString. Create a copy of the temporary JugPuzzle, simulate a move
	 * on the temporary JugPuzzle and add the temporary JugPuzzle and object using
	 * the add method in the states class.
	 */
	@Override
	public void nextStates(States states) {
		allPossibleMoves = new MoveString[6];
		allPossibleMoves[0] = new MoveString(0, 1);
		allPossibleMoves[1] = new MoveString(0, 2);
		allPossibleMoves[2] = new MoveString(1, 0);
		allPossibleMoves[3] = new MoveString(1, 2);
		allPossibleMoves[4] = new MoveString(2, 0);
		allPossibleMoves[5] = new MoveString(2, 1);

		JugPuzzle tempPuzzle = new JugPuzzle();

		for (MoveString move : allPossibleMoves) {
			tempPuzzle = this.copy();
			tempPuzzle.move(move.getFrom(), move.getTo());
			states.add(tempPuzzle, move);
		}

	}

	/**
	 * Create a copy of a JugPuzzle. Add 3 jugs to the new JugPuzzle and copy the
	 * amounts and capacities from the respective jugs in this to the jugs in the
	 * new JugPuzzle. Copy over the number of moves as well the possible moves in
	 * this to the new JugPuzzle as well.
	 * 
	 * @return the new JugPuzzle with attributes copied from this.
	 */

	public JugPuzzle copy() {
		JugPuzzle p = new JugPuzzle();
		p.jugs = new Jug[3];
		p.jugs[0] = new Jug(8);
		p.jugs[0].setAmount(this.jugs[0].getAmount());
		p.jugs[1] = new Jug(5);
		p.jugs[1].setAmount(this.jugs[1].getAmount());
		p.jugs[2] = new Jug(3);
		p.jugs[2].setAmount(this.jugs[2].getAmount());
		p.numMoves = this.getMoves();
		p.allPossibleMoves = this.allPossibleMoves;
		return p;
	}

}
