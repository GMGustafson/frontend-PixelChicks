package com.controllers;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileReader;
import java.util.ArrayList;


import com.model.Story;

public class StoryLoader {

    public static Story loadStory(String filePath) {
        JSONParser parser = new JSONParser();
        try {
            
            JSONObject jsonObject = (JSONObject) parser.parse(new FileReader("languageapp/src/main/java/com/data/course.json"));

           
            String title = (String) jsonObject.get("title");

            JSONArray textArray = (JSONArray) jsonObject.get("text");
            JSONArray translationArray = (JSONArray) jsonObject.get("storyTranslation");

            
            String category = (String) jsonObject.get("category");

            
            ArrayList<String> text = new ArrayList<>();
            ArrayList<String> storyTranslation = new ArrayList<>();

            
            for (Object line : textArray) {
                text.add((String) line);
            }

            for (Object line : translationArray) {
                storyTranslation.add((String) line);
            }

            
            return new Story(title, text, storyTranslation, category);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
