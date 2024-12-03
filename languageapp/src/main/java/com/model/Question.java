package com.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zaniah, sri, gracie, and grace
 */

public class Question {

    protected String question;
    /**
     * Constructor for Question
     */
    public Question() {

    }

    public Question(String question) {
        this.question = question;
    }

    /**
     * getQuestion method
     * Returns the question 
     * @return question
     */
    public String getQuestion() {

        return question;
    }

    /**
     * setQuestion method
     * Sets the question 
     * @param question
     */
    public void setQuestion(String question) {
        this.question = question;
    }

    /**
     * makeFlashcards method
     * Returns the questions for the flashcards
     * @return question for flashcards
     */
    public String makeFlashCards() {
        return "Question for flashcard" + question;
    }

     // Static arrays for different games
    public static List<Question> flashcardQuestions = new ArrayList<>();
    public static List<Question> fillInTheBlankQuestions = new ArrayList<>();
    public static List<Question> matchingQuestions = new ArrayList<>();
    public static List<Question> storyQuestions = new ArrayList<>();
    public static List<Question> mockConversationQuestions = new ArrayList<>();

    // Method for the array of questions
    public static void gameQuestions() {
        //Flashcards
        flashcardQuestions.add(new Question("Translate 'Red' to Spanish."));
        flashcardQuestions.add(new Question("Translate 'Blue' to Spanish."));
        flashcardQuestions.add(new Question("Translate 'White' to Spanish."));
        flashcardQuestions.add(new Question("Translate 'Yellow' to Spanish."));
        flashcardQuestions.add(new Question("Translate 'Purple' to Spanish."));

        //Fill in the Blank
        fillInTheBlankQuestions.add(new Question("The Spanish word for 'White' is _____ "));
        fillInTheBlankQuestions.add(new Question("The Spanish word for 'Red' is _____ "));
        fillInTheBlankQuestions.add(new Question("The Spanish word for 'Green' is _____ "));
        fillInTheBlankQuestions.add(new Question("The Spanish word for 'Black' is _____ "));
        fillInTheBlankQuestions.add(new Question("The Spanish word for 'Gray' is _____ "));

        //Matching
        matchingQuestions.add(new Question("Match 'Red' with its Spanish translation."));
        matchingQuestions.add(new Question("Match 'Pink' with its Spanish translation."));
        matchingQuestions.add(new Question("Match 'Yellow' with its Spanish translation."));
        matchingQuestions.add(new Question("Match 'Blue' with its Spanish translation."));
        matchingQuestions.add(new Question("Match 'Green' with its Spanish translation."));

        //Not really sure how to ask questions for the last two or if they even require questions??

        //Story
        //Mock Convo
      
    }

    
}
