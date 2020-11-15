package match;

import java.util.Random;
import competitor.Competitor;

public class Match {

	/**
	 * Constructor of the Match class
	 */
	public Match() {
	}

	/**
	 * PlayMatch method that allows you to play the match between two competitors
	 * @param competiteur1
	 * @param competiteur2
	 * @return un Competitor winner, le gagnant du match
	 * @throws IllegalArgumentException
	 */
	public Competitor playMatch(Competitor competiteur1, Competitor competiteur2) throws IllegalArgumentException {
		if(competiteur1.isElimine() || competiteur2.isElimine()) {
			throw new IllegalArgumentException("Un des competiteur est deja elimine.");
		}
		return (new Random().nextInt(2)==0)?competiteur1:competiteur2;

	}

	/**
	 * Method of the Match class which adds a win to the Competitor
	 * @param competiteur
	 */

	public void addWinMatch(Competitor competiteur) {
		competiteur.addWin();
	}

	/**
	 * Method of the Match class which eliminates a Competitor if it is not already
	 * @param competiteur
	 * @throws IllegalArgumentException
	 */
	public void elimination(Competitor competiteur) throws IllegalArgumentException{
		if(competiteur.isElimine()) {
			throw new IllegalArgumentException("Le competiteur est deja elimine");
		}
		competiteur.setElimine(true);
	}

}
