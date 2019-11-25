
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.util.Scanner;

public class Menu {

    protected static final Logger logger = LogManager.getLogger();
    Scanner sc = new Scanner(System.in);
    String inputChoice;


    public Menu() {


    }

    /**
     * Method used to show the welcome Menu
     */


    public void welcomeMenu() {

        logger.info("Affichage du menu d'accueil");

        System.out.println("Bienvenue dans Escape Game ONLINE  ");
        System.out.println("Veuillez choisir votre mode : ");
        System.out.println("*************************************");
        System.out.println("1 - Challenger");
        System.out.println("2 - Défenseur");
        System.out.println("3 - Duel");
        System.out.println("**************************************");

        int input = sc.nextInt();
        String choice = "";
        if (input == 1) {
            choice = "Challenger";
        } else if (input == 2) {
            choice = "Défenseur";
        } else if (input == 3) {
            choice = "Duel";
        } else {
            System.out.println("Vous avez saisi un choix incorrect veuillez recommencer ");
            System.out.println();
            this.welcomeMenu();

        }

        System.out.println("Vous avez choisi le mode : " + choice);


        if (input == 1) {
            ChallengerMode challengerMode = new ChallengerMode();
            challengerMode.playChallengerMode();
        } else if (input == 2) {
            DefenserMode defenserMode = new DefenserMode();
            defenserMode.playDefenserMode();
        } else if (input == 3) {
            DuelMode duelMode = new DuelMode();
            duelMode.playDuelMode();
        }

    }

<<<<<<< HEAD
    public void endgameMenu() {

        inputChoice = sc.nextLine();

=======
    public void endgameMenu () {
        inputChoice = sc.nextLine();

>>>>>>> Refacto - New classes
        if (!inputChoice.equals("1") && !inputChoice.equals("2") && !inputChoice.equals("3")) {
            System.out.println("Vous avez saisi un mauvais nombre ! --- Veuillez recommencer! ");
            System.out.println("");
            this.endGameMenuMessage();
            this.endgameMenu();
        }else if (inputChoice.equals("2")) {
            this.welcomeMenu();
        } else if (inputChoice.equals("3")) {
<<<<<<< HEAD
                System.out.println("Merci d'avoir joué à bientôt !");
                System.exit(0);
=======
            System.out.println("Merci d'avoir joué à bientôt !");
            System.exit(0);

        }
>>>>>>> Refacto - New classes

            }



<<<<<<< HEAD
        }

        public void endGameMenuMessage () {
=======

    public void endGameMenuMessage () {
>>>>>>> Refacto - New classes

        logger.info("Affichage du menu de fin de jeu");
        System.out.println("1 - Souhaitez vous rejouer au même mode ?");
        System.out.println("2 - Revenir vers le menu principal");
        System.out.println("3 - Quitter l'application");
    }
}
