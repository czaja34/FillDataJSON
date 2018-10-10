package pl.b2b;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import pl.b2b.fillData.FillPhonenumber;
import pl.b2b.fillData.GeneratePostCode;
import pl.b2b.fillData.ReadFile;

import java.io.*;
import java.util.List;

public class App {

    public static void main(String[] args) {
        ReadFile readFile = new ReadFile();
        List<String> peselList = readFile.readFile("pesel.txt");
        List<String> nrIdList = readFile.readFile("nrOsobisty.txt");
        GeneratePostCode generatePostCode = new GeneratePostCode();
        int counter = 0;
        JSONParser parser = new JSONParser();
        // Writing to a file
        FillPhonenumber fillPhonenumber = new FillPhonenumber();

        try {
            File file = new File("JsonFile.json");
            file.createNewFile();
            FileWriter fileWriter = new FileWriter(file);
            Object obj = parser.parse(new FileReader("MOCK_DATA.json"));

            JSONArray jsonArray = (JSONArray) obj;
            fileWriter.write("[");
            for (Object json : jsonArray) {
                JSONObject jsonObject = (JSONObject) json;
                jsonObject.put("pesel", peselList.get(counter));
                jsonObject.put("idnumber", nrIdList.get(counter));
                jsonObject.put("postalcode", GeneratePostCode.generatePostCode());
               jsonObject.put("phonenumber", fillPhonenumber.fillPhonenumber());
                fileWriter.write(jsonObject.toJSONString());
                fileWriter.write(",\n");
                counter++;
            }

            fileWriter.write("]");
            fileWriter.flush();
            fileWriter.close();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

}