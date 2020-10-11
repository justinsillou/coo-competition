**Introduction**

**HowTo**

- recuperation du depot:

```console
git clone https://gitlab-etu.fil.univ-lille1.fr/fofanad/projet_competitions.git
```

- generation de la documentation `(dans /src)`

```console
javadoc -d ../docs/ -subpackages *
```

- compilation `(toujours dans /src)`

```console
javac */*.java -d ../bin
```

- generation de l'archive du projet `(dans /bin)`

```console
jar cvfm ../competition_v1.jar ../manifest *
```

- execution de l'archive `(dans /projet_competitions)`

```console
java -jar competition_v1.jar
```

- elements de conception

	protected void play(List<Competitor> c) {
		ArrayList<Competitor> winners = new ArrayList<Competitor>();
		ArrayList<Competitor> losers = new ArrayList<Competitor>();

		for(int i = 0; i< c.size(); i++) {
			winners.add(c.get(i));
		}
		int nbComp = c.size();

		while(nbComp > 1) {
			for(int i = 0; i< winners.size(); i+=2) {
				scheduleMatch(winners.get(i),winners.get(i+1));				
			}
			for(int i = 0; i < winners.size(); i++) {
				if(winners.get(i).isElimine()) {
					losers.add(winners.get(i));
				}
			}
			for(int i = 0; i<losers.size();i++) {
				winners.remove(losers.get(i));
			}

			losers.clear();
			nbComp/=2;
		}
	}

- principes de conceptions mis en oeuvre

- valorisation du projet

**Diagrame de classe du projet**

![DiagrammeUML](diagUML.png)
