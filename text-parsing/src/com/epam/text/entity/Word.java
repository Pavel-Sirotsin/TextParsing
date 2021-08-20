package com.epam.text.entity;

public class Word implements TextPart {
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
        System.out.println(lexeme + " ");
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
}
