package com.epam.text.service.splitter;

import com.epam.text.entity.Paragraph;
import com.epam.text.entity.Text;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SplitByParagraph extends Splitter {
    private static final Logger logger = LogManager.getLogger(SplitByParagraph.class);

    public SplitByParagraph(Splitter next) {
        super(next);
    }

    @Override
    public void split(SplitType type, Text text) {
        if (SplitType.PARAGRAPH.equals(type)) {
            String[] paragraphArray = text.getContent().split(REGEX_PARAGRAPH);

            for (String content : paragraphArray) {
                content = content.replaceAll("(\\r\\n)+","\n");
                text.add(new Paragraph(content));
            }
            logger.info("content was split by paragraph and add to list - .size(): "
                    + text.getParagraphList().size());
        }

        if (nextSplitter != null) {
            logger.info("the text was send to another splitter.");
            nextSplitter.split(SplitType.SENTENCE, text);
        }
    }
}

