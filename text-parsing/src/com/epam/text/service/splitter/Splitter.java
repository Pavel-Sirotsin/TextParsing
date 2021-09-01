package com.epam.text.service.splitter;

import com.epam.text.entity.Text;

import java.util.regex.Pattern;

public abstract class Splitter {
    public static final String REGEX_PARAGRAPH = "(?<=[.!?])[\\r\\n]+";
    public static final String REGEX_SENTENCE = "(?<=[.!?\\n])\\s+";
    public static final String REGEX_WORD = "\\s+";

    protected Pattern paragraphPattern = Pattern.compile(REGEX_PARAGRAPH);
    protected Pattern sentencePattern = Pattern.compile(REGEX_SENTENCE);
    protected Pattern wordPattern = Pattern.compile(REGEX_WORD);

    protected Splitter nextSplitter;

    public Splitter (Splitter next) {
        this.nextSplitter = next;
    }

    public Splitter getNext() {
        return this.nextSplitter;
    }

    public void setNext(Splitter next) {
        this.nextSplitter = next;
    }

    public abstract void split(SplitType type, Text text);
}
