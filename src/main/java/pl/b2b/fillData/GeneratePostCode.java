package pl.b2b.fillData;

import java.util.Random;

public class GeneratePostCode {

    public static String generatePostCode() {
        Random generator = new Random();

        int first = (generator.nextInt(10));
        int secon = (generator.nextInt(10));
        int third = (generator.nextInt(10));
        int fourth = (generator.nextInt(10));
        int fifth = (generator.nextInt(10));
        return first + "" + secon + "-" + third + fourth + fifth;
    }
}
