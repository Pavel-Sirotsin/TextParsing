package com.epam.text.service;

import com.epam.text.service.impl.TextLauncherImpl;
import com.epam.text.service.impl.TextServiceImpl;

public class ServiceProvider {
    private static final ServiceProvider instance = new ServiceProvider();

    private TextLauncherImpl launcherImpl = new TextLauncherImpl();
    private TextServiceImpl serviceImpl = new TextServiceImpl();


    private ServiceProvider() {
    }

    public static ServiceProvider getInstance() {
        return instance;
    }

    public TextLauncherImpl getLauncherImpl() {
        return launcherImpl;
    }

    public TextServiceImpl getServiceImpl() {
        return serviceImpl;
    }
}
