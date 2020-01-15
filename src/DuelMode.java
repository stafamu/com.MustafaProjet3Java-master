public class DuelMode extends GameMode {

    Human human = new Human();
    private String compareP1 = "";
    private String compareP2 = "";


    public DuelMode() {

    }

    /**
     * Method which is used to launch the Duel Mode
     */

    @Override
    public void play(Player human, Player ai) {


        secretCombinationHuman = human.generateSecretCombination();
        ai.generateSecretCombination(secretCombinationAI);

        do {
            tryNumber++;
            supposition = ai.makeProposal(maxThick, minThick);
            compareP1 = analyseCombination(secretCombinationHuman, supposition);
            intelligency(compareP1.toCharArray());
            human.giveHint(compareP1, tryNumber);
            if (compareP1.equals(compareStringLength())) {
                victoryAI();
                this.replayGame();
            }
            compareP2 = analyseCombination(secretCombinationAI, human.makeProposal());
            ai.giveHint(compareP2, tryNumber);
            if(compareP2.equals(compareStringLength())) {
                victoryHuman();
                this.replayGame();
            }
        } while (tryNumber != configuration.getMaxTry());
    }

    @Override
    public void replayGame() {

        menu.endgameMenu();

        if (menu.inputChoice.equals("1")) {
            DuelMode duelMode = new DuelMode();
            duelMode.play(human, ai);
        }
    }
}

























































































































