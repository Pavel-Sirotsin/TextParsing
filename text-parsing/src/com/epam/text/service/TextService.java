package com.epam.text.service;

import com.epam.text.entity.Text;

public interface TextService {
    int doSentenceInWordIncreasing(Text workSample);

    int changeFirstWordOnLast(Text workSample);

    int changeRandomlyWordByTheLength(Text workSample);
}
