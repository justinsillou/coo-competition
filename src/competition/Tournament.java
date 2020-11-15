package competition;

import java.util.ArrayList;
import java.util.List;

import competitor.Competitor;

public class Tournament extends Competition {

	private List<Competitor> winnersList;
	/**
	 * Constructor of the Tournament class which initializes the list of cometitors with the superclass's constructor of Competition
	 * @param competitors
	 */
	protected Tournament(List<Competitor> competitors) throws NumberOfCompetitorException{
		super(competitors);
		if (!isPowerOfTwo(competitors.size())){
			throw new NumberOfCompetitorException("Nombre de compétiteurs doit etre une puissance de 2");
		}
	}

	/**
	* Players needs to be a power of 2
	*/
	private boolean isPowerOfTwo(int n){
		return n>0 && (n&n-1)==0;
	}

	/**
	 * Override of the play() method of the Competition class which manages the course of the tournament
	 */
	@Override
	public void play() {
		play(this.getCompetitors());
	}

	/**
	 * Override of the play(List<Competitor>) method of the Competition class which manages the course of the matches
	 */
	@Override
	protected void play(List<Competitor> c) {
		List<Competitor> competitorList = new ArrayList<Competitor>(c); //liste des joueurs
		this.winnersList = new ArrayList<Competitor>();

		while(competitorList.size() > 1){
			for(int i = 0; i< competitorList.size(); i+=2) {
				scheduleMatch(competitorList.get(i),competitorList.get(i+1));
			}
			competitorList = this.winnersList;
			this.winnersList = new ArrayList<Competitor>(); //raz de la liste de joueurs
		}
	}

	/**
	 * Override of the scheduleMatch(Competitor, Competitor) method of the Competition class which plays a match and manages the eliminations and the point additions
	 */
	@Override
	protected void scheduleMatch(Competitor c1, Competitor c2) {
		 Competitor winner = this.getMatch().playMatch(c1, c2);
		 this.getScores().put(winner, this.getScores().get(winner)+1);
		 winner.addWin();
		 System.out.printf("%s vs %s --> %s wins ! \n", c1.getName(), c2.getName(), winner.getName());
		 this.winnersList.add(winner); //ajout a la liste de competiteurs le gagnant
	}
}
