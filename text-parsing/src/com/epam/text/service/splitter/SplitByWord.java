package com.epam.text.service.splitter;

import com.epam.text.entity.Paragraph;
import com.epam.text.entity.Sentence;
import com.epam.text.entity.Text;
import com.epam.text.entity.Word;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SplitByWord extends Splitter {
    private static final Logger logger = LogManager.getLogger(SplitByWord.class);

    public SplitByWord(Splitter next) {
        super(next);
    }

    @Override
    public void split(SplitType type, Text text) {
        if (SplitType.WORD.equals(type)) {
            String[] wordArray = null;

            for (Paragraph paragraph : text.getParagraphList()) {
                for (Sentence sentence : paragraph.getSentenceList()) {
                    wordArray = sentence.getContent().split(REGEX_WORD);

                    for (String content : wordArray) {
                        content = content.replaceAll("\\s","");
                        sentence.add(new Word(content));
                    }
                }
            }
            logger.info("content was split by word and add to list.");
        }

        if (nextSplitter != null) {
            logger.info("Text was send to another splitter: " + nextSplitter.getClass().getSimpleName());
            nextSplitter.split(type, text);
        }
    }
}

