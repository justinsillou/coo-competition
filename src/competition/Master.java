package competition;

import java.util.ArrayList;
import java.util.List;

import competitor.Competitor;
import masters.SelectedMethod;

public class Master extends Competition {

	List<Competitor> pool = new ArrayList<>(); //creation d'une liste poule
	List<Competitor> winnersPool = new ArrayList<Competitor>(); //Gagnant pool pour phase finale
	List<Competitor> addPool = new ArrayList<Competitor>(); //ajout en plus de gagnants (après les poules)
	int nbPoule;
	int compTours = 1;
	private SelectedMethod selectedMethod; //type de selection de méthode de poule

	public Master(List<Competitor> competitors, int nbPoule, SelectedMethod selectedMethod) {
		super(competitors);
		this.nbPoule = nbPoule;
		this.selectedMethod = selectedMethod;
	}

	@Override
	public void play() {
		play(this.getCompetitors());
	}

	@Override
	protected void play(List<Competitor> c) {
		int nbJPoule = c.size()/nbPoule;
		System.out.println("Nombre de joueurs par poules : " + nbJPoule);
		System.out.println("Nombre de joueurs total : " + c.size());
		System.out.println("\n			PREMIER PHASE");
		for (int i = 0; i < c.size(); i++) {
			pool.add(c.get(i));
			if (this.pool.size() == nbJPoule){
				System.out.println("\n			Poule : " + compTours + "\n");
				winnersPool = this.selectedMethod.playPool(pool);
				pool.clear();
				compTours++;
			}
		}

		winnersPool.addAll(this.selectedMethod.addWinnersPool());

		System.out.println("\n			PHASE FINALE\n");
		try{
			Competition tournois = new Tournament(winnersPool);
			tournois.play();
			tournois.affichage(tournois.ranking());
		} catch (NumberOfCompetitorException e){
			e.printStackTrace();
		}
	}

	/*
	@Override
	protected void play(List<Competitor> c) {
		ArrayList<Competitor> copyC = new ArrayList<Competitor>();
		ArrayList<ArrayList<Competitor>> master = new ArrayList<ArrayList<Competitor>>();
		ArrayList<Competitor> poule = new ArrayList<Competitor>();
		for(int i = 0; i< c.size(); i++) {
			copyC.add(c.get(i));
		}
		for(int i = 0; i<this.nbPoule;i++) {
			for(int j = 0; j < this.nbJPoule; j++) {
				Competitor joueurAlea = copyC.get((int) (Math.random()*(copyC.size()+1)));
				poule.add(joueurAlea);
				copyC.remove(joueurAlea);
			}
			master.add(poule);
		}
	}
	*/
	@Override
	protected void scheduleMatch(Competitor c1, Competitor c2) {
		//Fait dans les Méthodes
	}

}
