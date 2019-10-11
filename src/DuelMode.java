import java.util.Arrays;
import java.util.Scanner;

public class DuelMode extends GameMode {


    protected int tryNumber;
    Human human = new Human();
    Scanner sc = new Scanner(System.in);


    public DuelMode() {


    }

    /**
     * Method which is used to launch the Duel Mode
     */

    public void playDuelMode() {

        GameMode gameMode = new GameMode();
        System.out.println("Veuillez saisir votre combinaison secrète de " + getCombSize() + " chiffres entre 0 et 9 ");
        int[] propositionHuman;
        int[] combSecretHuman = human.inputSecretCombination();
        int[] combSecretComputer = ia.genRandomNumber(new int[gameMode.getCombSize()]);
        boolean found = false;
        boolean found1 = false;

            for (int i = getMaxTry() - 1; i >= 0 && !found || found1; i--) {

                if (getDevMode()) {
                    System.out.print("(Combinaison secrète : ");
                    Arrays.stream(combSecretHuman).forEach(System.out::print);
                    System.out.println(")");
                }


                tryNumber = i;


                found = ia.responseAttacker(combSecretHuman, tryNumber);

                if (getDevMode()) {

                    System.out.println("");
                    System.out.print("Combinaison secrète de l'ordinateur : ");
                    Arrays.stream(combSecretComputer).forEach(System.out::print);
                    System.out.println("");


                }

                if (!found) {

                    System.out.println("Veuillez saisir une proposition " + gameMode.getCombSize() + " chiffres entre 0 et 9");
                    propositionHuman = human.proposition();
                    found1 = ia.responseDefender(combSecretComputer, propositionHuman, tryNumber);

                } if(found1) {

                    System.out.println("Bravo vous avez gagné !");



                }
                if (found || found1) {

                    Menu menu = new Menu();
                    menu.endGameMenuMessage();
                    menu.endgameMenu();
                    if (menu.inputChoice == 1) {
                        DuelMode duelMode = new DuelMode();
                        duelMode.playDuelMode();
                    }

                        }


                    }
                }
            }









































































































