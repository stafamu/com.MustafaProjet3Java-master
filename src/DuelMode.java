import java.util.Arrays;
import java.util.Scanner;

public class DuelMode extends GameMode {


    protected int tryNumber;
    Human human = new Human();
    Scanner sc = new Scanner(System.in);


    public DuelMode() {


    }

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

                if (!found) {

                    System.out.println("");
                    System.out.print("Combinaison secrète de l'ordinateur : ");
                    Arrays.stream(combSecretComputer).forEach(System.out::print);
                    System.out.println("");
                    System.out.println("Veuillez saisir une proposition " + gameMode.getCombSize() + " chiffres entre 0 et 9");
                    propositionHuman = human.proposition();
                    found1 = ia.responseDefender(combSecretComputer, propositionHuman, tryNumber);

                } if(found1) {

                    System.out.println("Bravo vous avez gagné !");



                }
                if (found || found1) {

                    Menu menu = new Menu();
                    menu.endGameMenuMessage();
                    int inputChoice = sc.nextInt();
                    menu.endgameMenu(inputChoice);
                    if (inputChoice == 1) {
                        DuelMode duelMode = new DuelMode();
                        duelMode.playDuelMode();
                    }

                        }


                    }
                }
            }


























            /*found = ia.responseAttacker(propositionHuman, tryNumber);

            if (!found) {

                logger.info("Affichage de la combinaison secrète");
                System.out.println("");
                System.out.print("(Combinaison secrète : ");
                Arrays.stream(randomNumber).forEach(System.out::print);
                System.out.println(")");

                //for (int m = getMaxTry() - 1; m >= 0 && !found1; m--) {

                logger.info("Demande de saisir une proposition");
                System.out.println("Veuillez saisir votre proposition de " + getCombSize() + " chiffres entre 0 et 9 ! ");
                found1 = ia.responseDefender(randomNumber, b, tryNumber);

             */















































































