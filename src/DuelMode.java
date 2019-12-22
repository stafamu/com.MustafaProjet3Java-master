import java.util.Arrays;
import java.util.Scanner;

public class DuelMode extends GameMode {


    Human human = new Human();
    protected String compareP1 = "";
    protected String compareP2 = "";


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
            supposition = ai.makeProposal(maxThick, minThick);
            compareP1 = analyseCombination(secretCombinationHuman, supposition);
            intelligence(compareP1.toCharArray());
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
            tryNumber++;
        } while (tryNumber != configuration.maxTry);
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

























































































































