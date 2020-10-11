package competition;

import java.util.ArrayList;
import java.util.List;

import competitor.Competitor;

public class Tournament extends Competition {

	/**
	 * Constructor of the Tournament class which initializes the list of cometitors with the superclass's constructor of Competition  
	 * @param competitors
	 */
	protected Tournament(List<Competitor> competitors) {
		super(competitors);
	}

	/**
	 * Override of the play() method of the Competition class which manages the course of the tournament
	 */
	@Override
	public void play() {
		play(super.getCompetitors());
	}

	/**
	 * Override of the play(List<Competitor>) method of the Competition class which manages the course of the matches
	 */
	@Override
	protected void play(List<Competitor> c) {
		ArrayList<Competitor> winners = new ArrayList<Competitor>();
		ArrayList<Competitor> losers = new ArrayList<Competitor>();

		for(int i = 0; i< c.size(); i++) {
			winners.add(c.get(i));
		}
		int nbComp = c.size();
		
		while(nbComp > 1) {
			for(int i = 0; i< winners.size(); i+=2) {
				scheduleMatch(winners.get(i),winners.get(i+1));				
			}
			for(int i = 0; i < winners.size(); i++) {
				if(winners.get(i).isElimine()) {
					losers.add(winners.get(i));
				}
			}
			for(int i = 0; i<losers.size();i++) {
				winners.remove(losers.get(i));
			}
			
			losers.clear();
			nbComp/=2;	
		}
	}

	/**
	 * Override of the scheduleMatch(Competitor, Competitor) method of the Competition class which plays a match and manages the eliminations and the point additions
	 */
	@Override
	protected void scheduleMatch(Competitor c1, Competitor c2) {
		 Competitor winner = super.getMatch().playMatch(c1, c2);
		 if(winner == c1) {
			 super.getMatch().elimination(c2);
			 super.getMatch().addWinMatch(c1);
		 }
		 else {
			 super.getMatch().elimination(c1);
			 super.getMatch().addWinMatch(c2);
		 }
	}
}
