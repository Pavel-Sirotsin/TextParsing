package com.epam.text.service.utility;

import com.epam.text.entity.Paragraph;
import com.epam.text.entity.Sentence;
import com.epam.text.entity.Text;
import com.epam.text.entity.Word;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TextUtility {
    public static void placeInTextOrder(Text workSample, List<Sentence> allInOne) {
        int fromIndex = 0;
        int toIndex;
        List<Sentence> sublist;

        for (Paragraph paragraph : workSample.getParagraphList()) {
            toIndex = fromIndex + paragraph.getSentenceList().size();

            sublist = allInOne.subList(fromIndex, toIndex);
            fromIndex = toIndex;

            paragraph.setSentenceList(sublist);
        }
    }

    public static List<Sentence> getAllInOne(Text workSample) {
        List<Sentence> allInOne = new ArrayList<>();

        for (Paragraph paragraph : workSample.getParagraphList()) {
            paragraph.getSentenceList().forEach(sentence -> allInOne.add(sentence));
        }
        return allInOne;
    }

    public static void swap(LinkedList<Word> exchange) {
        Word first, last;
        if ((first = exchange.pollFirst()) != null
                && (last = exchange.pollLast()) != null) {

            exchange.addFirst(last);
            exchange.addLast(first);
        }

    }
}
