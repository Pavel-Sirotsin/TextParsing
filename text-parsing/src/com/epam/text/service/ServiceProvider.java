package com.epam.text.service;

public class ServiceProvider {
    private static final ServiceProvider instance = new ServiceProvider();


    private ServiceProvider() {
    }

    public static ServiceProvider getInstance() {
        return instance;
    }




}
