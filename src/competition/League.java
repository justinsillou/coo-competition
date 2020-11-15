package competition;

import java.util.List;

import competitor.Competitor;

public class League extends Competition {
	/**
	 * Constructor of the League class which initializes the list of cometitors with the superclass's constructor of Competition
	 * @param competitors
	 **/
	public League(List<Competitor> competitor) {
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
      Competitor winner = this.getMatch().playMatch(c1, c2);
			this.getScores().put(winner, this.getScores().get(winner)+1);
			winner.addWin();
			System.out.printf("%s vs %s --> %s wins ! \n", c1.getName(), c2.getName(), winner.getName());
  }

  /**
   * Override of the play() method of the Competition class which manages the course of the League
   */
  @Override
  public void play() {
	  for(int i = 0; i < this.getCompetitors().size(); i++) {
		  if(this.getCompetitors().get(i).getNbWin() != 0) {
			  this.getCompetitors().get(i).setNbWin(0);
		  }
	  }
		play(this.getCompetitors());
  }

}
