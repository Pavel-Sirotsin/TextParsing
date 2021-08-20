package com.epam.text.entity;

import java.util.List;

public class Paragraph implements TextPart {
    private String content;
    private List<Sentence> sentenceList;

    public Paragraph() {
    }

    public Paragraph(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Sentence> getSentenceList() {
        return sentenceList;
    }

    public void setSentenceList(List<Sentence> sentenceList) {
        this.sentenceList = sentenceList;
    }

    @Override
    public void print() {
        sentenceList.forEach(Sentence::print);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Paragraph paragraph = (Paragraph) o;

        if (content != null) {
            if (!content.equals(paragraph.content)) return false;
        } else {
            if (paragraph.content != null) return false;
        }
        if (sentenceList != null) return sentenceList.equals(paragraph.sentenceList);
        return paragraph.sentenceList == null;
    }

    @Override
    public int hashCode() {
        int result = content != null ? content.hashCode() : 0;
        result = 31 * result + (sentenceList != null ? sentenceList.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " - content: " + content + " - sentenceList: " + sentenceList.toString();
    }
}
