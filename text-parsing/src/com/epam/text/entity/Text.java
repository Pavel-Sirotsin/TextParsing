package com.epam.text.entity;

import java.util.ArrayList;
import java.util.List;

public class Text implements TextPart {
    private String content;
    private List<Paragraph> paragraphList = new ArrayList<>();

    public Text() {
    }

    public Text(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Paragraph> getParagraphList() {
        return paragraphList;
    }

    public void setParagraphList(List<Paragraph> list) {
        this.paragraphList = list;
    }

    public void add(Paragraph paragraph){
        paragraphList.add(paragraph);
    }

    public void remove(Paragraph paragraph){
        paragraphList.remove(paragraph);
    }

    @Override
    public void print() {
       paragraphList.forEach(Paragraph::print);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Text text = (Text) o;

        if (content != null) {
            if (!content.equals(text.content)) return false;
        } else {
            if (text.content != null) return false;
        }
        if (paragraphList != null) return paragraphList.equals(text.paragraphList);
        return text.paragraphList == null;
    }

    @Override
    public int hashCode() {
        int result = content != null ? content.hashCode() : 0;
        result = 31 * result + (paragraphList != null ? paragraphList.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " - content: " + content + " - paragraphList: " + paragraphList.toString();
    }
}
