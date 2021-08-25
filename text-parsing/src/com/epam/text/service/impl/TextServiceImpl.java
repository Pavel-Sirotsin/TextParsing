package com.epam.text.service.impl;

import com.epam.text.entity.Paragraph;
import com.epam.text.entity.Sentence;
import com.epam.text.entity.Text;
import com.epam.text.entity.Word;
import com.epam.text.service.TextService;
import com.epam.text.service.helper.TextHelper;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class TextServiceImpl implements TextService {
    @Override
    public int doSentenceInWordIncreasing(Text workSample) {
        List<Sentence> allInOne = TextHelper.getAllInOne(workSample);

        Collections.sort(allInOne, (o1, o2) -> {
            int sizeOne = o1.getWordList().size();
            int sizeTwo = o2.getWordList().size();
            return Integer.compare(sizeOne, sizeTwo);
        });

        TextHelper.putInOrderAfterSort(workSample, allInOne);

        return 0;
    }


    @Override
    public int changeFirstWordOnLast(Text workSample) {
        LinkedList<Word> exchange;

        for (Paragraph paragraph : workSample.getParagraphList()) {
            for (Sentence sentence : paragraph.getSentenceList()) {
                exchange = new LinkedList<>(sentence.getWordList());
                TextHelper.swap(exchange);
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