package data;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class JsonDataReader {

    public  String name,password,englishNAme,arabicName;

    public void jsonReaderForLogin() throws IOException, ParseException {
        String filePass=System.getProperty("user.dir")+"/src/test/java/data/LoginData.json";
        File file=new File(filePass);
        JSONParser parser=new JSONParser();
        JSONArray jsonarray= (JSONArray)parser.parse(new FileReader(file));
        for(Object jsonObj : jsonarray){
            JSONObject jsonObject=(JSONObject) jsonObj;
            name= (String)jsonObject.get("name");
            System.out.println(name);
            password=(String)jsonObject.get("pass");
            System.out.println(password);
        }

    }
    public void jsonReaderForEditFirstItem() throws IOException, ParseException {
        String filePass=System.getProperty("user.dir")+"/src/test/java/data/EditFirstItem.json";
        File file=new File(filePass);
        JSONParser parser=new JSONParser();
        JSONArray jsonarray= (JSONArray)parser.parse(new FileReader(file));
        for(Object jsonObj : jsonarray){
            JSONObject jsonObject=(JSONObject) jsonObj;
            englishNAme= (String)jsonObject.get("englishName");
            System.out.println(englishNAme);
            arabicName=(String)jsonObject.get("arabicName");
            System.out.println(arabicName);
        }

    }
}
