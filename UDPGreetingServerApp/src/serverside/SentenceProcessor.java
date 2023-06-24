package serverside;

/**
 * An example of sentenceProcessor method
 * @author nurulhannan
 */
public class SentenceProcessor {
    private String sentence;

    public SentenceProcessor(byte[] byteData) {
        this.sentence = new String(byteData);
    }

    public String getSentence() {
        return sentence;
    }

    public int countVowels() {
        int count = 0;
        String vowels = "aeiouAEIOU";
        for (char c : sentence.toCharArray()) {
            if (vowels.indexOf(c) != -1) {
                count++;
            }
        }
        return count;
    }

    public int countConsonants() {
        int count = 0;
        String consonants = "bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ";
        for (char c : sentence.toCharArray()) {
            if (consonants.indexOf(c) != -1) {
                count++;
            }
        }
        return count;
    }

    public int countPunctuation() {
        int count = 0;
        String punctuation = ".,;:!?";
        for (char c : sentence.toCharArray()) {
            if (punctuation.indexOf(c) != -1) {
                count++;
            }
        }
        return count;
    }
}
