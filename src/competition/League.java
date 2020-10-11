package competition;

import java.util.List;

import competitor.Competitor;

public class League extends Competition {

	/**
	 * Constructor of the League class which initializes the list of cometitors with the superclass's constructor of Competition
	 * @param competitors
	 **/
	protected League(List<Competitor> competitor) {
			super(competitor);
	}

	/**
	 * Override of the play(List<Competitor>) method of the Competition class which manages the course of the matches
	 */
	@Override
	public void play(List<Competitor> c) {
			for (Competitor c1 : c) {
					for (Competitor c2 : c) {
							if (c1 != c2)
									scheduleMatch(c1, c2);
					}
			}
	}

/**
 * Override of the scheduleMatch(Competitor, Competitor) method of the Competition class which plays a match and manages the point additions
 */
  @Override
  protected void scheduleMatch(Competitor c1, Competitor c2) {
      Competitor winner = super.getMatch().playMatch(c1, c2);
			//Utilisation d'une fonction intermédiaire ... mais qui fonctionne pour l'instant
			winner.addWin();
			super.getScores().put(winner, winner.getNbWin());
			//super.getScores().put(winner, super.getScores().get(winner)+1);
			System.out.printf("%s vs %s --> %s wins ! \n", c1.getName(), c2.getName(), winner.getName());
  }

  /**
   * Override of the play() method of the Competition class which manages the course of the League
   */
  @Override
  public void play() {
		play(super.getCompetitors());
  }

}
