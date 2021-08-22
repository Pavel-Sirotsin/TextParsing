package com.epam.text.service.splitter;

import com.epam.text.entity.Text;

public abstract class Splitter {
    public static final String REGEX_PARAGRAPH = "(?<=\\n)(?!\\s)";    //  "(?!.)\\n+"  "(?<=\n)\n"
    public static final String REGEX_SENTENCE = "(?<=.?[.!?])|(?<=.\\n)"; // "(.+?[.!?])?(?(1)(?<=[.!?])|(?<=.\\n))"  "(?<=[.!?])" "(?<=.?[.!?])|(?<=.\n)"
    public static final String REGEX_WORD = "(?<=\\s|\\p{Punct})";
    //mark \s*(?<=[[:punct:]])

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
