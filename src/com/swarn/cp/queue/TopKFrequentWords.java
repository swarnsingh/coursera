package com.swarn.cp.queue;

import java.util.*;

/**
 * https://leetcode.com/problems/top-k-frequent-words/submissions/1318590680/
 * <p>
 * <p>
 * Given an array of strings words and an integer k, return the k most frequent strings.
 * Return the answer sorted by the frequency from highest to lowest. Sort the words with the same frequency by their lexicographical order.
 * </p>
 *
 * <p>
 * Example 1:
 * <p>
 * Input: words = ["i","love","leetcode","i","love","coding"], k = 2
 * Output: ["i","love"]
 * Explanation: "i" and "love" are the two most frequent words.
 * Note that "i" comes before "love" due to a lower alphabetical order.
 * </p>
 * <p>
 * Example 2:
 * <p>
 * Input: words = ["the","day","is","sunny","the","the","the","sunny","is","is"], k = 4
 * Output: ["the","is","sunny","day"]
 * Explanation: "the", "is", "sunny" and "day" are the four most frequent words, with the number of occurrence being 4, 3, 2 and 1 respectively.
 *
 * </p>
 *
 * <p>
 * Constraints:
 * <p>
 * 1 <= words.length <= 500
 * 1 <= words[i].length <= 10
 * words[i] consists of lowercase English letters.
 * k is in the range [1, The number of unique words[i]]
 * <p>
 * <p>
 * Follow-up: Could you solve it in O(n log(k)) time and O(n) extra space?
 *
 * </p>
 *
 * @author Swarn Singh
 */
public class TopKFrequentWords {

    public static void main(String[] args) {
        String[] words = new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        int k = 4;
        List<String> result = topKFrequent(words, k);
        for (String word : result) {
            System.out.print(word + " ");
        }

        System.out.println();

        String[] features = new String[]{"a", "aa", "b", "c"};
        String[] responses = new String[]{"a", "a aa", "a a a a a", "b a"};

        String[] items = sortFeatures(features, responses);
        for (String item : items) {
            System.out.print(item + " ");
        }
    }

    public static List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> frequencyMap = new HashMap<>();
        for (String word : words) {
            frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
        }

        // Step 2: Use a priority queue (min-heap) to keep the top k elements
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
                (a, b) -> a.getValue() == b.getValue() ?
                        a.getKey().compareTo(b.getKey()) :
                        b.getValue().compareTo(a.getValue())
        );

        pq.addAll(frequencyMap.entrySet());

        // Step 3: Extract the elements from the priority queue
        List<String> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(pq.poll().getKey());
        }

        return result;
    }

    public static String[] sortFeatures(String[] features, String[] responses) {
        String[] items;
        Set<String> featuresSet = new HashSet();
        HashMap<String, Integer> map = new LinkedHashMap<>();

        Collections.addAll(featuresSet, features);

        for (String feature : features) {
            map.put(feature, 1);
        }

        for (String response : responses) {
            String[] arr = response.split("\\s+");
            for (String item : arr) {
                if (featuresSet.contains(item)) {
                    map.put(item, map.getOrDefault(item, 0) + 1);
                }
            }
        }

        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
                (a, b) -> a.getValue() == b.getValue() ? b.getKey().compareTo(a.getKey()) : 0
        );

        pq.addAll(map.entrySet());

        int size = pq.size();
        items = new String[size];

        for (int i = 0; i < size; i++) {
            items[i] = pq.poll().getKey();
        }

        return items;
    }
}
