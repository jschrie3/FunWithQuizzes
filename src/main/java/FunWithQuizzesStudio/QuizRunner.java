package FunWithQuizzesStudio;

public class QuizRunner {
    // if quiz is created outside of the main method, it must be designated as static
    private static final Quiz quiz = new Quiz();

    // establish main method
    public static void main(String[] args) {
        // QUESTION 1
        String q1 = "Which of the following are books by Jane Austen?";
        // establish q1 choice array
        Choice[] q1Choices = new Choice[] {
                // add answer choices
                new Choice("Jane Eyre"),
                // we can use the secondary constructor we created to indicate whether an answer is correct
                new Choice("Pride and Prejudice", true),
                new Choice("Wives and Daughters"),
                new Choice("Mansfield Park", true)
        };
        // now we establish the type of question
        Checkbox question1 = new Checkbox(q1, q1Choices); // we give it the question string (q1) and array of answer choices

        // QUESTION 2
        String q2 = "The most published author of all time is Agatha Christie.";
        // establish q2 choice array
        Choice[] q2Choices = new Choice[] {
                // add answer choices
                new Choice("True", true),
                new Choice("False")
        };
        // now we establish the type of question
        TrueFalse question2 = new TrueFalse(q2, q2Choices);

        // QUESTION 3
        String q3 = "Which poem did Amanda Gorman recite at the 2021 presidential inauguration?";
        // establish q3 choice array
        Choice[] q3Choices = new Choice[] {
                // add answer choices
                new Choice("The Miracle of Morning"),
                new Choice("The Hill We Climb", true),
                new Choice("We Rise"),
                new Choice("New Day's Lyric")
        };
        // now we establish the type of question
        MultipleChoice question3 = new MultipleChoice(q3, q3Choices);

        // add questions to the quiz
        quiz.addQuestions(new Question[] {question1, question2, question3});

        // now that the quiz has questions we can run it
        quiz.runQuiz();

        // print the score
        System.out.println("\nYou answered " + quiz.getNumCorrect() +
                " of " + quiz.getQuestions().size() + " questions correctly. Thanks for playing!\n");
    }
}
