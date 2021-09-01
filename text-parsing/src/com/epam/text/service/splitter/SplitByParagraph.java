package com.epam.text.service.splitter;

import com.epam.text.entity.Paragraph;
import com.epam.text.entity.Text;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Objects;

public class SplitByParagraph extends Splitter {
    private static final Logger logger = LogManager.getLogger(SplitByParagraph.class);

    public SplitByParagraph(Splitter next) {
        super(next);
    }

    @Override
    public void split(SplitType type, Text text) {
        if (SplitType.PARAGRAPH.equals(type)) {
            String subject = text.getContent();

            List<String> paragraphArray = List.of(paragraphPattern.split(subject));
            paragraphArray.forEach(content -> text.add(new Paragraph(content)));

            logger.info("content was split by paragraph and add to list - .size(): "
                    + text.getParagraphList().size());
        }

        if (Objects.nonNull(nextSplitter)) {
            logger.info("the text was send to another splitter.");
            nextSplitter.split(SplitType.SENTENCE, text);
        }
    }
}

