import java.util.Arrays;

public class DuelMode extends GameMode {


    protected int tryNumber = 10;
    protected int tryNumber1;
    Human human = new Human();


    public DuelMode() {


    }

    public void playDuelMode() {

        System.out.println("Veuillez saisir votre combinaison secrète de " + getCombSize() + " chiffres entre 0 et 9 ");
        int[] propositionHuman;
        int[] combSecretHuman = human.proposition();
        int[] combSecretComputer = ia.genRandomNumber(new int[4]);
        int[] propOrdi;
        String returnComparison = "";
        String humanComparison = "";


        if (getDevMode()) {

            System.out.print("(Combinaison secrète : ");
            Arrays.stream(combSecretHuman).forEach(System.out::print);
            System.out.println(")");
            //boolean found = false;
            //boolean found1 = false;

            //for (int i = getMaxTry() - 1; i >= 0; i--) {


            //tryNumber = i;


            //for (int i = getMaxTry() - 1; i >= 0; i--) {

            //tryNumber = i;

            do {

                tryNumber--;

                propOrdi = ia.computerProposal(returnComparison, combSecretHuman);

                System.out.print(" Proposition : ");
                Arrays.stream(propOrdi).forEach(System.out::print);
                System.out.print("  -> Réponse : " + returnComparison + " ------> " + " il vous reste " + tryNumber + " essais ! ");

                do {

                    System.out.println("Combinaison secrète ordi : ");
                    Arrays.stream(combSecretComputer).forEach(System.out::print);
                    propositionHuman = human.proposition();
                    ia.responseAttacker(propositionHuman, tryNumber);

                    System.out.println("gagné ");
                }

                while (propOrdi == combSecretHuman || tryNumber == 0);

                System.out.println("perdu");
            } while (combSecretComputer == propositionHuman);
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


    }











































































