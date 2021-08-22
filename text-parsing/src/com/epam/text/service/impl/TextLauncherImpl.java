package com.epam.text.service.impl;

import com.epam.text.service.ServiceException;
import com.epam.text.dao.DAOException;
import com.epam.text.dao.DAOProvider;
import com.epam.text.dao.DAOTextAble;
import com.epam.text.entity.Text;
import com.epam.text.service.TextLauncherAble;
import com.epam.text.service.splitter.*;

public class TextLauncherImpl implements TextLauncherAble {
    private final DAOProvider provider = DAOProvider.getInstance();

    private Splitter activateSplitChain() {
        Splitter splitByWord = new SplitByWord(null);
        Splitter splitBySentence = new SplitBYSentence(splitByWord);
        return new SplitByParagraph(splitBySentence);
    }


    @Override
    public Text splitTextIntoPart() throws ServiceException {
        DAOTextAble impl = provider.getImpl();
        Text text = null;

        try {
            text = impl.getTextFromSource();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }

        activateSplitChain().split(SplitType.PARAGRAPH, text);
        return text;
    }


}
