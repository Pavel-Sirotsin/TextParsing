package com.epam.text.service.impl;

import com.epam.text.dao.DAOException;
import com.epam.text.dao.DAOProvider;
import com.epam.text.dao.DAOTextAble;
import com.epam.text.service.ServiceException;
import com.epam.text.service.TextLauncher;
import com.epam.text.service.splitter.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TextLauncherImpl implements TextLauncher {
    private static final Logger logger = LogManager.getLogger(TextLauncherImpl.class);

    @Override
    public void reassembleText() {
        logger.info("The text will be reassembled by chain of splitters");

        ORIGIN.getParagraphList().clear();
        splitTextIntoPart();
    }
    @Override
    public void splitTextIntoPart() {
        Splitter splitByWord = new SplitByWord(null);
        Splitter splitBySentence = new SplitBYSentence(splitByWord);
        Splitter splitByParagraph = new SplitByParagraph(splitBySentence);
        splitByParagraph.split(SplitType.PARAGRAPH, ORIGIN);
    }

    @Override
    public void setContent() throws ServiceException {
        DAOProvider provider = DAOProvider.getInstance();
        DAOTextAble impl = provider.getImpl();

        String content;

        try {
            content = impl.getTextFromSource();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }

        logger.info("the content was uploaded to the entity .length(): " + ORIGIN.getContent().length());

        ORIGIN.setContent(content);
    }


}
