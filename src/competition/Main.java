package competition;

import java.util.*;
import competitor.Competitor;

public class Main {

	public static void main(String[] args) {
		//LEAGUE
		System.out.println("\nLEAGUE");
		List<Competitor> competitors = Arrays.asList(new Competitor("Blastoff"),
																									new Competitor("Lynx"),
																									new Competitor("Catalyst"),
																									new Competitor("Raven"),
																									new Competitor("Drift"),
																									new Competitor("Midas"));
    Competition championnat = new League(competitors);
    championnat.play();
		System.out.println("\n***Ranking***");
  	championnat.ranking().forEach((competitor, points) -> System.out.println(competitor.getName() + " - " + points));



		//TOURNAMENT
		/*
		System.out.println("\nTOURNAMENT");
		Competition tournois = new Tournament(competitors);
		tournois.play();
		*/
  }
}
