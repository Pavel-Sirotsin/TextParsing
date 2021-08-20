package com.epam.text.dao;


import com.epam.text.dao.impl.TextFromFileImpl;

public class DAOProvider {
    private static final DAOProvider instance = new DAOProvider();

    private TextFromFileAble textFromFile = new TextFromFileImpl();

    private DAOProvider() {
    }

    public static DAOProvider getInstance() {
        return instance;
    }

    public TextFromFileAble getTextFromFile() {
        return textFromFile;
    }
}
