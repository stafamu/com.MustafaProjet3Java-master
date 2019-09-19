import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.Scanner;

public class IA {

    int[] maxThick;
    int[] minThick;
    int[] proposal;
    int maxTry;
    int combinationSize;
    String strCompareChallenger;
    String strCompareDefenser;
    Scanner sc = new Scanner(System.in);
    static final Logger logger = LogManager.getLogger();
    int[] oldComputerProposal;


    public IA(int size) {

        maxThick = new int[size];
        minThick = new int[size];
        initValue(maxThick, 9);
        initValue(minThick, 0);


    }

    private void initValue(int[] tab, int value) {

        for (int i = 0; i < tab.length; i++) {
            tab[i] = value;
        }
    }

    public boolean responseDefender(int[] randomNumber, int[] pUtilisateur, int tryNumber) {

        String str = "";
        strCompareChallenger = "";
        for (int i = 0; i < randomNumber.length || str.equals(strCompareChallenger); i++) {
            if (randomNumber[i] == pUtilisateur[i]) {
                str += "=";


            } else if (randomNumber[i] < pUtilisateur[i]) {
                str += "-";


            } else if (randomNumber[i] > pUtilisateur[i]) {
                str += "+";


            }

        }
        logger.info("Affiche indice ordinateur + le nombre d'essais restants");
        System.out.println(" -> Réponse : " + str + " ------> " + " il vous reste " + tryNumber + " essais ! ");
        for (int i = 0; i < str.length(); i++) {
            strCompareChallenger += "=";
        }
        if (str.equals(strCompareChallenger))
            return true;
        return false;

    }













    public boolean responseAttacker(int[] secretComb, int tryNumber) {


        GameMode gameMode = new GameMode();
        maxTry = gameMode.getMaxTry();
        combinationSize = gameMode.getCombSize();
        strCompareDefenser = "";

        // condition  if (human n'as pas trouvé la combinaison secrète, demander à l'ordinateur de jouer (boucler))


        int[] secretNumber = new int[combinationSize];
        String str = "";
        for (int i = 0; i < secretComb.length; i++) {
            secretNumber[i] = ((minThick[i] + maxThick[i]) / 2);
            for (int j = 0; j < secretNumber.length; j++)
                proposal = secretNumber;


            if (secretComb[i] == secretNumber[i]) {
                str += "=";


            } else if (secretComb[i] < secretNumber[i]) {
                maxThick[i] = secretNumber[i];
                str += "-";


            } else if (secretComb[i] > secretNumber[i]) {
                minThick[i] = secretNumber[i] + 1;
                str += "+";


            }


        }
        logger.info("Affiche la proposition de l'ordinateur + la réponse de joueur + le nombre d'essais restants ");
        System.out.print(" Proposition : ");
        Arrays.stream(proposal).forEach(System.out::print);
        System.out.print("  -> Réponse : " + str + " ------> " + " il vous reste " + tryNumber + " essais ! ");
        for (int i = 0; i < str.length(); i++) {
            strCompareDefenser += "=";

        }
        if (str.equals(strCompareDefenser)) {
            logger.info("Affiche la réponse de défaite et la combinaison secrète");
            System.out.print("Vous avez perdu ! " + "L'ordinateur a trouvé la combinaison secrète : ");
            Arrays.stream(secretComb).forEach(System.out::print);
            System.out.print(" en " + (maxTry - tryNumber) + " essais !");
            initValue(maxThick, 9);
            initValue(minThick, 0);

            return true;


        }
        return false;
    }


    public int[] genRandomNumber(int[] tab) {

        for (int i = 0; i < tab.length; i++) {
            tab[i] = (int) (Math.random() * 9 + 0);

        }

        return tab;


    }
}

    /*public int[] computerProposal (String humanResponse, int[] humanSecretComb) {

        GameMode gameMode = new GameMode();

        int[] newComputerProposal = new int[gameMode.getCombSize()];

        for (int i = 0; i < humanSecretComb.length; i++) {
            newComputerProposal[i] = ((minThick[i] + maxThick[i]) / 2);
            for (int j = 0; j < newComputerProposal.length; j++)
                oldComputerProposal = newComputerProposal;


            if (humanSecretComb[i] == newComputerProposal[i]) {
                humanResponse += "=";


            } else if (humanSecretComb[i] < newComputerProposal[i]) {
                maxThick[i] = newComputerProposal[i];
                humanResponse += "-";


            } else if (humanSecretComb[i] > newComputerProposal[i]) {
                minThick[i] = newComputerProposal[i] + 1;
                humanResponse += "+";
            }
        }
        return newComputerProposal;

    }



    }

     */






































