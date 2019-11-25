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
        return convertStringtoIntTab(secretComb);

    }

    @Override
    public int [] generateSecretCombination() {

        System.out.println("Veuillez saisir votre combinaison secrète de " + configuration.getCombSize() + " chiffres entre 0 et 9 ! ");
        input = sc.nextLine();
        return convertStringtoIntTab(secretComb);

    }

    @Override
        public int [] makeProposal () {

        System.out.println("Veuillez saisir votre proposition de " + configuration.getCombSize() + " chiffres entre 0 et 9 ! ");
        input = sc.nextLine();
        return convertStringtoIntTab(proposal);


    }

    @Override
    public void giveHint(String hint, int tryNumber) {

        System.out.print("  -> Réponse : " + hint + " ------> " + " il vous reste " + tryNumber + " essais ! ");


    }

    public int[] convertStringtoIntTab(int tab[]) {

        for (int i = 0; i < configuration.getCombSize(); i++) {
            tab[i] = Integer.parseInt(String.valueOf(input.charAt(i)));
        }

        return tab;
    }
}








































































