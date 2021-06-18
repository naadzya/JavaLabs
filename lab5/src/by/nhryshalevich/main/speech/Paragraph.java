package by.nhryshalevich.main.speech;

import java.util.Arrays;

public class Paragraph {
    private Sentence[] sentences;

    private static String[] addDotToLastSentence(String[] allSentences) {
        // Index of last sentence
        int n = allSentences.length - 1;
        String lastChar = allSentences[n].substring(allSentences[n].length() - 1);
        if (!lastChar.equals("!") && !lastChar.equals("?")) {
            allSentences[n] += ".";
        }
        return allSentences;
    }

    public Paragraph(String paragraph) {
        String[] resultInString = addDotToLastSentence(paragraph.split("\\.|\\!\\?"));
        int n = resultInString.length;
        sentences = new Sentence[n];
        for (int i = 0; i < n; i++) {
            sentences[i] = new Sentence(resultInString[i].strip());
        }
    }

    public Sentence[] getSentences() {
        return sentences;
    }

    public void setSentences(Sentence[] sentences) {
        this.sentences = sentences;
    }

    public void setSentencesFromStr(String paragraph) {
        String[] resultInString = paragraph.split("\\.|\\!\\?");
        int n = resultInString.length;
        sentences = new Sentence[n];
        for (int i = 0; i < n; i++) {
            sentences[i] = new Sentence(resultInString[i]);;
        }
    }

    private String[] sentencesToString() {
        String[] result = new String[sentences.length];
        for (int i = 0; i < sentences.length; i++) {
            result[i] = sentences[i].toString();
        }
        return result;
    }

    public String toString() {
        return String.join(". ", sentencesToString()) + "\n";
    }

    public void breakSentencesByLength(int maxLength) {
        String original = toString();
        String result = "", dirtyResult = "", paragraphRest = original;
        int indexOfLastRestSpace = 0;
        while (paragraphRest.length() > maxLength) {
            dirtyResult = result + paragraphRest.substring(0, maxLength);
            indexOfLastRestSpace = dirtyResult.lastIndexOf(" ");
            result = dirtyResult.substring(0, indexOfLastRestSpace) + "\n";
            paragraphRest = original.substring(result.length());
        }
        result += paragraphRest;
        setSentencesFromStr(result);
    }
}
