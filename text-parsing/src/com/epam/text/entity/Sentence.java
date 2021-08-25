package com.epam.text.entity;

import java.util.ArrayList;
import java.util.List;

public class Sentence implements TextPart {
    private String content;
    private List<Word> wordList = new ArrayList<>();

    public Sentence() {
    }

    public Sentence(List<Word> wordList) {
        this.wordList = wordList;
    }

    public Sentence(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Word> getWordList() {
        return wordList;
    }

    public void setWordList(List<Word> wordList) {
        this.wordList = wordList;
    }

    public void add(Word word) {
        wordList.add(word);
    }

    public void remove(Word word) {
        wordList.remove(word);
    }

    @Override
    public void print() {
        wordList.forEach(Word::print);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sentence sentence = (Sentence) o;

        if (content != null) {
            if (!content.equals(sentence.content)) return false;
        } else {
            if (sentence.content != null) return false;
        }
        if (wordList != null) return wordList.equals(sentence.wordList);
        return sentence.wordList == null;
    }

    @Override
    public int hashCode() {
        int result = content != null ? content.hashCode() : 0;
        result = 31 * result + (wordList != null ? wordList.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " - content: " + content + " - wordList: " + wordList.toString();
    }

}
