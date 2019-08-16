package com.amazon.framework;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.HashMap;

public class TestData
{
    private static HashMap<String, HashMap<String, String>> testDataMap = loadFromJSONFile();

    private TestData() {
    }

    public static HashMap<String, HashMap<String, String>> getInstance() {
        return testDataMap;
    }

    private static HashMap<String, HashMap<String, String>> loadFromJSONFile()
    {
        HashMap<String, HashMap<String, String>> dataMap = new HashMap<>();
        try {
            FileReader reader = new FileReader(Utilities.getRelativePath() + "/" + "resources" +
                    "/" + "testdata.json");
            JSONParser jsonParser = new JSONParser();
            JSONArray jsonArray = (JSONArray) jsonParser.parse(reader);
            for(Object arrayObject: jsonArray) {
                JSONObject jsonObject = (JSONObject) arrayObject;

                if(jsonObject.containsKey("testcase")){
                    dataMap.put(jsonObject.get("testcase").toString(), jsonObject);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataMap;
    }

    public static String testData(String testcase, String field) {
       String data;
       try {
           HashMap<String, String> testCaseData = testDataMap.get(testcase);
           data=testCaseData.get(field);
       } catch(Exception ex) {
           throw new RuntimeException(String.format("Test Case '%s' is not present in Test Data " +
                   "JSON file.", testcase));
       }

       if(data!=null) {
           return data;
       } else {
           throw new RuntimeException(String.format("Test data field '%s' is not defined for test case" +
                   "''%s in Test Data JSON file", field, testcase));
       }
    }
}

