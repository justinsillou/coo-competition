package masters;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import competitor.Competitor;

public class TwoFirstOfPoolAndTwoBestThirdTest {

	private static List<Competitor> competitors1, competitors2;
	private static List<Competitor> winners, winnersAndThirds;
	private static TwoFirstOfPoolAndTwoBestThird strategie;

	
	@Before
	public void init() {
		competitors1 = Arrays.asList(new Competitor("Blastoff"), new Competitor("Drift"), new Competitor("Midas"), new Competitor("Raven"));
		competitors2 = Arrays.asList(new Competitor("Lynx"), new Competitor("Catalyst"),new Competitor("Lyon"), new Competitor("Rook"));
		winners = new ArrayList<Competitor>();
		winnersAndThirds = new ArrayList<Competitor>();
		strategie = new TwoFirstOfPoolAndTwoBestThird();
	}
	
	
	
	@Test
	public void testPlayPoolOK() {
		winners = strategie.playPool(competitors1);
		assertTrue(winners.size() == 2);
	}
	
	@Test
	public void testAddWinnersPoolOK() {
		strategie.playPool(competitors1);
		winners.addAll(strategie.playPool(competitors2));
		winnersAndThirds = strategie.addWinnersPool();
		assertEquals(winners.size()+2, winnersAndThirds.size());
	}
}
