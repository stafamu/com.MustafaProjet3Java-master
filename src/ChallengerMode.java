import java.util.Arrays;


public class ChallengerMode extends GameMode {

    protected int tryNumber;
    Human human = new Human();




    public ChallengerMode() {

        tryNumber = 0;

    }

    /**
     * Method which is used to launch the Challenger Mode
     */

    public void playChallengerMode() {

        if (getDevMode()) {

            logger.info("Affichage de la combinaison secrète");
            System.out.println("");
            System.out.print("(Combinaison secrète : ");
            Arrays.stream(randomNumber).forEach(System.out::print);
            System.out.println(")");

        }

        boolean found = false;
        for (int i = getMaxTry() - 1; i >= 0 && !found; i--) {

            tryNumber = i;

            logger.info("Demande de saisir une proposition");
            System.out.println("Veuillez saisir votre proposition de " + getCombSize() + " chiffres entre 0 et 9 ! ");
            int[] b = human.proposition();
            found = ia.responseDefender(randomNumber, b, tryNumber);


        } if(found) {

            logger.info("Affiche la réponse de victoire");
            System.out.println("Bravo vous avez gagné !");
            System.out.println();
            menu.endGameMenuMessage();
<<<<<<< HEAD
            menu.endgameMenu();
            if (menu.inputChoice.equals("1")) {
                ChallengerMode challengerMode = new ChallengerMode();
                challengerMode.playChallengerMode();
=======
            //int inputChoice = sc.nextInt();
            menu.endgameMenu();
            //if (inputChoice == 1) {
                //ChallengerMode challengerMode = new ChallengerMode();
                //challengerMode.playChallengerMode();
>>>>>>> Refacto - New classes

        }



        }
    }






