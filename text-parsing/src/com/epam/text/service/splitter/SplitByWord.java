package com.epam.text.service.splitter;

import com.epam.text.entity.Paragraph;
import com.epam.text.entity.Sentence;
import com.epam.text.entity.Text;
import com.epam.text.entity.Word;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class SplitByWord extends Splitter {
    private static final Logger logger = LogManager.getLogger(SplitByWord.class);

    public SplitByWord(Splitter next) {
        super(next);
    }

    @Override
    public void split(SplitType type, Text text) {
        if (SplitType.WORD.equals(type)) {
            List<String> wordList;

        for (Paragraph paragraph : text.getParagraphList()) {
            for (Sentence sentence : paragraph.getSentenceList()) {
                String subject = sentence.getContent();

                wordList = List.of(wordPattern.split(subject));
                wordList.forEach(content -> sentence.add(new Word(content)));

            }
        }
        logger.info("content was split by word and add to list.");
    }

}
}

