import java.util.Arrays;
import java.util.Scanner;

public class Human extends Player {

    Scanner sc = new Scanner(System.in);
    int[] secretComb = new int[configuration.getCombSize()];
    int[] proposal = new int[configuration.getCombSize()];
    String input;


    public Human() {


    }

    @Override
    public int[] generateSecretCombination(int[] tab) {
        System.out.println("Veuillez saisir votre combinaison secrète de " + configuration.getCombSize() + " chiffres entre 0 et 9 ! ");
        input = sc.nextLine();
        if (configuration.getDevMode()) {
            logger.info("Affichage de la combinaison secrète");
            System.out.print("(Combinaison secrète : " + input);
            System.out.println(")");
        }
        return convertStringtoIntTab(secretComb);

    }

    @Override
    public int[] generateSecretCombination() {


        System.out.println("Veuillez saisir votre combinaison secrète de " + configuration.getCombSize() + " chiffres entre 0 et 9 ! ");
        input = sc.nextLine();
        while(verifyInput(input)){
            return generateSecretCombination();
        }
        if (configuration.getDevMode()) {
            logger.info("Affichage de la combinaison secrète Humain");
            System.out.print("(Combinaison secrète : " + input);
            System.out.println(")");
        }
        return convertStringtoIntTab(secretComb);
    }


    @Override
    public int[] makeProposal(int[] max, int[] min) {
        return new int[0];
    }

    @Override
    public int[] makeProposal() {

        try {
            System.out.println("Veuillez saisir votre proposition de " + configuration.getCombSize() + " chiffres entre 0 et 9 ! ");
            input = sc.nextLine();
            while(verifyInput(input)){
                return makeProposal();
            }
            System.out.print("Proposition : " + input);
        } catch (Exception e) {
            System.out.println("Vous ave saisi un mauvais nombre");
        }
        return convertStringtoIntTab(proposal);


    }

    @Override
    public void giveHint(String hint, int tryNumber) {

        System.out.print("  -> Réponse : " + hint + " ------> " + " il vous reste " + (configuration.getMaxTry() - tryNumber) + " essais ! ");
        System.out.println();


    }

    public int[] convertStringtoIntTab(int tab[]) {

        try {
            for (int i = 0; i < configuration.getCombSize(); i++) {
                tab[i] = Integer.parseInt(String.valueOf(input.charAt(i)));
            }
        } catch (Exception e) {

            System.out.println("Vous avez saisi un ");
        }
        return tab;
    }

    public boolean verifyInput(String input) {

        if (input.length() != configuration.getCombSize() || input.replaceAll("\\D", "").length() != configuration.getCombSize()) {
            Configuration.logger.info("Affiche le message d'erreur mauvaise saisi utilisateur");
            System.out.println("Vous avez saisi un nombre incorrect --- Veuillez recommencer ! ");
            return true;
        }
        return false;
    }
}

























































































