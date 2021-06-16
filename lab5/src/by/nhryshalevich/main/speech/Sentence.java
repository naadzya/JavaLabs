package by.nhryshalevich.main.speech;

import java.util.Arrays;

public class Sentence {
    private Word[] words;

    public Sentence(String sentence) {
        // \t is TAB, \x0B is vertical tab, \f is FF (form feed), \r is CR
        // See https://docs.oracle.com/javase/8/docs/api/java/util/regex/Pattern.html
        String[] resultInString = sentence.split("[ \t\\x0B\f\r]+");
        words = new Word[resultInString.length];
        for (int i = 0; i <  resultInString.length; i++) {
               words[i] = new Word(resultInString[i]);
        }
    }

    public Word[] getWords() {
        return words;
    }

    public void setWords(Word[] words) {
        this.words = words;
    }

    private String[] wordsToStrings() {
        String[] result = new String[words.length];
        for (int i = 0; i < words.length; i++) {
            result[i] = words[i].toString();
        }
        return result;
    }

    @Override
    public String toString() {
        return String.join(" ", wordsToStrings());
    }
}
