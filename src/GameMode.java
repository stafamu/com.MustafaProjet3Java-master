import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ResourceBundle;

public class GameMode  {

    IA ia;
    protected int tryNumber;
    protected int[] randomNumber;
    protected int [] secretCode;
    protected static final Logger logger = LogManager.getLogger();


    private ResourceBundle myFile = ResourceBundle.getBundle("config");

    public GameMode () {


        ia = new IA(getCombSize());

        secretCode = new int[getCombSize()];
        randomNumber = ia.genRandomNumber(secretCode);
    }












    /**
     * Method for accessing the Config.properties file
     */


    public void propertyValues () {

        System.out.println("Donnèes fichier : " + myFile.getString("maxTry"));
    }

    public  Integer  getCombSize() {

        return new Integer (myFile.getString("size"))  ;


    }

    public  Integer getMaxTry() {

        return new Integer(myFile.getString("maxTry"));
    }

    public  Boolean getDevMode() {

        return new Boolean(myFile.getString("devMode"));
    }
}

