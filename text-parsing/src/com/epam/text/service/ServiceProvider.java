package com.epam.text.service;

import com.epam.text.service.impl.TextLauncherImpl;

public class ServiceProvider {
    private static final ServiceProvider instance = new ServiceProvider();

    private TextLauncherImpl launcher = new TextLauncherImpl();


    private ServiceProvider() {
    }

    public static ServiceProvider getInstance() {
        return instance;
    }

    public TextLauncherImpl getLauncher() {
        return launcher;
    }
}
