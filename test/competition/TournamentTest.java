package competition;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import competitor.Competitor;

public class TournamentTest {

	private static List<Competitor> competitors;
	private static Tournament tournoi ;
	
	@Before
	public void init() {
		competitors = Arrays.asList(new Competitor("Blastoff"), new Competitor("Drift"), new Competitor("Midas"), new Competitor("Raven"), new Competitor("Lynx"), new Competitor("Catalyst"),new Competitor("Lyon"), new Competitor("Rook"));
		try {
			tournoi = new Tournament(competitors);
		} catch (NumberOfCompetitorException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testScheduleMatchTournamentOk() {
		Competitor blastoff = competitors.get(0);
		Competitor drift = competitors.get(1);
		tournoi.scheduleMatch(blastoff, drift);
		assertTrue((blastoff.isElimine() && !drift.isElimine() && drift.getNbWin() == 1) || (drift.isElimine() && !blastoff.isElimine() && blastoff.getNbWin() == 1));
	}
	
	@Test
	public void testPlayTournamentOk() {
		int conteurLosers = 0;
		int conteurWinner = 0;

		tournoi.play(competitors);
		for(int i = 0; i < competitors.size(); i++) {
			if(competitors.get(i).isElimine()) {
				conteurLosers++;
			}
			else {
				conteurWinner++;
			}
		}
		assertTrue((conteurLosers == competitors.size()-1) && (conteurWinner == 1));
	}
}
