import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public abstract class GameMode {

    protected int tryNumber = 1;
    protected static final Logger logger = LogManager.getLogger();
    Menu menu = new Menu();
    Configuration configuration;
    Human human = new Human();
    AI ai = new AI();
    int[] maxThick;
    int[] minThick;
    int combSize;
    protected int[] secretCombinationHuman;
    protected int[] secretCombinationAI;
    int[] supposition;
    int[] humanProposition;
    int maxTry;


    public GameMode() {

        configuration = new Configuration();
        combSize = configuration.getCombSize();
        secretCombinationHuman = new int[configuration.getCombSize()];
        secretCombinationAI = new int[configuration.getCombSize()];
        maxTry = configuration.getMaxTry();
        maxThick = new int[combSize];
        minThick = new int[combSize];
        initValue(maxThick, 9);
        initValue(minThick, 0);


    }


    public void play(Player human, Player ai) {


    }

    public void replayGame() {

    }

    public String analyseCombination(int[] combinationToFind, int[] combinationProposal) {

        String response = "";


        for (int i = 0; i < combinationToFind.length; i++) {


            if (combinationToFind[i] > combinationProposal[i]) {
                response += "+";

            } else if (combinationToFind[i] < combinationProposal[i]) {
                response += "-";

            } else {
                response += "=";
            }

        }
        return response;
    }

    /**
     * Method which compares two Strings
     * @return
     */


    public String compareStringLength() {
        String stringLength = new String();

        for (int i = 0; i < combSize; i++) {
            stringLength += "=";
        }
        return stringLength;
    }

    private void initValue(int[] tab, int value) {

        for (int i = 0; i < tab.length; i++) {
            tab[i] = value;
        }
    }

    public void intelligence(char[] combinationPlusMinus) {

        for (int i = 0; i < configuration.getCombSize(); i++) {

            if (combinationPlusMinus[i] == '-') {
                maxThick[i] = supposition[i];

            } else if (combinationPlusMinus[i] == '+') {
                minThick[i] = supposition[i] + 1;


            }
        }
    }

    public void printArray(int[] arrayToPrint) {

        for (int i = 0; i < arrayToPrint.length; i++) {

            System.out.print(arrayToPrint[i]);
        }


    }

    public void victoryHuman() {

        logger.info("Affiche la réponse de victoire");
        System.out.println("Bravo vous avez gagné !");
        System.out.print("Vous avez trouvé la combinaison secrète : ");
        printArray(secretCombinationAI);
        System.out.print(" en " + (tryNumber - 1) + " essai(s) ");
        System.out.println();
    }

    public void victoryAI() {

        logger.info("Affiche la réponse de la défaite");
        System.out.println("Dommage vous avez perdu !");
        System.out.print("L'ordinateur a trouvé la combinaison secrète : " );
        printArray(secretCombinationHuman);
        System.out.print(" en " + (tryNumber - 1) + " essai(s) ");
        System.out.println();
    }
}























































