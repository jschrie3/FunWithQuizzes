package FunWithQuizzesStudio;

public class Choice {
    // make them private and final because we won't need to change them
    private final String content;
    private final boolean correct;

    /* CONSTRUCTOR */
    // right-click > generate > constructor
    public Choice(String content, boolean correct) {
        this.content = content;
        this.correct = correct;
    }

    // create a secondary constructor where we can just give content and it defaults to false
    public Choice(String content) {
        this(content, false); // use "this" to call the first constructor
    }

    /* GETTERS AND SETTERS */
    // just creating getters so we can tap into the content in this class

    public String getContent() {
        return content;
    }

    public boolean isCorrect() {
        return correct;
    }
}
