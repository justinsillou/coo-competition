package competitor;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.lang.String;


public class CompetitorTest {

	private static Competitor competiteur;
	private static String name;
	
	@Before
	public void init(){
		competiteur = new Competitor(name);
	}
	
	@Test
	public void testAddWin() {
		int nbWinInitial = competiteur.getNbWin();
		competiteur.addWin();
		int nbWin = competiteur.getNbWin(); 
		assertEquals(nbWinInitial+1,nbWin);
	}

}
