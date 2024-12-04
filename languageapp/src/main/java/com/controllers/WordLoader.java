package com.controllers;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class WordLoader {

    public static List<String> loadWordsFromJSON(String course) {
        List<String> words = new ArrayList<>();
        try {
            // Create a JSON parser instance
            JSONParser parser = new JSONParser();
            
            // Read the JSON file
            FileReader reader = new FileReader(new File("languageapp/src/main/java/com/data/course.json"));
            JSONObject jsonObject = (JSONObject) parser.parse(reader);  // Parse the JSON
            
            // Get the "words" array from the JSON object
            JSONArray wordsArray = (JSONArray) jsonObject.get("words");

            // Add words to the list
            for (Object obj : wordsArray) {
                words.add((String) obj); // Cast the object to String
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return words;
    }

    // Method to randomly shuffle and return a list of words
    public static List<String> getRandomizedWords(List<String> words) {
        Random random = new Random();
        List<String> shuffledWords = new ArrayList<>(words);
        for (int i = 0; i < shuffledWords.size(); i++) {
            int randomIndex = random.nextInt(shuffledWords.size());
            String temp = shuffledWords.get(i);
            shuffledWords.set(i, shuffledWords.get(randomIndex));
            shuffledWords.set(randomIndex, temp);
        }
        return shuffledWords;
    }
}
