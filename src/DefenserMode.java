import java.util.Arrays;

public class DefenserMode extends GameMode {


    public DefenserMode() {


    }

    /**
     * Method which is used to launch the Defenser Mode
     */


    @Override
    public void play(Player human, Player ai) {

<<<<<<< HEAD
=======

            tryNumber = i;


            found = ia.responseAttacker(propositionHuman, tryNumber);


        }

        System.out.println("");
        Menu menu = new Menu();
        menu.endGameMenuMessage();
        menu.endgameMenu();
        if (menu.inputChoice.equals("1")) {
            System.out.println("");
<<<<<<< HEAD
            DefenserMode defenserMode = new DefenserMode();
            defenserMode.playDefenserMode();
        }
>>>>>>> origin/master
    }
}



=======
            Menu menu = new Menu();
            menu.endGameMenuMessage();
            //Scanner sc = new Scanner(System.in);
            //inputChoice = sc.nextInt();
            menu.endgameMenu();
            if (inputChoice == 1) {
                System.out.println("");
                playDefenserMode();
>>>>>>> Refacto - New classes







