import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class Human  {


    GameMode gameMode = new GameMode();
    int [] proposition;
    static final Logger logger = LogManager.getLogger();
    String saisi;


    public  Human() {

        proposition = new int [gameMode.getCombSize()] ;


    }

    protected int[] proposition() {

        Scanner clavier = new Scanner(System.in);
        saisi = clavier.nextLine();
        if (saisi.length() != proposition.length || saisi.replaceAll("\\D", "").length() != proposition.length) {
            logger.info("Affiche le message d'erreur mauvaise saisi utilisateur");
            System.out.println("Vous avez saisi un nombre incorrect. ");
            return proposition();
        }
        for (int i = 0; i < gameMode.getCombSize(); i++) {
            proposition[i] = Integer.parseInt(String.valueOf(saisi.charAt(i)));
        }
        return proposition;
    }


    }






