package com.epam.text.service.splitter;

import com.epam.text.entity.Paragraph;
import com.epam.text.entity.Sentence;
import com.epam.text.entity.Text;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SplitBYSentence extends Splitter{
    private static final Logger logger = LogManager.getLogger(SplitBYSentence.class);

    public SplitBYSentence(Splitter next) {
        super(next);
    }

    @Override
    public void split(SplitType type, Text text) {
        if (SplitType.SENTENCE.equals(type)) {
            String[] sentenceArray = null;

            for (Paragraph paragraph :text.getParagraphList() ) {
                sentenceArray = paragraph.getContent().split(REGEX_SENTENCE);

                for (String content : sentenceArray) {
                    content = content.replaceAll("\\n","");
                    paragraph.add(new Sentence(content));
                }
            }

            logger.info("content was split by sentence and add to list");
        }

        if (nextSplitter != null) {
            logger.info("text was send to another splitter.");
            nextSplitter.split(SplitType.WORD, text);
        }
    }
}
