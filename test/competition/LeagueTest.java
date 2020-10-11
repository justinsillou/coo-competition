package competition;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import competitor.Competitor;

public class LeagueTest {

	private static List<Competitor> competitors;
	private static League ligue ;
	
	@Before
	public void init() {
		competitors = Arrays.asList(new Competitor("Blastoff"), new Competitor("Drift"), new Competitor("Midas"), new Competitor("Raven"), new Competitor("Lynx"), new Competitor("Catalyst"),new Competitor("Lyon"), new Competitor("Rook"));
		ligue = new League(competitors);
	}
	
	@Test
	public void testScheduleMatchLeagueOk() {
		Competitor blastoff = competitors.get(0);
		Competitor drift = competitors.get(1);
		ligue.scheduleMatch(blastoff, drift);
		assertTrue(drift.getNbWin() == 1 || blastoff.getNbWin() == 1);
	}
	
	@Test
	public void testPlayLeagueOk() {
		int conteurWin = 0;

		ligue.play(competitors);
		for(int i = 0; i < competitors.size(); i++) {
			conteurWin+=competitors.get(i).getNbWin();
		}
		assertTrue(conteurWin == competitors.size()*(competitors.size()-1));
	}
}
