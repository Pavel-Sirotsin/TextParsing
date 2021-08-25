package com.epam.text.view.impl;

import com.epam.text.entity.Text;
import com.epam.text.view.TextViewer;

import java.util.Objects;

public class TextViewerImpl implements TextViewer {
    @Override
    public void makeReadableAnswer(Text text, int result) {
        if (Objects.nonNull(text) && result == 0) {
            System.out.print(text.print());
        } else {
            System.out.println("No matches!");
        }
    }
}
