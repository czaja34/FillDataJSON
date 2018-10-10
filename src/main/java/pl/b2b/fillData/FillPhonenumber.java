package pl.b2b.fillData;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FillPhonenumber {

    private List<String> firsNumber;

    public FillPhonenumber() {
        firsNumber = new ArrayList<>();
        firsNumber.add("50");
        firsNumber.add("51");
        firsNumber.add("53");
        firsNumber.add("57");
        firsNumber.add("60");
        firsNumber.add("66");
        firsNumber.add("69");
        firsNumber.add("72");
        firsNumber.add("73");
        firsNumber.add("78");
        firsNumber.add("79");
        firsNumber.add("88");
    }

    public String fillPhonenumber() {
        Random generator = new Random();
        int first = (generator.nextInt(12));
        int number;

        String phonenumber = firsNumber.get(first);
        for (int i = 0; i < 7; i++) {
            number = (generator.nextInt(10));
            phonenumber += number;
        }
        return phonenumber;
    }

}
