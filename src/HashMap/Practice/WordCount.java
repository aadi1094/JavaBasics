package HashMap.Practice;

import java.util.HashMap;
import java.util.Scanner;

public class WordCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a sentence:");

        // Convert to lowercase, remove punctuation/quotes, and trim spaces
        String sentence = sc.nextLine()
                .toLowerCase()
                .replaceAll("[^a-z0-9\\s]", "")
                .trim();

        HashMap<String, Integer> wordCounts = new HashMap<>();

        if (!sentence.isEmpty()) {
            String[] words = sentence.split("\\s+");

            for (String word : words) {
                wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
            }
        }

        System.out.println(wordCounts);
        sc.close();
    }
}
