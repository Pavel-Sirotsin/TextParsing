package com.epam.text.service;

import com.epam.text.entity.Text;

public interface TextServiceAble {
    Text doSentenceInWordIncreasing(Text text) throws ServiceException;

    Text changeFirstWordOnLast(Text text) throws ServiceException;

    Text changeRapidlyWordByTheLength(Text text) throws ServiceException;
}
