package masters;

import java.util.*;

import competitor.Competitor;
import competition.*;

public class FirstOfPool implements SelectedMethod {

  List<Competitor> WinnersPoolsList = new ArrayList<>();

  @Override
  public List<Competitor> playPool(List<Competitor> c){
    Competition compet = new League(c); // Championnat
    compet.play(); // play Championnat
    Map<Competitor, Integer> ListRank = compet.ranking(); // ranking
    compet.affichage(ListRank);
    Competitor winner = ListRank.keySet().iterator().next(); // récup du gagnant
    WinnersPoolsList.add(winner); //ajout a la liste des gagnants
    // System.out.println(WinnersPoolsList);
    return WinnersPoolsList;
  }

  @Override
  public List<Competitor> addWinnersPool(){
    List<Competitor> emptylist = new ArrayList<>();
    return emptylist;
  }
}
