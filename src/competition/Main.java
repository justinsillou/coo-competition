package competition;

import java.util.*;
import java.lang.*;
import competitor.Competitor;
import competition.*;
import masters.*;


public class Main {

	public static void main(String[] args) {
		List<Competitor> competitors = Arrays.asList(new Competitor("Blastoff"),
																									new Competitor("Lynx"),
																									new Competitor("Catalyst"),
																									new Competitor("Raven"),
																									new Competitor("Midas"),
																									new Competitor("Dupont"),
																									new Competitor("Hawks"),
																									new Competitor("Drift"),
																									new Competitor("Raoul"),
																									new Competitor("Veronique"),
																									new Competitor("Thoomas"),
																									new Competitor("Theo"),
																									new Competitor("Marie"),
																									new Competitor("Luc"),
																									new Competitor("Michel"),
																									new Competitor("Christophe"),
																									new Competitor("David"),
																									new Competitor("Justin"),
																									new Competitor("Pierre"),
																									new Competitor("Jules"),
																									new Competitor("Jean"),
																									new Competitor("Fleur"),
																									new Competitor("Michelle"),
																									new Competitor("Christopher"));

		//(NE PAS SUPPRIMER ! LEAGUE ET TOURNAMENT)
		//Mis en commentaire pour laisser place a masters.
		/*

		// ---------- LEAGUE -------------

		System.out.println("Championnat :\n");
    Competition compet = new League(competitors);
    compet.play();
		compet.affichage(compet.ranking());

		// ---------- TOURNAMENT ----------

		System.out.println("\n\nTournois :\n");
		try{
			Competition tournois = new Tournament(competitors);
			tournois.play();
			tournois.affichage(tournois.ranking());
		} catch (NumberOfCompetitorException e){
			e.printStackTrace();
		}
		*/

		// ----------- MASTERS ------------

		System.out.println("\n\nMasters, ");
		//Master(list of competitors, nbpoules, methode de selection)

		//Strategie 1: le meilleure de chaques poules
		// nbPoules powerof2
		//SelectedMethod methode = new FirstOfPool();

		//Strategie 2: les 2 meilleures de chaques poules et les deux meilleures troisiemes
		//(choisir 3 poules pour cette strategie)
		SelectedMethod methode = new TwoFirstOfPoolAndTwoBestThird();

		Competition master = new Master(competitors, 3, methode);
		master.play();
  }
}
