package by.nhryshalevich.main.speech;

public class Word {
    private String word;
    private String type;

    public Word(String s) {
        // Constructs a new Word initialized with a string.
        // Remove white space on front and end.
        word = s.replace("\\s+", " ");
    }

    public String getWord() {
        return word;
    }

    public String getType() {
        return type;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return word;
    }
}
