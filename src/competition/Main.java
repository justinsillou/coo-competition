package competition;

import java.util.*;
import competitor.Competitor;

public class Main {

	public static void main(String[] args) {
		//LEAGUE
		List<Competitor> competitors = Arrays.asList(new Competitor("Blastoff"),
																									new Competitor("Lynx"),
																									new Competitor("Catalyst"),
																									new Competitor("Raven"),
																									new Competitor("Drift"),
																									new Competitor("Midas"));
    Competition compet = new League(competitors);
    compet.play();
		compet.ranking();

		//TOURNAMENT
  }
}
