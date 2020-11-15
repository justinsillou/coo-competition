package masters;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import competitor.Competitor;

public class FirstOfPoolTest {

	private static List<Competitor> competitors;
	private static List<Competitor> winners;
	private static FirstOfPool fstpool;

	
	@Before
	public void init() {
		competitors = Arrays.asList(new Competitor("Blastoff"), new Competitor("Drift"), new Competitor("Midas"), new Competitor("Raven"), new Competitor("Lynx"), new Competitor("Catalyst"),new Competitor("Lyon"), new Competitor("Rook"));
		winners = new ArrayList<Competitor>();
		fstpool = new FirstOfPool();
	}
	
	@Test
	public void testAddWinnersPoolOK() {
		winners = fstpool.addWinnersPool();
		assertTrue(winners.size() == 0);
	}
	
	@Test
	public void testPlayPoolOK() {
		winners = fstpool.playPool(competitors);
		assertTrue(winners.size() == 1);
	}

}
