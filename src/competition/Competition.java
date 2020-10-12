package competition;
import java.util.*;

import competitor.Competitor;
import match.Match;
import util.MapUtil;

public abstract class Competition{

  private final Match match;
  private final List<Competitor> competitors;
  private final Map<Competitor, Integer> scores;

  /**
   * Constructor of the Competition class which initializes the list of cometitors
   * @param competitors
   */
  public Competition(List<Competitor> competitors){
    this.competitors = competitors;
    this.match = new Match();
	  this.scores = new HashMap<>();
  }


  /**
   * Abtsract method play() of the Competition class
   */
  public abstract void play();

  /**
   * Abtsract method play(List<Competitor>) of the Competition class
   */
  protected abstract void play(List<Competitor> c);

  /**
   * Abtsract method scheduleMatch(Competitor, Competitor) of the Competition class
   */
  protected abstract void scheduleMatch(Competitor c1, Competitor c2);

  /**
   * Abtsract method ranking() of the Competition class which return the rank of the Competition
   * @return a Map which contains the competitors and their score
   */
  public Map<Competitor, Integer> ranking(){
    return MapUtil.sortByDescendingValue(scores);
  }

  /**
  * Affichage
  * @println the players ranking by score
  */
  public void affichage(Map<Competitor,Integer> score) {
      System.out.println("\n***Ranking***");
      score.forEach((competitor, points) -> System.out.println(competitor.getName() + " - " + points));
  }

  /**
   * Getter of the Competition match attribute
   * @return the match of type Match
   */
  public Match getMatch(){
    return match;
  }

  /**
   * Getter of the Competition score attribute
   * @return a Map that contains the competitors and their score
   */
  public Map<Competitor, Integer> getScores(){
    return scores;
  }


  /**
   * Getter of the Competition competitors attribute
   * @return a List taht contains the list of Competitor
   */
  public List<Competitor> getCompetitors(){
    return competitors;
  }

}
