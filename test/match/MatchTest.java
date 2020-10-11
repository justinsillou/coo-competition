package match;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import competitor.Competitor;

public class MatchTest {
	
	private static Match match;
	private static Competitor c1 ,c2;
	private static String name1, name2;

	@Before
	public void init(){
		c1 = new Competitor(name1);
		c2 = new Competitor(name2);
		
		match = new Match();
	}
	
	@Test
	public void testPlayMatchOk() {
		Competitor winner = null;
		try {
			winner = match.playMatch(c1,c2);
		} catch (IllegalArgumentException e) {
			fail();
		}
		assertEquals(winner.getClass().getName(), c1.getClass().getName());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testPlayMatchCompetitorEliminated() throws IllegalArgumentException {
		Competitor winner;
		c1.setElimine(true);
		winner=match.playMatch(c1, c2);
		assertEquals(winner.getClass().getName(), c1.getClass().getName());
	}

	@Test
	public void testAddWinMatch() {
		int nbWinInitial = c1.getNbWin();
		match.addWinMatch(c1);
		int nbWin = c1.getNbWin();
		assertEquals(nbWinInitial+1,nbWin);
	}
	
	@Test
	public void testElimination() {
		try {
			match.elimination(c2);
		}catch(IllegalArgumentException e) {
			fail();
		}
		assertTrue(c2.isElimine());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testEliminationCompetitorAlreadyEliminated() {
		c2.setElimine(true);
		match.elimination(c2);
		assertTrue(c2.isElimine());
	}
}
