package by.nhryshalevich.main.speech;

public class Text {
    Paragraph[] paragraphs;

    public Text(String text) {
        String[] resultInString = text.split("\n");
        paragraphs = new Paragraph[resultInString.length];
        for (int i = 0; i < resultInString.length; i++) {
            paragraphs[i] = new Paragraph(resultInString[i].strip());
        }
    }

    public Paragraph[] getParagraphs() {
        return paragraphs;
    }

    public void setParagraphs(Paragraph[] paragraphs) {
        this.paragraphs = paragraphs;
    }

    private String[] paragraphsToString() {
        String[] result = new String[paragraphs.length];
        for (int i = 0; i < paragraphs.length; i++) {
            result[i] = paragraphs[i].toString();
        }
        return result;
    }

    public String toString() {
        return String.join("\n", paragraphsToString());
    }

    public void breakParaghaphsByLength(int maxLength) {
        for (Paragraph par: paragraphs) {
            par.breakSentencesByLength();
        }
    }
}
