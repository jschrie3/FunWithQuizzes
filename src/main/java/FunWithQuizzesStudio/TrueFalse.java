package FunWithQuizzesStudio;

public class TrueFalse extends Question {
    // generate the constructor
    public TrueFalse(String question, Choice[] choiceArray) {
        super(question, choiceArray);
    }

    // write out tostring method
    @Override
    public String toString() {
        // all we need to do is return what we want to print anytime we print this quetion
        return "\nTRUE/FALSE\n" +
                //use super to call get question so we can get the question text
                super.getQuestion() + "\n" +
                // use super again to get the formatted choices
                super.getFormattedChoices() + "\n";
    }
}
