package com.epam.text.entity;


public class Word implements TextPart, Comparable<Word> {
    private String lexeme;

    public Word() {
    }

    public Word(String lexeme) {
        this.lexeme = lexeme;
    }

    public String getLexeme() {
        return lexeme;
    }

    public void setLexeme(String lexeme) {
        this.lexeme = lexeme;
    }

    @Override
    public void print() {
        if (lexeme.equalsIgnoreCase(" *** IN-HONOR-Of-STRING *** ")) {
            String red = "\u001B[32m";
            String reset = "\u001B[0m";
            System.out.print(red + lexeme + " " + reset);
        } else {
            System.out.print(lexeme + " ");
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Word word = (Word) o;

        if (lexeme != null) return lexeme.equals(word.lexeme);
        return word.lexeme == null;
    }

    @Override
    public int hashCode() {
        return lexeme != null ? lexeme.hashCode() : 0;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " - lexeme: " + lexeme;
    }

    @Override
    public int compareTo(Word o) {
        return lexeme.compareTo(o.lexeme);
    }
}
