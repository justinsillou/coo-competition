echo ""
echo "Génération de la documentation"
cd src
javadoc -d ../docs/ -subpackages *

echo ""
echo "Compilation (javac */*.java -d ../bin)"
javac */*.java -d ../bin

echo ""
echo "Génération de l'archive (jar cvfm ../competition_v1.jar ../manifest *)"
cd ../bin
jar cvfm ../competition_v1.jar ../manifest *

echo ""
echo "Execution de l'archive (java -jar competition_v1.jar)"
cd ..
java -jar competition_v1.jar

echo ""
