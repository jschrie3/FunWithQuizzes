package FunWithQuizzesStudio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public abstract class Question {
    /* PROPERTIES */
    private final String question;
    private HashMap<Integer, Choice> choiceMap; // not using final in case we want to regenerate new choiceMap in the future

    /* CONSTRUCTORS */
   // we only want to generate constructor with question because we want to pass in an array of
    // choices to build a map; manually add in the Choice[] array parameter

    public Question(String question, Choice[] choiceArray) {
        this.question = question;
        // call createRandomizedChoiceMap where we will pass in the array of choices
        // anytime a question class is instantiated the constructor will call this method
        // and take in the choice array to create a randomized list of choices for the hashmap
        createRandomizedChoiceMap(choiceArray);

    }

    /* GETTERS AND SETTERS */
    // we want just getters

    public String getQuestion() {
        return question;
    }

    public HashMap<Integer, Choice> getChoiceMap() {
        return choiceMap;
    }

    /* METHODs */
    // create abstract toString method to be inherited by subclasses
    @Override
    public abstract String toString(); // abstract makes it clear that this is intended to be inherited by the subclasses

    // create method to generate random choices map
    void createRandomizedChoiceMap(Choice[] choiceArray) {
        // take parameter from constructor and assign value of empty hashmap
        choiceMap = new HashMap<>();
        // establish array list
        ArrayList<Choice> choiceList = new ArrayList<>();
        // collections class can now add all questions passed in to the hashmap
        Collections.addAll(choiceList, choiceArray);
        // then the collections class can randomize them anytime this method is called
        Collections.shuffle(choiceList);
        // loop through each choice to assign an index for the keys
        for (int i = 0; i < choiceList.size(); i++) {
            // .put is the hashmap method we use to give the key/value pair
            choiceMap.put(i + 1, choiceList.get(i)); // key will present as a number, the value will be the choice index
        }
    }

    // create method to format choices
    String getFormattedChoices() {
        // use stringbuilder so we can use the accumulator pattern to build the string a little at a time
        StringBuilder formattedChoices =  new StringBuilder();
        // loop through the keys in the hashmap
        for (int choiceNum : choiceMap.keySet()) {
            // on each loop we're going to create the choice string
            // give each choice a number (choiceNum)
            // choiceMap.get(choiceNum) - gets the choice object from the choiceMap
            // then .getContent - gets the string for the choice (content) at that number (choiceNum)
            String choice = "\t" + choiceNum + " - " + choiceMap.get(choiceNum).getContent() + "\n";
            // then use the stringbuilder and the append method to add the choice string
            formattedChoices.append(choice);
        }
        // return the formatted choices and convert them back to string
        return formattedChoices.toString();
    }
}
