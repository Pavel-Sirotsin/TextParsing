package com.epam.text.view.impl;

import com.epam.text.controller.Controller;
import com.epam.text.controller.ControllerProvider;
import com.epam.text.view.MainViewer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class MainViewerImpl implements MainViewer {
    private static final Logger logger = LogManager.getLogger(MainViewerImpl.class);
    private final Scanner input = new Scanner(System.in);

    @Override
    public String showMenu() {
        return "Выберите действие:\n" +
                "1) Вывести все предложения текста в порядке возрастания количества слов в каждом из них.\n" +
                "2) В каждом предложении текста поменять местами первое слово с последним не изменяя длинны предложения.\n" +
                "3) В некотором предложении текста слова заданной длинны заменить указанной подстрокой,\n" +
                "длинна которой может не совподать с длинной слова: " +
                "заданная длинна (случайно), подстрака: \" *** IN-HONOR-Of-STRING *** \".\n" +
                "***************************************";
    }

    @Override
    public int chooseOperation() {
        ControllerProvider provider = ControllerProvider.getInstance();
        Controller controller = provider.getController();

        while (!input.hasNext("[1-3]")) {
            logger.info("wrong input");
            System.err.println("Invalid value! Type 1 or 3!");
            input.next();
        }

        String request = input.next();

        return controller.doAction(request);
    }

    @Override
    public void reassembleQuestion() {
        ControllerProvider provider = ControllerProvider.getInstance();
        Controller controller = provider.getController();

        System.out.println("Востановить текст:\nY/N?");

        while (!input.hasNext("[yYnN]")) {
            logger.info("wrong input");
            System.err.println("Invalid value! Type Y or N!");
            input.next();
        }
        String request = input.next();

        if(request.equalsIgnoreCase("y")){
            controller.doAction("4");
        }

    }


}
