import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public abstract class GameMode {


    Configuration configuration;
    int[] proposal;
    Menu menu = new Menu();
    Human human = new Human();
    AI ai = new AI();
    int[] maxThick;
    int[] minThick;
    int[] combSize;
    static final Logger logger = LogManager.getLogger();
    //String response = "";



    public GameMode() {



        configuration = new Configuration();
        combSize = new int[configuration.getCombSize()];
        //input = human.makeSecretCombination();
    }


    public void play(Player human, Player ai) {




    }


    public boolean verifyInput(int[] combinationSize, String input) {

        if (input.length() != combinationSize.length || input.replaceAll("\\D", "").length() != combinationSize.length) {
            //Configuration.logger.info("Affiche le message d'erreur mauvaise saisi utilisateur");
            //System.out.println("Vous avez saisi un nombre incorrect --- Veuillez recommencer ! ");
        }
        return true;
    }


    public void ifDevMode(int[] combOrProposal) {

        if (configuration.getDevMode()) {

            //logger.info("Affichage de la combinaison secrète");


            System.out.println("");
            System.out.print("(Combinaison secrète : ");
            Arrays.stream(combOrProposal).forEach(System.out::print);
            System.out.println(")");
        }
    }

    public String analyseCombination(int[] combinationToFind, int[] combinationProposal) {

        String response = "";

        for (int i = 0; i < combinationToFind.length; i++) {

            if (combinationToFind[i] > combinationProposal[i]) {
                response += "-";

            } else if (combinationToFind[i] < combinationProposal[i]){
                response += "+";

            } else {
                response += "=";
            }

        }return response;
    }
}



















































