package com.epam.text.view.impl;

import com.epam.text.entity.Text;
import com.epam.text.view.TextViewer;

import java.util.Objects;

public class TextViewerImpl implements TextViewer {
    @Override
    public void makeReadableAnswer(Text text) {
        if (Objects.nonNull(text)) {
            text.print();
        } else {
            System.err.println("The Text object is not exist!");
        }
    }
}
