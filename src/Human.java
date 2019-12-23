import java.util.Scanner;

public class Human extends Player {

    Scanner sc = new Scanner(System.in);
    private int[] secretComb = new int[configuration.getCombSize()];
    private int[] proposal = new int[configuration.getCombSize()];
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

        try {
            System.out.println("Veuillez saisir votre combinaison secrète de " + configuration.getCombSize() + " chiffres entre 0 et 9 ! ");
            input = sc.nextLine();
            if(input.length()!=configuration.getCombSize()) {
                throw new Exception();
            }
            if (configuration.getDevMode()) {
                logger.info("Affichage de la combinaison secrète Humain");
                System.out.print("(Combinaison secrète : " + input);
                System.out.println(")");
            }
            return convertStringtoIntTab(secretComb);

        } catch (Exception e) {
            Configuration.logger.info("Affiche le message d'erreur mauvaise saisi utilisateur");
            System.out.println("Vous avez saisi un nombre incorrect --- Veuillez recommencer ! ");
            return generateSecretCombination();
        }
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
            System.out.print("Proposition : " + input);
            if(input.length()!=configuration.getCombSize()) {
                throw new Exception();
            }
            return convertStringtoIntTab(proposal);
        } catch (Exception e) {
            Configuration.logger.info("Affiche le message d'erreur mauvaise saisi utilisateur");
            System.out.println("Vous avez saisi un nombre incorrect --- Veuillez recommencer ! ");
            return makeProposal();
        }
    }

    @Override
    public void giveHint(String hint, int tryNumber) {

        System.out.print("  -> Réponse : " + hint + " ------> " + " il vous reste " + (configuration.getMaxTry() - tryNumber) + " essais ! ");
        System.out.println();


    }

    public int[] convertStringtoIntTab(int tab[]) {


        for (int i = 0; i < configuration.getCombSize(); i++) {
            tab[i] = Integer.parseInt(String.valueOf(input.charAt(i)));
        }
        return tab;
    }
}




























































































