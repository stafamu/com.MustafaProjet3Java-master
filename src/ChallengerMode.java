import java.util.Arrays;
import java.util.Scanner;

public class ChallengerMode extends GameMode {

    protected int tryNumber;
    Human human = new Human();
    Scanner sc = new Scanner(System.in);


    public ChallengerMode() {

        tryNumber = 0;

    }

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
            Menu menu = new Menu();
            menu.endGameMenuMessage();
            int inputChoice = sc.nextInt();
            menu.endgameMenu(inputChoice);
            if (inputChoice == 1) {
                ChallengerMode challengerMode = new ChallengerMode();
                challengerMode.playChallengerMode();

        }



        }
    }
}





