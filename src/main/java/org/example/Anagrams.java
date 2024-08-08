package org.example;

import java.util.*;

public class Anagrams {
    private static final Map<String, Set<String>> anagramMap = new HashMap<>();

    public boolean checkAnagram(String text1, String text2) {
        return sortString(text1).equals(sortString(text2));
    }

    public void addAnagram(String text1, String text2) {
        String sortedText1 = sortString(text1);
        String sortedText2 = sortString(text2);

        anagramMap.computeIfAbsent(sortedText1, k -> new HashSet<>()).add(text2);
        anagramMap.computeIfAbsent(sortedText2, k -> new HashSet<>()).add(text1);
    }

    public List<String> findAnagrams(String text) {
        String sortedText = sortString(text);
        Set<String> anagrams = anagramMap.getOrDefault(sortedText, Collections.emptySet());

        return new ArrayList<>(anagrams);
    }

    private String sortString(String text) {
        char[] chars = text.toCharArray();
        Arrays.sort(chars);

        return new String(chars);
    }
}
