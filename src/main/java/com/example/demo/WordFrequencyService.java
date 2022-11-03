package com.example.demo;

import java.util.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.*;

public class WordFrequencyService {
    private ArrayList<String> words = new ArrayList<>();

    public String determineWordFrequency(Object data) throws JsonProcessingException {
        WordFrequencyModel responseModel = new WordFrequencyModel();
        JsonObject jsonObject = new Gson().fromJson(data.toString(), JsonObject.class);
        JsonArray jsonArray = jsonObject.get("words").getAsJsonArray();

        this.populateWordsListFromRequest(jsonArray);

        responseModel.setWordMap(this.countFrequency());

        this.prettyPrintToConsole(responseModel.getMap());

        String response = this.buildJsonResponse(responseModel.getMap());
        return response;
    }

    private HashMap<String, Integer> countFrequency() {
        HashMap<String, Integer> wordFrequencyMap = new HashMap<>();
        for(String word: this.words) {
            if(wordFrequencyMap.containsKey(word)) {
                int currentCount = wordFrequencyMap.get(word);
                wordFrequencyMap.put(word, ++currentCount);
            } else {
                wordFrequencyMap.put(word, 1);
            }
        }

        return wordFrequencyMap;
    }

    private void populateWordsListFromRequest(JsonArray request) {
        for(JsonElement element : request) {
            this.words.add(element.toString());
        }
    }

    private String buildJsonResponse(HashMap<String, Integer> map) {
        ArrayList<WordCount> list = new ArrayList<>();
        for (String key : map.keySet()) {
            list.add(new WordCount(key, map.get(key)));
        }
        list.sort((o1, o2) -> o1.getCount() > o2.getCount() ? -1 : 1);

        String response = new Gson().toJson(list);

        return response;
    }

    private void prettyPrintToConsole(HashMap<String, Integer> map) {
        // Create a list from elements of HashMap
        List<Map.Entry<String, Integer> > list =
                new LinkedList<Map.Entry<String, Integer> >(map.entrySet());

        // Sort the list
        Collections.sort(list, new Comparator<Map.Entry<String, Integer> >() {
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2)
            {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });

        for (Map.Entry wordCount : list) {
            System.out.println(wordCount.getValue() + " " + wordCount.getKey());
        }
    }
}
