public class ChallengerMode extends GameMode {

    protected int tryNumber;
    protected int [] secretCombination;
    protected String compare = "";


    public ChallengerMode() {

        secretCombination = new int [configuration.getCombSize()];

        tryNumber = 0;


    }

    /**
     * Method which is used to launch the Challenger Mode
     */

    @Override
    public void play(Player human, Player ai) {

        ai.generateSecretCombination(secretCombination);
        while (tryNumber != configuration.maxTry) {

            compare = analyseCombination(secretCombination,human.makeProposal());

            if (compare.equals("====")) {
                logger.info("Affiche la réponse de victoire");
                System.out.println("Bravo vous avez gagné !");
                System.out.println();
                menu.endGameMenuMessage();
                menu.endgameMenu();
            } else if(tryNumber==configuration.maxTry){
                System.out.println("Dommage vous avez perdu");
            } else {
                ai.giveHint(compare,tryNumber);
                tryNumber++;
            }


        }
    }
}






















