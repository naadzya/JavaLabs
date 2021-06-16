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
            sentences[i] = new Sentence(resultInString[i].strip());
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
        String paragraph = toString();
        // Remove last \n
        paragraph = paragraph.substring(0, paragraph.length() - 1);
        String lastLine = paragraph.substring(maxLength);
        int lastNewlineIndex = maxLength;  // index of last word \n in paragraph
        while (lastLine.length() > maxLength) {
            paragraph = paragraph.replace(lastLine, "\n" + lastLine);
            lastNewlineIndex = paragraph.lastIndexOf("\n");
            System.out.println(lastLine);
            lastLine = paragraph.substring(lastNewlineIndex + 1);
        }
        setSentencesFromStr(paragraph);
    }
}
