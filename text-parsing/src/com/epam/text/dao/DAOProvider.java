package com.epam.text.dao;


import com.epam.text.dao.impl.DAOTextImpl;

public class DAOProvider {
    private static final DAOProvider instance = new DAOProvider();

    private DAOTextAble textFromFile = new DAOTextImpl();

    private DAOProvider() {
    }

    public static DAOProvider getInstance() {
        return instance;
    }

    public DAOTextAble getImpl() {
        return textFromFile;
    }
}
