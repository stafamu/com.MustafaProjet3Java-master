public class DefenderMode extends GameMode {

    private String compare = "";

    public DefenderMode() {


    }

    /**
     * Method which is used to launch the Defenser Mode
     */

    @Override
    public void play(Player human, Player ai) {

        secretCombinationHuman = human.generateSecretCombination();

        while (tryNumber != configuration.getMaxTry() + 1 || !compare.equals(compareStringLength())) {
            supposition = ai.makeProposal(maxThick, minThick);
            compare = analyseCombination(secretCombinationHuman, supposition);
            intelligency(compare.toCharArray());
            human.giveHint(compare, tryNumber);
            tryNumber++;
            if (compare.equals(compareStringLength())) {
                victoryAI();
                this.replayGame();
            } else if (tryNumber == configuration.getMaxTry() + 1) {
                this.replayGame();
            }
        }
    }

    @Override
    public void replayGame() {

        menu.endgameMenu();

        if (menu.inputChoice.equals("1")) {
            DefenderMode defenderMode = new DefenderMode();
            defenderMode.play(human, ai);
        }
    }
}























