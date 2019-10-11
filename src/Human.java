import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class Human  {


    GameMode gameMode = new GameMode();
    int [] proposition;
    static final Logger logger = LogManager.getLogger();
    String saisi;
    String input;
    int [] inputCombinationHuman;



    public  Human() {

        proposition = new int [gameMode.getCombSize()] ;
        inputCombinationHuman = new int [gameMode.getCombSize()];


    }

    /**
     * Method which verifies the correct user input and returns the input value
     * @return
     */


    protected int[] proposition() {

        Scanner clavier = new Scanner(System.in);
        saisi = clavier.nextLine();
        if (saisi.length() != proposition.length || saisi.replaceAll("\\D", "").length() != proposition.length) {
            logger.info("Affiche le message d'erreur mauvaise saisi utilisateur");
            System.out.println("Vous avez saisi un nombre incorrect --- Veuillez recommencer ! ");
            return proposition();
        }
        for (int i = 0; i < gameMode.getCombSize(); i++) {
            proposition[i] = Integer.parseInt(String.valueOf(saisi.charAt(i)));
        }
        return proposition;
    }

    /**
     * Method which does the same as the previous one but used especially for the Secret Combination input
     * @return
     */


    protected int[] inputSecretCombination() {

        Scanner inputHuman = new Scanner(System.in);
        input = inputHuman.nextLine();
        if (input.length() != inputCombinationHuman.length || input.replaceAll("\\D", "").length() != inputCombinationHuman.length) {
            logger.info("Affiche le message d'erreur mauvaise saisi utilisateur");
            System.out.println("Vous avez saisi un nombre incorrect. ");
            return inputSecretCombination();
        }
        for (int i = 0; i < gameMode.getCombSize(); i++) {
            inputCombinationHuman[i] = Integer.parseInt(String.valueOf(input.charAt(i)));
        }
        return inputCombinationHuman;
    }


    }






