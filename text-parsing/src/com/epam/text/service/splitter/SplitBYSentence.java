package com.epam.text.service.splitter;

import com.epam.text.entity.Paragraph;
import com.epam.text.entity.Sentence;
import com.epam.text.entity.Text;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Objects;

public class SplitBYSentence extends Splitter {
    private static final Logger logger = LogManager.getLogger(SplitBYSentence.class);

    public SplitBYSentence(Splitter next) {
        super(next);
    }

    @Override
    public void split(SplitType type, Text text) {
        if (SplitType.SENTENCE.equals(type)) {
            List<String> sentenceList;

            for (Paragraph paragraph : text.getParagraphList()) {
                String subject = paragraph.getContent();

                sentenceList = List.of(sentencePattern.split(subject));
                sentenceList.forEach(content -> paragraph.add(new Sentence(content)));

            }

            logger.info("content was split by sentence and add to list");
        }

        if (Objects.nonNull(nextSplitter)) {
            logger.info("text was send to another splitter.");
            nextSplitter.split(SplitType.WORD, text);
        }
    }
}
