package com.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import com.model.Word;
import java.util.HashSet;

/**
 * @author zaniah, sri, gracie, and grace
 */

public class FillInTheBlank extends Question{

  private Phrase sampleSentence;
  private Phrase phrase;
  private ArrayList<String> wordBank;
  private String userInput;
  private String correctAnswer;
  private Phrase hint;
  private ArrayList<String> otherAnswers;

  private Word word;
 // private ArrayList

  public FillInTheBlank(String question, Phrase sampleSentence, Phrase hint, ArrayList<String> wordBank, String userInput, ArrayList<String> otherAnswers) {
      //TODO Auto-generated constructor stub
      super(question);
  
      this.sampleSentence = sampleSentence;
      this.wordBank = wordBank;
      this.hint = hint;
      this.phrase = phrase;


  }

  // public FillInTheBlank(Phrase phrase) {
  //   super(phrase.getWords());
  //   this.sampleSentence = phrase.getWords();
  //   this.wordBank = new ArrayList<>(List.of(phrase.getWords().split(" ")));
  //   this.correctAnswer = getMissingWord();
  //   this.hint = phrase.getTranslation();
  // }

  // public FillInTheBlank(Word word) {
  //   super(word.getWord());
    
  // }


  /**
   * checkAnswer method
   * Checks if the user response if correct
   * @param userInput
   * @return message + missingWord
   */
  public String checkAnswer(String userInput) 
  {
    // String missingWord = getMissingWord(); 
        if (userInput != null && userInput.equalsIgnoreCase(correctAnswer)) {
            return "You are correct! The missing word was: " + correctAnswer;
        } 
        else {
            return "Sorry, that was incorrect. The correct word is: " + correctAnswer;
        }

  }

  /**
     * getMissingWord method
     * Returns a missing word
     * @return words[index]
     */
  // public String getMissingWord() 
  // {
  //   String sentence = sampleSentence.getTranslation();
  //   String[] words = sentence.split(" ");
  //   Random random = new Random();
  //   int index = random.nextInt(words.length);
  //   return words[index];
  // }

  public String getHint() {
    if (sampleSentence != null) {
      return sampleSentence.getTranslation();
    }
    return correctAnswer;
  }

  public String getMissingWord() {
    String sentence = sampleSentence.getWords();  // Get the translated sentence
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

  public ArrayList<String> getWordBank() {
    return wordBank;
  }


  /**
     * getSampleSentence method
     * Returns sentence with a missing word
     * @return sentence
     */
  public String getSampleSentence() {
    String sentence = phrase.getWords();
    String missingWord = getMissingWord();
    return sentence.replace(missingWord, "___"); 
  }

  public ArrayList<String> findOtherAnswers () {
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
