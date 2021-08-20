package com.epam.text.dao;


import com.epam.text.dao.impl.TextLauncherImpl;

public class DAOProvider {
    private static final DAOProvider instance = new DAOProvider();

    private DAOTextLauncher textLauncher = new TextLauncherImpl();

    private DAOProvider() {
    }

    public static DAOProvider getInstance() {
        return instance;
    }

    public DAOTextLauncher getTextLauncher() {
        return textLauncher;
    }
}
