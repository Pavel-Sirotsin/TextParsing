package com.epam.text.service.impl;

import com.epam.text.entity.Paragraph;
import com.epam.text.entity.Sentence;
import com.epam.text.entity.Text;
import com.epam.text.service.TextService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TextServiceImpl implements TextService {

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
    }

    @Override
    public void changeRapidlyWordByTheLength(Text workSample) {
    }

}