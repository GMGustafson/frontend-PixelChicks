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

public class FillInTheBlank extends Question{
    // Attributes
  private Phrase hint;
  private Phrase sampleSentence;
  private ArrayList<String> wordBank;
  private String userInput;
  private Word word;
  private ArrayList<String> otherAnswers;

  public FillInTheBlank(String question, Phrase hint, Phrase sampleSentence, ArrayList<String> wordBank) {
      //TODO Auto-generated constructor stub
      super(question);
      this.sampleSentence = sampleSentence;
      this.wordBank = wordBank;
      this.hint = hint;
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

  // public String getMissingWord() 
  // {
  //   String sentence = sampleSentence.getWords();
  //   String[] words = sentence.split(" ");
  //   Random random = new Random();
  //   int index = random.nextInt(words.length);
  //   return words[index];
  // }

  public String getMissingWord() {
    String sentence = sampleSentence.getTranslation();  // Get the translated sentence
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

    
  public String getSampleSentence() {
    String sentence = sampleSentence.getWords();
    String missingWord = getMissingWord();
    return sentence.replace(missingWord, "___"); 
  }

  public String getHint() {
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

}

