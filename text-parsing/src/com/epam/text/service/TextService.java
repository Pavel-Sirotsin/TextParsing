package com.epam.text.service;

import com.epam.text.entity.Text;

public interface TextService {
    void doSentenceInWordIncreasing(Text workSample);

    void changeFirstWordOnLast(Text workSample);

    void changeRapidlyWordByTheLength(Text workSample);
}
