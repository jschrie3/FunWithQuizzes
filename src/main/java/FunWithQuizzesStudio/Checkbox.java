package FunWithQuizzesStudio;

public class Checkbox extends Question {
    // generate the constructor
    public Checkbox(String question, Choice[] choiceArray) {
        super(question, choiceArray);
    }

    // write out tostring method
    @Override
    public String toString() {
        // all we need to do is return what we want to print anytime we print this quetion
        return "\nCHECKBOX - Choose 1 or more.\n" +
                //use super to call get question so we can get the question text
                super.getQuestion() + "\n" +
                // use super again to get the formatted choices
                super.getFormattedChoices() + "\n";
    }
}
