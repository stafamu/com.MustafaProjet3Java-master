import java.util.Arrays;
import java.util.Scanner;

public class DefenserMode extends GameMode {


    int inputChoice;


    public DefenserMode() {


    }

    /**
     * Method which is used to launch the Defenser Mode
     */


    public void playDefenserMode() {

        Human human = new Human();
        System.out.println("Veuillez saisir votre combinaison secrète de " + getCombSize() + " chiffres entre 0 et 9 ");
        int [] propositionHuman= null;
        propositionHuman = human.proposition();

        if (getDevMode() ) {

            System.out.print("(Combinaison secrète : ");
            Arrays.stream(propositionHuman).forEach(System.out::print);
            System.out.println(")");
        }

            boolean found = false;
            for (int i = getMaxTry() - 1; i >= 0 && !found; i--) {


                tryNumber = i;


                found = ia.responseAttacker(propositionHuman, tryNumber);


            }

            System.out.println("");
            Menu menu = new Menu();
            menu.endGameMenuMessage();
            Scanner sc = new Scanner(System.in);
            inputChoice = sc.nextInt();
            menu.endgameMenu(inputChoice);
            if (inputChoice == 1) {
                System.out.println("");
                playDefenserMode();

            }


        }

    }


