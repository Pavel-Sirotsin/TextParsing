package com.epam.text.view;

import com.epam.text.view.impl.MainViewerImpl;
import com.epam.text.view.impl.TextViewerImpl;

public class ViewerProvider {
    private static final ViewerProvider instance = new ViewerProvider();

    private MainViewer mainViewer = new MainViewerImpl();
    private TextViewer textViewer = new TextViewerImpl();

    private ViewerProvider() {
    }

    public static ViewerProvider getInstance() {
        return instance;
    }

    public MainViewer getMainViewer() {
        return mainViewer;
    }

    public TextViewer getTextViewer() {
        return textViewer;
    }
}

