package FunWithQuizzesStudio;

// we want to extend question so we can inherit from question class
public class MultipleChoice extends Question {
    // generate the constructor
    public MultipleChoice(String question, Choice[] choiceArray) {
        super(question, choiceArray); // intelliJ called super for us
    }

    // write out tostring method
    @Override
    public String toString() {
        // all we need to do is return what we want to print anytime we print this quetion
        return "\nMULTIPLE CHOICE\n" +
                //use super to call get question so we can get the question text
                super.getQuestion() + "\n" +
                // use super again to get the formatted choices
                super.getFormattedChoices() + "\n";
        }
}
