import java.util.*;

/**
 * N-Gram Problem - Lab 2
 *
 * @author Mayank Jariwala
 * @version 0.1.0
 */
public class NGram {

    private int nGramValue;
    private List<String> nGramWords = new ArrayList<>();
    private List<String> maxOccurrenceWords = new ArrayList<>();
    private String[] nGramsWordsInput;
    private List<Integer> nGramCount = new ArrayList<>();

    // Driver Function
    public static void main(String[] args) {
        NGram nGram = new NGram();
        Scanner scanner = new Scanner(System.in);
        int noOfLines = scanner.nextInt();
        // Initialize Array Size
        nGram.nGramsWordsInput = new String[noOfLines];
        scanner.nextLine();
        String singleLineInp;
        for (int i = 0; i <= noOfLines; i++) {
            singleLineInp = scanner.nextLine();
            if (i == noOfLines)
                nGram.nGramValue = Integer.parseInt(singleLineInp);
            else
                nGram.nGramsWordsInput[i] = singleLineInp;
        }
        Arrays.asList(nGram.nGramsWordsInput).forEach(nGram::process);
        int maxValue = Collections.max(nGram.nGramCount);
        for (int k = 0; k < nGram.nGramWords.size(); k++) {
            if (nGram.nGramCount.get(k).equals(maxValue)) {
                nGram.maxOccurrenceWords.add(nGram.nGramWords.get(k));
            }
        }
        nGram.maxOccurrenceWords.sort(null);
        System.out.print(nGram.getNGramString() + " " + nGram.maxOccurrenceWords.get(0));
    }

    /**
     * @return String with NGram - UniGram,BiGram,Trigram
     */
    private String getNGramString() {
        String gramText = "";
        switch (nGramValue) {
            case 1:
                gramText = "Unigram";
                break;
            case 2:
                gramText = "Bigram";
                break;
            case 3:
                gramText = "Trigram";
                break;
            default:
                break;
        }
        return gramText;
    }

    //Processing function
    private void process(String singleLineInp) {
        boolean indexLimitReached = false;
        int startIndex = 0, lastIndex;
        do {
            lastIndex = startIndex + nGramValue;
            if (lastIndex <= singleLineInp.length()) {
                String subString = singleLineInp.substring(startIndex, lastIndex);
                if (subString.matches("[a-z]{1,}")) {
                    int index = in_list(nGramWords, subString);
                    if (index == -1) {
                        nGramWords.add(subString);
                        nGramCount.add(1);
                    } else {
                        int specificWordCount = nGramCount.get(index) + 1;
                        nGramCount.set(index, specificWordCount);
                    }
                }
                startIndex++;
            } else
                indexLimitReached = true;
        } while (!indexLimitReached);
    }

    // checks whether given value exists inside list
    private int in_list(List<String> nGramWords, String word) {
        int foundElementIndex = -1;
        if (nGramWords == null)
            return foundElementIndex;
        for (int i = 0; i < nGramWords.size(); i++) {
            if (nGramWords.contains(word)) {
                foundElementIndex = nGramWords.indexOf(word);
                break;
            }
        }
        return foundElementIndex;
    }
}
