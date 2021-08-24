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
        first = exchange.removeFirst();
        last = exchange.removeLast();

        exchange.addFirst(last);
        exchange.addLast(first);

    }

    @Override
    public void doSentenceInWordIncreasing(Text workSample) {
        List<Sentence> allTogether = new ArrayList<>();

        for (Paragraph paragraph : workSample.getParagraphList()) {
            for (Sentence sentence : paragraph.getSentenceList()) {
                allTogether.add(sentence);
            }
        }

        Collections.sort(allTogether);
        int fromIndex = 0;
        int toIndex;
        List<Sentence> sublist;

        for (Paragraph paragraph : workSample.getParagraphList()) {
            toIndex = fromIndex + paragraph.getSentenceList().size();

            sublist = allTogether.subList(fromIndex, toIndex);
            fromIndex = toIndex;

            paragraph.setSentenceList(sublist);
        }


    }


    @Override
    public void changeFirstWordOnLast(Text workSample) {
        LinkedList<Word> exchange;

        for (Paragraph paragraph : workSample.getParagraphList()) {
            for (Sentence sentence : paragraph.getSentenceList()) {
                exchange = new LinkedList<>(sentence.getWordList());
                swap(exchange);
                sentence.setWordList(exchange);
            }

        }

    }

    @Override
    public void changeRapidlyWordByTheLength(Text workSample) {
    }

}