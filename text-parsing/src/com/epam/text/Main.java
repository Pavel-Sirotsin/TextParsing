package com.epam.text;

import com.epam.text.entity.Paragraph;
import com.epam.text.entity.Sentence;
import com.epam.text.entity.Text;
import com.epam.text.service.ServiceException;
import com.epam.text.service.impl.TextLauncherImpl;

import java.util.Collections;

/**
 * 2.Работа с текстом (In honor of String).
 * Создать консольное приложенеие, разбирающие текст по програмированию из файла
 * и позволяющие выполнять с текстом три различных операции:
 * - Вывести все предложения текста в порядке возрастания количества слов в каждом из них.
 * - В каждом предложении текста поменять местами первое слово с последним не изменяя длинны предложения.
 * - В некотором предложении текста слова заданной длинны заменить указанной подстрокой,
 * длинна которой может не совподать с длинной слова.
 * - log4J2
 * - Patterns: Composite, Chain Of Responsibility
 * <p>
 * 20 Aug 2021  * @author
 * Pavel Sirotsin
 */

public class Main {
    public static void main(String[] args) throws ServiceException {
        TextLauncherImpl l = new TextLauncherImpl();
        Text text = l.splitTextIntoPart();

        for (Paragraph p: text.getParagraphList()) {
            for (Sentence s: p.getSentenceList()) {
                Collections.sort(s.getWordList());
//                for (Word w : s.getWordList() ) {
//
//                }
            }
        }
        text.print();



    }


}


