package masters;

import java.util.*;

import competitor.Competitor;
import competition.*;

public class TwoFirstOfPoolAndTwoBestThird implements SelectedMethod {

  List<Competitor> WinnersPoolsList = new ArrayList<>();
  List<Competitor> ThirdPoolsList = new ArrayList<>();

  @Override
  public List<Competitor> playPool(List<Competitor> c){
    Competition compet = new League(c); // Championnat
    compet.play(); // play Championnat
    Map<Competitor, Integer> ListRank = compet.ranking(); // ranking
    compet.affichage(ListRank);
    Competitor winner = ListRank.keySet().iterator().next(); // récup du gagnant
	  ListRank.keySet().remove(winner);
    Competitor second = ListRank.keySet().iterator().next(); // récup du 2nd
	  ListRank.keySet().remove(second);
    Competitor third = ListRank.keySet().iterator().next(); // récup du 3rd
    WinnersPoolsList.add(winner); //ajout a la liste des gagnants
    WinnersPoolsList.add(second); //ajout a la liste des gagnants
    ThirdPoolsList.add(third);//aajout a la liste des 3 eme
    return WinnersPoolsList;
  }

  @Override
  public List<Competitor> addWinnersPool(){
    System.out.println("\nAjout des 2 meilleurs 3emes :");
    int indBest;//indice du competiteur avec le plus de victoires
    for(int i = 0; i < 2; i++) {//recuperation des 2 meilleures
    	indBest = 0;
	    for (int j = 0; j < ThirdPoolsList.size() ; j++) {
	      if(ThirdPoolsList.get(j).getNbWin() > indBest) {
	    	  indBest = j;
	      }
	    }
	    WinnersPoolsList.add(ThirdPoolsList.get(indBest));// ajout a la liste des winners
      System.out.println(ThirdPoolsList.get(indBest).getName());//affichage du nom
	    ThirdPoolsList.remove(indBest);//supression du compotiteur de la liste des troisiemes
    }
    return WinnersPoolsList;
  }
}
