package competitor;

public class Competitor {

	String name;
	int nbWin;
	boolean elimine;

	/**
	 * Constructor of the Competitor class which initializes the name to name, the nbWin to 0 and the bool eliminates to false
	 * @param name
	 */
	public Competitor(String name) {
		this.name = name;
		this.nbWin = 0;
		this.elimine = false;
	}

	/**
	 * Getter of the Competitor name attribute
	 * @return a string name, the name of the competitor
	 */
	public String getName() {
		return name;
	}

	/**
	 * Setter of the Competitor name attribute
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Getter of the Competitor nbWin attribute
	 * @return an int nbWin, number of match win by the Competitor
	 */
	public int getNbWin() {
		return nbWin;
	}

	/**
	 * Setter of the Competitor nbWin attribute
	 * @param nbWin
	 */
	public void setNbWin(int nbWin) {
		this.nbWin = nbWin;
	}

	/**
	 * Getter of the Competitor elimine attribute
	 * @return a bool elimine, true if the Competitor is eliminated
	 */
	public boolean isElimine() {
		return elimine;
	}

	/**
	 * Setter of the Competitor nbWin attribute
	 * @param elimine
	 */
	public void setElimine(boolean elimine) {
		this.elimine = elimine;
	}

	/**
	 * Competitor class method which adds a win to the competitor
	 */
	public void addWin() {
		this.nbWin ++;
	}



}
