package com.epam.text.entity;

import java.util.List;

public class Text {
    List<Sentence> sentences;

    public Text() {
    }

    public Text(List<Sentence> sentences) {
        this.sentences = sentences;
    }

    public List<Sentence> getSentences() {
        return sentences;
    }

    public void setSentences(List<Sentence> sentences) {
        this.sentences = sentences;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Text text = (Text) o;

        if (sentences != null) return sentences.equals(text.sentences);
        return text.sentences == null;
    }

    @Override
    public int hashCode() {
        return sentences != null
                ? sentences.hashCode()
                : 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Text:\n");
        sentences.forEach(sb::append);
        return sb.toString();
    }
}
