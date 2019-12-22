import java.util.Arrays;
import java.util.Scanner;

public class ChallengerMode extends GameMode {

    protected String compare;


    public ChallengerMode() {

    }

    /**
     * Method which is used to launch the Challenger Mode
     */

    @Override
    public void play(Player human, Player ai) {

        ai.generateSecretCombination(secretCombinationAI);
        while (tryNumber != configuration.maxTry + 1) {
            humanProposition = human.makeProposal();
            compare = analyseCombination(secretCombinationAI, humanProposition);
            ai.giveHint(compare, tryNumber);
            tryNumber++;
            if (compare.equals(compareStringLength())) {
                victoryHuman();
                replayGame();
            } else if (tryNumber == configuration.maxTry + 1) {
                System.out.println("Dommage vous avez perdu !");
                System.out.print("La combinaison secrète était : ");
                printArray(secretCombinationAI);
                replayGame();
            }
        }
    }

    @Override
    public void replayGame() {

        menu.endgameMenu();

        if (menu.inputChoice.equals("1")) {
            ChallengerMode challengerMode = new ChallengerMode();
            challengerMode.play(human, ai);
        }
    }
}





























