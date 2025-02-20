package com.model;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import java.util.HashMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * @author zaniah, sri, gracie, and grace
 */

/**
 * The DataWriter class is responsible for writing flashcard data to a JSON file.
 * It takes a list of Flashcard objects and converts them into JSON format before
 * saving them to the file.
 */
public class DataWriter extends DataConstants {

   /** 
    * Path to the JSON file where user data will be written.
    */
       /**
    * Writes a list of users to the JSON file specified in FILE_PATH.
    * This method converts each User object into a JSON representation and writes
    * the entire list of users as a JSON array to the file
    */

   @SuppressWarnings("unchecked")

   public static void saveUsers() {
        UserList users = UserList.getInstance();
        ArrayList<User> userList = users.getUsers();
        JSONArray jsonUserList = new JSONArray();

        for (int i =0; i < userList.size(); i++) {
            jsonUserList.add(getUserJSON(userList.get(i)));
        }

       try {

        String path = getFileWritingPath(FILE_NAME_USER, FILE_NAME_USER_JUNIT );
			FileWriter writer = new FileWriter(path);
			
			writer.write(jsonUserList.toJSONString());
			// writer.flush();

            //URI url = DataLoader.class.getResource(FILE_NAME_USER).toURI();  
            //FileWriter writer = new FileWriter(url.getPath());
            //writer.write(jsonUserList.toJSONString());
            //writer.flush();
    }
           catch (IOException e) {
           e.printStackTrace();
       } 
       
    }
  
    @SuppressWarnings("unchecked")
    public static JSONObject getUserJSON(User user) {
        JSONObject userDetails = new JSONObject();
        userDetails.put(USER_ID, user.getId().toString());
		userDetails.put(USER_USERNAME, user.getUsername());
		userDetails.put(USER_FIRST_NAME, user.getFirstName());
		userDetails.put(USER_LAST_NAME, user.getLastName());
        userDetails.put(USER_USERNAME, user.getUsername());
        userDetails.put(USER_EMAIL, user.getEmail());
		userDetails.put(USER_PHONE_NUMBER, user.getPhoneNumber());
        userDetails.put(USER_DATE_OF_BIRTH, user.getDateOfBirth());
        userDetails.put(USER_PASSWORD, user.getPassword());
        JSONArray coursesJSON = new JSONArray();
        HashMap<Course, Progress> courses = user.getCourses();
        for (Course course : courses.keySet()) {
            JSONObject courseJSON = new JSONObject();
            courseJSON.put(COURSE_ID, course.getCourseID().toString());
            courseJSON.put(COURSE, course.getCourse());

            Progress progress = courses.get(course);
            JSONObject progressJSON = new JSONObject();
            progressJSON.put(TOT_QUESTIONS_ANSWERED, progress.getTotalQuestionsAnswered());
            progressJSON.put(NUM_CORRECT_ANSWERS, progress.getNumCorrectAnswers());
            progressJSON.put(CURRENT_CATEGORY,progress.getCurrentCategory());
            progressJSON.put(PROGRESS_IN_CATEGORY, progress.getProgressInCategory());
            progressJSON.put(USER_STREAK, progress.getStreak());

            JSONArray missedWordsJSON = new JSONArray();
            List<String> missedWords = progress.getMissedWords();
            for (String missedWord : missedWords) {
                missedWordsJSON.add(missedWord);
            }
            progressJSON.put(MISSED_WORDS, missedWordsJSON);

            courseJSON.put(PROGRESS, progressJSON);
            coursesJSON.add(courseJSON);
        }

        userDetails.put(USER_COURSES,coursesJSON);
        return userDetails;
    }

   

   @SuppressWarnings("unchecked")
   public static void writeUsers(List<User> users) {
        JSONArray userList = new JSONArray();
        for (User user : users) {
            JSONObject userDetails = new JSONObject();
            userDetails.put("id", user.getId().toString());
            userDetails.put("firstName", user.getFirstName());
            userDetails.put("lastName", user.getLastName());
            userDetails.put("email", user.getEmail());
            userDetails.put("phoneNumber", user.getPhoneNumber());
            userDetails.put("dateOfBirth", user.getDateOfBirth().toString());
            userDetails.put("username", user.getUsername());
            userDetails.put("password", user.getPassword());
            userList.add(userDetails);
        }
        try {
            String path = getFileWritingPath(FILE_NAME_USER, FILE_NAME_USER_JUNIT );
			FileWriter writer = new FileWriter(path);
            
                writer.write(userList.toJSONString());;
                writer.flush();
         }catch (Exception e) {
            e.printStackTrace();
        }
   }

   /* 
   @SuppressWarnings("unchecked")
   public static void saveProgress(Progress progress) {
       JSONObject progressDetails = new JSONObject();

       progressDetails.put(TOT_QUESTIONS_ANSWERED, progress.getTotalQuestionsAnswered());
       progressDetails.put(NUM_CORRECT_ANSWERS, progress.getNumCorrectAnswers());
       progressDetails.put(CURRENT_CATEGORY, progress.getCurrentCategory().toString());
       progressDetails.put(PROGRESS_IN_CATEGORY, progress.getProgressInCategory());
       progressDetails.put(USER_STREAK, progress.getStreak());
       //progressDetails.put(LANGUAGE, progress.getLanguage().toString());

       JSONArray missedWordsArray = new JSONArray();
       for (String word : progress.getMissedWords()) {
           missedWordsArray.add(word);
       }
       progressDetails.put(MISSED_WORDS, missedWordsArray);

       try {
        String path = getFileWritingPath(FILE_NAME_PROGRESS, FILE_NAME_PROGR_JUNIT );
			FileWriter writer = new FileWriter(path);
        
            writer.write(progressDetails.toJSONString());
            writer.flush();
     }catch (IOException | URISyntaxException e) {
           e.printStackTrace();
       }
   }*/


   private static String getFileWritingPath(String pathName, String junitPathName) {
    try {
        if(isJUnitTest()){
            URI url = DataLoader.class.getResource(junitPathName).toURI();
            return url.getPath();
        } else {
            return pathName;
        }
    } catch(Exception e){
        System.out.println("Difficulty getting resource path");
        return "";
    }
}
}
