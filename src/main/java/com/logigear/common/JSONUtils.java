package com.logigear.common;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class JSONUtils {
    public static JSONArray getJSONList(String path){
        JSONParser jsonParser = new JSONParser();
        JSONArray objectList = new JSONArray();
        try (FileReader reader = new FileReader(path))
        {
            objectList = (JSONArray) jsonParser.parse(reader);
        }
        catch (Exception e){

        }
        return objectList;
    }

    public static void setJSONList(String path, JSONArray list){
        try (FileWriter file = new FileWriter(path)) {
            file.write(list.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
