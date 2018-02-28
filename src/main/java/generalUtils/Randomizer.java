package generalUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Randomizer {

    private DateFormat dateFormat = new SimpleDateFormat("yyMMdd_HHmm_");
    private Date date = new Date();
    private Random rnd = new Random();

    private static Randomizer ourInstance = new Randomizer();

    private String rand = dateFormat.format(date) + (100 + rnd.nextInt(900));

    private int numericRand = 100000 + rnd.nextInt(900000);

    public String getRand(){
        return rand;
    }

    public int getNumericRand(){
        return numericRand;
    }

    public static Randomizer getInstance() {
        return ourInstance;
    }

    private Randomizer() {
    }
}
