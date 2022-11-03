package com.example.demo;

public class WordCount {
    private String word;
    private int count;

    WordCount(String word, int count) {
        this.word = word;
        this.count = count;
    }

    public String getWord() {
        return this.word;
    }

    public int getCount() {
        return this.count;
    }
}
