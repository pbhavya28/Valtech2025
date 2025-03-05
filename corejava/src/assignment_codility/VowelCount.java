package assignment_codility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class VowelCount {

    public int countVowels(String sentence) {
        int count = 0;
        String lower = sentence.toLowerCase();

        for (int i = 0; i < lower.length(); i++) {
            char ch = lower.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        List<String> sentences = new ArrayList<>();
        sentences.add("Kindergarden is not college");
        sentences.add("Today is a D-Day");
        sentences.add("Does this sentence have a vowel?");
        sentences.add("bcd fg hjklm npqrstvw xyz");
        sentences.add("fast and furious");
        sentences.add("potatoes and tomatoes");


        System.out.println("Original Sentences: " + sentences);

        VowelCount vc = new VowelCount();

        Map<String, Integer> count = new HashMap<>();
        for (String sen : sentences) {
        	count.put(sen, vc.countVowels(sen));
        }

        Map<String, Integer> sortedSen = count.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new 
                ));

        
        System.out.println("Sorted Sentences by Vowel Count: " + sortedSen);
    }
}
