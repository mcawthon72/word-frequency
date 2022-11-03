package com.example.demo;

import java.util.HashMap;

public class WordFrequencyModel {

    private HashMap<String, Integer> wordMap = new HashMap<>();

    public void addToMap(String word, int frequency ) {
        this.wordMap.put(word, frequency);
    }

    public HashMap<String, Integer> getMap() {
        return this.wordMap;
    }

    public void setWordMap(HashMap<String, Integer> map) { this.wordMap = map; }

}
