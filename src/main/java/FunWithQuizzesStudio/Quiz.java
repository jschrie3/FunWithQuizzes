package FunWithQuizzesStudio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Quiz {
    // create an empty arraylist so the questions can be added later
    private final ArrayList<Question> questions = new ArrayList<>();
    private int numCorrect = 0; // initialize number of correct with zero

    // NO NEED FOR CONSTRUCTOR

    /*GETTERS AND SETTERS*/
    // we only need getters
    public ArrayList<Question> getQuestions() {
        return questions;
    }
    public int getNumCorrect() {
        return numCorrect;
    }

    /* INSTANCE METHODS*/
    public void addQuestions(Question[] questionArray) {
        // takes the question objects (strings) from the questionArray and puts them in the arraylist
        Collections.addAll(questions, questionArray);
    }

    // update the score by increasing the score anytime an answer is correct
    public void updateScore(){
        numCorrect++;
    }

    public void runQuiz(){
        // create a scanner to take in user input
        Scanner input = new Scanner(System.in);
        // use shuffle to shuffle the questions themselves
        Collections.shuffle(questions);
        // loop through one question at a time
        for (Question question : questions) { // for each question in arraylist questions
            // print the question and choices for the user by calling the tostring method
            System.out.println(question);
            // determine the correct responses
            // create an arraylist of integers
            ArrayList<Integer> correctResponses = new ArrayList<>();
            // loop through the arraylist
            // question.getChoiceMap().keySet() will return just the number (key) of each choice
            for (int choiceNum : question.getChoiceMap().keySet()) {
                // question.getChoiceMap().get(choiceNum) enables us to get the value at that key
                // and then determine if it is correct
                if (question.getChoiceMap().get(choiceNum).isCorrect()) {
                    // if the choice is correct, add it to the correctResponses arraylist
                    correctResponses.add(choiceNum);
                }
            }
            // get the actual responses from the user and evaluate if correct
            ArrayList<Integer> userResponses = new ArrayList<>(); // collect user responses
            // use a while loop so we don't increment if we need to go through and ask again
            int i = 0; // to keep track of how many times we've looped through
            // keep looping so long as we have an i less than number of correct responses
            while (i < correctResponses.size()) {
                System.out.println("Please enter a number: ");
                // take user response
                int userResponse = input.nextInt();
                // check if they've already given us this answer
                if (userResponses.contains(userResponse)){
                    System.out.println("You already gave that answer.");
                    // else if they give us an incorrect response
                } else if (!correctResponses.contains(userResponse)) {
                    System.out.println("Sorry that is incorrect. The correct answer is: ");
                    // loop through the correct responses in case there is more than one
                    for (int resp : correctResponses) {
                        // print each correct response
                        // .get(resp) gets the number of the correct response
                        // .getContent returns the text of the correct response
                        System.out.println(question.getChoiceMap().get(resp).getContent());
                    }
                    // break out of while loop because they've already gotten the question wrong,
                    // so there's no need to keep printing responses
                    // allow for loop to loop through again
                    break;
                } else {
                    // if the user got the answer correct
                    System.out.println("Correct!");
                    // add their response to the userResponses arraylist
                    userResponses.add(userResponse);
                    // if they've gotten to the end of all the possible correct responses
                    if (i == correctResponses.size() - 1) { // use -1 because arraylist is zero indexed
                        // give the user a point (add a point to their score)
                        updateScore();
                    }
                    // increment i up so that either the loop stops or it will allow
                    // user to enter the next response (if there are multiple responses to a question)
                    i++;
                }
            }
        }
        // close the scanner
        input.close();
    }

}
