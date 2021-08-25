package com.epam.text.service.impl;

import com.epam.text.entity.Paragraph;
import com.epam.text.entity.Sentence;
import com.epam.text.entity.Text;
import com.epam.text.entity.Word;
import com.epam.text.service.TextService;

import java.util.*;

public class TextServiceImpl implements TextService {

    private void swap(LinkedList<Word> exchange) {
        Word first, last;
        if ((first = exchange.pollFirst()) != null
                && (last = exchange.pollLast()) != null) {

            exchange.addFirst(last);
            exchange.addLast(first);
        }

    }

    @Override
    public int doSentenceInWordIncreasing(Text workSample) {
        List<Sentence> allTogether = new ArrayList<>();

        for (Paragraph paragraph : workSample.getParagraphList()) {
            for (Sentence sentence : paragraph.getSentenceList()) {
                allTogether.add(sentence);
            }
        }

        Collections.sort(allTogether, new Comparator<Sentence>() {
            @Override
            public int compare(Sentence o1, Sentence o2) {
                int sizeOne = o1.getWordList().size();
                int sizeTwo = o2.getWordList().size();
                return Integer.compare(sizeOne, sizeTwo);
            }
        });
        int fromIndex = 0;
        int toIndex;
        List<Sentence> sublist;

        for (Paragraph paragraph : workSample.getParagraphList()) {
            toIndex = fromIndex + paragraph.getSentenceList().size();

            sublist = allTogether.subList(fromIndex, toIndex);
            fromIndex = toIndex;

            paragraph.setSentenceList(sublist);
        }

        return 0;
    }


    @Override
    public int changeFirstWordOnLast(Text workSample) {
        LinkedList<Word> exchange;

        for (Paragraph paragraph : workSample.getParagraphList()) {
            for (Sentence sentence : paragraph.getSentenceList()) {
                exchange = new LinkedList<>(sentence.getWordList());
                swap(exchange);
                sentence.setWordList(exchange);
            }

        }
        return 0;
    }

    @Override
    public int changeRandomlyWordByTheLength(Text workSample) {
        for (Paragraph paragraph : workSample.getParagraphList()) {
            for (Sentence sentence : paragraph.getSentenceList()) {
                for (Word word : sentence.getWordList()) {
                    String toReplace = " *** IN-HONOR-Of-STRING *** ";
                    int wordLength = (int) (Math.random() * 10);

                    if (word.getLexeme().length() == wordLength) {
                        word.setLexeme(toReplace);
                        return 0;
                    }
                }
            }
        }

        return 1;
    }

}