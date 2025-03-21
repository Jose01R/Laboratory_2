package util;

import java.text.DecimalFormat;
import java.util.Random;

public class Utility {

    private static final Random random;

    //constructor static
    static {
        // SEMILLA PARA EL RANDOM
        long seed = System.currentTimeMillis();
        random = new Random(seed);
    }

    public static int random(int bound){
        // return (int) Math.floor(Math.random()*bound);
        return 1 + random.nextInt(bound);
    }

    public static void fill(int [] a){
        for (int i = 0; i < a.length; i++){
            a[i] = random(99);
        }
    }

    // FORMATO PARA TOTAL VALUE
    public static String $format(Double n) {
        return new DecimalFormat("$###,###,###.##").format(n);
    }

    // FORMATO PARA TOTAL WEIGHT
    public static String format(Double n) {
        return new DecimalFormat("###,###,###.##KG").format(n);
    }

    public static String format(long n) {
        return new DecimalFormat("###,###,###.##").format(n);
    }
}
