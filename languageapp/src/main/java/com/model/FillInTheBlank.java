package com.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import com.model.Word;
import java.util.HashSet;
import com.model.CategorySystemFacade;

/**
 * @author zaniah, sri, gracie, and grace
 */

public class FillInTheBlank extends Question  {
    // Attributes
  private String hint;
  private Phrase sampleSentence;
  private ArrayList<String> wordBank;
  private String userInput;
  private Word word;
  private Course course;
  private String missingWord;
  private ArrayList<String> otherAnswers;
  private ArrayList<Phrase> phrases; 
  private String sentence;
  
  public FillInTheBlank() {

  }

  public FillInTheBlank(String question) {
    super(question);
  }

  public void setSampleSentence (Phrase sampleSentence) {
    this.sampleSentence = sampleSentence;
  }

  public Phrase getSampleSentence () {
    return sampleSentence;
  }

  public void setSentence(String sentence) {
    this.sentence = sentence;
  }

  public String getSentence() {
    if (sampleSentence == null) {
      return "No sampleSentence available.";
    }
    sentence = sampleSentence.getWords();
    missingWord = getMissingWord();
    return sentence.replace(missingWord, "___"); 
  }

  public ArrayList<String> generateWordBank() {
    ArrayList<String> altWords = word.getAlternatives();
    wordBank = new ArrayList<String>();
    Random random = new Random();
    while ( wordBank.size() < 3 && !altWords.isEmpty()) {
      int randomIndex = random.nextInt(altWords.size());
      String selectedAlternative = altWords.get(randomIndex);

      if (!wordBank.contains(selectedAlternative)) {
        wordBank.add(selectedAlternative);
      }
    }
    return wordBank;
  }

  public String getMissingWord() { 
    // if (sampleSentence == null) {
    //   throw new IllegalStateException("sampleSentence is not set! Please set it before continuing!");
    // } // Get the translated sentence
    sentence = sampleSentence.getWords();
    String[] words = sentence.split(" ");               // Split the sentence into individual words
    Random random = new Random();                       // Create a random object
    ArrayList<String> wordBank = getWordBank();         // Assume this method retrieves the current word bank

    String chosenWord = null;
    do {
        int index = random.nextInt(words.length);       // Select a random index from the sentence words
        chosenWord = words[index];                      // Pick the word at that index
    } while (!wordBank.contains(chosenWord));           // Keep looping until the chosen word is in the word bank

    return chosenWord;                                  
}

  public String getSampleHint() {
    String hint = sampleSentence.getTranslation();
    return hint;
  }
 
  public ArrayList<String> getWordBank() {
    return wordBank;
  }

  public ArrayList<String> getOtherAnswers() {
    otherAnswers = word.getAlternatives();
    ArrayList<String> selectedAnswers = new ArrayList<>();
    HashSet<Integer> indices = new HashSet<>();
    Random random = new Random();
    while (indices.size() < 3 && indices.size() < otherAnswers.size()) {
      int index = random.nextInt(otherAnswers.size());
      if (indices.add(index)) {
        selectedAnswers.add(otherAnswers.get(index));
      }
    }
      return selectedAnswers; 
  }

  public String checkAnswer(String userInput) 
  {
    String missingWord = getMissingWord(); 
        if (userInput != null && userInput.equalsIgnoreCase(missingWord)) {
            return "You are correct! The missing word was: " + missingWord;
        } 
        else {
            return "Sorry, that was incorrect. The correct word is: " + missingWord;
        }
  }

}

